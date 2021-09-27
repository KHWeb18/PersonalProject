<template>
    
    <div>

 <!--
<v-container id="viewimg">
       <table id="imgtable"> 
        <img width="350px" v-if="Product.productName =='[사슴벌레용]발효톱밥5L'" src="@/assets/상우/발효톱밥.jpg"/>
                <img width="350px" v-if="Product.productName =='[장수풍뎅이]발효톱밥5L'" src="@/assets/상우/발효톱밥.jpg"/>
                <img width="350px"  v-if="Product.productName =='산란목'" src="@/assets/상우/산란목.jpg"/>
                <img width="350px" v-if="Product.productName =='발효톱밥5L'" src="@/assets/상우/발효톱밥.jpg"/>
                <img width="350px" v-if="Product.productName =='균사'" src="@/assets/상우/균사.jpg"/>
                <img width="350px" v-if="Product.productName =='곤충젤리100개'" src="@/assets/상우/수액젤리.jpg"/>
                <img width="350px" v-if="Product.productName =='곤충이끼'" src="@/assets/상우/곤충이끼.jpg"/>
                <img width="350px" v-if="Product.productName =='오호히라균사'" src="@/assets/상우/균사.jpg"/>
                <img width="350px" v-if="Product.productName =='레벤지균사'" src="@/assets/상우/균사.jpg"/>
                <img width="350px" v-if="Product.productName =='놀이목'" src="@/assets/상우/놀이목.jpg"/>
                <img width="350px" v-if="Product.productName =='광구병'" src="@/assets/상우/광구병.jpg"/>
                <img width="350px" v-if="Product.productName =='오호히라균사묶음6개'" src="@/assets/상우/균사묶음.jpg"/>
                <img width="350px" v-if="Product.productName =='균사스푼'" src="@/assets/상우/균사스푼.jpg"/>
                <img width="350px" v-if="Product.productName =='일반균사묶음6개'" src="@/assets/상우/균사묶음.jpg"/>
                <img width="350px" v-if="Product.productName =='사육케이스특대'" src="@/assets/상우/사육케이스.jpg"/>
                <img width="350px" v-if="Product.productName =='사육케이스대'" src="@/assets/상우/사육케이스.jpg"/>
                <img width="350px" v-if="Product.productName =='사육케이스중'" src="@/assets/상우/사육케이스.jpg"/>
                <img width="350px" v-if="Product.productName =='사육케이스소'" src="@/assets/상우/사육케이스.jpg"/>
                <img width="350px" v-if="Product.productName =='먹이접시1구'" src="@/assets/상우/먹이접시1구.jpg"/>
                <img width="350px" v-if="Product.productName =='먹이접시2구'" src="@/assets/상우/먹이접시2구.jpg"/>
                <img width="350px" v-if="Product.productName =='[사슴벌레용]발효톱밥5L묶음6개'" src="@/assets/상우/발효톱밥묶음.jpg"/>
                <img width="350px" v-if="Product.productName =='[장수풍뎅이]발효톱밥5L묶음6개'" src="@/assets/상우/발효톱밥묶음.jpg"/>
                <img width="350px" v-if="Product.productName =='유산균젤리100개'" src="@/assets/상우/유산균젤리.jpg"/>
                <img width="350px" v-if="Product.productName =='유충병고급'" src="@/assets/상우/유충병고급.jpg"/>
                <img width="350px" v-if="Product.productName =='온도계스티커'" src="@/assets/상우/온도계스티커.jpg"/>
                <img width="350px" v-if="Product.productName =='장수풍뎅이세트'" src="@/assets/상우/장수풍뎅이세트.jpg"/>
                <img width="350px" v-if="Product.productName =='왕사슴벌레세트'" src="@/assets/상우/왕사슴벌레세트.jpg"/>
       </table>
      </v-container>
      -->
    <!--
    <v-container style="max-width:700px" id="viewProductDesc">
        <table id="table" >
          <h4>제품명:{{Product.productName}}</h4>
           <h4>가격:{{Product.productPrice}}</h4>
              <p>{{Product.productDesc}}</p>
              
                <h4>수량{{productNum}} 총가격(택배비3000원):{{Product.productPrice * productNum +3000}}</h4>
            </table>
    </v-container>
    -->
    <v-card
        align="center"
  >
   <v-list-item>
      <v-list-item-content>
          <v-list-item-subtitle>
        <img width="350px" v-if="Product.productName =='[사슴벌레용]발효톱밥5L'" src="@/assets/상우/발효톱밥.jpg"/>
                <img width="350px" v-if="Product.productName =='[장수풍뎅이]발효톱밥5L'" src="@/assets/상우/발효톱밥.jpg"/>
                <img width="350px"  v-if="Product.productName =='산란목'" src="@/assets/상우/산란목.jpg"/>
                <img width="350px" v-if="Product.productName =='발효톱밥5L'" src="@/assets/상우/발효톱밥.jpg"/>
                <img width="350px" v-if="Product.productName =='균사'" src="@/assets/상우/균사.jpg"/>
                <img width="350px" v-if="Product.productName =='곤충젤리100개'" src="@/assets/상우/수액젤리.jpg"/>
                <img width="350px" v-if="Product.productName =='곤충이끼'" src="@/assets/상우/곤충이끼.jpg"/>
                <img width="350px" v-if="Product.productName =='오호히라균사'" src="@/assets/상우/균사.jpg"/>
                <img width="350px" v-if="Product.productName =='레벤지균사'" src="@/assets/상우/균사.jpg"/>
                <img width="350px" v-if="Product.productName =='놀이목'" src="@/assets/상우/놀이목.jpg"/>
                <img width="350px" v-if="Product.productName =='광구병'" src="@/assets/상우/광구병.jpg"/>
                <img width="350px" v-if="Product.productName =='오호히라균사묶음6개'" src="@/assets/상우/균사묶음.jpg"/>
                <img width="350px" v-if="Product.productName =='균사스푼'" src="@/assets/상우/균사스푼.jpg"/>
                <img width="350px" v-if="Product.productName =='일반균사묶음6개'" src="@/assets/상우/균사묶음.jpg"/>
                <img width="350px" v-if="Product.productName =='사육케이스특대'" src="@/assets/상우/사육케이스.jpg"/>
                <img width="350px" v-if="Product.productName =='사육케이스대'" src="@/assets/상우/사육케이스.jpg"/>
                <img width="350px" v-if="Product.productName =='사육케이스중'" src="@/assets/상우/사육케이스.jpg"/>
                <img width="350px" v-if="Product.productName =='사육케이스소'" src="@/assets/상우/사육케이스.jpg"/>
                <img width="350px" v-if="Product.productName =='먹이접시1구'" src="@/assets/상우/먹이접시1구.jpg"/>
                <img width="350px" v-if="Product.productName =='먹이접시2구'" src="@/assets/상우/먹이접시2구.jpg"/>
                <img width="350px" v-if="Product.productName =='[사슴벌레용]발효톱밥5L묶음6개'" src="@/assets/상우/발효톱밥묶음.jpg"/>
                <img width="350px" v-if="Product.productName =='[장수풍뎅이]발효톱밥5L묶음6개'" src="@/assets/상우/발효톱밥묶음.jpg"/>
                <img width="350px" v-if="Product.productName =='유산균젤리100개'" src="@/assets/상우/유산균젤리.jpg"/>
                <img width="350px" v-if="Product.productName =='유충병고급'" src="@/assets/상우/유충병고급.jpg"/>
                <img width="350px" v-if="Product.productName =='온도계스티커'" src="@/assets/상우/온도계스티커.jpg"/>
                <img width="350px" v-if="Product.productName =='장수풍뎅이세트'" src="@/assets/상우/장수풍뎅이세트.jpg"/>
                <img width="350px" v-if="Product.productName =='왕사슴벌레세트'" src="@/assets/상우/왕사슴벌레세트.jpg"/>
          </v-list-item-subtitle>
          <v-list-item-subtitle>
               <v-dialog  v-model="dialog" persistent max-width="400">
               <template v-slot:activator="{ on }">
               <v-btn    dark v-on="on">구매</v-btn>
               </template>
               <v-card>
               <v-card-title class="headline">
                   주문
               </v-card-title>
               <v-card-text>
                  <v-text-field label="주소" v-model="address" type="text" :rules="must" flat solo>
              </v-text-field>
              <v-text-field label="성함" v-model="buyUserName" type="text" :rules="must" flat solo>
              </v-text-field>
              <v-text-field label="핸드폰" v-model="phoneNo" type="text" :rules="must" flat solo>
              </v-text-field>
               </v-card-text>
               <v-card-actions>
                   <v-spacer></v-spacer>
                   <v-btn @click.native="finalBuybtn(Product)" class="red">최종구매</v-btn>
               <v-btn @click.native="prerchasecancle">취소</v-btn>
               </v-card-actions>
               </v-card>
           </v-dialog>
           <v-btn v-if="this.$store.state.User !=null" @click="Basket(Product)" align="center" >장바구니</v-btn>
                <v-btn v-if="this.$store.state.User ==null" @click="plzlogin" align="center">장바구니</v-btn>
                <v-btn  @click="plusProduct"> <v-icon>mdi-plus-thick</v-icon></v-btn >
               <v-btn  @click="minusProduct"><v-icon> mdi-minus-thick</v-icon></v-btn>
          </v-list-item-subtitle>
      </v-list-item-content>
    </v-list-item>
    <v-list-item>
      <v-list-item-content>
      <h4>{{Product.productName}}</h4>
      </v-list-item-content>
    </v-list-item>

    <v-list-item two-line>
      <v-list-item-content>
        <v-list-item-title>가격.수량:{{productNum}}</v-list-item-title>
       <h4>{{Product.productPrice}}원</h4>
      </v-list-item-content>
    </v-list-item>

    <v-list-item three-line>
      <v-list-item-content>

        <pre>
          {{Product.productDesc}}
        </pre>
      </v-list-item-content>
    </v-list-item>
  </v-card>
        <form  @submit.prevent="OnSubmit" v-if="commentBox ==1 && this.$store.state.User !=null">
        <table >
          <tr>
              <p>후기</p><v-btn style="float:right" small route :to="{name: 'ShoppingMallpage'}">목록</v-btn>
             <p>{{ui}}</p>
            <v-textarea height="10px" auto-grow outlined v-model="comments">
            </v-textarea>
            <v-btn depressed style="float:right" type="submit"><v-icon>mdi-comment</v-icon></v-btn>
          </tr>
        </table>
        </form>
     
        <table>
            <tr v-for="(item, index) in Product.authList" :key="Product.authList[index].id">
                  
                  <th width="150px">{{ item.ui}}</th>
                  
                  <td >{{item.comments}}</td>

                   <td v-if="Modify == item.productCommentNo">
                    <textarea  v-model="comments" cols="1" rows="1"/><v-btn depressed @click="CommemtsModify(item)">수정완료</v-btn><v-btn depressed @click="ModifyOFF">취소</v-btn>
                </td>
        <td>
        <v-btn  depressed v-if="item.ui == User"  @click="deleteComment(item.productCommentNo)">
            <v-icon>mdi-alpha-x-box-outline</v-icon>
        </v-btn>
        <v-btn depressed v-if="item.ui == User"   @click="ModifyOn(item.productCommentNo)">
             <v-icon>mdi-eraser</v-icon>
        </v-btn>
        </td>
            </tr>
        </table>
        
        
        
    </div>

