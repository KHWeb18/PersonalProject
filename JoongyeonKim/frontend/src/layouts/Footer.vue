<template>
  <div id="container">
    <v-banner>
      <footer>
          <v-toolbar dense white>
          &copy; 2021
          </v-toolbar>
      </footer>
    </v-banner>
  </div>
</template>

<!--
<template>
  <footer class="mt-5 py-5 bg-dark text-white">
    &copy; 2021
  </footer>
</template>
-->

<script>
export default {
  name: 'Footer'
}
</script>

<style scoped>
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

#container {
    margin: 0 auto;
    width: 1200px;
}

h5 {
    float: right;
    margin: 380px;
}
</style>