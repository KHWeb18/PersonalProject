<template>
    <v-container class="box0">
        <form @submit.prevent="onSubmit" style="width: 600px">            
            <div class="register_box">
                <div class="register_box_content">
                <h5 class="register_title">회원정보를 입력해 주세요</h5>
                <div class="row">
                <!-- <v-radio-group v-model="radioGroup" row="row" >
                    <v-radio 
                    color="light-blue lighten-1"
                    v-for="kinds in kindsOfMember" :key="kinds" :label="`${kinds}`"></v-radio>
                </v-radio-group> -->
                </div>
                <fieldset class="box1">
                    
                    <strong class="box_title">아이디</strong>
                    <div class="box2">
                        <input type="text" class="int" v-model="userId" 
                        placeholder="아이디" maxlength="16" @input="searchChangeFunc($event)"
                        >

                        <span class="validation">
                            <v-icon v-show='toggle' class="delete_all_btn" @click="deleteContent" tabindex="-1">highlight_off</v-icon>
                        </span>
                      
                    </div>
                      <span class="guide_messgage">
                            <ul v-show='toggle_friend'>
                                <li class="error_message">✘ 6자 이상의 영문 혹은 영문과 숫자를 조합</li>
                                <li class="error_line"></li>
                            </ul>
                             <ul v-show='toggle_friend_check'>
                                <li class="pass_message">✔ 6자 이상의 영문 혹은 영문과 숫자를 조합</li>
                                <li class="error_line_none"></li>
                            </ul>
                        </span>
                    <strong class="box_title">비밀번호</strong>
                    <div class="box2" style="margin-bottom:10px">
                        <input type="password" class="int" v-model="password" placeholder="비밀번호를 입력해주세요" 
                            maxlength="32" @input="searchChangeFunc2($event)"
                            >
                        <span class="validation">
                            <v-icon v-show='toggle2' class="delete_all_btn" @click="deleteContent2" tabindex="-1">highlight_off</v-icon>
                        </span>                        
                    </div>
                    <span class="guide_messgage2">
                        <ul v-show='toggle_friend2'>
                            <li class="error_message">✘ 8자 이상 입력</li>
                            <li class="error_line"></li>
                        </ul>
                        <ul v-show='toggle_friend_check2'>
                            <li class="pass_message">✔ 8자 이상 입력</li>
                            <li class="error_line_none"></li>
                        </ul>
                        <ul v-show='toggle_friend2_1'>    
                            <li class="error_message">✘ 영문/숫자/특수문자(공백 제외)만 허용하며, 특수문자를 포함하여 입력</li>
                            <li class="error_line" style="top:-47px"></li>
                        </ul>
                        <ul v-show='toggle_friend_check2_1'>    
                            <li class="pass_message">✔ 영문/숫자/특수문자(공백 제외)만 허용하며, 특수문자를 포함하여 입력</li>
                            <li class="error_line_none" style="top:-47px"></li>
                        </ul>
                    </span>
                    
                    <div class="box2">
                        <input type="password" class="int" v-model="password2" placeholder="비밀번호를 한번 더 입력해주세요" 
                            maxlength="32" @input="searchChangeFunc3()"
                            >
                        <span class="validation">
                            <v-icon v-show='toggle3' class="delete_all_btn" @click="deleteContent3" tabindex="-1">highlight_off</v-icon>
                        </span>
                        <p class="error_message"></p>
                    </div>
                    <span class="guide_messgage">
                        <ul v-show='toggle_friend3'>
                            <li class="error_message">✘ 동일한 비밀번호를 입력해주세요</li>
                            <li class="error_line"></li>
                        </ul>
                        <ul v-show='toggle_friend_check3'>
                            <li class="pass_message">✔ 동일한 비밀번호를 입력해주세요</li>
                            <li class="error_line_none"></li>
                        </ul>
                    </span>
                    <strong class="box_title">닉네임</strong>
                     <div class="box2">
                        <input type="text" class="int" v-model="nickname" 
                        placeholder="닉네임" maxlength="10" @input="searchChangeFunc4($event)">
                        <span class="validation" style="left: 85%">
                            <div v-show='toggle4' class="validation_with_length">
                                <div class="count_name">
                                {{ count_name }}/10
                                </div>
                                <div>
                                <v-icon class="delete_all_btn" @click="deleteContent4" tabindex="-1">highlight_off</v-icon>
                                </div>
                            </div>
                        </span>
                    </div>

                    <div class="button_box">
                        <v-btn width="300" color="light-blue lighten-1 text center" @click="onSubmit" class="item" >
                            등록
                        </v-btn>
                    </div>
                </fieldset>
                </div>
            </div>
        </form>
    </v-container>
