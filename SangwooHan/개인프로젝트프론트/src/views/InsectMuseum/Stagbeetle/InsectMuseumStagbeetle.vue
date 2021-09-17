<template>
    <div>
        <v-container>
        <insect-museum-bar/>
        <stagbeetle-list-form  v-if="StagbeetleList" :StagbeetleList="StagbeetleList"/>
        <p v-else> 공사중입니다 </p>
        </v-container>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import StagbeetleListForm from '../../../components/InsectMuseum/Stagbeelte/StagbeetleListForm.vue'
import InsectMuseumBar from '../../NavigationVar/InsectMuseumBar.vue'


export default {
  components: {StagbeetleListForm, InsectMuseumBar  },
        name: 'InsectMuseumStagbeetle',    

        computed: {
            ...mapState(['StagbeetleList'])
        },
        methods: {
            ...mapActions(['fetchStagbeetleList'])
        },
        mounted(){
           this.fetchStagbeetleList()
        }

}
</script>