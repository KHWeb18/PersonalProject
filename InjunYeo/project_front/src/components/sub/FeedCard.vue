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
                    
            </v-card>
        </v-col>
        
    </v-row>
</template>

<script>
export default {
    name:'FeedCard',
    methods:{
        onFantasy(){
            const payload = '정통판타지'
            this.$emit('categoryChange',payload)
        },
        onRomance(){
            const payload  = '로맨스판타지'
            this.$emit('categoryChange',payload)
        },
        onOrigin(){
            const payload = '무협'
            this.$emit('categoryChange',payload)
        },
        onAnother(){
            const payload = '이세계'
            this.$emit('categoryChange',payload)
        },
        onDark(){
            const payload = '다크판타지'
            this.$emit('categoryChange',payload)
        },
        onUrban(){
            const payload = '현대판타지'
            this.$emit('categoryChange',payload)
        },

    }
}
</script>