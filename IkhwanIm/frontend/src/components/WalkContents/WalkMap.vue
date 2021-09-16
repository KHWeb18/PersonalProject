<template>
  <v-dialog elevation="15" v-model="seeLocation" max-width="600px">
    <template v-slot:activator="{ on, attrs }">
      <v-btn outlined color="indigo" class="btn-flat mt-n2 text-h6 font-weight-regular" v-on="on" v-bind="attrs">
        <v-icon class="mr-8 ml-n4">location_on</v-icon>Location</v-btn>
    </template>
    <v-card elevation="15">

      <!-- card title -->
      <v-card-title class="text-h4 mb-1">Current Location</v-card-title>
      <v-card-subtitle class="text-h6 mb-n3 ml-1"><v-icon color="cyan darken-1">place</v-icon>
        {{ city }}, {{ country }}</v-card-subtitle>

      <!-- card contents -->
      <div class="mapContainer">
        <MglMap class="map" :accessToken="accessToken" :mapStyle="mapStyle"
                :center="center" :zoom="zoom">
          <MglMarker :coordinates="coordinates"/>
        </MglMap>
      </div>
    </v-card>
  </v-dialog>
</template>

<script>
import Mapbox from "mapbox-gl";
import { MglMap,  MglMarker } from "vue-mapbox";
import { mapGetters } from "vuex"

export default {
  name: "WalkMap",
  components: {
    MglMap,
    MglMarker
  },
  computed: {
    ...mapGetters(['getWalk']),
  },
  data() {
    return {
      seeLocation: false,
      city: '',
      country: '',
      accessToken:
          "pk.eyJ1IjoibWlrZWhhbWlsdG9uMDAiLCJhIjoiNDVjS2puUSJ9.aLvWM5BnllUGJ0e6nwMSEg",
      // your access token. Needed if you using Mapbox maps
      mapStyle: "mapbox://styles/mapbox/streets-v11", // your map style
      coordinates: '',
      center: '',
      zoom: 6,
    };
  },
  beforeUpdate() {
    // We need to set mapbox-gl library here in order to use it in template
    this.mapbox = Mapbox;
    this.getCoordinates()
    this.city = this.getWalk.city
    this.country = this.getWalk.country
  },
  methods: {
    getCoordinates() {
      const vid = this.getWalk
      const coordinates = vid.zoom
      const array = coordinates.split(",").map(Number)
      this.coordinates = array
      this.center = array
    }
  }
};

</script>

<style scoped src="../../assets/style/mapStyle.css">

</style>
