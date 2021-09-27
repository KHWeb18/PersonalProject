<template>
    <form @submit.prevent="onSubmit">
        <!--<h3>게시물 작성 형태</h3>-->
        
        <table>
            <tr>
                <td v-show="false">판매자</td>
                <td><input type="text" v-model="producer" :disabled="true" v-show="false"></td>
            </tr>
            <tr>
                <td>상품명</td>
                <td><input type="text" v-model="product_name"></td>
            </tr>            
            <tr>
                <td>상품가격</td>
                <td><input type="number" v-model="price"></td>
            </tr>
            <tr>
                <td>상품 세부사항</td>
                <td><textarea cols="50" rows="20" v-model="description"></textarea></td>
            </tr>
            
            <tr>
                <td>사진</td>
                <td> <img :src="files" /> </td>
                <!--<td><img :src="(`@/assets/productimg/${files_name}`)"></td>-->
                <!--<td><img :src="(`../demo/images/${product[idx].img}`)"></td>-->
            </tr>

        </table>
        
        <div>
            <label>
                <input type="file" id="files" ref="files" multiple v-on:change="handleFileUpload()">
            </label>
            <!--<button v-on:click="submitFiles()">업로드!</button>-->
        </div>
        
        <div>
            <button v-on:click="submitFiles()">등록</button>
            <!--<button type="submit">등록</button>-->
            <router-link :to="{ name: 'ProductListPage' }">
                취소
            </router-link>
        </div>
    </form>
    
</template>

<script>

import axios from 'axios'
import { mapState } from 'vuex'


export default {
    name: 'ProductRegisterForm',
    
    data () {
        return {
            product_name: '',
            producer: '',
            description: '',
            price: '',
            files: '',
            file_name: '',
            
            
            
            
        }
    },
    mounted () {
        // this.fetchSession()
        this.$store.state.session = this.$cookies.get("user")
        if (this.$store.state.session != null) {
            this.producer = this.$store.state.session.userId            
        }
        
    },
    computed: {                
        ...mapState(['session'])
    },
    methods: {        
        onSubmit () {             
            const { product_name, producer, description, price, file_name } = this            
            this.$emit('submit', { product_name, producer, description, price, file_name })
        },   
       
        
        handleFileUpload () {
            this.files = this.$refs.files.files
            this.file_name = this.files[0].name   
                   

            console.log(this.files)
            console.log(this.file_name)

        },
        submitFiles () {
            let formData = new FormData()            
            for (var idx = 0; idx < this.files.length; idx++) {                
                formData.append('fileList', this.files[idx])
                
            }
            
            axios.post('http://localhost:7777/file/uploadImg', formData, {            
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            })
            .then (res => {
                this.response = res.data                
            })
            .catch (res => {
                this.response = res.message
            }) 
            alert('Processing Complete!')
        },
          
    }
}
</script> 