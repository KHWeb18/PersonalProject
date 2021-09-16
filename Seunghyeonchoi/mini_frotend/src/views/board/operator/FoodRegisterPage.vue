<template>
    <div style="min-height:900px;">
        <v-spacer style="background-color: #212121;height: 90px;"></v-spacer>
        <div class="title_image">
            <img src="@/assets/img/logo4.png" width="100" class="item"></div>
        <v-container class="box01">
        <food-register-form/>
        </v-container>
        <v-spacer></v-spacer>
    </div>
</template>

<script>
import FoodRegisterForm from '@/components/admin/FoodRegisterForm.vue'

export default {
    name: 'FoodRegisterPage',
    components: {
        FoodRegisterForm
    },
    data () {
        return {
            isLogin: false
        }
    }
}
</script>


<style scoped>
.box01 {
    width: 1000px;
}
.background_image {
    background-repeat: no-repeat;
    background-position: 40% 0;
    background-size: auto;
}
.title_image {
    display: flex;
    justify-content: center;
    margin: 30px;
    margin-bottom: 20px;
    margin-top: 20px;
}
.board_title {
    text-align: center;
    font-size: 32px;
    font-weight: 700;
    line-height: 32px;
    color: #333d4b;
    margin-bottom: 60px;
}
</style>