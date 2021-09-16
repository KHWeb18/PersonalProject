<template>
     <div>
        <v-spacer></v-spacer>
        <v-container>
            <swiper class="swiper" :options="swiperOption">

                <router-link style="text-decoration: none; color:black" 
                :to="{ name: 'LoginPage' }">

                <swiper-slide>
                    <b-img :src="`${albumimg[0].image}`" alt="Image 1">
                    슬라이드 1
                    </b-img>
                </swiper-slide>
                </router-link>
                <swiper-slide>
                    <b-img :src="`${albumimg[1].image}`">
                    슬라이드 2
                    </b-img>
                </swiper-slide>
                <swiper-slide>
                    <b-img :src="`${albumimg[2].image}`">
                    슬라이드 3
                    </b-img>
                </swiper-slide>
                <swiper-slide>
                    <b-img :src="`${albumimg[3].image}`">
                    슬라이드 4
                    </b-img>
                </swiper-slide>
                <swiper-slide>
                     <b-img :src="`${albumimg[0].image}`">
                    슬라이드 5
                    </b-img>
                </swiper-slide>
                <swiper-slide>
                     <b-img src="https://image.aladin.co.kr/product/5559/36/cover500/8678378395_1.jpg">
                    슬라이드 6
                    </b-img>
                </swiper-slide>
                <swiper-slide>
                     <b-img src="https://image.bugsm.co.kr/album/images/500/309/30950.jpg">
                    슬라이드 7
                    </b-img>
                </swiper-slide>
                <div class="swiper-pagination" slot="pagination">
                </div>
            </swiper>
        </v-container>
    </div>
</template>

<script>

import { Swiper, SwiperSlide } from 'vue-awesome-swiper'
import 'swiper/css/swiper.css'
import albums from "../assets/albums.json"

export default {
    name: 'Coverflow',
    components: {
        Swiper,
        SwiperSlide
    },
    data () {
        return {
            albumimg: albums.albums,
            swiperOption: {
                loop: true,
                effect: 'coverflow',
                grabCursor: true,
                centeredSlides: true,
                slidesPerView: 'auto',
                coverflowEffect: {
                    rotate: 200,
                    stretch: 20,
                    depth: 200,
                    modifier: 1,
                    slideShadows: true
                },
                pagination: {
                    // el: '.swiper-pagination',
                    // 넘김 갯수 ture=축약, false=갯수전부보임
                    // dynamicBullets: false,
                    nextEl: '.swiper-button-next',
                    prevEl: '.swiper-button-prev',
                },
                autoplay: {
                    delay: 10000
                }
            }
        }
    }
}

</script>

<style lang="scss" scoped>

.slide-3d {
    width: 90%;
    height: 300px;
    padding-top: 50px;
    padding-bottom: 50px;
}

.swiper {
    height: 100%;
    width: 100%;

    .swiper-slide {
        display: flex;
        justify-content: left;
        align-items: left;
        width: 300px;
        height: 300px;
        text-align: center;
        font-weight: bold;
        font-size: 1.0rem;
        background-color: rgb(232, 255, 249);
        background-position: center;
        background-size: cover;
    }
}

</style>