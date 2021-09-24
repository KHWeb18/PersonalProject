<template>
  <div>
    <v-container align="center">
      <br>
      <v-spacer></v-spacer>
    <h1 align="center">오시는 길</h1>
    <p align="center">__________</p>
    <div id="map" align="center"></div>
    </v-container>
  </div>
</template>

<script>
export default {
  name: "MapPage",
  data() {
    return {
      map: null,
      markerPositions1: [
        [33.452278, 126.567803],
        [33.452671, 126.574792],
        [33.451744, 126.572441],
      ],
      markerPositions2: [
        [37.499590490909185, 127.0263723554437],
        [37.499427948430814, 127.02794423197847],
        [37.498553760499505, 127.02882598822454],
        [37.497625593121384, 127.02935713582038],
        [37.49629291770947, 127.02587362608637],
        [37.49754540521486, 127.02546694890695],
        [37.49646391248451, 127.02675574250912],
      ],
      markers: [],
      infowindow: null,
    };
  },
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement("script");

      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=a31ea0a88f90369a63ae977fde35e829";
      document.head.appendChild(script);
    }
  },
  methods: {
    initMap() {
      const container = document.getElementById("map");
      const options = {
        center: new kakao.maps.LatLng(37.5048863044297, 127.0474979075962),
        level: 5,
      };
      this.map = new kakao.maps.Map(container, options);

      var markerPosition  = new kakao.maps.LatLng(37.5048863044297, 127.0474979075962); 

      // 마커를 생성합니다
      var marker = new kakao.maps.Marker({
          position: markerPosition
      });
      //marker.setClickable(true);
      marker.setMap(this.map);

      var iwContent =
            '        <div class="title">' + 
            '            라이프 오브 모멘트' + 
            '        </div>' + 
            '        <div class="body">' + 
            '                <div class="ellipsis">서울시 강남구 선릉로91길 14</div>' + 
            '                <div style="padding:5px class="jibun ellipsis">(우) 63309 (지번) (역삼동 705-8) 선릉빌딩 302호' + 
            '                <a href="http://localhost:8080/intro" target="_blank" class="link">홈페이지</a></div>' + 
            '            </div>' + 
            '        </div>' + 
            '    </div>' +    
            '</div>';
        var iwPosition = new kakao.maps.LatLng(37.5048863044297, 127.0474979075962);

          var infowindow = new kakao.maps.InfoWindow({
          position : iwPosition, 
          content : iwContent 
          });
          infowindow.open(this.map, marker); 
    },
    displayMarker(markerPositions) {
      if (this.markers.length > 0) {
        this.markers.forEach((marker) => marker.setMap(null));
      }

      const positions = markerPositions.map(
        (position) => new kakao.maps.LatLng(...position)
      );

      if (positions.length > 0) {
        this.markers = positions.map(
          (position) =>
            new kakao.maps.Marker({
              map: this.map,
              position,
            })
        );

        const bounds = positions.reduce(
          (bounds, latlng) => bounds.extend(latlng),
          new kakao.maps.LatLngBounds()
        );

        this.map.setBounds(bounds);
      }
    },
    displayInfoWindow() {

      var iwContent = '<div style="padding:5px;">Hello World!</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
        iwPosition = new kakao.maps.LatLng(37.5048863044297, 127.0474979075962), //인포윈도우 표시 위치입니다
        iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

      this.infowindow = new kakao.maps.InfoWindow({
        map: this.map, // 인포윈도우가 표시될 지도
        position: iwPosition,
        content: iwContent,
        removable: iwRemoveable,
      });

      this.map.setCenter(iwPosition);
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#map {
  width: 900px;
  height: 500px;
  text-align: center;
  margin: 0px 120px;
}

.button-group {
  margin: 10px 9px;
}

button {
  margin: 0 3px;
}
</style>