</template>

<script>
export default {
    name: 'MemberJoinColumnTestForm',
    data () {
        return {
            // radioGroup: 1,
            kindsOfMember: [
                '일반유저',
                '운영자'
            ],
            userId: '',
            password: '',
            password2: '',
            nickname: '',
            toggle: false,            
            toggle2: false,
            toggle3: false,
            toggle4: false,
            count_name: 0,
            toggle_friend: false,
            toggle_friend2: false,
            toggle_friend2_1: false,
            toggle_friend3: false,

            toggle_friend_check: false,
            toggle_friend_check2: false,
            toggle_friend_check2_1: false,
            toggle_friend_check3: false,

            check01: false,
            check02: false,
            check03: false,


            errorMessages: '',
            name: null,
        }
    },
    methods: {
        onSubmit () {

            if (this.check01 & this.check02 & this.check03 == true) {
            const { userId, password, nickname } = this
            // const auth = radioGroup == 0 ? '일반유저' : '운영자'
            const auth = '일반유저'
            this.$emit('submit', { userId, password, nickname, auth })
            } else {
                alert('입력사항을 확인해주세요')
                

                return false
            }
            
        },
        deleteContent () {
            this.toggle = false
            this.userId = ''
            this.toggle_friend = true
            this.toggle_friend_check = false
        },
        deleteContent2 () {
            this.toggle2 = false
            this.password = ''
            this.toggle_friend2 = true
            this.toggle_friend_check2 = false
            this.toggle_friend2_1 = true
            this.toggle_friend_check2_1 = false
        },deleteContent3 () {
            this.toggle3 = false
            this.password2 = ''
            this.toggle_friend3 = true
            this.toggle_friend_check3 = false           
        },deleteContent4 () {
            this.toggle4 = false
            this.nickname = ''
            
        },
        searchChangeFunc(event){
            console.log(event.target.value)
            this.toggle = true
            this.toggle_friend = true
            if (this.userId == '') {
                this.toggle = false;
            }
            
            var checkUserId = this.userId,
            exp = /^[a-zA-Z0-9]*$/;
            var resultCheckUserId = exp.test(checkUserId);
            console.log(resultCheckUserId)

            if (resultCheckUserId) {
                if (checkUserId.length >= 6) {
                    console.log("6자리 이상 확인")
                    this.toggle_friend = false
                    this.toggle_friend_check = true
                    this.check01 = true
                }else {
                    this.toggle_friend_check = false
                    this.check01 = false
                }
            } else {
                this.toggle_friend = true
                this.toggle_friend_check = false
            }
        },
        searchChangeFunc2(event){
            console.log(event.target.value)
            this.toggle2 = true            
            this.toggle_friend2 = true
            this.toggle_friend2_1 = true
            if (this.password == '') {
                this.toggle2 = false;
            }

            var checkPassword = this.password,
            exp = /[~!@#$%^&*()_+|<>?:{}]/;
            var resultCheckPassword= exp.test(checkPassword);
            console.log(resultCheckPassword)

            if (checkPassword.length >= 8) {
                this.toggle_friend2 = false
                this.toggle_friend_check2 = true                
            }else {
                this.toggle_friend_check2 = false
            }
            
            if (resultCheckPassword) {
                this.toggle_friend2_1 = false
                this.toggle_friend_check2_1 = true
            }else {
                this.toggle_friend_check2_1 = false
            }

            if (this.toggle_friend_check2 & this.toggle_friend_check2_1 == true) {
                this.check02 = true
                console.log('두번째 체크도 통과')
            }else {
                this.check02 = false
            }
        },
        searchChangeFunc3(){
            this.toggle3 = true
            this.toggle_friend3 = true
            if (this.password2 == '') {
                this.toggle3 = false;
            }

            if (this.password == this.password2) {
                this.toggle_friend3 = false;
                this.toggle_friend_check3 = true
                this.check03 = true
            }else {
                this.toggle_friend_check3 = false
                this.check03 = false
            }
            
        },
        searchChangeFunc4(event){
            this.toggle4 = true
            if (this.nickname == '') {
                this.toggle4 = false;
            }
            this.count_name = event.target.value.length
        },
    },
    computed: {
        form () {
            return {
        name: this.name
            }
        }
    },
    watch: {
      name () {
        this.errorMessages = ''
      },
    }
}
</script> 


<style scoped>
.guide_messgage {
    display: block;
    position: relative;
    top: -30px;
    padding: 10px 0 9px;
    font-size: 12px;
    color: #666;
    line-height: 18px;
    word-break: break-all;
    letter-spacing: -.1px;
    clear: both;
}
.guide_messgage2 {
    display: block;
    position: relative;
    top: -10px;
    padding: 10px 0 9px;
    font-size: 12px;
    color: #666;
    line-height: 18px;
    word-break: break-all;
    letter-spacing: -.1px;
    clear: both;
}

input::placeholder {
    font-size: 13px;
    letter-spacing: 0;
    font-weight: 700;
    color:rgba(77, 77, 90, 0.747);
    /* font-style: 'a바람새L'; */
}
.row {
    padding-left: 10.5px;
    margin: 0px;
    font-size: 24px;
    line-height: 34px;
    color: red;
    font-weight: normal;
}
.count_name {
    display: inline;
    min-width: 37px;
    text-align: right;
    margin-top: 3px;
    color: #b6b6b6;
    cursor: auto;
}
.register_box {
    border: 2px #b6b6b6 solid;
    border-left: 0px;
    border-right: 0px;
    width: 600px;
    height: 850px;

}
.register_box_content {
    padding: 60px;
    padding-top: 30px;
}
.register_title {
    padding: 10.5px;
    font-size: 24px;
    line-height: 34px;
    color: #252525;
    font-weight: normal;
}
.box_title {
    display: block;
    font-size: 12px;
    color: #000000;
    font-weight: 700;
    margin-top: 20px;
    margin-left: 2px;
}
.box0 {
    width: 600px;
    padding: 0px;
}
.box1 {
    border: 0;
}
.box2 {
    height: 43px;
    margin-bottom: 30px;
}
.int {
    display: block;
    position: relative;    
    letter-spacing: 2px;
}
.validation {
    position: relative;
    top: -40px; left: 94%;
    cursor: pointer;
    height: 2px;
}
.validation_with_error {
    position: relative;
    top: -74px; left: 94%;
    cursor: pointer;
    height: 2px;
}
.validation_with_length {
    width: 65px;
    display: flex;
    justify-content: space-between;
}
.delete_all_btn {
    display: inline-block;
    visibility:inherit;
}
.delete_all_btn2 {
    display: inline-block;
    visibility:inherit;
}
.item {
    font: 12pt;
    color: white;
    font-weight: 800;
}
.item_list {
    margin-top: 10px;
    display: flex;
}
.button_box_for_line {
    margin: 40px;
}
.button_box {
    display: flex;
    margin: 50px;
    margin-top: 50px;
    margin-bottom: 30px;
    justify-content:center;
}
.v-btn {
    margin-right: 10px;
}
.error_message {
    color: rgba(214, 3, 3, 0.856);
    font-size: 8pt;
    font-weight: 500;
}
.pass_message {
    color: #3CA03C;
    font-size: 8pt;
    font-weight: 500;
}
.error_line {
    position: relative; 
    height: 2px;
    top:-27px;
    border-top: 2px rgba(214, 3, 3, 0.856) solid;
}
.error_line_none {
    position: relative; 
    height: 2px;
    top:-27px;
    border-top: 2px transparent;
}
    
</style>