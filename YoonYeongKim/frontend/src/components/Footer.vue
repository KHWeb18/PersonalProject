<template>
    <footer class="footer">
        <v-footer
            dark
            padless
        >
            <v-card
            flat
            tile
            class="indigo lighten-1 white--text text-center"
            >
            <v-card-text>
                <v-btn
                v-for="icon in icons"
                :key="icon"
                class="mx-4 white--text"
                icon
                >
                <v-icon size="24px">
                    {{ icon }}
                </v-icon>
                </v-btn>
            </v-card-text>

            <v-card-text class="white--text pt-0">
                This page was created based on data from author Robert Dimmery's book 1001 Albums You Must Hear Before You Die. I hope you enjoy watching it. This page was created based on data from author Robert Dimmery's book 1001 Albums You Must Hear Before You Die. I hope you enjoy watching it. This page was created based on data from author Robert Dimmery's book 1001 Albums You Must Hear Before You Die. I hope you enjoy watching it.
            </v-card-text>

            <v-divider></v-divider>

            <v-card-text class="white--text">
                {{ new Date().getFullYear() }} — <strong>YOUMUSTHEAR1001</strong>
            </v-card-text>
            </v-card>
        </v-footer>
	</footer>
</template>

<script>
  export default {
    data: () => ({
      icons: [
        'mdi-facebook',
        'mdi-twitter',
        'mdi-linkedin',
        'mdi-instagram',
      ],
    }),
  }
</script>