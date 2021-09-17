<template>
  
   <div id="mapwrap"> 
    <!-- 지도가 표시될 div -->
    <div id="map" ></div>
    <!-- 지도 위에 표시될 마커 카테고리 -->
    <div class="category">
        <ul>
            <li id='coffeeMenu' onclick="changeMarker('coffee')">
                <span class="ico_comm ico_coffee"></span>
                카페
            </li>
            <li id='storeMenu' onclick="changeMarker('store')">
                <span class="ico_comm ico_store"></span>
                용품매장
            </li>
            <li id='carparkMenu' onclick="changeMarker('carpark')">
                <span class="ico_comm ico_carpark"></span>
                주차장
            </li>
        </ul>
    </div>
</div>
    



      
</template>

<script>



export default {
    name: 'Store',
    mounted() {
        if (window.kakao && window.kakao.maps) {
            this.initMap()
        } else {
            const script = document.createElement('script')
            script.onload = () => kakao.maps.load(this.initMap)
            script.src = 'http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=6c5e8cf7eface562cbb19a6563d2d6da'
            document.head.appendChild(script)
            
        }
    },
    methods: {
        
        initMap() {
            var mapContainer  = document.getElementById('map')
            var mapOption  = {
                center: new kakao.maps.LatLng(37.53412067827983, 126.98139959933486),
                level: 9
            },
            

            map = new kakao.maps.Map(mapContainer, mapOption)
            map.setMapTypeId(kakao.maps.MapTypeId.ROADMAP)
        
           

           // 커피숍 마커가 표시될 좌표 배열입니다
            var coffeePositions = [ 
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>페이퍼넛츠</div>'+
                                '<div>서대문구 거북골로24길 37-8</div>'+
                                '<div>10:30 ~ 20:30 월요일 휴무</div><br>',
                    latlng: new kakao.maps.LatLng(37.58124688505972, 126.90818192311804), 
                },
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>달냥</div>'+
                                '<div>은평구 통일로 684 서울혁신파크 상상청 1층</div>'+
                                '<div>09:00 ~ 19:00</div><br>',
                    latlng: new kakao.maps.LatLng(37.60871577404528, 126.93521587104543), 
                },
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>두더지손가게</div>'+
                                '<div>영등포구 당산로52길 31-1 1층</div>'+
                                '<div>12:00 ~ 20:00 | 월,일요일 휴무</div><br>',
                    latlng: new kakao.maps.LatLng(37.53328667369514, 126.90515769188), 
                },
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>브릿지엣지</div>'+
                                '<div>동작구 상도로53길 70 상가동 311호</div>'+
                                '<div>10:00 ~ 20:00 | 월,일요일 휴무</div><br>',
                    latlng: new kakao.maps.LatLng(37.502629915588294, 126.95409531393851), 
                },
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>보틀팩토리</div>'+
                                '<div>서대문구 홍연길 26</div>'+
                                '<div>11:00 ~ 22:00 | 월요일 휴무</div><br>',
                    latlng: new kakao.maps.LatLng(37.57516795711521, 126.92848105508409), 
                },
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>쿠아레비 구산점</div>'+
                                '<div>은평구 서오릉로 149 1층</div>'+
                                '<div>08:00 ~ 21:00 | 일요일 휴무</div><br>',
                    latlng: new kakao.maps.LatLng(37.611586978331076, 126.91621429191238), 
                },
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>사직동그가게</div>'+
                                '<div>종로구 사직로9길 18</div>'+
                                '<div>12:00 ~ 20:00 | 월요일 휴무&nbsp;</div><br>',
                    latlng: new kakao.maps.LatLng(37.57707506292108, 126.96779003939753), 
                },
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>앞으로의 빵집</div>'+
                                '<div>종로구 삼일대로32가길 29-1&nbsp;</div>'+
                                '<div>13:00 ~ 20:00 | 금,토 오픈</div><br>',
                    latlng: new kakao.maps.LatLng(37.57470260380899, 126.98935047553643), 
                },
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>카페기웃기웃</div>'+
                                '<div>마포구 신촌로12다길 20 스테이하이오피스텔 1층</div>'+
                                '<div>12:00 ~ 21:00 | 월요일 휴무</div><br>',
                    latlng: new kakao.maps.LatLng(37.55456291795383, 126.93360480817148), 
                },
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>아토모스</div>'+
                                '<div>성북구 성북로8길 11 1층</div>'+
                                '<div>11:00 ~ 21:00 | 수요일 휴무</div><br>',
                    latlng: new kakao.maps.LatLng(37.59113712267524, 127.00439605303508), 
                },
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>어스얼스 서촌점</div>'+
                                '<div>종로구 자하문로28가길 1</div>'+
                                '<div>12:00 ~ 21:00</div><br>',
                    latlng: new kakao.maps.LatLng(37.58534256726394, 126.9712254923963), 
                },
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>서스테이너블해빗</div>'+
                                '<div>용산구 소월로2길 5 1층</div>'+
                                '<div>11:00 ~ 20:00</div><br>',
                    latlng: new kakao.maps.LatLng(37.55477302585391, 126.97682513440704), 
                },
                 { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>빛바람</div>'+
                                '<div>서울 종로구 삼일대로32가길 29-1</div>'+
                                '<div>13:00 ~ 20:00 | 금,토 오픈</div><br>',
                    latlng: new kakao.maps.LatLng(37.55915206952444, 126.91709358830278), 
                },
            ];

            // 편의점 마커가 표시될 좌표 배열입니다
            var storePositions = [
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>오즈타운</div>'+
                                '<div>마포구 동교로 272-8 2층</div>'+
                                '<div>14:00 ~ 20:00 | 월요일,주말,공휴일 휴무</div><br>',
                    latlng: new kakao.maps.LatLng(37.563530136685614, 126.92610113689794), 
                },
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>지구살림터</div>'+
                                '<div>양천구 목동중앙북로16길 41 1층</div>'+
                                '<div>14:00 ~ 20:00 | 월요일 휴무</div><br>',
                    latlng: new kakao.maps.LatLng(37.5443060310792, 126.87398327388162), 
                },
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>지구샵 상도점</div>'+
                                '<div>동작구 성대로1길 16 1층</div>'+
                                '<div>14:00 ~ 20:30 | 목,금,토,일 오픈</div><br>',
                    latlng: new kakao.maps.LatLng(37.50084534195729, 126.93386727494469), 
                },
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>플라프리</div>'+
                                '<div>동작구 동작대로 157-4 1층</div>'+
                                '<div>12:00 ~ 19:00 | 월요일 휴무</div><br>',
                    latlng: new kakao.maps.LatLng(37.490629325994156, 126.98218778313934), 
                },
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>아로마티카 제로스테이션</div>'+
                                '<div>강남구 도산대로1길 62 1층</div>'+
                                '<div>11:00 ~ 20:00</div><br>',
                    latlng: new kakao.maps.LatLng(37.52071814372389, 127.0194143715091), 
                },
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>플래닛키퍼스 제로웨이스트스토어</div>'+
                                '<div>강남구 언주로30길 13 대림 아크로빌 C동 23층 2314호</div>'+
                                '<div>09:00 ~ 21:00 | 월요일 ~ 금요일 오픈</div><br>',
                    latlng: new kakao.maps.LatLng(37.488137525477256, 127.0506730969197), 
                },
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>아름다운가게 송파가락점</div>'+
                                '<div>송파구 가락로 164 파인힐빌딩</div>'+
                                '<div>10:30 ~ 18:00 | 일요일, 공휴일 휴무</div><br>',
                    latlng: new kakao.maps.LatLng(37.49459281599576, 127.12210534462308), 
                },
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>송포어스</div>'+
                                '<div>강동구 풍성로35길 34 1층</div>'+
                                '<div>11:00 ~ 20:00 | 월요일 휴무</div><br>',
                    latlng: new kakao.maps.LatLng(37.53344506638277, 127.1254666912897), 
                },
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>대안생활공기</div>'+
                                '<div>강동구 상암로 10 지선빌딩 201호</div>'+
                                '<div>09:30 ~ 18:00 | 주말 휴무</div><br>',
                    latlng: new kakao.maps.LatLng(37.55110070632562, 127.12493610630126), 
                },
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>제로웨이스트샵 안녕상점</div>'+
                                '<div>도봉구 도봉로143길 18 2층</div>'+
                                '<div>13:00 ~ 20:00 | 월,화,일요일 휴무</div><br>',
                    latlng: new kakao.maps.LatLng(37.66189126471419, 127.04118018385104), 
                },
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>지구랑가게</div>'+
                                '<div>노원구 광운로 53 1층 3호</div>'+
                                '<div>11:00 ~ 19:30 | 월,일요일 휴무</div><br>',
                    latlng: new kakao.maps.LatLng(37.62238663893475, 127.05932198862035), 
                },
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>보탬상점</div>'+
                                '<div>중랑구 봉화산로22길 2 1층</div>'+
                                '<div>11:00 ~ 20:00 | 일요일 휴무</div><br>',
                    latlng: new kakao.maps.LatLng(37.6014905729707, 127.08173884036312), 
                },
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>순환지구</div>'+
                                '<div>성북구 동소문로25길 8 1층</div>'+
                                '<div>12:30 ~ 20:00 | 월요일 마지막주 일요일 휴무</div><br>',
                    latlng: new kakao.maps.LatLng(37.59481403999546, 127.01859001966922), 
                },
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>알맹상점 리스테이션</div>'+
                                '<div>중구 한강대로 405 4층</div>'+
                                '<div>15:00 ~ 20:00 | 월요일 휴무</div><br>',
                    latlng: new kakao.maps.LatLng(37.55580998317398, 126.97037390074352), 
                },
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>디어에코</div>'+
                                '<div>광진구 아차산로65길 22 1층</div>'+
                                '<div>11:00 ~ 20:00 | 월,일요일 휴무</div><br>',
                    latlng: new kakao.maps.LatLng(37.541261361565425, 127.09379443866803), 
                },
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>덕분애</div>'+
                                '<div>서초구 서초대로 389 진흥상가 2층</div>'+
                                '<div>11:00 ~ 19:00 | 일요일,공휴일 휴무</div><br>',
                    latlng: new kakao.maps.LatLng(37.497075003838724, 127.02366590723175), 
                },
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>비그린</div>'+
                                '<div>동작구 노량진로 10 1층</div>'+
                                '<div>13:00 ~ 19:00 | 월,화,일요일 휴무</div><br>',
                    latlng: new kakao.maps.LatLng(37.51263789448785, 126.92730787960281), 
                },
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>1.5도씨</div>'+
                                '<div>관악구 조원로18길 15 103호</div>'+
                                '<div>10:00 ~ 20:00 | 월요일 휴무</div><br>',
                    latlng: new kakao.maps.LatLng(37.48359304690583, 126.91265738331512), 
                },
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>허그어웨일</div>'+
                                '<div>강서구 화곡로55길 23</div>'+
                                '<div>11:00 ~ 19:30 | 월요일 휴무</div><br>',
                    latlng: new kakao.maps.LatLng(37.552655370967614, 126.84850335144634), 
                },
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>알맹상점</div>'+
                                '<div>마포구 월드컵로 49 2층</div>'+
                                '<div>14:00 ~ 20:00 | 월요일 휴무</div><br>',
                    latlng: new kakao.maps.LatLng(37.5537083110072, 126.91159669405536), 
                },
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>유민얼랏</div>'+
                                '<div>마포구 성미산로17길 68 3호</div>'+
                                '<div>12:00 ~ 19:00 | 월,일요일 휴무</div><br>',
                    latlng: new kakao.maps.LatLng(37.56441870072021, 126.91753201070175), 
                },
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>리틀베러</div>'+
                                '<div>마포구 백범로31길 8 공덕SK리더스뷰 2동 1층</div>'+
                                '<div>13:00 ~ 22:00</div><br>',
                    latlng: new kakao.maps.LatLng(37.54498185022567, 126.94935917535575), 
                },
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>레디투웰니스</div>'+
                                '<div>중구 퇴계로2길 9-8 4층</div>'+
                                '<div>12:00 ~ 19:00 | 월요일 휴무</div><br>',
                    latlng: new kakao.maps.LatLng(37.557021180856665, 126.97768740317576), 
                },
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>라마홈</div>'+
                                '<div>종로구 자하문로 48 1층</div>'+
                                '<div>12:30 ~ 18:00 | 월,화,일요일 휴무</div><br>',
                    latlng: new kakao.maps.LatLng(37.58023627657183, 126.97159539297716), 
                },
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>더피커</div>'+
                                '<div>성동구 서울숲2길 29 1층</div>'+
                                '<div>12:00 ~ 18:00 | 월,일요일 휴무</div><br>',
                    latlng: new kakao.maps.LatLng(37.547941996080176, 127.04411903780904), 
                },
                { 
                    content:    '<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>'+
                                '<div>꽃피는삼월에</div>'+
                                '<div>대문구 답십리로30길 22-1</div>'+
                                '<div>14:00 ~ 20:00</div><br>',
                    latlng: new kakao.maps.LatLng(37.57425171466926, 127.04830321082504), 
                },
            ];

            // 주차장 마커가 표시될 좌표 배열입니다
            var carparkPositions = [
                      
            ];    

            var markerImageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/category.png',  // 마커이미지의 주소입니다. 스프라이트 이미지 입니다
                coffeeMarkers = [], // 커피숍 마커 객체를 가지고 있을 배열입니다
                storeMarkers = [], // 편의점 마커 객체를 가지고 있을 배열입니다
                carparkMarkers = [] // 주차장 마커 객체를 가지고 있을 배열입니다

                
            createCoffeeMarkers() // 커피숍 마커를 생성하고 커피숍 마커 배열에 추가합니다
            createStoreMarkers() // 편의점 마커를 생성하고 편의점 마커 배열에 추가합니다
            createCarparkMarkers() // 주차장 마커를 생성하고 주차장 마커 배열에 추가합니다

           

            // 마커이미지의 주소와, 크기, 옵션으로 마커 이미지를 생성하여 리턴하는 함수입니다
            function createMarkerImage(src, size, options) {
                var markerImage = new kakao.maps.MarkerImage(src, size, options)
                return markerImage            
            }

            // 좌표와 마커이미지를 받아 마커를 생성하여 리턴하는 함수입니다
            function createMarker(position, image) {
                var marker = new kakao.maps.Marker({
                    position: position,
                    image: image
                })
                
                return marker  
            }   
            
            // 커피숍 마커를 생성하고 커피숍 마커 배열에 추가하는 함수입니다
            function createCoffeeMarkers() {
                
                for (var i = 0; i < coffeePositions.length; i++) {  
                    
                    var imageSize = new kakao.maps.Size(22, 26),
                        imageOptions = {  
                            spriteOrigin: new kakao.maps.Point(10, 0),    
                            spriteSize: new kakao.maps.Size(36, 98)  
                        };     
                    
                    // 마커이미지와 마커를 생성합니다
                    var markerImage = createMarkerImage(markerImageSrc, imageSize, imageOptions),    
                        marker = createMarker(coffeePositions[i].latlng, markerImage)  
                    
                    // 생성된 마커를 커피숍 마커 배열에 추가합니다
                    coffeeMarkers.push(marker)

                     var infowindow = new kakao.maps.InfoWindow({
                        content: coffeePositions[i].content // 인포윈도우에 표시할 내용
                        });
                    kakao.maps.event.addListener(marker, 'click', makeOverListener(map, marker, infowindow));
                    kakao.maps.event.addListener(map, 'click', makeOutListener(infowindow))

                    
                }   
                // 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
                function makeOverListener(map, marker, infowindow) {
                    return function() {
                        infowindow.open(map, marker);
                    };
                }

                // 인포윈도우를 닫는 클로저를 만드는 함수입니다 
                function makeOutListener(infowindow) {
                    return function() {
                        infowindow.close();
                    };
                }  
            }


            // 커피숍 마커들의 지도 표시 여부를 설정하는 함수입니다
            function setCoffeeMarkers(map) {        
                for (var i = 0; i < coffeeMarkers.length; i++) {  
                    coffeeMarkers[i].setMap(map)
                }        
            }

            // 편의점 마커를 생성하고 편의점 마커 배열에 추가하는 함수입니다
            function createStoreMarkers() {
                for (var i = 0; i < storePositions.length; i++) {
                    
                    var imageSize = new kakao.maps.Size(22, 26),
                        imageOptions = {   
                            spriteOrigin: new kakao.maps.Point(10, 36),    
                            spriteSize: new kakao.maps.Size(36, 98)  
                        }       
                
                    // 마커이미지와 마커를 생성합니다
                    var markerImage = createMarkerImage(markerImageSrc, imageSize, imageOptions),    
                        marker = createMarker(storePositions[i].latlng, markerImage)  

                    // 생성된 마커를 편의점 마커 배열에 추가합니다
                    storeMarkers.push(marker)    

                     var infowindow = new kakao.maps.InfoWindow({
                        content: storePositions[i].content // 인포윈도우에 표시할 내용
                        });
                    kakao.maps.event.addListener(marker, 'click', makeOverListener(map, marker, infowindow));
                    kakao.maps.event.addListener(map, 'click', makeOutListener(infowindow))

                }        
            }

            function makeOverListener(map, marker, infowindow) {
                return function() {
                    infowindow.open(map, marker);
                };
            }

            // 인포윈도우를 닫는 클로저를 만드는 함수입니다 
            function makeOutListener(infowindow) {
                return function() {
                    infowindow.close();
                };
            }  


            // 편의점 마커들의 지도 표시 여부를 설정하는 함수입니다
            function setStoreMarkers(map) {        
                for (var i = 0; i < storeMarkers.length; i++) {  
                    storeMarkers[i].setMap(map)
                }        
            }

            // 주차장 마커를 생성하고 주차장 마커 배열에 추가하는 함수입니다
            function createCarparkMarkers() {
                for (var i = 0; i < carparkPositions.length; i++) {
                    
                    var imageSize = new kakao.maps.Size(22, 26),
                        imageOptions = {   
                            spriteOrigin: new kakao.maps.Point(10, 72),    
                            spriteSize: new kakao.maps.Size(36, 98)  
                        }       
                
                    // 마커이미지와 마커를 생성합니다
                    var markerImage = createMarkerImage(markerImageSrc, imageSize, imageOptions),    
                        marker = createMarker(carparkPositions[i], markerImage)  

                    // 생성된 마커를 주차장 마커 배열에 추가합니다
                    carparkMarkers.push(marker)        
                }                
            }

            // 주차장 마커들의 지도 표시 여부를 설정하는 함수입니다
            function setCarparkMarkers(map) {        
                for (var i = 0; i < carparkMarkers.length; i++) {  
                    carparkMarkers[i].setMap(map)
                }        
            }

            changeMarker()   

            // 카테고리를 클릭했을 때 type에 따라 카테고리의 스타일과 지도에 표시되는 마커를 변경합니다
            function changeMarker(type){
                
                var coffeeMenu = document.getElementById('coffeeMenu').onclick = function(){ (type === 'coffee') 
                
                    // 커피숍 카테고리를 선택된 스타일로 변경하고
                    coffeeMenu.className = 'menu_selected'
                    
                    // 편의점과 주차장 카테고리는 선택되지 않은 스타일로 바꿉니다
                    storeMenu.className = ''
                    carparkMenu.className = ''
                
                    // 커피숍 마커들만 지도에 표시하도록 설정합니다
                    setCoffeeMarkers(map)
                    setStoreMarkers(null)
                    setCarparkMarkers(null)}
                var storeMenu = document.getElementById('storeMenu').onclick = function()
                {(type === 'store')  // 편의점 카테고리가 클릭됐을 때
                
                    // 편의점 카테고리를 선택된 스타일로 변경하고
                    coffeeMenu.className = ''
                    storeMenu.className = 'menu_selected'
                    carparkMenu.className = ''
                    
                    // 편의점 마커들만 지도에 표시하도록 설정합니다
                    setCoffeeMarkers(null)
                    setStoreMarkers(map)
                    setCarparkMarkers(null)}
                var carparkMenu = document.getElementById('carparkMenu').onclick = function(){(type === 'carpark')  // 주차장 카테고리가 클릭됐을 때
                
                    // 주차장 카테고리를 선택된 스타일로 변경하고
                    coffeeMenu.className = ''
                    storeMenu.className = ''
                    carparkMenu.className = 'menu_selected'
                    
                    // 주차장 마커들만 지도에 표시하도록 설정합니다
                    setCoffeeMarkers(null)
                    setStoreMarkers(null)
                    setCarparkMarkers(map)


                }
            }
        }
    }                    
}




</script>

<style scoped>

#mapwrap{position:relative;overflow:hidden;z-index:2;}
.category, .category *{margin:0;padding:0;color:#000;}   
.category {position:absolute;overflow:hidden;top:15px;left:15px;width:105px;height:52px;z-index:10;border:1px solid black;font-family:'Malgun Gothic','맑은 고딕',sans-serif;font-size:12px;text-align:center;background-color:#fff;}
.category .menu_selected {background:#FF5F4A;color:#fff;border-left:px solid #915B2F;border-right:1px solid #915B2F;margin:0 -1px;} 
.category li{list-style:none;float:left;width:50px;height:45px;padding-top:5px;cursor:pointer;} 
.category .ico_comm {display:block;margin:0 auto 2px;width:22px;height:26px;background:url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/category.png') no-repeat;} 
.category .ico_coffee {background-position:-10px 0;}  
.category .ico_store {background-position:-10px -36px;}   
.category .ico_carpark {background-position:-10px -72px;} 
#map{
    width:100%;
    height:400px;
}


</style>