<template>

    <v-container v-if="member">
          <v-row align="center">
            <v-col cols="8" class="mt-3"><h3>My Info</h3>
            </v-col>
          </v-row>

          <v-card class="mx-auto mt-n3" max-width="700" min-height="260">
            <v-card-text>
              <p class="text-h4 text--primary mt-2">
                Profile</p><v-spacer class="pt-2"></v-spacer>
              <p>ID</p> <v-spacer class="mx-4"></v-spacer><p class="text-h5">{{member.member_id}}</p>
              <p>email</p> <v-spacer class="mx-4"></v-spacer><p class="text-h5">{{member.email}}</p>
              <p>name</p> <v-spacer class="mx-4"></v-spacer><p class="text-h5">{{member.name}}</p>
              <p>Joined in</p> <v-spacer class="mx-4"></v-spacer><p class="text-h5">{{member.regDate}}</p>
              회원번호 : {{member.memberNo}}
              {{session.member_id}}
            </v-card-text>

              <v-btn class="right mt-n11" text color="deep-purple accent-4">
                Change Profile
              </v-btn>
          </v-card>
      <v-spacer class="py-8"></v-spacer>
          <v-card class="mx-auto mt-n3" max-width="700" min-height="100">
            <v-card-text>
              <p class="text-h4 text--primary mt-2">
                Delete My Account</p><v-spacer class="pt-2"></v-spacer>
              <p>I want to delete my Account</p>
            </v-card-text>
            <v-btn @click="deleteId" class="right mt-n11" text color="red accent-4">
              Delete
            </v-btn>
          </v-card>
    </v-container>

</template>

<script>
import {mapActions, mapState} from "vuex";
import axios from "axios";
import cookies from "vue-cookies";
import Vue from "vue";
Vue.use(cookies)
export default {
  name: "TestPage",
  computed: {
    ...mapState(["member","session"])
  },
  data() {
    return {

    }
  },
  mounted() {
    this.fetchMember(this.session.member_id)
  },
  methods: {
    ...mapActions(["fetchMember"]),
    deleteId() {
      var temp;
      var inputString = prompt("please type in your ID",)
      if (inputString == this.member.member_id) {
        temp = true;
        const { memberNo } = this.member
        axios.delete(`http://localhost:7777/member/${memberNo}`)
            .then(() => {
              alert("Account Deleted")
              this.$cookies.remove('user')
              this.$store.state.session = null
              this.$router.push({ name: 'Home' })
              window.location.reload();
            })
            .catch(err => {
              alert(err.response.data.message)
            })
      } else {
        alert("Typo")
        temp = false;
      }
      console.log(temp)
      return temp;
    }
  }
}
</script>

<style scoped>

</style>
