<template>
  <header>
    <div id="app">
      <h1>
        <a href="/" class="logo"
          ><img
            alt="logo1"
            src="../../assets/logos/logo1.jpg"
            width="300"
            height="120"
          />
        </a>
      </h1>
      <div class="menuWrap">
        <ul class="menu">
          <li><a href="/member/create">회원가입</a></li>
          <li><a href="/member/login">로그인</a></li>
          <li>
            <a
              ><router-link to="/cart">장바구니</router-link>
              <counter-badge :count="cartCount"></counter-badge>
            </a>
          </li>
        </ul>
      </div>
    </div>
  </header>
</template>

<script>
import CounterBadge from "@/components/badge/CounterBadge";

export default {
  data() {
    return {
      product: this.$store.getters.product(this.$route.params.id),
      cartItems: this.$store.getters.product(this.$route.params.id),
    };
  },
  mounted() {
    this.cartItems = this.$route.params.id;
  },
  components: { CounterBadge },
  computed: {
    cartCount() {
      return this.$store.state.cart.length;
    },
  },
};
</script>

<style scoped>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}
header {
  width: 100%;
  text-align: center;
  position: relative;
  height: 140px;
}
header h1 {
  position: center;
  top: 0;
  left: 100px;
}
header ul.menu:after {
  display: block;
  clear: both;
  content: "";
}
header ul.menu {
  position: absolute;
  top: 20px;
  right: 50px;
}
header ul.menu li {
  float: left;
  padding: 5px 10px;
  list-style: none;
}
.nav-items {
  justify-content: flex-end;
  display: flex;
}
.nav-items__item {
  margin-left: 1rem;
  position: relative;
}
ul {
  padding-left: 0;
  list-style: none;
}
a {
  text-decoration: none;
  color: #333;
}
.badge {
  position: absolute;
  top: -0.5rem;
  right: -1.3rem;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 20px;
  width: 20px;
  border-radius: 20px;
  background-color: #42b983;
  color: #fff;
  font-weight: bold;
  font-size: 12px;
}
</style>
