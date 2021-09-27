<template>
  <div>
    <v-container>
      <section class="wrapper">
        <h2>Best 상품</h2>
        <ul class="featured-items">
          <li
            v-for="product in featuredProducts"
            :key="product.id"
            class="featured-items__item"
          >
            <v-card>
              <router-link
                :to="{ name: 'product', params: { id: product.id } }"
              >
                <img class="product-image" :src="imagePath(product)" alt="" />
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
              <v-btn @click="addToCart" class="btn btn--grey">
                <v-icon color="grey lighten-1">
                  mdi-cart
                </v-icon>
              </v-btn>
            </v-card>
          </li>
        </ul>
        <!--<v-card :loading="loading" class="mx-auto my-12" max-width="374">
        <template slot="progress">
          <v-progress-linear
            color="deep-purple"
            height="10"
            indeterminate
          ></v-progress-linear>
        </template>

        <v-img
          height="250"
          src="https://cdn.vuetifyjs.com/images/cards/cooking.png"
        ></v-img>

        <v-card-title>Cafe Badilico</v-card-title>

        <v-card-text>
          <v-row align="center" class="mx-0">
            <v-rating
              :value="4.5"
              color="amber"
              dense
              half-increments
              readonly
              size="14"
            ></v-rating>

            <div class="grey--text ms-4">
              4.5 (413)
            </div>
          </v-row>
        </v-card-text>

        <v-card-actions>
          <v-btn color="deep-purple lighten-2" text @click="reserve">
            Reserve
          </v-btn>
        </v-card-actions>
      </v-card>-->
      </section>
    </v-container>
  </div>
</template>
<script>
export default {
  name: "BestProductPage",
  data: () => ({
    loading: false,
    selection: 1,
  }),
  computed: {
    featuredProducts: function() {
      return this.$store.getters.featuredProducts;
    },
  },
  methods: {
    imagePath(product) {
      return require(`../assets/products/${product.images[0]}`);
    },
    addToCart() {
      this.$store.dispatch("addToCart", this.$route.params.id);
    },
    reserve() {
      this.loading = true;

      setTimeout(() => (this.loading = false), 2000);
    },
  },
};
</script>
<style lnag="scss" scoped>
* {
  list-style: none;
}
.v-card {
  width: 200px;
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
}
.product-title {
  font-weight: bold;
}
</style>
