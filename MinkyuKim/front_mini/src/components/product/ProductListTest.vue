<template>
<!--
    <div>
        <h3>판매작품 목록</h3>
        <table border="1">
            <tr>
                <th align="center" width="100">상품번호</th>
                <th align="center" width="450">상품명</th>
                <th align="center" width="150">판매자</th>
                <th align="center" width="150">상품가격</th>
                <th align="center" width="240">등록일자</th>
            </tr>
            <tr v-if="!products || (Array.isArray(products) && products.length === 0)">
                <td colspan="4">
                    현재 등록된 상품이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="product in products" :key="product.productNo">
                <td align="center">{{ product.productNo }}</td>
                <td align="left">
                    <router-link :to="{ name: 'ProductReadPage',
                                    params: { productNo: product.productNo.toString() } }">
                        {{ product.product_name }}
                    </router-link>
                </td>
                <td align="center">{{ product.producer }}</td>
                <td align="center">{{ product.price }}</td>
                <td align="center">{{ product.regDate }}</td>
            </tr>
        </table>
    </div>-->
    
    
        <div>                     
            <table class="table-style"></table>
            <br>
     <div class="row">         
        <div class="col-xl-4 col-lg-4 col-md-6" :key="product.productNo" v-for="product in products">            
                <div class="card" 
                style=" background-color: white; padding:10px; height:400px; width:300px; cursor: pointer;">                
                
                    <router-link class="default-link" style="color:black;"
                    :to="{ name: 'ProductReadPage', params: { productNo: product.productNo.toString() } }">
                    <div style="height:295px; width:295px:">
                        
                        <img :src="require(`@/assets/imgproduct/${product.files}`)" class="card-img-top" alt="...">
                        
                        <!--
                        <tr>
                            
                            <td v-for="product in products" :key="product.productNo">
                        <img :src="require(`@/assets/imgproduct/${product.file_name}`)" class="card-img-top" alt="...">
                            </td>
                        </tr>-->
                        
                        <!--<img :src="`/download/${product.productNo}/${product.path}`" class="card-img-top" alt="...">-->
                        <!--
                        <table border="1">
                            <tr v-for="(product, idx) in products" v-bind:key="idx">
                                <td>
                                    <img :src="require(`@/assets/imgproduct/${product[idx].file_name}`)">
                                </td>
                            </tr>
                        </table>
                        -->
                        <!--<img :src="(`@/assets/imgproduct/${product[idx].img}`)">-->
                        
                        
                    </div>
                    <!--<a @click="goToDetail(product.productNo);" style="cursor:pointer;">
                        <img :src="`/download/${product.id}/${product.path}`" class="card-img-top" alt="..."></a>-->
                        
                        

                    <div class="card-body">
                        
                        <h5 class="card-title" style="font-weight: bolder; text-align:center; color:#003663; ">{{product.product_name}}</h5>              
                        
                        
                    <!--
                    <div class="btn-group" role="group">
                    <button type="button" class="btn btn-sm btn-outline-secondary">장바구니 담기</button>
                    <button type="button" class="btn btn-sm btn-outline-secondary">주문하기</button>
                    </div>
                    -->                        
                    
                        <center>
                        <small class="center" style="font-weight: bold; float:right">₩ {{product.price}}원</small>
                        </center>
                        
                    
                        
                    </div>
                </router-link>
            </div>          
        </div>
    </div>
    </div>        
    
</template>

<script>

//import axios from 'axios'
import { mapActions } from 'vuex'

export default {
    name: 'ProductListTest',    
    /*
    props: {
        products: {
            type: Array
        },
        
        
    },*/
    
    props: {
        products: {
            type: Array
        },
        
        
        
    },
    
    /*
    computed: {
        ...mapState(['products']),
        
    },*/
    
    methods: {    
        ...mapActions(['fetchProduct']),    
        /*
    goToDetail(productNo) {
        this.$router.push({name:'ProductReadPage', params: { productNo: product.productNo.toString() }})
        //this.$router.push({path:'/product/:productNo', query: {product:productNo}}); 
        }
        goToDetail(event, idx) {
            console.log("글 번호: " + idx.item.productNo)
            this.$router.push({name: 'ProductReadPage', params: {productNo: String(idx.item.productNo)}})
            https://github.com/ekankr2/GoFor/blob/main/frontend/src/components/board/BoardList.vue
    },*/
    },      
}

</script>

<style scoped>
.default-link:hover {
    text-decoration: none;
    color:red;
    background-color: black;
    cursor: pointer;

}
.table-style {
    height: 5px;
    background-color: #003663;
}

img {
    width: 100%;
    height: 100%;    
}
small {
    text-align: right;
}
</style>