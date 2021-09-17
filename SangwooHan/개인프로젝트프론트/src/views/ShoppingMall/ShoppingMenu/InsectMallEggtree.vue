<template>
<div>
    <shopping-mall-menu-bar/>
        <insect-mall-eggtree-form :listArray="PageArray"/>
    </div>
</template>
<script>
import axios from 'axios'
import ShoppingMallMenuBar from '../../../components/ShoppingMall/ShoppingMallMenuBar.vue'
import InsectMallEggtreeForm from '../../../components/ShoppingMall/InsectMallEggtreeForm.vue'



export default {
  components: { ShoppingMallMenuBar, InsectMallEggtreeForm },
    name: 'InsectMallEggtree',
    data(){
            return{
                productType: '산란목',
                PageArray: [],
            }
    },
    methods: {
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