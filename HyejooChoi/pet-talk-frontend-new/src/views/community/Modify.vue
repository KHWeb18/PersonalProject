<template>
	<div>
		<h1>커뮤니티</h1>
		<div class="form_wrap">
			<h2>글쓰기</h2>
				<b-input v-model="detail.title" placeholder="제목을 입력해주세요."></b-input>
				<b-form-textarea
								v-model="detail.content"
								placeholder="내용을 입력해 주세요"
								rows="13"
								max-rows="6"

				></b-form-textarea>

		</div>

		<br>
		<b-button @click="onClickSaveBtn">저장</b-button>&nbsp;
		<b-button @click="onClickCancleBtn">취소</b-button>
	</div>
</template>
<script>
  import api from "../../api/api";
  export default {
    name: 'BoardModify',
    async mounted() {
      if (this.id) {
        await api.get(`/board/${this.id}`)
          .then((res) => {
            this.detail.title = res.data.data.board.title;
            this.detail.content = res.data.data.board.content;
            this.detail.writer = res.data.data.board.writer;
            this.detail.createdAt = res.data.data.board.createdAt;
            console.log(res.data.data.board);
          })
          .catch((err) => {
            console.log(err);
            alert("게시글 조회 오류");
          })
      }
    },
    data() {
      return {
        userId: this.$store.state.userInfo.id,
        id: this.$route.params.id,
        detail: {
          title: '',
          content: '',
          writer: '',
          createdAt: '',
        },
      }
    },
    created() {

    },
    methods: {
      onClickSaveBtn() {
        if (this.id === undefined) {
          // 글작성
          api.post(`/board/create`, {
            title: this.detail.title,
            content: this.detail.content,
            writer: this.userId,
          })
            .then((res) => {
              if (res.data.resultCode === "SUCCESS") {
                this.$router.push({name: "BoardList", params: {id: res.data.data.id }});
                alert("등록 성공");
              } else {
                alert("등록 실패");
              }
            }).catch((err) => {
            console.log(err);
            alert("등록 실패");
          });
        } else {
          // 글수정
          api.post(`/board/update/${this.id}`, {
            title: this.detail.title,
            content: this.detail.content,
            writer: this.userId,
          })
            .then((res) => {
              if (res.data.resultCode === "SUCCESS") {
                this.$router.push({name: "BoardDetail", params: {id: this.id}});
                alert("수정 성공");
              } else {
                alert("수정 실패");
              }
            }).catch((err) => {
            console.log(err);
            alert("수정 실패");
          })
        }
      },
      onClickCancleBtn() {
        this.$router.push({name: "BoardList"});
      }
    }
  }
</script>

<style scoped>
	.page {
		width: 1200px;
		margin-top: 100px;

		font-family: 'Gowun Dodum', sans-serif;
	}

	h1 {
		font-size: 33px;
		font-weight: bold;
		width: 100%;
		color: rgb(229, 119, 175);
	}

	.form_wrap {
		border: 1px solid rgba(0, 0, 0, 0.125);
		border-radius: 5px;
		padding: 30px 50px;
		background-color: #faf5f2;
		margin-top: 45px;
	}

	h2 {
		font-size: 25px;
	}

	input {
		width: 40%;
		margin-top: 30px;
	}

	textarea {
		margin-top: 10px;
	}




	.btn_wrap {
		width: 100%;
	}

	.btn {
		width: 90px;
		height: 35px;
		color: #fff;
		background-color: rgb(236, 152, 195);
		border: none;
		border-radius: 5px;
		font-size: 18px;
		line-height: 18px;
		float: right;
		font-family: 'Gowun Dodum', sans-serif;
	}

	.btn:nth-of-type(2) {
		background-color: #fff;
		color: #000;
		font-weight: bold;
	}
</style>
