<template>
    <v-row justify="center" no-gutters>
        <v-col cols="2">
            <v-card
                class="mx-4"
                max-width="320"
                @click="onFantasy"                   
            >
                <v-img
                src="@/assets/imgs/fantasy.jpg"
                height="200px"
                ></v-img>
                <v-spacer></v-spacer>
                <v-spacer></v-spacer>
                <v-card-title>
                    정통판타지
                </v-card-title>

                <v-card-actions>
                    <v-btn
                        color="orange lighten-2"
                        text
                        @click="writeFantasy"
                    >
                        글쓰기
                    </v-btn>

                <v-spacer></v-spacer>
                </v-card-actions>
            </v-card>
        </v-col>
        <v-col cols="2">
            <v-card
                class="mx-4"
                max-width="320"   
                @click="onRomance"                 
            >
                <v-img
                src="@/assets/imgs/romance.jpg"
                height="200px"
                ></v-img>
                <v-spacer></v-spacer>
                <v-spacer></v-spacer>
                <v-card-title>
                    로맨스판타지
                </v-card-title>

                <v-card-actions>
                    <v-btn
                        color="orange lighten-2"
                        text
                        @click="writeRomance"
                    >
                        글쓰기
                    </v-btn>

                <v-spacer></v-spacer>
                </v-card-actions>
            </v-card>
        </v-col>
        <v-col cols="2">
            <v-card
                class="mx-4"
                max-width="320"  
                @click="onOrigin"                  
            >
                <v-img
                src="@/assets/imgs/china.jpg"
                height="200px"
                ></v-img>
                <v-spacer></v-spacer>
                <v-spacer></v-spacer>
                <v-card-title>
                    무협
                </v-card-title>

                <v-card-actions>
                    <v-btn
                        color="orange lighten-2"
                        text
                        @click="writeOrigin"
                    >
                        글쓰기
                    </v-btn>

                <v-spacer></v-spacer>
                </v-card-actions>
            </v-card>
        </v-col>
        <v-col cols="2">
            <v-card
                class="mx-4"
                max-width="320"  
                @click="onAnother"                  
            >
                <v-img
                src="@/assets/imgs/another.jpg"
                height="200px"
                ></v-img>
                <v-spacer></v-spacer>
                <v-spacer></v-spacer>
                <v-card-title>
                    이세계
                </v-card-title>

                <v-card-actions>
                    <v-btn
                        color="orange lighten-2"
                        text
                        @click="writeAnother"
                    >
                        글쓰기
                    </v-btn>

                <v-spacer></v-spacer>
                </v-card-actions>
            </v-card>
        </v-col>
        <v-col cols="2">
            <v-card
                class="mx-4"
                max-width="320" 
                @click="onDark"                   
            >
                <v-img
                src="@/assets/imgs/dark.jpg"
                height="200px"
                ></v-img>
                <v-spacer></v-spacer>
                <v-spacer></v-spacer>
                <v-card-title>
                    다크판타지
                </v-card-title>
                    
                <v-card-actions>
                    <v-btn
                        color="orange lighten-2"
                        text
                        @click="writeDark"
                    >
                        글쓰기
                    </v-btn>

                <v-spacer></v-spacer>
                </v-card-actions>
            </v-card>
        </v-col>
                <v-col cols="2">
            <v-card
                class="mx-4"
                max-width="320" 
                @click="onUrban"                   
            >
                <v-img
                src="@/assets/imgs/urban.jpg"
                height="200px"
                ></v-img>
                <v-spacer></v-spacer>
                <v-spacer></v-spacer>
                <v-card-title>
                    현대판타지
                </v-card-title>
                    
                <v-card-actions>
                    <v-btn
                        color="orange lighten-2"
                        text
                        @click="writeUrban"
                    >
                        글쓰기
                    </v-btn>

                <v-spacer></v-spacer>
                </v-card-actions>
            </v-card>
        </v-col>
        
    </v-row>
</template>

<script>
export default {

    methods:{
        writeFantasy(){
            this.$router.push({name:'MyPageBoardRegister', query:{category:'정통판타지'}})
        },
        writeRomance(){
            this.$router.push({name:'MyPageBoardRegister', query:{category:'로맨스판타지'}})
        },
        writeOrigin(){
            this.$router.push({name:'MyPageBoardRegister', query:{category:'무협'}})
        },
        writeAnother(){
            this.$router.push({name:'MyPageBoardRegister', query:{category:'이세계'}})
        },
        writeDark(){
            this.$router.push({name:'MyPageBoardRegister', query:{category:'다크판타지'}})
        },
        writeUrban(){
            this.$router.push({name:'MyPageBoardRegister', query:{category:'현대판타지'}})
        },

        onFantasy(){
            this.$router.push({name:'MyPageBoardCategory', query:{category:'정통판타지'}})
        },
        onRomance(){
            this.$router.push({name:'MyPageBoardCategory', query:{category:'로맨스판타지'}})
        },
        onOrigin(){
            this.$router.push({name:'MyPageBoardCategory', query:{category:'무협'}})
        },
        onAnother(){
            this.$router.push({name:'MyPageBoardCategory', query:{category:'이세계'}})
        },
        onDark(){
            this.$router.push({name:'MyPageBoardCategory', query:{category:'다크판타지'}})
        },
        onUrban(){
            this.$router.push({name:'MyPageBoardCategory', query:{category:'현대판타지'}})
        },

    }
}
</script>