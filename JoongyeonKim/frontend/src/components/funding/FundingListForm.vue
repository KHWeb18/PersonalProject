<template>
  <v-container :cols="4">
    <v-card id="listSet" class="mx-auto mt-11" max-width="800" min-height="500" v-for="funding in fundings" :key="funding.fundingNo">
    <!--<v-card id="listSet" max-width="332" v-for="funding in fundings" :key="funding.fundingNo" mb-2 xs-4 cols="4">-->
  
      <v-card-title>
      <router-link  :to="{ name: 'FundingReadPage', 
          params: { fundingNo: funding.fundingNo.toString() } }">
          <v-img><img :src="require(`@/assets/userUploadImage/${funding.image}`)" aspect-ratio="1"></v-img>
      </router-link>
      </v-card-title>

    <v-divider class="mx-4"></v-divider>
    <div align="ceter" id="div1" >{{funding.category}}  /  {{funding.writer}}</div>
    
    <v-card-title>
      <router-link :to="{ name: 'FundingReadPage',
                params: { fundingNo: funding.fundingNo.toString() } }">
                {{ funding.title }}
      </router-link> 
    </v-card-title>
    
    <v-card-text>
      <div align="justify">{{funding.summary}}</div>
    </v-card-text>

    </v-card>
  </v-container>
</template>

<script>
  export default {
    name: 'FundingListForm',
    props: {
        fundings: {
            type: Array
        }
    },
    data ()  {
        return {

        }
    },

    methods: {

    },
    mounted () {
        console.log(JSON.stringify(this.fundings))


    },
    
  }
</script>

<style scoped>

* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

#container {
    margin: 0 auto;
    width: 1400px;
}
/*
img {
  width: 300px;
  height: 200px;
  object-fit: cover;
}
*/
img {
  width: 769px;
  height: 400px;
  object-fit: cover;
}


#listSet {
  margin: 40px;
  left: 30px;
}


#div1 {
  float: 0;
}

</style>