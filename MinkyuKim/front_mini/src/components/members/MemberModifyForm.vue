<template>
    <div>
        <!--<h3>Product Modify Form</h3>-->
        <!--prevent를 넣은 이유는 실행순서를 보장해주기 때문에
            여기서 submit을하면 바로 처리를 하러 가는데 prevent가 걸려있으면, submit을 했을 때
            onSubmit으로 걸려서 views/productModifyPage.vue로 넘어가 submit이 작동하게 됨.
            즉, 여기(하위컴포넌트)에서 submit 하는것을 막고 상위컴포넌트에서 실행되게 한다. -->
        <form @submit.prevent="onSubmit">            
            <table>
                <tr>
                <th>*이름</th>
                <td>
                    <input v-model="name" type="text" maxlength="20">
                    
                </td>
            </tr>            
            <tr>
                <th>*생년월일</th>
                <td>
                    <input type="text" v-model="dateOfBirth">
                </td>
                    
            </tr>
            <tr>
                <th>*전화번호</th>
                <td>
                    <input type="number" v-model="phoneNumber">
                    
                </td>
            </tr>
            <tr>
                <th>*이메일</th>
                <td>
                    <input type="email" v-model="email">
                    
                </td>
            </tr>
            
            <tr>
                <th>*주소</th>
                <td>
                    <input type="text" v-model="address">
                    
                </td>
            </tr>
            <table>
                <tr>
                    <th>*성별</th>                    
                    <td>
                    <v-radio-group v-model="genderRadioGroup" row>
                        <v-radio v-for="kinds in kindsOfGender" :key="kinds" :label="`${kinds}`"> 
                        </v-radio>
                    </v-radio-group>
                    </td>
                </tr>
            </table>
            <div class="row">
                <th>관심사</th>  
                <v-checkbox v-model="drawing" label="그림"></v-checkbox>
                <v-checkbox v-model="article" label="소품"></v-checkbox>                   
                <v-checkbox v-model="largeArtwork" label="대형 작품"></v-checkbox>
            </div>
            </table>            

            <div>
                <!--<button type="submit">수정 완료</button>-->
                <v-btn type="submit">수정 완료</v-btn>                
                <router-link :to="{ name: 'Home' }">
                    취소
                </router-link>
            </div>
        </form>
    </div>
</template>

<script>

//import {mapState} from 'vuex'

export default {
    name: 'MemkberModifyForm',
    props: {
        member: {
            type: Object,
            //required: true
        },
        
    },
    data () {
        return {
            radioGroup: 1,
            kindsOfMember: [
                '구매회원',
                '판매회원'
            ],
            userId: '',            
            name: '' ,          
            genderRadioGroup: 0,
            kindsOfGender: [
                '남성',
                '여성'
            ],
            dateOfBirth: '',
            phoneNumber: '',
            email: '',
            address: '',            
            drawing: '',            
            article : '',
            largeArtwork: ''
            
        }
    },    
    methods: {
        onSubmit () {
            const { name, dateOfBirth, phoneNumber, email, address, genderRadioGroup, drawing, article, largeArtwork, radioGroup } = this
            this.$emit('submit', { name, dateOfBirth, phoneNumber, email, address, genderRadioGroup, drawing, article, largeArtwork, radioGroup })
        },
    },
    created () {
        this.name = this.member.name        
        this.dateOfBirth = this.member.dateOfBirth
        this.phoneNumber = this.member.phoneNumber
        this.email = this.member.email
        this.address = this.member.address
        this.genderRadioGroup = this.member.genderRadioGroup        
        this.drawing = this.member.drawing
        this.article = this.member.article
        this.largeArtwork = this.member.largeArtwork
        this.radioGroup = this.member.radioGroup
    }
}
</script>