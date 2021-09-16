<template>
  <div>
    <v-card>
      <v-card-title>
        <h4>Recommendations</h4>
        <v-spacer></v-spacer>
        <v-text-field
            v-model="search"
            append-icon="mdi-magnify"
            label="Search"
            single-line
            hide-details
            class="shrink"
        ></v-text-field>
      </v-card-title>
      <v-data-table @click:row="showBoard"
                    :headers="headers"
                    :items="boards"
                    :search="search"
                    :page.sync="page"
                    :items-per-page="itemsPerPage"
                    class="table"
                    hide-default-footer
                    @page-count="pageCount = $event"
      ></v-data-table>
      <div class="text-center pt-2">
        <v-pagination class="blue-grey lighten-4"
            v-model="page"
            :length="pageCount"
            ></v-pagination>
      </div>
    </v-card>
  </div>
</template>

<script>
export default {
  name: "BoardList",
  props: {
    boards: {
      type: Array
    }
  },
  data () {
    return {
      search: '',
      page: 1,
      pageCount: 0,
      itemsPerPage: 9,
      /*
      options:{
        page: number,
        itemsPerPage: number,
        sortBy: string[],
        sortDesc: boolean[],
        groupBy: string[],
        groupDesc: boolean[],
        multiSort: boolean,
        mustSort: boolean
      },

       */
      headers: [
        {text: '번호', align: 'start', value: 'boardNo'},
        {text: '제목', align: 'center', value: 'title', width: "60%"},
        {text: '', value: ''},
        {text: '작성자', value: 'writer'},
        {text: '등록일자',align: 'center', value: 'regDate'},
      ],
    }
  },
  methods: {
    showBoard(event, idx) {
      console.log("글 번호: " + idx.item.boardNo)
      this.$router.push({name: 'BoardReadPage', params: {boardNo: String(idx.item.boardNo)}})
    },
  }
}
</script>

<style scoped>
.table{
  cursor: pointer;
}
</style>
