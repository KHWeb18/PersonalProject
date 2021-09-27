<template>
<div>
    <div class="back">
          <link rel="preconnect" href="https://fonts.googleapis.com">
          <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
          <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Jua&display=swap" rel="stylesheet">

    <div>
        <v-dialog v-model="loginDialog" max-width="300px">
            
            <v-card>
                <v-flex text-center>
                    로그아웃 하시겠습니까?
                </v-flex>
                <v-card-actions>
                    <router-link :to="{ name: 'Home' }" class="nav-link" active-class="active">
                        <v-btn @click="logout" color="blue lighten-5">로그아웃</v-btn>
                    </router-link>
                    <v-spacer></v-spacer>
                    <router-link :to="{ name: 'Home' }" class="nav-link" active-class="active">
                            <v-btn color="blue lighten-5"> 취소</v-btn>
                    </router-link>
                </v-card-actions>
            </v-card>
    </v-dialog>
    </div>
    </div>
</div>
</template>

<script>
export default {
    name: 'MemberLoginPage',
    data(){
      return{
            dialog: true,
            loginDialog: true,
            
            userInfo: {
                userId: '',
                password: ''
            },
      }
    },
    methods:{
        logout () {
            this.$cookies.remove("user")
            this.isLogin = false
            this.$store.state.session = null
        }
    },
    
}
</script>

<style>
.back {
  background: url('../assets/img/back1.jpg');
  background-size: cover;
  height: 100vh;
  font-family: 'Do Hyeon', sans-serif;
  font-family: 'Jua', sans-serif;
}

</style>