<template>
  <div>
    <div class="back">
      <link rel="preconnect" href="https://fonts.googleapis.com" />
      <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
      <link
        href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Jua&display=swap"
        rel="stylesheet"
      />

      <div align="center">
        <h2>후기 작성</h2>
        <board-register-form @submit="onSubmit" />
      </div>
    </div>
  </div>
</template>

<script>
import BoardRegisterForm from "@/components/board/BoardRegisterForm.vue"
import axios from "axios"

export default {
  name: "BoardRegisterPage",
  components: {
    BoardRegisterForm,
  },
  methods: {
    onSubmit(payload) {
      const { writer, content, area, store, rating } = payload
      axios
        .post('http://localhost:7777/board/register', {writer, content, area, store, rating })
        .then(res => {
          alert('소중한 후기 감사드립니다.' + res)
          this.$router.push('/board')
        })
        .catch(res => {
          alert(res.response.data.message);
        })
    }
  }
}
</script>

<style scoped>
.back {
  background: url("../assets/img/back1.jpg");
  background-size: cover;
  height: 100vh;
  font-family: "Do Hyeon", sans-serif;
  font-family: "Jua", sans-serif;
}
h2 {
  text-align: center;
  color: gray;
}
</style>