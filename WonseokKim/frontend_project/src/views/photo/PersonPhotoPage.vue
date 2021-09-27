<template>
<v-container>
    <coverflow :coverList="coverList" :coverWidth="400" :index="1"></coverflow>
</v-container>
</template>

<script>
import coverflow from 'vue-coverflow'
export default {
    name: 'CoverflowTestPage',
    data () {
        return {
            coverList: [
                {
                    cover: 'https://images.unsplash.com/photo-1529333166437-7750a6dd5a70?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTh8fGZyaWVuZHxlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&w=1000&q=80',
                    title: 'Friends'
                }, {
                    cover: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRsrGLD9XzOSIYnUjZcER1K4F8q_vDWTtmiEX86R-NDwsXWrvDVaubw0cZ_flv-ibwmAV4&usqp=CAU',
                    title: 'Graduation'
                }, {
                    cover: 'https://bsmedia.business-standard.com/_media/bs/img/article/2020-03/20/full/1584724669-8489.jpg',
                    title: 'Working'
                }, {
                    cover: 'https://cdn.cdnparenting.com/articles/2019/01/21120025/1195922569-H.jpg',
                    title: 'Jogging'
                }, {
                    cover: 'https://www.brides.com/thmb/nCyGXpfYepGFL70qVcTftfmzte4=/1800x1202/filters:fill(auto,1)/GEORGINASAMUEL_1534-9bf58940d6644a4ea82c8a37a58fb838.jpg',
                    title: 'Wedding'
                }, {
                    cover: 'https://www.pickthebrain.com/blog/wp-content/uploads/2013/03/Screen-shot-2013-03-12-at-10.30.49-PM.png',
                    title: 'Baby'
                }
            ]
        }
    },
    components: {
        coverflow
    }
}
</script>