<template>
    <v-app class="d-flex h-100 text-center">
        <div class="cover-container d-flex pa-3 mx-auto flex-column">
            <header class="mb-7">
                <div class="">
                    <h3 class="logo float-md-start mb-0 d-flex justify-center">IFYOU</h3>
                    <nav v-if="isLogin" class="nav nav-masthead float-md-end d-flex justify-center">
                        <router-link class="nav-link active" :to="{path:'/'}">Home</router-link>
                        <a class="nav-link" @click="addTopic = !addTopic">AddTopic</a>
                        <router-link class="nav-link" :to="{path:'/myAccount'}">MyAccount</router-link>
                    </nav>
                    <nav v-else class="nav nav-masthead float-md-end d-flex justify-center">
                        <router-link class="nav-link active" :to="{path:'/'}">Home</router-link>
                        <router-link class="nav-link" :to="{path:'/signIn'}">SignIn</router-link>
                        <router-link class="nav-link" :to="{path:'/signUp'}">SignUp</router-link>
                    </nav>
                </div>
            </header>

        <v-dialog v-model="addTopic" max-width="500px">
          <v-card>
            <v-card-title>
              <v-radio-group v-model="board.type" row>
               <v-radio label="pros and cons" value="1"></v-radio>
                <v-radio label="balance" value="2"></v-radio>
              </v-radio-group>
            </v-card-title>
            <v-card-text>
              <v-text-field label="Topic" v-model="board.topic"></v-text-field>
              <v-divider></v-divider>
              <div v-if="board.type == 2">
                <v-text-field label="Optin1" v-model="board.op1"></v-text-field>
                <v-text-field label="Optin2" v-model="board.op2"></v-text-field>
              </div>
               <v-text-field label="Description" v-model="board.content"></v-text-field>
            </v-card-text>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn text color="rgb(255, 68, 1)" @click="insertTopic">
                Submit
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
            <v-main>
                <router-view/>
            </v-main>
        </div>
    </v-app>
</template>

<script>
export default {
  data() {
    return {
      addTopic: false,
      board: {
        type: 1,
        topic: "",
        user_id: 0,
        op1: "찬성",
        op2: "반대",
        content: "",
      },

    }
  },
  methods: {
    insertTopic() {
      this.board.user_id = this.$store.state.user.no
      this.$http.post('/api/insertTopic', {board: this.board})
          .then(res => {
            console.log(res);
            this.addTopic = false
            alert('토픽이 추가되었습니다. ')
            this.board = {}
          })
    },
  },
  created() {

  },
  mounted() {
     this.$store.state.user = this.$cookies.get("user")
     if(this.$store.state.user.email !== null) {
       this.$store.state.isLogin = true
     } else {
       console.log(this.user);
       this.$store.state.isLogin = false
     }
     console.log(this.user);

  },
  computed: {
    user() {
      return this.$store.state.user;
    },
    isLogin() {
      return this.$store.state.isLogin
    }
  }
}
</script>

<style>
    .cover-container {
        max-width: 42em;
    }
    *,
    ::after,
    ::before {
        box-sizing: border-box;
        font-family: 'SpaceMono-Regular';
    }
    .cover-container {
        width: 100%;
        height: 100%;
        max-width: 42em;
    }
    nav {
        display: flex;
        flex-wrap: wrap;
        padding-left: 0;
        margin-bottom: 0;
        list-style: none;
    }
    .nav-masthead .active {
        color: #fff;
        border-bottom-color: #fff;
    }
    .nav-masthead .nav-link:hover {
        color: rgb(255, 68, 1);
    }
    .nav-masthead .nav-link {
        padding: 0.25rem 0;
        font-weight: 700;
        color: rgba(255, 255, 255, .5);
        background-color: transparent;
        border-bottom: 0.25rem solid transparent;
    }
    .nav-link {
        display: block;
        text-decoration: none;
        transition: color 0.15s ease-in-out,background-color 0.15s ease-in-out,border-color 0.15s ease-in-out;
        font-size: 0.8em;
    }
    .nav-masthead .nav-link + .nav-link {
        margin-left: 1rem;
    }

    .v-application {
        font-family: 'SpaceMono-Regular';
        text-align: center;
    }
    header {
        font-size: 1.4em;
    }
    h3 {
        color: rgb(23, 28, 245);
    }
    @font-face {
        font-family: 'SpaceMono-Regular';
        src: url("assets/fonts/SpaceMono-Regular.ttf") format('truetype');
        font-weight: 400;
    }

    @font-face {
        font-family: 'SpaceMono-Bold';
        src: url("assets/fonts/SpaceMono-Bold.ttf") format('truetype');
        font-weight: 700;
    }
</style>