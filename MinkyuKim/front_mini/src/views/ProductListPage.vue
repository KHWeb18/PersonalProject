<template>
<v-container>
    <div id="board">
        <!--<h2>Vue + Spring + DB 상품 구현</h2>-->
        <!--<v-btn type="submit" @click="registerAuth">상품 등록</v-btn>-->
        <!--<router-link :to="{ name: 'ProductRegisterPage' }"> 상품 등록 </router-link>-->
        <!--<product-list :products="products"/>-->
        
        <!--
        <v-col class="text-right">
            <span>
                <h3>판매작품 목록</h3>   
        <v-btn type="submit" @click="registerAuth" >상품 등록</v-btn>  
            </span>        
        </v-col>
        -->
        <div style="float:left"><h3>판매작품 목록</h3></div>
        <div style="float:right; padding-top:50px;"><v-btn type="submit" @click="registerAuth" >상품 등록</v-btn></div>
        
            
        <product-list-test :products="products"/>
        
    </div>
</v-container>
</template>

<script>
//import ProductList from '@/components/product/ProductList.vue'
import { mapState, mapActions } from 'vuex'
import ProductListTest from '../components/product/ProductListTest.vue'

export default {
    name: 'ProductListPage',   
    /*props: {
        products: {
            type: Object            
        }       
    },*/ 
    components: {
        //ProductList,
        ProductListTest
        
    },
    computed: {
        ...mapState(['products']),
        
    },
    mounted () {
        this.fetchProductList()
        
    },
    methods: {
        ...mapActions(['fetchProductList']),
        registerAuth () {
            if (this.$store.state.session != null) {   
                this.$router.push({ name: 'ProductRegisterPage' })         
            } else {
                alert('로그인후 작성할 수 있습니다.')
                this.$router.push({ name: 'MemberLoginPage' })    
            }
            
        },  
        /*
        registerAuthh () {
            v-show="this.$store.state.session !== null && this.$store.state.session.userId === product.producer"

            memberAuth = this.$cookies.get('auth') && this.$store.state.session.userId =

            v-show="this.$store.state.session !== null && this.$store.state.session.userId === product.producer && this.$cookies.get('auth') == '판매회원'"
            v-show="this.$store.state.session !== null && this.$store.state.session.userId === product.producer && registerAuthh


            if(this.$store.state.session != null && this.$store.state. == '판매회원') {
            this.$router.push({ name: 'ProductRegisterPage' })
            } else {
                alert('판매회원만 작성가능합니다.')            
            }

        }*/
    }
}
</script>