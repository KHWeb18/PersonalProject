<template>
  <v-app>
    <v-main>
      <Header />
      <router-view/>
      <Footer />
    </v-main>
  </v-app>  
</template>

<script>
import Header from './layouts/Header';
import Footer from './layouts/Footer';
export default {
  components: {Header, Footer}, 
  name: 'App',
  computed: {
    user() {
      return this.$store.state.user;
    },
  },
  /*
  mounted() {
    this.$store.state.user=this.$cookies.get("user")
      if(this.$store.state.user != null) {
        this.$store.state.isLogin = true
      }
  }
  */
}
</script>

<style>
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
</style>