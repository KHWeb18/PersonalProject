<template>
    <div>
        <!-- 제목 -->
        <div class="title_box">
            <h4 class="page_title">
                <v-icon>mdi-food-apple</v-icon>
                <span>사료 리스트</span>
            </h4>
        </div>
        <!-- 옵션바 -->
        <div class="option_box">
            <div style="transform: scale(0.7);">
                <v-btn-toggle v-model="toggle_exclusive" shaped mandatory>
                    <v-btn>
                        <v-icon>mdi-image</v-icon>
                    </v-btn>
                    <v-btn>
                        <v-icon>mdi-format-align-justify</v-icon>
                    </v-btn>
                </v-btn-toggle>
            </div>
        </div>
        <!-- 검색창 -->
        <div class="searching_box">
            <div class="searching_bar">
                <v-icon style="margin:10px">mdi-magnify</v-icon>
                <span>
                    <input type="text" class="searching" placeholder="검색어를 입력해주세요" v-model="word"
                    @keyup.enter="searching(word)">
                </span>
            </div>
        </div>
        <div class="searching_message_box" v-show="searchinOn">
            <div class="searching_message">
                <div><b>{{ word }}</b> 검색 결과</div>
                <div><p>&nbsp;&nbsp;사료가 <b>{{this.searchingResult.length}}</b>개 검색되었습니다.</p></div>
            </div>
        </div>
        <!-- 푸드리스트 -->
        <v-container class="food01" v-show="!toggle_exclusive">
            <div v-show="!searchinOn">
                <v-container class="food_box">
                    <div v-for="mob in paginatedData2" :key="mob.foodNo" class="item">
                        <v-card class="mx-auto">
                            <v-img :src="ImgRequest(mob.foodNo)" height="200px"></v-img>
                            <div class="btn-plus"><span draggable="false"><v-icon color="white">mdi-image-plus</v-icon></span></div>
                            <v-dialog width="700px">
                                <template v-slot:activator="{ on }">
                                    <div class="btn-plus2" v-on="on"><span draggable="false"></span></div>
                                </template>
                                <v-card>
                                    <v-img :src="ImgRequest(mob.foodNo)"></v-img>
                                </v-card>
                            </v-dialog>
                            <v-card-title>
                                {{mob.foodNo}}. 
                                {{mob.name}}
                            </v-card-title>
                            <v-card-subtitle style="height:187px">
                                <br>
                                    {{ mob.introduce }}
                                <br>
                            </v-card-subtitle>
                            <v-card-actions>
                                <v-dialog width="600px">
                                    <template v-slot:activator="{ on }">
                                        <p v-show="checkAFFO(mob) == '인증'">
                                            <v-btn v-on="on" style="font-weight:bold; font-size:15px; color:#039BE5;" 
                                            text="text">{{checkAFFO(mob)}}</v-btn></p>
                                        <p v-show="checkAFFO(mob) == '미달'">
                                            <v-btn v-bind="attrs" v-on="on" style="font-weight:bold; font-size:15px; color:#DD2C00;" 
                                            text="text">{{checkAFFO(mob)}}</v-btn></p>
                                    </template>
                                    <v-card>
                                        <v-card-title>
                                            <span class="text-h5">AAFCO 인증이란 무엇인가요?</span>
                                        </v-card-title>
                                        <v-card-text>
                                            미국사료협회 AAFCO(Association of American Feeding Control Officials)는 사료 시장에 통용되는 기준을 제시하는 민간기관 으로, 미국을 넘어 범세계적인 영향력을 갖고 있습니다.<br>
                                            AAFCO, 아프코, 사료 기준, 사료 기호성, 사료 제조 원재료, 첨가물, 사료협회, 영양소, 기준치, 강아지, 고양이 동물 사료에 쓰이는 원재료의 종류와 명칭, 제조 관련 규제, 제품 표기 사항, 영양소 기준치 등을 제시 함으로써 업계 관계자들이 통일된 규칙을 따르고, 그 내용이 법률에 일관적으로 반영되는 것이 AAFCO의 주요 역할이에요.<br>
                                            AAFCO는 매년 두 차례의 정기 총회를 통해 동물 사료의 제조·유통 관련 이슈와 안건을 검토하고, 이를 바탕으로 업계 종사자 대상의 교육도 진행하지요.
                                            위 내용을 문서화하여 매년 10월 공식 간행물을 발행하는데, 여기에 강아지와 고양이의 주식(主食, 가끔 먹는 간식이 아닌 매일 먹는 밥)이 지켜야 할 최소 기준치도 있어요.<br>
                                            여기서 중요한 것은 아프코 기준이 최선이 아닌 최소한의 기준, 즉 영양 결핍이 발생하지 않기 위한 기본 일 뿐이라는 점!<br>
                                        </v-card-text>
                                    </v-card>
                                </v-dialog>
                                <v-dialog width="600px">
                                    <template v-slot:activator="{ on, attrs }">
                                        <v-btn v-bind="attrs" v-on="on" color="purple" text="text">
                                            {{mob.gradeSelect}}</v-btn>
                                    </template>
                                    <v-card>
                                        <v-card-title>
                                            <span class="text-h5">사료 등급은 어떻게 이루어져있나요?</span>
                                        </v-card-title>
                                        <v-card-text>
                                            실제로 사료등급은 사료 업계나 소비자가 사용하는 용어로 공식적인 것이 아닙니다.<br>
                                            법적으로 정의를 하거나 사용 여부를 결정한 게 아니어서 어떤 제조사든지 사용된 원재료에 관계 없이 홀리스틱이란 용어를 사용할 수 있으니 참고로만 알아두시고 맹신하지는 마시길 바랍니다<br>
                                        </v-card-text>
                                    </v-card>
                                </v-dialog>
                                <v-dialog width="600px">
                                    <template v-slot:activator="{ on, attrs }">
                                        <v-btn v-bind="attrs" v-on="on"  color="red lighten-1" text="text">
                                            {{mob.ageSelect}}</v-btn>
                                        </template>
                                    <v-card>
                                        <v-card-title>
                                            <span class="text-h5">고양이의 연령별 특징은 어떻게 되나요?</span>
                                        </v-card-title>
                                        <v-card-text>
                                            <p class="title">자묘시기 (생후 6개월까지)</p>
                                            자묘 시기에는 고양이의 성격을 결정지을 수 있는 사회화 시기를 포함하기 때문에 가장 많이 신경을 써줘야 할 때입니다.<br>
                                            새끼 고양이가 장난감에 익숙해지고, 할 수 있는 것과 할 수 없는 것에 대해 알고, 여러가지 주의점들을 익히도록 해야합니다.<br>
                                            또한 이동장, 자동차, 병원 등의 낯선 환경에도 적응할 수 있도록 도와줘야 합니다.<br><br>
                                            고양이의 원활한 배뇨 활동을 위해 화장실의 위치와 갯수, 크기 등에 신경써줘야하는데, 고양이 몸길이의 1.5배 정도가 적당합니다.<br>
                                            성묘가 됐을때도 쓸 수 있도록 여유있는 크기의 화장실을 선택하는 것이 좋습니다.<br><br>
                                            고양이가 선호하는 사료의 종류와 양을 파악하기 위해서 건사료, 습식사료, 생식 등 다양한 먹이를 급여해보고, 개보다 취약한 고양이의 치아 관리를 위해 양치질에 익숙해 질 수 있도록 지속적으로 관리해줍니다.<br><br>
                                            또한 종합백신과 광견병백신 접종, 구충과 심장사상충 예방 접종을 시작해야합니다. 몸이 약한 자묘 시기에는 범백(고양이 백혈병 바이러스)에 걸리기 쉬우므로 예방 접종 전 범백 검사를 필수로 진행하는 것이 좋습니다.<br><br>
                                            
                                            <p class="title">청년기와 성묘시기 (생후 7개월~10년 사이)</p>
                                            청년기(7개월~2년 사이)에는 중성화 수술이 이루어지는 시기이므로, 수술 이후 식사량 관리를 통해 비만을 예방해야합니다.<br>
                                            성장이 다 끝나는 생후 1년 즈음에는 화장실 크기를 다시 확인해서 좁게 느껴진다면 더 큰것으로 바꿔줘야합니다.<br>
                                            정기적인 구충과 심장사상충 예방도 꾸준히 해야합니다.<br><br>
                                            생후 3~5년 사이의 성묘 시기는 가장 건강하고 활동이 왕성할 때입니다.<br>
                                            고양이의 본성인 사냥과 탐험 본능이 강해지기 때문에 실내에서 키우는 경우 캣타워나 스크래처, 장난감 등으로 호기심 있는 주거 환경을 만들어 주는것이 좋습니다.<br><br>
                                            생후 7~10년 사이 고양이는 사람 나이로 4~50대에 해당하며, 건강에 문제가 생기기 쉬워집니다.<br>
                                            가능하다면 6개월이나 1년에 한번씩 동물병원에서 정기검진을 받는것이 바람직합니다.<br>
                                            이때부터는 관절염이 발생하기 시작하는 나이기 때문에 고양이가 주로 사용하는 밥그릇, 화장실, 잠자리에 접근이 용이한지, 너무 높은곳에 있지는 않은지 확인해줍니다.<br><br>
                                            아파도 아픈티를 잘 내지 않는 고양이들의 본성을 고려해서 수면시간, 활동량, 운동성, 행동 변화 등을 주의깊게 관찰해야하며, 갑자기 살이 찌거나 반대로 살이 빠지는 경우 갑상샘 질환을 의심해 볼 수도 있으니 검진을 받을 필요가 있습니다.<br><br>

                                            <p class="title">노령묘 시기 (11세 이상)</p>
                                            관절염이 쉽게 발생하는 나이이므로 고양이의 활동량이 급격하게 줄었다면 통증 때문이 아닌지 살펴봐야합니다.<br>
                                            충분한 급수가 되지 않으면 노령묘에게 대표적으로 발생하는 질환인 만성신부전, 갑상샘기능항진증, 당뇨가 생길 수 있기 때문에 음수량과 배뇨량이 충분한지 주의 깊게 관찰하고, 평소와 다른경우 동물병원에 내원해서 검사를 받아야합니다.<br><br>
                                            노령에 접어들면서 구강종양의 발생빈도가 높아지며, 씹거나 삼키는걸 잘 못하거나 지속적으로 침을 흘린다면 구강검진을 반드시 받아야합니다.<br>
                                            복합적이고 다양한 질환들이 발생하는 시기이니만큼 연령과 이전 병력 등을 고려한 보조제 복용도 필요하므로 수의사와 상담을 받아보는 것이 좋습니다.<br><br>
                                            15세가 넘어서는 치매에 의한 인지기능 장애가 발생할 수 있습니다.<br>
                                            이유 없이 벽만 쳐다보고 빙글빙글 돌거나, 바닥에 있는 음식을 먹지 못하거나, 좁은 공간에 들어가서 스스로 나오지 못하는 경우 치매 가능성을 고려해야 합니다.<br><br>
                                            고양이는 근본이 육식동물이므로 본능적으로 아픔이나 고통을 겉으로 표현하지 않습니다.<br>
                                            그래서 심각하게 아파서 식욕이 줄거나 구토 및 설사를 하기 전에는 미처 발견하기 어렵습니다.<br>
                                            반려인은 고양이의 변화를 관찰하고 정기적인 건강검진으로 조기에 발견하는 노력이 필요합니다.<br>

                                        </v-card-text>
                                    </v-card>
                                </v-dialog>
                                <v-spacer></v-spacer>
                                <v-btn icon="icon" @click="show = !show">
                                    <v-icon>{{ show ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon></v-btn>
                            </v-card-actions>
                            <v-expand-transition>
                                <div v-show="show">
                                    <v-divider></v-divider>
                                    <v-dialog width="600px">
                                        <template v-slot:activator="{ on, attrs }">
                                            <v-card-text v-bind="attrs" v-on="on" >
                                                <p>
                                                    <b>조단백</b>: {{ mob.protein }}% 이상 &nbsp;&nbsp;<b>수분</b>: {{ mob.moisture }}% 이상</p>
                                                <p>
                                                    <b>조지방</b>: {{ mob.fat }}% 이상 &nbsp;&nbsp;<b>칼슘</b>: {{ mob.calcium }}% 이상</p>
                                                <p>
                                                    <b>조회분</b>: {{ mob.mineral }}% 이상 &nbsp;&nbsp;<b>인</b>: {{ mob.phosphorus }}% 이상</p>
                                                <p>
                                                    <b>조섬유</b>: {{ mob.fiber }}% 이상 &nbsp;&nbsp;<b>에너지</b>: {{ mob.kcal }} kcal/kg 이상</p>
                                                <p v-show="checkAFFO(mob) == '인증'">
                                                    <b>AAFCO</b>: <b style="font-weight:bold; font-size:15px; color:#039BE5;">기준 {{checkAFFO(mob)}}</b></p>
                                                <p v-show="checkAFFO(mob) == '미달'">
                                                    <b>AAFCO</b>: <b style="font-weight:bold; font-size:15px; color:#DD2C00;">기준 {{checkAFFO(mob)}}</b></p>    
                                            </v-card-text>
                                            </template>
                                        <v-card>
                                            <v-card-title>
                                                <span class="text-h5">사료 등급은 어떻게 이루어져있나요?</span>
                                            </v-card-title>
                                            <v-card-text>
                                                <p class="title">조단백, 조지방, 조섬유, 조회분의 ‘조’의 의미는?</p>
                                                반려동물이 먹는 모든 식품은 사료관리법에 의해 규제되어 있어요!<br>
                                                여러 사료 중 7대 영양성분인 조단백, 조지방, 조섬유, 조회분, 칼슘 , 인, 수분의 함량은 사료에 꼭 표기가 되어있죠.<br>
                                                이렇게 사료의 성분표를 보다 보니 단밸질이 조단백, 지방이 조지방 등 영양소 앞에 ‘조’가 붙어있는 함량을 볼 수 있었습니다.<br>
                                                ‘조’는 거칠다는 의미로 영양소 자체가 순수하지 못하고 다른 성분들이 함유된 것을 뜻하며, 성분함량으로 볼 수 있습니다.<br><br>
                                                
                                                <p class="title">조단백</p>
                                                단백질은 몸을 구성하는 성분일 뿐만 아니라 에너지원으로서도 중요한 역할을 하고 있습니다.<br>
                                                사료를 보실 때 꼭 체크해야 되는 정보로서 강아지의 경우 18% 이상 고양이의 경우 26% 이상 포함되어 있어야 충분한 영양을 제공할 수 있다고 합니다.<br>
                                                (생후 1년~6년 기준)<br><br>

                                                <p class="title">조지방</p>
                                                체내에서 다양한 생리작용에 관여하고 다양한 비타민의 성분을 운반하게 해주는 중요한 영양소 중 하나입니다.<br><br>
                                                1년 미만 : 성장 과정 중 지능과 학습에 영향을 줍니다.<br>
                                                1~6년 : 다양한 비타민을 수송하는 역할을 합니다.<br>
                                                7년 이상 : 소화력이 떨어져 과다 섭취 시 위험합니다.<br><br>
                                                
                                                <p class="title">조섬유</p>
                                                물, 묽은 산, 알코올, 에테르에 녹지 않는 물질로 몸속에서 칼로리 원으로 이용할 수 없는 탄수화물을 말합니다.<br>
                                                조섬유는 몸속에서 소화가 되지 않기 때문에 영양소로 취급하지 않지만 다른 음식물을 통과할 수 있도록 도와주는 역할과 당이 흡수되는 속도를 조절해 혈당 상승을 억제하는 역할을 하고 있기 때문에 중요하게 체크해야 되는 성분입니다.<br>
                                                <b>TIP</b><br>
                                                다이어트가 필요한 반려동물의 경우 일반사료에 비해 조지방이 낮고 조섬유가 높은 사료를 선택하셔야 합니다.<br><br>
                                                
                                                <p class="title">조회분</p>
                                                550℃로 가열하여 유기물을 연소시킨 후에 남아 있는 성분을 말하는 것으로 이것을 무기질이라고 합니다.<br>
                                                칼슘, 칼륨, 인, 마그네슘, 철을 묶어서 말하며, 몸을 구성하기도 하고 기능을 조절하는 중요한 역할을 하고 있습니다.<br>
                                            </v-card-text>
                                        </v-card>
                                    </v-dialog>
                                </div>
                            </v-expand-transition>
                        </v-card>
                    </div>
                    <v-container style="margin-top:20px;">
                    <div class="text-center">
                        <v-pagination class="btn_pagination" v-model="pageNum2" :length="pageCount2"></v-pagination>
                    </div>
                    </v-container>
                </v-container>
            </div>
            <!-- 푸드리스트(검색결과) -->
            <div v-show="searchinOn">
                <v-container class="food_box">
                    <div v-for="mob in paginatedDataS" :key="mob.foodNo" class="item">
                        <v-card class="mx-auto">
                            <v-img :src="ImgRequest(mob.foodNo)" height="200px"></v-img>
                            <div class="btn-plus"><span draggable="false"><v-icon color="white">mdi-image-plus</v-icon></span></div>
                            <v-dialog width="700px">
                                <template v-slot:activator="{ on }">
                                    <div class="btn-plus2" v-on="on"><span draggable="false"></span></div>
                                </template>
                                <v-card>
                                    <v-img :src="ImgRequest(mob.foodNo)"></v-img>
                                </v-card>
                            </v-dialog>
                            <v-card-title>
                                {{mob.foodNo}}. 
                                {{mob.name}}
                            </v-card-title>
                            <v-card-subtitle style="height:187px">
                                <br>
                                    {{ mob.introduce }}
                                <br>
                            </v-card-subtitle>
                            <v-card-actions>
                                <v-dialog width="600px">
                                    <template v-slot:activator="{ on, attrs }">
                                        <p v-show="checkAFFO(mob) == '인증'">
                                            <v-btn v-bind="attrs" v-on="on" style="font-weight:bold; font-size:15px; color:#039BE5;" 
                                            text="text">{{checkAFFO(mob)}}</v-btn></p>
                                        <p v-show="checkAFFO(mob) == '미달'">
                                            <v-btn v-bind="attrs" v-on="on" style="font-weight:bold; font-size:15px; color:#DD2C00;" 
                                            text="text">{{checkAFFO(mob)}}</v-btn></p>
                                    </template>
                                    <v-card>
                                        <v-card-title>
                                            <span class="text-h5">AAFCO 인증이란 무엇인가요?</span>
                                        </v-card-title>
                                        <v-card-text>
                                            미국사료협회 AAFCO(Association of American Feeding Control Officials)는 사료 시장에 통용되는 기준을 제시하는 민간기관 으로, 미국을 넘어 범세계적인 영향력을 갖고 있습니다.<br>
                                            AAFCO, 아프코, 사료 기준, 사료 기호성, 사료 제조 원재료, 첨가물, 사료협회, 영양소, 기준치, 강아지, 고양이 동물 사료에 쓰이는 원재료의 종류와 명칭, 제조 관련 규제, 제품 표기 사항, 영양소 기준치 등을 제시 함으로써 업계 관계자들이 통일된 규칙을 따르고, 그 내용이 법률에 일관적으로 반영되는 것이 AAFCO의 주요 역할이에요.<br>
                                            AAFCO는 매년 두 차례의 정기 총회를 통해 동물 사료의 제조·유통 관련 이슈와 안건을 검토하고, 이를 바탕으로 업계 종사자 대상의 교육도 진행하지요.
                                            위 내용을 문서화하여 매년 10월 공식 간행물을 발행하는데, 여기에 강아지와 고양이의 주식(主食, 가끔 먹는 간식이 아닌 매일 먹는 밥)이 지켜야 할 최소 기준치도 있어요.<br>
                                            여기서 중요한 것은 아프코 기준이 최선이 아닌 최소한의 기준, 즉 영양 결핍이 발생하지 않기 위한 기본 일 뿐이라는 점!<br>
                                        </v-card-text>
                                    </v-card>
                                </v-dialog>
                                <v-dialog width="600px">
                                    <template v-slot:activator="{ on, attrs }">
                                        <v-btn v-bind="attrs" v-on="on" color="purple" text="text">
                                            {{mob.gradeSelect}}</v-btn>
                                    </template>
                                    <v-card>
                                        <v-card-title>
                                            <span class="text-h5">사료 등급은 어떻게 이루어져있나요?</span>
                                        </v-card-title>
                                        <v-card-text>
                                            실제로 사료등급은 사료 업계나 소비자가 사용하는 용어로 공식적인 것이 아닙니다.<br>
                                            법적으로 정의를 하거나 사용 여부를 결정한 게 아니어서 어떤 제조사든지 사용된 원재료에 관계 없이 홀리스틱이란 용어를 사용할 수 있으니 참고로만 알아두시고 맹신하지는 마시길 바랍니다<br>
                                        </v-card-text>
                                    </v-card>
                                </v-dialog>
                                <v-dialog width="600px">
                                    <template v-slot:activator="{ on, attrs }">
                                        <v-btn v-bind="attrs" v-on="on"  color="red lighten-1" text="text">
                                            {{mob.ageSelect}}</v-btn>
                                        </template>
                                    <v-card>
                                        <v-card-title>
                                            <span class="text-h5">고양이의 연령별 특징은 어떻게 되나요?</span>
                                        </v-card-title>
                                        <v-card-text>
                                            <p class="title">자묘시기 (생후 6개월까지)</p>
                                            자묘 시기에는 고양이의 성격을 결정지을 수 있는 사회화 시기를 포함하기 때문에 가장 많이 신경을 써줘야 할 때입니다.<br>
                                            새끼 고양이가 장난감에 익숙해지고, 할 수 있는 것과 할 수 없는 것에 대해 알고, 여러가지 주의점들을 익히도록 해야합니다.<br>
                                            또한 이동장, 자동차, 병원 등의 낯선 환경에도 적응할 수 있도록 도와줘야 합니다.<br><br>
                                            고양이의 원활한 배뇨 활동을 위해 화장실의 위치와 갯수, 크기 등에 신경써줘야하는데, 고양이 몸길이의 1.5배 정도가 적당합니다.<br>
                                            성묘가 됐을때도 쓸 수 있도록 여유있는 크기의 화장실을 선택하는 것이 좋습니다.<br><br>
                                            고양이가 선호하는 사료의 종류와 양을 파악하기 위해서 건사료, 습식사료, 생식 등 다양한 먹이를 급여해보고, 개보다 취약한 고양이의 치아 관리를 위해 양치질에 익숙해 질 수 있도록 지속적으로 관리해줍니다.<br><br>
                                            또한 종합백신과 광견병백신 접종, 구충과 심장사상충 예방 접종을 시작해야합니다. 몸이 약한 자묘 시기에는 범백(고양이 백혈병 바이러스)에 걸리기 쉬우므로 예방 접종 전 범백 검사를 필수로 진행하는 것이 좋습니다.<br><br>
                                            
                                            <p class="title">청년기와 성묘시기 (생후 7개월~10년 사이)</p>
                                            청년기(7개월~2년 사이)에는 중성화 수술이 이루어지는 시기이므로, 수술 이후 식사량 관리를 통해 비만을 예방해야합니다.<br>
                                            성장이 다 끝나는 생후 1년 즈음에는 화장실 크기를 다시 확인해서 좁게 느껴진다면 더 큰것으로 바꿔줘야합니다.<br>
                                            정기적인 구충과 심장사상충 예방도 꾸준히 해야합니다.<br><br>
                                            생후 3~5년 사이의 성묘 시기는 가장 건강하고 활동이 왕성할 때입니다.<br>
                                            고양이의 본성인 사냥과 탐험 본능이 강해지기 때문에 실내에서 키우는 경우 캣타워나 스크래처, 장난감 등으로 호기심 있는 주거 환경을 만들어 주는것이 좋습니다.<br><br>
                                            생후 7~10년 사이 고양이는 사람 나이로 4~50대에 해당하며, 건강에 문제가 생기기 쉬워집니다.<br>
                                            가능하다면 6개월이나 1년에 한번씩 동물병원에서 정기검진을 받는것이 바람직합니다.<br>
                                            이때부터는 관절염이 발생하기 시작하는 나이기 때문에 고양이가 주로 사용하는 밥그릇, 화장실, 잠자리에 접근이 용이한지, 너무 높은곳에 있지는 않은지 확인해줍니다.<br><br>
                                            아파도 아픈티를 잘 내지 않는 고양이들의 본성을 고려해서 수면시간, 활동량, 운동성, 행동 변화 등을 주의깊게 관찰해야하며, 갑자기 살이 찌거나 반대로 살이 빠지는 경우 갑상샘 질환을 의심해 볼 수도 있으니 검진을 받을 필요가 있습니다.<br><br>

                                            <p class="title">노령묘 시기 (11세 이상)</p>
                                            관절염이 쉽게 발생하는 나이이므로 고양이의 활동량이 급격하게 줄었다면 통증 때문이 아닌지 살펴봐야합니다.<br>
                                            충분한 급수가 되지 않으면 노령묘에게 대표적으로 발생하는 질환인 만성신부전, 갑상샘기능항진증, 당뇨가 생길 수 있기 때문에 음수량과 배뇨량이 충분한지 주의 깊게 관찰하고, 평소와 다른경우 동물병원에 내원해서 검사를 받아야합니다.<br><br>
                                            노령에 접어들면서 구강종양의 발생빈도가 높아지며, 씹거나 삼키는걸 잘 못하거나 지속적으로 침을 흘린다면 구강검진을 반드시 받아야합니다.<br>
                                            복합적이고 다양한 질환들이 발생하는 시기이니만큼 연령과 이전 병력 등을 고려한 보조제 복용도 필요하므로 수의사와 상담을 받아보는 것이 좋습니다.<br><br>
                                            15세가 넘어서는 치매에 의한 인지기능 장애가 발생할 수 있습니다.<br>
                                            이유 없이 벽만 쳐다보고 빙글빙글 돌거나, 바닥에 있는 음식을 먹지 못하거나, 좁은 공간에 들어가서 스스로 나오지 못하는 경우 치매 가능성을 고려해야 합니다.<br><br>
                                            고양이는 근본이 육식동물이므로 본능적으로 아픔이나 고통을 겉으로 표현하지 않습니다.<br>
                                            그래서 심각하게 아파서 식욕이 줄거나 구토 및 설사를 하기 전에는 미처 발견하기 어렵습니다.<br>
                                            반려인은 고양이의 변화를 관찰하고 정기적인 건강검진으로 조기에 발견하는 노력이 필요합니다.<br>

                                        </v-card-text>
                                    </v-card>
                                </v-dialog>
                                <v-spacer></v-spacer>
                                <v-btn icon="icon" @click="show = !show">
                                    <v-icon>{{ show ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon></v-btn>
                            </v-card-actions>
                            <v-expand-transition>
                                <div v-show="show">
                                    <v-divider></v-divider>
                                    <v-dialog width="600px">
                                        <template v-slot:activator="{ on, attrs }">
                                            <v-card-text v-bind="attrs" v-on="on" >
                                                <p>
                                                    <b>조단백</b>: {{ mob.protein }}% 이상 &nbsp;&nbsp;<b>수분</b>: {{ mob.moisture }}% 이상</p>
                                                <p>
                                                    <b>조지방</b>: {{ mob.fat }}% 이상 &nbsp;&nbsp;<b>칼슘</b>: {{ mob.calcium }}% 이상</p>
                                                <p>
                                                    <b>조회분</b>: {{ mob.mineral }}% 이상 &nbsp;&nbsp;<b>인</b>: {{ mob.phosphorus }}% 이상</p>
                                                <p>
                                                    <b>조섬유</b>: {{ mob.fiber }}% 이상 &nbsp;&nbsp;<b>에너지</b>: {{ mob.kcal }} kcal/kg 이상</p>
                                                <p v-show="checkAFFO(mob) == '인증'">
                                                    <b>AAFCO</b>: <b style="font-weight:bold; font-size:15px; color:#039BE5;">기준 {{checkAFFO(mob)}}</b></p>
                                                <p v-show="checkAFFO(mob) == '미달'">
                                                    <b>AAFCO</b>: <b style="font-weight:bold; font-size:15px; color:#DD2C00;">기준 {{checkAFFO(mob)}}</b></p>    
                                            </v-card-text>
                                            </template>
                                        <v-card>
                                            <v-card-title>
                                                <span class="text-h5">사료 등급은 어떻게 이루어져있나요?</span>
                                            </v-card-title>
                                            <v-card-text>
                                                <p class="title">조단백, 조지방, 조섬유, 조회분의 ‘조’의 의미는?</p>
                                                반려동물이 먹는 모든 식품은 사료관리법에 의해 규제되어 있어요!<br>
                                                여러 사료 중 7대 영양성분인 조단백, 조지방, 조섬유, 조회분, 칼슘 , 인, 수분의 함량은 사료에 꼭 표기가 되어있죠.<br>
                                                이렇게 사료의 성분표를 보다 보니 단밸질이 조단백, 지방이 조지방 등 영양소 앞에 ‘조’가 붙어있는 함량을 볼 수 있었습니다.<br>
                                                ‘조’는 거칠다는 의미로 영양소 자체가 순수하지 못하고 다른 성분들이 함유된 것을 뜻하며, 성분함량으로 볼 수 있습니다.<br><br>
                                                
                                                <p class="title">조단백</p>
                                                단백질은 몸을 구성하는 성분일 뿐만 아니라 에너지원으로서도 중요한 역할을 하고 있습니다.<br>
                                                사료를 보실 때 꼭 체크해야 되는 정보로서 강아지의 경우 18% 이상 고양이의 경우 26% 이상 포함되어 있어야 충분한 영양을 제공할 수 있다고 합니다.<br>
                                                (생후 1년~6년 기준)<br><br>

                                                <p class="title">조지방</p>
                                                체내에서 다양한 생리작용에 관여하고 다양한 비타민의 성분을 운반하게 해주는 중요한 영양소 중 하나입니다.<br><br>
                                                1년 미만 : 성장 과정 중 지능과 학습에 영향을 줍니다.<br>
                                                1~6년 : 다양한 비타민을 수송하는 역할을 합니다.<br>
                                                7년 이상 : 소화력이 떨어져 과다 섭취 시 위험합니다.<br><br>
                                                
                                                <p class="title">조섬유</p>
                                                물, 묽은 산, 알코올, 에테르에 녹지 않는 물질로 몸속에서 칼로리 원으로 이용할 수 없는 탄수화물을 말합니다.<br>
                                                조섬유는 몸속에서 소화가 되지 않기 때문에 영양소로 취급하지 않지만 다른 음식물을 통과할 수 있도록 도와주는 역할과 당이 흡수되는 속도를 조절해 혈당 상승을 억제하는 역할을 하고 있기 때문에 중요하게 체크해야 되는 성분입니다.<br>
                                                <b>TIP</b><br>
                                                다이어트가 필요한 반려동물의 경우 일반사료에 비해 조지방이 낮고 조섬유가 높은 사료를 선택하셔야 합니다.<br><br>
                                                
                                                <p class="title">조회분</p>
                                                550℃로 가열하여 유기물을 연소시킨 후에 남아 있는 성분을 말하는 것으로 이것을 무기질이라고 합니다.<br>
                                                칼슘, 칼륨, 인, 마그네슘, 철을 묶어서 말하며, 몸을 구성하기도 하고 기능을 조절하는 중요한 역할을 하고 있습니다.<br>
                                            </v-card-text>
                                        </v-card>
                                    </v-dialog>
                                </div>
                            </v-expand-transition>
                        </v-card>
                    </div>
                    <v-container style="margin-top:20px;max-width:1300px;">
                        <div class="text-center">
                            <v-pagination class="btn_pagination" v-model="pageNumS" :length="pageCountS"></v-pagination>
                        </div>
                    </v-container>
                </v-container>
            </div>
        </v-container>
        <br>
        <div v-show="!searchinOn">
            <div class="data_table_box"  v-show="toggle_exclusive">
                <v-data-table
                    :headers="headers"
                    :items="foods"
                    :items-per-page="5"
                    :sort-by="[]"
                    :sort-desc="[false, true]"
                    multi-sort
                    class="elevation-1">
                    <template v-slot:top>
                        <v-toolbar flat="flat">
                            <v-toolbar-title>사료 목록</v-toolbar-title>
                            <v-spacer></v-spacer>
                        </v-toolbar>
                    </template>
                    <template v-slot:expanded-item="{ headers, item }">
                        <td :colspan="headers.length">
                            {{ item.introduce }}
                        </td>
                    </template>
                </v-data-table>
            </div>
        </div>
        <div v-show="searchinOn">
            <div class="data_table_box"  v-show="toggle_exclusive">
                <v-data-table
                    :headers="headers"
                    :items="searchingResult"
                    :items-per-page="5"
                    :sort-by="[]"
                    :sort-desc="[false, true]"
                    multi-sort
                    class="elevation-1">
                    <template v-slot:top>
                        <v-toolbar flat="flat">
                            <v-toolbar-title>사료 목록</v-toolbar-title>
                            <v-spacer></v-spacer>
                        </v-toolbar>
                    </template>
                    <template v-slot:expanded-item="{ headers, item }">
                        <td :colspan="headers.length">
                            {{ item.introduce }}
                        </td>
                    </template>
                </v-data-table>
            </div>
        </div>

        <v-simple-table v-show="this.$store.state.isAuth == true">
            <template>
                <thead>
                    <tr>
                        <th class="text-center" width="64">No.</th>
                        <th class="text-center">제목</th>
                        <th class="text-center">등급</th>
                        <th class="text-center">글루텐여부</th>
                    </tr>
                    <tr v-if="!foods || (Array.isArray(foods) && foods.length === 0)">
                        <td colspan="4">
                            현재 등록된 게시물이 없습니다!
                        </td>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="food of foods" :key="food.foodNo">
                        <td style="text-align:center">{{ food.foodNo }}</td>
                        <td>
                            <!-- <router-link
                                :to="{ name: 'FoodReadPage',                                
                                                        params: { foodNo: food.foodNo.toString() } }"> -->
                                <div @click="test(food.foodNo)">{{ food.name }}</div>
                            <!-- </router-link> -->
                        </td>
                        <td style="text-align:center">{{ food.gradeSelect }}</td>
                        <td style="text-align:center">{{ food.glutenFree }}</td>
                    </tr>
                </tbody>
            </template>
        </v-simple-table>

        
        
    </div>
</template>

<script>
    export default {
        name: 'FoodList',
        props: {
            foods: {
                type: Array
            },
            pageSize2: {
                type: Number,
                required: false,
                default: 8
            }
        },
        data() {
            return {
                alert: true,
                show: false,
                pageNum2: 1,                
                pageNumS: 1,
                expanded: [],
                singleExpand: false,
                toggle_exclusive: [],
                searchingResult: [],
                searchinOn: false,
                word: '',
                headers: [
                    {
                        text: '사료명',
                        align: 'center',
                        width: '200',
                        sortable: false,
                        value: 'name'
                    }, {
                        text: '등급',
                        value: 'gradeSelect',
                        align: 'center'
                    }, {
                        text: '글루텐',
                        value: 'glutenFree',
                        align: 'center'
                    }, {
                        text: '연령',
                        value: 'ageSelect',
                        align: 'center'
                    }, {
                        text: '조단백(%)',
                        value: 'protein',
                        align: 'center'
                    }, {
                        text: '조지방(%)',
                        value: 'fat',
                        align: 'center'
                    }, {
                        text: '조회분(%)',
                        value: 'mineral',
                        align: 'center'
                    }, {
                        text: '조섬유(%)',
                        value: 'fiber',
                        align: 'center'
                    }, {
                        text: '수분(%)',
                        value: 'moisture',
                        align: 'center'
                    }, {
                        text: '칼슘(%)',
                        value: 'calcium',
                        align: 'center'
                    }, {
                        text: '인(%)',
                        value: 'phosphorus',
                        align: 'center'
                    }, {
                        text: '대사에너지(kcal/kg)',
                        value: 'kcal',
                        align: 'center'
                    }
                ]
            }
        },
        watch: {
            word(newVal) {
                if(newVal == '') {
                    setTimeout(() => {
                        this.searchinOn = false
                        }, 200)
                }
            }
        },
        methods: {
            nextPage2() {
                this.pageNum2 += 1;
            },
            prevPage2() {
                this.pageNum2 -= 1;
            },
            nextPageS() {
                this.pageNumS += 1;
            },
            prevPageS() {
                this.pageNumS -= 1;
            },
            ImgRequest(foodNo) {
            try {
                return require(`../../../../../Mini/Images/Food/${foodNo}.gif`
                )
            } catch (e) {
                return require(`@/assets/logo.png`)
                }
            },
            checkAFFO(mob) {
                if (mob.protein <= 29) {
                    return '미달'
                } else if (mob.fat <= 10) {
                    return '미달'
                } else if (mob.mineral < 2.6) {
                    return '미달'
                } else {
                    return '인증'
                }                
            },
            searching () {
                var lists = this.foods

                this.searchingResult = []
                for(var i = 0; i < lists.length; i++){
                    if(lists[i].name.includes(this.word)){
                        this.searchingResult.push(lists[i])
                    }
                }
                console.log('searching 결과 : ' + this.searchingResult)
                console.log('0번 값은? : ' + this.searchingResult[0])
                this.searchinOn = true
                
                if (this.word == '') {
                    this.searchinOn = false
                }
            },
            test(data) {
                console.log(data)
                this.$store.state.temp = data
                this.$router.push({ name: 'FoodReadPage' })
            }
            
        },
        computed: {
            pageCount2() {
                let listLength = this.foods.length, // 길이
                    listSize = this.pageSize2,
                    page = Math.floor(listLength / listSize);
                if (listLength % listSize > 0) 
                    page += 1;
                    return page;
            },
            paginatedData2() {
                const start = (this.pageNum2 - 1) * this.pageSize2,
                    end = start + this.pageSize2;
                return this
                    .foods
                    .slice(start, end);
            },
            pageCountS() {
                let listLength = this.searchingResult.length, // 길이
                    listSize = this.pageSize2,
                    page = Math.floor(listLength / listSize);
                if (listLength % listSize > 0) 
                    page += 1;
                return page;
            },
            paginatedDataS() {
                const start = (this.pageNumS - 1) * this.pageSize2,
                    end = start + this.pageSize2;
                return this
                    .searchingResult
                    .slice(start, end);
            },
        }
    }
</script>

<style scoped="scoped" > 
.mx-auto:hover {
    transform: translate3d(0px, -10px, 0px);
    box-shadow: 10px 17px 40px 0 rgb(0 0 0 / 45%);
    transition: all 1s ease;
}
.data_table_box {
    text-align: center;
    width: 70vw;
}
.food01 {
    display: inline-block;
    margin: 0;
    padding: 0;
    width: 70vw;    
    min-width: 1280px;
    max-width: 1300px;
}
.food_box {
    position: relative;
    margin: 0;
    padding: 0;
    width: 70vw;
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
}
.item {
    margin: 10px;
    width: 300px;
}
.btn_pagination {
    background-color: transparent;
    box-shadow: none;
}
p {
    margin: 0;
}
.v-btn.v-btn--text.theme--light.v-size--default {
    padding: 0;
}
.v-card__actions {
    padding: 4px;
}


.option_box {
    display: flex;
    justify-content: flex-end;
    width: 70vw;
    max-width: 1300px;
}
.searching_box {    
    height: 50px;
}
.searching_bar {
    display: flex;
    justify-content: row;
    height: 40px;
    width:70vw;
    max-width: 1300px;
    border: 1px solid #BDBDBD;
}
.searching {
    height: 38px !important; 
    width:60vw !important;
    max-width: 955px;
    border-style: none !important;
}
.title_box span {
    font-size: 25px;
    font-weight: bold;
}
.searching_message_box {
    width:70vw;
    height: 110px;
    max-width: 1300px;
    display:flex;
    justify-content: center;
}
.searching_message {
    display: flex;
    flex-direction: column;
    justify-content: center;
    width:60vw;
    max-width: 900px;
    border-bottom: 1px solid #BDBDBD;
    margin-top: 15px;
}
.searching_message div {
    text-align: center;
    font-size: 20px;
    margin-bottom: 10px;
}
.searching_message b {
    letter-spacing: 3px;
    color: #0288D1;
    font-size: 30px;
}
.searching_message p {    
    font-size: 13px;
    color: #757575;
}
.page_title {
    color: #424242;
}
.title {
    font-size: 15px;
    color: #0288D1;
    font-weight: 700;
}


.mx-auto {
  z-index: 0;
  width:inherit;
  height:inherit;
}
.mx-auto:hover .btn-plus {
  opacity:1;
  transform:scale(1);
}
.mx-auto:hover .btn-plus2 {
  opacity:1;
  transform:scale(1);
}
.btn_pagination {
    background-color: transparent;
    box-shadow: none;
}
.nothing {
    width: 290px;
}
.nothing p {
    margin: 0px;
}
.item {
    margin: 10px;
    width: 300px;
}
.btn-plus {
  position:absolute;
  top:77.5px;
  left:122.5px;
  background:rgb(65, 84, 192, 0.8);
  width:55px;
  height:55px;
  border-radius:50%;
  text-align:center;
  /* 추가된 부분 */
  opacity:0;
  transform:scale(2);
  transition:all .3s linear;
}
.btn-plus span {
  font-size:2.3em;
  color:#ffffff;
  user-select:none;
}
.btn-plus2 {
  /* hover시 사진 어둡게 */
  position:absolute;
  top:0.001px;
  background:rgba(0, 0, 0, 0.2);
  width:300px;
  height:200px;
  text-align:center;
  border-radius: 6px 6px 0px 0px;
  cursor: pointer;
  /* 추가된 부분 */
  opacity:0;
  transition:all .6s linear;
}.btn-plus2 span {
  font-size:2.3em;
  color:#ffffff;
  user-select:none;
}
</style>