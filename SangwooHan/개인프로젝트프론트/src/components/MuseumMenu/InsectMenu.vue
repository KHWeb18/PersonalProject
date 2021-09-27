<template>
    <div>
       <v-menu
        bottom
        offset-y
      >
        <template v-slot:activator="{ on, attrs }">
          <v-btn
            dark
            v-bind="attrs"
            v-on="on"
          >
           메뉴
          </v-btn>
        </template>
        <v-list>
          <v-list-item
            v-for="(item, i) in items"
            :key="i"
            @click="Click(item)"
          >
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>

    </div>
</template>

<script>

export default {
    name: 'InsectMuseumPage',
    components: {
   
    },
    data() {
        return {
            items: [
                {title: '잠자리' },
                {title: '장수풍뎅이' },
                {title: '사슴벌레'}
            ]
        }
    },
    methods: {
        Click(item) {

            console.log(item.title)
           
           if(item.title =='사슴벌레'){ 
            this.$router.replace({name: 'InsectMuseumStagbeetle'}).catch(err => {alert(err.response.data.message)})}
            else if(item.title =='장수풍뎅이'){if(this.$router =='insectMuseumbeetle'){alert('현재페이지입니다.')} else{ this.$router.replace({ name: 'InsectMuseumbeetle'})}}
            else if(item.title =='잠자리'){this.$router.replace({ name: 'InsectMuseumDragonfly'}).catch(err => {alert(err.response.data.message)})}
            
            
           
        }
    }
}
</script>

<style scoped>

</style>