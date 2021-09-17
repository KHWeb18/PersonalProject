<template>
  <div>
    <h1>TABLE PAGINATION</h1>
    <paginated-list :listArray="pageArray"/>
  </div>
</template>

<script>
import axios from 'axios'
import PaginatedList from '../components/PaginatedList.vue';

export default {
  name: 'simple-pagination',
  components: {
    PaginatedList
    
  },
  data () {
    return {
      pageArray: []
    }
  },
  created () {
    axios.get('http://localhost:9999/jpaProduct/getProductList')
    .then(res => {
      
      this.pageArray = res.data;
    })
    .catch(err => {
      console.log(err);
    });
  }
}
</script>

<style>
h1 {
  color: #454545;
  text-align: center;
}
</style>