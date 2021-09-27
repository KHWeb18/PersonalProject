<template>
  <v-container app>
    <v-list width="1200">
      <v-card>
        <contact-sort-button />

        <contact-list-head />

        <emloyee-list />
      </v-card>
    </v-list>
  </v-container>
</template>

<script>
import EmloyeeList from './EmployeeList.vue'
import ContactListHead from './ContactListHead.vue'
import ContactSortButton from './ContactSortButton.vue'

export default {
  components: {
    EmloyeeList,
    ContactListHead,
    ContactSortButton
  },

}
</script>
