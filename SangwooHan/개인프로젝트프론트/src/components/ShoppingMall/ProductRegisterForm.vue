<template>
    <div>
        <form @submit.prevent="OnSubmit">
        <table>
            <tr>
                <td>상품명</td>
                <input v-model="productName" type="text"/>
                <td>상품가</td>
                <input v-model="productPrice" type="Number"/>
                <td>분류</td>
                <v-select v-model="productType"
                :items="items">
                </v-select>
                <td>재고</td>
                <input v-model="productStock" type="Number"/>
            </tr>
            <tr>
                <td>상품설명</td>
                    <v-textarea auto-grow v-model="productDesc"  style="width: 1300px;"/>
            </tr>

            <tr>
            </tr>

            <v-btn type="submit">등록하기</v-btn>
        </table>
        
        </form>
    </div>
</template>

<script>
import axios from 'axios'
axios
export default {
    name: 'productRegisterForm',
    data() {
        return{
            items: [
                {text: '균사', value: '균사'},
                {text: '발효톱밥', value: '발효톱밥'},
                {text: '산란목', value: '산란목'},
                {text: '젤리', value: '젤리'},
                {text: '곤충', value: '곤충'},
                {text: '기타사육용품', value: '기타사육용품'},
              
            ],
            productName: '',
            productPrice: 0,
            productDesc: '',
            productType: '',
            productStock: 0,
        }
    },


    methods: {
            OnSubmit() {
                    const {productName, productPrice, productDesc, productType,productStock} = this
                    this.$emit('submit', {productName, productPrice, productDesc, productType,productStock})

            },
            handleFileUpload () {
            this.files = this.$refs.files.files
        },
    }
}
</script>

<style scoped>

</style>