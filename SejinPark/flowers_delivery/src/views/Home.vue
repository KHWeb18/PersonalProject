<template>
     
    
     
    <div class="slide-3d">
         
        <v-container>
            <swiper class="swiper" :options="swiperOption">
                <swiper-slide>
                    <img src="https://cdn.pixabay.com/photo/2018/01/12/14/34/background-3078335_960_720.jpg">
                </swiper-slide>
                <swiper-slide  >
                    <img src="https://cdn.pixabay.com/photo/2016/05/18/17/05/rose-1400953_960_720.jpg">
                        
                </swiper-slide>
                <swiper-slide>
                    <img src="https://cdn.pixabay.com/photo/2020/02/26/07/12/mockup-4880849_960_720.jpg">
                </swiper-slide>
               
                <div class="swiper-pagination" slot="pagination">
                </div>
            </swiper>
        </v-container>
        
         
    </div>
</template>

<script>
import SessionLoginPage from '@/views/SessionLoginPage.vue'//eslint-disable-line no-unused-vars
import { Swiper, SwiperSlide } from 'vue-awesome-swiper'
import 'swiper/css/swiper.css'
export default {
    name: 'Home',
    components: {
        Swiper,
        SwiperSlide
    },
    data () {
        return {
            swiperOption: {
                loop: true,
                effect: 'coverflow',
                grabCursor: true,
                centeredSlides: true,
                slidesPerView: 'auto',
                coverflowEffect: {
                    rotate: 0,
                    stretch: 0,
                    depth: 0,
                    // 회전 많이 맥이고 싶으면 높을수록 많이 돌아가고
                    // 그 대신 폭은 작아짐
                    // 아예 안주면 회전이 없어져서 일직선임
                    modifier: 1,
                    //slideShadows: true
                },
                pagination: {
                    el: '.swiper-pagination',
                    dynamicBullets: true
                },
                autoplay: {
                    delay: 2000
                }
            }
        }
    }
}
</script>

<style lang="scss" scoped>
.slide-3d {
    width: 100%;
    height: 400px;
    padding-top: 50px;
    padding-bottom: 50px;
}
.swiper {
    height: 100%;
    width: 100%;
    .swiper-slide {
        display: flex;
        justify-content: center;
        align-items: center;
        width: 300px;
        height: 350px;
        text-align: center;
        font-weight: bold;
        font-size: 1.7rem;
        background-color: mediumpurple;
        background-position: center;
        background-size: cover;
    }
 
}
img {
    height: 130%;
    
}

</style>