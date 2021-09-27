<template>
    <v-container>
        <div align="center">
            <h2>회원 정보 수정</h2>
            <!--만약 product가 있다면 product를 바인딩 시키고 submit
                앞의 product는 data의 product, 뒤의 product는 props의 product-->
            <member-modify-form v-if="isLogin" :userInfo="userInfo" @submit="onSubmit"/>
            <p v-else>로딩중 .......</p>
        </div>
    </v-container>
</template>

<script>
import MemberModifyForm from '@/components/members/MemberModifyForm.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'
export default {
    name: 'MemberModifyPage',
    components: {
        MemberModifyForm
    },
    props: {
        userId: {
            type: String,
            //required: true
        }
    },
    computed: {
        ...mapState(['isLogin']),
        ...mapState(['member'])
    },
    methods: {
        ...mapActions(['fetchMember']),
        onSubmit (payload) {
            console.log("payload: " + JSON.stringify(payload))

            const { name, dateOfBirth, phoneNumber, email, address, gender, drawing, article, largeArtwork } = payload
            axios.put(`http://localhost:7777/member/${this.userId}`, { name, dateOfBirth, phoneNumber, email, address, gender, drawing, article, largeArtwork })
                    //${this.userId}
                    .then(res => {
                        alert('수정 성공!' + res)
                        console.log('상품 번호: ' + res.data.uesrId.toString())
                        // push의 경우 to의 역할과 같다.( router-link-to)
                        this.$router.push({
                            name: 'Home',                            
                        })
                    })
                    .catch(err => {                        
                        alert(err.response.data.message)
                    })
        }
    },
    created () {
        this.fetchMember(this.userId)
                .catch(err => {
                    alert(err.response.data.message)
                    this.$router.back()
                })
    }
}
</script>