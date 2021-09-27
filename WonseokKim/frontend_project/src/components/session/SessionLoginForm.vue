<template>
    <v-container>
        <form @submit.prevent="onSubmit">
            <v-card class="mx-auto"
                max-width="400">
        <v-img
            class="white--text align-end"
            height="200px"
            src="@/assets/img/seaside.jpeg">
        <v-card-title>로그인</v-card-title>
        </v-img>
        <v-card-text>
            <v-form ref="form">
                <v-col cols="12">
                    <v-text-field
                        type="text"
                        v-model="userId"
                        label="아이디*"
                        prepend-icon="mdi-account"
                        required>
                        </v-text-field>
                </v-col>
                <v-col cols="12">
                        <v-text-field
                        v-model="passwordCheck"
                        label="비밀번호*"
                        type="password"
                        prepend-icon="mdi-lock"
                        ></v-text-field>
                    </v-col>
                    <v-btn class="mt-3" color="green" outlined @click="onSubmit">
                        로그인
                    </v-btn>
                    <v-btn class="mt-3" color="red" outlined router-link :to="{ name: 'Home' }">
                        취소
                    </v-btn>
            </v-form>
        </v-card-text>
        </v-card>
        </form>
    </v-container>
</template>

<script>
export default {
    name: 'SessionLoginForm',
    data () {
        return {
            userId: '',
            passwordCheck: ''
        }
    },
    methods: {
        onSubmit () {
            const { userId, passwordCheck } = this
            this.$emit('submit', { userId, passwordCheck })
        }
    }
}

</script>