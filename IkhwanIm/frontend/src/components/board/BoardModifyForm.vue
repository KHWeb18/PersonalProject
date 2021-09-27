<template>
  <div v-if="board">
    <v-card class="mx-auto mt-11"
            max-width="800" min-height="500">

      <v-list-item two-line>
        <v-list-item-content>
          <h3 class="center mt-3">Edit Post</h3>
          <v-list-item-title class="text-h5 my-5 font-weight-regular text--disabled">
            new title<v-textarea auto-grow rows="3" class="text-h3" row-height="20"
                                 v-model="title"></v-textarea>
          </v-list-item-title>
          <v-list-item-subtitle align="right">글 번호 : {{board.boardNo}}<br>
            작성일 : {{ board.regDate }}</v-list-item-subtitle>
        </v-list-item-content>
      </v-list-item>
      <v-divider></v-divider>
      <v-card-text>
        <v-row align="center">
          <v-col class="mt-3" cols="12">
            <v-icon>insert_link</v-icon>new YouTube Link
            <v-textarea v-model="link" auto-grow solo row-height="10" value="" class="text-body-1"></v-textarea>
          </v-col>
        </v-row>
      </v-card-text>

      <v-list-item>
        <v-row>
          <v-col class="text-subtitle-1 text--disabled" cols="12">
            insert new content
            <v-textarea filled solo auto-grow rows="4" row-height="30"
                        v-model="content"></v-textarea>
          </v-col>
        </v-row>
      </v-list-item>

      <v-divider></v-divider>
      <!-- comments v-if logged on-->
      <v-card-actions>
        <v-btn text @click="cancel">CANCEL</v-btn>
        <v-spacer></v-spacer>
        <v-btn text @click="Done">DONE</v-btn>
      </v-card-actions>


    </v-card>
  </div>
</template>

<script>
export default {
  name: "BoardModifyForm",
  props: {
    board: {
      type: Object,
      required: true
    }
  },
  data () {
    return {
      link: this.board.link,
      title: this.board.title,
      content: this.board.content
    }
  },
  methods: {
    Done () {
      const { title, content, link } = this
      this.$emit('submit', { title, content, link })
    },
    cancel() {
      this.$router.push({ name: 'BoardReadPage' })
    }
  }
}
</script>

<style scoped>
.v-list-item{
  min-height: 200px;
}
</style>
