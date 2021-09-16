<template>
  <v-toolbar
    flat
    class="mb-2"
  >
    <div v-show="role">
      <posting />
    </div>
    <v-spacer />
    <template>
      <tr>
        <td>
          <v-scroll-x-reverse-transition>
            <v-text-field
              v-show="hidden"
              label="Search"
              v-bind="$attrs"
              v-on="$listeners"
            />
          </v-scroll-x-reverse-transition>
        </td>
      </tr>
    </template>
    <v-btn
      color="primary"
      v-bind="$attrs"
      icon
      @click="hidden = !hidden"
    >
      <v-icon>mdi-magnify</v-icon>
    </v-btn>
  </v-toolbar>
</template>

<script>
export default {
  name: "SearchBar",
  components: {
    Posting: () => import('./Posting.vue')
  },

  inheritAttrs: false,


  data: () => ({
    hidden: false,
  })
  ,
  computed: {
    // 권한에 따른 버튼 활성화지만 localstorage에서 바꾸면 보인다.
    role() {
      return this.$store.getters['authentication/getRole']
    }
  },



}
</script>

<style>

</style>
