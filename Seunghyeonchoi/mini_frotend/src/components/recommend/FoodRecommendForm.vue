<template>
    <div>
        <!-- 제목 -->
        <div class="title_box">
            <h4 class="page_title">
                <v-icon>mdi-food-apple</v-icon>
                <span>사료 계산기</span>
            </h4>
        </div>
        <div class="food_box" :class="{red: attachRed, green: !attachRed}">
            <div class="container2">
                <div class="result_box">
                    <div class="result_box_item">
                        <h3>하루 필요 칼로리</h3>
                        <form name="checkMoney" id="check-money" >
                            <div v-show="calcKcal !== ''" class="calc_result">{{ calcKcal }}kcal</div>
                        </form>
                        <form name="checkMoney" id="check-money" >
                            <div v-show="calcKcal == ''" class="calc_result">kcal</div>
                        </form>
                    </div>
                    <div class="result_box_item">
                        <h3>하루 적정 사료량</h3>
                        <form name="checkMoney" id="check-money" >
                            <div v-show="calcDailyFoodWeight !== ''" class="calc_result">{{ calcDailyFoodWeight }}g</div>
                        </form>
                        <form name="checkMoney" id="check-money" >
                            <div v-show="calcDailyFoodWeight == ''" class="calc_result">g</div>
                        </form>
                    </div>
                </div>
                <v-spacer class="select_food">{{selectFood}}</v-spacer>

                <div class="bar">고양이 사료량 계산</div>
                    <div class="ready-money">
                        <ul class="age_box2">
                            <!-- <v-item-group> -->
                                <v-chip-group sole="solo"
                                active-class="orange accent-4 white--text">
                                    <v-chip v-if="true" @click="toggle(0)">생후 3개월 미만</v-chip>
                                    <v-chip v-if="true" @click="toggle(1)">6개월 미만</v-chip>
                                    <v-chip v-if="true" @click="toggle(2)">1살 미만</v-chip>
                                    <v-chip v-if="true" @click="toggle(3)">성묘</v-chip>
                                    <v-chip v-if="true" @click="toggle(4)">노묘(7살 이상)</v-chip>
                                </v-chip-group>
                            <!-- </v-item-group> -->
                        </ul>
                        <ul class="age_box3">
                            <!-- <v-item-group> -->
                                <v-chip-group sole="solo"
                            active-class="lime accent-4 white--text">
                                <v-chip v-if="pregnantCheck" disabled @click="toggle2()">중성화</v-chip>
                            </v-chip-group>
                            <v-chip-group sole="solo"
                            active-class="lime accent-4 white--text">
                                <v-chip v-if="!pregnantCheck" @click="toggle2()">중성화</v-chip>
                            </v-chip-group>
                            
                            <v-chip-group sole="solo"
                            active-class="pink accent-2 white--text">
                                <v-chip v-if="(!pregnantCheck && !dynamicCheck)" @click="toggle3()">비만묘</v-chip>
                            </v-chip-group>
                            <v-chip-group sole="solo"
                            active-class="pink accent-2 white--text">
                                <v-chip v-if="(!pregnantCheck && dynamicCheck) || 
                                (pregnantCheck && !dynamicCheck)" disabled @click="toggle3()">비만묘</v-chip>
                            </v-chip-group>


                            <v-chip-group sole="solo"
                            active-class="deep-purple darken-2 white--text">
                                <v-chip v-if="neuteringCheck" disabled @click="toggle4()">임신묘</v-chip>
                            </v-chip-group>
                            <v-chip-group sole="solo"
                            active-class="deep-purple darken-2 white--text">
                                <v-chip v-if="!neuteringCheck" @click="toggle4()">임신묘</v-chip>
                            </v-chip-group>

                            <v-chip-group sole="solo"
                            active-class="pink accent-2 white--text">
                                <v-chip v-if="dietCheck " disabled @click="toggle5()">활동적인묘</v-chip>
                            </v-chip-group>
                            <v-chip-group sole="solo"
                            active-class="pink accent-2 white--text">
                                <v-chip v-if="!dietCheck || (!neuteringCheck && !dietCheck && !pregnantCheck)" @click="toggle5()">활동적인묘</v-chip>
                            </v-chip-group>
                            <!-- </v-item-group> -->
                        </ul>
                        <ul class="age_box4">
                            <form id="check-money" >
                                <input v-model="inputWeight" class="my-money" type="number" placeholder="몸무게(kg)" @input="calc()"
                                onblur="this.placeholder='숫자를 입력해주세요'"/>
                            </form>
                        </ul>
                        <ul class="age_box4">
                            <form name="inputKcal" id="check-money" >
                                <input v-model="inputKcal" class="my-money" type="number" placeholder="사료 칼로리(kcal/kg)" @input="calc()"
                                onblur="this.placeholder='숫자를 입력해주세요'"/>
                            </form>
                        </ul>
                    </div>
                </div>


            <div class="container3" >
                <div class="result_box2">
                    <!-- 나이 선택 카드 -->
                    <v-card v-if="card1 != 10" class="mx-auto" :class="{ on : reveal }">
                        <v-card-text width:200px v-show="card1 == 0"  class="mx-auto2">
                        <div >생후 3개월 미만 고양이</div>
                        <div class="text_primary">
                            <ul class="menu1">
                                <li @click="select_option('kitten')">KITTEN 사료</li>
                            </ul>
                        </div>
                        </v-card-text>
                        <v-card-text width:200px  v-show="card1 == 1"  class="mx-auto2">
                        <div>생후 6개월 미만 고양이</div>
                        <div class="text_primary">
                            <ul class="menu1">
                                <li @click="select_option('kitten')">KITTEN 사료</li>
                                <li @click="select_option('calPho')">칼슘과 인이 많은</li>
                                <li @click="select_option('protein')">단백질이 풍부한</li> 
                            </ul>
                        </div>
                        </v-card-text>
                        <v-card-text width:200px  v-show="card1 == 2"  class="mx-auto2">
                        <div>생후 1살 미만 고양이</div>
                        <div class="text_primary">
                            <ul class="menu1">
                                <li @click="select_option('kitten')">KITTEN 사료</li>
                                <li @click="select_option('calPho')">칼슘과 인이 많은</li>
                                <li @click="select_option('protein')">단백질이 풍부한</li>
                            </ul>
                        </div>
                        </v-card-text>
                        <v-card-text width:200px  v-show="card1 == 3" class="mx-auto2">
                        <div>성묘</div>
                        <div class="text_primary">
                            <ul class="menu1">
                                <li @click="select_option('adult')">성묘용 사료</li>
                                <li @click="select_option('diarhea')">엉덩이가 더럽다면</li>
                                <li @click="select_option('coat')">냥코트가 푸석하면</li>
                                <li @click="select_option('hairball')">헤어볼 안 토하면</li>
                            </ul>
                        </div>
                        </v-card-text>
                        <v-card-text width:200px  v-show="card1 == 4"  class="mx-auto2">
                        <div>노묘(7살 이상)</div>
                        <div class="text_primary">
                            <ul class="menu1">
                                <li @click="select_option('senior')">시니어용 사료</li>
                                <li @click="select_option('palatability')">입맛이 까다로운</li>
                                <li @click="select_option('gluten')">글루텐그레인프리</li>
                            </ul>
                        </div>
                        </v-card-text>
                    <v-card-actions style="justify-content:center; margin-top:0px;">
                        <v-btn text color="teal accent-4" @click="reveal = true">
                            Learn More
                        </v-btn>
                    </v-card-actions>
                    <v-expand-transition>
                        <v-card v-if="reveal" class="transition-fast-in-fast-out v-card--reveal" style="height: 100%;">
                            <v-card-text class="pb-0">
                                <div v-show="card1 == 0" class="fade-in-box">
                                <p class="change_font" >
                                    생후 3개월 미만 고양이</p>
                                <p>이유기에는 생후 4주부터 젖니가 나오고 성묘의 3~4배의 칼로리가 필요한 시기랍니다.</p>
                                <p>때문에 키튼사료(고칼로리 사료)를 물이나 전용우유에 불려 급여해 줘야해요</p> 
                                <p>적응할수록 우유나 물의 양을 줄여가는데 하루에 조금씩 4~5회로 나누어 먹이고</p>
                                <p>2주 정도에 걸쳐 급여해 주면서 슬슬 젖을 떼는 연습을 시켜주면 된답니다^^</p>
                                </div>
                                <div v-show="card1 == 1"  class="fade-in-box">
                                <p class="change_font" >
                                    생후 6개월 미만 고양이</p>
                                <p>똥꼬 발랄의 절정을 달리는 6개월까지의 시기에요ㅋㅋㅋ</p>
                                <p>이때의 영양이 평생을 좌우한다고 해도 과언이 아닌데요</p>
                                <p>발육의 도움이 되는 고단백 고칼로리에 소화도 잘되는 키튼사료를 급여한답니다</p>
                                <p>2개월 부터 3~4회 나눠 먹이다가 횟수를 서서히 2회로 줄여주세요</p>
                                <p>애틋한 마음으로 푸짐한 한그릇을 주어도 되지만 먹은 만큼 잘 싸는지(?) 확인하고</p>
                                <p>만약 설사나 무른 응가를 한다면 급여량을 줄여주어야 하겠죠?</p>
                                </div>
                                <div v-show="card1 == 2"  class="fade-in-box">
                                <p class="change_font" >
                                    생후 1살 미만 고양이</p>
                                <p>곧 성묘가 될 고양이지만 아직까진 애죠</p>
                                <p>칼슘과 인이 부족해지기 쉬우니 조금 신경써주신다면 좋아요</p>
                                <p>칼슘 1% 이상, 인 0.8% 이상이 적정하다고 합니다.<p>
                                <p>인의 섭취가 과도할경우 부갑상선 호르몬의 분비를 촉발시켜 칼슘이 뼈에서 빠져나가 골밀도를 낮춰 뼈건강을 해쳐요.</p>
                                <p>또한 이 시기에 먹은 사료의 맛이 고양이의 취향을 만들 가능성이 매우 높기 때문에</p>
                                <p>다양한 사료를 접해보는 것도 나중을 위해 좋답니다</p>
                                </div>
                                <div v-show="card1 == 3" class="fade-in-box">
                                <p class="change_font" >
                                    다 큰 고양이</p>
                                <p>어덜트(Adult)라 불리는 이 시기는 보통 1살 이상~7살 미만의 고양이를 지칭합니다.</p>
                                <p>이 시기에 먹던 고단백의 사료를 계속 주다보면 비만으로 이어질 가능성이 매우 높아요.</p>
                                <p>따라서 고단백 사료를 점점 줄이면서 영양소가 골고루 들어있는 사료를 주는 것이 좋아요.</p>
                                <p>고단백 사료의 경우에 대부분이 습식 사료로, 하루 식사량 중에서 습식 사료의 비중을 점점 줄여 나가는 것을 권해요.</p>
                                </div>
                                <div v-show="card1 == 4" class="fade-in-box">
                                <p class="change_font" >
                                    노묘(7살 이상)
                                </p>
                                <p>7살 이상이 되면 시니어(Senior)로 부르며,</p>
                                <p>이 시기부터는 소화 체계가 예전처럼 활발하지 않기 때문에 더 주의를 기울일 필요가 있어요.</p>
                                <p>관절이나 치아 등 건강이 약해지는 시기이므로 영양소는 높되, 소화는 잘 되는 습식사료로 다시 돌아가는 것이 좋아요.</p>
                                <p>특히 부드러운 식감으로 인해 많이 씹지 않아도 알아서 소화가 잘 되는 캔 사료, 파우치 사료 등이 좋답니다.</p>
                                </div>
                            </v-card-text>

                            <v-card-actions class="pt-0">
                                <v-btn text color="teal accent-4" @click="reveal = false">
                                    Close
                                </v-btn>
                            </v-card-actions>
                        </v-card>
                    </v-expand-transition>
                </v-card>
                </div>

                <div class="result_box2">
                    <!-- 나이 선택 카드 -->
                    <v-card v-if="card2 != 10" class="mx-auto" :class="{ on : reveal2 }">
                        <v-card-text width:200px  v-show="card2 == 1" class="mx-auto2">
                        <div>중성화/푸짐한 고양이</div>
                        <div class="text_primary">
                            <ul class="menu1">
                                <li @click="select_option('lowKcal')">칼로리가 낮은</li>
                                <li @click="select_option('protein')">단백질이 많은</li>
                                <li @click="select_option('fiber')">식이섬유가 많은</li>
                            </ul>
                        </div>
                        </v-card-text>
                         <v-card-text width:200px  v-show="card2 == 2" class="mx-auto2">
                        <div>임신한 고양이</div>
                        <div class="text_primary">
                            <ul class="menu1">
                                <li @click="select_option('fat')">지방이 많은</li>
                            </ul>
                        </div>
                        </v-card-text>   
                        <v-card-text width:200px  v-show="card2 == 3" class="mx-auto2">
                            <ul class="menu1">
                                <li @click="select_option('diarhea')">엉덩이가 더럽다면</li>
                                <li @click="select_option('coat')">냥코트가 푸석하면</li>
                                <li @click="select_option('hairball')">헤어볼 안 토하면</li>
                                <li @click="select_option('palatability')">입맛이 까다로운</li>
                                <li @click="select_option('gluten')">글루텐그레인프리</li>                                
                            </ul>
                        </v-card-text>                      
                    <v-card-actions style="justify-content:center; margin-top:0px;">
                        <v-btn text color="teal accent-4" @click="reveal2 = true">
                            Learn More
                        </v-btn>
                    </v-card-actions>
                    <v-expand-transition>
                        <v-card v-if="reveal2" class="transition-fast-in-fast-out v-card--reveal" style="height: 100%;">
                            <v-card-text class="pb-0">
                                <div v-show="card2 == 1" class="fade-in-box">
                                <p class="text-h4 text--primary">
                                    중성화/푸짐한 고양이 
                                </p>
                                <p>반려묘가 먹는 사료에는 탄수화물이 30~70% 들어 있어서 살이 찔 수밖에 없어요.<br>
                                <p>식습관 개선이 필수에요. 고양이에게 사료는 건빵과 같은 것, 전투 식량처럼 적은 양으로 높은 열량을 내요.</p>
                                <p>고단백 사료, 혹은 식이섬유가 많이 포함된 사료를 주는 게 다이어트에 큰 도움이 돼요
                                <p>이외에도 사료를 건식에서 습식으로 바꿔주는 것만으로도 도움이 돼요. 
                                <p>습식 사료를 먹으면 수분으로 배를 채워 건식에 비해 먹는 양이 적어질 수 밖에 없어요.</p>
                                </div>
                                <div v-show="card2 == 2"  class="fade-in-box">
                                <p class="text-h4 text--primary">
                                    임신한 고양이</p>
                                <p>임신 초기에는 모유 생산에 도움되도록 특별히 설계된 고지방식을 급여해야 합니다.<br>
                                <p>기존 사료에 새 사료를 섞어(75:25) 새 사료로 점진적으로 전환합니다.</p>
                                <p>5-7일이면 새 사료의 비율을 100%까지 늘릴 수 있습니다.</p>
                                <p>이렇게 하면 식단 변화로 인해 발생할 수 있는 소화 불량을 줄이는 데 도움이 됩니다.</p>
                                <p>임신이 진행됨에 따라 반려묘가 필요로 하는 에너지양은 매주 약 10%씩 증가합니다.</p>
                                <p>임신 후반에는 평소보다 70% 더 많은 에너지를 소비합니다.</p>
                                </div>
                                <div v-show="card2 == 3"  class="fade-in-box">
                                <p class="text-h4 text--primary">
                                    활동적인 고양이</p>
                                <p>아무런 문제 없는 활동적인 고양이라니 부럽네요^^<br>
                                <p>특별한 문제가 없는 이상 마음에 맞는 사료를 고르시면 될 거 같습니다.</p>                                
                                </div>
                            </v-card-text>

                            <v-card-actions class="pt-0">
                                <v-btn text color="teal accent-4" @click="reveal2 = false">
                                    Close
                                </v-btn>
                            </v-card-actions>
                        </v-card>
                    </v-expand-transition>
                </v-card>
                </div>
            </div>
        </div>



        <!-- 검색 결과 -->
        <v-container class="food01" v-show="searchinOn">
            <v-container class="food_box2">
                <div v-for="mob in paginatedData2" :key="mob.foodNo" class="item">
                    <v-card class="fadeInCard">
                        <div class="myGod">
                            <v-img :src="ImgRequest(mob.foodNo)" height="200px"></v-img>
                            <div class="btn-plus"><span draggable="false"><v-icon color="white">mdi-image-plus</v-icon></span></div>
                            <div class="btn-plus2" @click="[inputKcal = mob.kcal, selectFood = mob.name]"><span draggable="false"></span></div>
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
                        </div>
                    </v-card>
                </div>
            </v-container>
            <v-container style="margin-top:20px;">
                <div class="text-center">
                    <v-pagination class="btn_pagination" v-model="pageNum2" :length="pageCount2"></v-pagination>
                </div>
            </v-container>
        </v-container>
    </div>
