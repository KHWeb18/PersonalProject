<template>
    <v-container class="box0">
        <form @submit.prevent="onSubmit">
                <div class="register_box_content">
                <fieldset class="box1">                    
                    <div class="box2">
                        <input type="text" class="int" v-model="userId" 
                        placeholder="아이디" maxlength="16" @input="searchChangeFunc($event)">
                        <span class="validation">
                            <v-icon v-show='toggle' class="delete_all_btn" @click="deleteContent" tabindex="-1">highlight_off</v-icon>
                        </span>
                    </div>
                    <div class="box2">
                        <input type="password" class="int" v-model="password" placeholder="비밀번호" 
                            maxlength="32" @input="searchChangeFunc2($event)" v-on:keyup.enter="onSubmit">
                        <span class="validation">
                            <v-icon v-show='toggle2' class="delete_all_btn" @click="deleteContent2" tabindex="-1">highlight_off</v-icon>
                        </span>                        
                    </div>                 
                    
                    <div class="button_box" style="margin-bottom: 15px">
                        <v-btn v-show="onLoginBtn"
                        color="light-blue lighten-1 text center" @click="onSubmit" class="item" >
                            로그인
                        </v-btn>
                        <v-btn  v-show="!onLoginBtn"
                        disabled 
                        depressed
                        color="light-blue lighten-1 text center" @click="onSubmit" class="item" >
                            로그인
                        </v-btn>
                    </div>
                    <div class="button_box" style="margin-top: 0px;">
                        <router-link to="/register">
                        <v-btn color="transparent" class="item" style="color: #29B6F6;">
                            회원가입
                        </v-btn>
                        </router-link>
                    </div>
                </fieldset>
            </div>
        </form>
    </v-container>
</template>

<script>
export default {
    name: 'GameMemberLoginForm',
    data () {
        return {
            userId: '',
            password: '',
            toggle: false,            
            toggle2: false,
            
            toggle_friend: false,
            toggle_friend2: false,

            check1: false,
            check2: false,

            onLoginBtn: false

        }
    },
    methods: {
        onSubmit () {
            const { userId, password } = this
            this.$emit('submit', { userId, password })
        },
        deleteContent () {
            this.toggle = false
            this.check1 = false
            this.userId = ''
            this.onLoginBtn = false
        },
        deleteContent2 () {
            this.toggle2 = false
            this.check2 = false
            this.password = ''
            this.onLoginBtn = false
        },
        searchChangeFunc () {
            // console.log(event.target.value) 쓸 거면 위에 ()에 event 넣어
            this.toggle = true
            if (this.userId == '') {
                this.toggle = false;
                this.check1 = false;
                this.onLoginBtn = false;
            } else {
                this.check1 = true
            }
            if (this.check1 & this.check2 == true) {
                this.onLoginBtn = true;
                console.log(this.onLoginBtn)
            } else if(this.check1 || this.check2 == false) {
                this.onLoginBtn = false;
            }
        },
        searchChangeFunc2 () {
            // console.log(event.target.value) 
            this.toggle2 = true
            this.check2 = true
            if (this.password == '') {
                this.toggle2 = false;
                this.check2 = false;
                this.onLoginBtn = false;
            }
            if (this.check1 & this.check2 == true) {
                this.onLoginBtn = true;
                console.log(this.onLoginBtn)
            } else if(this.check1 == false) {
                this.onLoginBtn = false;
            }
        },
        enterLogin () {
            if (window.event.keycode == 13) {
                onsubmit()
            }
        }
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
.register_box_content {
    display: flex;
    justify-content: center;
    padding: 20px;
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
    display: flex;
    justify-content: center;
    width: 600px;
    padding: 0px;
}
.box1 {
    border: 0px;

}
.box2 {
    height: 43px;
    width: 100%;
    margin: 0px;
    margin-bottom: 30px;
    padding-left: 50px;
    padding-right: 50px;
}
.int {
    display: block;
    position: relative;    
    letter-spacing: 2px;    
}
.validation {
    position: relative;
    top: -38px; left: 91%;
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
    width: 310px;
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
    width: 310px;
    margin: 50px;
    margin-top: 50px;
    margin-bottom: 30px;
    justify-content:center;
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