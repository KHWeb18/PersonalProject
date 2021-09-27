<template>
  <div class="login_wrap">
    <section class="myPage-form">
      <h1>내 정보</h1>
      <form action="">
        <div class="int-area">
          <label for="uid">아이디</label>
          <input
              type="text"
              name="uid"
              id="uid"
              maxlength="15"
              minlength="2"
              v-model="uid"
              autocomplete="off"
              required
              disabled
          >
        </div>

        <div class="int-area">
          <label for="pw">비밀번호</label>
          <input
              type="password"
              autocomplete="off"
              required
              minlength="8"
              name="pw"
              id="pw"
              v-model="password"
          >
          <div class="myPage_btn">
            <!--            <button @click="onclickMyPage()">수정</button>-->
          </div>
        </div>


        <div class="int-area">
          <label for="nickname">닉네임</label>
          <input
              type="text"
              name="nickname"
              id="nickname"
              maxlength="15"
              minlength="2"
              v-model="nickname"
              autocomplete="off"
              required
          >
          <div class="myPage_btn">
            <!--            <button @click="onclickMyPage()">수정</button>-->
          </div>
        </div>

        <div class="int-area">
          <label for="email">이메일</label>
          <input
              type="text"
              name="email"
              id="email"
              maxlength="15"
              minlength="2"
              v-model="email"
              autocomplete="off"
              required
          >

        </div>

      </form>

      <div class="myPage_btn">
        <button @click="onclickMyPage()">수정</button>
      </div>
    </section>
  </div>


</template>

<script>
import api from "../api/api";

export default {
  name: 'MyPage',
  async mounted() {
    await api.get(`/user/${this.$store.state.userInfo.id}`)
        .then((res) => {
          this.uid = res.data.data.userId;
          this.password = res.data.data.password;
          this.nickname = res.data.data.nickname;
          this.email = res.data.data.email;
        })
        .catch((e) => {
          console.log(e);
        });
  },
  data() {
    return {
      uid: '',
      password: '',
      nickname: '',
      email: '',
    }
  },
  methods: {
    async onclickMyPage() {
      await api.post(`/user/${this.$store.state.userInfo.id}`, {
        password: this.password,
        nickname: this.nickname,
        email: this.email,
      })
          .then((res) => {
            if (res) {
              alert('회원 정보 수정 완료');
            }
          }).catch((e) => {
            console.log(e);
            alert('회원 정보 수정 실패');
          })
    }
  }
};
</script>

<style scoped>

.myPage-form > h1 {
  font-size: 33px;
  color: rgb(229, 119, 175);
  font-family: 'Gowun Dodum', sans-serif;
  font-weight: bold;
}

.int-area {
  margin-top: 25px;
}

.int-area > label {
  font-weight: bold;
  font-family: 'Gowun Dodum', sans-serif;
  font-size: 17px;
}

.myPage_btn button {
  border: 1px solid #333;
  padding: 3px 5px;
}


</style>
