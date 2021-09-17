<template>
    <div>
        <insect-museum-bar/>
        <img src="@/assets/상우/박물관[하늘소도감].jpg"/>
        <skycow-list-form v-if="SkycowList" :SkycowList="SkycowList"/>
            <p v-else> 공사중</p>
           
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import InsectMuseumBar from '../../NavigationVar/InsectMuseumBar.vue'
import SkycowListForm from '../../../components/InsectMuseum/Skycow/SkycowListForm.vue'
export default {
  components: { InsectMuseumBar, SkycowListForm },
    computed: {
        ...mapState(['SkycowList'])
    },
    methods: {
        ...mapActions(['fetchSkycowList'])
    },
    mounted() {
        this.fetchSkycowList()
    },
}
</script>