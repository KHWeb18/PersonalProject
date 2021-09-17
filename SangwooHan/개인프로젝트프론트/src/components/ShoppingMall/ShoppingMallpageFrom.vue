<template>
<div>
    <shopping-mall-menu-bar :ProductList="ProductList"/>
    검색<input type="text" v-model="search"/>
   <v-container>
        <ul>
            <li  v-for="product in ProductList" :key="product.productName">
               
                <img width="300px" v-if="product.productName =='[사슴벌레용]발효톱밥5L'&&product.productName.includes(search)" src="@/assets/상우/발효톱밥.jpg"/>
                <img width="300px" v-if="product.productName =='[장수풍뎅이]발효톱밥5L'&&product.productName.includes(search)" src="@/assets/상우/발효톱밥.jpg"/>
                <img width="300px" v-if="product.productName =='산란목'&&product.productName.includes(search)" src="@/assets/상우/산란목.jpg"/>
                <img width="300px" v-if="product.productName =='발효톱밥5L'&&product.productName.includes(search)" src="@/assets/상우/발효톱밥.jpg"/>
                <img width="300px" v-if="product.productName =='균사'&&product.productName.includes(search)" src="@/assets/상우/균사.jpg"/>
                <img width="300px" v-if="product.productName =='곤충젤리100개'&&product.productName.includes(search)" src="@/assets/상우/수액젤리.jpg"/>
                <img width="300px" v-if="product.productName =='곤충이끼'&&product.productName.includes(search)" src="@/assets/상우/곤충이끼.jpg"/>
                <img width="300px" v-if="product.productName =='오호히라균사'&&product.productName.includes(search)" src="@/assets/상우/균사.jpg"/>
                <img width="300px" v-if="product.productName =='레벤지균사'&&product.productName.includes(search)" src="@/assets/상우/균사.jpg"/>
                <img width="300px" v-if="product.productName =='놀이목'&&product.productName.includes(search)" src="@/assets/상우/놀이목.jpg"/>
                <img width="300px" v-if="product.productName =='광구병'&&product.productName.includes(search)" src="@/assets/상우/광구병.jpg"/>
                <img width="300px" v-if="product.productName =='오호히라균사묶음6개'&&product.productName.includes(search)" src="@/assets/상우/균사묶음.jpg"/>
                <img width="300px" v-if="product.productName =='균사스푼'&&product.productName.includes(search)" src="@/assets/상우/균사스푼.jpg"/>
                <img width="300px" v-if="product.productName =='일반균사묶음6개'&&product.productName.includes(search)" src="@/assets/상우/균사묶음.jpg"/>
                <img width="300px" v-if="product.productName =='사육케이스특대'&&product.productName.includes(search)" src="@/assets/상우/사육케이스.jpg"/>
                <img width="300px" v-if="product.productName =='사육케이스대'&&product.productName.includes(search)" src="@/assets/상우/사육케이스.jpg"/>
                <img width="300px" v-if="product.productName =='사육케이스중'&&product.productName.includes(search)" src="@/assets/상우/사육케이스.jpg"/>
                <img width="300px" v-if="product.productName =='사육케이스소'&&product.productName.includes(search)" src="@/assets/상우/사육케이스.jpg"/>
                <img width="300px" v-if="product.productName =='먹이접시1구'&&product.productName.includes(search)" src="@/assets/상우/먹이접시1구.jpg"/>
                <img width="300px" v-if="product.productName =='먹이접시2구'&&product.productName.includes(search)" src="@/assets/상우/먹이접시2구.jpg"/>
                <img width="300px" v-if="product.productName =='[사슴벌레용]발효톱밥5L묶음6개'&&product.productName.includes(search)" src="@/assets/상우/발효톱밥묶음.jpg"/>
                <img width="300px" v-if="product.productName =='[장수풍뎅이]발효톱밥5L묶음6개'&&product.productName.includes(search)" src="@/assets/상우/발효톱밥묶음.jpg"/>
                <img width="300px" v-if="product.productName =='유산균젤리100개'&&product.productName.includes(search)" src="@/assets/상우/유산균젤리.jpg"/>
                <img width="300px" v-if="product.productName =='유충병고급'&&product.productName.includes(search)" src="@/assets/상우/유충병고급.jpg"/>
                <img width="300px" v-if="product.productName =='온도계스티커'&&product.productName.includes(search)" src="@/assets/상우/온도계스티커.jpg"/>
                <img width="300px" v-if="product.productName =='장수풍뎅이세트'&&product.productName.includes(search)" src="@/assets/상우/장수풍뎅이세트.jpg"/>
                <img width="300px" v-if="product.productName =='왕사슴벌레세트'&&product.productName.includes(search)" src="@/assets/상우/왕사슴벌레세트.jpg"/>
                <p v-if="product.productName.includes(search)" >제품명:{{product.productName}}</p>
                <p v-if="product.productName.includes(search)" >제품가격:{{product.productPrice}}원</p>
                <v-btn depressed v-if="product.productName.includes(search)" @click="Buy(product.boardNo)"><v-icon>mdi-location-enter</v-icon>구매</v-btn>
                <v-btn depressed v-if="User !=null&&product.productName.includes(search)" @click="Basket(product)"><v-icon>mdi-basket</v-icon>장바구니</v-btn>
                <v-btn depressed v-if="User ==null&&product.productName.includes(search)" @click="plzlogin">장바구니</v-btn>
            </li>
        </ul>
        
    </v-container>
        
    </div>
</template>
<script>
import cookies from 'vue-cookies'
import Vue from 'vue'
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import ShoppingMallMenuBar from './ShoppingMallMenuBar.vue'

Vue.use(cookies)
export default {
  components: {  ShoppingMallMenuBar },
    name: 'ShoppingMallPageForm',
    props:{
        ProductList:{
            type: Array
        }
    },
    data(){
            return{
                productNum: 1,
                search: '',
            }
    },
    methods: {
        plzlogin(){alert('로그인후에 이용해주세요!')},
        ...mapActions(['fetchBasketList','fetchMember']),
        
        Buy(boardNo){
               this.$router.push({name: 'ProductReadPage', params:{boardNo}})
        },
        Basket(product){
           
            //현재 로그인된 아이디와 포문을돌려 회원db에 같은 아이디가 나온다면, 그 회원의 memberNo를 가져온다.
            // 즉 현재 로그인된 유저의 memberNo를 가져와서 장바구니에 활용한다.
            /*
             for(var i = 0 ; i <this.members.length ; i++){
           if(this.$store.state.User == this.members[i].userid){
                 this.$store.state.loginMemberNo = this.members[i].memberNo
            }
             }*/
            const { productName, productPrice} = product
            const {productNum} =this
            axios.post(`http://localhost:9999/jpamemberManage/addBasket/${this.$store.state.loginMemberNo}`,{ productName, productPrice,productNum})
            .then( ()=> {
                alert('장바구니에 추가되었습니다.')
               this.$router.go()
            }).catch(err=>{alert(err.response.data.message)})
         
            
        
    },
    here(members){
        console.log(members)
    }
    
        
    },
    computed:{
        ...mapState(['members','User','loginMemberNo'])

    },
    
    
}
</script>

<style scoped>
ul{
    list-style: none;
}
li {
    float: left;
}
table{
    position: absolute;
}
tr{
    border: hidden;
}
</style>