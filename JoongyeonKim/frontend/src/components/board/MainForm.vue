<template>
    <div id ="container">
        <div>
        <v-carousel cycle>
        <v-carousel-item v-for="(item,i) in items" :key="i" :src="item.src">
            <!--
            <v-sheet :color="color" height="100%" tile>
                <v-row class="fill-height" align="center" justify="center"></v-row>
            </v-sheet>
            -->
        </v-carousel-item>
        </v-carousel>
        </div>
            <v-container :cols="4">
                <v-card id="listSet" class="mx-auto mt-11" max-width="800" min-height="500" v-for="funding in fundings" :key="funding.fundingNo">
                <!--<v-card id="listSet" max-width="332" v-for="funding in fundings" :key="funding.fundingNo" mb-2 xs-4 cols="4">-->
            
                <v-card-title>
                <router-link  :to="{ name: 'FundingReadPage', 
                    params: { fundingNo: funding.fundingNo.toString() } }">
                    <v-img><img :src="require(`@/assets/userUploadImage/${funding.image}`)" aspect-ratio="1"></v-img>
                </router-link>
                </v-card-title>

                <v-divider class="mx-4"></v-divider>
                <div align="ceter"  >{{funding.category}}  /  {{funding.writer}}</div>
                
                <v-card-title>
                <router-link :to="{ name: 'FundingReadPage',
                            params: { fundingNo: funding.fundingNo.toString() } }">
                            {{ funding.title }}
                </router-link> 
                </v-card-title>
                
                <v-card-text>
                <div align="justify">{{funding.summary}}</div>
                </v-card-text>

                </v-card>
            </v-container>
        </div>
</template>

<script>

//import { Swiper, SwiperSlide } from 'vue-awesome-swiper'
import 'swiper/css/swiper.css'

export default {
    name: 'MainForm',
    components: {
        //Swiper,
       // SwiperSlide,
    },
    props: {
        fundings: {
            type: Array
        }
    },
    data () {
        return {
        /*
            swiperOption: {
            loop: true,
            effect: 'coverflow',
            grabCursor: true,
            centeredSlides: true,
            slidesPerView: 'auto',
            coverflowEffect: {
                rotate: 50,
                stretch: 0,
                depth: 100,
                // 회전 많이 하고싶으면 높을수록 많이 돌아가고 
                // 그 대신 폭은 작아짐
                modifier: 0,
                slideShadows: true
            },
            pagination: {
                el: '.swiper-pagination',
                type: 'bullets'
            },
            autoplay: {
                delay: 4000
            },
            */
            items: [
                {
                src: require('@/assets/imgs/hongik.jpg'),
                },
                {
                src: require('@/assets/imgs/arium.png'),
                },
                {
                src: require('@/assets/imgs/partyRoom.jpg'),
                },
                {
                src: require('@/assets/imgs/2021sibf.jpg'),
                },
            ],
        }
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

#slideShow {
    clear: both;
    width: 100%;
    height: 400px;
    padding-top: 0px;
    padding-bottom: 60px;
    background-color: orange;
    overflow: hidden;
}


#interestFunding {
    clear: both;
    width: 100%;
    height: 100%;
    background-color: '';
    overflow: hidden;
}



#contents {
    width: 100%;
    height: 300px;
}

#tabMenu {
    float: left;
    width: 600px;
    height: 100%;
    background-color: violet;
}

#links {
    float: left;
    width: 1200px;
    height: 100%;
    background-color: skyblue;
}

.slide-3d {
    width: 100%;
    height: 400px;
    padding-top: 50px;
    padding-bottom: 50px;
}

.swiper {
    height: 100%;
    width: 1200px;
}

.swiper-slide {
        display: flex;
        justify-content: center;
        align-items: center;
        width: 680px;
        height: 300px;
        text-align: center;
        font-weight: bold;
        font-size: 2rem;
        background-color: rgb(6, 255, 230);
        background-position: center;
        background-size: cover;
}

img {
  width: 769px;
  height: 400px;
  object-fit: cover;
}
#listSet {
  margin: 40px;
  left: 10px;
  border: 100px;
}


#div1 {
  float: 0;
}

</style>



<!--
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
        height: 300px;
        text-align: center;
        font-weight: bold;
        font-size: 2rem;
        background-color: turquoise;
        background-position: center;
        background-size: cover;
    }
}
</style>>
-->


