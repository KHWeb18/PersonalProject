<template>
  <div>
    <table>
      <tr>
               <th>주문번호</th>
               <th>주소</th>
               <th>성함</th>
               <th>연락처</th>
               <th>물품이름</th>
               <th>개수</th>
               <th>가격</th>
               <th>입금상태</th>
               <th>비고</th>
               <th>시간</th>
           </tr>
      <tr v-for="item in paginatedData" :key="item.orderNo">
                  <th>{{item.orderNo}}</th>
                  <th width="150px">{{ item.address}}</th>
                  <td>{{item.buyUserName}}</td>
                  <td>{{item.phoneNo}}</td>
                  <td>{{item.productName}}</td>
                  <td>{{item.productNum}}</td>
                  <td>{{item.productPrice}}</td>
                  <td>{{item.state}}</td>
                <td><v-btn @click="Shipping(item.orderNo)">배송</v-btn></td>
                <td>{{$moment(item.createDate).format('YYYY-MM-DD/hh:mm')}}</td>
                </tr>
    </table>
   <!-- <v-btn @click="check">체크</v-btn> -->
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
import Vue from 'vue'
import VueMoment from 'vue-moment'
Vue.use(VueMoment);

export default {
  name: 'paginated-list',
  data () {
    return {
      pageNum: 0
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
    nextPage () {
      this.pageNum += 1;
    },
    prevPage () {
      this.pageNum -= 1;
    },
    check(){
        console.log(this.listArray)
    },
     Shipping(orderNo){
                    
                axios.post(`http://localhost:9999/jpaOrder/Shipping/${orderNo}`,{shipping: '배송시작'})
                .then(()=>{
                    this.$router.go()
                })
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
</style>