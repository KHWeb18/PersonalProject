<template>
  <v-row justify="center">
    <v-dialog
      v-model="dialog"
      max-width="800px"
    >
      <template v-slot:activator="{ on, attrs }">
        <v-btn
          color="green"
          dark
          v-bind="attrs"
          text
          v-on="on"
        >
          Modify schedule
        </v-btn>
      </template>

      <validation-observer
        v-slot="{ invalid }"
        ref="observer"
      >
        {{ load }}
        <v-card>
          <v-card-title>
            <span class="text-h5">Modify Schedule</span>
          </v-card-title>
          <v-card-text>
            <v-container>
              <v-form>
                <v-row>
                  <v-col cols="3">
                    <validation-provider
                      v-slot="{ errors }"
                      :rules="{
                        required: true,
                        max: 10
                      }"
                      name="time"
                    >
                      <v-text-field
                        v-model="time8"
                        :value="get.time9"
                        label="8AM"
                        placeholder="Hard Coding"
                        :error-messages="errors"
                      />
                    </validation-provider>
                  </v-col>

                  <v-col cols="3">
                    <validation-provider
                      v-slot="{ errors }"
                      :rules="{
                        required: true,
                        max: 10
                      }"
                      name="time"
                    >
                      <v-text-field
                        v-model="time9"
                        label="9AM"
                        placeholder="Hard Coding"
                        :error-messages="errors"
                      />
                    </validation-provider>
                  </v-col>

                  <v-col cols="3">
                    <validation-provider
                      v-slot="{ errors }"
                      :rules="{
                        required: true,
                        max: 10
                      }"
                      name="time"
                    >
                      <v-text-field
                        v-model="time10"
                        label="10AM"
                        :error-messages="errors"
                      />
                    </validation-provider>
                  </v-col>
                  <v-col cols="3">
                    <validation-provider
                      v-slot="{ errors }"
                      :rules="{
                        required: true,
                        max: 10
                      }"
                      name="time"
                    >
                      <v-text-field
                        v-model="time11"
                        label="11AM"
                        :error-messages="errors"
                      />
                    </validation-provider>
                  </v-col>
                </v-row>
                <v-row>
                  <v-col cols="3">
                    <validation-provider
                      v-slot="{ errors }"
                      :rules="{
                        required: true,
                        max: 10
                      }"
                      name="time"
                    >
                      <v-text-field
                        v-model="time12"
                        label="12AM"
                        :error-messages="errors"
                      />
                    </validation-provider>
                  </v-col>
                  <v-col cols="3">
                    <validation-provider
                      v-slot="{ errors }"
                      :rules="{
                        required: true,
                        max: 10
                      }"
                      name="time"
                    >
                      <v-text-field
                        v-model="time13"
                        label="13AM"
                        :error-messages="errors"
                      />
                    </validation-provider>
                  </v-col>
                  <v-col cols="3">
                    <validation-provider
                      v-slot="{ errors }"
                      :rules="{
                        required: true,
                        max: 10
                      }"
                      name="time"
                    >
                      <v-text-field
                        v-model="time14"
                        label="14AM"
                        :error-messages="errors"
                      />
                    </validation-provider>
                  </v-col>
                  <v-col cols="3">
                    <validation-provider
                      v-slot="{ errors }"
                      :rules="{
                        required: true,
                        max: 10
                      }"
                      name="time"
                    >
                      <v-text-field
                        v-model="time15"
                        label="15AM"
                        :error-messages="errors"
                      />
                    </validation-provider>
                  </v-col>
                </v-row>
                <v-row>
                  <v-col cols="3">
                    <validation-provider
                      v-slot="{ errors }"
                      :rules="{
                        required: true,
                        max: 10
                      }"
                      name="time"
                    >
                      <v-text-field
                        v-model="time16"
                        label="16AM"
                        :error-messages="errors"
                      />
                    </validation-provider>
                  </v-col>
                  <v-col cols="3">
                    <validation-provider
                      v-slot="{ errors }"
                      :rules="{
                        required: true,
                        max: 10
                      }"
                      name="time"
                    >
                      <v-text-field
                        v-model="time17"
                        label="17AM"
                        :error-messages="errors"
                      />
                    </validation-provider>
                  </v-col>
                  <v-col cols="3">
                    <validation-provider
                      v-slot="{ errors }"
                      :rules="{
                        required: true,
                        max: 10
                      }"
                      name="time"
                    >
                      <v-text-field
                        v-model="time18"
                        label="18AM"
                        :error-messages="errors"
                      />
                    </validation-provider>
                  </v-col>
                  <v-col cols="3">
                    <validation-provider
                      v-slot="{ errors }"
                      :rules="{
                        required: true,
                        max: 10
                      }"
                      name="time"
                    >
                      <v-text-field
                        v-model="time19"
                        label="19AM"
                        :error-messages="errors"
                      />
                    </validation-provider>
                  </v-col>
                  <v-col cols="3">
                    <validation-provider
                      v-slot="{ errors }"
                      :rules="{
                        required: true,
                        max: 10
                      }"
                      name="time"
                    >
                      <v-text-field
                        v-model="time20"
                        label="20AM"
                        :error-messages="errors"
                      />
                    </validation-provider>
                  </v-col>
                </v-row>
              </v-form>
            </v-container>
          </v-card-text>
          <v-card-actions>
            <v-spacer />
            <v-btn
              color="blue darken-1"
              text
              @click="dialog = false"
            >
              Close
            </v-btn>
            <v-btn
              color="blue darken-1"
              text
              :disabled="invalid"
              @click="modifySchedule"
            >
              Save
            </v-btn>
          </v-card-actions>
        </v-card>
      </validation-observer>
    </v-dialog>
  </v-row>
</template>
<script>

export default {
  name: "ScheduleModify",
  data: () => ({
    dialog: false,
    scheduleNo: null,
    time8: 'work',
    time9: 'work',
    time10: 'work',
    time11: 'work',
    time12: 'work',
    time13: 'work',
    time14: 'work',
    time15: 'work',
    time16: 'work',
    time17: 'work',
    time18: 'work',
    time19: 'work',
    time20: 'work',
    modify: []
  }),
  computed: {
    load() {
      return this.get()
    }
  },
  created() {
    this.get()
  },
  methods: {
    get() {
      this.modify = this.$store.getters['schedule/getExist']
      this.scheduleNo = this.modify[0].scheduleNo
      this.time8 = this.modify[0].time8
      this.time9 = this.modify[0].time9
      this.time10 =  this.modify[0].time10
      this.time11 =  this.modify[0].time11
      this.time12 =  this.modify[0].time12
      this.time13 =  this.modify[0].time13
      this.time14 =  this.modify[0].time14
      this.time15 =  this.modify[0].time15
      this.time16 =  this.modify[0].time16
      this.time17 =  this.modify[0].time17
      this.time18 =  this.modify[0].time18
      this.time19 =  this.modify[0].time19
      this.time20 =  this.modify[0].time20
    },
    modifySchedule() {
      this.$store.dispatch('schedule/modifySchedule', {
        scheduleNo: this.scheduleNo,
        email: localStorage.getItem('email'),
        name: localStorage.getItem('name'),
        team: localStorage.getItem('team'),
        time8: this.time8,
        time9: this.time9,
        time10: this.time10,
        time11: this.time11,
        time12: this.time12,
        time13: this.time13,
        time14: this.time14,
        time15: this.time15,
        time16: this.time16,
        time17: this.time17,
        time18: this.time18,
        time19: this.time19,
        time20: this.time20,
      }),
      this.dialog = false
    }
  }
}
</script>
