<template>
    <div>
        <v-container>
      <insect-museum-bar/>
        <img src="@/assets/상우/박물관[나비도감].jpg"/>
        <butterfly-list-form v-if="ButterflyList" :ButterflyList="ButterflyList"/>
        <p v-else>공사중입니다</p>
        </v-container>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import ButterflyListForm from '../../../components/InsectMuseum/Butterfly/ButterflyListForm.vue'
import InsectMuseumBar from '../../NavigationVar/InsectMuseumBar.vue'

export default {
    name: 'InsectMuseumButterfly',
    components: {
        ButterflyListForm,
        InsectMuseumBar

    },
    computed: {
    ...mapState(['ButterflyList'])
    },
    methods: {
        ...mapActions(['fetchButterflyList']),
     
        
    },
    mounted() {
        this.fetchButterflyList()
    },
}
</script>