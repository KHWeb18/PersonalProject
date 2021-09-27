<template>
    <v-footer dark="dark" padless="padless">
        <v-card
            flat="flat"
            tile="tile"
            class="indigo lighten-1 white--text text-center"
            width="100%">
            <v-card-text>
                <v-btn v-for="icon in icons" :key="icon" class="mx-4 white--text" icon="icon">
                    <v-icon size="24px">{{ icon }}</v-icon>
                </v-btn>
            </v-card-text>

            <v-card-text class="white--text pt-0">
                (주)라이프모멘트 | 대표: 김원석 | 소재지: 서울시 강남구 역삼동<br>
                    This is the 스마트 콘텐츠와 웹융합 응용SW개발자 Personal Project vue.js web page.<br>
                    Copyright© 2021 LifeOfMoment. All Right Reserved.
                </v-card-text>

                <v-divider></v-divider>

                <v-card-text class="white--text">
                    {{ new Date().getFullYear() }}
                    —
                    <strong>Life Of Moment</strong>
                </v-card-text>
            </v-card>
        </v-footer>
</template>

<script>

export default {
  name: 'Footer',

  data: () => ({
    icons: [
      'mdi-facebook',
      'mdi-twitter',
      'mdi-linkedin',
      'mdi-instagram',
    ],
  }),
};
</script>