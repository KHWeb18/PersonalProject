<template>
  <v-card-text>
    <validation-observer
      ref="observer"
      v-slot="{ invalid }"
    >
      <v-form @submit.prevent="singin">
        <v-row justify="center">
          <v-radio-group
            v-model="role"
            row
            mandatory
          >
            <v-radio
              label="직원"
              value="1"
            />
            <v-radio
              label="관리자"
              value="2"
            />
          </v-radio-group>
        </v-row>
        <v-row no-gutters>
          <v-col cols="3" />
          <v-col
            cols="6"
            align-self="center"
          >
            <validation-provider
              v-slot="{ errors }"
              name="email"
              :rules="{
                required: true,
                email: true
              }"
            >
              <v-text-field
                v-model="email"
                label="이메일"
                clearable
                prepend-icon="mdi-email"
                :error-messages="errors"
              />
            </validation-provider>
          </v-col>
        </v-row>
        <v-row no-gutters>
          <v-col cols="3" />
          <v-col
            cols="6"
            align-self="center"
          >
            <validation-provider
              v-slot="{ errors }"
              name="passwordconfirm"
              :rules="{
                required: true,
              }"
            >
              <v-text-field
                v-model="password"
                label="비밀번호"
                name="passwordconfirm"
                clearable
                prepend-icon="mdi-lock-outline"
                :error-messages="errors"
                type="password"
              />
            </validation-provider>
          </v-col>
        </v-row>
        <v-row
          class="ml-15"
          no-gutters
        >
          <v-col class="ml-16 mt-3">
            <find />
          </v-col>
          <v-col class="mt-3 mr-10">
            <!-- 가입 -->
            <sign-up />
          </v-col>
          <v-col class="mr-15">
            <v-btn
              color="primary"
              :disabled="invalid"
              type="submit"
              text
              small
            >
              로그인
            </v-btn>
          </v-col>
        </v-row>
      </v-form>
    </validation-observer>
  </v-card-text>
</template>

<script>
// signup 연결 버튼

export default {

  components: {
    SignUp: () => import('../Signup.vue'),
    Find: () => import('../Find.vue')
  },
  data: () => ({
    inheritAttrs: false,
    password: null,
    email: null,
    role: null,
  }),
  methods: {
    async singin ()  {
      const result = await this.$refs.observer.validate()

      if ( result ) {
        this.$store.dispatch('authentication/signin',
          { email: this.email, password: this.password, auth: this.role }
        )
      }
    },

  },


}
</script>

<style>

</style>
