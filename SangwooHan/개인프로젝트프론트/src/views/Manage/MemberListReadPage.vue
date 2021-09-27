<template>
    <div>
        <v-container>
     <member-list-read-form v-if="member" :member="member"/>  
     <p v-else> 로딩중</p>
     <v-btn route :to="{ name: 'MemberModifyPage', params: {memberNo}}">수정하기</v-btn>
        </v-container>
    </div>
</template>

<script>

import { mapState, mapActions} from 'vuex'
//import router from '@/router'
import MemberListReadForm from '../../components/Management/MemberListReadForm.vue'
export default {
    name: 'MemberListReadPage',
    components: {
      MemberListReadForm
    },
    props:{
        memberNo:{
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['member'])
        
    },
    created () {
        this.fetchMember(this.memberNo)
                .catch(err => {
                    alert(err.response.data.message)
                    this.$router.push()
                })
    },
    methods: {
        ...mapActions(['fetchMember']),
        //여백
       

        
        
    },
    data(){

        return{
            dialog: false,
           
        }
    }
}
</script>