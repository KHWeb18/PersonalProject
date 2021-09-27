<template>
  <main class="mt-3">
    <div class="container">
      <div class="float-end mb-1">
        <button type="button" class="btn btn-dark" @click="goToInsert">제품등록</button>
      </div>
      <table class="table table-bordered">
        <thead>
          <tr>
            <th></th>
            <th>제품명</th>
            <th>제품가격</th>
            <th>배송비</th>
            <th>추가 배송비</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          <tr :key="i" v-for="(funding, i) in fundingList">
            <td>
              <img v-if="funding.path!=null" :src="`/download/${funding.id}/${funding.path}`" style="height:50px;width:auto;" />
            </td>
            <td>{{funding.funding_name}}</td>
            <td>{{funding.funding_price}}</td>
            <td>{{funding.delivery_price}}</td>
            <td>{{funding.add_delivery_price}}</td>
            <td>
              <button type="button" class="btn btn-info me-1" @click="goToImageInsert(funding.id);">사진등록</button>
              <button type="button" class="btn btn-warning me-1" @click="goToUpdate(funding.id);">수정</button>
              <button type="button" class="btn btn-danger" @click="deleteFunding(funding.id);">삭제</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </main>
</template>

<script>
export default {
  data() {
    return {
      fundingList: []
    };
  },
  created() {
    this.getFundingList();
  },
  methods: {
    async getFundingList() {
      this.fundingList = await this.$api("/api/fundingList2",{});
      console.log(this.fundingList);
    },
    goToInsert() {
      this.$router.push({path:'/create'});
    },
    goToDetail(funding_id) {
     this.$router.push({path:'/detail', query:{funding_id:funding_id}}); 
    },
    goToUpdate(funding_id) {
      this.$router.push({path:'/update', query:{funding_id:funding_id}}); 
    },
    goToImageInsert(funding_id) {
      this.$router.push({path:'/image_insert', query:{funding_id:funding_id}}); 
    },
    deleteFunding(funding_id) {
      this.$swal.fire({
        title: '정말 삭제하시겠습니까?',
        showCancelButton: true,
        confirmButtonText: `삭제`,
        cancelButtonText: `취소`
      }).then(async (result) => {
        if (result.isConfirmed) {
          console.log(funding_id)
          await this.$api("/api/fundingDelete",{param:[funding_id]});
          this.getFundingList();
          this.$swal.fire('삭제되었습니다!', '', 'success')
        } 
      });
    }
  }
}
</script>