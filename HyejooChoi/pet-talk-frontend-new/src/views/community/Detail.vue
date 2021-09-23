<template>
	<div class="detail_wrap">
		<div class="detail_inner">
			<h1>커뮤니티</h1>
			<div class="detail_title">
				<h1>{{ this.board.title }}</h1>
				<div class="detail_subtitle">
					<span>{{ this.board.writerName }}</span>
					<strong>{{ this.board.createdAt }}</strong>
					<em>조회수 <b>{{ this.board.count }}</b></em>
				</div>
			</div>

			<div class="detail_body" v-html="content">
				<p>{{ this.board.content }}</p>
			</div>


			<div class="detail-button">
				<b-button @click="onClickModifyBtn" v-if="userId === board.writer" class="btn_modify">수정</b-button>
				<b-button @click="onClickDeleteBtn" v-if="userId === board.writer" class="btn_delete">삭제</b-button>
				<b-button @click="onClickListBtn" class="btn_list">목록</b-button>
			</div>

			<!--      <div class="content-detail-content-info">-->
			<!--        <div class="content-detail-content-info-left">-->
			<!--          <div class="content-detail-content-info-left-number">{{ id }}</div>-->
			<!--          <div class="content-detail-content-info-left-subject">{{ this.board.title }}</div>-->
			<!--        </div>-->
			<!--        <div class="content-detail-content-info-right">-->
			<!--          <div class="content-detail-content-info-right-user">글쓴이: {{ this.board.writerName }}</div>-->
			<!--          <div class="content-detail-content-info-right-created">등록일: {{ this.board.createdAt }}</div>-->
			<!--        </div>-->
			<!--      </div>-->
			<!--      <div class="content-detail-content">{{ this.board.content }}</div>-->

			<!--			<div class="content-detail-button">-->
			<!--				<b-button variant="primary" @click="onClickModifyBtn" v-if="userId === board.writer">수정</b-button>&nbsp;-->
			<!--				<b-button variant="warning" @click="onClickDeleteBtn" v-if="userId === board.writer">삭제</b-button>-->
			<!--				<b-button variant="secondary" @click="onClickListBtn">목록</b-button>-->
			<!--			</div>-->


			<div class="int-area">
				<input
								type="text"
								placeholder="댓글을 입력해주세요."
								autocomplete="off"
								required
								v-model="commentInput"
								@keyup="onKeyUpCommentBtn"
				>
				<button @click="onClickCommentBtn">등록</button>
			</div>

			<div v-for="(cl, index) in commentList" class="content-detail-comment" :key="index">
				<div>
					<!-- 닉네임 -->
					<span class="commentNick">{{ cl[1].nickname }}</span>

					<!-- 댓글 내용 -->
					<div v-if="cl[0].edit === true" style="display: inline-block">
						<input v-model="cl[0].editContent" style="border: 1px solid black" @keyup="onKeyupEditInput($event, cl[0].id, index)">
					</div>
					<div v-else>
						<p class="commentContent">{{ cl[0].content }}</p>
					</div>

					<!-- 댓글 작성일 -->
					<span class="commentTime">{{ cl[0].createdAt }}</span>

					<!-- 저장 및 수정 삭제 버튼 -->
					<div v-if="cl[0].edit === true" style="display: inline-block">
						<span @click="onClickCommentSave(cl[0].id, index)">저장</span>
						<span @click="onClickCancleBtn(cl[0].id, index)">취소</span>
					</div>
					<div v-else-if="!cl[0].edit && cl[1].id === userId">
						<span @click="onClickCommentModify(cl[0].id, index)">수정</span>
						<span @click="onClickCommentDelete(cl[0].id)">삭제</span>
					</div>

				</div>
			</div>
		</div>
	</div>
</template>

