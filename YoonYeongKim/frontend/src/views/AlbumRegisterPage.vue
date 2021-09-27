<template>
    <div align="center">
        <h2>게시물 작성</h2>
        <album-register-form @submit="onSubmit"/>
    </div>
</template>

<script>

import AlbumRegisterForm from '@/components/album/AlbumRegisterForm.vue'
import axios from 'axios'

export default {
    name: 'AlbumRegisterPage',
    components: {
        AlbumRegisterForm
    },
    methods: {
        onSubmit (payload) {
            const { title, artist, releaseYear, genre, style, country, content, image, media } = payload
            axios.post('http://localhost:7777/vuealbum/register', { title, artist, releaseYear, genre, style, country, content, image, media })
                    .then(res => {
                        alert('등록 성공! - ' + res)
                        // console.log('게시물 번호: ' + res.data.albumNo.toString())
                        this.$router.push({
                            name: 'AlbumListPage'
                            // params: { boardNo: res.data.albumNo.toString() }
                        })
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }
}
</script> 