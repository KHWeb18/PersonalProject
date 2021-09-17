<template>
    <div>

        <dragonfly-read-form v-if="Dragonfly" :Dragonfly="Dragonfly" />

        <p v-else>공사중입니다.</p>
   
    </div>
</template>

<script>
import DragonflyReadForm from '../../../components/InsectMuseum/Dragonfly/DragonflyReadForm'
import { mapActions ,mapState} from 'vuex'
export default {
    name: 'DragonflyReadPage',
    components: {
        DragonflyReadForm
    },
    props: {
        boardNo: {
            type: Number,
            required: true
        }
    },
    computed: {
        ...mapState(['Dragonfly'])
    },
    methods:{
        ...mapActions(['fetchDragonfly'])
    },
    created(){
        this.fetchDragonfly(this.boardNo)
    }
}
</script>