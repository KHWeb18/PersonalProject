<template>
  <v-list
    dense
    nav
    expand
  >
    <template v-for="(item, index) in items ">
      <nav-list-group
        v-if="item.items"
        :key="`group-${index}`"
        :item="item"
      />
      <nav-list-item
        v-else
        :key="`item-${index}`"
        :item="item"
      />
    </template>
  </v-list>
</template>

<script>
import { mapState } from 'vuex'
export default {
  components: {
    NavListItem: () => import('./NavListItem.vue'),
    NavListGroup: () => import('./NavListGroup.vue')
  },
  computed: {
    ...mapState('drawer', {
      items: 'items',
    }),
  }

}
</script>

<style>

</style>
