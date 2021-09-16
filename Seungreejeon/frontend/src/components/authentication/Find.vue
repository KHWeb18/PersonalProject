<template>
  <v-row justify="center">
    <v-dialog
      v-model="dialog"
      fullscreen
      hide-overlay
      transition="dialog-bottom-transition"
    >
      <template v-slot:activator="{ on, attrs }">
        <v-btn
          color="primary"
          dark
          v-bind="attrs"
          text
          small
          v-on="on"
        >
          ID/PW 찾기
        </v-btn>
      </template>
      <v-card>
        <v-toolbar
          dark
          color="primary"
        >
          <v-btn
            icon
            dark
            @click="dialog = !dialog"
          >
            <v-icon>mdi-close</v-icon>
          </v-btn>

          <v-toolbar-title>ID/PW 찾기</v-toolbar-title>
          <v-spacer />
        </v-toolbar>

        <find-form @change="change" />
      </v-card>
    </v-dialog>
  </v-row>
</template>
<script>

import FindForm from './find/findForm.vue'

export default {
  components: {
    FindForm
  },
  data: () => ({
    inheritAttrs: false,
    dialog: false,
  }),
  methods:{
    change() {
      this.dialog = !this.dialog
    }
  }

}
</script>
