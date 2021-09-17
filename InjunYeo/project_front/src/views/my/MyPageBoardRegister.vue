<template>
    <div>
        <my-page-board-register-form :category="$route.query.category"></my-page-board-register-form>
    </div>
</template>

<script>
import MyPageBoardRegisterForm from '../../components/my/MyPageBoardRegisterForm.vue'
export default {
  name:"MyPageBoardRegister",
  components: { MyPageBoardRegisterForm },
  mounted(){
    
  }
  
}
</script>