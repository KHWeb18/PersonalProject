<template>
	<div class="store_wrap">
		<div class="bestItem">
			<h1>인기상품</h1>
			<section>
				<article>
					<div class="itemImg">
						<img src="https://shop-phinf.pstatic.net/20210809_235/1628496296011yJ7VQ_JPEG/3.jpg?type=w860" alt="당근">
					</div>
					<div class="itemText">
						<h2>고양이 당근 스크래쳐</h2>
						<p>30,900원</p>
						<strong>★4.8</strong> <span>리뷰 124</span>
					</div>
				</article>

				<article>
					<div class="itemImg">
						<img src="https://shop-phinf.pstatic.net/20210809_235/1628496296011yJ7VQ_JPEG/3.jpg?type=w860" alt="당근">
					</div>
					<div class="itemText">
						<h2>고양이 당근 스크래쳐</h2>
						<p>30,900원</p>
						<strong>★4.8</strong> <span>리뷰 124</span>
					</div>
				</article>

				<article>
					<div class="itemImg">
						<img src="https://shop-phinf.pstatic.net/20210809_235/1628496296011yJ7VQ_JPEG/3.jpg?type=w860" alt="당근">
					</div>
					<div class="itemText">
						<h2>고양이 당근 스크래쳐</h2>
						<p>30,900원</p>
						<strong>★4.8</strong> <span>리뷰 124</span>
					</div>
				</article>

				<article>
					<div class="itemImg">
						<img src="https://shop-phinf.pstatic.net/20210809_235/1628496296011yJ7VQ_JPEG/3.jpg?type=w860" alt="당근">
					</div>
					<div class="itemText">
						<h2>고양이 당근 스크래쳐</h2>
						<p>30,900원</p>
						<strong>★4.8</strong> <span>리뷰 124</span>
					</div>
				</article>

				<article>
					<div class="itemImg">
						<img src="https://shop-phinf.pstatic.net/20210809_235/1628496296011yJ7VQ_JPEG/3.jpg?type=w860" alt="당근">
					</div>
					<div class="itemText">
						<h2>고양이 당근 스크래쳐</h2>
						<p>30,900원</p>
						<strong>★4.8</strong> <span>리뷰 124</span>
					</div>
				</article>

				<article>
					<div class="itemImg">
						<img src="https://shop-phinf.pstatic.net/20210809_235/1628496296011yJ7VQ_JPEG/3.jpg?type=w860" alt="당근">
					</div>
					<div class="itemText">
						<h2>고양이 당근 스크래쳐</h2>
						<p>30,900원</p>
						<strong>★4.8</strong> <span>리뷰 124</span>
					</div>
				</article>

				<article>
					<div class="itemImg">
						<img src="https://shop-phinf.pstatic.net/20210809_235/1628496296011yJ7VQ_JPEG/3.jpg?type=w860" alt="당근">
					</div>
					<div class="itemText">
						<h2>고양이 당근 스크래쳐</h2>
						<p>30,900원</p>
						<strong>★4.8</strong> <span>리뷰 124</span>
					</div>
				</article>

				<article>
					<div class="itemImg">
						<img src="https://shop-phinf.pstatic.net/20210809_235/1628496296011yJ7VQ_JPEG/3.jpg?type=w860" alt="당근">
					</div>
					<div class="itemText">
						<h2>고양이 당근 스크래쳐</h2>
						<p>30,900원</p>
						<strong>★4.8</strong> <span>리뷰 124</span>
					</div>
				</article>



			</section>
<!--			<ul>-->
<!--				<li>-->
<!--					<img src="https://shop-phinf.pstatic.net/20210809_235/1628496296011yJ7VQ_JPEG/3.jpg?type=w860" alt="당근">-->
<!--					-->
<!--				</li>-->
<!--			</ul>-->


		</div>

		<div class="category">
			<h1>카테고리</h1>
			<div class="itemWrap"></div>
		</div>

		<div class="newItem">
			<h1>NEW 상품</h1>
			<div class="itemWrap"></div>
		</div>

	</div>

</template>

<script>
  export default {
    name: 'StoreList',

  };
</script>

<style scoped>

	.store_wrap {
		width: 1200px;
		margin-top: 100px;
		/*height: 60vh;*/
		display: flex;
		flex-direction: column;
		/*justify-content: space-evenly;*/
		/*align-items: center;*/
	}

	h1 {
		font-size: 33px;
		font-weight: bold;
		width: 100%;
		color: rgb(229, 119, 175);
		font-family: 'Gowun Dodum', sans-serif;
	}

	h2, p, strong, span {
		font-family: 'Gowun Dodum', sans-serif;
	}

	h2 {
		font-size: 22px;
	}

	section {
		width: 1200px;
	}

	article {
		width: 285px;
		float: right;
	}

	.itemImg img{
		width: 100%;
	}






	/*article {*/
	/*	width: 285px;*/
	/*	margin-right: 20px;*/
	/*	!*float: right;*!*/


	/*}*/

	/*article:nth-last-of-type(4) {*/
	/*	margin-right: 0;*/
	/*}*/

	/*.storeImg {*/
	/*	!*width: 100%;*!*/
	/*}*/

	/*.storeImg img {*/
	/*	width: 100%;*/
	/*	height: 350px;*/
	/*}*/



</style>
