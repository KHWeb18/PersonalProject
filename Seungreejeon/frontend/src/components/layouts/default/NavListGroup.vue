<template>
  <v-list-group
    :prepend-icon="item.icon"
    eager
    v-bind="$attrs"
    color="black"
    v-on="$listeners"
  >
    <template v-slot:activator>
      <v-list-item-content>
        <v-list-item-title>
          {{ item.title }}
        </v-list-item-title>
      </v-list-item-content>
    </template>

    <template v-for="(child, index) in item.items">
      <nav-list-item
        :key="`child-${index}`"
        :item="child"
      />
    </template>
  </v-list-group>
</template>

<script>

export default {
  name: "NavListGroup",
  components: {
    NavListItem: () => import('./NavListItem.vue')
  },
  props: {
    item: {
      type: Object,
      default: () => ({})
    }
  },

}
</script>

<style>

</style>
