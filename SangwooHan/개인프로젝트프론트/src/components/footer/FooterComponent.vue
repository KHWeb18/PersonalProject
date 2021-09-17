<template>
<!--
    <div>
        <img src="@/assets/상우/푸터홈로고.png"/>
        <v-container>
            <v-container>
                <pre style="font-color:red;">곤충아카데미(Since2021)-(주)곤카       대표:한상우    서울시-역삼동-kh곤카         전화:010-3024-0106</pre>
                <pre style="font-color:red;">통신판매업신고 : 아직안함    개인정보관리책임자 : 한상우이메일 : tkddn5678@naver.com Hosting : (주)비아웹</pre>
                <pre>곤충박물관곤카 - 국내 최고의 곤충 포털 Since 20201     GONCA INSECT MUSEUM SEOUL, All Rights Reserved.</pre>
                <pre>                                   국민(205502-04-594665)한상우</pre>
            </v-container>
        </v-container>
        
    </div>-->
     <v-footer
    dark
    padless
  >
    <v-card
      flat
      tile
      class="black lighten-1 white--text text-center"
    >
      <v-card-text>
        <v-btn
        class="mx-4 white--text"
        href="https://www.facebook.com/profile.php?id=100007057508611">
        <v-icon>mdi-facebook</v-icon>
        </v-btn>
        <v-btn
        class="mx-4 white--text"
        href="https://www.facebook.com/profile.php?id=100007057508611">
        <v-icon>mdi-twitter</v-icon>
        </v-btn>
        <v-btn
        class="mx-4 white--text"
        href="https://www.facebook.com/profile.php?id=100007057508611">
        <v-icon>mdi-linkedin</v-icon>
        </v-btn>
        <v-btn
        class="mx-4 white--text"
        href="https://www.facebook.com/profile.php?id=100007057508611">
        <v-icon>mdi-instagram</v-icon>
        </v-btn>
      </v-card-text>

      <v-card-text class="white--text pt-0">
      <pre>곤충아카데미(Since2021)-(주)곤카       대표:한상우    서울시-역삼동-kh곤카         전화:010-3024-0106 통신판매업신고 : 아직안함    개인정보관리책임자 : 한상우이메일 : tkddn5678@naver.com Hosting : (주)비아웹 곤충박물관곤카 - 국내 최고의 곤충 포털 Since 20201    GONCA INSECT MUSEUM SEOUL, All Rights Reserved.</pre>
      <pre>국민(205502-04-594665)한상우</pre>
      </v-card-text>

      <v-divider></v-divider>

      <v-card-text class="white--text">
        {{ new Date().getFullYear() }} — <strong>InsectMuseum</strong>
      </v-card-text>
    </v-card>
  </v-footer>
</template>

<script>
export default {
    data(){
        return{
            icons: [
        'mdi-facebook',
        'mdi-twitter',
        'mdi-linkedin',
        'mdi-instagram',
      ],
        }
    }
}
</script>

<style scoped>
/*
pre{
    color: white;
}
img{
    float: left;
}
*/


</style>