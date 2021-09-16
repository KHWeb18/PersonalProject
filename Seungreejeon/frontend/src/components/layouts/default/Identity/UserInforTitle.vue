<template>
  <v-list>
    <v-list-item>
      <v-list-item-avatar>
        <img
          src="@/assets/EMP.jpg"
          alt="user"
        >
      </v-list-item-avatar>
      <v-list-item-content>
        <v-list-item-title>
          {{ name }}
        </v-list-item-title>
        <v-list-item-subtitle>
          {{ "Department : " + depart }}
        </v-list-item-subtitle>
      </v-list-item-content>
    </v-list-item>
  </v-list>
</template>

<script>

export default {
  name: 'UserInfor',
  computed: {
    name() {
      return localStorage.getItem('name')
    },
    depart() {
      return localStorage.getItem('team')
      // return this.$store.getters['authentication/getEmpDepart']
    }
  }

}
</script>

<style>

</style>
