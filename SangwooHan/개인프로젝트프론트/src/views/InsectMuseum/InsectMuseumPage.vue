<template>
  <div>
      <v-container>
     <insect-museum-bar/>
     <img src="@/assets/상우/곤충박물관로고.png"/>
        <h3>찾고싶은 곤충이 있나요?</h3>
        <pre>search by insect.</pre>
        <input v-model="title">
        <v-btn @click="searchtitle" ><v-icon>mdi-magnify</v-icon></v-btn>
        
        <table>
            <tr>
                <th>게시글번호</th>
                <th>작성자</th>
                <th>제목</th>
                <th>작성일자</th>
                <th>조회수</th>
            </tr>
            <tr>
                <th>{{searchResult.boardNo}}</th>
                <th>{{searchResult.id}}</th>
                <a @click="gogo(searchResult.title,searchResult.boardNo)"><th>{{searchResult.title}}</th></a>
                <th>{{$moment(searchResult.createDate).format('YYYY-MM-DD/hh:mm')}}</th>
                <th>{{searchResult.vuecount}}</th>
            </tr>
        </table>
        </v-container>
  </div>
</template>

<script>
import axios from 'axios'

import InsectMuseumBar from '../NavigationVar/InsectMuseumBar.vue'

import Vue from 'vue'
import VueMoment from 'vue-moment'
Vue.use(VueMoment)


export default {
    name: 'InsectMuseumPage',
    components: {   
        InsectMuseumBar
    },
    data() {

        return{
            title: '',

            searchResult: [],
            
           
        }
    },
    methods:{
            searchtitle() {
                    const {title} = this
                axios.post('http://localhost:9999/stagbeetle/searchtitle/' ,{title})
                .then( (res) => {
                        this.searchResult = res.data                      
                        if(res.data == ''){
                            axios.post('http://localhost:9999/beetle/searchtitle/' ,{title})
                            .then((res)=>{
                                this.searchResult =res.data
                                if(res.data == ''){
                                    axios.post('http://localhost:9999/butterfly/searchtitle/' ,{title})
                                    .then((res) =>{
                                        this.searchResult = res.data
                                        if(res.data == ''){
                                            axios.post('http://localhost:9999/dragonfly/searchtitle/' ,{title})
                                            .then( (res)=>{
                                                this.searchResult = res.data
                                                if(res.data == ''){
                                                    axios.post('http://localhost:9999/skycow/searchtitle/' ,{title})
                                                    .then( (res)=> {
                                                        this.searchResult = res.data
                                                        if(res.data == ''){
                                                            alert('해당곤충은 찾지못하였습니다.')
                                                        }
                                                    })
                                                }
                                            })
                                        }
                                    })
                                }
                                
                            })
                        }
                })
                
            },
            gogo(title,boardNo){
                if(title.includes('풍뎅이')){
                    this.$router.push({name: 'BeetleReadPage',params:{boardNo}})
                }
                if(title.includes('사슴')){
                    this.$router.push({name: 'StagbeetleReadPage',params:{boardNo}})
                }
                if(title.includes('잠자리')){
                    this.$router.push({name: 'DragonflyReadPage',params:{boardNo}})
                }
                if(title.includes('하늘소')){
                    this.$router.push({name: 'SkycowReadPage',params:{boardNo}})
                }
                if(title.includes('나비')){
                    this.$router.push({name: 'ButterflyReadPage',params:{boardNo}})
                }
            }
            
            
            
    }
   
}

</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Cabin&display=swap');
pre{
  font-family: 'Cabin', sans-serif;
}
</style>