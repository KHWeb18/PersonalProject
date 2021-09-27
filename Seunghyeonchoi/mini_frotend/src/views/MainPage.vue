<template>
    <div id="main">
        <v-card class="overflow-hidden">
            <v-app-bar style="z-index: 2;"
            absolute color="white" shrink-on-scroll elevate-on-scroll inverted-scroll
            scroll-target="#scrolling-techniques-7" scroll-threshold="700">
                <template v-slot:img="{ props }">
                    <v-img v-bind="props" gradient="to top right, rgba(55,255,255,0), rgba(255,255,255,0)"></v-img>
                </template>
                <v-app-bar-nav-icon></v-app-bar-nav-icon>
                <v-toolbar-content>
                    <ul class="menu1">
                        <li><a style="letter-spacing: 3px;"> CAT FOOD INFORMATION CATMORE </a></li>
                    </ul>
                </v-toolbar-content>
            </v-app-bar>      
            <v-sheet
            id="scrolling-techniques-7"
            class="overflow-y-auto"
            max-height="100vh">
                <v-carousel
                hide-delimiters
                cycle="cycle"
                height="700"
                hide-delimiter-background="hide-delimiter-background"
                show-arrows-on-hover="show-arrows-on-hover">
                    <v-carousel-item v-for="(item,i) in items"
                    :key="i"
                    :src="item.src"></v-carousel-item>
                </v-carousel>   
                <div style="height: 900px;">
                    <div style="display:flex;justify-content:space-evenly;">
                        <router-link :to="{ name: 'FoodRecommendPage' }">
                            <div class="image-wrap" style="width:30vw;margin:10px;margin-right:40px">
                                <p></p>
                            <div class="iamge_wrap" style="width:500px;">
                                <fade-up-image
                                src="https://i.imgur.com/9pUfcpd.png"
                                src-placeholder="https://cdn-images-1.medium.com/max/30/1*TeymfgOgswgMnEJeYoYsVg.jpeg"/>
                                    <div class="btn-plus3"><span draggable="false">&#10140;</span></div></div>
                            </div>
                        </router-link>
                        <router-link :to="{ name: 'FoodListPage' }">
                            <div class="image-wrap" style="width:30vw;margin:10px;margin-left:40px">
                                <p></p>
                                <div class="iamge_wrap" style="width:500px;">
                                    <fade-up-image
                                    src="https://i.imgur.com/LdKcF4q.png"
                                    src-placeholder="https://cdn-images-1.medium.com/max/30/1*TeymfgOgswgMnEJeYoYsVg.jpeg"/>
                                    <div class="btn-plus3"><span draggable="false">&#10140;</span></div></div>
                            </div>
                        </router-link>
                    </div>
                    <div style="text-align: center;">
                        <div style="display: inline-block;"><img src="@/assets/logo2.png" class="img_test"></div>
                    </div>        
                    <div
                        style="display:flex;justify-content:space-evenly;position:relative;top:-50px;">
                        <router-link :to="{ name: 'FreeBoardListPage' }">
                            <div class="image-wrap" style="width:30vw;margin:10px;margin-right:40px">
                                <p></p>
                                <div class="iamge_wrap" style="width:500px;">
                                    <fade-up-image
                                        src="https://i.imgur.com/cfTL5zo.png"
                                        src-placeholder="https://cdn-images-1.medium.com/max/30/1*TeymfgOgswgMnEJeYoYsVg.jpeg"/>
                                    <div class="btn-plus3">
                                        <span draggable="false">&#10140;</span>
                                    </div>
                                </div>
                            </div>
                        </router-link>
                    </div>

                    <div class="temp01">
                        <v-container class="food_box2">
                            <div v-for="mob in paginatedData" :key="mob.boardNo" class="item">
                                <div class="iamge_wrap">
                                    <router-link
                                        :to="{ name: 'FreeBoardReadPage',
                                                    params: { boardNo: mob.boardNo.toString() } }">
                                        <v-img :src="CommunityImgRequest(mob.writer, mob.boardNo)" aspect-ratio="1"></v-img>
                                        <div class="btn-plus">
                                            <span draggable="false">&#10140;</span>
                                        </div>
                                        <div class="btn-plus2">
                                            <span draggable="false"></span>
                                        </div>
                                    </router-link>
                                </div>
                            </div>
                        </v-container>
                    </div>
                </div>
            </v-sheet>
        </v-card>
    </div>
</template>



<script>

import FadeUpImage from './effect/FadeUpImage';
import { mapState, mapActions } from 'vuex'

export default {
  components: {
    FadeUpImage,
    },
    data () {
      return {
        slides: [
          'First',
          'Second',
          'Third',
          'Fourth',
          'Fifth',
        ],
        items: [
          {
            src: require('@/assets/img/mainLogo01_001.png'),
          },
          {
            src: require('@/assets/img/mainLogo02.png'),
          },
          {
            src: require('@/assets/img/mainLogo03.png'),
          }
        ],
        isActive: false,
        e1: 1,
        pageNum: 1,
        pageSize: {
                type: Number,
                required: false,
                default: 10
            }
      }
    },
    computed: {
        ...mapState(['boards']),
        ...mapState ({
            lists: state => state.lists
        }),
        pageCount() {
            let listLength = this.boards.length, // 길이
                listSize = this.pageSize,
                page = Math.floor(listLength / listSize);
            if (listLength % listSize > 0) 
                page += 1;
            return page;
        },
        paginatedData() {
            return this
                .boards
                .slice(0, 6);
                }
        },
        mounted () {
            this.fetchFreeBoardList()
        },
        methods: {
            ...mapActions(['fetchFreeBoardList']),
            CommunityImgRequest( a, b ) {
                try {
                    return require(`../../../Mini/Images/free/${a}_${b}.gif`
                    )
                } catch (e) {
                    return require(`@/assets/logo.png`)
                    }
            },
            nextPage() {
                this.pageNum += 1;
            },
            prevPage() {
                this.pageNum -= 1;
            }
        }
    }
