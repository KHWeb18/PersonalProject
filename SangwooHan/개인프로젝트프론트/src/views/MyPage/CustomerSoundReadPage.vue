<template>
    <div>
        <v-container>
            <my-information-menu/>
        <customer-sound-read-page-form v-if="CustomerSound" :CustomerSound="CustomerSound"/>
        </v-container>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import CustomerSoundReadPageForm from '../../components/MyPage/CustomerSoundReadPageForm.vue'
import MyInformationMenu from '../../components/MyPage/MyInformationMenu.vue'

export default {
    name: 'CustomerSoundReadPage',
  components: { CustomerSoundReadPageForm, MyInformationMenu,  },
  props: {
      boardNo: {
          type: Number,
          required :true
      }
  },
  computed: {
      ...mapState(['CustomerSound'])
  },
  methods:{
      ...mapActions(['fetchCustomerSound'])
  },
  created(){
      this.fetchCustomerSound(this.boardNo)
  }

    
}
</script>