<script>
  import api from "../../api/api";
  import dayjs from "dayjs";

  export default {
    name: "BoardDetail",
    async mounted() {
      if (!this.userId) {
        alert("권한이 없습니다. 로그인 화면으로 이동합니다.");
        this.$router.push({name: "Login"});
      } else {
        await this.fetchBoardDetail();
      }
    },
    data() {
      return {
        userId: this.$store.state.userInfo.id,
        id: this.$route.params.id,
        commentList: [],
        board: {
          id: '',
          title: '',
          content: '',
          writer: '',
          createdAt: '',
          writerName: '',
          count: '',
        },
        commentInput: '',
      };
    },
    computed: {
      content() {
        return this.board.content.split('\n').join('<br>');
      }
    },
    methods: {
      async fetchBoardDetail() {
        await api.get(`/board/${this.id}`)
          .then((res) => {
            console.log(res);
            this.board.title = res.data.data.board.title;
            this.board.content = res.data.data.board.content;
            this.board.writer = res.data.data.board.writer;
            this.board.writerName = res.data.data.board.writerName;
            this.board.count = res.data.data.board.count;
            this.board.createdAt = dayjs(res.data.data.board.createdAt).format("YYYY-MM-DD HH:mm");
            this.commentList = res.data.data.comment ? res.data.data.comment : [];
            this.commentList.map((v) => {
              v[0].createdAt = dayjs(v[0].createdAt).format("YYYY-MM-DD HH:mm");
            });
          })
          .catch((err) => {
            console.log(err);
            alert("게시글 조회 오류");
          })
      },
      onClickModifyBtn() {
        this.$router.push({name: "BoardModify", params: {id: this.id}});
      },
      async onClickDeleteBtn() {
        if (confirm("삭제하시겠습니까?")) {
          await api.delete(`/board/delete/${this.id}`)
            .then((res) => {
              if (res.data.data === true) {
                alert('글 삭제 성공');
                this.$router.push({name: "BoardList"});
              } else {
                alert('글 삭제 실패');
              }
            })
            .catch((err) => {
              console.log(err);
              alert("알 수 없는 오류 발생");
            })
        }
      },
      onClickListBtn() {
        this.$router.push({name: "BoardList"});
      },

      async onClickCommentBtn() {
        if (this.validateComment()) {
          await this.postComment();
        }
      },

      async onKeyUpCommentBtn(e) {
        if (e.keyCode === 13) {
          if (this.validateComment()) {
            await this.postComment();
          }
        }
      },

      async postComment() {
        await api.post(`/comment/create/COMMUNITY/${this.id}`, {
          writer: this.userId,
          content: this.commentInput,
        })
          .then((res) => {
            if (res.data.resultCode === "SUCCESS") {
              // this.$router.push({name: "BoardDetail", params: {id: this.id}});
              alert('댓글 등록 성공');
              this.fetchBoardDetail();
              this.commentInput = '';
            } else {
              alert("댓글 등록 실패");
            }
          }).catch((err) => {
            console.log(err);
            alert("댓글 등록 실패");
          })
      },

      validateComment() {
        if (!this.commentInput || this.commentInput.length === 0) {
          alert('댓글을 입력해주세요.');
          return false;
        }
        return true;
      },

      onClickCommentModify(commentId, index) {
        this.commentList[index][0].edit = true;
        this.commentList[index][0].editContent = this.commentList[index][0].content;
        this.$forceUpdate();
      },

      onClickCancleBtn(commentId, index) {
        delete this.commentList[index][0].edit;
        delete this.commentList[index][0].editContent;
        this.$forceUpdate();
      },

      async onClickCommentSave(commentId, index) {
        try {
          if (this.validationEditComment(index)) {
            const {data} = await this.postSaveComment(commentId, this.commentList[index][0].editContent);
            if (data) {
              alert('수정 되었습니다.');
              delete this.commentList[index][0].edit;
              delete this.commentList[index][0].editContent;
              await this.fetchBoardDetail();
            }
          }
        } catch (e) {
          console.log(e);
          alert('수정 실패');
        }
      },

      async onClickCommentDelete(commentId) {
        try {
          const {data} = await this.deleteComment(commentId);
          if (data) {
            alert('삭제 되었습니다.');
            await this.fetchBoardDetail();
          }
        } catch (e) {
          console.log(e);
          alert('삭제 실패');
        }
      },

      deleteComment(commentId) {
        return api.delete(`/comment/delete/${commentId}`);
      },

      postSaveComment(commentId, editContent) {
        return api.post(`/comment/modify/${commentId}`, {
          content: editContent
        })
      },

      async onKeyupEditInput(e, commentId, index) {
        if (e.keyCode === 13) {
          await this.onClickCommentSave(commentId, index);
        }
      },

      validationEditComment(index) {
        const target = this.commentList[index][0].editContent;
        if (!target && target.length < 1) {
          alert('댓글 내용을 입력해주세요.');
          return false;
        }
        return true;
      },

    },

  }

