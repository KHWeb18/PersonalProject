<template>
      <div>
        <v-menu offset-y>
          <template v-slot:activator="{ on, attrs }">
            <v-btn class="mt-n4 py-8 btn-flat" text v-bind="attrs" v-on="on">
              {{ session.member_id }}
            </v-btn>
          </template>
          <v-list>
            <v-list-item>
              <v-list-item-title @click="memberInfo" class="infoBtn"><v-icon left>assignment_ind
              </v-icon>My Info</v-list-item-title>
            </v-list-item>
            <v-divider></v-divider>
            <v-list-item>
              <v-list-item-title @click="logoutBtn" class="red-text infoBtn"><v-icon color="red">exit_to_app</v-icon>
                Sign Out</v-list-item-title>
            </v-list-item>
          </v-list>
        </v-menu>
      </div>
</template>

<script>
export default {
  name: "MemberMenu",
  props: {
    session: {
      type: Object,
      required: true
    },
  },
  methods: {
    logoutBtn () {
      this.$emit('logout')
    },
    memberInfo() {
      this.$router.push({ name: 'MemberInfoPage' })
    }
  }
}
</script>

<style scoped>
.infoBtn{
  cursor: pointer;
}
</style>
