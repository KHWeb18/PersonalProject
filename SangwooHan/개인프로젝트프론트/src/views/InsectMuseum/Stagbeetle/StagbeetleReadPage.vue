<template>
    <div>
    
      <stagbeetle-read-form v-if="Stagbeetle" :Stagbeetle="Stagbeetle"/>
     
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import StagbeetleReadForm from '../../../components/InsectMuseum/Stagbeelte/StagbeetleReadForm.vue'


export default {
  components: {StagbeetleReadForm },
    name: 'StagbeetleReadPage',
    props: {
        boardNo: {
            type: Number,
            required: true
        }
    },
    computed: {
        ...mapState(['Stagbeetle'])
    },
    methods: {
        ...mapActions(['fetchStagbeetle'])
    },
    created() {
        this.fetchStagbeetle(this.boardNo)
    }
}
</script>