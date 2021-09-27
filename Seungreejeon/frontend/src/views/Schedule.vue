<template>
  <v-container>
    <schedule-index />
  </v-container>
</template>

<script>


export default {
  components: {
    ScheduleIndex:() => import('../components/schedule/Index.vue'),
  }

}
</script>

<style>

</style>
