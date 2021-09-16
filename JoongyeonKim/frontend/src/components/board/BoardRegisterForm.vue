<template>
    <div id="container">
        <v-container>
            <form @submit.prevent="onSubmit">
                <table>
                    <v-text-field class="pl-3 pr-3" required v-model="email"
                                label="작성자" type="text" prepend-icon="mdi-account" flat solo>
                    </v-text-field>
                    <v-text-field class="pl-3 pr-3" required v-model="title"
                                label="제목" type="text" prepend-icon="mdi-book" flat solo>
                    </v-text-field>
                    <v-text-field class="pl-3 pr-3" required v-model="content"
                                label="내용" type="text" prepend-icon="mdi-comment-edit" flat solo>
                    </v-text-field> 
                </table>
                <div>
                    <v-btn class="mt-3" color="primary" tile large button type="submit">게시글 등록</v-btn>
                </div>
            </form>
        </v-container>
    </div>
</template>

<script>

export default {
    name: 'BoardRegisterForm',
    data () {
        return {
            email: '',
            title: '',
            content: ''
        }
    },
    mounted () {
    },
    computed: {
    },
    methods: {
        onSubmit () {
            const { email, title, content } = this
            this.$emit('submit', { email, title, content })
        },
    }
}
</script> 

<style scoped>
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

#container {
    margin: 0 auto;
    width: 1200px;
}
</style>