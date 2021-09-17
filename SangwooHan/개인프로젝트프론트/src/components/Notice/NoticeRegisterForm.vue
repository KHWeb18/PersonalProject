<template>
   <form @submit.prevent="OnSubmit">
            <div>
              
                <v-container style="max-width: 1000px">
                    <h3>공지게시</h3>
           <v-text-field label="id" v-model="id"  readonly type="text" append-icon="mid-account" flat solo>
           </v-text-field>
            <v-radio-group v-model="type1" row>
                    <v-radio label="이벤트" value="이벤트"></v-radio>
                    <v-radio label="공지" value="공지"></v-radio>
                </v-radio-group>   
            <v-text-field label="title" v-model="title" type="text" append-icon="mid-account" flat solo>
           </v-text-field>
           <p>내용</p>
          <textarea name="contentText" id="contentText" cols="30" rows="10" v-model="text"></textarea>
           
                </v-container>
                 
            </div>
                <v-btn type="submit" class="blue">공지하기</v-btn>
         
        </form>
</template>

<script>
export default {
    name: 'NoticeRegisterForm',
    data() {
        return{
            id: this.$store.state.User,
            title: '',
            text: '',
            type1: '',
        }
    },
    methods: {
        OnSubmit() {
            const  {id , title, text,type1 } = this
            this.$emit('submit', {id, title, text, type1 })
        }
    }

}
</script>

<style scoped>
#contentText{width:1000px; height:200px; border: 1px;
border-style:solid;
/*   resize:none; */
/*   resize: horizontal; */
 resize: vertical;
}

</style>