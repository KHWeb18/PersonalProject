<template>
  <div>
      검색
      <input v-model="search"/>
      <table>
          <tr>
           <ul>
             <li  v-for="product in paginatedData" :key="product.productName">
                <img width="300px" v-if="product.productName =='곤충젤리100개'&&product.productName.includes(search)&&product.productType =='젤리'" src="@/assets/상우/수액젤리.jpg"/>
                <img width="300px" v-if="product.productName =='유산균젤리100개'&&product.productName.includes(search)&&product.productType =='젤리'" src="@/assets/상우/유산균젤리.jpg"/>
                <p v-if="product.productName.includes(search)&&product.productType =='젤리'" >제품명:{{product.productName}}</p>
                <p v-if="product.productName.includes(search)&&product.productType =='젤리'" >제품가격:{{product.productPrice}}원</p>
                <v-btn v-if="product.productName.includes(search)&&product.productType =='젤리'" @click="Buy(product.boardNo)"> 구매</v-btn>
                <v-btn  v-if="User !=null&&product.productName.includes(search)&&product.productType =='젤리'" @click="Basket(product)">장바구니</v-btn>
                <v-btn v-if="User ==null&&product.productName.includes(search)&&product.productType =='젤리'" @click="plzlogin">장바구니</v-btn>
            </li>
           </ul>
          </tr>
          <tr>
                <button :disabled="pageNum === 0" @click="prevPage" class="page-btn">이전</button>
                <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }} 페이지</span>
                <button :disabled="pageNum >= pageCount - 1" @click="nextPage" class="page-btn">다음</button>
          </tr>
      </table>
  </div>
</template>

<script>
import axios from 'axios';

import { mapState } from 'vuex';

export default {
    
  components: {  },
  name: 'paginated-list',
  data () {
    return {
      pageNum: 0,
      search: '',
      productNum: 1,
      newArrayList: []
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
      default: 10
    }
  },
  methods: {
      check1(){
          console.log(this.listArray.includes('기타사육용품'))
      },
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
  computed: {
      ...mapState(['User']),
    pageCount () {
      let listLeng = this.listArray.length,
          listSize = this.pageSize,
          page = Math.floor(listLeng / listSize);
      if (listLeng % listSize > 0) page += 1;
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
</style>