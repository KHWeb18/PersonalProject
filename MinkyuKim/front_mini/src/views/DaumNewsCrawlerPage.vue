<template>    
        <Layout>
            <!--
            <template #menubar>
                <v-btn @click="start('culture')" text color="black"
                        style="padding-top: 100px; padding: 50px; width: 90px;">정보 불러오기(문화)</v-btn>
            </template>
            -->
            <template #content>
                <v-btn @click="start('culture')" text color="black"
                        style="padding-top: 100px; padding: 20px; width: 150px;">정보 불러오기(문화)</v-btn>
                <v-simple-table>
                    <template v-slot:default>
                        <thead>
                            <tr>
                                <th class="text-left">No.</th>
                                <th class="text-left">제목</th>                                
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="list of lists" :key="list.title">
                                <td style="color: gray">{{ list.newsNo }}</td>
                                <td><a @click="clickNews()">{{ list.title }}</a></td>
                                <!--<td><a @click="clickNews(list.newsNo)">{{ list.title }}</a></td>
                                <td>{{ list.title }}</td>-->
                            </tr>
                        </tbody>
                    </template>
                </v-simple-table>
            </template>        
        </Layout>
    
</template>

<script>
import Layout from '@/components/layout/Layout'
import { mapState } from 'vuex'
//import axios from 'axios'

export default {        
    components: {
        Layout
    },
    computed: {
        ...mapState ({
            lists: state => state.lists            
        }),
        /*
        ...mapState ({
            address: state => state.address
        })*/
    },
    methods: {
         
        start (category) {
            // action 수동 호출
            this.$store.dispatch('crawlFind', category)
        },
        clickNews() {            
            /*
            axios.get("http://localhost:7777/culture" + '${address}', {address})
			.then((res)=>{
				console.log(res);
			})
			.then((err)=>{
				console.log(err);
			})
            */

            /*
            const { address } = payload
            axios.get('http://localhost:7777/' + `${address}`)
                .then(res => {
                    //this.$router.push({ res.data.address })
                    console.log(res.data)
                })*.
            //return this.$store.state.address

            
            //this.$store.dispatch('crawlAddress', address)


            
            
            
            //const { address } = payload
                              
            //this.$store.dispatch('crawlAddress', address)
            /*axios.get('http://localhost:7777/' + `${address}`)
                .then(res => {
                    console.log(res.data);
                })*/
            //axios.get(`${this.address}`)
            window.open("https://news.daum.net/culture#1")            
            //window.open('http://localhost:7777/' + `${this.address}`)   
            /*axios.get('http://localhost:7777/', `${address}`)            
                    .then(res => {
                        console.log(res.data)
                    })*/
        },
        /*
        ...mapActions(['crawlAddress']),
        clickNews (payload) {
            const { address } = payload
            axios.put(`http://localhost:7777/${this.address}`, { address })
            //axios.put(`http://localhost:7777/${this.address}`)
                    .then(res => {
                        alert('수정 성공!')
                        // push의 경우 to의 역할과 같다.( router-link-to)
                        this.$router.push({                            
                            params: { address: res.data.address.toString() }
                        })
                    })
                    .catch(err => {
                        alert(err.response.data.message)
                    })
            }
        },   */
    }
}
</script> 