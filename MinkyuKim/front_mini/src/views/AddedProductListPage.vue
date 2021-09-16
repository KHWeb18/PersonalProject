<template>
  <main class="mt-3">
    <div class="container">      
      <table class="table table-bordered">
        <thead>
          <tr>
            <th></th>
            <th>제품명</th>
            <th>제품가격</th>
            
            
            <th></th>
          </tr>
        </thead>
        <tbody>            
            <!--<img v-if="product.path!=null" :src="`/download/${product.id}/${product.path}`" style="height:50px;width:auto;" />-->
            <td><img :src="require(`@/assets/imgproduct/1 (8).jpg`)" style="height:50px;width:auto;"></td>
            
            <td>Urban</td>
            <td>7000000</td>
            
            <!--
            td>{{product.product_name}}</td>
            <td>{{product.price}}</td>
            <td>
              <button type="button" class="btn btn-info me-1" @click="goToImageInsert(product.id);">사진등록</button>
              <button type="button" class="btn btn-warning me-1" @click="goToUpdate(product.id);">수정</button>
              <button type="button" class="btn btn-danger" @click="deleteProduct(product.id);">삭제</button>
            </td>
            -->
        </tbody>
      </table>
    </div>
  </main>
</template>

<script>

export default {
    name: 'AddedProductListPage',

}