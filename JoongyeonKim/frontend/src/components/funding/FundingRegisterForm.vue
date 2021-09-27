<template>
  <div id="container">
    <form @submit.prevent="onSubmit">
        <v-sheet color="white" height="1200" width="900">
      <table>
          <tr>
            <td>창작자</td>
            <td><input type="text" v-model="writer" flat solo></td>
          </tr>
          <!--
          <tr>
            <td>작성자</td>
            <td><input type="text" v-model="writer" v-on:change="handleEmail()" flat solo></td>
          </tr>
          -->
          <tr>
            <td>카테고리</td>
            <td><v-select :items='items' input type="text" v-model="category"></v-select></td>
          </tr>
          <tr>
            <td>이미지</td>
            <td><label>Files
                <input type="file" id="files" ref="files" height="100%" width="100%" multiple v-on:change="handleFileUpload()">
            </label></td>
          </tr>
          <tr>
              <td>제목</td>
              <td><input type="text" v-model="title" flat solo></td>
          </tr>
          <tr>
              <td>요약</td>
              <td><input type="text" v-model="summary" flat solo></td>
          </tr>
          <tr>
              <td>본문</td>
              <td><textarea input type="text" v-model="content" flat solo></textarea></td>
          </tr>
          <tr>
              <td>모금 종료일</td>
              <td><input type="text" v-model="fundingEnd" flat solo></td>
          </tr>
          <tr>
              <td>목표금액</td>
              <td><input type="number" v-model="endMoney" flat solo></td>
              <!--<span class="input-group-text">원</span>-->
          </tr>
          <tr>
              <td>현재금액</td>
              <td><input type="number" v-model="nowMoney" flat solo disabled></td>
              <!--<span class="input-group-text">원</span>-->
          </tr>
      </table>
      <div>
          <v-btn class="mt-3" color="primary" tile large button type="submit" v-on:click="submitFiles()">저장</v-btn>
      </div>
      </v-sheet>
    </form>
  </div>
</template>

<script>

import axios from 'axios'

export default {
    name: 'FundingRegisterForm',
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
    computed: {
        
    },
    methods: {
        onSubmit () {
            const { writer, category, title, image,  content, summary, fundingEnd, endMoney, nowMoney } = this
            this.$emit('submit', { writer, category, title, image, content, summary, fundingEnd, endMoney, nowMoney })
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
        /*
        handleEmail () {
            this.writer = this.$refs.member.email
        }
        */
    }
}
</script> 

<style scoped>
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

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