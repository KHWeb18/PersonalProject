<template>
    <div>
        <notice-list-new-form :listArray="PageArray"/>
    </div>
</template>

<script>
import axios from 'axios'
import NoticeListNewForm from '../../components/Notice/NoticeListNewForm.vue'
export default {
    name: 'NoticeListForm',
    components:{
        NoticeListNewForm
    },
    props: {
        notices:{
            type: Array
        }
    },
    data() {
        return{ 
            PageArray: [],

        }
    },
    methods: {
        /*
        handleClick(value){
                
            this.$router.push({name: 'NoticeReadPage' , params: { boardNo: value.boardNo.toString()}})

            axios.post(`http://localhost:9999/jpaNotice/vuecount/${value.boardNo}`)
            .then( () => {
                
            })
        }
        */
    },
    created(){
        axios.get('http://localhost:9999/jpaNotice/noticelist')
        .then( (res)=>{
            this.PageArray = res.data
        })
    }
}
</script>