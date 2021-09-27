<template>
    <div>
        <v-container>
            <my-information-menu/>
        <customer-sound-list-form/>
        <v-btn  style="margin-left:1420px" route :to="{name: 'PersonalQuestionRegister'}">글쓰기</v-btn>
        </v-container>
    </div>
</template>

<script>
import CustomerSoundListForm from '../../components/MyPage/CustomerSoundListForm.vue'
import MyInformationMenu from '../../components/MyPage/MyInformationMenu.vue'

export default {
    name: 'CustomerSoundPage',
    components: {
        CustomerSoundListForm,
        MyInformationMenu,
    }
}
</script>
<style scoped>

</style>