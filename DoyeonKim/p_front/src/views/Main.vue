<template>
    <div>

        <v-container fluid>
            <!-- Grid 시스템의 한 행을 정의함 -->

        </v-container>     
        <template>
  <v-toolbar color="white">
   


<template>

</template>

  </v-toolbar>

      <div>


      <div>
        
        <template>


          
    <div>
       <v-navigation-drawer app v-model="nav_drawer" temporary>
            <v-list nav dense>
                <v-list-item-group v-model="group" active-class="deep-purple--text text--accent-4">
                    <v-list-item v-for="link in links" :key="link.name" router :to="link.route">
                        <v-list-item-action>
                            <v-icon left>{{ link.icon }}</v-icon>
                        </v-list-item-action>
                        <v-list-item-content>
                            <v-list-item-title>{{ link.text }}</v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                </v-list-item-group>
            </v-list>
        </v-navigation-drawer>
    </div>
        </template>
      </div>
      <div class="conbox con2">
        
        <template>
    <div>
        
       




             

        
    </div>

 



</template>
      </div>

    </div>
         
</template>







<!-- 사진-->

  <v-carousel hide-delimiters>
    <v-carousel-item
      v-for="(item,i) in items"
      :key="i"
      :src="item.src"
    ></v-carousel-item>
  </v-carousel>
        
<h4 div style="text-align:center">ㅤ-ㅤCOMMUNITYㅤ-</h4>

        <v-container>
            <v-data-table :headers="headerTitle"
                    :items="contents"
                    :items-per-page="10"
                    class="elevation-1">
            </v-data-table>
        </v-container>
    </div>
</template>


<script>

export default {
    name: 'VuetifyAllInOneTestPage',
    data () {
        return {

            items: [
          {
            src: require("./../assets/pimg/add1.jpg"),
          },
          {
            src: require("./../assets/pimg/add2.jpg"),
          },
          {
            src: require("./../assets/pimg/add3.jpg"),
          },
          {
            src: require("./../assets/pimg/add4.jpg"),
          },
            ],
          
            


            headerTitle: [
        { text: '번호', value: 'boardNo', width: "70px" },
        { text: '제목', value: 'title', width: "200px" },
        { text: '작성자', value: 'writer', width: "100px" },
    ],
    contents: [
        { boardNo: 1, title: '카메라에 대해', writer: '오이'},
        { boardNo: 2, title: '오늘', writer: '야호', content: '..' },
        { boardNo: 3, title: '다들 무슨', writer: '우우',  },
        { boardNo: 4, title: '배고픈', writer: '도도',  },
        { boardNo: 5, title: '야호', writer: '토마토' },
        { boardNo: 6, title: '월요일 싫어', writer: '토토로'},
        { boardNo: 7, title: '배고프다', writer: '야하'},
        { boardNo: 8, title: '사고싶은게 있는데', writer: '오늘'},
        { boardNo: 9, title: '토요일에', writer: '바다'},
        { boardNo: 10, title: '여행가고싶으신분', writer: '카메라' },
        { boardNo: 11, title: '코로나 언제', writer: '참치',  },
        { boardNo: 12, title: '테스트', writer: '하하',  },
        { boardNo: 13, title: '글', writer: '흐흐' },
        { boardNo: 14, title: '강아지', writer: '키키' },
        { boardNo: 15, title: '고양이', writer: '럼펌' },
    ],
            message: '환장',
            nav_drawer: false,
            group: false,
            dialog: false,
            loginDialog: false,
            service: {
                name: '7박 8일 여행 코스'
            },
            userInfo: {
                email: '',
                password: ''
            },
            links: [
                {
                    icon: 'home', text: 'Home', name: 'home', route: '/vuetifyTest'
                },
                {
                    icon: 'community', text: 'Community', name: 'community', route: '/product'
                },
                {
                    icon: 'market', text: 'Market', name: 'market', route: '/materialize'
                },
                {
                    icon: 'login', text: 'Login', name: 'login', route: '/memberLogin'
                },
                {
                    icon: 'signup', text: 'Signup', name: 'signup', route: '/memberJoinColumn'
                }  
            ]

        }
    },
    methods: {
        btn_click ($event) {
            if ($event.target.innerHTML == " 결제승인 ") {
                alert('결제가 완료되었습니다!')
                this.dialog = false
            }
        },
        roundBtnClick () {
            alert('Vuetify 버튼이라고 들어봤니 ?')
        },
        btnLoginClick ($event) {
            if ($event.target.innerHTML == " 확인 ") {
                alert('로그인이 완료되었습니다!')
                console.log("입력된 정보 - 이메일: " + this.userInfo.email + 
                            ", 비밀번호: " + this.userInfo.password)
                this.loginDialog = false
            }
            this.userInfo.email = ''
            this.userInfo.password = ''
        }
    },
    watch: {
        group () {
            this.nav_drawer = false
        }
    }
}
</script>


<style scoped>
h1 {
    margin: 10px;
}
p {
    padding: 10px;
    margin: 5px 10px;
}
</style>