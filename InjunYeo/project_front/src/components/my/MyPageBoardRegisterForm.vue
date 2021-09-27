<template>
        <v-container>
            <h3>마이페이지 게시글 등록</h3>
                <table>
                    <tr>
                        <td>제목</td>
                        <td><input type="text" v-model="title"></td>
                    </tr>
                    <tr>
                        <td>본문</td>
                        <td><textarea cols="50" rows="20" v-model="content"></textarea></td>
                    </tr>
                    <tr>
                        <td>태그</td>
                        <td>
                            <input type="text" v-model="tag">
                        </td>
                    </tr>
                </table>
                    <v-btn color="teal darken-1" text @click="btnBoardRegister">
                        등록
                    </v-btn>
        </v-container>  
</template>

<script>
import axios from 'axios'
//import { mapState } from 'vuex'



export default {
    name:'MyPageBoardRegisterForm',
    props:{
        category:{
            Type: String,
            required:true
        }

    },
    data(){
        return{
            title:'',
            content:'',
            writer:'',
            tag:''
        }
    },
    mounted(){
        
        if( this.$cookies.get('user').email != null){
            this.writer = this.$cookies.get('user').email
        }else{
            alert('실패')
        }
    },
    computed:{
        //...mapState(['session'])
    },
    methods:{
        btnBoardRegister(){
            const{ title, content,writer,tag,category } = this
            if(title == ''){
                alert('제목을 작성해주세요!')
            }else{
                axios.post('http://localhost:9999/user-my/my-page-board-register',{title, content,writer,tag,category})
                .then(res=>{
                    if(res.data == true){
                        alert('등록성공')
                        this.$router.push({name:'MyPageBoardCategory', query:{category: category }})
                        
                    }
                })
            }

        },
    }
    
}
</script>

<style scoped>
td{
    border: 1px solid black;
}
</style>