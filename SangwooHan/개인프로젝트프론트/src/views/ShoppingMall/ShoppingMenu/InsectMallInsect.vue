<template>
<div>
    <shopping-mall-menu-bar />
        <insect-mall-insect-form :listArray="PageArray"/>
</div>
</template>
<script>
import axios from 'axios'
import ShoppingMallMenuBar from '../../../components/ShoppingMall/ShoppingMallMenuBar.vue'
import InsectMallInsectForm from '../../../components/ShoppingMall/InsectMallInsectForm.vue'



export default {
  components: { ShoppingMallMenuBar, InsectMallInsectForm },
    name: 'InsectMallEggtree',

    data(){
            return{
                productType: '곤충',
                PageArray: [],
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