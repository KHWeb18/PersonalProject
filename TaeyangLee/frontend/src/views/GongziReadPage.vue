<template>
    <div align="center">
        <h2>공지사항</h2>
        <gongzi-read v-if="gongzi" :gongzi="gongzi"/>
        <p v-else>로딩중 ...... </p>
        <div v-if="isAuth">
        <router-link :to="{ name: 'GongziModifyPage', params: { gongziNo } }">
            게시물 수정
        </router-link>
       
        <button @click="onDelete">삭제</button>
        </div>
        <router-link :to="{ name: 'GongziListPage' }">
            게시물 보기
        </router-link>
        
    </div>
</template>

<script>
import GongziRead from '@/components/gongzi/GongziRead.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'
export default {
    name: 'GongziReadPage',
    props: {
        gongziNo: {
            type: String,
            required: true
        }
    },
    data() {
        return {
            isAuth: false
        }
    },
    components: {
        GongziRead
    },
    computed: {
        ...mapState(['gongzi'])
    },
    created () {
        this.fetchGongzi(this.gongziNo)
                .catch(err => {
                    alert(err.response.data.message)
                    this.$router.push()
                })
    },
     beforeUpdate () {  
       
        this.$store.state.session = this.$cookies.get("user")
        if (this.$store.state.session.auth == '관리자') {
            this.isAuth = true
        
    }
    
    },
    methods: {
        ...mapActions(['fetchGongzi']),
        onDelete () {
            const { gongziNo } = this.gongzi
            axios.delete(`http://localhost:7777/gongzi/${gongziNo}`)
                .then(() => {
                    alert("삭제 성공!")
                    this.$router.push({name: 'GongziListPage' })
                })
                .catch(err => {
                    alert(err.response.data.message)
                })
        }
    
    }
}
</script>