<template>
    <div>
        <v-container>
        <insect-museum-bar/>
        <beetle-list-form :BeetleList="BeetleList"/>
        </v-container>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import BeetleListForm from '../../../components/InsectMuseum/Beetle/BeetleListForm.vue'
import InsectMuseumBar from '../../NavigationVar/InsectMuseumBar.vue'
export default {
    name: 'InsectMuseumBeetle',
  components: { BeetleListForm, InsectMuseumBar },
    computed:{
        ...mapState(['BeetleList'])
    },
    methods:{
        ...mapActions(['fetchBeetleList'])
    },
    mounted() {
        this.fetchBeetleList()
    },
}
</script>