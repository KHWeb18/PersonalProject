<template>
    <v-container>
        <v-row>
            <v-col v-for="image in images" :key="image" class="d-flex child-flex" cols="3">
                <v-img :src="image" aspect-ratio="1" class="gery lighten-2">
                    
                    <template v-slot:placeholder>
                        <v-row class="fill-height ma-0" align="center" justify="center">
                            <v-progress-circular indeterminate color="grey lighten-5">
                            </v-progress-circular>
                        </v-row>
                    </template>
                </v-img>
            </v-col>
        </v-row>
    </v-container>
</template>

<script>
export default {
    name: 'BouquetPage',
    data () {
        return {
            images: [
                //require('@/assets/img/ferrari.jpg'),
               
                
                "https://e7.pngegg.com/pngimages/867/407/png-clipart-tulip-tulip-bouquet.png",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQozzzA3NF1ejWgng15tSQTKYtjAwwRQ-TyCA&usqp=CAU",
                "https://i.pinimg.com/originals/d7/4e/27/d74e2746c6fa2f6d80baf0192c6c5195.jpg",
                "https://e7.pngegg.com/pngimages/867/407/png-clipart-tulip-tulip-bouquet.png",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQozzzA3NF1ejWgng15tSQTKYtjAwwRQ-TyCA&usqp=CAU",
                "https://i.pinimg.com/originals/d7/4e/27/d74e2746c6fa2f6d80baf0192c6c5195.jpg",
                "https://e7.pngegg.com/pngimages/867/407/png-clipart-tulip-tulip-bouquet.png",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQozzzA3NF1ejWgng15tSQTKYtjAwwRQ-TyCA&usqp=CAU",
                "https://i.pinimg.com/originals/d7/4e/27/d74e2746c6fa2f6d80baf0192c6c5195.jpg",
                "https://e7.pngegg.com/pngimages/867/407/png-clipart-tulip-tulip-bouquet.png",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQozzzA3NF1ejWgng15tSQTKYtjAwwRQ-TyCA&usqp=CAU",
              
            ]
             
        }
    }
}
</script>

<style scoped>

v-cols {
    padding: 10px;
    margin: 10px;
}
v-row {
    padding: 10px;
    margin: 10px;
}
</style>