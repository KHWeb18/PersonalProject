<template>
  <div class="text-center">
    <v-menu
      :close-on-content-click="false"
      :nudge-width="200"
      offset-y
    >
      <template v-slot:activator="{ on, attrs }">
        <v-btn
          icon
          color="white"
          class="ml-1"
          v-bind="attrs"
          v-on="on"
        >
          <v-icon>mdi-account-circle</v-icon>
        </v-btn>
      </template>
      <user-information />
    </v-menu>
  </div>
</template>

<script>
import UserInformation from './Index.vue'
export default {
  name: "UserIdentity",
  components: {
    UserInformation
  },
}
</script>

<style>

</style>
