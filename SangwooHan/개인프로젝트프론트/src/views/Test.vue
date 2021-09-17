<template>
   <div>
       <p>내가 Test다음으로 입력한 값은 = {{ UserId }} 입니다.</p>
   </div>
</template>


<script>
export default {
    computed: {
        UserId() {
            return this.$route.params.UserId
        }
    }
}
</script>