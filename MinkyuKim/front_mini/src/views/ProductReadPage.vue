<template>
    <v-container>
        <div align="center">
            <!--<h2>Vue + Spring + DB 상품 세부사항</h2>-->
            <product-read v-if="product" :product="product"/>
            <p v-else>로딩중 ...... </p>         
           
           <!--
           <div v-show="this.$store.state.session !== null && this.$store.state.session.userId === product.producer">
            <router-link  :to="{ name: 'ProductModifyPage', params: { productNo } }"> 상품 정보 수정 </router-link>
            <button @click="onDelete">상품 삭제</button>            
           </div>
            <router-link :to="{ name: 'ProductListPage' }"> 목록 돌아가기 </router-link>
            -->         
            <br>
            
        <div style="text-align:right; " v-show="this.$store.state.session !== null && this.$store.state.session.userId === product.producer">            
                <v-btn :to="{ name: 'ProductModifyPage', params: { productNo } }">
                    상품 정보 수정
                </v-btn>                
                <v-btn  @click="onDelete">
                    상품 삭제
                </v-btn>
            </div>
               
            <v-btn :to="{ name: 'ProductListPage' }">
                목록 돌아가기
            </v-btn>
            
        </div>        
    </v-container>        
</template>

<script>

import ProductRead from '@/components/product/ProductRead.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
    name: 'ProductReadPage',
    props: {
        productNo: {
            type: String,
            required: true
        }        

    },
    /*
    data () {
        return {
            userId: ''
        }
    },*/
    components: {
        ProductRead
    },
    computed: {
        ...mapState(['product']),
        ...mapState(['session'])
    },
    created () {
        this.fetchProduct(this.productNo)
                .catch(err => {
                    alert(err.response.data.message)
                    this.$router.push()
                })
    },  
    /*  
    mounted () {
        this.$store.state.session = this.$cookies.get("user") 
        
        },        
    */
    methods: {
        ...mapActions(['fetchProduct']),
        onDelete () {
            const { productNo } = this.product
            axios.delete(`http://localhost:7777/vueproduct/${productNo}`)
                    .then(() => {
                        alert('삭제 성공!')
                        this.$router.push({ name: 'ProductListPage' })
                    })
                    .catch(err => {
                        alert(err.response.data.message)
                    })
        },
        addCart () {
                alert('장바구니에 추가되었습니다.')
            }
        
    }
}
</script>