<template>
  <v-container>
  <v-row v-masonry>
    <v-col v-for="(item, index) in items" :key="index" cols="12" sm="4">
      <v-card height="1%" color="teal" class="pt-0 pb-0">
        <v-img :src="item.img" @load="this.$redrawVueMasonry()"></v-img>
        <v-card-text>{{item.text}}</v-card-text>
      </v-card>
    </v-col>
  </v-row>
</v-container>

</template>

<script>


export default {
    name: 'NaturePhotoPage',
    data () {
        return {
            items: [
                { img: 'https://blog.kakaocdn.net/dn/tgGvz/btqM0saDbGy/kGhcdkOSYci48U0xXlgF80/img.png', text: "할랄"},
                { img: 'https://cdn.ibos.kr/og-BD6140-49299-gif?v=0', text: "마카롱"},
                { img: 'https://img.siksinhot.com/article/1594621702582120.jpeg', text: "치즈케이크"},
                { img: 'https://blog.kakaocdn.net/dn/kNJ7E/btqUWtHWdiy/cYuqhH1Kkr0lembO9KqGvk/img.jpg', text: "피자"},
                { img: 'https://pds.joongang.co.kr/news/component/htmlphoto_mmdata/201903/08/52cf07ea-c8da-4574-b0e9-21e0e3b31118.jpg', text: "치킨"},
                { img: 'https://danoshop.net/mall/upload/2020/01/31/pho_716x478.jpg', text: "베트남 쌀국수"},
                { img: 'https://mp-seoul-image-production-s3.mangoplate.com/1158109_1560665666403118.jpg?fit=around|738:738&crop=738:738;*,*&output-format=jpg&output-quality=80', text: "크림 스파게티"},
                { img: 'http://image.auction.co.kr/itemimage/1d/2f/21/1d2f2107c6.jpg', text: "뉴욕 핫도그"},
                { img: 'https://t1.daumcdn.net/cfile/tistory/9942B3395A3501C304', text: "한국 삼겹살"},
                { img: 'http://www.mindgil.com/news/photo/202101/70530_6285_1006.jpg', text: "짜장면"},
                { img: 'https://lh3.googleusercontent.com/proxy/ASXpLvsmM4fVik8-RCEZ2s7gUQ7vB83OZ0QmzeFzj1HKl2GzYx80m5nK8HYeL1SAnWCNSx8oOYmu3oEdX65wvnDd6FM3nYhpH4a4Zn7WzAq88F_rsdbq_Lk6kBRaonreLbwmVPK4RUc', text: "마라탕"},
                { img: 'https://cdn.eyesmag.com/content/uploads/posts/2020/09/28/fast-food-franchises-serve-hamburger-without-tomatoes-main-830fce32-c71e-4faa-ba77-1efb08e7ee7b.jpg', text: "햄버거"},
                { img: 'https://mblogthumb-phinf.pstatic.net/20120530_29/ii222_1338367061153xVMNj_JPEG/DSC_4527.jpg?type=w2', text: "떡튀순"},


            ]
        }
    }
}
</script>