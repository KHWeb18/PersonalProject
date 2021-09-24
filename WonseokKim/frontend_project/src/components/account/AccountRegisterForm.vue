<template>
<v-container>
    <form @submit.prevent="onSubmit">
        <v-card class="mx-auto"
                max-width="400">
        <v-img
            class="white--text align-end"
            height="200px"
            src="@/assets/img/friends.jpeg">
        <v-card-title>회원가입</v-card-title>
        </v-img>
        <v-card-text>
            <v-form ref="form">
                <v-col cols="12">
                    <v-text-field
                        type="text"
                        v-model="userId"
                        label="아이디*"
                        :rules="user_id_rule"
                        :disabled="state == 'ins' ? false : true"
                        prepend-icon="mdi-account"
                        required>
                        </v-text-field>
                </v-col>
                    <v-col cols="12">
                        <v-text-field
                        v-model="password"
                        label="비밀번호*"
                        type="password"
                        :rules="user_pw_rule"
                        prepend-icon="mdi-lock"
                        ></v-text-field>
                    </v-col>
                    <v-col cols="12">
                        <v-text-field
                        v-model="passwordCheck"
                        label="비밀번호 확인*"
                        type="password"
                        :rules="user_pw_rule2"
                        prepend-icon="mdi-lock"
                        ></v-text-field>
                    </v-col>
                    <v-col cols="12">
                        <v-text-field
                        type="text"
                        v-model="userName"
                        label="이름*"
                        :rules="user_nm_rule"
                        prepend-icon="mdi-account-check"
                        required></v-text-field>
                    </v-col>
                    <v-col cols="12">
                    <v-text-field
                        v-model="userEmail"
                        label="이메일*"
                        :rules="user_email_rule"
                        type="email"
                        prepend-icon="mdi-email"
                        required></v-text-field>
                    </v-col>
                    <v-btn class="mt-3" color="green" outlined @click="onSubmit">
                        회원가입
                    </v-btn>
                    <v-btn class="mt-3" color="red" outlined router-link :to="{ name: 'Home' }">
                        가입취소
                    </v-btn>
            </v-form>
        </v-card-text>
        </v-card>
    </form>
</v-container>

</template>

<script>

export default {
    name: 'RegisterForm',
    data () {
        return {
            dialog:false,
            state: 'ins',
            userId: '',
            user_id_rule: [
                v => !!v || '아이디는 필수 입력사항입니다.',
                v => /^[a-zA-z0-9]*$/.test(v) || '아이디는 영문+숫자만 입력 가능합니다.',
                v => !( v && v.length >= 10) || '아이디는 10자 이상 입력할 수 없습니다.'
            ],
            userName: '',
            user_nm_rule: [
                v => !!v || '이름은 필수 입력사항입니다.',
                v => !( v && v.length <= 1) || '이름은 1글자 이상 입력해주세요.',
                v => !/[~!@#$%^&*()_+|<>?:{}]/.test(v) || '이름에는 특수문자를 사용할 수 없습니다.'
            ],
            password: '',
            passwordCheck: '',
            user_pw_rule: [
                v => this.state === 'ins' ? !!v || '패스워드는 필수 입력사항입니다.' : true,
                v => !( v && v.length >= 10) || '비밀번호 10자 이상 입력할 수 없습니다.',
            ],
            user_pw_rule2: [
                v => this.state === 'ins' ? !!v || '패스워드는 필수 입력사항입니다.' : true,
                v => !( v && v.length >= 10) || '아이디는 10자 이상 입력할 수 없습니다.',
                v => v === this.password || '비밀번호가 일치하지 않습니다.'
            ],
            userEmail: '',
            user_email_rule: [
                v => !!v || '이메일을 작성해주세요.',
                v => /.+@.+\..+/.test(v) || '이메일 형식으로 작성해주세요.'
            ]
        }
    },
    methods: {
        onSubmit () {
            const { userId, passwordCheck, userName, userEmail } = this
            this.$emit('submit', { userId, passwordCheck, userName, userEmail })
        }
    }
}
</script>