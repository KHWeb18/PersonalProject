<template>
    <div>
        <product-read-form v-if="Product" :Product="Product"/>
        <p v-else>공사중</p>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import ProductReadForm from '../../components/ShoppingMall/ProductReadForm.vue'
export default {
  components: { ProductReadForm },
    name: 'ProductReadPage',
    props:{
        boardNo: {
            type:String,
            required: true
        },
        
    },
    computed:{
            ...mapState(['Product'])
        },
        methods:{
            ...mapActions(['fetchProduct'])
        },
        created() {
            this.fetchProduct(this.boardNo)
        },
}
</script>