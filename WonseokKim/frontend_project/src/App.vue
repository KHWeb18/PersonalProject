<template>
  <v-app>
    <main-app-bar/>
    <v-main>
      <router-view/>
    </v-main>
     <main-footer/>
  </v-app>
</template>

<script>
import MainAppBar from '@/components/layout/AppBar';
import MainFooter from '@/components/layout/Footer';


export default {
  name: 'App',
  components: {
    MainAppBar,
    MainFooter
  }
}
</script>