</template>

<script>
export default {
    data: () => ({
      valid: false,
      inputWeight: '',
      inputKcal: '',
      calcDailyFoodWeight: '',
      calcKcal: '',

      ageList: ['3개월', '6개월', '1살', '성묘', '노묘'],
      age: [0, 0, 0, 0, 0],
      ageSelect: '',
      neutering: false,
      neuteringCheck: false,
      diet: false,
      dietCheck: false,
      pregnant: false,
      pregnantCheck: false,
      dynamic: false,
      dynamicCheck: false,
      optionCheck: true,


      //오른쪽 정보 카드
      reveal: false,
      reveal2: false,
      card1: 10,
      card2: 10,
      
      // animation용
      attachRed: false,
      color:'green',
      isHideImage: false,
      listSelector: '',

      //검색
      searchingResult: [],
      searchinOn: false,
      pageNum2: 1,
      show: false,
      selectFood: ''

    }),
    props: {
        foods: {
            type: Array
        },
        pageSize2: {
            type: Number,
            required: false,
            default: 6
        }
    },
    watch: {
        word(newVal) {       //이런식으로 watch 사용
            if(newVal == '') {
                setTimeout(() => {
                    this.searchinOn = false
                    }, 200)
            }
        },
        inputKcal(newVal) {
            if(newVal !== '') {
                this.calc()
            }
        }
    },
    computed: {
        divClasses: function() {
            return {
                red: this.attachRed,
                green: !this.attachRed
            }
        },
        pageCount2() {
            let listLength = this.searchingResult.length, // 길이
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
                .searchingResult
                .slice(start, end);
        }
    },
    methods: {
        toggle (n) {
            this.calc()
            if (this.card1 == 10) {
                this.attachRed = true
                setTimeout(() => {
                this.card1 = n
                }, 1000)
            } else {
                this.card1 = n
                this.attachRed = this.attachRed = true
            }

         if (this.age[n] == 0) { 
                this.age = [0, 0 ,0, 0, 0]
                this.age[n] = 1;
                this.ageSelect = this.ageList[n]
                // console.log(this.age)
                // console.log(this.ageSelect)
            } else if (this.age[n] == 1) {
                this.age = [0, 0 ,0, 0, 0]                
                this.ageSelect = ''
                console.log(this.age)
            }
            
        },
        toggle2 () {
            if (!this.neutering) {
                this.neutering = true
                this.neuteringCheck = true
            } else {
            this.neutering = false
            this.neuteringCheck = false
            }
            // console.log(this.neutering)
            this.card2 = 1
            this.calc()
        },
        toggle3 () {
            if (!this.diet) {
                this.diet = true
                this.dietCheck = true
            } else {
            this.diet = false
            this.dietCheck = false
            }
            // console.log(this.diet)
            this.card2 = 1
            this.calc()
        },
        toggle4 () {
            if (!this.pregnant) {
                this.pregnant = true
                this.pregnantCheck = true
            } else {
            this.pregnant = false
            this.pregnantCheck = false
            }
            // console.log(this.pregnant)
            this.card2 = 2
            this.calc()
        },
        toggle5 () {
            if (!this.dynamic) {
                this.dynamic = true
                this.dynamicCheck = true
            } else {
            this.dynamic = false
            this.dynamicCheck = false
            }
            // console.log(this.dynamic)
            this.card2 = 3
            this.calc()
        },
        ageSelector() {
            switch(this.ageSelect) {
                case '3개월':
                    return 3.0;
                case '6개월':
                    return 2.5;
                case '1살':
                    return 2.0;
                case '성묘':
                    return 1.4;
                case '노묘':
                    return 0.7;
            }
        },
        calc () {
            if(this.inputKcal !== '' && this.inputWeight !== '' && this.ageSelect !== '') {
                var catWeight = this.inputWeight
                var ageMultiple = this.ageSelector()
                // console.log('ageMultiple : ' + ageMultiple)
                var neuteringConsntant = 1
                    if(this.neutering) {
                        neuteringConsntant = 0.857
                    }
                var pregnantConstant = 1
                    if(this.pregnant) {
                        pregnantConstant = 1.7
                    }
                var dietConstant = 1
                    if(this.diet) {
                        dietConstant = 0.571
                    }
                var dynamicConstant = 1
                    if(this.dynamic) {
                        dynamicConstant = 1.143
                    }

                var BMR = 30 * catWeight + 70
                this.calcKcal = Math.round(BMR * ageMultiple * neuteringConsntant * pregnantConstant * dietConstant * dynamicConstant)
                this.calcDailyFoodWeight = Math.round(this.calcKcal / this.inputKcal * 1000)
                }
        },
        discrimination (data) {//검색값 변환

            var searching_option = '' 
            switch(data) {
                case 'kitten':
                    searching_option = 'KITTEN'
                    break
                case 'adult':
                    searching_option = 'ADULT'
                    break
                case 'senior':
                    searching_option = 'SENIOR'
                    break
                case 'diarhea':
                    searching_option = 'DIARHEA'
                    break        
                case 'hairball':
                    searching_option = 'HAIRBALL'
                    break
                case 'coat':
                    searching_option = 'COAT'
                    break
                case 'palatability':
                    searching_option = 'PALATABILITY'
                    break
                case 'calPho':
                    searching_option = 'CALPHO'
                    break
                case 'protein':
                    searching_option = 'PROTEIN'
                    break
                case 'lowKcal':
                    searching_option = 'LOWKCAL'
                    break
                case 'fiber':
                    searching_option = 'FIBER'
                    break
                case 'fat':
                    searching_option = 'FAT'
                    break   
                case 'gluten':
                    searching_option = 'GLUTEN'
                    break    
                default:
                    break
            }
            return searching_option
        },
        select_option (data) { //검색 실행

            var SO = this.discrimination(data)

            var lists = this.foods
            this.searchingResult = []

            if (SO == 'KITTEN' || SO == 'ADULT' || SO == 'SENIOR') {
                // console.log('나이 선택하셨네요 나이 검색 시작')
                for(var i = 0; i < lists.length; i++){
                    if(lists[i].ageSelect.includes(SO)){
                        this.searchingResult.push(lists[i])
                    }
                }
            } else if (SO =='DIARHEA'){
                for(var a = 0; a < lists.length; a++){
                    if(lists[a].diarhea.includes('TRUE')){
                        this.searchingResult.push(lists[a])
                    }
                }
            } else if (SO =='HAIRBALL'){
                for(var b = 0; b < lists.length; b++){
                    if(lists[b].hairball.includes('TRUE')){
                        this.searchingResult.push(lists[b])
                    }
                }
            } else if (SO =='COAT'){
                for(var c = 0; c < lists.length; c++){
                    if(lists[c].coat.includes('TRUE')){
                        this.searchingResult.push(lists[c])
                    }
                }
            } else if (SO =='PALATABILITY'){
                for(var d = 0; d < lists.length; d++){
                    if(lists[d].palatability.includes('TRUE')){
                        this.searchingResult.push(lists[d])
                    }
                }
            } else if (SO =='CALPHO'){
                for(var e = 0; e < lists.length; e++){
                    if(lists[e].calcium >= 1){
                        this.searchingResult.push(lists[e])
                    }
                }
            } else if (SO =='PROTEIN'){
                for(var g = 0; g < lists.length; g++){
                    if(lists[g].protein >= 35){
                        this.searchingResult.push(lists[g])
                    }
                }
            } else if (SO =='LOWKCAL'){
                for(var h = 0; h < lists.length; h++){
                    if(lists[h].kcal <= 3500){
                        this.searchingResult.push(lists[h])
                    }
                }
            } else if (SO =='FIBER'){
                for(var j = 0; j < lists.length; j++){
                    if(lists[j].fiber >= 8){
                        this.searchingResult.push(lists[j])
                    }
                }
            } else if (SO =='FAT'){
                for(var k = 0; k < lists.length; k++){
                    if(lists[k].fat >= 20){
                        this.searchingResult.push(lists[k])
                    }
                }
            } else if (SO =='GLUTEN'){
                for(var l = 0; l < lists.length; l++){
                    if(lists[l].glutenFree.includes('TRUE')){
                        this.searchingResult.push(lists[l])
                    }
                }
            }
            this.searchinOn = true
        },
        nextPage2() {
                this.pageNum2 += 1;
        },
        prevPage2() {
            this.pageNum2 -= 1;
        },
        ImgRequest(foodNo) {
            try {
                return require(`../../../../Mini/Images/Food/${foodNo}.gif`
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
        }
    }
}
</script>


<style scoped>

.result_box {
    
    display: flex;
    justify-content: space-evenly;
}
.result_box2 { 
	justify-content: flex-start;
}
.result_box_item {

    box-sizing: border-box;
    border-radius: 25px;
    border: 0;
    font-size: 2em;
    font-family: 'Recipekorea';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/Recipekorea.woff') format('woff');
    font-weight: bold;
    text-align: center;
    color: #190707;
    transition: all 0.5s;

}
.result_box h3 {
    font-size: 0.5em;
    color: #666666;
    font-weight: bold;
}
.food {
    margin:0px;
    padding:0px;
    display: flex;
    justify-content: center;
}

.food_box {
    position: relative;
    left: 180px;
    padding:0px;
    margin: 20px 10vw 20px 10vw;
    display: flex;
    justify-content: center;
    flex-wrap: wrap;
    width:90vw;
    max-width: 1200px;
}
.v-btn:not(.v-btn--round).v-size--default {
    height: 20px;
}
::placeholder {
    font-size: 13px;
    letter-spacing: 0;
    font-weight: 700;
    color:rgba(77, 77, 90, 0.747);
    /* font-style: 'a바람새L'; */
}
.age_box {
    height: 48px;
}
.option_box {
    height: 48px;
}
.age_box2 {
    display: flex;
    justify-content: center;
    padding-bottom: 6px;
}
.age_box3 {
    display: flex!important;
    justify-content: center!important;
    padding-top: 6px!important;
}
.age_box4 {
    display: flex;
    justify-content: center;    
}
.container2 {
    width: 550px;
    max-height: 550px;
    margin: 0px 12px 0px 20px;
    border: 1px solid #cccccc;
    border-radius: 2%;
    box-shadow: 2px 2px 5px #333333;
}
@-webkit-keyframes move {

  100% {
    -webkit-transform: translateX(-180px) ;    
  }
}
.red {
    -webkit-animation-duration: 1000ms;
    -webkit-animation-name: move;
    animation-fill-mode: forwards;
    background-color: transparent !important;
}
.green {
  background-color: transparent !important;
}
.blue {
  background-color: blue;
}



.container3 {
    width: 550px;
    max-height: 550px;
    margin: 0px 20px 0px 12px;
    border: 0px solid #cccccc;
    border-radius: 2%;
}

.my-money {
    padding-top: 20px;
    text-align: center;
}
.calc_result {
    padding-top: 20px;
    text-align: center;
    height: 80px;
}
.my-money h3 {
    font-size: 1.2em;
    color: #666666;
}
.bar {
    width: 100%;
    padding-left: 15px;
    height: 40px;
    background: #747474;
    color: #ffffff;
    font-size: 1.2em;
    line-height: 40px;
}
#check-money input {
    width: 240px;
    height: 55px;
    padding: 20px;
    box-sizing: border-box;
    border-radius: 25px;
    border: 0;
    background: #fff;
    font-size: 2em;
    font-family: 'Jua', sans-serif;
    font-weight: bold;
    text-align: center;
    color: #190707;
    transition: all 0.5s;
}
#check-money input:hover {
    background: #eee;
}
#check-money input:focus {
    outline: none;
}
#check-money div {
    font-size: 30px;
    text-align: center;
    letter-spacing: 0;
    font-weight: 700;
    color:rgba(77, 77, 90, 0.747);
}
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}
.ready-money {
    width: 520px;
    margin: 20px auto auto auto;
}
.ready-money ul {
    list-style: none;
    border-bottom: 1px dashed #cccccc;
    height: 60px;
}
.ready-money ul:last-child {
    border-bottom: none;
}
::placeholder {
    font-size: 20px;
    text-align: center;
    letter-spacing: 0;
    font-weight: 700;
    color:rgba(77, 77, 90, 0.747);
}
.v-card--reveal {
  bottom: 0;
  opacity: 1 !important;
  position: absolute;
  width: 100%;
}
.mx-auto {
    display: inline-block;
    animation: fadein 1.5s;
    -webkit-animation: fadein 1.5s;
    height: 245px;
    border-radius: 15px;
    box-shadow: 2px 2px 5px #333333 !important;
    width: 240px;
    margin-top:4px;    
    transition:1s;
}
.mx-auto.on {
    display: inline-block;
    animation: fadein 1.5s;
    -webkit-animation: fadein 1.5s;
    height: 245px;
    border-radius: 15px;
    box-shadow: 2px 2px 5px #333333 !important;
    width: 540px;
    margin-top:4px;    
    transition:1s;
}
.mx-auto2 {
    text-align:center;
    display: flex;
    flex-direction: column;
    justify-content: center;
    animation: fadein 1.5s;
    -webkit-animation: fadein 1.5s;
    -webkit-transition-timing-function: ease-in; 
}
.v-card__text.mx-auto2 {
    padding-bottom: 0px;
}
@-webkit-keyframes fadein {
    from {
        opacity:0;
    }
    to {
        opacity:1;
    }
}
.fade-in-box {
    padding:0px;
    margin:0px;
    display: inline-block;
    animation: fadein 1s;
    -webkit-animation: fadein 1s;
}
.fade-in-box p {
    margin: 5px;
}
.transition-fast-in-fast-out.v-card--reveal.v-card.v-sheet.theme--light {
    border-radius: 15px !important;
}
.v-card__actions {
    padding-top: 5px;
}
.recommend_card_btn {
    margin: 20px 0px 20px 0px;
    font-size: 30px;
    font-weight: 700;
}




