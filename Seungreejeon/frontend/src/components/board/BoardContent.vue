<template>
  <v-form @submit.prevent="submit">
    <div v-show="propshow">
      {{ changeProps }}
    </div>
    <v-card>
      <v-text-field
        :value="boardNo"
        filled
        readonly
      />
      <v-text-field
        v-model="title"
        :disabled="modify"
      />

      <v-text-field
        v-model="content"
        :disabled="modify"
      />

      <v-divider />

      <v-card-actions>
        <v-spacer />
        <v-btn
          color="orange"
          text
          @click="change"
        >
          close
        </v-btn>
        <div v-if="role">
          <v-btn
            text
            @click="modify = !modify"
          >
            modify
          </v-btn>
          <v-btn
            text
            color="error"
            @click="deleteBoard"
          >
            Delete
          </v-btn>
          <v-btn
            v-if="!modify"
            text
            color="success"
            type="submit"
          >
            Save
          </v-btn>
        </div>
      </v-card-actions>
    </v-card>
  </v-form>
</template>

<script>
export default {
  props: {
    item:{
      type: Object,
      require: true,
    }
  },

  data: () => ({
    boardNo: null,
    content: null,
    title: null,
    modify: true,
    propshow: false,

  }),
  computed: {

  },
  computed: {
    changeProps() {
      return this.content = this.item.content,
      this.title = this.item.title,
      this.boardNo = this.item.boardNo
    },
    role() {
      return this.$store.getters['authentication/getRole']
    }
  },

  methods: {
    change() {
      this.$emit('change')
      this.content = this.item.content,
      this.title = this.item.title,
      this.boardNo = this.item.boardNo
    },
    submit() {
      this.modify = !this.modify
      this.$store.dispatch('board/modifyBoard', {
        content:this.content, title:this.title, boardNo: this.boardNo
      }),
      this.change()
    },
    deleteBoard() {
      this.$store.dispatch('board/deleteBoard',this.boardNo)
      this.change()
    }
  }
}
</script>

<style>

</style>
