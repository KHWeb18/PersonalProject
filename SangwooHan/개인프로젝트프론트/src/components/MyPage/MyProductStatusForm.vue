<template>
  <div>
      <v-container>
    <table>
      <tr>
        <th>주문번호</th>
        <th>상품명</th>
        <th>상품가격</th>
        <th>개수</th>
        <th>주문일시</th>
       <th>상태</th>
       <th>비고</th>
       
      </tr>
      <tr v-for="p in paginatedData" :key="p.orderNo">
        <td>{{p.orderNo}}</td>
        <td>{{p.productName}}</td>
        <td>{{p.productPrice}}</td>
        <td>{{p.productNum}}</td>
        <td>{{p.createDate}}</td>
        <td>{{p.state}}</td>
        <button v-if="p.state =='입금확인중'" @click="deleteorder(p.orderNo)">주문취소</button>
        <button v-if="Modify == 0 &&p.state =='입금확인중'" @click="ModifyOn(p.orderNo)">수량변경</button>
        <input v-if="Modify ==  p.orderNo" style="max-width: 50px" type="Number" v-model="quantity"/>
        <button v-if="Modify == p.orderNo" @click="ModifyOff">취소</button>
        <button v-if="Modify == p.orderNo" @click="QuantityChange(p.orderNo)">/완료</button>
      </tr>
    </table>
      </v-container>
  <!--  <v-btn @click="check">체크</v-btn> -->
    <div class="btn-cover">
      <button :disabled="pageNum === 0" @click="prevPage" class="page-btn">
        이전
      </button>
      <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }} 페이지</span>
      <button :disabled="pageNum >= pageCount - 1" @click="nextPage" class="page-btn">
        다음
      </button>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'paginated-list',
  data () {
    return {
      pageNum: 0,
      Modify: 0,
      quantity: 1
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
      default: 5
    }
  },
  methods: {
    ModifyOn(orderNo){
      this.Modify = orderNo
    },
    ModifyOff(){
      this.Modify = 0
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
    deleteorder(orderNo){
        axios.delete(`http://localhost:9999/jpaOrder/deleteOrder/${orderNo}`)
        .then(()=>{
            alert("주문취소하였습니다.")
             this.$router.go()
        })
    },
    QuantityChange(orderNo){
        const {quantity} =this
        if(quantity > 0){
        axios.post(`http://localhost:9999/jpaOrder/QuantityChange/${orderNo}`,{quantity})
        .then( () =>{
           alert('수량이 변경되었습니다.')
           this.$router.go()
        })
                        }
        else {
          axios.delete(`http://localhost:9999/jpaOrder/deleteOrder/${orderNo}`)
        .then(()=>{
            alert("주문취소하였습니다.")
             this.$router.go()
        })
        }                
    }
  },
  computed: {
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

<style>

</style>