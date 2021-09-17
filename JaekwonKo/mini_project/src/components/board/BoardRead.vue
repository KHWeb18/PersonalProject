<template>
    <div>
        <table>
            <tr>
                <td>글번호</td>
                <td><input type="text" :value="board.boardNo" readonly></td>
            </tr>
            <tr>
                <td>카페 | 용품매장</td>
                <td><input type="text" :value="board.store" readonly></td>
            </tr>
            <tr>
                <td>방문매장</td>
                <td><input type="text" :value="board.area" readonly></td>
            </tr>
            <tr>
                <td>작성자</td>
                <td><input type="text" :value="board.writer" readonly></td>
            </tr>
            <tr>
                <td>내용</td>
                <td><textarea cols="50" rows="20" :value="board.content" readonly></textarea></td>
            </tr>
            <tr>
                <td>평점</td>
                <td><input type="int" :value="board.rating" readonly></td>
            </tr>
            <tr>
                <td>등록일자</td>
                <td><input type="text" :value="board.regDate" readonly></td>
            </tr>                     
            
        </table>
    </div>
</template>

<script>
export default {
    name: 'BoardRead',
    props: {
        board: {
            type: Object,
            required: true
        }
    }    
}
</script>

<style>
.table{
    color: black;
    font-size: 14px;
}
</style>