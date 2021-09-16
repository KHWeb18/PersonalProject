<template>
  <v-navigation-drawer
    v-model="drawer"
    app
    v-bind="$attrs"
    v-on="$listeners"
  >
    <nav-header />

    <v-divider />

    <nav-list />
  </v-navigation-drawer>
</template>

<script>

export default {
  name: "NavDrawer",
  components: {
    NavList: () => import('./NavList.vue'),
    NavHeader: () => import('./NavHeader.vue')
  },
  inheritAttrs: false,
  computed: {
    drawer: {
      get () {
        return this.$store.getters['drawer/getDrawer']
      },
      set (value) {
        return this.$store.dispatch('drawer/toggleDrawer', value)
      }
    },
  }
}
</script>

<style>

</style>
