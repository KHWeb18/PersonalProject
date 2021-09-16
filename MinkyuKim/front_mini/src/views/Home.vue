<template>
    <div class="slide-3d">        
        <v-spacer></v-spacer>        
        <div style="background-color: #003663; height: 254px; width: 100%;">
        <!--<div :style="{ backgroundImage: 'url(http://img.khan.co.kr/news/2018/12/19/20181219010021846001706113.jpg)'}" 
                style="height: 400px; width: 3000px;">-->
            <v-container>                        
                <swiper class="swiper" :options="swiperOption">
                    <!-- 이미지는 v-image -->
                    <swiper-slide><img src="../assets/img/1.jpg" style="max-height: 300px"></swiper-slide>
                    <swiper-slide><img src="../assets/img/2.jpg" style="max-height: 300px"></swiper-slide>
                    <swiper-slide><img src="../assets/img/3.jpg" style="max-height: 300px"></swiper-slide>
                    <swiper-slide><img src="../assets/img/4.jpg" style="max-height: 300px"></swiper-slide>
                    <swiper-slide><img src="../assets/img/5.jpg" style="max-height: 300px"></swiper-slide>
                    <swiper-slide><img src="../assets/img/6.jpg" style="max-height: 300px"></swiper-slide>
                    <swiper-slide><img src="../assets/img/7.jpg" style="max-height: 300px"></swiper-slide>
                    <swiper-slide><img src="../assets/img/8.jpg" style="max-height: 300px"></swiper-slide>
                    <swiper-slide><img src="../assets/img/9.jpg" style="max-height: 300px"></swiper-slide>
                    <swiper-slide><img src="../assets/img/10.jpg" style="max-height: 300px"></swiper-slide>
                    <swiper-slide><img src="../assets/img/11.jpg" style="max-height: 300px"></swiper-slide>
                    <swiper-slide><img src="../assets/img/12.jpg" style="max-height: 300px"></swiper-slide>
                    <div class="swiper-pagination" slot="pagination">
                    </div>
                </swiper> 
                <br>
                <div class="text-center">                
                <h3>Atelier - 인테리어, 예술작품을 소장하는 가장 합리적인 방법 </h3>                  
                <br>  
                <h5>대학생, 신인작가의 수준높은 작품들을 감상해보세요</h5>
                </div>
                <br>
                <div style="border: 0px solid black; height: 300px; width: 100%">
                    <br><br><br>
                    <span style="border: 0px solid black; text-align: center; display: inline-block; 
                            width: 28%; height: 200px; margin-left: 50px;">
                            <img src="../assets/img/Exhibition1.jpg" style="height: 200px; width:350px">
                    </span>
                    <span style="border: 0px solid black; text-align: center; display: inline-block; 
                            width: 28%; height: 200px; margin-left: 50px;">
                            <img src="../assets/img/Exhibition2.jpg" style="height: 200px; width:350px">
                    </span>
                    <span style="border: 0px solid black; text-align: center; display: inline-block; 
                            width: 28%; height: 200px; margin-left: 50px;">
                            <img src="../assets/img/Exhibition3.jpg" style="height: 200px; width:350px">
                    </span>                    
                </div>                                
                
        </v-container>
        </div>        
    </div>      
    
    
</template>


<script>

import { Swiper, SwiperSlide } from 'vue-awesome-swiper'
import 'swiper/css/swiper.css'
//import Layout from '../components/layout/Layout.vue'

  export default {
    name: 'Home',
    components: {
        //Layout
        Swiper,
        SwiperSlide
    },
    data () {
        return {
            swiperOption: {
                autoHeight: true,
                loop: true,
                effect: 'coverflow',
                grabCursor: true,
                centeredSlides: true,
                slidesPerView: 'auto',
                coverflowEffect: {
                    rotate: 50,
                    stretch: -3,
                    depth: 50,
                    // 회전 많이 맥이고 싶으면 높을수록 많이 돌아가고
                    // 그 대신 폭은 작아짐, 
                    // 아예 안주면(0)이면 회전이 없어져서 일직선임(평면)
                    modifier: 7,
                    slideShadows: true
                },
                pagination: {
                    el: '.swiper-pagination',
                    dynamicBullets: true
                },
                autoplay: {
                    // 자동회전
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
    padding-top: 30px;
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
        height: 300px;
        font-weight: bold;
        font-size: 1.7rem;        
        background-color: chocolate;
        background-position: center;
        background-size: center;        
    }
}
</style> 
   
    
        
        
   
