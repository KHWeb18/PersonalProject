export const imagePath = {
  methods: {
    makeImagePath(product) {
      return require(`@/assets/products/${product.images[0]}`);
    },
  },
};
