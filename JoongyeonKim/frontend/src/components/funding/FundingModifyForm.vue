<template>
    <div align="container">
        <form @submit.prevent="onSubmit">
             <v-sheet color="white" height="" width="900">
                <table>
                        <tr>
                            <td>창작자</td>
                            <td><input type="text" v-model="writer" flat solo disabled></td>
                        </tr>
                        <!--
                        <tr>
                            <td>작성자</td>
                            <td><input type="text" v-model="writer" v-on:change="handleEmail()" flat solo></td>
                        </tr>
                        -->
                        <tr>
                            <td>카테고리</td>
                            <td><v-select :items='items' input type="text" v-model="category" disabled></v-select></td>
                        </tr>
                        <tr>
                            <td>현재 이미지</td>
                            <td><label>이미지 변경
                                <input type="file" id="files" ref="files" multiple v-on:change="handleFileUpload()">
                                <td align="center">
                                    <v-img max-height="200" max-width="300"><img :src="require(`@/assets/userUploadImage/${this.funding.image}`)"></v-img>
                                </td>
                            </label></td>
                        </tr>
                        <tr>
                            <td>제목</td>
                            <td><input type="text" v-model="title" flat solo></td>
                        </tr>
                        <tr>
                            <td>요약</td>
                            <td><input type="text" v-model="summary" flat solo ></td>
                        </tr>
                        <tr>
                            <td>본문</td>
                            <td><textarea input type="text" cols="50" rows="20" v-model="content" flat solo></textarea></td>
                        </tr>
                        <tr>
                            <td>모금 종료일</td>
                            <td><input type="text" v-model="fundingEnd" flat solo disabled></td>
                        </tr>
                        <tr>
                            <td>목표금액</td>
                            <td><input type="number" v-model="endMoney" flat solo disabled></td>
                            <!--<span class="input-group-text">원</span>-->
                        </tr>
                        <tr>
                            <td>현재금액</td>
                            <td><input type="number" v-model="nowMoney" flat solo disabled></td>
                            <!--<span class="input-group-text">원</span>-->
                        </tr>
                </table>
            </v-sheet>
            <div>
                <v-btn class="mt-3" color="primary" tile large button type="submit" v-on:click="submitFiles()">저장</v-btn>
                <router-link :to="{ name: 'FundingReadPage', params: { fundingNo: funding.fundingNo.toString() } }" >
                    취소
                </router-link>
                <v-btn color="primary" @click="onDelete">삭제</v-btn> 
            </div>
        </form>
    </div>
</template>

<script>

import axios from 'axios'

export default {
    name: 'FundingModifyForm',
    props: {
        funding: {
            type: Object,
            required: true
        }
    },
    mounted () {
        console.log(JSON.stringify(this.funding))
    },
    data () {
        return {
          writer: '',
          category: '',
          title: '',
          image: '',
          fundingEnd: '',
          content: '',
          summary: '',
          endMoney: '',
          nowMoney: 0,
          items: ['게임','음악','만화'],
        }
    },
    methods: {
        onSubmit () {
            const { writer, category, title, image,  content, summary, fundingEnd, endMoney, nowMoney } = this
            this.$emit('submit', { writer, category, title, image,  content, summary, fundingEnd, endMoney, nowMoney })
        },
        handleFileUpload () {
            this.files = this.$refs.files.files
            const info = this.files
            this.image = info[0].name
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
        },
        onDelete () {
            const { fundingNo } = this.funding
            axios.delete(`http://localhost:7777/funding/${fundingNo}`)
                .then(() => {
                    alert("프로젝트가 삭제되었습니다")
                    this.$router.push({name: 'FundingListPage' })
                })
                .catch(err => {
                    alert(err.response.data.message)
                })
        },
    },
    created () {
        this.writer = this.funding.writer
        this.category = this.funding.category
        this.title = this.funding.title
        this.image = this.funding.image
        this.content = this.funding.content
        this.summary = this.funding.summary
        this.fundingEnd = this.funding.fundingEnd
        this.endMoney = this.funding.endMoney
        this.nowMoney = this.funding.nowMoney
        
    }
}

</script>

<style scoped>
#container {
    margin: 0 auto;
    width: 1200px;
}

img {
  width: 300px;
  height: 200px;
  object-fit: cover;
}

</style>