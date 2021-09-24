<template>
  <v-container>
  <v-row v-masonry>
    <v-col v-for="(item, index) in items" :key="index" cols="12" sm="4">
      <v-card height="1%" color="teal" class="pt-0 pb-0">
        <v-card-title>{{item.title}}</v-card-title>
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
                { img: 'https://i.pinimg.com/736x/31/de/06/31de063256e52c8fd64471d668f954c7.jpg', title: "LA 다운타운"},
                { img: 'https://i.pinimg.com/736x/ce/d8/70/ced8702170cbfc719f1fad204f6208f0.jpg', title: '선셋비치'},
                { img: 'https://t1.daumcdn.net/thumb/R720x0.fjpg/?fname=http://t1.daumcdn.net/brunch/service/user/2UUt/image/2vT_Z85nLqikJqXWQ3vBOST6pXo', title: '강원도'},
                { img: 'https://a.cdn-hotels.com/gdcs/production13/d298/6722a536-dc90-49b4-9987-4c0ce03105cc.jpg', title: '제주도'},
                { img: 'http://www.sommeliertimes.com/news/photo/201909/14640_30182_1016.jpg', title: '뉴질랜드'},
                { img: 'https://rimage.gnst.jp/livejapan.com/public/article/detail/a/00/01/a0001463/img/basic/a0001463_main.jpg?20210108131218&q=80&rw=750&rh=536', title: '일본'},
                { img: 'https://post-phinf.pstatic.net/MjAxODAzMzFfMjUw/MDAxNTIyNDIzMDIzNDI1.jP_iqKkGs_p3xB0eBY_M6noUC8FSrn6IFYHrAdGl5Y8g.z4Ok1-4GlyAvc8xhx0mzPn7bACqmKiP1w9AvrHcUwMIg.JPEG/Prague-Czech_Republic-Travel-intro.jpg?type=w1200', title: '체코'},
                { img: 'https://youimg1.tripcdn.com/target/1i64p22344ayu8xjl1A6D.jpg?proc=source/trip', title: '뉴욕'},
                { img: 'https://blog.kakaocdn.net/dn/cNCgCL/btqEcH3mo2b/mNS1FON75otmlhjp3GPF41/img.jpg', title: '파리'},
                { img: 'https://admin.itsmorefuninthephilippines.co.kr//uploads/Destination_Images/coron_main2019522_17055.jpg', title: '필리핀'},
                { img: 'https://eb.findmybucketlist.com/city/new/cp/1228525_cp_00.jpg?update_date=2019-07-1212:49:22', title: '미국 시애틀'},
                { img: 'https://lh3.googleusercontent.com/proxy/lH9dYZIdM7pZhJAz2aM0fQQaTX3IRDI1ujpWMsbN9WM4HBREqeQJRSXe71l2nhDVE-Bhmsck-e2Olisg11kZFnL79ngoW5WzhocmOR55w_ZVrIVGMx_pVJ7baEftZ8fVOYXPUPgt', title: '미국 알래스카'},
                { img: 'https://tripjoa.com/wp-content/uploads/2020/01/%EC%9D%B4%EB%AF%B8%EC%A7%80-16-1.jpg', title: '스페인'},
                { img: 'https://wishbeen-seoul.s3.ap-northeast-2.amazonaws.com/post/1455530292580_8265196948_65f4c3d34e_k.jpg', title: '스위스'},
                { img: 'https://ppss.kr/wp-content/uploads/2018/01/008-19.jpg', title: '아프리카'},

            ]
        }
    }
}
</script>