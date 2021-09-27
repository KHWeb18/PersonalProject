<template>
  <v-footer app color="white" dark absolute :footer="footer">
    <v-spacer></v-spacer>
    <div>&copy; {{ new Date().getFullYear() + ' ' + footer }}</div>
    <h9>하하</h9>
  </v-footer>
</template>
<script>
export default {
  props: ['footer']
}
</script>    