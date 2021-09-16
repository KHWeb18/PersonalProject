<template>
    <div id="container">
        <v-container>
            <form @submit.prevent="onSubmit">
                <v-radio-group v-model="radioGroup" row>
                    <v-radio v-for="kinds in kindsOfMember" :key="kinds" :label="`${kinds}`"> 
                    </v-radio>
                </v-radio-group>
                <table>
                    <v-text-field class="pl-3 pr-3" :rules="emailRules" required v-model="email"
                                label="이메일" type="email" prepend-icon="mdi-email" flat solo>
                    </v-text-field>
                    <v-text-field class="pl-3 pr-3" :rules="nameRules" required v-model="userName"
                                label="이름" type="text" prepend-icon="mdi-account" flat solo>
                    </v-text-field>
                    <v-text-field class="pl-3 pr-3" :rules="passwordRules" required v-model="password"
                                label="비밀번호" type="password" prepend-icon="mdi-lock" flat solo>
                    </v-text-field> 
                    <v-text-field class="pl-3 pr-3" :rules="passwordConfirmRules" required v-model="passwordConfirm"
                                label="비밀번호 확인" type="password" prepend-icon="mdi-lock" flat solo>
                    </v-text-field>
                </table>
                <div>
                    <v-btn class="mt-3" color="" button type="submit">회원가입</v-btn>
                </div>
            </form>
        </v-container>
    </div>
</template>

<script>

import { mapState } from 'vuex'

export default {
    name: 'MemberRegisterForm',
    data () {
        return {
            radioGroup: 1,
            kindsOfMember: [
                '개인',
                '관리자'
            ],
            email: '',
            userName: '',
            password: '',
            passwordConfirm: '',
            passwordConfirmRules: [
            v => !!v || '비밀번호를 작성해주세요.',
            v => v === this.password || '패스워드가 일치하지 않습니다' 
            ]
        }
    },
    computed: {
        ...mapState ([
            'emailRules',
            'nameRules',
            'passwordRules'
        ])  
    },
    methods: {
        onSubmit () {
            const { email, userName, password, passwordConfirm, radioGroup  } = this
            const auth = radioGroup == 0 ? '개인' : '관리자'
            this.$emit('submit', { email, userName, password, passwordConfirm, auth })
        },
    }
}
</script> 

<style scoped>
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

#container {
    margin: 0 auto;
    width: 1200px;
}
</style>