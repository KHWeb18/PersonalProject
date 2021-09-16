<template>
    <div align="center">
        <v-sheet color="white" width="900">
            <funding-read-form v-if="funding" :funding="funding"/>
            <p v-else>로딩중 ...... </p>
            <v-btn color="primary" v-if="isLogin" :to="{ name: 'FundingModifyPage', params: { fundingNo } }">
                프로젝트 수정
            </v-btn>
            <v-btn color="primary" v-else @click="fundingModifyFail">
                프로젝트 수정
            </v-btn>

            <v-dialog v-model="dialog" v-if="isLogin" scrollable persistent max-width="400" >
                <template v-slot:activator="{ on }">
                    <v-btn color="primary" dark v-on="on">펀딩하기</v-btn>
                </template>
                <v-card><!-- v-dialog에 종속되어 있다 (v-dialog가 불러지면 따라나옴) -->
                    <v-card-title class="headline">
                        후원할 금액을 입력하세요!
                    </v-card-title>

                    <v-spacer></v-spacer>
                    <td><input type="number" v-model="yourMoney" flat solo></td>
                    <!--<td>{{ yourMoney }}</td>-->
                    <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="blue darken-1" text  @click="dialog = false">
                        취소
                    </v-btn>
                    <v-btn color="blue darken-1" text @click="onPay" >
                        확인
                    </v-btn>

                    </v-card-actions>
                </v-card>
            </v-dialog>
                <v-btn color="primary" v-else @click="fundingPayFail">펀딩하기</v-btn>
            <v-btn color="primary" :to="{ name: 'FundingListPage' }">
                프로젝트 목록
            </v-btn>
        </v-sheet>
    </div>
</template>


<script>

import FundingReadForm from '@/components/funding/FundingReadForm.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
    name: 'FundingReadPage',
    props: {
        fundingNo: {
            type: String,
            required: true
        }
    },
    data () {
        return {
            dialog: false,
            isLogin: false,
            yourMoney: '',
        }
    },
    components: {
        FundingReadForm
    },
    computed: {
        ...mapState(['funding']),

    },
    methods: {
        ...mapActions(['fetchFunding']),
        fundingModifyFail() {
            this.isLogin = false
            alert('창작자만 수정가능합니다')
            this.$router.push("login")
        },
        fundingPayFail() {
            this.isLogin = false
            alert('로그인이 필요합니다')
            this.$router.push("login")
        },
        onPay (payload) {
            const { nowMoney } = payload
            axios.put(`http://localhost:7777/funding/plusMoney/${this.fundingNo}`, { nowMoney })
            .then(res =>{
                alert('펀딩 성공')
            this.$router.push({
                name: 'FundingListPage',
                params: { fundingNo: res.data.fundingNo.toString() }
                })
            })
            .catch(err => {
                alert(err.response.data.message)
            })
        },
        /*
        saveMoney() {

            for(;;) {
                this.funding.nowMoney = this.yourMoney + this.funding.nowMoney
            }

        },
        calcMoney() { 

            for(;;) {
                this.calcMoney = this.yourMoney + this.funding.nowMoney
            }
        }
        */
    },
    created () {
        this.fetchFunding(this.fundingNo)
        .catch(err => {
            alert(err.response.data.message)
            this.$router.push()
        })
    },
    mounted() {
        console.log(JSON.stringify(this.funding))
        this.$store.state.session = this.$cookies.get("user")
        if (this.$store.state.session != null) {
            this.isLogin = true
        }
    },
}
</script>