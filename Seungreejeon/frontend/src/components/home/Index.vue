<template>
  <v-fade-transition mode="out-in">
    <v-container class="mt-15">
      <!-- <span>{{ $moment().format('YYYY-MM-DD') }}</span> -->
      <v-row>
        <v-col class="5">
          <v-card
            align="center"
            class="text-h1 font-weight-thin mt-15"
            flat
          >
            {{ time }}
          </v-card>
        </v-col>
      </v-row>
      <v-row>
        <v-col class="mt-15">
          <template>
            <v-data-table
              :headers="headers"
              :items="boards"
              :items-per-page="3"
              hide-default-footer
              :sort-by="['boardNo']"
              :sort-desc="[true]"
            >
              <template v-slot:[`item.regDate`]="{ item }">
                <display-time :time="item.regDate" />
              </template>
              <template v-slot:[`item.title`]="{ item }">
                <a
                  class="black--text"
                  @click="openDialog(item)"
                >{{ item.title }} </a>
              </template>
            </v-data-table>
          </template>
        </v-col>
      </v-row>
      <v-dialog
        v-if="selectedItem"
        v-model="dialog"
        max-width="800"
      >
        <board-content
          :item="selectedItem"
          @change="change"
        />
      </v-dialog>
    </v-container>
  </v-fade-transition>
</template>

<script>
import { mapState,mapActions } from 'vuex'

import DisplayTime from '../board/display-time.vue'

import BoardContent from '../board/BoardContent.vue'

export default {

  components: {
    DisplayTime,
    BoardContent
  },
  data:() => ({
    interval: null,
    time: null,
    dialog: false,
    selectedItem: null
  }),

  computed: {
    ...mapState('board', {
      headers: 'headers',
      boards: 'boards'
    }),
  },

  beforeDestroy() {
    clearInterval(this.interval)
  },

  created() {
    this.fetchBoard()

    this.interval = setInterval(() => {

      this.time = Intl.DateTimeFormat('en-US', {
        hour: 'numeric',
        minute: 'numeric',
        second: 'numeric'
      }).format()
    }, 1000)
  },
  methods: {
    ...mapActions('board', {
      fetchBoard: 'fetchBoard'
    }),
    openDialog (item) {
      this.selectedItem = item
      this.dialog = true
    },
    change() {
      this.dialog = false
    }
  },
}

</script>

<style>

</style>
