<template>
  <v-list>
    <v-list-item
      link
    >
      <v-dialog
        v-model="dialog"
        transition="dialog-top-transition"
        width="350"
      >
        <template v-slot:activator="{ on, attrs }">
          <v-list-item-title
            class="text-subtitle-1"
            v-bind="attrs"
            v-on="on"
          >
            {{ infor[0].title }}
          </v-list-item-title>
        </template>

        <v-card>
          <user-modify-infor @change="dichange" />
        </v-card>
      </v-dialog>
    </v-list-item>
    <v-list-item
      link
      @click="signout"
    >
      <v-list-item-title
        class="text-subtitle-1"
      >
        {{ infor[1].title }}
      </v-list-item-title>
    </v-list-item>
  </v-list>
</template>

<script>
import { mapState } from 'vuex'

export default {
  name: "UserInformation",
  components: {
    UserModifyInfor: () => import('./UserModifyInfor.vue')
  },
  data: () => ({
    dialog: false
  }),
  computed: {
    ...mapState('userInfor', {
      infor: 'infor'
    })
  },
  methods: {
    signout() {
      this.$store.dispatch('authentication/signout')
    },
    modifyUserInfor() {
      this.$store.dispatch('authentication/modifyUserInfor')
    },
    dichange() {
      this.dialog = !this.dialog
    }
  }

}
</script>

<style>

</style>
