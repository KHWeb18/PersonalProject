<template>
  <v-dialog  v-model="registerDialog" persistent max-width="500px">
    <template v-slot:activator="{ on, attrs }">
      <v-btn text color="white" class="btn-flat" v-on="on" v-bind="attrs">회원가입</v-btn>
    </template>
    <v-card>
      <!-- card image -->
      <v-img
          :src="require('../../assets/pic/sunrise.jpg')"
          height="190px"
      ></v-img>
      <!-- card title -->
      <v-card-title class="headline text-h4">
        Sign Up
      </v-card-title>
      <!-- card contents -->
      <form v-on:submit.prevent="onRegister">
      <v-card-text>
        <v-container>
          <v-row>
            <v-col cols="12">
              <input placeholder="아이디" :disabled="valid" v-model="member_id"
              type="text" class="my-5">
              <v-btn color="grey darken-1" @click="checkValid" dark class="check mt-5 ml-n5">중복확인</v-btn>
            </v-col>
            <v-col cols="12">
              <input placeholder="비밀번호" v-model="member_pw"
                     type="password" class="my-5">
            </v-col>
            <v-col cols="12" md="8">
              <input placeholder="이름" v-model="name"
                     type="text" class="mt-6">
            </v-col>

            <v-col cols="12">
              <input placeholder="이메일" v-model="email"
                     type="email" class="mt-6 mb-n2">
            </v-col>
          </v-row>
        </v-container>
      </v-card-text>

      <!-- divide line -->
      <v-divider class="mx-5 my-2"></v-divider>
      <!-- buttons -->
      <v-card-actions>
        <v-btn color="teal darken-1" class="text-button"  text @click="registerDialog = !registerDialog">
          cancel
        </v-btn>
        <v-spacer></v-spacer>
        <v-btn v-if="valid" color="teal darken-1" type="submit" class="text-button"
               text >
          Submit
        </v-btn>
      </v-card-actions>
      </form>
    </v-card>
  </v-dialog>
</template>

<script>
import axios from "axios";

export default {
  name: "MemberRegisterCard",
  data() {
    return {
      registerDialog: false,
        member_id: '',
        member_pw: '',
        name: '',
        email: '',
        valid: false,
    }
  },
  methods: {
    onRegister () {
      const { member_id, member_pw, name, email } = this
      this.$emit('submit', { member_id, member_pw, name, email })
      this.registerDialog = false;
    },
    checkValid() {
      const { member_id } = this
      let temp;
      axios.get(`http://localhost:7777/member/check/${member_id}`)
          .then(res => {
            this.temp = res.data;
            if(this.temp){
              alert("Account Usable")
              this.valid = res.data;
            }else {
              alert("Account Duplicate")
              this.valid = false;
            }

          })
      return temp
    }
  },
}
</script>

<style scoped>
.check{
  position: absolute;
}
</style>
