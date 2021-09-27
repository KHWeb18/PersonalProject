<template>
	<div class="home_wrap">
		<swiper class="swiper" :options="swiperOption">
			<swiper-slide><img src="../assets/img/imgSlide5.png"></swiper-slide>
			<swiper-slide><img src="../assets/img/imgSlide1.jpg"></swiper-slide>
			<swiper-slide><img src="../assets/img/imgSlide2.jpg"></swiper-slide>
			<swiper-slide><img src="../assets/img/imgSlide3.jpg"></swiper-slide>
			<swiper-slide><img src="../assets/img/imgSlide4.jpg"></swiper-slide>
			<div class="swiper-pagination" slot="pagination"></div>
			<div class="swiper-button-prev" slot="button-prev"></div>
			<div class="swiper-button-next" slot="button-next"></div>
		</swiper>

		<section id="ranking_wrap">
			<article class="ranking comm_ranking">
				<h1>인기 게시글</h1>
				<hr>
				<ul>
<!--					<router-link v-for="(c, index) in communityList" :key="index" :to="`/community/detail/${c.id}`">-->
<!--						<li>-->
<!--							{{ `${index + 1}위` }} {{ c.title }} <span>{{ c.count }}</span>-->
<!--						</li>-->
<!--					</router-link>-->
					<li class="ranking_subtitle"><strong>순위</strong><em>제목</em><span>조회수</span></li>
					<li v-for="(c, index) in communityList" :key="index">
						<router-link :to="`/community/detail/${c.id}`">
							<strong>{{ `${index + 1}위` }}</strong> <em>{{ c.title }}</em> <span>{{ c.count }}</span>
						</router-link>
					</li>

				</ul>
			</article>

			<article class="ranking gall_ranking">
				<h1>인기 갤러리</h1>
				<hr>
				<ul>
<!--					<router-link v-for="(g, index) in galleryList" :key="index" :to="`/gallery/detail/${g.id}`">-->
<!--						<li>-->
<!--							{{ `${index + 1}위` }} {{ g.title }} <span>{{ g.count }}</span>-->
<!--						</li>-->
<!--					</router-link>-->
					<li class="ranking_subtitle"><strong>순위</strong><em>제목</em><span>조회수</span></li>

					<li v-for="(g, index) in galleryList" :key="index">
						<router-link :to="`/gallery/detail/${g.id}`">
							<strong>{{ `${index + 1}위` }}</strong> <em>{{ g.title }}</em> <span>{{ g.count }}</span>
						</router-link>
					</li>
				</ul>
			</article>
		</section>

		<section id="icon_wrap">
			<div class="inner">
				<h1>반려상식</h1>

				<div class="icon">
					<article>
						<div class="pic">
							<v-icon>mdi-paw</v-icon>
							<p>발바닥</p>
						</div>
					</article>
					<article>
						<div class="pic">
							<v-icon>mdi-cat</v-icon>
							<p>고양이</p>
						</div>
					</article>
					<article>
						<div class="pic">
							<v-icon>mdi-dog</v-icon>
							<p>강아지</p>
						</div>
					</article>
					<article>
						<div class="pic">
							<v-icon>mdi-hospital-box</v-icon>
							<p>건강</p>
						</div>
					</article>
					<article>
						<div class="pic">
							<v-icon>mdi-creation</v-icon>
							<p>케어</p>
						</div>
					</article>
					<article>
						<div class="pic">
							<v-icon>mdi-lightbulb-on</v-icon>
							<p>꿀팁</p>
						</div>
					</article>

				</div>
			</div>
		</section>

		<div class="banner">
			<img src="../assets/img/foo_banner.jpg">
		</div>

	</div>
</template>

<script>
  import api from "../api/api";
  import {Swiper, SwiperSlide} from 'vue-awesome-swiper'
  import 'swiper/css/swiper.css'

  export default {
    name: 'Home',
    title: 'Loop mode / Infinite loop',
    components: {Swiper, SwiperSlide},
    async mounted() {
      await api.get('/board/popular')
        .then((res) => {
          this.communityList = res.data.data;
          console.log("===> res.data.data : ", res.data.data);
        })
        .catch((e) => {
          console.log(e);
        });

      await api.get('/gallery/popular')
        .then((res) => {
          this.galleryList = res.data.data;
          console.log("===> res.data.data : ", res.data.data);
        })
        .catch((e) => {
          console.log(e);
        });
    },
    data() {
      return {
        communityList: [],
        galleryList: [],
        swiperOption: {
          slidesPerView: 1,
          spaceBetween: 30,
          loop: true,
          pagination: {el: '.swiper-pagination', clickable: true},
          navigation: {nextEl: '.swiper-button-next', prevEl: '.swiper-button-prev'},
          autoplay: {delay: 2500, disableOnInteraction: false}
        }
      }
    }
  }

