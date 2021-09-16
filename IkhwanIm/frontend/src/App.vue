<template>
  <v-app>
    <nav-bar-component></nav-bar-component>
    <v-main>
      <router-view/>
    </v-main>
    <HomeFooter></HomeFooter>
  </v-app>
</template>

<script>

import NavBarComponent from "./views/NavBarComponent";
import HomeFooter from "./components/HomeContents/HomeFooter";
export default {
  name: 'App',
  components: {HomeFooter, NavBarComponent},
  data: () => ({
    //
  }),
};
</script>

