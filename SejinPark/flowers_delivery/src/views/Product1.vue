<template>
    <div class="product1">
        <div class="product-image" style="float:left;">
            <img v-bind:src="image" >
        </div>
        
        <div class="product-info" style="position:relative;">
            <h3> {{product}} </h3>
        </div>
        <div>
            <li >
                <ul>가격:8000</ul>
            
            </li>
        </div>


    </div>
</template>

<script>
export default {
    name: 'product',
    data() {
        return {
        product:'컬렉션',
        image:'https://image.freepik.com/free-photo/beautiful-flower-basket-table_175677-96.jpg'
        }
    } 
    
}
</script>

<style scoped>
    img {
        max-width: 80%;
        max-height: 80%;
    }
</style>