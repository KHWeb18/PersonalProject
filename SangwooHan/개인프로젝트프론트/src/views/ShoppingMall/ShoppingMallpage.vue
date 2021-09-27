<template>
    <div>
       <!-- <shopping-mallpage-from v-if="ProductList" :ProductList="ProductList"/> -->
        
        <shopping-mallpage-form-new-ver :listArray="pageArray"/>
       
    </div>
</template>
<script>
import axios from 'axios'
import {mapActions, mapState} from 'vuex'
import shoppingMallpageFormNewVer from '../../components/ShoppingMall/shoppingMallpageFormNewVer.vue'
export default {
  components: { shoppingMallpageFormNewVer },
    name: 'ShoppingMallpage',
    computed: {
        ...mapState(['ProductList'])
    },
    methods: {
        ...mapActions(['fetchProductList'])
    },
    mounted() {
        this.fetchProductList()
    },
    created () {
    axios.get('http://localhost:9999/jpaProduct/getProductList')
    .then(res => {
      
      this.pageArray = res.data;
    })
    .catch(err => {
      console.log(err);
    });
  },
  data() {

      return{
          pageArray: []
      }
  }
}
</script>