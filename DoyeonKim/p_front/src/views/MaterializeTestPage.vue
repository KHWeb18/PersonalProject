<template>
  <div style="display: flex">
  
  <v-container fluid>
    <v-row dense>
      <v-card
    :loading="loading"
    class="mx-auto my-12"
    max-width="374"
  >
  <router-link to="/OnlyVuePage">
    <v-img 
      height="250"
      src="./../assets/pimg/c1.jpg"
    ></v-img>
</router-link>

    <v-card-title >정품 EOS R5</v-card-title>

    <v-card-text>
      
      <v-row
        align="center"
        class="mx-0"
      >
        <v-rating
          :value="4.5"
          color="amber"
          dense
          half-increments
          readonly
          size="14"
        ></v-rating>

        <div class="grey--text ml-4">4.5 (12)</div>
      </v-row>

      <div class="my-4 subtitle-1">
       
      </div>
                                                                                                            
      <div>풀프레임 미러리스의 혁명</div>
    </v-card-text>

    <v-divider class="mx-4"></v-divider>

    <v-card-title>￦ 5,199,000</v-card-title>
    <p>개수: <input type="number" text-align: left v-model="width"></p>



    <v-card-actions>
     <!--  <template v-slot:activator="{ on, attrs }"> -->
      <v-btn
         color="deep-purple lighten-2"
        text
        @click="reserve"
      >

        <!--       v-bind="attrs"
          v-on="on"-->
        구매하기
        
      </v-btn>
    </v-card-actions>
   </v-card>

   <v-card
    :loading="loading"
    class="mx-auto my-12"
    max-width="374"
  >
    <v-img 
      height="250"
      src="./../assets/pimg/c2.jpg"
    ></v-img>

    <v-card-title>정품 EOS R6</v-card-title>

    <v-card-text>
      <v-row
        align="center"
        class="mx-0"
      >
        <v-rating
          :value="4.5"
          color="amber"
          dense
          half-increments
          readonly
          size="14"
        ></v-rating>

        <div class="grey--text ml-4">4.5 (12)</div>
      </v-row>

      <div class="my-4 subtitle-1">
       
      </div>
                                                                                                            
      <div>풀프레임 미러리스 선택의 기준</div>
    </v-card-text>

    <v-divider class="mx-4"></v-divider>

    <v-card-title>￦ 3,599,000</v-card-title>
    <p>개수: <input type="number" text-align: left v-model="width"></p>



    <v-card-actions>
     <!--  <template v-slot:activator="{ on, attrs }"> -->
      <v-btn
         color="deep-purple lighten-2"
        text
        @click="reserve"
      >

        <!--       v-bind="attrs"
          v-on="on"-->
        구매하기
        
      </v-btn>
    </v-card-actions>
   </v-card>

   <v-card
    :loading="loading"
    class="mx-auto my-12"
    max-width="374"
  >
    <v-img 
      height="250"
      src="./../assets/pimg/c1.jpg"
    ></v-img>

    <v-card-title>정품 EOS R6 24-105 STM KIT</v-card-title>

    <v-card-text>
      <v-row
        align="center"
        class="mx-0"
      >
        <v-rating
          :value="4.5"
          color="amber"
          dense
          half-increments
          readonly
          size="14"
        ></v-rating>

        <div class="grey--text ml-4">4.5 (12)</div>
      </v-row>

      <div class="my-4 subtitle-1">
       
      </div>
                                                                                                            
      <div>풀프레임 미러리스 선택의 기준</div>
    </v-card-text>

    <v-divider class="mx-4"></v-divider>

    <v-card-title>￦ 3,599,000</v-card-title>
    <p>개수: <input type="number" text-align: left v-model="width"></p>



    <v-card-actions>
     <!--  <template v-slot:activator="{ on, attrs }"> -->
      <v-btn
         color="deep-purple lighten-2"
        text
        @click="reserve"
      >

        <!--       v-bind="attrs"
          v-on="on"-->
        구매하기
        
      </v-btn>
    </v-card-actions>
   </v-card>


    </v-row>
  </v-container>

   </div>
   
</template>

<!--
   <v-card>
        <v-card-title class="text-h5 grey lighten-2">
          Privacy Policy
        </v-card-title>

        <v-card-text>
          Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
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
  </div>
  
</template>
-->

<script>
export default {
    name: 'MaterializeTestPage'

}
</script>