<template>
    <form @submit.prevent="onSubmit">
        <div>
            <v-stepper v-model="e6" vertical="vertical">
                <v-stepper-step :complete="e6 > 1" step="1">
                    사료정보
                    <small>제품명 및 영양성분 입력</small>
                </v-stepper-step>
                <v-stepper-content step="1">
                    <form @submit.prevent="onSubmit">
                        <div class="int3">
                            <input type="text" class="int2" v-model="name" 
                                placeholder="사료이름" >
                        </div>
                        <div class="register_box_content">
                            <fieldset class="box1">
                                <input type="number" class="int" v-model="protein" 
                                placeholder="조단백(% 이상)" maxlength="3" @input="searchChangeFunc($event)">
                                <input type="number" class="int" v-model="fat" 
                                placeholder="조지방(% 이상)" maxlength="3" @input="searchChangeFunc($event)">   
                                <input type="number" class="int" v-model="mineral" 
                                placeholder="조회분(% 이상)" maxlength="3" @input="searchChangeFunc($event)">
                                <input type="number" class="int" v-model="fiber" 
                                placeholder="조섬유(% 이상)" maxlength="3" @input="searchChangeFunc($event)">
                            </fieldset>
                            <fieldset class="box1">
                                <input type="number" class="int" v-model="moisture" 
                                placeholder="수분(% 이상)" maxlength="3" @input="searchChangeFunc($event)">
                                <input type="number" class="int" v-model="calcium" 
                                placeholder="칼슘(% 이상)" maxlength="3" @input="searchChangeFunc($event)">   
                                <input type="number" class="int" v-model="phosphorus" 
                                placeholder="인(% 이상)" maxlength="3" @input="searchChangeFunc($event)">
                                <input type="number" class="int" v-model="kcal" 
                                placeholder="대사에너지(kcal/kg)" maxlength="4" @input="searchChangeFunc($event)">
                            </fieldset>
                            <fieldset class="box2">
                                <textarea style="height:140px;width:180px;" cols="80" rows="20" maxlength="155" v-model="introduce" placeholder="간단한 사료 설명(160자 이내)"></textarea>
                            </fieldset>
                        </div>
                        <v-item-group>
                            <v-chip-group sole="solo" active-class="orange accent-4 white--text"  v-model = "tagLocation">
                                <v-chip :input-value="active" @click="toggle(0)">ORGANIC</v-chip>
                                <v-chip :input-value="active" @click="toggle(1)">HOLISTIC</v-chip>
                                <v-chip :input-value="active" @click="toggle(2)">SUPER PREMIUM</v-chip>
                                <v-chip :input-value="active" @click="toggle(3)">PREMIUM</v-chip>
                                <v-chip :input-value="active" @click="toggle(4)">GROCERY</v-chip>
                            </v-chip-group>
                        </v-item-group>
                        <v-item-group>
                            <v-chip-group sole="solo" active-class="blue-grey darken-2 white--text"  v-model = "tagLocation">
                                <v-chip :input-value="active" @click="toggle3(0)">KITTEN</v-chip>
                                <v-chip :input-value="active" @click="toggle3(1)">ADULT</v-chip>
                                <v-chip :input-value="active" @click="toggle3(2)">SENIOR</v-chip>
                            </v-chip-group>
                        </v-item-group>
                        <v-item-group style="display:flex">
                            <v-chip-group sole="solo" active-class="lime accent-4 white--text" v-model = "tagLocation">
                                <!-- shit, coat, hairball, taste -->
                                <v-chip :input-value="active" @click="toggle2()">GLUTEN FREE</v-chip>
                            </v-chip-group>
                            <v-chip-group sole="solo" active-class="pink accent-2 white--text" v-model = "tagLocation" >
                                <v-chip :input-value="active" @click="toggle4()">DIARRHEA</v-chip>
                            </v-chip-group>
                            <v-chip-group sole="solo" active-class="purple accent-3 white--text" v-model = "tagLocation" >
                                <v-chip :input-value="active" @click="toggle5()">HAIRBALL</v-chip>
                            </v-chip-group>
                            <v-chip-group sole="solo" active-class="teal darken-3 white--text" v-model = "tagLocation" >
                                <v-chip :input-value="active" @click="toggle6()">COAT</v-chip>
                            </v-chip-group>
                            <v-chip-group sole="solo" active-class="lime darken-3 white--text" v-model = "tagLocation" >
                                <v-chip :input-value="active" @click="toggle7()">PALATABILITY</v-chip>
                            </v-chip-group>
                        </v-item-group>
                    </form>
                    <v-btn color="light-blue lighten-1 text center" @click="e6 = 2" class="change_font">다음</v-btn>
                </v-stepper-content>
                <v-stepper-step step="2">대표 이미지</v-stepper-step>
                <v-stepper-content step="2">
                    <div style="margin-bottom: 10px">                        
                        <div class="image-box">
                        <label>이미지 추가 
                            <input type="file" class="files" id="files" ref="files" multiple v-on:change="handleFileUpload()" 
                            style="pointer:cursor">
                        </label>
                        <button @click="fileDeleteButton()" class="image_btn">이미지 삭제</button>
                        </div>
                        <div class="preview_image">
                            <img :src="preview">
                        </div>
                    </div>
                    <v-btn color="light-blue lighten-1 text center" @click="fusion()" class="change_font">완료</v-btn>
                   <v-btn color="blue-grey darken-1" @click="e6 = 1" class="change_font">이전</v-btn>
                </v-stepper-content>
            </v-stepper>
        </div>
    </form>
