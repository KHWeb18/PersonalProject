<template>
  <div>
    <h2 class="grey--text">
      ProjectPlan
    </h2>
    <v-btn text>
      <h4 class="font-weight-light ">
        Depart : {{ team }}
      </h4>
    </v-btn>

    <v-snackbar
      v-model="snackbar"
      :timeout="2000"
      top
      color="success"
    >
      <span>Awesome! You added a new project.</span>
      <v-btn
        color="white"
        small
        text
        @click="snackbar = !snackbar"
      >
        Close
      </v-btn>
    </v-snackbar>
    <v-container class="my-3">
      <v-row class="my-5">
        <v-col class="mb-3">
          <add-project @projectAdded="snackbar = !snackbar" />
          <v-tooltip top>
            <template v-slot:activator="{ on, attrs }">
              <v-btn
                slot="activator"
                small
                color="grey"
                text
                v-bind="attrs"
                @click="sortBy('title')"
                v-on="on"
              >
                <v-icon
                  left
                  samll
                >
                  mdi-folder
                </v-icon>

                <span class="text-lowercase">By projcect name</span>
              </v-btn>
            </template>
            <span>Sort projects by name</span>
          </v-tooltip>
          <v-tooltip top>
            <template v-slot:activator="{ on, attrs }">
              <v-btn
                small
                color="grey"
                text
                v-bind="attrs"
                @click="sortBy('person')"
                v-on="on"
              >
                <v-icon
                  left
                  samll
                >
                  mdi-account-circle
                </v-icon>
                <span class="text-lowercase">By person</span>
              </v-btn>
            </template>
            <span>Sort person by name</span>
          </v-tooltip>
        </v-col>
      </v-row>

      <v-card
        v-for="( project, i ) in get"
        :key="i"
        flat
        class="ml-15"
      >
        <v-row :class="`project ${project.status}`">
          <v-col
            cols="5"
          >
            <div class="grey--text text-caption">
              Project Title
            </div>
            <div>{{ project.title }}</div>
          </v-col>
          <v-col
            cols="3"
          >
            <div class="grey--text text-caption">
              Person
            </div>
            <div>
              {{ project.person }}
            </div>
          </v-col>
          <v-col
            cols="2"
          >
            <div class="grey--text text-caption">
              Due By
            </div>
            <div>
              {{ project.due }}
            </div>
          </v-col>
          <v-col
            cols="2"
          >
            <div class="float-right ">
              <v-chip
                id="chip"
                :class="`${project.status} white--text my-2`"
              >
                <!-- :color="project.status==='complete'?'green':project.status==='ongoing'?'blue':'orange'" -->
                {{ project.status }}
              </v-chip>
              <v-btn
                v-show="role"
                icon
                @click="delProject(project.projectNo)"
              >
                <v-icon>mdi-delete</v-icon>
              </v-btn>
            </div>
          </v-col>
        </v-row>
        <br>
        <v-divider />
      </v-card>
    </v-container>
  </div>
</template>

<script>

import { mapActions } from 'vuex'

export default {
  components: {
    AddProject: () => import('./AddProject.vue')
  },

  data: ()=> ({
    // projects: [
    //   { title: 'd esign a new webSite', person: 'Zealot', due: '4st Jan 2019', status: 'complete'},
    //   { title: 'a dbadsfnew webSite', person: 'Dragoon', due: '2st Jan 2019', status: 'ongoing'},
    //   { title: 'z sdfasdf the beat', person: 'Tank', due: '1st Jan 2019', status: 'overdue'}
    // ],
    snackbar: false
  }),
  computed: {

    get () {
      return this.$store.getters['project/getProject']

    },
    team() {
      return localStorage.getItem('team')
    },
    role() {
      return this.$store.getters['authentication/getRole']
    }

  },
  created() {
    this.fetchProject()
  },

  methods: {
    ...mapActions('project', {
      fetchProject: 'fetchProject'
    }),
    sortBy(value) {
      this.$store.dispatch('project/getSort', value)
    },
    delProject(value) {
      this.$store.dispatch('project/deleteProject', value)
    }
  }

}
</script>

<style>

.project.complete {
  border-left: 4px solid #3cd175;
}
.project.ongoing {
  border-left: 4px solid orange;
}
.project.overdue {
  border-left: 4px solid red;
}

#chip.v-chip.complete {background: #00cc00;}
#chip.v-chip.ongoing{
  background: orange;
}
#chip.v-chip.overdue{
  background: red;
}

</style>
