<template>
  <div class="menu-item" @click="isOpen = !isOpen">
    <a href="#">
      {{ title }}
    </a>

    <div class="sub-menu" v-if="isOpen">
      <div class="menu-item">
        <router-link
          :to="{
            name: 'category-overview',
            params: { category: 'vegetable' },
          }"
          class="nav-items__item"
          >채소</router-link
        >
      </div>
      <div class="menu-item">
        <router-link
          :to="{ name: 'category-overview', params: { category: 'fruits' } }"
          class="nav-items__item"
          >과일</router-link
        >
      </div>
      <div class="menu-item">
        <router-link
          :to="{
            name: 'category-overview',
            params: { category: 'butchery·egg' },
          }"
          class="nav-items__item"
          >정육·계란</router-link
        >
      </div>
      <div class="menu-item">
        <router-link
          :to="{
            name: 'category-overview',
            params: { category: 'rice·grains' },
          }"
          class="nav-items__item"
          >쌀·잡곡류</router-link
        >
      </div>
      <div class="menu-item">
        <router-link
          :to="{
            name: 'category-overview',
            params: { category: 'seasoning·oil' },
          }"
          class="nav-items__item"
          >양념·오일</router-link
        >
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Category",
  props: ["title"],
  data() {
    return {
      isOpen: false,
    };
  },
};
</script>

<style scoped>
a,
a:visited {
  outline: none;
  color: #000000;
  border-radius: 2px;
}

a:hover {
  text-decoration: pink;
}
.menu-item {
  color: black;
  padding-top: 15%;
}
</style>
