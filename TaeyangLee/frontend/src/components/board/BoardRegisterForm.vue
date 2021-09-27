<template>
    <form @submit.prevent="onSubmit">
    
 <table>
        <tr>
            <td>제목</td>
            <td><input type="text" v-model="title"></td>
        </tr>
        <tr>
            <td>작성자</td>
            <td><input type="text" v-model="writer"></td>
        </tr>
        <tr>
            <td>본문</td>
            <td><textarea cols="50" rows="20" v-model="content"></textarea></td>
        </tr>
        <tr>
            <td>현재모금액</td>
            <td><input type="text" v-model="nowfunding"></td>
        </tr>
         <tr>
            <td>목표금액</td>
            <td><input type="text" v-model="funding"></td>
        </tr>
        <tr>
            <td>이미지 첨부</td>
            <td><label>Files
                <input type="file" id="files" ref="files" multiple v-on:change="handleFileUpload()">
            </label>
            </td>
        </tr>
    </table>
    <div>
        <button type="submit" v-on:click="submitFiles()">등록</button>
        <router-link :to="{ name: 'BoardListPage'}">
            취소
        </router-link>
    </div>
    </form>
    
</template>

<script>
import axios from 'axios'
export default {
    name: 'BoardRegisterForm',
    data() {
        return {
            title: '제목을 작성하세요',
            writer : '',
            content: '본문을 작성하면 됩니다.',
            img: '',
            funding: '목표금액을 입력하세요',
            nowfunding: 0
        }
    },
    methods: {
        onSubmit() {
            const { title, writer, content, img, nowfunding, funding } = this
            this.$emit('submit', { title, writer, content, img, nowfunding, funding })
        },
        handleFileUpload () {
            this.files = this.$refs.files.files
            const info = this.files
            this.img = info[0].name
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
        }
    }
}
</script>



<style scoped>
button {
    background-color: greenyellow;
}

</style>