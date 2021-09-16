<template>
  <div>
    <v-card class="mx-auto mt-11"
            max-width="800" min-height="500">

      <v-list-item two-line>
        <v-list-item-content>
          <h3 class="center mt-3">Edit Personal Info</h3>
        </v-list-item-content>
      </v-list-item>
      <v-divider></v-divider>
      <v-card-text>
        <v-row align="center">
          <v-col class="mt-3" cols="12">
            new ID
            <v-textarea v-model="member_id" disabled auto-grow solo row-height="10"
                        class="text-body-1"></v-textarea>
          </v-col>
        </v-row>
      </v-card-text>
      <v-card-text>
        <v-row align="center">
          <v-col class="mt-n10" cols="12">
            new name
            <v-textarea v-model="name" auto-grow solo row-height="10" class="text-body-1"></v-textarea>
          </v-col>
        </v-row>
      </v-card-text>
      <v-card-text>
        <v-row align="center">
          <v-col class="mt-n10" cols="12">
            new Email
            <v-textarea v-model="email" auto-grow solo row-height="10" class="text-body-1"></v-textarea>
          </v-col>
        </v-row>
      </v-card-text>
      <v-card-text>
        <v-row align="center">
          <v-col class="mt-n10" cols="12">
            new Password
            <v-textarea v-model="member_pw" auto-grow solo row-height="10" value="" class="text-body-1"></v-textarea>
          </v-col>
        </v-row>
      </v-card-text>


      <v-divider></v-divider>
      <!-- comments v-if logged on-->
      <v-card-actions>
        <v-btn text @click="cancel">CANCEL</v-btn>
        <v-spacer></v-spacer>
        <v-btn text @click="done">DONE</v-btn>
      </v-card-actions>


    </v-card>
  </div>
</template>

<script>
import axios from "axios";
import {mapState} from "vuex";

export default {
  name: "MemberInfoChangePage",
  computed: {
    ...mapState(["member"])
  },
    data() {
      return {
        member_id: this.$store.state.member.member_id,
        email: this.$store.state.member.email,
        name: this.$store.state.member.name,
        member_pw: '',
        memberNo: this.$store.state.member.memberNo,
      }
    },
  methods: {
    cancel() {
      this.$router.push({name: 'MemberInfoPage'})
    },
    done() {
      const { memberNo, member_id, email, name, member_pw } = this
      axios.put(`http://localhost:7777/member/modify/${memberNo}`, { member_id, email, name, member_pw })
          .then(() => {
            alert('수정 성공!')
            this.$router.push({
              name: 'MemberInfoPage',
            })
          })
          .catch(err => {
            alert(err.response.data.message)
          })
    },
  }

}
</script>

<style scoped>

</style>
