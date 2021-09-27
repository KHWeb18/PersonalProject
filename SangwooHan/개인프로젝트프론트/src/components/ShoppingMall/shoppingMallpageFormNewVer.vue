<template>
  <div>
      <shopping-mall-menu-bar :ProductList="ProductList"/>
      검색
      <input v-model="search"/>
      <table>
          <tr>
    <ul>
        <li v-for="p in paginatedData" :key="p.no">
            <img width="300px" v-if="p.productName =='[사슴벌레용]발효톱밥5L'&&p.productName.includes(search)" src="@/assets/상우/발효톱밥.jpg"/>
                <img width="300px" v-if="p.productName =='[장수풍뎅이]발효톱밥5L'&&p.productName.includes(search)" src="@/assets/상우/발효톱밥.jpg"/>
                <img width="300px" v-if="p.productName =='산란목'&&p.productName.includes(search)" src="@/assets/상우/산란목.jpg"/>
                <img width="300px" v-if="p.productName =='발효톱밥5L'&&p.productName.includes(search)" src="@/assets/상우/발효톱밥.jpg"/>
                <img width="300px" v-if="p.productName =='균사'&&p.productName.includes(search)" src="@/assets/상우/균사.jpg"/>
                <img width="300px" v-if="p.productName =='곤충젤리100개'&&p.productName.includes(search)" src="@/assets/상우/수액젤리.jpg"/>
                <img width="300px" v-if="p.productName =='곤충이끼'&&p.productName.includes(search)" src="@/assets/상우/곤충이끼.jpg"/>
                <img width="300px" v-if="p.productName =='오호히라균사'&&p.productName.includes(search)" src="@/assets/상우/균사.jpg"/>
                <img width="300px" v-if="p.productName =='레벤지균사'&&p.productName.includes(search)" src="@/assets/상우/균사.jpg"/>
                <img width="300px" v-if="p.productName =='놀이목'&&p.productName.includes(search)" src="@/assets/상우/놀이목.jpg"/>
                <img width="300px" v-if="p.productName =='광구병'&&p.productName.includes(search)" src="@/assets/상우/광구병.jpg"/>
                <img width="300px" v-if="p.productName =='오호히라균사묶음6개'&&p.productName.includes(search)" src="@/assets/상우/균사묶음.jpg"/>
                <img width="300px" v-if="p.productName =='균사스푼'&&p.productName.includes(search)" src="@/assets/상우/균사스푼.jpg"/>
                <img width="300px" v-if="p.productName =='일반균사묶음6개'&&p.productName.includes(search)" src="@/assets/상우/균사묶음.jpg"/>
                <img width="300px" v-if="p.productName =='사육케이스특대'&&p.productName.includes(search)" src="@/assets/상우/사육케이스.jpg"/>
                <img width="300px" v-if="p.productName =='사육케이스대'&&p.productName.includes(search)" src="@/assets/상우/사육케이스.jpg"/>
                <img width="300px" v-if="p.productName =='사육케이스중'&&p.productName.includes(search)" src="@/assets/상우/사육케이스.jpg"/>
                <img width="300px" v-if="p.productName =='사육케이스소'&&p.productName.includes(search)" src="@/assets/상우/사육케이스.jpg"/>
                <img width="300px" v-if="p.productName =='먹이접시1구'&&p.productName.includes(search)" src="@/assets/상우/먹이접시1구.jpg"/>
                <img width="300px" v-if="p.productName =='먹이접시2구'&&p.productName.includes(search)" src="@/assets/상우/먹이접시2구.jpg"/>
                <img width="300px" v-if="p.productName =='[사슴벌레용]발효톱밥5L묶음6개'&&p.productName.includes(search)" src="@/assets/상우/발효톱밥묶음.jpg"/>
                <img width="300px" v-if="p.productName =='[장수풍뎅이]발효톱밥5L묶음6개'&&p.productName.includes(search)" src="@/assets/상우/발효톱밥묶음.jpg"/>
                <img width="300px" v-if="p.productName =='유산균젤리100개'&&p.productName.includes(search)" src="@/assets/상우/유산균젤리.jpg"/>
                <img width="300px" v-if="p.productName =='유충병고급'&&p.productName.includes(search)" src="@/assets/상우/유충병고급.jpg"/>
                <img width="300px" v-if="p.productName =='온도계스티커'&&p.productName.includes(search)" src="@/assets/상우/온도계스티커.jpg"/>
                <img width="300px" v-if="p.productName =='장수풍뎅이세트'&&p.productName.includes(search)" src="@/assets/상우/장수풍뎅이세트.jpg"/>
                <img width="300px" v-if="p.productName =='왕사슴벌레세트'&&p.productName.includes(search)" src="@/assets/상우/왕사슴벌레세트.jpg"/>

            <p v-if="p.productName.includes(search)" >제품명:{{p.productName}}</p>
                <p v-if="p.productName.includes(search)" >제품가격:{{p.productPrice}}원</p>
                <v-btn depressed v-if="p.productName.includes(search)" @click="Buy(p.boardNo)"><v-icon>mdi-location-enter</v-icon>구매</v-btn>
                <v-btn depressed v-if="User !=null&&p.productName.includes(search)" @click="Basket(p)"><v-icon>mdi-basket</v-icon>장바구니</v-btn>
                <v-btn depressed v-if="User ==null&&p.productName.includes(search)" @click="plzlogin"><v-icon>mdi-basket</v-icon>장바구니</v-btn>

        </li>
    </ul>
          </tr>
          <tr>
                <v-btn  depressed :disabled="pageNum === 0" @click="prevPage" class="page-btn">
      <v-icon>mdi-arrow-left-box</v-icon>   
                </v-btn>
      <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }}</span>
      <v-btn  depressed :disabled="pageNum >= pageCount - 1" @click="nextPage" class="page-btn">
        <v-icon>mdi-arrow-right-box</v-icon>   
      </v-btn>
          </tr>
      </table>




   
  </div>
