<template>
  <div class="signup_wrap">
    <section class="signup-form">
      <h1>회원가입</h1>
        <div class="int-area">
          <label for="uid">아이디</label>
          <div class="id_description">
            아이디는 5글자 이상으로 입력해주세요.
          </div>
          <input
              type="text"
              placeholder="아이디"
              autocomplete="off"
              required name="uid"
              id="uid"
              v-model="uid"
          >
        </div>

        <div class="int-area">
          <label for="pw">비밀번호</label>
          <div class="pw_description">
            8자 이상의 비밀번호를 입력해주세요.
          </div>
          <input
              type="password"
              placeholder="비밀번호"
              autocomplete="off"
              required
              minlength="8"
              name="pw"
              id="pw"
              v-model="password"
          >
        </div>

        <div class="int-area">
          <label for="confirmPassword">비밀번호 확인</label>
          <input type="password" placeholder="비밀번호 확인" autocomplete="off" required name="confirmPassword"
                 id="confirmPassword" v-model="password2">
        </div>

        <div class="int-area">
          <label for="nickname">닉네임</label>
          <div class="nick_description">다른 유저와 겹치지 않는 별명을 입력해주세요. (2자~15자)</div>
          <input
              type="text"
              name="nickname"
              id="nickname"
              placeholder="별명 (2자~15자)"
              maxlength="15"
              minlength="2"
              v-model="nickname"
              autocomplete="off"
              required
          >
        </div>

        <div class="int-area">
          <label class="email_label" for="email">이메일</label>

          <div class="email_input">
                        <span class="email_lacal">
                            <input
                                type="text"
                                placeholder="이메일"
                                autocomplete="off"
                                required
                                name="email"
                                id="email"
                                v-model="email"
                            >
                        </span>
            <!--                        <span class="email_separator">@</span>-->
            <!--                        <span class="email_domain">-->
            <!--                            <select class="form-control empty">-->
            <!--                                <option value="" disabled="">선택해주세요</option>-->
            <!--                                <option value="naver.com">naver.com</option>-->
            <!--                                <option value="hanmail.net">hanmail.net</option>-->
            <!--                                <option value="daum.net">daum.net</option>-->
            <!--                                <option value="gmail.com">gmail.com</option>-->
            <!--                                <option value="nate.com">nate.com</option>-->
            <!--                                <option value="hotmail.com">hotmail.com</option>-->
            <!--                                <option value="outlook.com">outlook.com</option>-->
            <!--                                <option value="icloud.com">icloud.com</option>-->
            <!--                                <option value="_manual">직접입력</option>-->
            <!--                            </select>-->
            <!--                        </span>-->
          </div>

        </div>

        <!--                <div class="email_btn">-->
        <!--                    <v-btn>이메일 인증하기</v-btn>-->
        <!--                </div>-->


        <div class="btn-area">
          <button @click="onclickSignUp">회원가입</button>
        </div>

    </section>
  </div>
</template>

<script>
import {validateEmail} from "../assets/js/validation.js";
import api from "../api/api";
export default {
  name: "SignUp",
  data() {
    return {
      uid: '',
      password: '',
      password2: '',
      nickname: '',
      email: '',
    }
  },
  methods: {
    async onclickSignUp() {
      const validate = this.validation();
      if (validate) {
        console.log(validate);
        await api.post(`/user/signup`, {
          userId: this.uid,
          password: this.password,
          nickname: this.nickname,
          email: this.email,
        })
          .then((res) => {
            if (res.data.resultCode == "SUCCESS") {
              alert("회원가입이 완료 되었습니다. 로그인 하세요.");
              this.$router.push({name: "Login"});
            } else {
              alert(res.data.message);
            }
          })
        .catch((e) => {
          console.log(e);
        })
      } else {
        return;
      }
    },

    validation() {
      if (!this.uid || this.uid.length < 5 || this.uid.length > 15) {
        alert('아이디를 확인해주세요. 아이디는 5글자 이상이어야 합니다.');
        return false;
      }

      if (this.password !== this.password2) {
        alert('비밀번호가 일치하지 않습니다. 다시 확인해주세요.');
        return false;
      }

      if (this.password === this.password2 && (this.password.length < 8 && this.password2.length < 8)) {
        alert('비밀번호는 8자리 이상이어야 합니다.');
        return false;
      }

      if (!this.nickname || this.nickname.length < 2 || this.nickname.length > 15) {
        alert('닉네임을 확인해주세요.');
        return false;
      }

      if (!this.email) {
        alert('이메일을 입력해주세요.');
        return false;
      }

      if (!validateEmail(this.email)) {
        alert('이메일 양식이 잘못 되었습니다. 다시 확인해주세요.');
        return false;
      }
      return true;
    }
  }
}


</script>

<style scoped>

.signup_wrap {
  height: 80vh;
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  align-items: center;

  /*flex-direction: column;*/
  /*justify-content: center;*/
  /*align-content: space-between;*/
}

.signup-form {

}

.signup-form > h1 {
  font-size: 33px;
  color: rgb(229, 119, 175);
  font-family: 'Gowun Dodum', sans-serif;
  font-weight: bold;
}

.int-area {
  /*width: 500px;*/
  margin-top: 25px;
}

.int-area > label {
  font-weight: bold;
  font-family: 'Gowun Dodum', sans-serif;
  font-size: 17px;
}

.id_description,
.pw_description,
.nick_description {
  font-size: 13px;
  font-family: 'Gowun Dodum', sans-serif;
}

.int-area input {
  width: 100%;
  padding: 15px 10px;
  border: none;
  border: 1px solid rgb(204, 204, 204);
  outline: none;
  font-size: 15px;
  font-family: 'Gowun Dodum', sans-serif;
}

.btn-area button {
  width: 340px;
  height: 50px;
  color: #333;
  background-color: rgb(236, 152, 195);
  border: none;
  border-radius: 5px;
  font-size: 20px;
  font-family: 'Gowun Dodum', sans-serif;
}

</style>
