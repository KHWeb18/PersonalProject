<template>
  <v-dialog
    v-model="dialog"
    max-width="600px"
  >
    <template v-slot:activator="{ on , attrs}">
      <v-btn
        slot="activator"
        text
        v-bind="attrs"
        width="100"
        rounded
        v-on="on"
      >
        <h5>
          Post
        </h5>
      </v-btn>
    </template>
    <v-card>
      <v-card-title>
        <h5>Post</h5>
      </v-card-title>
      <v-card-text>
        <validation-observer
          v-slot="{ invalid }"
          ref="observer"
        >
          <v-form
            ref="form"
            class="px-3"
            @submit.prevent="post"
          >
            <validation-provider
              v-slot="{ errors }"
              :rules="{
                required: true,
              }"
              name="title"
            >
              <v-text-field
                v-model="title"
                label="Title"
                prepend-icon="mdi-folder"
                :error-messages="errors"
              />
            </validation-provider>

            <validation-provider
              v-slot="{ errors }"
              :rules="{
                required: true,
              }"
              name="content"
            >
              <v-textarea
                v-model="content"
                prepend-icon="mdi-pencil"
                label="Information"
                :error-messages="errors"
              />
            </validation-provider>
            <!-- <validation-provider
              v-slot="{ errors }"
              :rules="{
                required: true,
              }"
              name="due"
            >
              <v-row>
                <v-col cols="6">
                  <v-menu max-width="290">
                    <template v-slot:activator="{ on, attrs }">
                      <v-text-field
                        slot="activator"
                        v-model="due"
                        label="Due Date"
                        prepend-icon="mdi-calendar-range"
                        v-bind="attrs"
                        :value="due"
                        :error-messages="errors"
                        v-on="on"
                      />
                    </template>
                    <v-date-picker
                      v-model="due"
                    />
                  </v-menu>
                </v-col>
              </v-row>
            </validation-provider> -->

            <v-spacer />

            <v-btn
              class="success mx-0 mt-3"
              small
              :loading="loading"
              type="submit"
              :disabled="invalid"
            >
              Post
            </v-btn>
          </v-form>
        </validation-observer>
      </v-card-text>
    </v-card>
  </v-dialog>
</template>

<script>
export default {
  data: ()=> ({
    title: '',
    content: '',
    // due: null,
    loading: false,
    dialog: false
  }),
  methods: {

    async post() {
      const result = await this.$refs.observer.validate()

      if( result ) {
        this.$store.dispatch('board/post',
          { title: this.title, content: this.content }
        )
        this.dialog = false
      }


      // if (this.$refs.form.validate()) {
      //   this.loading = true;
      //   // after res false

      //   const project = {
      //     title: this.title,
      //     content: this.content,
      //     due: this.due,
      //     // 2021-08-11
      //     person: 'Ree',
      //     status: 'ongoing'
      //   }
      //   // this.$emit('projectAdded')
      // }
      // // db에서 받게되면 수행할것
      // this.dialog = false

    }
  }

}
</script>

<style>

</style>