</template>

<script>
import axios from 'axios';

import { mapActions, mapState } from 'vuex';
import ShoppingMallMenuBar from './ShoppingMallMenuBar.vue';
export default {
    
  components: { ShoppingMallMenuBar },
  name: 'paginated-list',
  data () {
    return {
      pageNum: 0,
      search: '',
      productNum: 1,
    }
  },
  props: {
    listArray: {
      type: Array,
      required: true
    },
    pageSize: {
      type: Number,
      required: false,
      default: 14
    }
  },
  methods: {
      ...mapActions(['fetchProductList']),
    nextPage () {
      this.pageNum += 1;
    },
    prevPage () {
      this.pageNum -= 1;
    },
    check(){
        console.log(this.listArray)
    },
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
    plzlogin(){
      alert('로그인후 이용해주세요')
    }
  },
  mounted(){
      this.fetchProductList()
  },
  computed: {
      ...mapState(['ProductList','User']),
    pageCount () {
      let listLeng = this.listArray.length,
          listSize = this.pageSize,
          page = Math.floor(listLeng / listSize);
      if (listLeng % listSize > 0) page += 1;
      
      /*
      아니면 page = Math.floor((listLeng - 1) / listSize) + 1;
      이런식으로 if 문 없이 고칠 수도 있다!
      */
      return page;
    },
    paginatedData () {
      const start = this.pageNum * this.pageSize,
            end = start + this.pageSize;
      return this.listArray.slice(start, end);
    }
  }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@700&display=swap');
table {
  width: 100%;
  border-collapse: collapse;
}
table th {
  font-size: 1.2rem;
}
table tr {
  height: 2rem;
  text-align: center;
  border-bottom: 1px solid #505050;
}
table tr:first-of-type {
  border-top: 2px solid #404040;
}
table tr td {
  padding: 1rem 0;
  font-size: 1.1rem;
}
.btn-cover {
  margin-top: 1.5rem;
  text-align: center;
}
.btn-cover .page-btn {
  width: 5rem;
  height: 2rem;
  letter-spacing: 0.5px;
}
.btn-cover .page-count {
  padding: 0 1rem;
}
ul{
    list-style: none;
}
li {
    float: left;
}
p{
 font-family: 'IBM Plex Sans KR', sans-serif;
}
</style>