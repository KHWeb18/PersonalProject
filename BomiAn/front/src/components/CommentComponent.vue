<template>
  <div class="text-left mt-5">
    <v-form>
    <v-container>
      <v-row>
        <v-col cols="12">
          <v-text-field
            v-model="user_comment"
            :append-outer-icon="'mdi-send'"
            :prepend-icon="icon"
            filled
            clearable
            clear-icon="mdi-close-circle"
            label="Leave your comment!"
            type="text"
            @click:append="toggleMarker"
            @click:append-outer="insertComment"
            @keyup.enter="insertComment"
            @click:prepend="changeIcon"
            @click:clear="clearMessage"
          ></v-text-field>
        </v-col>
      </v-row>
    </v-container>
  </v-form>

    <v-list three-line v-for="(comment, index) in comments" :key="index">
      <template>
        <v-list-item>
          <v-list-item-avatar>
            <v-icon large>{{ comment.icon }}</v-icon>
          </v-list-item-avatar>

          <v-list-item-content>
            <div class="d-flex justify-space-between">
              <v-list-item-title>{{ comment.user_nickname }}</v-list-item-title>
              <v-icon v-if="user.no == comment.u_no" @click="deleteComment(comment.id)">mdi-close</v-icon>
              <div v-else></div>
            </div>
            <v-list-item-subtitle><span class="text--primary">{{ comment.comment }}</span></v-list-item-subtitle>
          </v-list-item-content>
        </v-list-item>
      </template>
    <v-divider></v-divider>
    </v-list>
  </div>
</template>

<script>
  export default {
    data: () => ({
      user_comment: '',
      marker: true,
      iconIndex: 0,
      icons: [
        'mdi-emoticon',
        'mdi-emoticon-cool',
        'mdi-emoticon-dead',
        'mdi-emoticon-excited',
        'mdi-emoticon-happy',
        'mdi-emoticon-neutral',
        'mdi-emoticon-sad',
        'mdi-emoticon-tongue',
      ],
    }),

    computed: {
      icon () {
        return this.icons[this.iconIndex]
      },
      user() {
        return this.$store.state.user
      }
    },

    methods: {
      toggleMarker () {
        this.marker = !this.marker
      },
      insertComment () {
        const comment = {
          u_no: this.$store.state.user.no,
          b_no: this.$route.params.id,
          comment: this.user_comment,
          icon: this.icon
        }
        this.$emit('insertComment', comment)
        this.resetIcon()
        this.clearMessage()
      },
      clearMessage () {
        this.user_comment = ''
      },
      resetIcon () {
        this.iconIndex = 0
      },
      changeIcon () {
        this.iconIndex === this.icons.length - 1
          ? this.iconIndex = 0
          : this.iconIndex++
      },
      deleteComment(id) {
        this.$emit('deleteComment', id)
      } 
    },
    props: {
      comments: Array
    },
  }
</script>