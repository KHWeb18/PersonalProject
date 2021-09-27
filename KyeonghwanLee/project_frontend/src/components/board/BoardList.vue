<template>
  <div>
    <h3>공지안내</h3>
    <!--<v-container>
      <v-data-table
        :headers="headerTitle"
        :items="contents"
        :items-per-page="10"
        clas="elevation-1"
      >
      </v-data-table>
    </v-container>-->

    <table border="1">
      <tr>
        <th align="center" width="100">번호</th>
        <th align="center" width="640">제목</th>
        <th align="center" width="150">작성자</th>
        <th align="center" width="240">등록일자</th>
      </tr>
      <tr v-if="!boards || (Array.isArray(boards) && boards.length === 0)">
        <td colspan="4">
          현재 등록된 게시물이 없습니다!
        </td>
      </tr>
      <tr v-else v-for="board in boards" :key="board.boardNo">
        <td align="center">{{ board.boardNo }}</td>
        <td align="left">
          <router-link
            :to="{
              name: 'BoardReadPage',
              params: { boardNo: board.boardNo.toString() },
            }"
          >
            {{ board.title }}
          </router-link>
        </td>
        <td align="right">{{ board.writer }}</td>
        <td align="center">{{ board.regDate }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: "BoardList",
  props: {
    boards: {
      type: Array,
    },
  },
  /*data() {
    return {
      page: 1,
    };

  },*/
  data() {
    return {
      headerTitle: [
        { text: "번호", value: "boardNo", width: "70px" },
        { text: "제목", value: "title", width: "150px" },
        { text: "작성자", value: "writer", width: "100px" },
      ],
      contents: [
        {
          boardNo: 1,
          title: "제철 과일 10% 할인",
          writer: "fruits",
          content: "제철 과일 10%할인 기간: 2021/08/15~2021/08/31 ",
        },
        {
          boardNo: 2,
          title: "추석 선물세트 예약",
          writer: "gift",
          content:
            "추석 선물세트 사전예약시 10%할인 기간:2021/08/01~2021/09/10",
        },
      ],
    };
  },
};
</script>

<style scoped>
h1 {
  margin: 10px;
}
p {
  padding: 10px;
  margin: 5px 10px;
}
</style>
