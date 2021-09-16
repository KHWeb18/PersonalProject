<template>
  <v-card
    class="mx-auto"
    max-width="1200"
  >
    <v-row>
      <v-col cols="9">
        <v-card
          height="70"
          class="text-h5 font-weight-regular ml-6 mt-2"
          flat
        >
          <span class="text-uppercase font-weight-thin">{{ currentTitle + " " }}</span>
          <span class="text-uppercase font-wieght-regular">Team</span>
        </v-card>
      </v-col>
      <v-col cols="3">
        <div class="mt-5 ml-5">
          <schedule-set v-show="role" />
        </div>
        <div class="mt-5 ml-5">
          <modify-schedule v-if="modify" />
        </div>
      </v-col>
    </v-row>
    {{ errorModify }}

    <v-window v-model="step">
      <first-page />
      <second-page />
    </v-window>

    <br>
    <v-divider />

    <v-card-actions>
      <v-btn
        :disabled="step === 1"
        text
        @click="step--"
      >
        Back
      </v-btn>

      <v-spacer />
      <v-btn
        :disabled="step === 2"
        color="primary"
        depressed
        @click="step++"
      >
        Next
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
import { mapActions } from 'vuex'
import FirstPage from './FirstPage.vue';
import SecondPage from './SecondPage.vue';
import ScheduleSet from './ScheduleSet.vue';
import ModifySchedule from './Modify.vue';


export default {
  components: { SecondPage, FirstPage, ScheduleSet,
    ModifySchedule
  },
  data: () => ({
    step: 1,
    role: false,
    modify: false
  }),


  computed: {
    currentTitle () {
      switch (this.step) {
      case 1: return localStorage.getItem('team')
      default: return localStorage.getItem('team')
      }
    },

    errorModify() {
      return this.findExist()
    }

  },
  created() {
    this.fetchSchedule()

    this.findExist()
  },

  methods: {

    ...mapActions('schedule', {
      fetchSchedule: 'fetchSchedule'
    }),
    //같은 이메일의 스케줄이 있으면 스케줄 생성 못하고 Modify활성화

    findExist() {
      console.log('실행여부')
      console.log(this.$store.getters['schedule/getModify'])
      if(this.$store.getters['schedule/getModify'] ==  0) {
        this.role = true
        this.modify = false
      } else {
        this.role = false
        this.modify = true
      }
      //   this.modify = true
      //   this.role = false
      // }
      //   if(this.$store.getters['schedule/getModify'] === 0) {
      //     alert(this.$store.getters['schedule/getModify'])
      //     this.role = true
      //   } else {
      //     this.modify = true
      //     alert(this.$store.getters['schedule/getModify'])
    }
  },
}
</script>
