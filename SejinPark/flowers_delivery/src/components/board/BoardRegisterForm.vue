<template>
    <form @submit.prevent="onSubmit">
        <table>
            <tr>
                <td>작성자</td>
                <td><input type="text" v-model="writer"></td>
            </tr>
            <tr>
                <td>제목</td>
                <td><input type="text" v-model="title"></td>
            </tr>
            
            <tr>
                <td>본문</td>
                <td><textarea cols="50" rows="20" v-model="content"></textarea></td>
            </tr>
        </table>

        <div>
            <v-btn type="submit">문의하기</v-btn>
            <router-link :to="{ name: 'BoardListPage' }">
                 취소
            </router-link>
        </div>
    </form>
</template>

<script>
export default {
    name: 'BoardRegisterForm',
    data () {
        return {
            writer: '',
            title: '',
            
            content: ''
        }
    },
    methods: {
        onSubmit () {
            const { writer,title, content } = this
            this.$emit('submit', { writer,title, content })
        }
    }
}
</script> 