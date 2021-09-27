<template>
    <div class="p">
        <table border="1">
            <br>
            <br>
            <tr >
                <th align="center" width="100" >번호</th>
                <th align="center" width="300">카페 | 용품매장</th>
                <th align="center" width="450">방문매장</th>
                <th align="center" width="300">평점</th>
                <th align="center" width="150">작성자</th>
                <th align="center" width="240">등록일자</th>
            </tr>
            <tr v-if="!boards || (Array.isArray(boards) && boards.length === 0)">
                <td colspan="4" style="color:black">
                    현재 등록된 게시물이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="board in boards" :key="board.boardNo">
                <td align="center">{{ board.boardNo }}</td>
                <td align="center">{{ board.store }}</td>
                <td align="center">
                    <router-link :to="{ name: 'BoardReadPage',
                                    params: { boardNo: board.boardNo.toString() } }">
                        {{ board.area }}
                    </router-link>
                </td>
                <td align="center">{{ board.rating }}</td>                
                <td align="center">{{ board.writer }}</td>
                <td align="center">{{ board.regDate }}</td>
            </tr>
        </table>
    </div>
</template>

<script>
export default {
    name: 'BoardList',
    props: {
        boards: {
            type: Array
        }
    }
}
</script>

<style scoped>
.p{
    color: gray;
    font-size: 20px;
    font-weight:lighter ;
}
th{
    font-weight: lighter;
}
</style>