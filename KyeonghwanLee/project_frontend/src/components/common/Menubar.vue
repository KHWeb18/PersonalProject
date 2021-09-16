<template>
  <div id="main">
    <nav offset-y>
      <a><category title="카테고리"/></a>
      <a href="/BestProduct">BEST 상품</a>
      <a href="/board">공지안내</a>
      <a href="/daumNewsCrawler">news</a>
    </nav>
  </div>
</template>

<script>
import Category from "../../views/Category.vue";

export default {
  data() {
    return {
      isOpen: false,
    };
  },
  components: {
    Category,
  },
};
</script>

<style scoped>
body {
  font: 15px/1.3 "Open Sans", sans-serif;
  color: #5e5b64;
  text-align: center;
}

a,
a:visited {
  outline: none;
  color: #389dc1;
}

a:hover {
  text-decoration: pink;
}

section,
footer,
header,
aside,
nav {
  display: block;
}

/*-------------------------
  The menu
--------------------------*/

nav {
  display: inline-block;
  margin: 60px auto 45px;
  background-color: #63b0d1;
  box-shadow: 0 1px 1px #ccc;
  border-radius: 2px;
}

nav a {
  display: inline-block;
  padding: 18px 30px;
  color: rgb(0, 0, 0) !important;
  font-weight: bold;
  font-size: 16px;
  text-decoration: none !important;
  line-height: 1;
  text-transform: uppercase;
  background-color: transparent;

  -webkit-transition: background-color 0.25s;
  -moz-transition: background-color 0.25s;
  transition: background-color 0.25s;
}

nav a:first-child {
  border-radius: 2px 0 0 2px;
}

nav a:last-child {
  border-radius: 0 2px 2px 0;
}

nav.home .home,
nav.projects .projects,
nav.services .services,
nav.contact .contact {
  background-color: #e35885;
}

p {
  font-size: 22px;
  font-weight: bold;
  color: #7d9098;
}

p b {
  color: #ffffff;
  display: inline-block;
  padding: 5px 10px;
  background-color: #c4d7e0;
  border-radius: 2px;
  text-transform: uppercase;
  font-size: 18px;
}
.resource {
  margin: 20px 0;
}
</style>