</script>
<style scoped>
	.detail_wrap {

	}

	.page {
		width: 1200px;
		margin-top: 100px;

		font-family: 'Gowun Dodum', sans-serif;
	}

	.detail_inner {
		width: 1000px;
	}

	a, em, strong, b {
		font-style: normal;
		font-weight: normal;
		text-decoration: none;
	}

	/* 컨텐츠 제목 */
	.detail_title {
		/*text-align: justify;*/

		padding: 20px 0;
	}

	.detail_title h1 {
		color: rgb(99, 99, 99);
	}

	.detail_title .detail_subtitle {
		margin-top: 25px;
	}

	.detail_title .detail_subtitle span {
		font-weight: bold;
		margin-right: 25px;
		background: linear-gradient(to top, #a3f5a8 50%, transparent 50%);
	}

	.detail_title .detail_subtitle strong {
		font-size: 15px;
	}

	.detail_title .detail_subtitle em {
		float: right;
		font-size: 14px;
	}

	.detail_title .detail_subtitle em b {
		font-weight: bold;
		font-size: 15px;
	}


	/* 컨텐츠 */
	.detail_body {
		padding: 50px 10px;
		font-size: 18px;
		border-top: 1px solid rgba(0, 0, 0, .1);
		border-bottom: 1px solid rgba(0, 0, 0, .1);
		width: 100%;
		word-wrap:break-word;
		word-break:break-all;
	}




	/* 컨텐츠 버튼 */
	.detail-button {
		/*border: 1px solid red;*/
		padding: 15px 0;
	}

	.detail-button .btn {
		background-color: #fff;
		color: #000;
		border: 1px solid #bbb;
	}

	.detail-button .btn_modify {
		margin-right: 10px;
	}

	.detail-button .btn_delete {
		background-color: #f15c5c;
		color: #fff;
		border: 1px solid #f15c5c;
	}

	.detail-button .btn_list {
		float: right;
	}

	.detail-button:after {
		display: block;
		content: '';
		clear: both;
	}


	/*.content-detail-content-info {*/
	/*	border-bottom: 1px solid black;*/
	/*	display: flex;*/
	/*	justify-content: space-between;*/
	/*}*/

	/*.content-detail-content-info-left {*/
	/*	width: 720px;*/
	/*	display: flex;*/
	/*	flex-direction: row;*/
	/*	justify-content: space-between;*/
	/*	align-items: center;*/
	/*	padding: 1rem;*/
	/*}*/

	/*.content-detail-content-info-right {*/
	/*	width: 300px;*/
	/*	display: flex;*/
	/*	flex-direction: column;*/
	/*	justify-content: center;*/
	/*	align-items: center;*/
	/*	padding: 1rem;*/
	/*}*/

	/*.content-detail-content {*/
	/*	border: 1px solid black;*/
	/*	margin-top: 1rem;*/
	/*	padding-top: 1rem;*/
	/*	min-height: 720px;*/
	/*}*/

	/*.content-detail-button {*/
	/*	border: 1px solid black;*/
	/*	margin-top: 1rem;*/
	/*	padding: 2rem;*/
	/*}*/

	.content-detail-comment {
		border-top: 1px solid black;
		margin-top: 1rem;
		padding: 10px;
	}


	h1 {
		font-size: 33px;
		font-weight: bold;
		width: 100%;
		color: rgb(229, 119, 175);
	}

	.detail_inner > h1 {
		font-size: 22px;
	}

	.int-area {
		margin-top: 20px;
		width: 100%;
	}

	.int-area input {
		padding: 10px;
		float: left;
		width: 95%;
	}

	.int-area > button {
		padding: 10px;
		color: #fff;
		background-color: rgb(229, 139, 185);
	}


	.commentNick {
		font-weight: bold;
		margin-right: 20px;
		margin-bottom: 5px;
		display: block;
	}

	.commentContent {
		font-size: 18px;
		width: 80%;
		float: left;
	}

	.commentTime {

	}
</style>
