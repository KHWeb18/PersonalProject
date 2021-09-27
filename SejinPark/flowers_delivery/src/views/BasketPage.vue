<template>
    <v-container>
       
        <v-row>
            <v-col v-for="image in images" :key="image" class="d-flex child-flex" cols="3">
                <router-link to="/product1">

                
                <v-img :src="image" aspect-ratio="1" class="gery lighten-2">
                    
                    <template v-slot:placeholder>

                        <v-row class="fill-height ma-0" align="center" justify="center">
                            <v-progress-circular indeterminate color="grey lighten-5">
                            </v-progress-circular>
                        </v-row>
                    </template>
                </v-img>
                </router-link>

            </v-col>
        </v-row>
    </v-container>
</template>

<script>
export default {
    name: 'BasketPage',
    data () {
        return {
            images: [
                //require('@/assets/img/ferrari.jpg'),
               
                
                "https://image.freepik.com/free-photo/beautiful-flower-basket-table_175677-96.jpg",
                 "http://m.vertetblanc.co.kr/web/product/big/201609/37_shop1_484038.jpg",
                 "https://cdn.shopify.com/s/files/1/0067/4132/7942/products/image_530x@2x.jpg?v=1588074898",
                 "https://4.imimg.com/data4/WQ/PP/MY-29755323/red-flower-basket-500x500.jpg",
                 "https://image.freepik.com/free-photo/beautiful-flower-basket-table_175677-96.jpg",
                 "http://m.vertetblanc.co.kr/web/product/big/201609/37_shop1_484038.jpg",
                 "https://cdn.shopify.com/s/files/1/0067/4132/7942/products/image_530x@2x.jpg?v=1588074898"
              
            ]
        }
    }
}
</script>

<style scoped>

v-cols {
    padding: 10px;
    margin:  10px;
}
v-row {
    padding: 10px;
    margin: 10px;
}
</style>