<template>
  <div class="page">
    <!-- + icon -->
    <v-btn color="secondary" class="right mr-1 mt-1" fab x-small dark
        @click.stop="drawer = !drawer"><v-icon>add</v-icon></v-btn>

    <v-navigation-drawer right v-model="drawer" absolute temporary>
      <v-list-item>
        <v-list-item-avatar v-if="session">
          <v-img src="https://cdn.pixabay.com/photo/2017/06/13/12/53/profile-2398782_960_720.png"></v-img>
        </v-list-item-avatar>

        <v-list-item-content>
          <v-list-item-title v-if="session" class="text-h6">{{ session.member_id }}</v-list-item-title>
        </v-list-item-content>
      </v-list-item>

      <v-divider></v-divider>

      <v-list dense>
        <v-list-item class="my-2 mt-n1 mb-n1" link router :to="items[0].route">
          <v-list-item-icon><v-icon class="pt-2">{{ items[0].icon }}</v-icon></v-list-item-icon>

          <v-list-item-content>
            <v-list-item-title class="text-h6 font-weight-regular py-2">Home</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>

      <v-divider></v-divider>

      <v-list dense class="mt-1">
        <!-- location map -->
        <v-list-item>
          <walk-map></walk-map>
        </v-list-item>

        <v-divider></v-divider>
        <!-- buttons -->
        <v-btn fab elevation="3" small class="ma-3 ml-15"  @click.stop.prevent="sound">
          <v-icon class="mx-2">{{ items[1].icon }}</v-icon></v-btn>

        <v-btn fab elevation="3" dark small color="purple" class="ml-10"
               :href="this.playerOptions.sources[0].src" target="_blank"><v-icon>link</v-icon></v-btn>
        <!-- Select City -->
        <walk-select-box @changeVideo="changeVideo"></walk-select-box>
        <v-btn class="more mb-6 ml-7" to="/board">Recommend us videos</v-btn>
      </v-list>
    </v-navigation-drawer>

    <div class="video-container">
      <!-- noise screen-->
      <video src="../../assets/videos/noise.mp4" muted autoplay loop v-show="loading"></video>

      <video-player ref="videoPlayer" v-show="!loading"
                    :options="playerOptions"
                    class="player video-js vjs-big-play-button" @ended="onPlayerEnded($event)">
      </video-player>
    </div>
  </div>
</template>

<script>
import { videoPlayer } from 'vue-video-player'
import { mapState,mapActions } from 'vuex'
import WalkMap from "@/components/WalkContents/WalkMap";
import WalkSelectBox from "@/components/WalkContents/WalkSelectBox";

require('videojs-youtube')
require('videojs-playlist')
export default {
  components: {
    WalkSelectBox,
    videoPlayer,
    WalkMap,
  },
  data() {
    return {
      data: '',
      items: [
        {
          icon: 'home', text: 'Home', name: 'home', route: '/'
        },
        {
          icon: 'volume_off', text: '', name: 'volume', route: ''
        },
      ],
      drawer: null,
      loading: true,
      playerOptions: {

        showinfo: false,
        controls: false,
        rel: false,
        modestbranding: true,
        allowFullscreen: true,
        start: 60,
        autoplay: true,
        playsinline: true,
        muted: true,
        //fluid: true, // full screen
        //width: 1500,
        //fill: true,
        aspectRatio: "16:9",

        controlBar: false,
        bigPlayButton: false,
        loadingSpinner: false,
        language: 'en',
        playbackRates: [0.7, 1.0, 1.5, 2.0],
        techOrder: ["youtube"],
        sources: [{
          type: "video/youtube",
          //src: "https://www.youtube.com/watch?v=vifIDKDrfq4&ab"
          src: '',
        }],

        poster: '/static/images/author.jpg',
      },
    }
  },
  mounted() {
    this.noiseEffect()
    this.fetchRandom()
  },

  computed: {
    player() {
      return this.$refs.videoPlayer.player
    },
    ...mapState(['selectedWalk','session']),
  },
  methods: {
    ...mapActions(['getRandomWalk']),
    playerReadied(player) {
      this.playerOptions.muted = true
      console.log('player ready!', player)
    },
    changeVideo(selectedUrl) {
      this.noiseEffect()
      this.playerOptions.sources[0].src = selectedUrl
    },
    fetchRandom() {
      this.getRandomWalk()
      this.data = this.selectedWalk
      const random = Math.floor(Math.random() * this.selectedWalk.video_id.length)
      this.playerOptions.sources[0].src =
          'https://www.youtube.com/watch?v=' + this.selectedWalk.video_id[random] + '&t=40'
    },
    sound(){
      this.playerOptions.muted  = !this.playerOptions.muted
      const on = "volume_up"
      const off = "volume_off"
      if(this.items[1].icon == on){
        this.items[1].icon = off
      } else {
        this.items[1].icon = on
      }
    },
    noiseEffect() {
      this.loading = true;
      setTimeout(() => {
        this.loading = false;
      },1000)
    },
    onPlayerEnded() {
      this.loading = true;
      this.fetchRandom();
      setTimeout(() => {
        this.loading = false;
      },1500)
    }
  },
}
</script>

<style scoped src="../../assets/style/videoCommon.css">

</style>
