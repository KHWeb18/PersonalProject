<template>
	<v-card width="100%">
		<v-toolbar dense width="1200px">

			<v-toolbar-title>
				<router-link to="/">PETTALK</router-link>
			</v-toolbar-title>

			<!--			<ul class="navbar">-->
			<!--				<li><router-link to="/">반려상식</router-link></li>-->
			<!--				<li><router-link to="/community">커뮤니티</router-link></li>-->
			<!--				<li><router-link to="/gallery">갤러리</router-link></li>-->
			<!--				<li><router-link to="/">동물병원</router-link></li>-->
			<!--				<li><router-link to="/store">스토어</router-link></li>-->
			<!--			</ul>-->

			<v-tabs
							dark>
				<v-tab>
					<router-link to="/">반려상식</router-link>
				</v-tab>
				<v-tab>
					<router-link to="/community">커뮤니티</router-link>
				</v-tab>
				<v-tab>
					<router-link to="/gallery">갤러리</router-link>
				</v-tab>
				<v-tab>
					<router-link to="/">동물병원</router-link>
				</v-tab>
				<v-tab>
					<router-link to="/store">스토어</router-link>
				</v-tab>
			</v-tabs>

			<ul class="navbar_gnb">
				<li v-if="!this.$store.state.isLogin || this.$store.state.isLogin === false">
					<router-link to="/login">로그인</router-link>
					<router-link to="/signup">회원가입</router-link>
				</li>
				<li v-else>
					<div class="loginUser"><span>{{nickName}}</span>님</div>
					<router-link to="/mypage">내정보</router-link>
					<button @click="onClickLogout">로그아웃</button>
				</li>
			</ul>

		</v-toolbar>
	</v-card>
</template>

<!--<template>-->
<!--  <header>-->
<!--    <nav class="navbar">-->

<!--      <div class="navbar_logo">-->
<!--        <router-link to="/">PETTALK</router-link>-->
<!--      </div>-->

<!--      <ul class="navbar_menu">-->
<!--        <li><router-link to="/">반려상식</router-link></li>-->
<!--        <li><router-link to="/">커뮤니티</router-link></li>-->
<!--        <li><router-link to="/">갤러리</router-link></li>-->
<!--        <li><router-link to="/">동물병원</router-link></li>-->
<!--        <li><router-link to="/">스토어</router-link></li>-->
<!--      </ul>-->

<!--      <ul class="navbar_gnb">-->
<!--        <li v-if="!this.$store.state.isLogin || this.$store.state.isLogin === false">-->
<!--          <router-link to="/login">로그인</router-link>-->
<!--          <router-link to="/signup">회원가입</router-link>-->
<!--        </li>-->
<!--        <li v-else>-->
<!--          <router-link to="/">마이페이지</router-link>-->
<!--          <div @click="onClickLogout">로그아웃</div>-->
<!--        </li>-->
<!--      </ul>-->
<!--    </nav>-->

<!--  </header>-->
<!--</template>-->

<script>
  export default {
    name: "Navigation",
    data() {
      return {
        nickName: this.$store.state.userInfo.nickname,
        isLogin: undefined,
      }
    },
    mounted() {
      this.isLogin = this.$store.state.isLogin;
    },
    methods: {
      onClickLogout() {
        this.$store.dispatch("logout")
        this.$router.push({name: "Home"});
      },

    },
  }
</script>


<style scoped>
	.v-card {
		padding: 15px 0;
	}

	.v-sheet.v-card:not(.v-sheet--outlined) {
		box-shadow: none;
		border-bottom: 1px solid #eee;
	}

	/*background-color: rgba(247, 253, 95, 0.82);*/

	.v-card > *:last-child:not(.v-btn):not(.v-chip):not(.v-avatar) {
		border-radius: 0;
	}

	/*background-color: rgba(247, 253, 95, 0.82);*/

	.v-sheet.v-toolbar:not(.v-sheet--outlined) {
		box-shadow: none;
	}



	/*로고*/
	.v-toolbar__title a {
		font-size: 33px;
		color: rgb(229, 119, 175);
		font-family: 'Poor Story', cursive;
		font-weight: bold;
	}

	/*탭 메뉴*/
	/*.navbar {*/
	/*	border: 1px solid red;*/
	/*	box-sizing: border-box;*/
	/*	width: 60%;*/

	/*}*/

	/*.navbar li {*/
	/*	border: 1px solid red;*/
	/*	box-sizing: border-box;*/
	/*}*/

	/*.navbar li a{*/
	/*	border: 1px solid red;*/
	/*	box-sizing: border-box;*/
	/*}*/





	.v-toolbar__content > .v-tabs, .v-toolbar__extension > .v-tabs {
		/*flex: 0 0 auto;*/
		width: 50%;
		/*flex: 0;*/
		/*border: 1px solid red;*/
		padding: 0 100px;
	}

	.theme--light.v-tabs > .v-tabs-bar .v-tab:not(.v-tab--active),
	.theme--light.v-tabs > .v-tabs-bar .v-tab:not(.v-tab--active) >
	.v-icon, .theme--light.v-tabs > .v-tabs-bar .v-tab:not(.v-tab--active) >
	.v-btn, .theme--light.v-tabs > .v-tabs-bar .v-tab--disabled {
		color: #666;
	}


	.navbar_gnb {
		display: flex;
	}

	.navbar_gnb li {
		padding: 8px 5px;
		font-size: 11px;
		font-family: 'Gowun Dodum', sans-serif;
		font-weight: bold;
		/*border: 1px solid red;*/

	}

	.navbar_gnb li a {
		color: #555;
		/*float: left;*/
	}

	.navbar_gnb li a:nth-of-type(1) {
		margin-right: 7px;
	}

	.navbar_gnb li .loginUser {
		font-size: 13px;
	}

	.navbar_gnb li .loginUser > span {
		background: linear-gradient(to top, #a3f5a8 50%, transparent 50%);
	}

	.v-application ul, .v-application ol {
		padding-left: 0;
	}

	/*선택된 메뉴*/
	.v-tabs:not(.v-tabs--vertical) .v-tab a {
		font-family: 'Gowun Dodum', sans-serif;
		font-weight: bold;
		font-size: 14px;
		color: #222;
		display: block;
		/*border: 1px solid red;*/
	}

	/* li > a */
	.v-tab a {
		/*border: 1px solid red;*/
		display: block;
		padding: 10px 15px;
	}

	/*탭메뉴 클릭시 배경색깔 변경*/
	.v-tab:before {
		/*background-color: rgb(239, 165, 203);*/
	}



</style>