</template>
<script>
import axios from 'axios'
import {mapState} from 'vuex'

export default {
    name: 'ProduvtReadForm',
    props:{
        Product:{
            type:Object
        }
    },
    computed:{
        ...mapState(['members','User','loginMemberNo'])

    },
    data(){
        return{
            productNum: 1,
            perchaseBox: 0,
            address: '',
            phoneNo: '',
            buyUserName: '',
            commentBox: 1,
            ui: this.$store.state.User,
            comments: '',
            Modify: '',
            userid:this.$store.state.User,
            dialog: false,
            must: [
                 v => !! v || '정보를입력해주세요.',
            ]
             
        }
    },
    methods:{
        plzlogin(){
                alert('로그인후이용해주세요!')
        },
        ModifyOn(productCommentNo){
            this.Modify =productCommentNo
            this.commentBox =0
        },
        ModifyOFF () {
                this.Modify =null
                 this.commentBox =1
        },
        plusProduct(){
                this.productNum +=1
        },
        minusProduct(){
            
            if(this.productNum < 2){
                    alert('수량이 1보다 낮을순없습니다. 감사합니다.')
            }else{
                this.productNum -=1
            }
        },
        InitiatingPerchase(){
            this.perchaseBox =1
        },
        prerchasecancle(){
            this.dialog= false
        },
        Basket(Product){
            for(var i = 0 ; i <this.members.length ; i++){
           if(this.$store.state.User == this.members[i].userid){
                 this.$store.state.loginMemberNo = this.members[i].memberNo
            }
             }
                const { productName, productPrice} = Product
            const {productNum} =this
            axios.post(`http://localhost:9999/jpamemberManage/addBasket/${this.$store.state.loginMemberNo}`,{ productName, productPrice,productNum})
            .then( ()=> {
                alert('장바구니에 추가되었습니다.')
               
            }).catch(err=>{alert(err.response.data.message)})
        },
        
        finalBuybtn(Product){

                if(this.$store.state.User !=null){
               const {productName,productPrice } =Product
                const {productNum, buyUserName,address,phoneNo,userid} =this

                axios.post('http://localhost:9999/jpaOrder/register',{productName,productPrice,productNum,buyUserName,address,phoneNo,userid})
                .then( ()=>{
                    alert('구매감사드립니다. 국민205502-04-5946645(한상우) 로 입금해주세요 입금확인후 배송시작')
                    this.perchaseBox =0
                    this.$router.go()
                }).catch(err=>{
                    alert(err.response.data.message)
                })
                }
                else{
                    alert('로그인후 이용해주세요')
                }


        },
        OnSubmit(){
            const {ui ,comments} =this
            axios.post(`http://localhost:9999/jpaProduct/comment/${this.Product.boardNo}`,{ui,comments})
            .then(()=>{
                alert('댓글이등록되었습니다.')
                this.$router.go()
            }).catch(err=>{alert(err.response.data.message)})

        },
                     CommemtsModify(item){

            console.log(item)
            const {productCommentNo, ui, regDate} = item
                const {comments} =this
            axios.post(`http://localhost:9999/jpaProduct/ModifyComments/${this.Product.boardNo}`,{ui,productCommentNo,comments,regDate})
            .then(res =>{
                alert('수정성공'+ res) 
                this.$router.go()
                this.commentBox = 1
            }).catch(err=>{alert(err.response.data.message)})
            

                              },

                              deleteComment(productCommentNo){
            
               
            axios.delete(`http://localhost:9999/jpaProduct/deleteComment/${productCommentNo}`)
            .then( res => {
                alert('삭제성공'+ res)
                this.$router.go()
                         }).catch(err=>{alert(err.response.data.message)})

                                     },
        
    }
}
</script>

<style >
@import url('https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@700&display=swap');
/*
#viewimg{
    float: left;
}
#viewProductDesc{
    float: right;
    position: absolute;
    margin-left: 500px;
}
#goods{
    position: absolute;
    margin-top: 330px;
    margin-left: 80px;
}
*/
div{
        font-family: 'IBM Plex Sans KR', sans-serif;
}
</style>