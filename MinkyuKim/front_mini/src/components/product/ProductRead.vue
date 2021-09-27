<template>
    <div>
        <h3>상품 내용</h3>
        <div>
            <tr>
                <td v-show="false">상품번호</td>
                <td><input v-show="false" type="text" :value="product.productNo" readonly></td>
            </tr>
            <tr>
                <td v-show="false">등록일자</td>
                <td><input v-show="false" type="text" :value="product.regDate" readonly></td>
            </tr>
        </div>
        <div>
            <span>

            <span>
                <div style="float: left;">
                <tr></tr>
                
                <td>                    
                    <img :src="require(`@/assets/imgproduct/${product.files}`)" alt="...">                    
                </td>
                </div>
            </span>
            <br>
            <div>
                <span>
                    
                    <div style="float:left; padding-left:30px;">
                        <tr>
                            <td>판매자</td>
                            <td style="padding-left:20px;">{{product.producer}}</td>
                            <!--<td style="padding-left:20px;"><input type="text" :value="product.producer" readonly></td>-->
                        </tr>
                    </div>
                </span>
                <br><br><br>
                <span>
                    <div style="float:left; padding-left:30px;">
                        <tr>
                            <td>상품명</td>
                            <td style="padding-left:20px;">{{product.product_name}}</td>
                            <!--<td style="padding-left:20px;"><input type="text" :value="product.product_name" readonly></td>-->
                        </tr>
                    </div>
                </span>
                <br><br><br>
                <span>
                    <div style="float:left; padding-left:30px;">
                        <tr>
                            <td>상품가격</td>
                            <td style="padding-left:20px;">₩ {{product.price}}</td>
                            <!--<td style="padding-left:20px;"><input type="number" :value="product.price" readonly></td>-->
                        </tr>      
                    </div>
                    
                </span>  
                
            </div>
                
            </span>
            <br><br><br>
            <v-card-actions>
                <v-btn block class="white--text" color="#8d192b">
                장바구니 담기
                </v-btn>            
            </v-card-actions>                
            <v-card-actions>
                <v-btn block class="white--text" color="#8d192b">
                    구매하기
                </v-btn>            
             </v-card-actions>
            
        </div>
        <br>
        <!--
        <div style="float:left; padding-left:30px;">
        <v-btn> 장바구니 담기 </v-btn>
        </div>
        <div style="float:left; padding-left:10px;">
        <v-btn> 구매하기 </v-btn>
        </div>
        <br><br>
        -->
        <table>
        <!--    
            <tr>
                <td>판매자</td>
                <td><input type="text" :value="product.producer" readonly></td>
            </tr>
            <tr>
                <td>상품명</td>
                <td><input type="text" :value="product.product_name" readonly></td>
            </tr>
            <tr>
                <td>상품가격</td>
                <td><input type="number" :value="product.price" readonly></td>
            </tr>            
            -->
            <tr>
                <table style="width:100%; height:50px; border: 1px solid; background-color: #003663; color:white; font-size:25px;">
                <div style="text-align: center; bold:5em; ">
                <strong style="padding-top:10px">상품 정보</strong>
                </div>
                </table>
                <div>
                <td><textarea cols="200" rows="1000" :value="product.description" readonly></textarea></td>
                </div>
            </tr>            
        </table>         
    </div>
</template>

<script>
export default {
    name: 'ProductRead',
    props: {
        products: {
            type: Array
        },
        product: {
            type: Object,
            required: true
        },       
        methods: {
            
            /*
            addOrder(product) {
                this.$store.dispatch("addCart", product);
                },*/
        }, 
        
    }  
}

</script>

<style scoped>
img {    
    height: 300px; 
    width: 400px;

}
</style>