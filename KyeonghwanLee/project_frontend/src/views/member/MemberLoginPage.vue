<template>
  <div>
    <div align="center">
      <h2>Login</h2>
    </div>
    <member-login-form @submit="onSubmit" />
    <v-spacer></v-spacer>

    <v-btn tile color="teal" @click="showSession">
      <v-icon left>
        ads_click
      </v-icon>
      세션 보기
    </v-btn>
    <v-spacer></v-spacer>
    <v-btn tile color="teal" @click="removeSession">
      <v-icon left>
        ads_click
      </v-icon>
      세션 끊기
    </v-btn>
    <v-spacer></v-spacer>
    <v-btn tile color="teal" @click="logout" v-if="isLogin">
      <v-icon left>
        ads_click
      </v-icon>
      로그 아웃
    </v-btn>
  </div>
</template>

<script>
import MemberLoginForm from "@/components/member/MemberLoginForm.vue";
import { mapState, mapActions } from "vuex";
import Vue from "vue";
import cookies from "vue-cookies";
import axios from "axios";

Vue.use(cookies);

export default {
  name: "SessionLoginPage",
  components: {
    MemberLoginForm,
  },
  data() {
    return {
      isLogin: false,
    };
  },
  mounted() {
    // this.fetchSession()
    this.$store.state.session = this.$cookies.get("user");
    if (this.$store.state.session != null) {
      this.isLogin = true;
    }
  },
  computed: {
    ...mapState(["session"]),
  },
  methods: {
    ...mapActions(["fetchSession"]),
    onSubmit(payload) {
      if (this.$store.state.session == null) {
        const { email, password } = payload;
        axios
          .post("http://localhost:7777/jpasession/sign-in", { email, password })
          .then(res => {
            if (res.data.hashcode != null) {
              alert("로그인 성공! - " + res.data);
              this.isLogin = true;
              this.$store.state.session = res.data;
              this.$cookies.set("user", res.data, "1h");
              location.href = "/";
            } else {
              alert("로그인 실패! - " + res.data);
              this.isLogin = false;
            }
            /*
                            this.$router.push({
                                name: 'BoardReadPage',
                                params: { boardNo: res.data.boardNo.toString() }
                            })
                            */
          })
          .catch(res => {
            alert(res.response.data.message);
          });
      } else {
        alert(
          "이미 로그인 되어 있습니다 - 계정: " + this.$store.state.session.email
        );
      }
    },
    showSession() {
      if (this.isLogin == true) {
        axios
          .post("http://localhost:7777/jpamember/needSession")
          .then(res => {
            if (res.data == true) {
              alert("세션 정보 유지! - " + res.data);
            } else {
              alert("세션 정보 유지 안되는 중! - " + res.data);
            }
            /*
                            this.$router.push({
                                name: 'BoardReadPage',
                                params: { boardNo: res.data.boardNo.toString() }
                            })
                            */
          })
          .catch(res => {
            alert(res.response.data.message);
          });
      } else {
        alert("먼저 로그인부터 하세요!");
      }
    },
    removeSession() {
      axios.post("http://localhost:7777/jpamember/removeSession").then(res => {
        this.isLogin = res.data;
      });
    },
    logout() {
      this.$cookies.remove("user");
      this.isLogin = false;
      this.$store.state.session = null;
    },
  },
};
</script>

<style scoped>
h1,
h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}

.btn-lg {
  width: 100%;
}
</style>
