<template>
  <v-card
    flat
  >
    <v-row>
      <v-col
        v-for="(time, i) in timeone"
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
  </v-card>
</template>

<script>
import { mapState } from 'vuex'
export default {
  
  data: () => ({
    name: 'TimebarFirstpage',
  }),

  computed: {
    ...mapState('schedule', {
      timeone: 'timeone'
    })
  }


}
</script>

<style>

</style>
