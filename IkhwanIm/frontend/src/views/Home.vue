<template>
  <body>
  <div class="container">

    <!-- 4 contents -->
    <router-link :to="a.route" tag="div" class="box" v-for="a in contents" :key="a.title">
      <div class="videoBx">
         <video :src="a.vidLink" muted autoplay loop></video>
      </div>
      <div class="contentBx">
        <div class="content">
          <h3>{{ a.title }}</h3>
          <p>{{ a.content }}</p>
        </div>
      </div>
    </router-link>

  </div>
  </body>
</template>

<script>
  export default {
    name: 'Home',

    components: {
    },
    data() {
      return {
        contents: [
          { vidLink: require('@/assets/videos/main1.mp4'), title: 'a Walk', route: 'walk',
            content: 'to Ankara Antalya Barcelona Beijing Budapest Buenos Aires Busan Chicago Curitiba Daegu Delhi Dubai Dublin Dunedin Guadalajara Hamburg Havana Hawaii Istanbul Izmir Johannesburg Kyiv Lauterbrunnen Lisbon London Los Angeles'},
          { vidLink: require('@/assets/videos/main2.mp4'), title: 'a Bike Ride', route: 'bike',
            content: 'to Ankara Antalya Barcelona Beijing Budapest Buenos Aires Busan Chicago Curitiba Daegu Delhi Dubai Dublin Dunedin Guadalajara Hamburg Havana Hawaii Istanbul Izmir Johannesburg Kyiv Lauterbrunnen Lisbon London Los Angeles'},
          { vidLink: require('@/assets/videos/main3.mp4'), title: 'a Motorcycle Ride', route: 'motorcycle',
            content: 'to Ankara Antalya Barcelona Beijing Budapest Buenos Aires Busan Chicago Curitiba Daegu Delhi Dubai Dublin Dunedin Guadalajara Hamburg Havana Hawaii Istanbul Izmir Johannesburg'},
          { vidLink: require('@/assets/videos/main4.mp4'), title: 'a Drive', route: 'car',
            content: 'to Ankara Antalya Barcelona Beijing Budapest Buenos Aires Busan Chicago Curitiba Daegu Delhi Dubai Dublin Dunedin Guadalajara Hamburg Havana Hawaii Istanbul Izmir Johannesburg Kyiv Lauterbrunnen Lisbon London Los Angeles'},
        ]
      }
    }
  }
</script>

<style scoped src="../assets/style/home.css">

</style>
