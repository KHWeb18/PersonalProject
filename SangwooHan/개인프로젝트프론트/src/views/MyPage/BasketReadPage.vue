<template>
    <div>
        <v-container>
            <my-information-menu/>
        <basket-read-form v-if="this.$store.state.User !=null" :BasketList="BasketList"/>
        <p v-else>로그인후 이용해주세요!</p>
        </v-container>
    </div>
</template>

<script>
import {mapActions,mapState} from 'vuex'
import MyInformationMenu from '../../components/MyPage/MyInformationMenu.vue'
import BasketReadForm from '../../components/ShoppingMall/BasketReadForm.vue'
export default {
  components: { BasketReadForm, MyInformationMenu },
    name: 'BasketReadPage',
    props:{
        memberNo:{
            type:String,
            required: true
        }
    },
    computed:{
        ...mapState(['BasketList'])
    },
    methods: {
        ...mapActions(['fetchBasketList'])
    },
    created() {
        this.fetchBasketList(this.memberNo)
    },
}
</script>