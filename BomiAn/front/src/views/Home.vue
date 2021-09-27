<template>
    <div>
      <div v-for="(board, idx) in boards" :key="idx" class="mb-7">
        <v-hover>
            <template v-slot:default="{ hover }">
                    <v-card
                        class="mx-auto"
                        color="rgb(160, 149, 245)"
                        :elevation="hover ? 24 : 6"
                        max-width="600">
                        <v-card-title>
                            Q.
                            <span class="text-h6 font-weight-bold">{{ board.topic }}</span>
                        </v-card-title>

                        <v-card-text class="text-h5 font-weight-bold">
                            <div class="d-flex justify-space-around">
                                <router-link :to="{ name : 'GoToVote', params: { id: board.id } }">
                                    <v-btn>{{ board.op1 }}</v-btn>
                                </router-link>
                                <span>VS</span>
                                <router-link :to="{ name : 'GoToVote', params: { id: board.id } }">
                                    <v-btn>{{ board.op2 }}</v-btn>
                                </router-link>
                            </div>
                        </v-card-text>

                        <v-card-actions>
                            <v-list-item class="grow">
                                <v-list-item-content>
                                    <v-list-item-title class="text-start">{{ board.user_nickname }}</v-list-item-title>
                                </v-list-item-content>

                                <v-row align="center" justify="end">
                                    <v-icon class="mr-1" :color="hover?'red':'white'">
                                        mdi-heart
                                    </v-icon>
                                    <span class="subheading mr-2">{{ board.all_cnt }}</span>
                                    <span class="mr-1">·</span>
                                    <v-icon class="mr-1" :color="hover?'primary':'white'">
                                        mdi-share-variant
                                    </v-icon>
                                </v-row>
                            </v-list-item>
                        </v-card-actions>
                    </v-card>
            </template>
        </v-hover>
      </div>
    </div>
</template>

<script>

export default {
  data() {
    return {
      boards: []
    }
  },
  created() {
    this.getBoards();
    
  },
  methods: {
    getBoards () {
      this.$http.get('/api/getBoards')
          .then(res => {
            this.boards = res.data
          })
    },
  },
 
}
</script>

<style scoped>
* {
  text-decoration: none;
}
</style>
