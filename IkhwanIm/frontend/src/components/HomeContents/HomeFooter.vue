<template>
  <v-footer padless fixed color="grey lighten-2" height="18">
    <v-col
        class="text-center mt-n3 mx-auto"
        cols="12"
    >
      {{ new Date().getFullYear() }} — <strong>&copy; GoFor &#8482;</strong>
    </v-col>
  </v-footer>
</template>

<script>
export default {
name: "HomeFooter"
}
</script>

<style scoped>

</style>