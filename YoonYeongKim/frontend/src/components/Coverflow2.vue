<template>
    <coverflow 
    :coverList="coverList" 
    :coverWidth="300" 
    :index="3"
    :coverShadow=true
    :coverSpace="50"
    :coverFalt=true>
    </coverflow>
</template>

<script>
import coverflow from 'vue-coverflow'
import albums from "../assets/albums.json"

export default {
    name: 'CoverflowTestPage',
    data () {
        return {
            albumimg: albums.albums,
            coverList: [
                {
                    cover: 'https://image.aladin.co.kr/product/4012/57/cover500/c692734333_1.jpg',
                    // cover: require('@/assets/logo.png'),
                }, {
                    cover: 'https://image.bugsm.co.kr/album/images/1000/202/20299.jpg',
                    title: ''
                }, {
                    cover: 'https://image.bugsm.co.kr/album/images/1000/1142/114200.jpg',
                    title: ''
                }, {
                    cover: 'https://image.aladin.co.kr/product/3947/79/cover500/3581142228_1.jpg',
                    title: ''
                }, {
                    cover: 'https://image.aladin.co.kr/product/5559/36/cover500/8678378395_1.jpg',
                    title: ''
                }, {
                    cover: 'https://image.bugsm.co.kr/album/images/500/5522/552236.jpg',
                    title: ''
                },
                 {
                    cover: 'https://upload.wikimedia.org/wikipedia/commons/thumb/a/ae/Xx_album_cover.svg/500px-Xx_album_cover.svg.png',
                    title: 'Node'
                }
            ]
        }
    },
    components: {
        coverflow
    }
}
</script>