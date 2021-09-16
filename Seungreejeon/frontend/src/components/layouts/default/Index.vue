<template>
  <v-app>
    <snackbar />

    <loader />

    <app-bar />

    <nav-drawer />

    <default-view />
  </v-app>
</template>

<script>
import NavDrawer from './NavDrawer'
import AppBar from './AppBar'
import DefaultView from './View.vue'
import Snackbar from './snack/Snack.vue';
import Loader from './loader/Loader.vue'


export default {
  components: {
    AppBar,
    NavDrawer,
    DefaultView,
    Snackbar,
    Loader
  },
  data: () => ({
  }),

}
</script>

<style>

</style>
