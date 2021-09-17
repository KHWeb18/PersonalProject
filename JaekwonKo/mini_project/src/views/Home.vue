<template>
  <div class="back">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Jua&display=swap" rel="stylesheet">
    
    <br>
      <div>
        <image-gallery >
        </image-gallery>
      </div>
    <br>
    <div>
      <v-container center>
        <h3>작은 사이즈 지도</h3>
        <store></store>
        <v-btn depressed icon left x-large >
                    <a class href="/Store" >
                        <v-icon>mdi-map </v-icon>누르시면 전용페이지로 이동됩니다
                    </a>
                </v-btn>
      </v-container>
      <v-container center>
        <h3>관련 영상</h3>
        <iframe width="400" height="225" src="https://www.youtube.com/embed/8oaBBL4azdQ" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
<iframe width="400" height="225" src="https://www.youtube.com/embed/Mh8atDu1pxY" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>        <iframe width="400" height="225" src="https://www.youtube.com/embed/ghMtm6MR9tQ" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
      </v-container>
    </div>
    

    

  </div>
</template>

<script>

import ImageGallery from '../components/home/ImageGallery.vue'
import Store from '../components/home/Store.vue'
export default {
    name: 'Home',
   components: {
      ImageGallery,
      Store
    },
}
</script>


<style scoped>
.back {
  background: url('../assets/img/back1.jpg');
  background-size: cover;
  height: 200vh;
  overflow: hidden;


  font-family: 'Do Hyeon', sans-serif;
  font-family: 'Jua', sans-serif;
}
.container{
  color: gray;
}


</style>