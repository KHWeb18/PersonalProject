<template>
    <div>
        <v-spacer style="background-color: black;height: 90px;"></v-spacer>
        <v-container>
            <!-- <h1 class="board_title">회원가입</h1> -->
            <div class="title_image">
                <img src="@/assets/img/logo4.png" width="100" class="item">
            </div>
        <member-join-column-form @submit="onSubmit"/>
        <v-spacer></v-spacer>
        </v-container>
    </div>
</template>

<script>
import MemberJoinColumnForm from '@/components/member/MemberJoinColumnForm.vue'
import axios from 'axios'
export default {
    name: 'MemberJoinColumnPage',
    components: {
        MemberJoinColumnForm
    },
    methods: {
        onSubmit (payload) {
            const { userId, password, nickname, auth } = payload
            axios.post('http://localhost:7777/jpamember/register', {
                        userId, password, nickname, auth
                    })
                    .then(res => {
                        alert('가입 완료')                        
                        this.$router.push('/login')
                        console.log(res)
                    })
                    .catch(res => {
                        alert('아이디 중복!')
                        console.log(res)
                    })
        }
    }
}
</script>


<style scoped>
.title_image {
    display: flex;
    justify-content: center;
    margin: 30px;
}
.board_title {
    text-align: center;
    font-size: 32px;
    font-weight: 700;
    line-height: 32px;
    color: #333d4b;
}
</style>