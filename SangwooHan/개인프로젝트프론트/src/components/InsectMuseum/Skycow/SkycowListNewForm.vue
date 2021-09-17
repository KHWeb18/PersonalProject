<template>
  <div>
      
      <table style="">
          <tr>
            <th style="width:100px">글번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>조회수</th>
            <th>등록일자</th>
          </tr>
          <tr v-for="i in paginatedData" :key="i.no">
           <td style="text-align:center;">{{i.boardNo}}</td>
          <td @click="goDetail(i.boardNo)">{{i.title}}</td>
            <td>{{i.id}}</td>
            <td>{{i.vuecount}}</td>
            <td>{{$moment(i.createDate).format('YYYY-MM-DD/hh:mm')}}</td>
          </tr>
        </table>
            <table>
              <td style="text-align:center;">
        <v-btn depressed :disabled="pageNum === 0" @click="prevPage" class="page-btn">이전</v-btn>
      <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }}</span>
      <v-btn depressed :disabled="pageNum >= pageCount - 1" @click="nextPage" class="page-btn">다음</v-btn>
              </td>
            </table>
      
          
    




   
  </div>
</template>

<script>
import axios from 'axios';
import Vue from 'vue'
import VueMoment from 'vue-moment'
Vue.use(VueMoment);

export default {
    
 
  name: 'paginated-list',
  data () {
    return {
      pageNum: 0,
      search: '',
    }
  },
  props: {
    listArray: {
      type: Array,
      required: true
    },
    pageSize: {
      type: Number,
      required: false,
      default: 10
    }
  },
  methods: {
      
    nextPage () {
      this.pageNum += 1;
    },
    prevPage () {
      this.pageNum -= 1;
    },
    check(){
        console.log(this.listArray)
    },
    goDetail(boardNo){
        
            this.$router.push({name: 'SkycowReadPage' ,params:{boardNo}})

            axios.post(`http://localhost:9999/skycow/vuecount/${boardNo}`)
                  .then( () => {

               })
    }
  },
  
  computed: {
      
    pageCount () {
      let listLeng = this.listArray.length,
          listSize = this.pageSize,
          page = Math.floor(listLeng / listSize);
      if (listLeng % listSize > 0) page += 1;
      
      /*
      아니면 page = Math.floor((listLeng - 1) / listSize) + 1;
      이런식으로 if 문 없이 고칠 수도 있다!
      */
      return page;
    },
    paginatedData () {
      const start = this.pageNum * this.pageSize,
            end = start + this.pageSize;
      return this.listArray.slice(start, end);
    }
  }
}
</script>

<style>
table {
  width: 100%;
  border-collapse: collapse;
}
table th {
  font-size: 1.2rem;
}
table tr {
  height: 2rem;
  text-align: center;
  border-bottom: 1px solid #505050;
}
table tr:first-of-type {
  border-top: 2px solid #404040;
}
table tr td {
  padding: 1rem 0;
  font-size: 1.1rem;
}
.btn-cover {
  margin-top: 1.5rem;
  text-align: center;
}
.btn-cover .page-btn {
  width: 5rem;
  height: 2rem;
  letter-spacing: 0.5px;
}
.btn-cover .page-count {
  padding: 0 1rem;
}


</style>