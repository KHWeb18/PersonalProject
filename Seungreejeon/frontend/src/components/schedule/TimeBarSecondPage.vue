<template>
  <v-row>
    <v-col
      v-for="(time, i) in timetwo"
      :key="i"
    >
      <v-btn
        small
        color="primary"
        class="ml-5"
      >
        {{ time.time }}
      </v-btn>
    </v-col>
  </v-row>
</template>

<script>
import { mapState } from 'vuex'

export default {

  data: () => ({
    name: 'TimebarSecondpage',
  }),
  computed: {
    ...mapState('schedule', {
      timetwo: 'timetwo'
    })
  }
}
</script>

<style>

</style>
