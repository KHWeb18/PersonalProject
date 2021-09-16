<template>
  <v-card>
    <user-infor-title />
    <v-divider />
    <user-info-list />
  </v-card>
</template>

<script>

export default {
  name: "UserInforMenu",
  components: {
    UserInfoList: () =>import('./UserInfoList.vue'),
    UserInforTitle: () =>import('./UserInforTitle.vue')
  }
}

</script>

<style>

</style>

