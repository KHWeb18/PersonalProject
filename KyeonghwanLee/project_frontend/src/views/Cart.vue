<template>
  <div class="wrapper">
    <h1>장바구니</h1>
    <div class="flex-col">
      <ul class="cart-list">
        <li
          v-for="item in cartItems"
          :key="item.id"
          class="flex-col cart-list__item"
        >
          <img :src="makeImagePath(item)" class="thumbnail" alt="" />
          <div class="flex-col cart-list__item__details">
            <div style="margin-top: 8%;">
              <p>{{ item.name }}</p>
              <!--<p>Size: {{ item.size }}</p>
              <p>Color: {{ item.color }}</p>-->
            </div>
            <p style="margin-top: 8%;">{{ item.price }}원</p>
            <button
              @click="removeFromCart(item.id)"
              class="btn cart-list__btn-remove"
              style="margin-top: 7%;"
            >
              취소
            </button>
          </div>
        </li>
      </ul>
      <section class="total-section">
        <ul class="total-section-list">
          <li class="total-section__item" style="margin-top: 10%">
            <p class="total-section__item__label">{{ cartItemsCount }} 상품</p>
            <p>{{ itemsSubtotal }}원</p>
          </li>
          <li class="total-section__item">
            <p class="total-section__item__label">배송료</p>
            <p>{{ shipping }}원</p>
          </li>
          <li class="total-section__item">
            <p class="total-section__item__label">상품+배송료</p>
            <p>{{ subtotal }}원</p>
          </li>
          <li class="total-section__item">
            <p class="total-section__item__label">
              세금 ({{ salesTaxPercentage }})
            </p>
            <p>{{ salesTaxApplied }}원</p>
          </li>
          <li class="total-section__item">
            <p class="total-section__item__label">Total</p>
            <p>{{ total }}원</p>
          </li>
        </ul>
        <button class="btn btn--grey total-section__checkout-button">
          결제
        </button>
      </section>
    </div>
  </div>
</template>

<script>
import { imagePath } from "@/components/mixins/imagePath";
import { mapGetters, mapState } from "vuex";

export default {
  name: "cart",
  mixins: [imagePath],
  data() {
    return {
      salesTax: 0.01,
      selectedShippingOption: "",
      shippingOptionsArray: [],
      shipping: 2500,
    };
  },
  computed: {
    ...mapState({
      checkoutStatus: state => state.cart.checkoutStatus,
    }),
    ...mapGetters("cart", {
      products: "cartItems",
    }),
    cartItems() {
      return this.$store.getters.cartItems;
    },
    cartItemsCount() {
      return this.cartItems.length;
    },
    itemsSubtotal() {
      return this.cartItems.reduce((total, item) => total + item.price, 0);
    },
    subtotal() {
      return (
        Number(this.itemsSubtotal) + Number(this.selectedShippingOption) + 2500
      );
    },
    salesTaxPercentage() {
      return `${this.salesTax * 100}%`;
    },
    salesTaxApplied() {
      return Math.floor((this.subtotal * this.salesTax).toFixed(2) / 10) * 10;
    },
    total() {
      return Number(this.subtotal) + Number(this.salesTaxApplied);
    },
  },
  methods: {
    removeFromCart(itemId) {
      this.$store.dispatch("removeFromCart", itemId);
    },
  },
  mounted() {
    this.id = this.$route.params.id;
  },
};
</script>

<style>
.cart-list {
  width: 70%;
  margin-right: 1rem;
  @media only screen and (max-width: 832px) {
    width: 100%;
  }
}
.cart-list__item {
  text-align: center;
  font-size: 140%;
  width: 100%;
  border-bottom: 1px solid #2c3e50;
}
.cart-list__item__details {
  flex: 2;
  justify-content: space-between;
  margin-left: 2rem;
}
.cart-list__btn-remove {
  margin-top: 0.5rem;
}
.thumbnail {
  width: 100px;
  height: 100px;
  padding-left: 2%;
  margin-top: 0.5rem;
}
.total-section {
  background: #fafafa;
  padding: 0 1rem 1rem;
}
.total-section-list {
  margin: 0;
}
.total-section__item {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.total-section__item__label {
  font-weight: bold;
  margin-right: 1rem;
}
.total-section__checkout-button {
  width: 100%;
}
</style>
