<template>
    <div>
<v-container class="grey lighten-5">
    <v-row no-gutters>
      <v-col
        cols="12"
        sm="6"
        md="8"
      >
        <v-card
          class="pa-2"
          outlined
          tile
        >
          <v-img 
      height="250"
      src="./../assets/pimg/c1.jpg"
    ></v-img>

        </v-card>
      </v-col>



      <v-col
        cols="6"
        md="4"
      >
        <v-card
          class="pa-2"
          outlined
          tile
        >
          <h5 align= "left">정품 EOS R5</h5>
          <p align= "left">풀프레임 미러리스의 혁명</p>
        </v-card>
          <v-card
          class="pa-2"
          outlined
          tile
        >
          <p align= "left" color="gray">판매가</p>
          <h5>₩ 5,199,000</h5>
              <p align= "left">개수: <input type="number" text-align: left v-model="width"></p>


       <v-dialog
      v-model="dialog"
      width="500"
    >
      <template v-slot:activator="{ on, attrs }">
        <v-btn
          color="red lighten-2"
          dark
          v-bind="attrs"
          v-on="on"
        >
          구매하기
        </v-btn>
      </template>

      <v-card>
        <v-card-title class="text-h5 grey lighten-2">
          
        </v-card-title>

        <v-card-text>
          <br/>
          구매하시겠습니까?
        </v-card-text>

        <v-divider></v-divider>

        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn
            color="primary"
            text
            @click="dialog = false"
          >
            I accept
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
        </v-card>
        
      </v-col>

    </v-row>
  </v-container>
    </div>
</template>

<script>
export default {
    name: 'OnlyVuePage',
    data () {
        return {
            width: 0,
            height: 0
        }
    },
    computed: {
        results () {
            return this.width * this.height / 2.0;
        }
    }
}
</script>