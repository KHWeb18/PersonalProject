<template>
  <v-container>
    <board-title />
    <v-data-table
      :search="search"
      :headers="headers"
      :items="boards"
      :items-per-page="5"
      class="elevation-1 "
      height="400"
      :sort-by="['boardNo']"
      :sort-desc="[true]"
    >
      <!-- 시간 바꿔주기 -->
      <template v-slot:[`item.regDate`]="{ item }">
        <display-time :time="item.regDate" />
      </template>

      <!-- 내용클릭시 내용읽기 -->
      <template v-slot:[`item.title`]="{ item }">
        <a
          class="black--text"
          @click="openDialog(item)"
        >{{ item.title }} </a>
      </template>

      <template v-slot:top>
        <search-bar v-model="search" />
      </template>
    </v-data-table>

    <!-- 내용읽기 -->
    <v-dialog
      v-if="selectedItem"
      v-model="dialog"
      max-width="800"
      persistent
    >
      <board-content
        :item="selectedItem"
        @change="change"
      />
    </v-dialog>
  </v-container>
</template>

<script>
import { mapState, mapActions } from 'vuex'

import BoardTitle from './BoardTitle.vue'

import SearchBar from './SearchBar.vue'

import DisplayTime from './display-time.vue'

import BoardContent from './BoardContent.vue'

export default {


  name: 'BoardIndex',
  components: {
    BoardTitle,
    SearchBar,
    DisplayTime,
    BoardContent
  },
  data : () => ({
    inheritAttrs: false,
    search: '',
    dialog: false,
    selectedItem: null
  }),
  computed: {
    ...mapState('board', {
      headers: 'headers',
      boards: 'boards'
    }),
  },
  created () {
    this.fetchBoard()
  },
  methods: {
    ...mapActions('board', {
      fetchBoard: 'fetchBoard'
    }),
    openDialog (item) {
      this.selectedItem = item
      this.dialog = true
    },
    change() {
      this.dialog = false
    }
  },

}
</script>

<style scoped>

</style>>

