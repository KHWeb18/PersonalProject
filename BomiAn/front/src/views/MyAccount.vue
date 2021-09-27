<template>
  <div>
    <my-profile v-on:changeNickname="changeNickname"
                v-on:signOut="signOut"></my-profile>
    <div class="my-5"></div>
    <my-boards v-bind:boards="boards"
                v-on:deleteMyBoard="deleteMyBoard"
                v-on:updateMyBoard="updateMyBoard"
    ></my-boards>
  </div>
</template>

<script>
import MyProfile from '../components/MyProfile.vue'
import MyBoards from '../components/MyBoards.vue'
export default {
  components: { MyProfile, MyBoards },
  data() {
    return {
      boards: []
    }
  },
  created() {
    this.getUserBoards();
  },
  mounted() {
    if(this.$store.state.user == null) {
      this.$router.push('/')
      alert('로그인 후 이용해주세요.')
    }
  },
  methods: {
      signOut() {
      this.$cookies.remove("user")
      this.$store.commit("user", {})
      alert('sign out success!')
      this.$router.push('/')
      this.$store.state.isLogin = false
    },
    changeNickname(nickname) {
      const id = this.$store.state.user.no
      this.$http.post(`/api/changeNickname/${id}`, {nickname: nickname})
          .then(res => {
            this.$store.commit("user", res.data.userInfo)
            this.$cookies.set("user", res.data.userInfo)
            alert(res.data.message)
          })
    },
    getUserBoards() {
      const id = this.$store.state.user.no
      this.$http.get(`/api/getUserBoards/${id}`)
          .then(res => {
            this.boards = res.data
          })
    },
    deleteMyBoard(id) {
      this.$http.post(`/api/deleteMyBoard/${id}`)
          .then(res => {
            console.log(res.data);
            alert('게시글 삭제가 완료되었습니다.')
            this.getUserBoards();
          })
    },
    updateMyBoard(board) {
      this.$http.post('/api/updateMyBoard', {board: board})
          .then(res => {
            console.log(res.data);
            alert('게시글 수정이 완료되었습니다.')
            this.getUserBoards();
          })
    }
  },
}
</script>