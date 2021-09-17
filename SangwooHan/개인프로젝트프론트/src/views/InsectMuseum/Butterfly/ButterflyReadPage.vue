<template>
    <div>
     
        <butterfly-read-form v-if="Butterfly" :Butterfly="Butterfly"/>
    
   
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import ButterflyReadForm from '../../../components/InsectMuseum/Butterfly/ButterflyReadForm'
export default {
    name: 'ButterflyReadPage',
    components: {
        ButterflyReadForm   
    },
    props:{
        boardNo: {
            type: Number,
            required: true
        }
    },
    computed: {
        ...mapState(['Butterfly'])
    },
    methods: {
        ...mapActions(['fetchButterfly']),
     
    },
    created(){
        this.fetchButterfly(this.boardNo)
    }
}
</script>