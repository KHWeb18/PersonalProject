<template>
    <v-form ref="form" lazy-validation>
        <v-container class="font">
                <form @submit.prevent="onSubmit">
                    
                        <v-text-field solo  v-model="writer" type="text" label="작성자"  >
                            </v-text-field>


                        <v-select solo v-model="store" label="카페 / 용품매장중 어느 곳을 방문 하셨나요?" 
                        :items="storeList" item-text="store" item-value="value"
                         :rules="store_rule"  >
                        </v-select>


                        <v-select solo v-model="area" label="방문하신 매장이 어디신가요?" 
                        :items="areaList" item-text="area" item-value="value" 
                        :rules="area_rule"  >
                        </v-select>




                    <table>
                        <tr>
                            <td>내용</td>
                            <td><textarea cols="50" rows="20" v-model="content" placeholder="이곳을 클릭해 내용을 입력하세요."></textarea></td>
                        </tr>
                    </table>


                    <star-rating id=setstar :star-size="30" v-model="rating" 
                                v-bind:increment="1"
                                :border-width="5" border-color="#d8d8d8" 
                                :rounded-corners="true" 
                                :star-points="[23,2, 14,17, 0,19, 10,34, 7,50, 23,43, 38,50, 36,34, 46,19, 31,17]">
                                </star-rating>
                

            
                    <button type="submit">등록</button>
                    <router-link :to="{ name: 'BoardListPage' }">
                        취소
                    </router-link>
                </form>
        </v-container>
    </v-form>
</template>

<script>

import StarRating from 'vue-star-rating'

export default {
    name: 'BoardRegisterForm',
    components: {
        StarRating
    },
    data () {
        return {
            rating: 0,
            writer: this.$store.state.writer,
            content: '',
            store: '',
            storeList: [
                '카페', '용품매장'
            ],
            store_rule: [
                v => !!v || '카페/용품매장 중 선택해 주세요.' 
            ],
            area: '',
            areaList: [
                '페어퍼넛츠', '달냥', '두더지손가게', '브릿지엣지', '보틀팩토리', 
                '쿠아레비 구산점', '사직동그가게', '앞으로의 빵집', '카페기웃기웃', 
                '아토모스', '어스얼스 서촌점', '오즈타운', '지구살림터', '지구샵 상도점',
                '플라프리', '아로마티카 제로스테이션', '플래닛키퍼스제로웨이스트스토어',
                '아름다운가게 송파가락점', '송포어스', '대안생활공기', '제로웨이스트샵 안녕상점',
                '지구랑가게', '보탬상점', '순환지구', '알맹상점 리스테이션', '디어에코', '덕분애',
                '비그린', '1.5도씨', '허그어웨일', '알맹상점', '유민얼랏', '리틀베러', '레디투웰니스',
                '라마홈', '더피커', '꽃피는삼월에'
            ],
            area_rule: [
                v => !!v || '어느매장을 다녀오셨나요?' 
            ],
        }
    },
    methods: {
        onSubmit () {
            const { writer, content, area, store, rating } = this
            this.$emit('submit', { writer, content, area, store, rating })
        },
    },
    

}
</script>


<style scoped>

</style>
