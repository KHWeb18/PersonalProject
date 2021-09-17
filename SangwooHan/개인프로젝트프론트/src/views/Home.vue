<template>
<div>
   <!--<coverflow :coverList="coverList" :coverWidth="260" :index="2" id="coverflow" @click="handleClick"></coverflow> -->
   <!--
   <a @click="goMuseum"><img src="@/assets/상우/곤충박물관배너1.jpg"/></a>
   <v-container style="max-width:800px" id="vueMuseum"> 
        <v-row>
            <v-col v-for="(image,i) in images" :key="i" class="d-flex child-flex" cols="4">
                
            <a @click="InsectDetail(i)"><v-img :src="image" aspect-ratio="1" class="gery lighten-2">
              
                <template v-slot:placeholder>
                    
                <v-row class="fill-height ma-0" align="center" justify="center">
                    
                <v-progress-circular indeterminate color="grey lighten-5">
                    
                </v-progress-circular>
               
                </v-row>
                </template>
            </v-img></a>
            </v-col>
        </v-row>
    </v-container>
    <v-container style="max-width:680px" id="VueNoitice">
        <notice-list-new-form :listArray="PageArray"/>
    </v-container>
    <a @click="goShop"><img src="@/assets/상우/쇼핑몰배너다시1.png"/></a>
    <v-container style="max-width:800px" id="vueProduct">
        <v-row>
            <v-col v-for="(image,i) in products" :key="i" class="d-flex child-flex" cols="4">
                
            <a @click="ProductDetail(i)"><v-img :src="image" aspect-ratio="1" class="gery lighten-2">
              <span>추천!</span>
                <template v-slot:placeholder>
                    
                <v-row class="fill-height ma-0" align="center" justify="center">
                    
                <v-progress-circular indeterminate color="grey lighten-5">
                    
                </v-progress-circular>
               
                </v-row>665 475
                </template>
            </v-img></a>
            </v-col>        
        </v-row>
    </v-container>
  -->
  <v-carousel 
  cycle
  hide-delimiters
  height="700px">
    <v-carousel-item
      v-for="(item,i) in items" :key="i" :src="item.src" >
      <v-row class="fill-height" align="center" justify="center" >
      </v-row>
      </v-carousel-item>
  </v-carousel>

 <v-container class="pa-4 text-center">
    <v-row
      class="fill-height"
      align="center"
      justify="center"
    >
      <template v-for="(item, i) in items2">
        <v-col
          :key="i"
          cols="12"
          md="4"
        >
          <v-hover v-slot="{ hover }">
            <v-card
              :elevation="hover ? 12 : 2"
              :class="{ 'on-hover': hover }"
            >
              <v-img
                :src="item.img"
                height="225px"
              >
                <v-card-title class="text-h6 white--text">
                  <v-row
                    class="fill-height flex-column"
                    justify="space-between"
                  >
                    <p class="mt-4 subheading text-left">
                      {{ item.title }}
                    </p>

                    <div>
                      <p class="ma-0 text-body-1 font-weight-bold font-italic text-left">
                        {{ item.text }}
                      </p>
                      <p class="text-caption font-weight-medium font-italic text-left">
                        {{ item.subtext }}
                      </p>
                    </div>

                    <div class="align-self-center">
                      <v-btn
                        @click="topgapzz(i)"
                        v-for="(icon, index) in icons"
                        :key="index"
                        :class="{ 'show-btns': hover }"
                        :color="transparent"
                        icon
                      >
                        <v-icon
                          :class="{ 'show-btns': hover }"
                          :color="transparent"
                        >
                          {{ icon }}
                        </v-icon>
                      </v-btn>
                    </div>
                  </v-row>
                </v-card-title>
              </v-img>
            </v-card>
          </v-hover>
        </v-col>
      </template>
    </v-row>
  </v-container>
  
</div>
</template>

<script>
//import coverflow from 'vue-coverflow'

