<template>
    
    <div>
      
    <beetle-read-form v-if="Beetle" :Beetle="Beetle"/>
      <p v-else>공사중입니다.</p>
   
    </div>
</template>

<script>
import BeetleReadForm from '../../../components/InsectMuseum/Beetle/BeetleReadForm'
import { mapActions, mapState } from 'vuex'

export default {
    name: 'BeetleReadPage',
    components: {
    BeetleReadForm
    },
    props:{
        boardNo: {
            tpye:String
        }
    },
    computed: {
        ...mapState(['Beetle'])
    },
    methods: {
        ...mapActions(['fetchBeetle'])
    },
    created() {
        this.fetchBeetle(this.boardNo)
    },
}
</script>