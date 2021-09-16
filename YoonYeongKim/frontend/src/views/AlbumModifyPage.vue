<template>
    <div align="center">
        <h2>앨범 변경</h2>
        <album-modify-form v-if="album" :album="album" @submit="onSubmit"/>
        <p v-else>로딩중 .......</p>
    </div>
</template>

<script>

import AlbumModifyForm from '@/components/album/AlbumModifyForm.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
    name: 'AlbumModifyPage',
    components: {
        AlbumModifyForm
    },
    props: {
        albumNo: {
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['album'])
    },
    methods: {
        ...mapActions(['fetchAlbum']),
        onSubmit (payload) {
            console.log("payload: " + JSON.stringify(payload))
            const { title, artist, releaseYear, genre, style, country, content, image, media } = payload
            axios.put(`http://localhost:7777/vuealbum/${this.albumNo}`, 
                { title, artist, releaseYear, genre, style, country, content, image, media })
                    .then(res => {
                        alert('수정 성공!')
                        this.$router.push({
                            name: 'AlbumReadPage',
                            params: { albumNo: res.data.albumNo.toString() }
                        })
                    })
                    .catch(err => {
                        alert(err.response.data.message)
                    })
        }
    },
    created () {
        this.fetchAlbum(this.albumNo)
                .catch(err => {
                    alert(err.response.data.message)
                    this.$router.back()
                })
    }
}

</script> 