<template>
    <div style="position: relative;min-height:900px;">
        <v-spacer style="background-color: black;height: 90px;"></v-spacer>
        <div class="box0">
            <div class="title_image">
                <img src="@/assets/img/logo4.png" width="100" class="item"></div>
            </div>
        <member-profile-form @submit="onSubmit"/>
        <v-spacer></v-spacer>        
    </div>
</template>


<script>

import MemberProfileForm from '@/components/member/MemberProfileForm.vue'
import axios from 'axios'

export default {
    name: 'MemberProfilePage',
    components: {
        MemberProfileForm
    },
    data () {
        return {            
        }
    },
    methods: {
        onSubmit (payload) {            
            const { userId, nickname, password } = payload
            axios.put(`http://localhost:7777/jpamember/${this.$store.state.yourId}`, { userId, nickname, password })
                    .then(res => {
                        if (res.data != "") {
                            alert('변경 성공! - ' + res.data)
                            console.log(res.data)
                            this.$store.state.yourNickname = res.data.nickname
                        } else {
                            alert('변경 실패! - ' + res.data)
                        }
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                        alert('잘못된 접근! 로그인부터 해주세요')
                    })
        }
    }
}
</script>


<style scoped>
.background_image {
    background-repeat: no-repeat;
    background-position: 40% 0;
    background-size: auto;
}
.title_image {
    display: flex;
    justify-content: center;
    margin: 30px;
    margin-bottom: 0px;
    margin-top: 120px;
    padding-bottom: 20px;
    width: 50vw;
    border-bottom: 1px solid #BDBDBD;
}
.board_title {
    text-align: center;
    font-size: 32px;
    font-weight: 700;
    line-height: 32px;
    color: #333d4b;
    margin-bottom: 60px;
}
.box0 {
    display: flex;
    justify-content: center;
}
</style>