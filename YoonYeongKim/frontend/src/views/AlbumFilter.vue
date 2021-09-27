<template>
    <div class="앨범추천받기" align="center">
        <div>
        <h1 style="padding:50px 0px 0px 0px;">
          당신의 취향에 맞춰 추천 받아보세요</h1>
        </div>
        <div class="필터">
            <v-app size=sm>
                <v-container fluid>
                    <v-row>
        <!----------------------------------------------------------------------->
                        <v-col
                        style="width:440px;"
                        cols="12"
                        sm="6">
                            <v-autocomplete
                            v-model="e7"
                            :items="아티스트"
                            label="아티스트"
                            multiple
                            clearable
                            chips
                            deletable-chips
                            outlined
                            hint="아티스트를 선택하세요"
                            persistent-hint
                            ></v-autocomplete>
                        </v-col>
        <!----------------------------------------------------------------------->
                        <v-col
                        style="width:440px;"
                        cols="12"
                        sm="6">
                            <v-autocomplete
                            v-model="e8"
                            :items="발매연도"
                            label="발매연도"
                            multiple
                            clearable
                            chips
                            deletable-chips
                            outlined
                            hint="발매연도를 선택하세요"
                            persistent-hint
                            ></v-autocomplete>
                        </v-col>
        <!----------------------------------------------------------------------->
                        <v-col
                        style="width:440px;"
                        cols="12"
                        sm="6">
                            <v-autocomplete
                            v-model="e9"
                            :items="장르"
                            label="장르"
                            multiple
                            clearable
                            chips
                            deletable-chips
                            outlined
                            hint="장르를 선택하세요"
                            persistent-hint
                            ></v-autocomplete>
                        </v-col>
        <!----------------------------------------------------------------------->
                        <v-col
                        style="width:440px;"
                        cols="12"
                        sm="6">
                            <v-autocomplete
                            v-model="e10"
                            :items="스타일"
                            label="스타일"
                            multiple
                            clearable
                            chips
                            deletable-chips
                            outlined
                            hint="스타일를 선택하세요"
                            persistent-hint
                            ></v-autocomplete>
                        </v-col>
        <!----------------------------------------------------------------------->
                        <v-col
                        style="width:440px;"
                        cols="12"
                        sm="6">           
                            <v-autocomplete
                            v-model="e11"
                            :items="국가"
                            label="국가"
                            multiple
                            clearable
                            chips
                            deletable-chips
                            outlined
                            hint="국가를 선택하세요"
                            persistent-hint
                            ></v-autocomplete>
                        </v-col>
        <!----------------------------------------------------------------------->
                        <v-col
                        style="width:440px;"
                        cols="12"
                        sm="6">           
                            <v-autocomplete
                            v-model="e12"
                            :items="선택결과"
                            label="선택결과"
                            multiple
                            clearable
                            chips
                            deletable-chips
                            outlined
                            hint="선택한 것들 입니다."
                            persistent-hint
                            ></v-autocomplete>
                        </v-col>
        <!----------------------------------------------------------------------->
                    </v-row>
                </v-container>
            </v-app>
        </div>

        <div class="결과이미지">
          <v-row>
            <v-col
              v-for="n in 15"
              :key="n"
              cols="3"
            >
              <v-img
                :src="`https://picsum.photos/500/300?image=${n * 5 + 10}`"
                :lazy-src="`https://picsum.photos/10/6?image=${n * 5 + 10}`"
                aspect-ratio="1"
                class="grey lighten-2"
              >
                <template v-slot:placeholder>
                  <v-row
                    align="center"
                    justify="center"
                  >
                  </v-row>
                </template>
              </v-img>
            </v-col>
          </v-row>
        </div>

    </div>

</template>

<script>
  export default {
    data () {
      return {
        e7: [],
        e8: [],
        e9: [],
        e10: [],
        e11: [],
        e12: [],

        아티스트: [
          'Alaska', 'American Samoa', 'Arizona',
          'Arkansas', 'California', 'Colorado', 'Connecticut',
          'Delaware', 'District of Columbia', 'Federated States of Micronesia',
          'Florida', 'Georgia', 'Guam', 'Hawaii', 'Idaho'
        ],
        발매연도: [
          '1950', '1960', '1970', '1980',
          '1990', '2000', '2010'
        ],
        장르: [
          '락', '브루스', '브릿팝', '팝',
        ],
        스타일: [
          '얼터너티브', '그런지', '게러지',
        ],
        국가: [
          'KOR', 'UK', 'USA',
        ],
        선택결과 :[
          
        ]
      }
    }
  }
</script>

<style scoped>

.결과이미지 {
  padding:1px 200px 100px 200px;
}

</style>