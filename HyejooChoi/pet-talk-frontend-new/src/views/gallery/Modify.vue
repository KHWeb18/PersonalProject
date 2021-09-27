<template>
  <div>
    <h1>갤러리</h1>
    <div class="form_wrap">
      <h2 v-if="id">글수정</h2>
      <h2 v-else>글쓰기</h2>
      <b-input v-model="detail.title" placeholder="제목을 입력해주세요."></b-input>
      <b-form-textarea
          v-model="detail.content"
          placeholder="내용을 입력해 주세요"
          rows="13"
          max-rows="6"
      ></b-form-textarea>
      <div class="file-box">
        <div v-if="detail.imgPath">
          <a :href="detail.imgPath">{{ detail.filename }}</a>
          <span @click="onClickDeleteBtn" style="cursor: pointer"><v-icon>mdi-window-close</v-icon></span>
        </div>
        <div v-else>
          <input type="text" class="design-input" value="파일명.jpg" v-model="fileName" readonly>
          <b-form-file accept=".jpg, .png, .gif" plain id=file1 @change="handleFile"></b-form-file>
        </div>
      </div>
    </div>

    <br>
    <b-button @click="onClickSaveBtn">저장</b-button>&nbsp;
    <b-button @click="onClickCancleBtn">취소</b-button>
  </div>
</template>
<script>
import api from "../../api/api";
export default {
  name: 'GalleryModify',
  async mounted() {
    if (this.id) {
      await api.get(`/gallery/${this.id}`)
          .then((res) => {
            this.detail.title = res.data.data.gallery.gallery.title;
            this.detail.content = res.data.data.gallery.gallery.content;
            this.detail.writer = res.data.data.gallery.user.writer;
            this.detail.createdAt = res.data.data.gallery.gallery.createdAt;
            this.detail.filename = res.data.data.gallery.gallery.filename;
            this.detail.imgPath = res.data.data.gallery.gallery.imgPath;
            console.log(res.data.data);
          })
          .catch((err) => {
            console.log(err);
            alert("갤러리 글 조회 오류");
          })
    }
  },
  data() {
    return {
      userId: this.$store.state.userInfo.id,
      id: this.$route.params.id,
      base64data: '',
      fileName: '',
      uploadFile: '',
      detail: {
        title: '',
        content: '',
        writer: '',
        createdAt: '',
        imgPath: '',
        filename: '',
      },
    }
  },
  created() {

  },
  methods: {
    async handleFile(e) {
      try {
        console.log(e);
        const file = e.target.files[0];
        let base64data = await this.readFileAsync(file);
        console.log("====> base64data : ", base64data);
        // base64data = base64data.split(',')[1];
        if(base64data === undefined){
          alert('비어있는 파일은 첨부할 수 없습니다.');
          return;
        }
        const fileInfo = {
          filename: file.name,
          // mimetype: file.type,
          base64: base64data,
        }

        // this.fileName = fileInfo.filename;
        this.uploadFile = fileInfo;
      } catch(error) {
        console.log(error);
        alert('파일 첨부 중 오류가 발생했습니다.');
      }
    },
    // File reader
    readFileAsync(file) {
      return new Promise((resolve, reject) => {
        let reader = new FileReader();
        reader.onload = () => {
          resolve(reader.result);
        };
        reader.onerror = reject;
        reader.readAsDataURL(file);
      })
    },
    async onClickSaveBtn() {
      if (this.id === undefined) {
        // 글작성
        await api.post(`/gallery/create`, {
          title: this.detail.title,
          content: this.detail.content,
          writer: this.userId,
          filename: this.uploadFile.filename,
          base64: this.uploadFile.base64,
        })
            .then((res) => {
              if (res.data.resultCode === "SUCCESS") {
                this.$router.push({name: "GalleryDetail", params: {id: res.data.data.id }});
                alert("갤러리 글 등록 성공");
              } else {
                alert("갤러리 글 등록 실패");
              }
            }).catch((err) => {
          console.log(err);
          alert("갤러리 게시판 등록 실패");
        });
      } else {
        // 글수정
        api.post(`/gallery/update/${this.id}`, {
          title: this.detail.title,
          content: this.detail.content,
          writer: this.userId,
          filename: this.uploadFile.filename,
          base64: this.uploadFile.base64,
        })
            .then((res) => {
              if (res.data.resultCode === "SUCCESS") {
                this.$router.push({name: "GalleryDetail", params: {id: this.id}});
                alert("갤러리 글 수정 성공");
              } else {
                alert("갤러리 글 수정 실패");
              }
            }).catch((err) => {
          console.log(err);
          alert("수정 실패");
        })
      }
    },
    onClickCancleBtn() {
      this.$router.push({name: "GalleryList"});
    },

    async onClickDeleteBtn() {
      if (confirm("이미지를 삭제하시겠습니까?")) {
        await api.delete(`/gallery/delete/image/${this.id}`)
            .then((res) => {
              if (res) {
                alert('이미지가 삭제 되었습니다.');
                this.detail.imgPath = '';
                this.detail.filename = '';
              }
            })
            .catch((e) => {
              console.log(e);
              alert('이미지 삭제 오류');
            })
      }
    }
  }
}
</script>

<style scoped>
.page {
  width: 1200px;
  margin-top: 100px;

  font-family: 'Gowun Dodum', sans-serif;
}

h1 {
  font-size: 33px;
  font-weight: bold;
  width: 100%;
  color: rgb(229, 119, 175);
}

.form_wrap {
  border: 1px solid rgba(0, 0, 0, 0.125);
  border-radius: 5px;
  padding: 30px 50px;
  background-color: #faf5f2;
  margin-top: 45px;
}

h2 {
  font-size: 25px;
}

input {
  width: 40%;
  margin-top: 30px;
}

textarea {
  margin-top: 10px;
}




.btn_wrap {
  width: 100%;
}

.btn {
  width: 90px;
  height: 35px;
  color: #fff;
  background-color: rgb(236, 152, 195);
  border: none;
  border-radius: 5px;
  font-size: 18px;
  line-height: 18px;
  float: right;
  font-family: 'Gowun Dodum', sans-serif;
}

.btn:nth-of-type(2) {
  background-color: #fff;
  color: #000;
  font-weight: bold;
}
</style>
