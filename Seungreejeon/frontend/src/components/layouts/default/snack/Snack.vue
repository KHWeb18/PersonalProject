<template>
  <v-snackbar
    v-model="snack.open"
    :bottom="snack.location === 'bottom'"
    :color="snack.color"
    :timeout="timeout"
    :top="snack.location === 'top'"
    class="text-center ma-2"
    shaped
  >
    <v-row no-gutters>
      <v-col
        class="ml-5"
        align-self="center"
      >
        <h3 class="white--text">
          {{ snack.text }}
        </h3>
      </v-col>
      <v-col class="ml-16">
        <v-btn
          color="pink"
          text
          @click="snack.open = false"
        >
          CLOSE
        </v-btn>
      </v-col>
    </v-row>
  </v-snackbar>
</template>

<script>
import { mapState } from 'vuex'
export default {
  name: "SnackBar",
  data() {
    return {
      timeout: 2000,
    }
  },
  computed: {
    ...mapState('snackBar', {
      snack: 'snack'
    }),

  }
}
</script>
