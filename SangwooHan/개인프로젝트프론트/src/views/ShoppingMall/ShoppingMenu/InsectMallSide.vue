<template>
<div>
<shopping-mall-menu-bar />
<insect-mall-side-form :listArray="PageArray"/>
</div>
</template>
<script>
import axios from 'axios'
import ShoppingMallMenuBar from '../../../components/ShoppingMall/ShoppingMallMenuBar.vue'
import InsectMallSideForm from '../../../components/ShoppingMall/InsectMallSideForm.vue'



export default {
  components: { ShoppingMallMenuBar, InsectMallSideForm },
    name: 'InsectMallEggtree',
    data(){
            return{
                PageArray: [],
                productType: '기타사육용품'
                 }
    },
    created(){
        const {productType} =this
        axios.post('http://localhost:9999/jpaProduct/getsideProductList',{productType})
        .then((res) =>{
            this.PageArray = res.data
        })
    }

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