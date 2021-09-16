<template>
  <v-dialog
    v-model="dialog"
    transition="dialog-top-transition"
    max-width="320"
  >
    <template v-slot:activator="{ on, attrs }">
      <v-btn
        icon
        color="white"
        class="ml-1"
        v-bind="attrs"
        v-on="on"
      >
        <v-icon>mdi-calendar-month</v-icon>
      </v-btn>
    </template>

    <v-card>
      <v-date-picker
        v-model="picker"
        full-width
      />
    </v-card>
  </v-dialog>
</template>

<script>
export default {
  name: 'DatePicker',
  data: () => ({
    dialog: false,
    picker: (new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10),
  })
}
</script>

<style>

</style>
