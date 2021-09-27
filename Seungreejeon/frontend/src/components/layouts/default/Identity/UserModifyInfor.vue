<template>
  <v-card>
    <v-card-title>
      <span class="text-h5">User Profile</span>
    </v-card-title>
    <v-card-text>
      <v-container>
        <v-row no-gutters>
          <v-col
            cols="6"
            sm="8"
            md="5"
          >
            <v-text-field
              label="name"
              :value="name"

              class="mt-8"
              readonly
            />
          </v-col>
          <v-col
            cols="5"
            class="ml-12"
          >
            <v-avatar
              color="grey"
              size="100"
              tile
            >
              <img
                src="@/assets/EMP.jpg"
                alt="user"
              >
            </v-avatar>
          </v-col>

          <v-col cols="12">
            <v-text-field
              label="Email"
              :value="email"

              readonly
            />
          </v-col>
          <v-col cols="12">
            <v-text-field
              v-model="password"
              label="Password*"
              type="password"
              required
            />
          </v-col>
        </v-row>
      </v-container>
      <small>*이름, 이메일은 수정 불가</small>
    </v-card-text>
    <v-card-actions>
      <v-spacer />
      <v-btn
        text
        color="error"
        @click="deleteAccount"
      >
        Delete Account
      </v-btn>
      <v-btn
        color="primary"
        text
        @click="change"
      >
        Close
      </v-btn>
      <v-btn
        color="orange"
        text
        @click="modifyUserInfor"
      >
        Save
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
export default {
  data: () => ({
    password: null,
  }),
  computed: {
    name() {
      return localStorage.getItem('name')
    },
    email() {
      return localStorage.getItem('email')
    },
  },
  methods: {
    change() {
      this.$emit('change')
    },
    modifyUserInfor() {
      this.$store.dispatch('userInfor/modifyUserInfor',
        {
          password:this.password, email:localStorage.getItem('email')
        }
      )
    },
    deleteAccount() {
      const infor = localStorage.getItem('email')
      this.$store.dispatch('userInfor/deleteAcoount',
        {
          email: infor,
        })
    }
  }
}
</script>

<style>

</style>
