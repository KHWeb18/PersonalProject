<template>
	<footer id="footer">
		<div class="inner">
			<div class="fl">
				<ul>
					<li><router-link to="">이용약관</router-link></li>
					<li><router-link to="">개인정보취급방침</router-link></li>
					<li><router-link to="">매장안내</router-link></li>
					<li><router-link to="">고객센터</router-link></li>
				</ul>

				<p>
					(주)PETTALK / 대표이사 : 최혜주 / 경기도 성남시 분당구 북정로 6(정자동 178-1)<br />
					대표메일주소 : 6547123@naver.com / TEL : 010-9401-5955<br />
					사업자등록번호 : 123-45-67890
				</p>
				<div class="copyRight">Copyright ⓒ 2021 CHOI HYE JOO. All right reserved.</div>
			</div>
			<div class="fr">
				<div class="customer">
					<P><em>고객센터 010-9401-5955</em></P>
					<P>월-금 : 오전 10시 ~ 오후 5시 (휴게시간 12:30 ~ 2:00)<br />토,일,공휴일 휴무</P>
				</div>
				<ul class="sns">


					<li>
						<router-link to=""><v-icon>mdi-facebook</v-icon></router-link>
					</li>
					<li>
						<router-link to=""><v-icon>mdi-youtube</v-icon></router-link>
					</li>
					<li>
						<router-link to=""><v-icon>mdi-twitter</v-icon></router-link>
					</li>

				</ul>
			</div>
		</div>
	</footer>
</template>

<script>
  export default {
    name: "Footer"
  }
</script>

<style scoped>
	#footer {
		background: #fff;
		/*margin-top: 300px;*/
		position: relative;
		transition: 0.5s;
		border-top: 1px dashed #ddd;
		padding: 50px 100px;
		bottom: -50px;
		/*color: rgb(229, 119, 175);*/
		font-family: 'Gowun Dodum', sans-serif;
	}

	#footer:after, #footer .inner:after {
		content: "";
		display: block;
		clear: both;
	}

	#footer .inner {
		width: 1180px;
		margin: 0 auto;
		position: relative;
	}

	#footer .inner .fl {
		float: left;
	}


	#footer .inner .fl ul::after {
		content: '';
		clear: both;
		display: block;
	}

	#footer .inner .fl ul li {
		float: left;

	}

	#footer .inner .fl ul li:not(:last-of-type) {
		margin-right: 40px; }

	#footer .inner .fl ul li a {
		font-size: 15px;
		border-bottom: 1px solid #666;
		color: #111;
	}

	#footer .inner .fl p {
		line-height: 25px;
		font-size: 15px;
		margin: 22px 0;
	}

	#footer .inner .fl .copyRight {
		font-size: 15px;
	}

	#footer .inner .fr {
		float: right;
	}

	#footer .inner .fr p {
		font-size: 15px;
		line-height: 25px;
	}

	#footer .inner .fr p em {
		font-size: 22px;
		font-style: normal;
		font-weight: 600;
	}

	#footer .inner .fr .sns {
		margin-top: 30px;
	}

	#footer .inner .fr .sns li {
		float: left;

	}

	#footer .inner .fr .sns li:not(:last-of-type) {
		margin-right: 30px;
	}

	#footer .inner .fr .sns li i {
		font-size: 45px;
		color: rgb(229, 119, 175);
	}
</style>
