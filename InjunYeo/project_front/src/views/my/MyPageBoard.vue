<template>
    <v-container >
        <v-container v-if="isLogin">
        <v-card 
            class="mx-auto my-12"
            max-width="374"
            align="end">
            <div align="center">
                <h1>{{this.email}} 의 책장</h1>
            </div>
        </v-card> 
            <my-category-card-choice></my-category-card-choice>
        </v-container>
        <v-container v-else>
            <p>로그인 먼저 해주세요!</p>
        </v-container>
    </v-container>
     
</template>

<script>
import MyCategoryCardChoice from '../../components/my/MyCategoryCardChoice.vue'
export default {
  components: { MyCategoryCardChoice },
  data(){
      return{
          isLogin:false,
          email:''
      }

  },
  mounted(){
    if(this.$cookies.get('user').email != null ) {
        this.isLogin = true
        this.email = this.$cookies.get('user').email
    }else{
        this.isLogin = false
    }
  },

    
}
</script>