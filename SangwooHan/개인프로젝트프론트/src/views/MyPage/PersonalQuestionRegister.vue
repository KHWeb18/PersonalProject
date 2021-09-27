<template>
    <div>
        <v-container>
            <my-information-menu/>
        <personal-question-register-form/>
        </v-container>
    </div>
</template>

<script>
import MyInformationMenu from '../../components/MyPage/MyInformationMenu.vue'
import PersonalQuestionRegisterForm from '../../components/MyPage/PersonalQuestionRegisterForm.vue'
export default {
    name: 'PersonalQuestionRegister',
  components: { PersonalQuestionRegisterForm, MyInformationMenu },
    
}
</script>