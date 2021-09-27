<template>
    <div align="center">
        <h2>앨범 읽기</h2>
        <album-read v-if="album" :album="album"/>
        <p v-else>로딩중 ...... </p>
        <router-link :to="{ name: 'AlbumModifyPage', params: { albumNo } }">
            앨범 정보 수정
        </router-link>
        <button @click="onDelete">앨범 삭제</button>
        <router-link :to="{ name: 'AlbumListPage' }">
            앨범 보기
        </router-link>
    </div>
</template>

<script>

import AlbumRead from '@/components/album/AlbumRead.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
    name: 'AlbumReadPage',
    props: {
        albumNo: {
            type: String,
            required: true
        }
    },
    components: {
        AlbumRead
    },
    computed: {
        ...mapState(['album'])
    },
    created () {
        this.fetchAlbum(this.albumNo)
                .catch(err => {
                    alert(err.response.data.message)
                    this.$router.push()
                })
    },
    methods: {
        ...mapActions(['fetchAlbum']),
        onDelete () {
            const { albumNo } = this.album
            axios.delete(`http://localhost:7777/vuealbum/${albumNo}`)
                    .then(() => {
                        alert('삭제 성공!')
                        this.$router.push({ name: 'AlbumListPage' })
                    })
                    .catch(err => {
                        alert(err.response.data.message)
                    })
        }
    }
}

</script> 