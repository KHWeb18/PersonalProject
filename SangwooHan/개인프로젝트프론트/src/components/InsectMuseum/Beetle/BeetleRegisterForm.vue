<template>
<form @submit.prevent="OnSubmit">
            <div>
              
                <v-container>
                    <h3>풍뎅이 작성란</h3>
           <v-text-field label="작성자" v-model="id" readonlytype="text" append-icon="mid-account" flat solo>
           </v-text-field>
            <v-text-field label="title" v-model="title" type="text" append-icon="mid-account" flat solo>
           </v-text-field>
           <p>내용</p>
          <v-textarea height="100px" auto-grow outlined v-model="text">
            </v-textarea>
           
                </v-container>
                 
            </div>
                <v-btn type="submit" class="blue">작성하기</v-btn>
         
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
            
        }
    },
    methods: {
        OnSubmit() {
            const  {id , title, text } = this
            this.$emit('submit', {id, title, text })
        }
    }

}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap');
#contentText{width:1000px; height:200px; border: 1px;
border-style:solid;
/*   resize:none; */
/*   resize: horizontal; */
 resize: vertical;
}
p{
    font-family: 'Do Hyeon', sans-serif;
    font-size: 2.5em;
}
h3{
     font-family: 'Do Hyeon', sans-serif;
}
</style>