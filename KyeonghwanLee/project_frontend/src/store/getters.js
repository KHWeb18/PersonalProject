export default {
  product: state => id => {
    return state.products.filter(p => p.id === Number(id))[0];
  },
  /*cartItems: state => id => {
    return state.cart.map.filter(p => p.id === Number(id))[0];
  },*/
  cartItems: state => {
    return state.cart.map(itemId =>
      state.products.find(product => product.id === itemId)
    );
  },
  featuredProducts: state => {
    return state.products.filter(p => p.featured);
  },
  getSession(state) {
    return state.session;
  },
  productsByGender: state => gender => {
    return state.products.filter(p => p.gender === gender);
  },
  //productsByCategory: (category) => {
  //return this.state.products.filter(p => p.category === category)
  //}
  productsByCategory: state => category => {
    return state.products.filter(p => p.category === category);
  },
};
