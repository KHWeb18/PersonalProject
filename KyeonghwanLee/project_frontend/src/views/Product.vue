<template>
  <div>
    <section class="wrapper">
      <div class="flex-col">
        <img class="flex-col--2" :src="makeImagePath(product)" alt="" />
        <div class="flex-col--2">
          <h2>{{ product.name }}</h2>
          <h5>가격: {{ product.price }}원</h5>
          <p>중량/용량: {{ product.weight }}</p>
          <p>원산지: {{ product.origin }}</p>
          <p>
            <em>{{ product.quantity }} 개 남음</em>
          </p>
          <!--<h3>Details</h3>-->
          <ul>
            <!--<li>Material: {{ product.details.material }}</li>
            <li>Fit: {{ product.details.fit }}</li>
            <li>Maintenance: {{ product.details.maintenance }}</li>
            <li v-if="product.details.additional">
              Additional: {{ product.details.additional }}
            </li>-->
          </ul>
          <button @click="addToCart" class="btn btn--grey">
            장바구니 담기
          </button>
        </div>
      </div>
    </section>
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
    addToCart() {
      this.$store.dispatch("addToCart", this.$route.params.id);
    },
  },
};
</script>

<style lang="scss">
.flex-col {
  display: flex;
  align-items: flex-start;
}
.flex-col--2 {
  width: 50%;
  height: 90%;
  font-size: 1.4rem;
  font-family: "Avenir", Helvetica, Arial, sans-serif;
}
.flex-justify-right {
  text-align: right;
}
.flex-col--align-center {
  align-items: center;
}
.btn {
  padding: 0.5rem 0.75rem;
  border-radius: 3px;
  border: none;
  background-color: transparent;
  font-size: 0.9rem;
  font-weight: bold;
  cursor: pointer;
  transition: all 0.15s ease;
}
.btn--grey {
  background-color: #2c3e50;
  color: #fff;
  &:hover,
  &:focus {
    background-color: #42b983;
  }
}
</style>
