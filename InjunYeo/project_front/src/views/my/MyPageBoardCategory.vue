<template>
    <v-container >
        <v-container v-if="isLogin">
            <my-category-card @categoryChange="categoryChange"></my-category-card>
            <my-page-board-list :category="category"></my-page-board-list>
        </v-container>
        <v-container v-else>
            <p>로그인 먼저 해주세요!</p>
        </v-container>
    </v-container>
     
</template>

<script>
import MyPageBoardList from '../../components/my/MyPageBoardList.vue'
import MyCategoryCard from '../../components/my/MyCategoryCard.vue'
export default {
  components: { MyPageBoardList,MyCategoryCard },
  data(){
      return{
          isLogin:false,
          category:''
      }

  },
  mounted(){
    if(this.$cookies.get('user').email != null ) {
        this.isLogin = true
        this.category = this.$route.query.category
        
    }else{
        this.isLogin = false
    }
  },
  watch:{/*
      category:function(newVal){
          this.$router.push({name:'MyPageBoardCategory', query:{category: newVal }})
      }
      */
  },
  methods:{
      categoryChange(payload){
          this.$router.push({name:'MyPageBoardCategory', query:{category: payload }})
          this.$router.go()
      }
  }
 
}
</script>