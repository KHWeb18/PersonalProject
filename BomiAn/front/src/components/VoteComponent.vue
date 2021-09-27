<template>
    <div>
      <div>
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
                        <v-divider></v-divider>
                        <div>{{ board.content }}</div>
                        <v-card-text class="text-h5 font-weight-bold">
                            <div class="d-flex justify-space-around">               
                                <div class="d-flex flex-column"><v-btn @click="voteOp1(board.id)">{{ board.op1 }}</v-btn>
                                <span>{{ board.op1_cnt }}</span></div>
                                <span>VS</span>
                                <div class="d-flex flex-column"><v-btn @click="voteOp2(board.id)">{{ board.op2 }}</v-btn>
                                <span>{{ board.op2_cnt }}</span></div>
                            </div>
                        </v-card-text>

                        <v-card-actions>
                            <v-list-item class="grow">
                                <v-list-item-content>
                                    <v-list-item-title>{{ board.user_nickname }}</v-list-item-title>
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
  props: ['board'],
  methods: {
    voteOp1(id) {
      this.$emit('voteOp1', id)
    },
    voteOp2(id) {
      this.$emit('voteOp2', id)
    }
  },
}
</script>