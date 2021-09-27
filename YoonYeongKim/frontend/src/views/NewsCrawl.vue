<template>
    <div align="center">
        <h3 style="padding:30px 0px 30px 0px; font-weight:bold">News</h3>
        <div>
            <v-btn @click="start('culture')" text color="black" rounded x-large
                style="padding: 10px; width: 90px;">문화</v-btn>

                <v-btn @click="start('society')" text color="black" rounded x-large
                style="padding: 10px; width: 90px;">사회</v-btn>

                <v-btn @click="start('economic')" text color="black" rounded x-large
                style="padding: 10px; width: 90px;">경제</v-btn>
    
                <v-btn @click="start('digital')" text color="black" rounded x-large
                style="padding: 10px; width: 90px;">IT</v-btn>

                <v-btn @click="start('foreign')" text color="black" rounded x-large
                style="padding: 10px; width: 90px;">국제</v-btn>

                <v-btn @click="start('politics')" text color="black" rounded x-large
                style="padding: 10px; width: 90px;">정치</v-btn>
        </div>

        <div class="뉴스목록">
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
                            <!-- <td><a @click="clickNews(list.newsNo)">{{ list.title }}</a></td> -->
                            <td>{{ list.title }}</td>
                        </tr>
                    </tbody>
                </template>
            </v-simple-table>
        </div>
    </div>
</template>

<script>
import { mapState } from 'vuex'

export default {
    name: 'NewsCrawl',
    computed: {
        ...mapState ({
            lists: state => state.lists
        })
    },
    methods: {
        start (category) {
            // action 수동 호출
            this.$store.dispatch('crawlFind', category)
        }
    }
}
</script>

<style scoped>

.뉴스목록 {
  padding:0px 200px 100px 200px;
}
</style>