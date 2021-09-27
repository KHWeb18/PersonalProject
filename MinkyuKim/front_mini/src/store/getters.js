export default {
    staySignedIn(state) {
        return state.isLogin
    },
    
    getSession (state) {
        return state.session
    },
//name: product.product_name,
//price: product.price,            
//itemtotalprice: product.price,
    getcartProducts(state) {
        return state.cart.map(cartItem => {
            const product = state.products.find(product => product.product_name === cartItem.productId);
            if(product === undefined) {
                return {
                    quantity: 0,
                    itemtotalprice: 0,
                }
            } else return {
                id: product.productNo,
                name: product.product_name,
                price: product.price,
                itemtotalprice: cartItem.itemtotalprice,
            };
        });
    },
    getcartProductsthis:(state) => (productItem) => {
        const cartItem = state.cart.find(item => item.productId === productItem.id);
        const product = state.products.find(product => product.id === productItem.id);
        if(cartItem === undefined) {
            return {
                quantity: 0,
                itemtotalprice: 0,
            }
        }
        return {
            product : product.product_name,            
            itemtotalprice: cartItem.itemtotalprice,
        };
    },
    cartTotal(state) {
        let total = 0;
        state.cart.forEach(cartItem => {
            total += cartItem.itemtotalprice;
        });
        return total;
    },
}