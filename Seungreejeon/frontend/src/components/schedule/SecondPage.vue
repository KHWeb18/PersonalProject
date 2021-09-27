<template>
  <v-window-item :value="2">
    <time-bar-second-page />
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
            {{ person.time14 }}
          </v-btn>
        </v-col>
        <v-col>
          <v-btn
            small
            color="primary"
            class="ml-3"
            text
          >
            {{ person.time15 }}
          </v-btn>
        </v-col>
        <v-col>
          <v-btn
            small
            color="primary"
            class="ml-3"
            text
          >
            {{ person.time16 }}
          </v-btn>
        </v-col>
        <v-col>
          <v-btn
            small
            color="primary"
            class="ml-3"
            text
          >
            {{ person.time17 }}
          </v-btn>
        </v-col>
        <v-col>
          <v-btn
            small
            color="primary"
            class="ml-3"
            text
          >
            {{ person.time18 }}
          </v-btn>
        </v-col>
        <v-col>
          <v-btn
            small
            color="primary"
            class="ml-3"
            text
          >
            {{ person.time19 }}
          </v-btn>
        </v-col>
        <v-col>
          <v-btn
            small
            color="primary"
            class="ml-3"
            text
          >
            {{ person.time20 }}
          </v-btn>
        </v-col>
      </v-row>
    </v-card>
  </v-window-item>
</template>

<script>
import TimeBarSecondPage from './TimeBarSecondPage.vue'


export default {
  components: { TimeBarSecondPage },
  computed: {

    getList() {
      return this.$store.getters['schedule/getList']
    }

  }


}
</script>

<style>

</style>
