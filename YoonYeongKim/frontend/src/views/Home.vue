<template>
  <div class="home" align="center">

    <div class="지금 로그인하고 추천">
      <router-link style="text-decoration: none; color:black" 
      :to="{ name: 'LoginPage' }">
      <h1 style="padding:0px 0px 80px 0px; font-weight:bold">지금 로그인하고 추천받아보세요.</h1>
      </router-link>
      <Coverflow2 />
    </div>


    <div class="당신의 취향에 맞춰">
      <h3 style="padding:30px 0px 30px 0px; font-weight:bold">당신의 취향에 맞춰 추천받을 수 있습니다!</h3>
        <b-container-fluid class="ㅇㅇ" style="padding:30px;">
          <b-row>
            <b-col>
              <b-img :src="require('@/assets/1.jpg')" alt="Image 1"></b-img>
              <br>
              <br>
              <h5 style="font-weight:bold; padding:10px;">연도별</h5>
              <h6>1950년부터 2000년까지</h6>
            </b-col>

            <b-col>
              <b-img :src="require('@/assets/2.jpeg')" alt="Image 2"></b-img>
              <br>
              <br>
              <h5 style="font-weight:bold; padding:10px;">아티스트별</h5>
              <h6>좋아하는 아티스트가 <br> 있으십니까?</h6>
            </b-col>

            <b-col>
              <b-img :src="require('@/assets/3.jpg')" alt="Image 3"></b-img>
              <br>
              <br>
              <h5 style="font-weight:bold; padding:10px;">스타일별</h5>
              <h6>브릿팝, 얼터너티브등의 <br> 선호하는 스타일</h6>
            </b-col>

            <b-col>
              <b-img :src="require('@/assets/4.jpg')" alt="Image 4"></b-img>
              <br>
              <br>
              <h5 style="font-weight:bold; padding:10px;">장르별</h5>
              <h6>락부터 재즈까지 <br> 다양한 장르</h6>
            </b-col>
          </b-row>
        </b-container-fluid>
    </div>
<!-- <h6>{{앨범[0].title}}</h6>
<h6>{{앨범[0].image}}</h6> -->
<!--test------------------------------------------------------------------------->
    <router-link :to="{ name: 'AlbumListPage' }"
                    class="nav-link"
                    active-class="active">
            </router-link>
<!--test------------------------------------------------------------------------->
  </div>
</template>

<script>
import albums from "../assets/albums.json"

import Coverflow2 from '@/components/Coverflow2';

  export default {
    name: 'Home',
    data () {
      return {
        앨범: albums.albums,
      };
    },
    components: {
    Coverflow2
    }
}
</script>

<style scoped>
.home {
  padding:80px 0px 100px 0px;
}
</style>