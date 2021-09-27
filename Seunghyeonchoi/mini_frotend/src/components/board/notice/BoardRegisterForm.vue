<template>
    <form @submit.prevent="onSubmit">
        <table>
            <tr>
                <td class="message">제목</td>
                <td>
                    <input type="text" v-model="title" placeholder="제목을 입력해주세요"></td>
                </tr>
                <tr>
                    <td>작성자</td>
                    <td>
                        <input type="text" v-model="nickname" readonly></td>
                    </tr>
                    <tr>
                        <td>본문</td>
                        <td>
                            <textarea style="height:500px" cols="80" rows="20" v-model="content" placeholder="본문을 입력해주세요" wrap="hard"></textarea>
                        </td>
                    </tr>
        </table>

        <!-- 이미지 등록 폼 -->
        <div style="margin-bottom: 10px">
            <div class="image-box">
                <label>이미지 추가
                    <input
                        type="file"
                        class="files"
                        id="files"
                        ref="files"
                        multiple="multiple"
                        v-on:change="handleFileUpload()"
                        style="pointer:cursor"></label>
                    <button @click="fileDeleteButton()" class="image_btn">이미지 삭제</button>
            </div>
            <div class="preview_image">
                <img :src="preview"></div>
        </div>
        <!-- <v-btn @click="submitFiles()">이미지등록</v-btn> -->
        <div class="button_box">
            <router-link :to="{ name: 'NoticeBoardListPage' }">
                <v-btn>
                    취소
                </v-btn>
            </router-link>
            <v-btn color="light-blue lighten-1 text center" @click="fusion()" class="item">
                등록
            </v-btn>
        </div>
    </form>
</template>

<script>
import axios from 'axios'
export default {
    name: 'BoardRegisterForm',
    data () {
        return {
            //초기값 세팅
            title: '',
            writer: this.$store.state.yourId,
            content: '',
            files: '',
            preview: '',
            nickname: this.$store.state.yourNickname
        }
    },
    methods: {
        handleFileUpload () {
                this.files = this.$refs.files.files
                this.preview = URL.createObjectURL(this.files[0])
                console.log(this.preview)
        },
        onsubmit () {
            let formData = new FormData()
            for (var idx = 0; idx < this.files.length; idx++) {
                formData.append('fileList', this.files[idx])                
            }
            let ownerId = this.$store.state.yourId
            formData.append('id', ownerId)
            let no = this.$store.state.boardNo
            formData.append('no', no)
            axios.post('http://localhost:7777/admin/uploadImg_Notice', formData, {
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
            this.$router.push({
                            name: 'NoticeBoardListPage'
                        })
        },
        fileDeleteButton () {
            this.files = '',
            this.preview = ''
        },       
        boardRegist () {
            const { title, writer, content, nickname } = this

            axios.post('http://localhost:7777/noticeboard/register', { title, writer, content, nickname } )
                    .then(res => {
                         console.log('게시물 번호: ' + res.data.boardNo.toString())
                         this.$store.state.boardNo = res.data.boardNo.toString()
                        
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        },
        fusion () {
            setTimeout(() => {
                this.onsubmit()
                }, 1000)
            this.boardRegist()
        }
    }
}
</script> 

<style scoped>
.item {
    font: 12pt;
    color: white;
    font-weight: 800;
}
.button_box {    
    margin-top: 10px;
    display: flex;
    justify-content: flex-end;
}
.v-btn {
    margin-right: 10px;
}
.preview_image img {
    width: 300px;
}
.image_btn {
    color: #757575;
    font-size:12px;
    padding:3px;
    border-radius:3px;
    border: 0.5px solid #757575;
}
    
</style>