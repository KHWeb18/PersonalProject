<template>
<div>
   <div class="slide-3d" dense>
            <swiper class="swiper" :options="swiperOption">
                <swiper-slide><img src="@/assets/img/sea.jpeg"></swiper-slide>
                <swiper-slide><img src="@/assets/img/nature.png"></swiper-slide>
                <swiper-slide><img src="@/assets/img/jeju.jpeg"></swiper-slide>
                <swiper-slide><img src="@/assets/img/friend.jpeg"></swiper-slide>
                <swiper-slide><img src="@/assets/img/newyork.png"></swiper-slide>
                <swiper-slide><img src="@/assets/img/tree.jpeg"></swiper-slide>
                <swiper-slide><img src="@/assets/img/food.jpeg"></swiper-slide>
                <div class="swiper-pagination" slot="pagination">
                </div>
            </swiper>
   </div><br><br>

   <div class="highlight">
     <v-container>
       <h2 text-aline="center">사진 하이라이트</h2>
       <v-toolbar>
         <v-layout row>
           <v-flex justify-center>
                <!-- <v-btn text>전체</v-btn>
                <v-btn text>위클리</v-btn>
                <v-btn text>메이저</v-btn> -->
                <v-tabs v-model="selectedTab"></v-tabs>
                  <!--<v-tab v-for="tab in tabs" @click="updateRoute(tab.route)"></v-tab> -->
           </v-flex>
         </v-layout>
        </v-toolbar>
     </v-container>
   </div>
   <div>
   <div class="notice">
     <h2>공지사항</h2>
     <notice-list :notices="notices"></notice-list>     
     <!--<v-data-table :headers="headerTitle"
                    :items="contents"
                    :items-per-page="10"
                    class="elevation-1">
     </v-data-table> -->
    </div>
    <div class="question">
     <h2>질문게시판</h2>
     <question-list :questions="questions"></question-list>
   </div>
   </div>
</div>
</template>

<script>

import { Swiper, SwiperSlide } from 'vue-awesome-swiper'
import NoticeList from '@/components/notice/NoticeList.vue'
import QuestionList from '@/components/question/QuestionList.vue'
import 'swiper/css/swiper.css'
import { mapState, mapActions } from 'vuex'

  export default {
    name: 'Home',
    components: {
      Swiper,
      SwiperSlide,
      NoticeList,
      QuestionList
    },
    computed: {
        ...mapState(['notices']),
        ...mapState(['questions'])
    },
    mounted () {
        this.fetchNoticeList(),
        this.fetchQuestionList()
    },
    methods: {
        ...mapActions(['fetchNoticeList']),
        ...mapActions(['fetchQuestionList'])
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
                    rotate: 50,
                    stretch: 0,
                    depth: 100,
                    // 회전 많이 맥이고 싶으면 높을수록 많이 돌아가고
                    // 그 대신 폭은 작아짐
                    modifier: 0, //아예 안주면 회전이 없어져서 일직선임 
                    slideShadows: true
                },
                pagination: {
                    el: '.swiper-pagination',
                    clickable: true
                    // dynamicBullets: true
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
.notice {
  float: left;
  text-align: center;
}
.question {
  float: right;
  text-align: center;
}
.highlight {
  text-align: center;
}
.slide-3d {
    width: 100%;
    height: 400px;
    padding-top: 5px;
    padding-bottom: 100px;
}
.swiper {
    height: 110%;
    width: 100%;
    .swiper-slide {
        display: flex;
        justify-content: center;
        align-items: center;
        width: 600px;
        height: 300px;
        text-align: center;
        font-weight: bold;
        font-size: 1.5rem;
        //background-color: darkorange;
        background-position: center;
        background-size: cover;

    }
}
</style>