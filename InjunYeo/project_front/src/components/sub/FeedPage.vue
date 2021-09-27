<template>
    <v-container>
        <v-card 
            class="mx-auto my-12"
            max-width="374"
            align="end">
            <div align="center">
                <h1>{{this.category}}</h1>
            </div>
        </v-card> 
        <v-card>
            <v-card-title>
                <v-text-field
                v-model="search"
                append-icon="mdi-magnify"
                label="검색"
                single-line
                hide-details
                ></v-text-field>
            </v-card-title>

            <v-data-table
            
            :headers="headerTitle"
            :items="myBoardList" 
            :items-per-page="10"
            @click:row="readBoard" 
            :search="search"
            class="elevation-1">
            </v-data-table>
        </v-card>
    </v-container>
</template>

<script>

import {mapState,mapActions} from 'vuex'


export default {
    name:'FeedPage',
    props:{
        category:{
            Type:String,
            required:true
        }
    },
    data(){
        return{
            search:'',
            headerTitle:[ 
                {text: '제목', value: 'title' },
                {text: '작성자', value: 'writer' },
                {text: '내용', value: 'content' },
            ],
            email : '',
            
        
        }
    },
    computed:{
        ...mapState(['myBoardList'])
    },
    mounted(){

          
        this.email = null     
        const {email,category } = this
        this.fetchFeedBoardList({email,category})
        
    },
    methods:{
        ...mapActions(['fetchFeedBoardList']),

        readBoard(value){ 
            this.$router.push({
                name:'MyPageBoardDetail',
                params : { boardNo: value.boardNo }
            })
            
        }
    }
}
</script>