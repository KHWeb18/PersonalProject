<template>
  <div>
  <v-simple-table dark>
    <template v-slot:default>
      <thead>
        <tr>
          <th class="text-left">
            Topic
          </th>
          <th class="text-left">
          </th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(board, idx) in boards" :key="idx">
          <td class="text-start">{{ board.topic }}</td>
          <td>
            <div class="d-flex justify-space-around">
              <v-icon @click="deleteMyBoard(board.id)">mdi-trash-can</v-icon>
              <v-icon @click="openDialog(idx)">mdi-pencil</v-icon>
            </div>
          </td>
        </tr>
      </tbody>
    </template>
  </v-simple-table>

  <v-dialog v-model="updateTopic" max-width="500px">
          <v-card>
            update Topic
            <v-card-title>
              <v-radio-group v-model="userBoard.type" row>
               <v-radio label="pros and cons" value="1"></v-radio>
                <v-radio label="balance" value="2"></v-radio>
              </v-radio-group>
            </v-card-title>
            <v-card-text>
              <v-text-field label="Topic" v-model="userBoard.topic"></v-text-field>
              <v-divider></v-divider>
              <div v-if="userBoard.type == 2">
                <v-text-field label="Optin1" v-model="userBoard.op1"></v-text-field>
                <v-text-field label="Optin2" v-model="userBoard.op2"></v-text-field>
              </div>
               <v-text-field label="Description" v-model="userBoard.content"></v-text-field>
            </v-card-text>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn text color="rgb(255, 68, 1)" @click="updateMyBoard">
                update
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
  </div>
</template>

<script>
export default {
  props: {
    boards: {
      type: Array,
      required: true
    }
  },
  data() {
    return {
      updateTopic: false,
      userBoard: {
        type: 1,
        topic: "",
        op1: "찬성",
        op2: "반대",
        content: "",
        id: 0
      }
    }
  },
  methods: {
    deleteMyBoard(id) {
      this.$emit('deleteMyBoard', id)
    },
    openDialog(idx) {
      this.userBoard.type = this.boards[idx].type
      this.userBoard.topic = this.boards[idx].topic
      this.userBoard.op1 = this.boards[idx].op1
      this.userBoard.op2 = this.boards[idx].op2
      this.userBoard.content = this.boards[idx].content
      this.userBoard.id = this.boards[idx].id
      this.updateTopic = !this.updateTopic
    },
    updateMyBoard() {
      this.$emit('updateMyBoard', this.userBoard)
      this.updateTopic = !this.updateTopic
    }
  },
  
}
</script>