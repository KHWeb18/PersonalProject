<template functional>
  <v-lazy-image
    :src="props.src"
    :src-placeholder="props.srcPlaceholder"
    alt="Periscope"
  ></v-lazy-image>
</template>

<style scoped>
.v-lazy-image {
  opacity: 0;
  transform: translate3d(0, 50%, 0);
  transition: opacity 1s, transform 2s;
}
.v-lazy-image-loaded {
  opacity: 1;
  transform: translate3d(0, 0, 0);
}
</style>