</script>

<style scoped="scoped" > 

.main_background_image_first {
    transition: 20s;
}
.image-wrap {
    width: 100vh;
}
.logo-area {
    display: flex;
    justify-content: space-between;
}
.logo-area2 {
  display: flex;
  flex-wrap: wrap;
	align-content: center;
}
.v-lazy-image {
    width: 100%;
}
.image_highlight {
    width: 150px;
    box-shadow: 10px 17px 40px 0 rgb(0 0 0 / 25%);
}
.v-image.v-responsive {
    padding: 0;
    margin: 12px;
    box-shadow: 10px 17px 40px 0 rgb(0 0 0 / 25%);
}
.v-image.v-responsive:hover {
    box-shadow: 10px 17px 40px 0 rgb(0 0 0 / 25%);
    cursor: pointer;
    transition: all 1s ease;
}
@font-face {
    font-family: 'Recipekorea';
    src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/Recipekorea.woff") format('woff');
    font-weight: normal;
    font-style: normal;
}
* {
    margin: 0;
    padding: 0;
}
a,
a:link {
    color: white;
    text-decoration: none;
    font-family: 'Recipekorea';
}
ul {
    list-style: none;
    display: flex;
    justify-content: center;
}
ul li a {
    display: block;
    padding: 18px 2vw 1vw;
    position: relative;
}
ul li a::after {
    content: '';
    display: block;
    position: absolute;
    bottom: 18px;
    z-index: -1px;
}
.menu1 {
    width: 80vw;
}
.menu1 li {
  padding-bottom: 19px;
}
.menu1 li a::after {
  width: 0;
  height: 0.7vw;
  background: #880000;
  left: 30%;
  z-index: -1;
}
ul li a:hover::after {
  width: 100%;
  left: 0;
  
  
  transition: all .3s;
}
.v-application a {
    color:black;
}
.v-app-bar__nav-icon.v-btn.v-btn--icon.v-btn--round.theme--light.v-size--default {
    margin: 5px 1vw;
    margin-right: 4vw;
}
.icon_group {
  width: 20vw;
  margin-top: 7px;
  /* margin-right: 4vw;
  margin-left: 4vw; */
}
.fade-in-box {
  display: inline-block;
  padding: 10px;
  animation: fadein 3s;
  -webkit-animation: fadein 3s;
}
@-webkit-keyframes fadein {
    from {
        opacity:0;
    }
    to {
        opacity:1;
    }
}
.img_test {
    width: 30vw;
    animation: rotate_image 6s ease-in-out infinite;
    transform-origin: 50% 50%;
}
@keyframes rotate_image {
    100% {
        transform: rotate(-360deg);
    }
}
.d-flex.child-flex.col.col-4 {
  padding:0px;
}
.btn-plus {
  position:absolute;  
  top:120px;
  left:140px;
  background:rgb(65, 84, 192, 0.8);
  width:70px;
  height:70px;
  border-radius:50%;
  text-align:center;
  vertical-align: middle;
  padding-top:8px;
  cursor: pointer;
  /* 추가된 부분 */
  opacity:0;
  transform:scale(2);
  transition:all .3s linear;
}
.btn-plus span {
  font-size:3.3em;
  color:#ffffff;
  user-select:none;
}
.btn-plus2 {
  /* hover시 사진 어둡게 */
  position:absolute;
  top:0.001px;
  left:12px;
  background:rgba(0, 0, 0, 0.2);
  width:326px;
  height:326px;
  text-align:center;
  cursor: pointer;
  /* 추가된 부분 */
  opacity:0;
  transition:all .6s linear;
}
.btn-plus2 span {
  position: relative;
  top:70px;
  font-size:14px;
  color:#ffffff;
}
.myGod {
  width: 200px;
  height: 200px;
  cursor:pointer;
}
.myFod2 {
  width:inherit;
  height:inherit;
}
.food_box2 {
    display:flex;
    justify-content: center;
    flex-wrap: wrap;
    position: relative;
    margin: 0;
    padding: 15px 0 0 0;
    width: 90vw;
    border-top: 1px solid #BDBDBD;
}
.item {
  width: 350px;
}
.iamge_wrap:hover .btn-plus {
  opacity:1;
  transform:scale(1);
}
.iamge_wrap:hover .btn-plus2 {
  opacity:1;
  transform:scale(1);
}
.v-sheet.v-card:not(.v-sheet--outlined) {
  box-shadow: none !important;
}
.iamge_wrap {
  position: relative;
  width:inherit;
  cursor:pointer;
}
.temp01 {
  display: flex;
  justify-content: center;
}


/* 윗페이지 버튼 */
.btn-plus3 {
  position:absolute;  
  top:90px;
  left:180px;
  width:70px;
  height:70px;
  border-radius:50%;
  text-align:center;
  vertical-align: middle;
  padding-top:8px;
  cursor: pointer;
  /* 추가된 부분 */
  opacity:0;
  transform:scale(2);
  transition:all .3s linear;
}
.btn-plus3 span {
  font-size:3.3em;
  color:#000000;
  user-select:none;
}
.item {
  width: 350px;
}
.iamge_wrap:hover .btn-plus3 {
  opacity:1;
  transform:scale(1);
}
</style>