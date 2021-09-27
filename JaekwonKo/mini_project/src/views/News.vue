<template>
  <div>
    <div class="back">
          <link rel="preconnect" href="https://fonts.googleapis.com">
          <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
          <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Jua&display=swap" rel="stylesheet">
  
        
        <v-simple-table>
 
        
        <tbody>
            <tr v-for="(list,idx) in lists" :key="idx">
                    <td style="color: gray" width="200px" >{{ list.newsNo }}</td>
                    <td><a @click="clickNews(list.address)">{{ list.title }}</a></td>
            </tr>
        </tbody>
        </v-simple-table>


    

    </div>
  </div>
</template>

<script>

import { mapState } from 'vuex'

export default {
    computed: {
        ...mapState ({
            lists: state => state.lists
        })
    },
    methods: {
        clickNews(address){
            window.open(address, 'newslink', 'width: 1000px, height: 800px')
        }
    },
    created() {
        this.$store.dispatch('crawlFind', '제로웨이스트')
    },
}
</script>

<style scoped>
.back {
  background: url('../assets/img/back1.jpg');
  background-size: cover;
  height: 100vh;
  font-family: 'Do Hyeon', sans-serif;
  font-family: 'Jua', sans-serif;
}
.th{
     text-align: center
     
}


</style>