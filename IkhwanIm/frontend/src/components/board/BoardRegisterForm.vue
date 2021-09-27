<template>
  <form @submit.prevent="onSubmit">
    <input type="text" placeholder="Title here" class="mt-n1" v-model="title">
    <input type="text" class="mt-5"  disabled v-model="writer">
    <v-text-field type="text" class="mt-5" :rules="linkRules" placeholder="YouTube Link" v-model="link"/>
    <v-textarea solo auto-grow class="mt-8"  rows="4" row-height="80" placeholder="Description"
              v-model="content"></v-textarea>

    <div>
      <v-btn type="submit">Register</v-btn>
    </div>
  </form>
</template>

<script>
import {mapState} from "vuex";

export default {
  name: 'BoardRegisterForm',
  data () {
    return {
      title: '',
      writer: '',
      link: '',
      content: '',
      linkRules: [
          v => !!v || 'Link is required',
          v => v.length >= 8 || 'Name must be more than 8 characters',
          v => v.includes("youtube") || 'Must be YouTube Link'
          ],
    }
  },
  computed: {
    ...mapState(["session"])
  },
  mounted() {
    this.writer = this.$store.state.session.member_id
  },
  methods: {
    onSubmit () {
      const { title, writer, content, link } = this
      this.$emit('submit', { title, writer, content, link })
    }
  }
}
</script>
