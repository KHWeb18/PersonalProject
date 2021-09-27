<template>

    <v-container>
         <div>
        <!--
        <h3>File Upload Result: </h3>
       
            <label>Files
                <input type="file" id="files" ref="files" multiple v-on:change="handleFileUpload()">
            </label>
            <button v-on:click="submitFiles()">업로드!</button>
            -->

            <v-file-input type="file" id="files" ref="files" label="File input" @change="handleFileUpload()" v-model="files"></v-file-input>
            <v-btn @click="upload" color="primary">Upload</v-btn>
            <p>{{files.name}}</p>
        
        </div>
        
    </v-container>
</template>

<script>
import axios from 'axios'
// import snakecaseKeys from 'snakecase-keys'
export default {
    name: 'FileUploadPage',
    data () {
        return {
            files: '',
            image: ''
        }
    },
    methods: {
        handleFileUpload () {
            this.files = this.$refs.files.files
        },
        submitFiles () {
            let formData = new FormData()
            for (var idx = 0; idx < this.files.length; idx++) {
                formData.append('fileList', this.files[idx])
            }
            axios.post('http://localhost:9999/file/uploadImg', formData, {
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
        upload() {
      var formData = new FormData();
      for (var idx = 0; idx < this.files.length; idx++) {
                formData.append('fileList', this.files[idx])
            }
       axios.post('http://localhost:9999/file/uploadImg', formData, {
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            }).then( response => {
            console.log('SUCCESS!!');
            console.log(response.data)
          })
          .catch(function () {
            console.log('FAILURE!!');
          });
    }
       
       
    }
}
</script>