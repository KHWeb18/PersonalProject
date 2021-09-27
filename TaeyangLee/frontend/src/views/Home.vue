<template>
<div>
    <br>
    <hooper :autoPlay="true" :playSpeed="2000" class="text-center" id="hooper" style="height: 500px" :itemsToShow="1.5" :centerMode="true" infiniteScroll>
      <slide v-for="slide in slides" :key="slide" class="slide">
         <v-img :src="slide" aspect-ratio="1.8" class="gery lighten-2"></v-img>
            <p>{{ slide }}</p> 
      </slide>
      <hooper-navigation slot="hooper-addons"></hooper-navigation>
    </hooper>
    <br><br><br>
 


      <!--  <board-list :boards="boards"/>   -->
    <div class="video">
      
        
  <iframe width="638" height="360" src="https://www.youtube.com/embed/F39QAeUgv88"
    title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write;
    encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

  <iframe width="640" height="360" src="https://www.youtube.com/embed/w5KZa9TTLfo"
    title="YouTube video player"
    frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope;
    picture-in-picture" allowfullscreen></iframe>  
    </div>
    <br><br><br><br><br><br>
    
    <h4></h4>
    
      
<div class="support_section">
						<h4>후원이 꼭 필요한 이유는?</h4><br>
						<ul>
							<li>
								<img src='@/assets/img/main1.png' alt="190개 국가에서 심각한 질병에 걸린 아이들을 매일 도울 수 있습니다.">
								<dl><strong>생명을 구하는 일,<br>단 하루도 멈출 수 없습니다.</strong><dd>매년 어린이 590만 명이<br>다섯 번째 생일을 맞기 전 목숨을 잃습니다.</dd></dl>
							</li>
							<li>
								<img src='@/assets/img/main2.png' alt="자연재해, 전쟁 등 예상치 못한 긴급상황 발생 직후 기존 정기후원금으로 아이들을<br/>신속히 구할 수 있습니다.">
								<dl><dt>긴급상황 시 72시간 내<br>도울 수 있습니다.</dt>정기후원금으로 자연재해, 전쟁 등<br>긴급 상황 발생 즉시 아이들을 구할 수 있습니다. </dl>
							</li>
							<li>
								<img src='@/assets/img/main3.png' alt="교육을 통해 아이들이 올바르게 성장하고 스스로 자립할 수 있습니다.">
								<dl><dt>어린이들의 꿈과 미래,<br>꾸준한 도움이 필요합니다.</dt><dd>교육을 통해 아이들은 올바르게 성장하고<br>스스로 자립할 수 있습니다. </dd></dl>
							</li>
						</ul>
					</div>
   
    
     
        
      
       
    <div>

    
    </div>
    

    
    </div>
</template>

<script>
//import BoardList from '@/components/board/BoardList.vue'

import { mapState, mapActions } from 'vuex'
import { Hooper, Slide,Navigation as HooperNavigation } from "hooper"
import 'hooper/dist/hooper.css'

export default {
    name: 'home',
    data() {
      return {
        slides: [
          require('@/assets/img/slides1.png'),
          require('@/assets/img/slides2.png'),
          require('@/assets/img/slides3.png'),
          
         
      ],
      tab: null,
  
        
      }
    },
    components: {
        //BoardList,
        Hooper,
        Slide,
        HooperNavigation
        
    },
    computed: {
        ...mapState(['boards']),
        ...mapState(['list'])
    },
    mounted () {
        this.fetchBoardList(),
        this.fetchLogin()
    },
    methods: {
        ...mapActions(['fetchBoardList']),
        ...mapActions(['fetchLogin'])
    }
}
</script>




<style scoped>
.head {
  position: fixed;
}
* {
  list-style: none;
}
#hooper {
    height: 40vh;
    background-color: white;
}
.slide {
  font-size: 4rem;
  line-height: 40vh;
}
.board {
    width: 80%;
}

.v-tabs {
  width: 180px;
  height: 80px;
}

.btnlist {
  margin-left: 80px;
  margin-top: 50px;
  margin-right: 80px;
  height: 120px;
  background-color: white;
}
.teal {
  margin-left: 50px;
  margin-top: 35px;
  background-color: gre;
}

.child-img {
  margin-left: 50px;
  margin-right: 50px;
  
  
}

.black--text{
  text-align: left;
  font-size: 20px;
  font-weight: bold;
  margin-left: 40px;
  
}

.p-text {
  text-align: left;
  font-size: 15px;
  margin-left: 40px;
  
}

div {
  text-align: center;
}

ul{
  
  text-align: center;
  
}
li {
  display: inline-block;
  text-align: left;
  margin: 50px;
}

#support_section{
  border: 1px springgreen;
}







</style>