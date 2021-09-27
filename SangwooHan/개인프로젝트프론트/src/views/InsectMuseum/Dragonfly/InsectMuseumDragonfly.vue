<template>
    <div><v-container>
        <insect-museum-bar/>
        <img src="@/assets/상우/박물관/박물관[한국잠자리도감].jpg"/>
        <dragonfly-list-form :DragonflyList="DragonflyList" />
        </v-container>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import DragonflyListForm from '../../../components/InsectMuseum/Dragonfly/DragonflyListForm'
import InsectMuseumBar from '../../NavigationVar/InsectMuseumBar.vue'
export default {
  components: { DragonflyListForm,InsectMuseumBar },
    name: 'InsectMuseumDragonfly',

    computed: {
        ...mapState(['DragonflyList'])
    },
    methods:{
        ...mapActions(['fetchDragonflyList'])
    },
    mounted() {
        this.fetchDragonflyList()
    },

}
</script>