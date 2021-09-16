<template>
    <div id="album">
        <h2>추천 게시판</h2>
        <router-link :to="{ name: 'AlbumRegisterPage' }">
            게시물 작성
        </router-link>
        <album-list :albums="albums"/>
    </div>
</template>

<script>

import AlbumList from '@/components/album/AlbumList.vue'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'AlbumListPage',
    components: {
        AlbumList
    },
    computed: {
        ...mapState(['albums'])
    },
    mounted () {
        this.fetchAlbumList()
    },
    methods: {
        ...mapActions(['fetchAlbumList'])
    }
}

</script>