<template>
    <v-container>
        <div align="center">
            <h2>상품 판매글 작성</h2>
            <product-register-form @submit="onSubmit"/>
        </div>
    </v-container>
</template>

<script>
import ProductRegisterForm from '@/components/product/ProductRegisterForm.vue'
import { mapState } from 'vuex'
import axios from 'axios'
// import qs from 'qs'
export default {
    name: 'ProductRegisterPage',
    components: {
        ProductRegisterForm
    },
    computed: {
        ...mapState(['products']),
        
    },
    /*
    computed: {
        ...mapState(['isLogin']),

    },
    mounted: {
        if(user.isLogin == undefined) {
            alert("로그인을 해야 이용할 수 있습니다.")
            this.$router.pust({path: '/'})
        }
    },*/
    methods: {
        onSubmit (payload) {                        
            const { product_name, description, producer, price, file_name } = payload
            axios.post('http://localhost:7777/vueproduct/register', { product_name, description, producer, price, files: file_name })            
            
                    .then(res => {
                        alert('등록 성공! - ' + res)
                        console.log('상품 번호: ' + res.data.productNo.toString())
                        console.log('파일: ' + res.data.files)
                        this.$router.push({
                            name: 'ProductListPage'                            
                        })
                    })
                    .catch((error) => {                        
                        console.log('error =>', error.response.data)
                        })
                    /*.catch(res => {
                        alert(res.response.data.message + '  x')

                    })*/
        },
        
    }
}
</script> 