<template>
    <div>
        <v-container>
                    <v-row>
                        <v-col cols="12" xs="12" align="center">
                            <img class="mb-3" src="@/assets/img/together.jpeg">
                        </v-col>
                        <v-col cols="12" xs="12" align="center">
                            <h3 class="mb-3">{{ contents }}</h3>
                        <p> {{ body }}</p>
                        </v-col>
                    </v-row>
        </v-container><br><br><br>
        <v-container>
            <div align="center"> 
            <h1>핵심 가치</h1>
            <p>_________</p>
            </div><br>
                <v-col cols="12" xs="12" align="center">
                    <v-card
                        class="d-flex flex-nowrap py-3"
                        flat="flat"
                        tile="tile"
                        width="900">
                    <v-card class="order-3 pa-6" outlined="outlined" tile="tile">
                        <img src="http://www.adddata.co.kr/default/img/company/img0105.png">
                    <div class="co-title">
                        <h3>PARTNER</h3>
                        <h5>LoM은 언제나 여러분의 파트너 입니다.</h5>
                    </div>
            </v-card>
            <v-card class="order-3 pa-6" outlined="outlined" tile="tile">
                <img src="http://www.adddata.co.kr/default/img/company/img0106.png">
                    <div class="co-title">
                        <h3>PASSION</h3>
                        <h5>LoM은 끊없는 열정으로 사이트를 운용하겠습니다.</h5>
                    </div>
                </v-card>
                <v-card class="order-3 pa-6" outlined="outlined" tile="tile">

                    <img src="http://www.adddata.co.kr/default/img/company/img0104.png">
                        <div class="co-title">
                            <h3>GUIDE</h3>
                            <h5>LoM은 모든순간의 진실한 가이드가 되겠습니다.</h5>
                        </div>
                    </v-card>
                </v-card>
                </v-col>
        </v-container>
    </div>
</template>

<script>
export default {
    data () {
        return {
            contents: '당신의 행복한 순간들을 Life of Moment에 남기세요!',
            body: '인생의 누구나 아름다운 순간들은 있습니다. 사실 인생의 모든 순간들은 아름답습니다. 혹 그 순간들을 사진으로 남기셨나요? LoM은 당신의 소중한 시간들을 가치 있게 여깁니다. 누구나 가지고 있는 소중한 추억들, 시간들, 순간들을 사진으로 남기셨다면 그러한 멋진 순간들을 이웃들 또 친구들과 나누고 공유하세요. 저희 Life of Moment 사이트에서 도와 드리겠습니다.'
        }
    }
}
</script>