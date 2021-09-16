<template>
    <div>
        <v-container>
        <table>
            <tr>
                <td>등록번호</td>
                <td><input type="text" :value="food.foodNo" readonly></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" :value="food.name" readonly></td>
            </tr>
            <tr>
                <td>등급</td>
                <td><input type="text" :value="food.gradeSelect" readonly></td>
            </tr>
            <tr>
                <td>글루텐프리</td>
                <td><input type="text" :value="food.glutenFree" readonly></td>
            </tr>
            <tr>
                <td>대상연령</td>
                <td><input type="text" :value="food.age" readonly></td>
            </tr>
        </table>
        </v-container>
    </div>
</template>

<script>
export default {
    name: 'FoodRead',
    props: {
        food: {
            type: Object,
            required: true
        }
        
    }    
}
</script> 

<style scoped>
</style>