import axios from 'axios'
//import NoticeListNewForm from '../components/Notice/NoticeListNewForm.vue'




  export default {
    name: 'Home',

    components: {
     //   NoticeListNewForm
   //  coverflow
    
       
    },
    data(){
        return{
          items:[
               {
            src: require('@/assets/상우/배경화면뮤엘러리.jpg'),
            text: '곤충을 사랑하는 박물관',
          },
            {
            src: require('@/assets/상우/배경화면개구리와딱정이.jpg'),
            text: '곤충을 사랑하는 박물관',
          },
          {
            src: require('@/assets/상우/배경화면데이지와곤충.jpg'),
            text: '곤충을 사랑하는 박물관',
          },
           {
            src: require('@/assets/상우/배경화면나비잠자리.jpg'),
            text: '곤충을 사랑하는 박물관',
          },
          {
              src: require('@/assets/상우/배경화면하늘소.jpg'),
              text: '곤충을 사랑하는 박물관',
          },
          ],

          bgImage: require('@/assets/상우/박물관/박물관[왕사슴벌레].jpg'),

  
         
          PageArray:[],

          icons: ['mdi-arrow-right-bold-hexagon-outline'],
      items2: [
        {    
          title: '곤충박물관',
          text: `아름다운 곤충을 소개합니다.`,
          subtext: 'Let me introduce beautiful insects.',
          img: require('@/assets/상우/배경화면뮤엘러리.jpg'),
        },
        {
            
          title: '곤충쇼핑몰',
          text: '우리집도 곤충박물관이다!',
          subtext: 'InsectShoppingMall',
          img:  require('@/assets/상우/발효톱밥5LX6.jpg'),
        },
        {
          title: '커뮤니티',
          text: '우리만의 곤충이야기',
          subtext: 'top gap zz.',
          img: require('@/assets/상우/배경화면개구리와딱정이.jpg'),
        },
      ],
      transparent: 'rgba(255, 255, 255, 0)',






          /*
          coverList: [
                {
                   cover: require('@/assets/상우/나비.jpg'),
                    title: '나비',
                    route: '/SignupPage',
                    
                },

                 {
                    cover: require('@/assets/상우/매미.jpg'),
                    title: '매미'
                },

                {
                    cover: require('@/assets/상우/사슴벌레.jpg'),
                    title: '사슴벌레'
                },

                 {
                    cover: require('@/assets/상우/장수풍뎅이.jpg'),
                    title: '장수풍뎅이'
                },

                 {
                   cover: require('@/assets/상우/잠자리.jpg'),
                    title: '잠자리'
                },
                {
                    cover: require('@/assets/상우/하늘소.jpg'),
                    title: '하늘소',
                    
                },
                {
                    cover: require('@/assets/상우/박물관/박물관[왕사슴벌레].jpg'),
                    title: '하늘소',
                    
                },
            ],*/
        
        }
    },
    methods: {
        topgapzz(i){
            console.log(i)
            if(i == 0){
                this.$router.push({name: 'InsectMuseumPage'})
            }
            if(i == 1){
                this.$router.push({name: 'ShoppingMallpage'})
            }
            if(i == 2){
                this.$router.push({name: 'CommunityListPage'})
            }
        },
      removeSession () {
            axios.post('http://localhost:9999/jpamemberManage/removeSession')
                    .then(res => {
                        this.$store.state.isLogin = res.data

                        alert('로그아웃되셧습니다.')
                    })
        },
        goMuseum(){
            this.$router.push({name:'InsectMuseumPage'})
        },
        goShop(){
            this.$router.replace({name: 'ShoppingMallpage'})
        },
        
        
        InsectDetail(pictureNo){
            console.log(pictureNo)
            if(pictureNo == 0){
                this.$router.push({name:"StagbeetleReadPage", params:{boardNo: 3}})
            }
            if(pictureNo == 1){
                 this.$router.push({name:"BeetleReadPage", params:{boardNo: 1}})
            }if(pictureNo == 2){
                 this.$router.push({name:"DragonflyReadPage", params:{boardNo: 5}})
            }
            if(pictureNo == 3){
                 this.$router.push({name:"ButterflyReadPage", params:{boardNo: 9}})
            }
            if(pictureNo == 4){
                 this.$router.push({name:"SkycowReadPage", params:{boardNo: 6}})
            }
             if(pictureNo == 5){
                 this.$router.push({name:"StagbeetleReadPage", params:{boardNo: 4}})
            }
        },
        ProductDetail(pictureNo){
            console.log(pictureNo)
            if(pictureNo == 0){
                this.$router.push({name:"ProductReadPage", params:{boardNo: 4}})
            }
            if(pictureNo == 1){
                 this.$router.push({name:"ProductReadPage", params:{boardNo: 5}})
            }if(pictureNo == 2){
                 this.$router.push({name:"ProductReadPage", params:{boardNo: 28}})
            }if(pictureNo ==3) {
                 this.$router.push({name:"ProductReadPage", params:{boardNo: 3}})
            }
            if(pictureNo ==4) {
                 this.$router.push({name:"ProductReadPage", params:{boardNo: 6}})
            }
            if(pictureNo ==5) {
                 this.$router.push({name:"ProductReadPage", params:{boardNo: 25}})
            }
           
        }
      
    },
    created(){
        axios.get('http://localhost:9999/jpaNotice/noticelist')
        .then( (res)=>{
            this.PageArray = res.data
        })
    }
   
    
    
    }
    

  
</script>

<style scoped>

#coverflow{
  margin-left: 100px;
}
h3{
    font-family:fantasy ;
}
span{
    background-color: red;
    font-size: 2.5em;
}
#vueMuseum{
    float: left;
}
#VueNoitice{
    float: right;
    margin-right: 20px;
}
#vueProduct{
     float: left;
}
#vueVideo{
    position: absolute;
    margin-left: 800px;
    
}
.v-card {
  transition: opacity .4s ease-in-out;
}
.v-card:not(.on-hover) {
  opacity: 0.6;
 }
.show-btns {
  color: rgba(255, 255, 255, 1) !important;
}

</style>
