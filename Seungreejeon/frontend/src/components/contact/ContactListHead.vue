<template>
  <!-- 기본 틀 부분 -->
  <v-row no-gutters>
    <v-col
      cols="1"
      class="ma-1 ml-10 font-weight-light
          text-subtitle-1
          text--secondary "
    >
      {{ headers.Depart }}
    </v-col>
    <v-col
      cols="2"
      class="ma-1 ml-16 font-weight-light text-subtitle-1
          text--secondary"
    >
      {{ headers.Name }}
    </v-col>
    <v-col
      cols="3"
      class="ma-1 ml-11 font-weight-light text-subtitle-1
          text--secondary"
    >
      {{ headers.Contact }}
    </v-col>
    <v-col
      cols="3"
      class="ma-1 ml-8 font-weight-light
          text--secondary "
    >
      {{ headers.Email }}
    </v-col>
  </v-row>
</template>

<script>
import { mapState } from 'vuex'

export default {
  name: "ContactListHead",



  computed: {
    ...mapState('contact', {
      headers: 'headers'
    })
  }

}
</script>

<style>

</style>
