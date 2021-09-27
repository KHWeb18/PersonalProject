<template>
    
    <div>
        <v-container>
        <h3>회원수정하기</h3>
      <member-modify-page-form :member="member" @submit="onSubmit"/>
        </v-container>
    </div>
</template>

<script>
import MemberModifyPageForm from '../../components/Management/MemberModifyPageForm.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'
export default {
  components: { MemberModifyPageForm },
    name: 'MemberModifyPage',
    props: {
        memberNo: {
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['member'])
    },
    methods: {
        ...mapActions(['fetchMember']),
        onSubmit (payload) {
            console.log("payload: " + JSON.stringify(payload)+ 'this.memberNo' +this.memberNo)
            const {memberNo, userid,password ,name, email , birthday, phoneNo ,gender,address, regDate } = payload
            axios.post(`http://localhost:9999/jpamemberManage/ModifyMember/${this.memberNo}`, {memberNo, userid,password,name, email , birthday, phoneNo ,gender,address, regDate})
            .then(res => {
                alert('수정성공' + res)
                
                this.$router.push({
                    name: 'MemberList',
                 
                })
                
            })
            .catch(err => {
                alert(err.response.data.message)
            })
        }
    },
    created() {
        this.fetchMember(this.memberNo)
                .catch(err => {
                    alert(err.response.data.message)
                    this.$router.back()
                })
    },
}
</script>