a, a:link {
  text-decoration: none;
  font-family: 'Recipekorea';
}
.menu1 ul {
    list-style: none;
}
ul li {
  display: block;
  padding: 0.5vw;
  position: relative;
  text-align: center;
  cursor: pointer;
  width: 215px;
  font-family: 'Recipekorea';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/Recipekorea.woff') format('woff');
}
ul li:hover {
    color:#0D47A1;
    transition: 0.5s;
}
ul li::after {
  content: '';
  display: block;
  position: absolute;
}
.menu1 {
    font-size: 180%;
    display: inline-flex;
    flex-direction: column;
}
.menu1 li::after {
  width: 0;
  height: 0.3vw;
  background: #0D47A1;
  left: 50%;
}
ul li:hover::after {
  width: 100%;
  left: 0;
  transition: all .3s;
}
.text_primary {
    margin-top:20px;
    display: flex;
    justify-content: center;
}

.container food01 {
    display: inline-block;
    margin: 0px;
    padding: 0; 
}
.food_box2 {
    position: relative;
    margin: 0;
    padding: 15px 0 0 0;
    width: 60vw;
    display: flex;
    justify-content: center;
    flex-wrap: wrap;
    border-top: 1px solid #BDBDBD;
}
.myGod {
  z-index: 0;
  width:inherit;
  height:inherit;
}
.myGod:hover .btn-plus {
  opacity:1;
  transform:scale(1);
}
.myGod:hover .btn-plus2 {
  opacity:1;
  transform:scale(1);
  cursor: pointer;
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
  /* 추가된 부분 */
  opacity:0;
  transition:all .6s linear;
}.btn-plus2 span {
  font-size:2.3em;
  color:#ffffff;
  user-select:none;
}
.select_food {
    height: 60px;
    font-family: 'Recipekorea';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/Recipekorea.woff') format('woff');
    text-align: center;
    vertical-align: middle;
    font-size: 20px;
    padding-top: 25px;
    color: #303F9F;
}
.pt-0 {
    position: absolute;
    top:210px;
}
.change_font {
    margin-bottom: 10px !important;
    font-size: 20px;
    font-family: 'Recipekorea';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/Recipekorea.woff') format('woff');
}
.title_box span {
    font-size: 25px;
    font-weight: bold;
}
.title_box {
    margin-bottom: 100px;
}
.page_title {
    position: absolute;
    left: 50%;
    transform: translateX(-50%);
    color: #424242;
}
.fadeInCard {
    animation: fadein 1.5s;
}
.v-card__actions p{
    margin: 0px;
}
</style>