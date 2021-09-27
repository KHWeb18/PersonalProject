<template>
  <v-overlay
    v-if="loading.overlay"
    :value="overlay()"
  >
    <v-progress-circular
      indeterminate
      size="70"
    />
  </v-overlay>
</template>

<script>

import { mapState } from 'vuex'

export default {
  name: 'Loader',
  data: () => ({
    // overlay: false,
    time: 1000
  }),
  computed: {
    ...mapState('loading', {
      loading: 'loading',
    }),

    // overlay () {
    //   console.log("실행여부")
    //   return this.endOverLay()
    // },

  },

  methods: {
    overlay () {
      console.log("실행여부")
      setTimeout(() => {
        this.$store.commit('loading/END_LOADING')
      }, 2000)
    },
  }

}
</script>

<style>

</style>
