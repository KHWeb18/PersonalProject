<template>
    <v-row justify="center" no-gutters>
        <v-col cols="2">
            <v-card
                class="mx-4"
                max-width="320"                   
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
                        @click="feedFantasy"
                    >
                        Explore
                    </v-btn>

                <v-spacer></v-spacer>
                </v-card-actions>
            </v-card>
        </v-col>
        <v-col cols="2">
            <v-card
                class="mx-4"
                max-width="320"
                @click="feedFantasy"                   
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
                        @click="feedRomance"
                    >
                        Explore
                    </v-btn>

                <v-spacer></v-spacer>
                </v-card-actions>
            </v-card>
        </v-col>
        <v-col cols="2">
            <v-card
                class="mx-4"
                max-width="320"   
                @click="feedOrigin"                
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
                    >
                        Explore
                    </v-btn>

                <v-spacer></v-spacer>
                </v-card-actions>
            </v-card>
        </v-col>
        <v-col cols="2">
            <v-card
                class="mx-4"
                max-width="320"  
                @click="feedAnother"                 
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
                    >
                        Explore
                    </v-btn>

                <v-spacer></v-spacer>
                </v-card-actions>
            </v-card>
        </v-col>
        <v-col cols="2">
            <v-card
                class="mx-4"
                max-width="320"    
                @click="feedDark"               
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
                    >
                        Explore
                    </v-btn>

                <v-spacer></v-spacer>
                </v-card-actions>
            </v-card>
        </v-col>
                <v-col cols="2">
            <v-card
                class="mx-4"
                max-width="320" 
                @click="feedUrban"                  
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
                    >
                        Explore
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
        feedFantasy(){
            this.$router.push({name:'SubPage', query:{category:'정통판타지'}})
        },
        feedRomance(){
            this.$router.push({name:'SubPage', query:{category:'로맨스판타지'}})
        },
        feedOrigin(){
            this.$router.push({name:'SubPage', query:{category:'무협'}})
        },
        feedAnother(){
            this.$router.push({name:'SubPage', query:{category:'이세계'}})
        },
        feedDark(){
            this.$router.push({name:'SubPage', query:{category:'다크판타지'}})
        },
        feedUrban(){
            this.$router.push({name:'SubPage', query:{category:'현대판타지'}})
        }
    }
}
</script>