<template>
    <div>
        <v-sheet color="white" width="900">
        <table border="1">
            <tr>
                <td>카테고리</td>
                <td><input type="text" :value="funding.category" flat solo readonly></td>
            </tr>
            <tr>
                <td>창작자</td>
                <td><input type="text" :value="funding.writer" flat solo readonly></td>
            </tr>
            <tr>
                <td>이미지</td>
                <td align="center">
                    <v-img max-height="200" max-width="350">
                    <img :src="require(`@/assets/userUploadImage/${this.funding.image}`)"></v-img>
                </td>
            </tr>
            <tr>
                <td>제목</td>
                <td><input type="text" :value="funding.title" flat solo readonly></td>
            </tr>
            <tr>
                <td>요약</td>
                <td><input type="text" :value="funding.summary" flat solo readonly></td>
            </tr>
            <tr>
                <td>본문</td>
                <td><textarea input type="text" cols="50" rows="20" :value="funding.content" flat solo readonly></textarea></td>
            </tr>
            <tr>
                <td>모금 종료일</td>
                <td><input type="text" :value="funding.fundingEnd" flat solo readonly></td>
            </tr>
            <tr>
                <td>목표금액</td>
                <td><input type="number" :value="funding.endMoney" flat solo readonly></td>
                <!--<td>{{ funding.endMoney}}</td>-->
                <span>원</span>
            </tr>
            <tr>
                <td>현재금액</td>
                <td><input type="number" :value="funding.nowMoney" flat solo readonly></td>
                <!--<td>{{ funding.nowMoney }}</td>-->
                <!--<td><input type="number" v-model="funding.nowMoney" flat solo readonly></td>-->
                <span>원</span>
            </tr>
        </table>
      </v-sheet>
    </div>
</template>

<script>

export default {
    name: 'FundingReadForm',
    props: {
        funding: {
            type: Object,
            required: true
        },
    },
}
</script>

<style scoped>
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

img {
  width: 300px;
  height: 200px;
  object-fit: cover;
}
</style>
