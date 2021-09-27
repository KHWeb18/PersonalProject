<template>
    <div>
        <v-container>
        <skycow-read-form  v-if="Skycow" :Skycow="Skycow"/>
        <p v-else> 공사중</p>
        </v-container>
    </div>
</template>
<script>
import SkycowReadForm from '../../../components/InsectMuseum/Skycow/SkycowReadForm'
import { mapActions, mapState } from 'vuex'
export default {
    name: 'SkycowReadPage',
    components:{SkycowReadForm},
    props: {
        boardNo: {
            tpye:String,
            required: true
        }
    },
    computed: {
        ...mapState(['Skycow'])
    },
    methods: {
        ...mapActions(['fethchSkycow'])
    },
    created() {
        this.fethchSkycow(this.boardNo)
    }
}
</script>