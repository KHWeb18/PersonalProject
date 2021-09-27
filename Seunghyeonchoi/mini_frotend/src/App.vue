<template>
  <v-app>
    <nav-bar-component style="z-index: 1;"/>  
    <footer style="z-index: 1;"/>  
    <v-main>
      <router-view/>
    <footer-component/>
    </v-main>
  </v-app>
</template>


<script>
import NavBarComponent from './views/NavBarComponent.vue'
import FooterComponent from './views/FooterComponent.vue'

export default {  
  name: 'App',
  components: { 
    NavBarComponent,
    FooterComponent 
  }
}

</script>

<style>
/*
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
#nav {
  padding: 30px;
}
#nav a {
  font-weight: bold;
  color: #2c3e50;
}
#nav a.router-link-exact-active {
  color: #42b983;
}
*/
</style>