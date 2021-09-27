<template>
    <v-form ref="form" lazy-validation>
        <v-container class="font">
            <v-row>
                <form @submit.prevent="onSubmit">
                            <h1>회원가입</h1>&nbsp;&nbsp;



                            <v-col cols="12">
                                <v-text-field solo  v-model="userId" type="text" label="아이디" :rules="id_rule" required>
                                    </v-text-field>
                            </v-col>
                            <v-col cols="12">
                                <v-text-field solo v-model="password" type="password" label="비밀번호" :rules="pw_rule" required>
                                </v-text-field>
                            </v-col>
                            <v-col cols="12">
                                <v-text-field solo v-model="pw_chk" type="password" label="비밀번호 확인" :rules="pw_rule2" required>
                                </v-text-field>
                            </v-col>
                            <v-col cols="12">
                                <v-text-field solo v-model="email"  label="이메일" type="email" :rules="email_rule" required>
                                </v-text-field>
                            </v-col>
                            <v-col cols="12">
                                <v-select solo v-model="area" label="지역" :items="areaList" item-text="area" item-value="value" :rules="area_rule" required>
                                </v-select>
                            </v-col>
                                <div>
                                <v-btn x-large text type="submit" font-size="x-large">회원가입</v-btn>
                               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <v-btn x-large text>
                                    <a class href="/">
                                        취소
                                    </a>
                                </v-btn>
                            </div>
                               &nbsp;&nbsp; 
                   </form>
            </v-row>
        </v-container>
    </v-form>
</template>
<script>
export default {
    name: 'MemberRegisterForm',
    data () {
        return {

            userId: '',
            id_rule: [
                v => !!v || '아이디를 작성해주세요.',
                v => /^[a-zA-Z0-9]*$/.test(v) || '아이디는 영문 및 숫자만 입력 가능합니다.',
                v => !(v && v.length >= 15) || '아이디는 15자 이상 입력할 수 없습니다.'
            ],
            password: '',
            pw_rule: [
                v => !!v || '패스워드를 작성해주세요.',
                v => (v && v.length >= 8 && v.length <= 20) || '비밀번호는 8자이상 20자 이하로 작성해주세요.',
            ],
            pw_chk: '',
            pw_rule2: [
                v => !!v || '패스워드를 작성해주세요.' ,
                v => (v && v.length >= 8 && v.length <= 20) || '비밀번호는 8자이상 20자 이하로 작성해주세요.',
                v => v === this.password || '비밀번호가 일치하지 않습니다.'
            ],
            email: '',
            email_rule: [
                v => !!v || '이메일을 작성해주세요.'
            ],
            area: '',
            areaList: [
                '강남구','강동구','강북구', '강서구', '관악구', '광진구', '구로구'
                , '금천구', '노원구', '도봉구', '동대문구', '동작구', '마포구', '서대문구'
                , '서초구', '성동구', '성북구', '송파구', '양천구', '영등포구', '용산구'
                , '은평구', '종로구', '중구', '중랑구'
            ],
            area_rule: [
                v => !!v || '지역을 선택해 주세요.' 
            ]
        }
    },
    methods: {
         onSubmit () {
            const { userId, password, email, area  } = this
            this.$emit('submit', { userId, password, email, area })
        }
    },
}
</script>

<style scoped>
.font {
    text-align: center;
    font-size: x-large;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    height: max-content;
    width: content;
    background-color: white;
    opacity: 0.8;
}
h1 {
    text-align: center;
}
input::-ms-input-placeholder { color: rgb(7, 7, 7); }
input::-webkit-input-placeholder { color: rgb(12, 12, 12); }
input::-moz-placeholder { color: rgb(12, 12, 12); }
.singup{
    text-align: right;
    font-size: medium;
}
.v-btn{
    font-size: 0.8em;
    font-weight: bolder;
}
.v-text-field{
    font-size: 0.8em;
    width: content;
}

</style>