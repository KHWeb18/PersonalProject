<template>
  <v-container>
    <v-form
      ref="form"
      v-model="valid"
      lazy-validation
      @submit.prevent="onSubmit"
    >
      <div class="row">
        <v-radio-group v-model="radioGroup" row>
          <v-radio
            v-for="kinds in kindsOfMember"
            :key="kinds"
            :label="`${kinds}`"
          >
          </v-radio>
        </v-radio-group>
      </div>
      <v-text-field
        v-model="userId"
        :counter="10"
        :rules="idRules"
        label="UserId"
        required
      ></v-text-field>
      <v-text-field
        v-model="password"
        :counter="10"
        :rules="passwordRules"
        label="Password"
        type="password"
        required
      ></v-text-field>
      <v-text-field
        v-model="name"
        :counter="10"
        :rules="nameRules"
        label="Name"
        required
      ></v-text-field>
      <v-text-field
        v-model="phoneNo"
        :counter="12"
        :rules="phoneNoRules"
        label="PhoneNo"
        required
      ></v-text-field>
      <v-text-field
        v-model="email"
        :rules="emailRules"
        label="E-mail"
        required
      ></v-text-field>
      <v-text-field
        v-model="address"
        :rules="addressRules"
        label="Address"
        required
      ></v-text-field>

      <v-checkbox
        :rules="[v => !!v || 'You must agree to continue!']"
        label="Do you agree?"
        required
      ></v-checkbox>

      <v-btn :disabled="!valid" color="success" class="mr-4" type="submit"
        >회원가입
      </v-btn>

      <v-btn color="error" class="mr-4" href="/">취소</v-btn>
    </v-form>
  </v-container>
</template>

<script>
export default {
  name: "MemberRegisterForm",
  data: () => ({
    radioGroup: 1,
    kindsOfMember: ["개인", "사업자"],
    valid: false,
    userId: "",
    idRules: [
      v => !!v || "Id is required",
      v => v.length <= 10 || "Name must be less than 10 characters",
    ],

    password: "",
    passwordRules: [
      v => !!v || "Password is required",
      v => v.length <= 12 || "Password must be less than 12 characters",
    ],

    name: "",
    nameRules: [
      v => !!v || "Name is required",
      v => v.length <= 10 || "Name must be less than 10 characters",
    ],
    phoneNo: "",
    phoneNoRules: [
      v => !!v || "PhoneNo is required",
      //v => v.length <= 10 || 'PhoneNo must be less than 10 characters'
    ],
    email: "",
    emailRules: [
      v =>
        /^\w+([.-]?\w+)*@\w+([.-]?\w+)*(\.\w{2,3})+$/.test(v) ||
        "@ must be included in emial",
    ],
    address: "",
    addressRules: [v => !!v || "address is required"],
  }),
  methods: {
    onSubmit() {
      const {
        userId,
        password,
        name,
        phoneNo,
        email,
        address,
        radioGroup,
      } = this;
      const auth = radioGroup == 0 ? "개인" : "사업자";
      this.$emit("submit", {
        userId,
        password,
        name,
        phoneNo,
        email,
        address,
        auth,
      });
    },
  },
};
</script>
