<template>
    <v-container fluid>
        <v-window show-arrows>
            <template v-slot:prev="{ on, attrs }">
            <v-icon
            v-bind="attrs"
            v-on="on"
            color="white">mdi-chevron-left</v-icon>
            </template>
            <template v-slot:next="{ on, attrs }">
            <v-icon 
            v-bind="attrs"
            v-on="on"
            color="white">mdi-chevron-right</v-icon>
            </template>
            <v-window-item
            :value="1"
            >
                <v-card
                    height="720"
                >
                    <v-img
                    src="../../assets/imgs/queen.jpg"
                    height="720">
                        <v-row
                        class="fill-height pa-4"
                        align="center"
                        >
                            <v-col cols="12"
                            md="7"
                            offset-md="1">
                                <h1 class="display-2 font-weight-light white--text">
                                    Writer
                                </h1>
                                <div class="subheading text-uppercase pl-2 mb-4 white--text">
                                    Write your story, the most beautiful
                                </div>
                                <v-btn color="white"
                                depressed
                                outlined
                                @click="btnStart">
                                    시작하기
                                </v-btn>
                            </v-col>
            
                        </v-row>
                    </v-img>

                </v-card>
            </v-window-item>
            <v-window-item
            :value="2"
            >
                <v-card
                    height="720"
                >
                    <v-img
                    src="../../assets/imgs/tree.jpg"
                    height="720">
                        <v-row
                        class="fill-height pa-4"
                        align="center"
                        >
                            <v-col cols="12"
                            md="7"
                            offset-md="1">
                                <h1 class="display-2 font-weight-light white--text">
                                    Writer
                                </h1>
                                <div class="subheading text-uppercase pl-2 mb-4 white--text">
                                    Write your story, the most beautiful
                                </div>
                                <v-btn color="white"
                                depressed
                                outlined
                                @click="btnStart">
                                    시작하기
                                </v-btn>
                            </v-col>
            
                        </v-row>
                    </v-img>

                </v-card>
            </v-window-item>            
        </v-window>

        <v-container>
            <category-card></category-card>
        </v-container>
    </v-container>
    
</template>



<script>

import CategoryCard from '@/components/main/CategoryCard.vue'



export default {
    components:{ CategoryCard },
    data(){
        return{
            isLogin:false
        }
    },
    mounted(){
        if(this.$cookies.get('user').email != null){
        this.isLogin = true
        }else{
        this.isLogin = false
        }
    },
    methods:{
        btnStart(){
            if(this.isLogin){
                this.$router.push({
                    name:'MyPageBoard'
                })
            }
            else{
                this.$router.push({
                    name:'LoginAndRegisterPage'
                })
            }
        }
    }
}
</script>