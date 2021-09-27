<template>
    <div id="gongzi">
      
        <gongzi-list :gongzis="gongzis"/>
        <v-btn @click="GongziRegister" v-if="isAuth">공지작성</v-btn>
        
    </div>
</template>

<script>
import GongziList from '@/components/gongzi/GongziList.vue'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'GongziListPage',
    components: {
        GongziList
    },
    data() {
        return{
            isAuth: false
        }
    },
    computed: {
        ...mapState(['gongzis'])
    },
    mounted () {
        this.fetchGongziList()
    },
    beforeUpdate () {  
       
        this.$store.state.session = this.$cookies.get("user")
        if (this.$store.state.session.auth == '관리자') {
            this.isAuth = true
        
    }
    
    },
    methods: {
        ...mapActions(['fetchGongziList']),
        GongziRegister() {
            this.$router.push('/gongzi')
        }
    }
}
</script>