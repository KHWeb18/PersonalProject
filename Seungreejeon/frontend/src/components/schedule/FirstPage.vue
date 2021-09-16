<template>
  <v-window-item :value="1">
    <time-bar-firstpage />
    <br>
    <v-divider />
    <br>
    <v-card
      flat
    >
      <v-row
        v-for="(person, i) in getList"
        :key="i"
      >
        <v-col>
          <v-btn
            small
            color="primary"
            class="ml-3"
            text
          >
            {{ person.name }}
          </v-btn>
        </v-col>
        <v-col>
          <v-btn
            small
            color="primary"
            class="ml-3"
            text
          >
            {{ person.time8 }}
          </v-btn>
        </v-col>
        <v-col>
          <v-btn
            small
            color="primary"
            class="ml-3"
            text
          >
            {{ person.time9 }}
          </v-btn>
        </v-col>
        <v-col>
          <v-btn
            small
            color="primary"
            class="ml-3"
            text
          >
            {{ person.time10 }}
          </v-btn>
        </v-col>
        <v-col>
          <v-btn
            small
            color="primary"
            class="ml-3"
            text
          >
            {{ person.time11 }}
          </v-btn>
        </v-col>
        <v-col>
          <v-btn
            small
            color="primary"
            class="ml-3"
            text
          >
            {{ person.time12 }}
          </v-btn>
        </v-col>
        <v-col class="mb-1">
          <v-btn
            small
            color="primary"
            class="ml-3"
            text
          >
            {{ person.time13 }}
          </v-btn>
        </v-col>
      </v-row>
    </v-card>
  </v-window-item>
</template>

<script>

import TimeBarFirstpage from './TimeBarFirstpage.vue'
// import { mapActions } from 'vuex'


export default {
  components: {
    TimeBarFirstpage
  },
  computed: {
    getList() {
      return this.$store.getters['schedule/getList']
    },
  },
  // created() {
  //   this.fetchSchedule()
  // },
  // methods: {
  //   ...mapActions('schedule', {
  //     fetchSchedule: 'fetchSchedule'
  //   }),
  // }
}
</script>

<style>

</style>
