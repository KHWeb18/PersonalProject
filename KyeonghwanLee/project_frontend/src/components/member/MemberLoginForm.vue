<template>
  <form @submit.prevent="onSubmit">
    <div id="app">
      <v-app
        :class="{ 'pa-3': $vuetify.breakpoint.smAndUp }"
        :dark="darkTheme"
        id="inspire"
      >
        <v-container>
          <v-layout wrap>
            <v-flex sm12 md6 offset-md3>
              <v-card elevation="4" light tag="section">
                <v-card-title>
                  <v-layout align-center justify-space-between>
                    <h3 class="headline"></h3>
                    <v-flex>
                      <v-img
                        class="ml-3"
                        contain
                        height="48px"
                        position="center left"
                        src="../../assets/logos/logo1.jpg"
                      ></v-img>
                    </v-flex>
                  </v-layout>
                </v-card-title>
                <v-divider></v-divider>
                <v-card-text>
                  <p>Sign in with your email and password:</p>
                  <v-form>
                    <v-text-field
                      input
                      outline
                      label="email"
                      type="text"
                      v-model="email"
                    ></v-text-field>
                    <v-text-field
                      input
                      outline
                      hide-details
                      label="Password"
                      type="password"
                      v-model="password"
                    ></v-text-field>
                  </v-form>
                </v-card-text>
                <v-divider></v-divider>
                <v-card-actions
                  :class="{ 'pa-3': $vuetify.breakpoint.smAndUp }"
                >
                  <v-btn
                    color="info"
                    :large="$vuetify.breakpoint.smAndUp"
                    position="center left"
                    type="submit"
                  >
                    <v-icon left>lock</v-icon>
                    Login
                  </v-btn>
                </v-card-actions>
              </v-card>
            </v-flex>
          </v-layout>
        </v-container>
      </v-app>
    </div>
  </form>
</template>

<script>
export default {
  name: "MemberLoginForm",
  data() {
    return {
      email: "",
      password: "",
      darkTheme: true,
      platformName: "Platform name",
    };
  },
  methods: {
    onSubmit() {
      const { email, password } = this;
      this.$emit("submit", { email, password });
    },
  },
};
</script>

<style scoped>
.v-btn {
  border-radius: 4px;
}
.v-card {
  width: 100%;
}

.v-card__title {
  text-transform: uppercase;
}
</style>