</script>

<style scoped>
	.home_wrap {
		/*width: 1200px;*/
		width: 100%;
		font-family: 'Gowun Dodum', sans-serif;
	}

	h1 {
		font-size: 33px;
		font-weight: bold;
		color: rgb(229, 119, 175);
	}

	strong, em {
		font-style: normal;
		font-weight: normal;
	}

	ol, ul {
		padding-left: 0;
	}

	.v-application a {
		color: #000;
	}


	/*이미지 슬라이드*/
	.swiper-container {
		--swiper-theme-color: #fff;
		--swiper-pagination-color: #ffffff;
	}


	.swiper {
		height: auto;
		/*width: 1200px;*/
		/*margin-top: 10px;*/
	}

	swiper-slide {
		display: flex;
		justify-content: center;
		align-items: center;
		text-align: center;
		font-weight: bold;
	}

	.swiper-slide img {
		width: 100%;
	}



	/*랭킹*/
	#ranking_wrap {
		width: 1200px;
		/*height: 430px; 430이 맞음*/
		margin-top: 80px;
		/*padding: 20px;*/
		/*border: 1px solid red;*/
		/*display: flex;*/
		/*justify-content: space-between;*/
		/*align-items: center;*/
	}

	#ranking_wrap:after {
		content: "";
		display: block;
		clear: both;
	}

	#ranking_wrap .ranking {
		padding: 10px 0;
		/*flex: 1;*/
		width: 40%;
		/*border: 1px solid red;*/
		color: #000;

	}

	#ranking_wrap .ranking h1 {
		font-size: 25px;
	}

	#ranking_wrap .ranking hr {
		width: 100%;
		border: none;
		/*height: 1px;*/
	}

	#ranking_wrap .ranking ul {
		padding: 0 6px;
	}

	#ranking_wrap .ranking ul li.ranking_subtitle {
		margin-bottom: 5px;
		background: linear-gradient(to top, #fdf1f9 30%, transparent 70%);
	}

	#ranking_wrap .ranking ul li.ranking_subtitle strong{
		font-weight: normal;
	}

	#ranking_wrap .ranking ul li.ranking_subtitle em {
		display: inline-block;
		width: 80%;
		/*border: 1px solid red;*/
		text-align: center;
	}

	#ranking_wrap .ranking ul li {
		padding: 3px 0;
	}

	#ranking_wrap .ranking ul li strong {
		margin-right: 10px;
		font-weight: bold;
	}

	#ranking_wrap .ranking ul li em:not(.ranking_subtitle em) {
		/*border: 1px solid red;*/
		margin-left: 10px;
	}

	#ranking_wrap .ranking ul li span {
		float: right;
	}

	#ranking_wrap .comm_ranking {
		float: left;
	}

	#ranking_wrap .gall_ranking {
		float: right;
	}






	/* 아이콘 */
	#icon_wrap {
		width: 100%;
		/*padding: 50px 40px;*/
		padding: 50px 0px;
		box-sizing: border-box;
		transition: 0.5s;
		background-color: rgba(238, 238, 238, 0.45);
		margin-top: 50px;
		/*border: 1px solid red;*/
	}

	#icon_wrap:after {
		content: "";
		display: block;
		clear: both;
	}

	#icon_wrap .inner {
		width: 1180px;
		margin: 0 auto;
	}

	#icon_wrap .inner h1 {
		/*float: left;*/
		margin-bottom: 35px;
		font-size: 25px;
	}

	#icon_wrap .inner .icon {
		/*float: right;*/
		transition: 0.5s;
		box-sizing: border-box;
	}

	#icon_wrap .inner .icon article {
		float: left;
		/*margin-left: 65px;*/
		margin-left: 165px;
		width: 58px;
	}

	#icon_wrap .inner .icon article:nth-of-type(1) {
		margin-left: 0px;
		/*border: 1px solid red;*/
	}

	#icon_wrap .inner .icon article .pic {
		width: 100%;
		height: 58px;
		text-align: center;
	}

	#icon_wrap .inner .icon article .pic > i {
		font-size: 40px;
		color: #777;
		transition: .3s;
	}

	#icon_wrap .inner .icon article .pic > p {
		font-size: 11px;
		margin-top: 10px;
	}

	#icon_wrap .inner .icon article .pic:hover i {
		transform: scale(1.2);
	}

	/*하단 줄배너*/
	.banner {
		margin-top: 150px;
	}

	.banner img{
		max-width: 100%;
	}
</style>
