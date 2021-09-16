<template>
  <div>
    <hooper
      :infiniteScroll="true"
      :autoPlay="true"
      :playSpeed="4000"
      class="text-center"
      id="hooper"
    >
      <slide v-for="slide in slides" :key="slide.id" class="slide">
        <p>{{ slide.id }}</p>
        <img :src="slide.image[0]" class="img-fluid" />
      </slide>
      <hooper-navigation slot="hooper-addons"></hooper-navigation>
    </hooper>
    <div>
      <div>
        <section class="wrapper">
          <h2>추천 상품</h2>
          <ul class="featured-items">
            <li
              v-for="product in featuredProducts"
              :key="product.id"
              class="featured-items__item"
            >
              <router-link
                :to="{ name: 'product', params: { id: product.id } }"
              >
                <img class="product-image" :src="imagePath(product)" alt="" />
                <p class="product-title">{{ product.name }}</p>
                <p>
                  <em>{{ product.price }}원</em>
                </p>
              </router-link>
            </li>
          </ul>
        </section>
      </div>
    </div>
  </div>
</template>

<script>
import { Hooper, Slide, Navigation as HooperNavigation } from "hooper";
import "hooper/dist/hooper.css";
export default {
  name: "home",
  computed: {
    featuredProducts: function() {
      return this.$store.getters.featuredProducts.slice(0, 4);
    },
  },
  methods: {
    imagePath(product) {
      return require(`../assets/products/${product.images[0]}`);
    },
  },
  components: { HooperNavigation, Hooper, Slide },
  data() {
    return {
      slides: [
        {
          slideTitle: "Event1",
          image: [require("../assets/events/event11.jpg")],
          route: "/product",
          slideId: 1,
        },
        {
          slideTitle: "Event2",
          image: [require("../assets/events/event22.jpg")],
          slideId: 2,
        },
        {
          slideTitle: "Event3",
          image: [require("../assets/events/event33.jpg")],

          slideId: 3,
        },
      ],
    };
  },
};
</script>

<style lnag="scss" scoped>
* {
  list-style: none;
}
#hooper {
  height: 40vh;
}
.wrapper {
  max-width: 1000px;
  margin: 0 auto;
  @media only screen and (max-width: 832px) {
    max-width: 100%;
    padding: 1rem;
    text-align: center;
  }
}
.featured-items {
  padding-left: 0;
  list-style: none;
  display: flex;
  justify-content: space-between;
  @media only screen and (max-width: 832px) {
    flex-direction: column;
  }
}
.featured-items__item {
  width: 33%;
  text-align: center;
  @media only screen and (max-width: 832px) {
    width: 100%;
  }
}
.product-image {
  height: 200px;
  width: 200px;
  padding-left: 10%;
}
.product-title {
  font-weight: bold;
}
</style>
