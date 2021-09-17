<template>
        <v-container>
            <h3>마이페이지 게시글 보기</h3>
                <table>
                    <tr>
                        <td>제목</td>
                        <td><input type="text" v-model="myBoard.title" readonly></td>
                    </tr>
                    <tr>
                        <td>본문</td>
                        <td><textarea cols="50" rows="20" v-model="myBoard.content" readonly></textarea></td>
                    </tr>
                    <tr>
                        <td>태그</td>
                        <td>
                            <input type="text" v-model="myBoard.tags[0].tagName" readonly> 
                        </td>
                        
                    </tr>
                </table>
        </v-container>  
</template>

<script>

export default {
    name:'MyPageBoardReadForm',
    props:{
        myBoard:{
            type: Object,
            required: true
        }
    },
    
}
</script>

<style scoped>
td{
    border: 1px solid black;
}
</style>