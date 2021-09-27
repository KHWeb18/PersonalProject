<template>
  <div>
    <v-card class="mx-auto" max-width="240">
      <v-card-title class="white--text text-h5 text font-weight-medium indigo darken-2 py-3 mt-1">
        Select City

        <v-spacer></v-spacer>

        <v-btn color="white" class="text--primary" @click="showTable" fab small>
          <v-icon>{{ plusIcon }}</v-icon>
        </v-btn>
      </v-card-title>
      <v-divider></v-divider>

      <v-card elevation="10" max-width="240" min-width="240" class="mx-auto">
        <v-simple-table height="300px" v-if="show">
          <template v-slot:default>
            <tbody>
            <tr v-for="(item,idx) in data" :key="idx">
              <td class="text-h6 font-weight-regular"
                  @click="updateSelected(item.video_id); selectBike(item)">
                {{item.city}}, {{item.country}}</td>
            </tr>
            </tbody>
          </template>
        </v-simple-table>
      </v-card>
      <v-card elevation="1">
      <div v-if="showPlaces" class="text-h6 text font-weight-regular mx-2 py-2">City:
        {{ selectedBike.city }}, {{selectedBike.country}}</div>
      </v-card>
    </v-card>
  </div>
</template>

<script>
import { mapState, mapActions } from 'vuex'
export default {
  name: "BikeSelectBox",
  data() {
    return {
      show: false,
      plusIcon: "mdi-plus",
      showPlaces: false,
      data: '',
      selectedPlace: {},
    }
  },
  props: ['value'],
  computed: {
    ...mapState(['bike','selectedBike'])
  },
  methods: {
    ...mapActions(['selectBike']),
    updateSelected(selectedItem) {
      this.selectedPlace = selectedItem
      this.showPlaces = true
      const selectedUrl = selectedItem[Math.floor(Math.random() * selectedItem.length)]
      const videoUrl = 'https://www.youtube.com/watch?v=' + selectedUrl + '&t=40'
      this.$emit('changeVideo',videoUrl)
    },
    showTable(){
      this.show = !this.show
      const plus = "mdi-plus"
      const minus = "mdi-minus"
      if(this.plusIcon == plus) {
        this.plusIcon = minus
      }else {
        this.plusIcon = plus
      }
    }
  },
  beforeUpdate() {
    this.data = this.bike
  }
}
</script>

<style scoped>
td{
  user-select: none;
}
</style>
