<template>

  <div class="gallery_wrap">
    <h1>갤러리</h1>
    <v-container>
      <v-row>
        <v-col cols="4" sm="4" v-for="(b, index) in boardList" :key="index">
          <router-link :to="`/gallery/detail/${b[0].id}`">
            <v-card
                class="mx-auto"
                max-width="390"
            >
              <div v-if="b[0].imgPath">
                <v-img :src="b[0].imgPath" height="250"></v-img>
              </div>
              <div v-else>
                <v-img src="https://pettalk-backend.s3.ap-northeast-2.amazonaws.com/gallery/noimage.jpg" height="250"></v-img>
              </div>

              <v-card-title>
                {{ b[0].title }}
              </v-card-title>

              <v-card-subtitle>
                {{ b[0].content }}
              </v-card-subtitle>
              <v-list-item>
                <v-list-item-subtitle>
                  <strong>{{ b[1].nickname }}</strong><span>{{ b[1].createdAt }}</span> <em>조회 {{ b[0].count }}</em>
                </v-list-item-subtitle>
              </v-list-item>
            </v-card>
          </router-link>
        </v-col>
      </v-row>
    </v-container>
    <div class="btn_wrap">
      <b-button @click="onClickWriteBtn">글쓰기</b-button>
    </div>
    <b-pagination aria-controls="my-table" align="center" first-class="first" prev-class="prev" next-class="next"
                  last-class="last"
                  v-model="currentPage" :total-rows="totalItems" :per-page="perPage"
                  @change="handlerPagenation">
    </b-pagination>


  </div>

</template>

<script>
import api from "../../api/api";
import dayjs from "dayjs";

export default {
  name: 'GalleryList',
  async mounted() {
    await this.fetchBoardList();
  },
  data() {
    return {
      noImagePath: '../assets/img/noimage.jpg',
      currentPage: 1, // 현재 페이지
      perPage: 9, // 페이지당 보여줄 갯수
      totalPage: '',
      totalItems: '',
      // bootstrap 'b-table' 필드 설정
      fields: [
        {
          key: "id",
          label: "번호"
        },
        {
          key: "title",
          label: "제목"
        },
        {
          key: "writerName",
          label: "작성자"
        },
        {
          key: "createdAt",
          label: "등록일",

        },
        {
          key: "count",
          label: "조회",
        },
      ],
      boardList: [],
      // items: items
    };
  },
  methods: {
    async fetchBoardList() {
      return await api.get(`/gallery/list/${this.currentPage}/${this.perPage}`)
          .then((res) => {
            this.boardList = res.data.data.content;
            this.boardList.map((v) => {
              v.createdAt = dayjs(v.createdAt).format("YYYY-MM-DD HH:mm");
            })
            this.totalPage = res.data.data.totalPages;
            this.totalItems = res.data.data.totalElements;
            console.log(this.boardList);
          }).catch((err) => {
            console.log(err);
            alert("게시글 목록 조회 오류");
          });
    },
    rowClick(item) {
      this.$router.push({
        path: `/community/detail/${item.id}`
      });
    },
    onClickWriteBtn() {
      this.$router.push({name: 'GalleryCreate'});
    },
    handlerPagenation(v) {
      this.currentPage = v;
      this.fetchBoardList();
    }
  },
  computed: {
    rows() {
      return this.items.length;
    }
  },
}
</script>

<style scoped>
em {
  font-style: normal;
}

.gallery_wrap {
  width: 1200px;
  /*height: 100vh;*/
  display: flex;
  flex-direction: column;
  /*justify-content: space-evenly;*/
  align-items: center;
  margin-top: 100px;

  font-family: 'Gowun Dodum', sans-serif;
}


h1 {
  font-size: 33px;
  font-weight: bold;
  width: 100%;
  color: rgb(229, 119, 175);
}

.container {
	margin-top: 50px;
}

.v-card {
  margin-bottom: 20px;
}

.v-card__title {
	width: 100%;
	overflow: hidden;
	text-overflow:ellipsis;
	white-space: nowrap;
	display: block;
}

.btn_wrap {
  width: 100%;
}

.btn_wrap:after {
	content: "";
	display: block;
	clear: both;
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

.pagination {
  margin-top: 50px;
}

.pagination:after {
	content: "";
	display: block;
	clear: both;
}


</style>
