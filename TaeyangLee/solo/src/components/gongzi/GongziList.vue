<template>
    <div>
        <v-data-table
                    :headers="headerTitle"
                    :items="gongzis"
                    :items-per-page="10"
                    class="elevation-1"
                      @click:row="readItem" >
                    
            </v-data-table>
            


    </div>
</template>


<script>


import { mapState, mapActions } from 'vuex'

export default {
    
    name: 'GongziList',
    data() {
        return {
             headerTitle: [
                { text: '번호', value: 'gongziNo', width: "70px" },
                { text: '제목', value: 'title', width: "200px" },
                { text: '내용', value: 'content', width: "100px" },
                { text: '작성자', value: 'writer', width: "100px" }
                
                
            ],
            
            
        }
    },
    props: {
        gongzis: {
            type: Array,
            require: true
        }
    },
 
 
    methods: {
        ...mapActions(['fetchGongzi']),
        readItem(gongzi) {
            
            
            
            this.$router.push({ name: 'GongziReadPage',
                                    params: { gongziNo: gongzi.gongziNo} } )
        }
    },
    computed: {
         ...mapState(['gongzi'])
    }
    
    
}
</script>