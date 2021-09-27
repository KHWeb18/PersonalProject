<template>
  <v-list-item>
    <v-list-item-content>
      <v-list-item-title class="text-h6">
        {{ email }}
      </v-list-item-title>
      <v-list-item-subtitle>
        {{ name }}
      </v-list-item-subtitle>
    </v-list-item-content>
  </v-list-item>
</template>

<script>
export default {
  name: "NavHeader",
  computed: {
    name() {
      return localStorage.getItem('email')
    },
    email() {
      return localStorage.getItem('name')
    }
  }
}
</script>

<style>

</style>
