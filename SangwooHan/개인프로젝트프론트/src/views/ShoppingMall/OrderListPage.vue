<template>
    <div>
        <order-list-form v-if="OrderList" :OrderList="OrderList"/>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import OrderListForm from '../../components/ShoppingMall/OrderListForm.vue'
export default {
    name: 'OrderListPage',
    components:{
        OrderListForm
    },
    computed: {
        ...mapState(['OrderList'])
    },
    methods: {
        ...mapActions(['fetchOrderList'])
    },
    mounted(){
        this.fetchOrderList()
    }
}
</script>