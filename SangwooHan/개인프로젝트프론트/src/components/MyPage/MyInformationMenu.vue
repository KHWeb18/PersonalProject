<template>
    <div>
    <table class="type02">
        <tr>
     
            <v-btn depressed route :to="{name: 'BasketReadPage', params:{memberNo: this.$store.state.loginMemberNo}}">
                장바구니
            </v-btn>
            
            <v-btn depressed route :to="{name: 'MyInformationDetail'}">
                내정보
            </v-btn>

            <v-btn depressed route :to="{name: 'MyProductStatus',params:{User: this.$store.state.User} }">
                주문현황
            </v-btn>

            <v-btn depressed route :to="{name: 'CustomerSoundPage' }">
                고객센터
            </v-btn>
        </tr>
    </table>

 
    </div>
</template>

<script>

export default {
    name: 'MyInformation',

    props: {
        member: {
            type:Object
        }
    },
 
    methods:{
        
        haha(){
             this.$router.push({name: 'BasketReadPage',params:{memberNo: this.$store.state.loginMemberNo}}) 
        }
        /*
        BasketDetail(){
            this.$router.replace({name: 'BasketReadPage', params:{memberNo: this.$store.state.loginMemberNo}})
        },
        myinformationDetail() {
            this.$router.replace({ name: 'MyInformationDetail'})
        },
        MyProductStatusDetail() {
            this.$router.replace({name: 'MyProductStatus'})
        }
        */
    },
 
}
</script>

<style scoped>

</style>