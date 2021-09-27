<template>
    <div id="board">
        <h2>COMMUNITY</h2>
        <router-link :to="{ name: 'BoardRegisterPage' }">
            게시물 등록
        </router-link>
        <product-list :products="products"/>
    </div>
</template>

<script>
import ProductList from '@/components/product/ProductList.vue'
import { mapState, mapActions } from 'vuex'
export default {
    name: 'ProductListPage',

    components: {
        ProductList
    },
    computed: {
        ...mapState(['products'])
    },
    mounted () {
        this.fetchProductList()
    },
    methods: {
        ...mapActions(['fetchProductList'])
    }
}


</script>