<template>
    <div>
        <v-container>
            <my-information-menu/>
    <my-product-status-form  v-if="this.$store.state.session = true" :listArray="UserOrderList"/>
    <p v-else>로그인후 이용해주세요</p>
   <!-- <v-btn @click="check">확인</v-btn> -->
        </v-container>
    </div>
</template>

<script>
import MyProductStatusForm from '../../components/MyPage/MyProductStatusForm.vue'
import { mapActions, mapState } from 'vuex'
import MyInformationMenu from '../../components/MyPage/MyInformationMenu.vue'



export default {
    name: 'MyProductStatus',
    components:{
        MyProductStatusForm,
        MyInformationMenu,
        
    },
    props:{
            User:{
                type:String,
                required: true
            }
    },
    computed: {
        ...mapState(['UserOrderList'])
    },
    methods:{
        ...mapActions(['fetchUserOrderList']),
        check(){
            console.log(this.UserOrderList)
        }
    },
    created(){
        this.fetchUserOrderList(this.User)
    }

}
</script>