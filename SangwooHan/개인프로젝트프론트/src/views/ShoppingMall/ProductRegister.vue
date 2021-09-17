<template>
    <div>
        <product-register-form @submit="OnSubmit"/>
    </div>
</template>

<script>
import axios from 'axios'
import ProductRegisterForm from '../../components/ShoppingMall/ProductRegisterForm.vue'
export default {
    name: 'ProductRegister',
  components: { ProductRegisterForm },

  methods: {
      OnSubmit(payload) {
            const {productName, productPrice, productDesc, productType,productStock} = payload
            axios.post('http://localhost:9999/jpaProduct/register', {productName, productPrice, productDesc, productType,productStock})
            .then(res => {
                alert('상품등록완료' + res)
            }).catch(err=>{alert(err.response.data.message)})
      }
  }
    
}
</script>