</template>

<script>
import axios from 'axios'
export default {
    name: 'FoodRegisterForm',
    data () {
        return {
            e6: 1,
            files: '',
            preview: '',
            gradeList: ['ORGANIC', 'HOLISTIC', 'SUPERPREMIUM', 'PREMIUM', 'GROCERY'],
            grade: [0, 0, 0, 0, 0],
            gradeSelect: '',
            ageList: ['KITTEN', 'ADULT', 'SENIOR'],
            age: [0, 0, 0],
            ageSelect: '',
            glutenFree: 'none',
            name: '',
            protein: '',
            fat: '',
            mineral: '',
            fiber: '',
            moisture: '',
            calcium: '',
            phosphorus: '',
            kcal: '',
            introduce: '',

            diarhea: 'none',
            hairball: 'none',
            coat: 'none',
            palatability: 'none'
        }
    },
    methods: {
        handleFileUpload () {
                this.files = this.$refs.files.files
                this.preview = URL.createObjectURL(this.files[0])
                console.log(this.preview)
        },
        submitFiles () {
            let formData = new FormData()
            for (var idx = 0; idx < this.files.length; idx++) {
                formData.append('fileList', this.files[idx])
            }
            let no = this.$store.state.foodNo
            formData.append('no', no)

            axios.post('http://localhost:7777/admin/uploadImg_Food', formData, {
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            })
            .then (res => {
                this.response = res.data
                this.$router.push({
                            name: 'FoodRegisterPage'
                        })
            })
            .catch (res => {
                this.response = res.message
            }) 
            alert('Processing Complete!')
        },
        fileDeleteButton () {
            this.files = '',
            this.preview = ''
        },
        onSubmit () {
            const { name, gradeSelect, glutenFree, ageSelect, protein, fat, mineral, 
            fiber, moisture, calcium, phosphorus, kcal, introduce,
            diarhea, hairball, coat, palatability } = this

            axios.post('http://localhost:7777/operator/foodRegister', { name, gradeSelect, glutenFree, ageSelect, protein, fat, mineral, 
            fiber, moisture, calcium, phosphorus, kcal, introduce, diarhea, hairball, coat, palatability })
                    .then(res => {
                        alert('사료 정보 등록 완료 - ' + res)
                        this.$store.state.foodNo = res.data.foodNo.toString()
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        },
        toggle (n) {
         if (this.grade[n] == 0) { 
                this.grade = [0, 0 ,0, 0, 0]
                this.grade[n] = 1;
                this.gradeSelect = this.gradeList[n]
                console.log(this.grade)
                console.log(this.gradeSelect)
            } else if (this.grade[n] == 1) {
                this.grade = [0, 0 ,0, 0, 0]                
                this.gradeSelect = ''
                console.log(this.grade)
                console.log(this.gradeSelect)
            }
        },
        toggle3 (n) {
         if (this.age[n] == 0) { 
                this.age = [0, 0 ,0]
                this.age[n] = 1;
                this.ageSelect = this.ageList[n]
                console.log(this.age)
                console.log(this.ageSelect)
            } else if (this.age[n] == 1) {
                this.age = [0, 0 ,0, 0, 0]                
                this.ageSelect = ''
                console.log(this.age)
                console.log(this.ageSelect)
            }
        },
        toggle2 () {
            if (this.glutenFree == 'none') {
                this.glutenFree = 'TRUE'
            } else {
            this.glutenFree = 'none'
            }
            console.log(this.glutenFree)
        },
        toggle4 () {
            if (this.diarhea == 'none') {
                this.diarhea = 'TRUE'
            } else {
            this.diarhea = 'none'
            }
            console.log(this.glutenFree)
        },
        toggle5 () {
            if (this.hairball == 'none') {
                this.hairball = 'TRUE'
            } else {
            this.hairball = 'none'
            }
            console.log(this.hairball)
        },
        toggle6 () {
            if (this.coat == 'none') {
                this.coat = 'TRUE'
            } else {
            this.coat = 'none'
            }
            console.log(this.coat)
        },
        toggle7 () {
            if (this.palatability == 'none') {
                this.palatability = 'TRUE'
            } else {
            this.palatability = 'none'
            }
            console.log(this.palatability)
        },
        fusion () {
            setTimeout(() => {
                this.submitFiles()
                }, 100)
            this.onSubmit()

        }
    }
}
</script> 

<style scoped>
.image_btn {
    font-size: 11px;
    color: #fff;
    background-color: #546e7a;
    width: 118.719px;
    vertical-align: middle;
    cursor: pointer;
    border-radius: 5px;
    width: 90px;
    font-size: 12px;
    text-align: center;
    padding: 10px;
    height: 38px;
    margin-left: 5px;
}
.v-btn:not(.v-btn--round).v-size--default {
    height: 20px;
}
.change_font {
    font: 12pt;
    color: white;
    font-weight: 800;
    height: 36px !important;
}
.button_box {    
    margin-top: 10px; 
    display: flex;
    justify-content: flex-end;
}
.v-btn {
    margin-right: 10px;
}
.files {
    cursor: pointer;
    
}
.image-box {
    padding-bottom: 20px;
}
.image-box input[type='file'] {
    position: absolute;
    width: 0;
    height: 0;
    padding: 0;
    overflow: hidden;
    border: 0;
}
.image-box label {
    display: inline-block;
    padding: 10px 10px;
    background-color: #232d4a;
    color: #fff;
    vertical-align: middle;
    cursor: pointer;
    border-radius: 5px;
    width: 90px;
    font-size: 12px;
    text-align: center;
}
.register_box_content {
    display: flex;
    flex-wrap: wrap-reverse;
}
.int {
    display: block;
    position: relative;    
    letter-spacing: 2px;
    height: 2rem !important;   
    font-size: 9px;
}
.int2 {
    display: block;
    position: relative;    
    letter-spacing: 2px;
    height: 2rem !important;   
}
.int3 {
    padding: 0px 10.5px ;
    padding-right: 317px;
}
.box1 {
    border: 0px;
}
.box2 {
    margin-top: 15px;
    padding: 0px;
    border: 0px
}
::placeholder {
    font-size: 13px;
    letter-spacing: 0;
    font-weight: 700;
    color:rgba(77, 77, 90, 0.747);
    /* font-style: 'a바람새L'; */
}
</style>