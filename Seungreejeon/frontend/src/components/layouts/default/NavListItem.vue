<template>
  <v-list-item
    link
    :to="item.to"
    color="white"
    active-class="primary"
  >
    <v-list-item-icon>
      <v-icon>{{ item.icon }}</v-icon>
    </v-list-item-icon>

    <v-list-item-content>
      <v-list-item-title>{{ item.title }}</v-list-item-title>
    </v-list-item-content>
  </v-list-item>
</template>

<script>
export default {
  name: "NavListItem",
  props: {
    item: {
      type: Object,
      default: () => ({})
    }
  }

}
</script>

<style>

</style>
