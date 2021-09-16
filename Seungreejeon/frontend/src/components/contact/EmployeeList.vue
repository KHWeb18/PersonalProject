<template>
  <div>
    <v-divider />
    <v-list-item
      v-for="(em, i) in employee"
      :key="i"
      link
      v-bind="$attrs"
      v-on="$listeners"
    >
      <v-row no-gutters>
        <v-col
          cols="1"
          class="ma-1 ml-8 font-weight-light text-subtitle-1 "
        >
          <v-chip
            :color="em.team==='dev'?'green':em.team==='purchase'?'blue':'orange'"
            class=" white--text my-2"
          >
            {{ em.team }}
          </v-chip>
        </v-col>
        <!-- 클릭시 상세설명 부분 -->
        <v-dialog
          width="500"
        >
          <template v-slot:activator="{ on, attrs }">
            <v-col
              cols="2"
              class="ma-1 ml-15 font-weight-light text-subtitle-1"
              v-bind="attrs"
              v-on="on"
            >
              {{ em.name }}
            </v-col>
          </template>
          <v-card>
            <v-card-title class="text-h5 grey lighten-2">
              Information
            </v-card-title>
            <v-card-text>
              {{ em.detail }}
            </v-card-text>
          </v-card>
        </v-dialog>
        <v-col
          cols="3"
          class="ma-1 ml-10 font-weight-light text-subtitle-1"
        >
          {{ em.phoneNumber }}
        </v-col>
        <v-col
          cols="4"
          class="ma-1 font-weight-light"
        >
          {{ em.email }}
        </v-col>
      </v-row>
    </v-list-item>
  </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'

export default {
  name: "EmplyeeList",

  inheritAttrs: false,

  computed: {
    ...mapState('contact',{
      employee: 'employee'
    })
  },
  created() {
    this.fetchContact()
  },
  methods: {
    ...mapActions('contact', {
      fetchContact: 'fetchContact'
    }),
  }

}
</script>

<style>

</style>
