<template>
  <v-container
    fill-height
  >
    <v-row justify="center">
      <v-col cols="auto">
        <v-card width="800">
          <Header />

          <Form />
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>

import Header from './signin/Header.vue'

import Form from './signin/Form.vue'

export default {

  components: {
    Header,
    Form
  },

}
</script>

<style>

</style>
