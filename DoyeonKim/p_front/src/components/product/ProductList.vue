<template>
    <div>
        
        <h4>게시물 목록</h4>




                <v-container>
            <v-data-table :headers="headerTitle"
                    :items="contents"
                    :items-per-page="10"
                    class="elevation-1">
            </v-data-table>
        </v-container>

        
    </div>

 



</template>

         <v-dialog v-model="loginDialog" persistent max-width="500px">
            <template v-slot:activator="{ on }">
                <v-btn color="primary" dark v-on="on">로그인</v-btn>
            </template>
            <v-card>
                <v-card-title>
                    <span class="headline">
                        Log in
                    </span>
                </v-card-title>
                <v-card-text>
                    <v-container grid-list-md>
                        <v-layout wrap>
                            <v-flex xs12>
                                <v-text-field label="Email" v-model="userInfo.email" required flat solo>
                                </v-text-field>
                            </v-flex>
                            <v-flex xs12>
                                <v-text-field label="Password" v-model="userInfo.password"
                                                type="password" required solo>
                                </v-text-field>
                            </v-flex>
                        </v-layout>
                    </v-container>
                </v-card-text>
                <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn color="teal darken-1" text @click="btnLoginClick($event)">
                        취소
                    </v-btn>
                    <v-btn color="teal darken-1" text @click="btnLoginClick($event)">
                        확인
                    </v-btn>
                </v-card-actions>
            </v-card>
        </v-dialog>

<!-- <td align="left">
                    
                    <router-link :to="{ name: 'ProductReadPage',
                                    params: { boardNo: product.productNo.toString() } }">
                        {{ product.product_name }}
                    </router-link>
                </td> -->

<script>
export default {
    name: 'ProductList',
        data() {
        return {
            headerTitle: [
        { text: '번호', value: 'boardNo', width: "70px" },
        { text: '제목', value: 'title', width: "200px" },
        { text: '작성자', value: 'writer', width: "100px" },
    ],
    contents: [
        { boardNo: 1, title: '카메라에 대해', writer: '오이'},
        { boardNo: 2, title: '오늘', writer: '야호', content: '..' },
        { boardNo: 3, title: '다들 무슨', writer: '우우',  },
        { boardNo: 4, title: '배고픈', writer: '도도',  },
        { boardNo: 5, title: '야호', writer: '토마토' },
        { boardNo: 6, title: '월요일 싫어', writer: '토토로'},
        { boardNo: 7, title: '배고프다', writer: '야하'},
        { boardNo: 8, title: '사고싶은게 있는데', writer: '오늘'},
        { boardNo: 9, title: '토요일에', writer: '바다'},
        { boardNo: 10, title: '여행가고싶으신분', writer: '카메라' },
        { boardNo: 11, title: '코로나 언제', writer: '참치',  },
        { boardNo: 12, title: '테스트', writer: '하하',  },
        { boardNo: 13, title: '글', writer: '흐흐' },
        { boardNo: 14, title: '강아지', writer: '키키' },
        { boardNo: 15, title: '고양이', writer: '럼펌' },
    ]
    }
    },
    props: {
        products: {
            type: Array
        }
    }
}
</script>