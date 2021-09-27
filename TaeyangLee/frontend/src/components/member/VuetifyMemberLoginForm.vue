<template>
 <v-app id="app">
      <v-main>
           <v-container style="position: relative; top: 20%; margin-left: 20%" class="text-xs-center" >
                <v-layout row wrap class="text-xs-center">
                 <v-flex>
                 <v-card flat class="mx-auto" max-width="700">
                <v-row style="margin-top: 60px"> <v-col> 
                <v-form style="width: 700px; height: 400px"> 
                <div class="mx-3"> <v-icon color="black" size="30px">person</v-icon>
                 ID
                <div class="mx-1">
                 <v-text-field placeholder="ID" v-model="id" required >
                </v-text-field>
                 </div>
                  </div> 
                  <div class="mx-3"> 
                    <v-icon color="black" size="30px">lock</v-icon>
                     Password
                    <div class="mx-1">
                     <v-text-field placeholder="Password" type="password" v-model="pw" required 
                     ></v-text-field> 
                     </div> 
                     </div> 
                     <v-card-actions> 
                    <v-btn color="#B5B2FF" dark large block @click="onSubmit" >Login</v-btn>
                     </v-card-actions>
                  </v-form>
                      </v-col> 
                      </v-row> 
                       </v-card> 
              </v-flex> 
          </v-layout> 
            </v-container> 
          </v-main> 
         </v-app> 
</template>






<script>
export default {
    name: 'VuetifyMemberLoginForm',
    data () {
        return {
            id: '',
            pw: ''
        }
    },
    methods: {
        onSubmit () {
            const { id, pw } = this
            this.$emit('submit', { id, pw })
        },
        goHome() {
             this.$router.push({
                            name: 'Home'
                            
                        })
        }
        
    }
}
</script>