<template>
  <div id="board">
    <v-container>
      <board-list :boards="boards" />
    </v-container>
    <v-btn>
      <router-link :to="{ name: 'BoardRegisterPage' }">
        게시물 작성
      </router-link>
    </v-btn>
  </div>
</template>

<script>
import BoardList from "@/components/board/BoardList.vue";
import { mapState, mapActions } from "vuex";
export default {
  name: "BoardListPage",
  components: {
    BoardList,
  },
  computed: {
    ...mapState(["boards"]),
  },
  mounted() {
    this.fetchBoardList();
  },
  methods: {
    ...mapActions(["fetchBoardList"]),
  },
};
</script>
