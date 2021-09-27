<template>
    <div id="board_padding">
        <v-spacer style="background-color: #212121;height: 90px;"></v-spacer>
        <v-container>
            <food-list :foods="foods"/>
            <div class="button_box">
              <v-flex text-xs-right="text-xs-right" text-sm-right="text-sm-right">                    
              </v-flex>
            </div>
        </v-container>
    </div>
</template>

<script>

import FoodList from '@/components/board/food/FoodList.vue'
import { mapState, mapActions } from 'vuex'
export default {
  name: 'simple',
  components: {
    FoodList
  },
  computed: {
    ...mapState(['foods'])
  },
  mounted () {
    this.fetchFoodList()
  },
  methods: {
    ...mapActions(['fetchFoodList'])
  }
}
</script>

<style scoped>
h1 {
  color: #454545;
  text-align: center;
}
.boardButton {
    float: right;
    width: 160px;
    height: 45px;
    border: none;
    background-color: #01579B;
    color: #fff;
    font-size: 14px;
    font-weight: 700;
}
.change-font {
    font: 12pt;
    color: white;
    font-weight: 800;
}
.board_title {
    font-size: 32px;
    font-weight: 700;
    line-height: 32px;
    color: #333d4b;
    margin-bottom: 60px;
    margin-top: 70px;
}
.button_box {
    margin-top: 10px;
    display: flex;
    justify-content: flex-end;
}
</style>