<template>
  <div>
     <v-card
    class="mx-auto"
    max-width="344"
    outlined
  >
    <v-list-item three-line>
      <v-list-item-content>
        <div class="text-overline mb-4">
          IFYOU
        </div>
        <v-list-item-title class="text-h5 mb-1">
          {{ user_nick }}
        </v-list-item-title>
        <v-list-item-subtitle>Welcome! We are always wondering your opnion:)</v-list-item-subtitle>
      </v-list-item-content>

      <v-avatar
        size="80"
        color="rgb(0, 255, 1)"
      >
      <v-icon x-large color="black">mdi-emoticon-cool</v-icon>
      </v-avatar>
    </v-list-item>

    <v-card-actions class="d-flex justify-space-around">
      <v-btn
        outlined
        rounded
        text
        @click="updateNickname = !updateNickname"
      >
        edit
      </v-btn>
          <v-btn
        outlined
        rounded
        text
        @click="signOut"
      >
        sign out
      </v-btn>
    </v-card-actions>
  </v-card>

  <v-dialog v-model="updateNickname" max-width="400">
      <v-card>
      <v-card-title>
        change your nickname
      </v-card-title>
      <v-card-text>
        <v-text-field
          class="pa-2"
          label="nickname"
          color="rgb(0, 255, 1)"
          type="text"
          name="nickname"
          v-model="nickname"
          required
        >
        </v-text-field>
      </v-card-text>
      <v-card-actions>
        <v-btn outlined rounded text color="rgb(160, 149, 245)"
        @click="changeNickname"
        >edit</v-btn>
      </v-card-actions>
    </v-card>

  </v-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      updateNickname: false,
      nickname: ''
    }
  },
  methods: {
    signOut() {
      this.$emit('signOut')
    },
    changeNickname() {
      this.$emit('changeNickname', this.nickname)
      this.updateNickname = false
    }
  },
  computed:{
    user_nick() {
      return this.$store.state.user.nickname
    }
  }
}
</script>