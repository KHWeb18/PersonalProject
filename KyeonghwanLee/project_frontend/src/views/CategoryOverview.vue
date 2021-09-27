<template>
  <div>
    <h1 class="wrapper">{{ pageTitle }}</h1>
    <ul class="wrapper item-grid">
      <li
        v-for="product in productsByCategory"
        :key="product.id"
        class="item-grid__item"
      >
        <v-card>
          <router-link :to="{ name: 'product', params: { id: product.id } }">
            <img class="product-image" :src="makeImagePath(product)" alt="" />
            <p class="product-title">{{ product.name }}</p>
            <p>
              <em>{{ product.price }}원</em>
            </p>
          </router-link>
          <v-divider class="mx-4"></v-divider>
          <v-row align="center" class="mx-0" style="margin-top:2%">
            <v-rating
              :value="Math.random() * 2 + 3.5"
              color="amber"
              dense
              half-increments
              readonly
              size="14"
              style="margin-left : 28%;"
            ></v-rating>
          </v-row>
          <v-btn
            @click="addToCart"
            class="btn btn--grey"
            style="margin-bottom :8%; "
          >
            <v-icon color="grey lighten-1">
              mdi-cart
            </v-icon>
          </v-btn>
        </v-card>
      </li>
    </ul>
  </div>
</template>

<script>
import { imagePath } from "@/components/mixins/imagePath.js";

export default {
  name: "product",
  mixins: [imagePath],
  data() {
    return {
      product: this.$store.getters.product(this.$route.params.id),
    };
  },
  methods: {
    imagePath(product) {
      return require(`../assets/products/${product.images[0]}`);
    },
    addToCart() {
      this.$store.dispatch("addToCart", this.$route.params.id);
    },
  },
  computed: {
    category() {
      return this.$route.params.category;
    },
    pageTitle() {
      return `${this.category[0].toUpperCase()}${this.category.slice(1)}`;
    },
    productsByCategory() {
      return this.$store.getters.productsByCategory(this.category);
    },
  },
};
</script>

<style lang="scss">
.item-grid__item {
  width: 33%;
  text-align: center;
  @media only screen and (max-width: 832px) {
    width: 100%;
  }
}
.v-card {
  width: 200px;
  text-align: center;
}
.product-image {
  height: 200px;
  width: 200px;
}
.product-title {
  font-weight: bold;
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
.wrapper item-grid {
  padding-left: 0;
  list-style: none;
  display: flex;
  justify-content: space-between;
  @media only screen and (max-width: 832px) {
    flex-direction: column;
  }
}
</style>
