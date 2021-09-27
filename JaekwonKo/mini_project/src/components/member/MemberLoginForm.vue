<template>
    <div>
        <v-container class="font">
            <form @submit.prevent="onSubmit">
                        <h1>로그인</h1>&nbsp;&nbsp;
                        <ol>
                            <tr>아이디</tr>
                            <input class="form-control" type="text" v-model="userId" placeholder="아이디를 입력하세요." >&nbsp;
                            <tr>비밀번호</tr>
                            <input class="form-control" type="password" v-model="password" placeholder="비밀번호를 입력하세요." >
                        </ol>
                        <div>
                            <v-btn  x-large text type="submit" font-size="x-large">로그인</v-btn>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <v-btn x-large text>
                                <a class href="/">
                                    취소
                                </a>
                            </v-btn>
                        </div>
                        &nbsp;&nbsp;
                        <div class="singup">
                            아직 회원이 아니신가요?
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <v-btn x-large text>
                                    <a class href="/membership">
                                        회원가입
                                    </a>
                                </v-btn>
                        </div>
            </form>
        </v-container>
    </div>
</template>

<script>
export default {
    name: 'MemberLoginForm',
    data () {
        return {
            userId: '',
            password: ''
        }
    },
    methods: {
        onSubmit () {
            const { userId, password,} = this
            this.$emit('submit', { userId, password,})
        }
    }
}
</script>

<style scoped>
.font {
    text-align: center;
    font-size: x-large;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    height: max-content;
    width: max-content;
    background-color: white;
    opacity: 0.8;
}
h1 {
    text-align: center;
}
input::-ms-input-placeholder { color: rgb(7, 7, 7); }
input::-webkit-input-placeholder { color: rgb(12, 12, 12); }
input::-moz-placeholder { color: rgb(12, 12, 12); }
.singup{
    text-align: right;
    font-size: medium;
    font-size: 0.8em;
    
}
.v-btn{
    font-size: 0.8em;
    font-weight: bolder;
}


</style>