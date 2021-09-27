<template>
  <v-app-bar
    app
    color="primary"
    dark
    flat
  >
    <v-app-bar-nav-icon
      app
      @click="drawer = !drawer"
    />
    <v-toolbar-title
      class="text-uppercase black--text"
    >
      <span
        class="font-weight-light"
      >Work
      </span>
      <span class="font-weight-bold">
        Space
      </span>
    </v-toolbar-title>
    <v-spacer />
    <date-picker app />

    <identity app />
  </v-app-bar>
</template>

<script>

export default {
  name: "AppBar",
  components: {
    Identity:() => import('./Identity/Identity.vue'),
    DatePicker:() => import('./datepicker/Datepicker.vue'),
  },
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
