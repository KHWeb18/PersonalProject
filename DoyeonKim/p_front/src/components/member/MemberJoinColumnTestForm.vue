<template>
<v-container justify-center>
<v-card-title primary-title class="justify-center">
<v-card>
    
  <v-form
    ref="form"
    v-model="valid"
    lazy-validation
  >
    <v-text-field
      v-model="id"
      :counter="20"
      :rules="idRules"
      label="id"
      required
    ></v-text-field>

    <v-text-field
      v-model="password"
      :rules="pwRules"
      label="password"
      required
    ></v-text-field>

    <v-text-field
      v-model="passwordCheck"
      :rules="pwRules"
      label="password Check"
      required
    ></v-text-field>

    <v-text-field
      v-model="name"
      :rules="name"
      label="name"
      required
    ></v-text-field>

    <v-select
      v-model="gender"
      :items="gender"
      :rules="[v => !!v || 'Item is required']"
      label="gender"
      required
    ></v-select>

    <v-text-field
      v-model="email"
      :rules="emailRules"
      label="E-mail"
      required
    ></v-text-field>


    <v-checkbox
      v-model="checkbox"
      :rules="[v => !!v || 'You must agree to continue!']"
      label="Do you agree?"
      required
    ></v-checkbox>

    <v-btn
      :disabled="!valid"
      color="dark"
      class="mr-4"
      @click="validate"
    >
      로그인
    </v-btn>

    <v-btn
      color="dark"
      class="mr-4"
      @click="reset"
    >
      회원가입
    </v-btn>

    <v-btn
      color="warning"
      @click="resetValidation"
    >
      Reset Validation
    </v-btn>
  </v-form>
</v-card>

</v-card-title>
</v-container>
</template>

<script>
//import About from '../../views/About.vue'

  export default {
    data: () => ({
      valid: true,
      id: '',
      idRules: [
        v => !!v || '아이디를 입력하세요.',
        v => (v && v.length <= 20) || '20자 이상은 쓸 수 없습니다.',
      ],
      password: '',
      pwRules: [
        v => !!v || '비밀번호를 입력하세요',
        //v => /.+@.+\..+/.test(v) || 'E-mail must be valid',
      ],
      select: null,
      gender: [
        '여자',
        '남자',
      ],
      email: '',
      emailRules: [
        v => !!v || 'E-mail is required',
        v => /.+@.+\..+/.test(v) || 'E-mail must be valid',
      ],
    }),

    methods: {
      validate () {
        this.$refs.form.validate()
      },
      reset () {
        this.$refs.form.reset()
      },
      resetValidation () {
        this.$refs.form.resetValidation()
      },
    },
  }
  
</script>

