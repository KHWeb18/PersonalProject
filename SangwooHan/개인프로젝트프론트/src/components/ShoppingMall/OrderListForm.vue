<template>
    <div>
        <!--
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
           </tr>
           
                <tr v-for="item in OrderList" :key="item.productName">
                  <th>{{item.orderNo}}</th>
                  <th width="150px">{{ item.address}}</th>
                  <td>{{item.buyUserName}}</td>
                  <td>{{item.phoneNo}}</td>
                  <td>{{item.productName}}</td>
                  <td>{{item.productNum}}</td>
                  <td>{{item.productPrice}}</td>
                  <td>{{item.state}}</td>
                <v-btn @click="Shipping(item.orderNo)">배송</v-btn>
                </tr>
       </table>
       -->
       <order-list-new-form :listArray="OrderList"/>
    </div>
</template>

<script>
import axios from 'axios'
import OrderListNewForm from './OrderListNewForm.vue'
export default {
  components: { OrderListNewForm },
    name: 'OrderListForm',
    props: {
        OrderList:{
            type: Array
        }
    },
    data(){

        return{
            search: '',
           
        }
    },
    methods:{
        Shipping(orderNo){
                    
                axios.post(`http://localhost:9999/jpaOrder/Shipping/${orderNo}`,{shipping: '배송시작'})
                .then(()=>{
                    this.$router.go()
                })
        }
    }
}
</script>

<style scoped>

</style>