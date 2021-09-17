<template>
    <div>
         <v-toolbar  flat   >
   
    <v-toolbar-title>
        <span class="font-weight-light"></span>
    </v-toolbar-title>
     <v-spacer></v-spacer>
    <v-toolbar-items>
       <v-btn text v-for="link in LogInlinks" :key="link.icon" :to="link.route">
            {{ link.text }}
        </v-btn>
       
    </v-toolbar-items>
      <v-spacer></v-spacer>
    </v-toolbar>
    </div>
</template>

<script>
export default {
    
    data() {
        return{
            LogInlinks: [
                {
                
                text: '검색',
                 name: '검색',
                 route: '/insectMuseumPage'
                },
                {
                
                text: '사슴벌레',
                 name: '사슴벌레',
                 route: '/insectMuseumStagbeetle'
                },
                {text: '장수풍뎅이',
                 name: '사슴벌레',
                 route: '/insectMuseumBeetle'
                },
                {text: '잠자리',
                 name: '잠자리',
                 route: '/insectMuseumDragonfly'
                },
                {text: '하늘소',
                 name: '하늘소',
                 route: '/insectMuseumSkycow'
                },
                {text: '나비/나방',
                 name: '나비/나방',
                 route: '/insectMuseumButterfly'
                },
            ]
        }
    }
}
</script>