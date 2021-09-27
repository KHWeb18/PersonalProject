<template>
 <div>
        
        <table border="1">
            <tr v-if="!boards || (Array.isArray(boards) && boards.length === 0)">
                <td colspan="4">
                    현재 등록된 게시물이 없습니다!
                </td>
            </tr>
            
            <tr v-else v-for="(board, idx) in boards" :key="idx">
                
                
               
                <router-link :to="{ name: 'BoardReadPage',
                                    params: { boardNo: board.boardNo.toString() } }">
                <td><img :src="require(`@/assets/img/${board.img}`)" style="width:300px; height:300px;"></td>
                
                   <td>{{board.title}} <br><br> {{board.writer}} <br><br>
                   <br><br> {{board.content}} <br><br> {{board.nowfunding}} / {{board.funding}}</td>
                </router-link>
                <td>
                   
             <v-dialog v-model="loginDialog" persistent max-width="500px">
            <template v-slot:activator="{ on }">
                <v-btn color="primary" dark v-on="on">후원하기</v-btn>
            </template>
            <v-card>
                <v-card-title>
                    <span class="headline">
                        후원
                    </span>
                </v-card-title>
                <v-card-text>
                    <v-container grid-list-md>
                        <v-layout wrap>
                            <v-flex xs12>
                                <v-text-field label="nowfunding" v-model="board.nowfunding" required flat solo>
                                </v-text-field>
                            </v-flex>
                            
                        </v-layout>
                    </v-container>
                </v-card-text>
                <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="teal darken-1" text @click="btnCancel()">
                        취소
                    </v-btn>
                    <v-btn color="teal darken-1" text @click="btnLoginClick($event)">
                        확인
                    </v-btn>
                </v-card-actions>
            </v-card>
        </v-dialog>
          
            
                </td>
                              
            </tr>
           
        </table>
    </div>
   
    
    
     



</template>



<script>

export default {
    
    name: 'BoardList',
    data() {
        return {
             headerTitle: [
                { text: '번호', value: 'boardNo', width: "70px" },
                { text: '제목', value: 'title', width: "200px" },
                { text: '작성자', value: 'writer', width: "100px" },
                { text: '내용', value: 'content', width: "100px" },
                { text: '목표금액', value: 'funding', width: "50px" },
                { text: '현재모금액', value: 'nowfunding', width: "50px" },
                { text: '', value: 'img', width: "50px"}
            ],
            loginDialog: false
            
           
            
            
        }
    },
    props: {
        boards: {
            type: Array
            
        },
        boardNo: {
            type: String,
            required: true
        },
         board: {
            type: Object,
            required: true
        }

    },
 
 
    methods: {
        readItem() {
            
            const board = this.boards
            
            this.$router.push({ name: 'BoardReadPage',
                                    params: { boardNo: board.boardNo.toString() }})
        },
        
         onSubmit () {
            const { nowfunding } = this
            this.$emit('submit', { nowfunding })
        },
        btnCancel() {
             this.$router.push({ name: 'BoardListPage'})
        
        },
       
    
    }
    
}
</script>


<style scoped>

td {
    text-align: right;
}
</style>