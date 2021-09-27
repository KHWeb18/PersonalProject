<!-- <template>
    <v-container>
        <form @submit.prevent="onSubmit">
            <table>
                <tr>
                    <td>아이디</td>
                    <td><input type="text" v-model="id"></td>
                </tr>
                <tr>
                    <td>비밀번호</td>
                    <td><input type="password" v-model="pw"></td>
                </tr>
            </table>

            <div>
                <button type="submit">등록</button>
                <router-link :to="{ name: 'Home' }">
                    취소
                </router-link>
            </div>
        </form>
    </v-container>
</template>
-->

<!--
<template>
<body>
    <div>
        <h3 class="join_title">
            <label for="id">아이디</label>
        </h3>
        <span class="box int_id">
            <input type="text" id="id" v-model="id" class="int" maxlength="20">
            <span class="step_url"></span>
        </span>
        <span class="error_next_box"></span>
    </div>



    <div>
        <h3 class="join_title"><label for="pswd1">비밀번호</label></h3>
        <span class="box int_pass">
            <input type="text" id="pswd1" v-model="pw" class="int" maxlength="20">
            <span id="alertTxt">사용불가</span>
            <img src="@/assets/m_icon_pass.png" id="pswd1_img1" class="pswdImg">
        </span>
        <span class="error_next_box"></span>
    </div>

  
 
    <div>
        <h3 class="join_title"><label for="pswd2">비밀번호 재확인</label></h3>
        <span class="box int_pass_check">
            <input type="text" id="pswd2" class="int" maxlength="20">
            <img src="@/assets/m_icon_
            _disable.png" id="pswd2_img1" class="pswdImg">
        </span>
        <span class="error_next_box"></span>
    </div>

     <div class="btn_area">
                    <button type="button" id="btnJoin">
                        <span>로그인 하기</span>
                    </button>
                </div>


  

</body>


</template>
-->

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

<style>
html {
    height: 100%;
}

body {
    margin: 0;
    height: 100%;
    background: #f5f6f7;
    font-family: Dotum,'돋움',Helvetica,sans-serif;
}
#logo {
    width: 240px;
    height: 44px;
    cursor: pointer;
}

#header {
    padding-top: 62px;
    padding-bottom: 20px;
    text-align: center;
}
#wrapper {
    position: relative;
    height: 100%;
}

#content {
    position: absolute;
    left: 50%;
    transform: translate(-50%);
    width: 460px;
}
h3 {
    margin: 19px 0 8px;
    font-size: 14px;
    font-weight: 700;
}


.box {
    display: block;
    width: 100%;
    height: 51px;
    border: solid 1px #dadada;
    padding: 10px 14px 10px 14px;
    box-sizing: border-box;
    background: #fff;
    position: relative;
}

.int {
    display: block;
    position: relative;
    width: 100%;
    height: 29px;
    border: none;
    background: #fff;
    font-size: 15px;
}

input {
    font-family: Dotum,'돋움',Helvetica,sans-serif;    
}

.box.int_id {
    padding-right: 110px;
}

.box.int_pass {
    padding-right: 40px;
}



.step_url {
    /*@naver.com*/
    position: absolute;
    top: 16px;
    right: 13px;
    font-size: 15px;
    color: #8e8e8e;
}

.pswdImg {
    width: 18px;
    height: 20px;
    display: inline-block;
    position: absolute;
    top: 50%;
    right: 16px;
    margin-top: -10px;
    cursor: pointer;
}

#bir_wrap {
    display: table;
    width: 100%;
}

#bir_yy {
    display: table-cell;
    width: 147px;
    
}

#bir_mm {
    display: table-cell;
    width: 147px;
    vertical-align: middle;
}

#bir_dd {
    display: table-cell;
    width: 147px;
}

#bir_mm, #bir_dd {
    padding-left: 10px;
}

select {
    width: 100%;
    height: 29px;
    font-size: 15px;
    background: #fff url(https://static.nid.naver.com/images/join/pc/sel_arr_2x.gif) 100% 50% no-repeat;
    background-size: 20px 8px;
    -webkit-appearance: none;
    display: inline-block;
    text-align: start;
    border: none;
    cursor: default;
    font-family: Dotum,'돋움',Helvetica,sans-serif;
}

/* 에러메세지 */

.error_next_box {
    margin-top: 9px;
    font-size: 12px;
    color: red;    
    display: none;
}

#alertTxt {
    position: absolute;
    top: 19px;
    right: 38px;
    font-size: 12px;
    color: red;
    display: none;
}

/* 버튼 */

.btn_area {
    margin: 30px 0 91px;
}

#btnJoin {
    width: 100%;
    padding: 21px 0 17px;
    border: 0;
    cursor: pointer;
    color: #fff;
    background-color: #a4b3c9;
    font-size: 20px;
    font-weight: 400;
    font-family: Dotum,'돋움',Helvetica,sans-serif;
}
</style>