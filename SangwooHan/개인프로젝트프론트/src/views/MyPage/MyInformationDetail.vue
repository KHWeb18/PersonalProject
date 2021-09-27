<template>
    <div>
        <v-container>
            <my-information-menu/>
        <form @submit.prevent="OnSubmit">
        <table  v-if="coin == 0">
            <tr style="border: none;">
          <td style="max-height: 800px"> 비밀번호 <v-text-field v-model="password" type="password" label="비밀번호" style="max-width: 150px" flat solo-inverted>
            </v-text-field>
            <p v-if="NoMatchPassword == 1"> 비밀번호가 일치하지않습니다.</p>
            <v-btn type="submit">확인</v-btn>
          </td>
            
            </tr>
            
        </table>
        </form>
        <my-information-detail-form v-if="coin == 1"/>
        <!--<v-btn @click="check">체크</v-btn>-->
        </v-container>
    </div>
</template>

<script>
import cookies from 'vue-cookies'
import Vue from 'vue'
import { mapActions, mapState } from 'vuex'
import MyInformationDetailForm from '../../components/MyPage/MyInformationDetailForm.vue'

import axios from 'axios'
import MyInformationMenu from '../../components/MyPage/MyInformationMenu.vue'

Vue.use(cookies)
export default {
    name: 'MyInformaitonDetail',

  components: {  MyInformationDetailForm, MyInformationMenu },
    computed:{
        ...mapState(['User','members',])
    },
    mounted(){
       if(this.$cookies.get('setter')){
            this.coin = this.$cookies.get('coin')
       }
        
        this.fetchMemberList()
    },
    
  methods:{
      check(){console.log(this.$cookies.get('coin'))},
      ...mapActions(['fetchMemberList']),
      /*
       OnSubmit(){
             this.setter = 1
            for(var i = 0 ; i <this.members.length; i++ ){
                
                if(this.$store.state.User == this.members[i].userid) {
                    if(this.birth == this.members[i].birthday){
                        this.coin =1
                        this.$cookies.set('coin', this.coin, '5s')
                        this.$cookies.set('setter',this.coin, '5s')
                    }
                }

            }
         }
         */
        OnSubmit(){
            this.setter = 1
            const {userid ,password} =this
            axios.post('http://localhost:9999/jpamemberManage/checkingPassword',{userid,password})
            .then((res) =>{
                console.log(res.data)
                if(res.data == true){
                    this.coin =1
                        this.$cookies.set('coin', this.coin, '1h')
                        this.$cookies.set('setter',this.coin, '1h')

                }
                else{
                    this.NoMatchPassword =1
                }
            
            })
        }
  },
  data() {

      return{
          coin: 0,
          password: 0,
          setter:0,
          userid: this.$store.state.User,
          NoMatchPassword: 0,
      }
  }
    
}
</script>
<style scoped>

p{
    color: red;
}

</style>
