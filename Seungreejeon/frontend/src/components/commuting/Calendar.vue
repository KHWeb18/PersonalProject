<template>
  <v-row class="fill-height">
    <v-col>
      <v-sheet height="64">
        <v-toolbar
          flat
        >
          <v-btn
            outlined
            class="mr-4"
            color="grey darken-2"
            @click="setToday"
          >
            Today
          </v-btn>
          <v-btn
            fab
            text
            small
            color="grey darken-2"
            @click="prev"
          >
            <v-icon small>
              mdi-chevron-left
            </v-icon>
          </v-btn>
          <v-btn
            fab
            text
            small
            color="grey darken-2"
            @click="next"
          >
            <v-icon small>
              mdi-chevron-right
            </v-icon>
          </v-btn>
          <v-toolbar-title v-if="$refs.calendar">
            {{ $refs.calendar.title }}
          </v-toolbar-title>
          <v-spacer />
          <!-- add Event -->
          <div>
            <add-event />
          </div>
        </v-toolbar>
      </v-sheet>



      <v-sheet height="600">
        <v-calendar
          ref="calendar"
          v-model="focus"
          color="primary"
          :events="get"
          :type="type"
          :event-color="getEventColor"
          @click:event="showEvent"
          @click:more="viewDay"
        />
        <v-menu
          v-model="selectedOpen"
          :close-on-content-click="false"
          :activator="selectedElement"
          offset-x
        >
          <v-card
            color="grey lighten-4"
            :width="350"
            flat
          >
            <v-toolbar
              :color="selectedEvent.color"
              dark
            >
              <v-btn
                icon
                @click="deleteEvent(selectedEvent.calendarNo)"
              >
                <v-icon>mdi-delete</v-icon>
              </v-btn>
              <v-toolbar-title>
                {{ selectedEvent.name }}
              </v-toolbar-title>
              <div class="flex-grow-1" />
            </v-toolbar>

            <v-card-text>
              <form v-if="currentlyEditing !== selectedEvent.id">
                {{ selectedEvent.details }}
              </form>
              <form v-else>
                <textarea-autosize
                  v-model="selectedEvent.details"
                  type="text"
                  style="width: 100%"
                  :min-height="100"
                  placeholder="add note"
                />
              </form>
            </v-card-text>
          </v-card>
        </v-menu>
      </v-sheet>
    </v-col>
  </v-row>
</template>

<script>

export default {
  components: {
    AddEvent: () => import('./addEvent.vue')
  },

  data: () => ({
    focus: '',
    type: 'month',

    selectedEvent: {},
    selectedElement: null,
    selectedOpen: false,
    currentlyEditing: null,
    // dialogDate: false,

  }),

  computed: {
    get () {
      return this.$store.getters['calendar/getevents']
    },
  },

  created () {
    // this.$refs.calendar.checkChange()
    this.$store.dispatch('calendar/fetchCalendar')
  },

  methods: {
    async deleteEvent (No) {
      this.selectedOpen = false
      this.$store.dispatch('calendar/deleteCalendar', No)
    },

    viewDay ({ date }) {
      this.focus = date
      this.type = 'day'
    },
    getEventColor (event) {
      return event.color
    },
    setToday () {
      this.focus = ''
    },
    prev () {
      this.$refs.calendar.prev()
    },
    next () {
      this.$refs.calendar.next()
    },

    showEvent ({ nativeEvent, event }) {
      const open = () => {
        this.selectedEvent = event
        this.selectedElement = nativeEvent.target
        requestAnimationFrame(() => requestAnimationFrame(() => this.selectedOpen = true))
      }

      if (this.selectedOpen) {
        this.selectedOpen = false
        requestAnimationFrame(() => requestAnimationFrame(() => open()))
      } else {
        open()
      }

      nativeEvent.stopPropagation()
    },
  },
}
</script>
