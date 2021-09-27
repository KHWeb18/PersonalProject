<template>
  <div id="app">

    <div class="헤더">
      <Header />
    </div>

    <router-view />
    <Footer />

  </div>
</template>

<script>

import Header from '@/components/Header.vue';
import Footer from '@/components/Footer.vue';


export default {
  name: 'App',
  components: {
    Header,
    Footer
    }
}
</script>

<style scoped>

#app {
  background:rgba(0, 0, 0, 0.3);
  background: #ffffff;
  background-blend-mode: darken;
  background-attachment: fixed;
  background-position-x: 50%;
  background-position-y: 50%;
}

</style>