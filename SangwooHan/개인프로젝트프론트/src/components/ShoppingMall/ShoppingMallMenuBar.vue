<template>
    <div>
         <v-toolbar  flat   >
   
    <v-toolbar-title>
        <span class="font-weight-light"></span>
    </v-toolbar-title>
     <v-spacer></v-spacer>
    <v-toolbar-items>
         <v-btn depressed route :to="{name: 'ShoppingMallpage', params:{ProductList}}" >
            전체
        </v-btn>
      <v-btn depressed route :to="{name: 'InsectMallInsect', params:{ProductList}}" >
            곤충
        </v-btn>
         <v-btn depressed route :to="{name: 'InsectMallJelly', params:{ProductList}}" >
            젤리
        </v-btn>
         <v-btn depressed route :to="{name: 'InsectMallMushroom', params:{ProductList}}" >
            균사
        </v-btn>
         <v-btn depressed route :to="{name: 'InsectMallEggtree', params:{ProductList}}" >
            산란목
        </v-btn>
         <v-btn depressed route :to="{name: 'InsectMallSawdust', params:{ProductList}}" >
            발효톱밥
        </v-btn>
         <v-btn depressed route :to="{name: 'InsectMallSide', params:{ProductList}}" >
            기타사육용품
        </v-btn>
       
    </v-toolbar-items>
      <v-spacer></v-spacer>
    </v-toolbar>
    </div>
</template>
<script>
export default {
    name: 'ShoppingMallMenuBar',
    props:{
        ProductList:{
            type:Array
        }
    }
    
}
</script>