<template>
    <div>
        <h3>공지사항 읽기</h3>
        <table>
            <tr>
                <td>글번호</td>
                <td><input type="text" :value="notice.noticeNo" readonly></td>
            </tr>
            <tr>
                <td>등록일자</td>
                <td><input type="text" :value="notice.regDate" readonly></td>
            </tr>
            <tr>
                <td>제목</td>
                <td><input type="text" :value="notice.title" readonly></td>
            </tr>
            <tr>
                <td>작성자</td>
                <td><input type="text" :value="notice.writer" readonly></td>
            </tr>
            <tr>
                <td>본문</td>
                <td><textarea cols="50" rows="20" :value="notice.content" readonly></textarea></td>
            </tr>
        </table>
    </div>
</template>

<script>
export default {
    name: 'NoticeRead',
    props: {
        notice: {
            type: Object,
            required: true
        }
    }    
}
</script>

<style scoped>
td, th {
  padding: 10px;
  border: 1px solid rgb(16, 209, 151);
}
body {
  padding: 0rem;
}
</style>
