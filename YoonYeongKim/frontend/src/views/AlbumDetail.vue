<template>

<div class="앨범상세페이지">
  <div class="" style="padding:50px;">
      <h3 align="center">No. {{ randomAlbums.album_no }}</h3>
      <h1 align="center">{{ randomAlbums.title }}</h1>
  </div>

  <div class="테이블" align="center">
        <table>
        <tr>
            <td>아티스트</td>
            <td>{{ randomAlbums.artist }}</td>
            <td rowspan="6" width="600px" align="right">
              <div class="video-container">
                <!-- 동영상 embed 링크만 걸 수 있음 -->
                <iframe width="560" height="315" :src="`${randomAlbums.media}`"
                        frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
                        allowfullscreen>
                </iframe>
              </div>
            </td>
        </tr>
        <tr>
            <td>발매연도</td>
            <td>{{ randomAlbums.releaseYear }}</td>
        </tr>
        <tr>
            <td>장르</td>
            <td>{{ randomAlbums.genre }}</td>
        </tr>
        <tr>
            <td>스타일</td>
            <td>{{ randomAlbums.style }}</td>
        </tr>
        <tr>
            <td>국가</td>
            <td>{{ randomAlbums.country }}</td>
        </tr>
        <tr>
            <td colspan="2" width="550px">
            HISTORY
            </td>
        </tr>
        <tr>
            <td style="padding:50px 100px 50px 50px;" colspan="3" width="550px">
            {{ randomAlbums.content }}
            </td>
      </tr>
    </table>
  </div>
</div>
</template>

<script>

export default {
    data () {
        return {
            albums: [
                {   
                    genre: "락", 
                    image: "https://image.aladin.co.kr/product/4012/57/cover500/c692734333_1.jpg",
                    media: "https://www.youtube.com/embed/ljUtuoFt-8c", 
                    style: "얼터너티브, 그런지 (Grunge)",
                    title: "Nevermind", 
                    artist: "Nirvana", 
                    content: "「Nevermind」는 1990년대의 가장 중요한 록 앨범이 분명하다. 그 뒤틀린 팝송은 펑크의 호전성과 맞닿아 있었지만 그 기저는 메탈의 파워코드와도 만나고 있었다. 앨범은 즉시 비범하고 날카로운 목소리의 주인공 커트 코베인을 록계의 가장 뛰어난  싱어이자 천재적인 감성과 독창성을 가진 작곡가로 만들었다.\n\n송가가 된 톱트랙 ‘Smells Like Teen Spirit’은 차분한 시적 가사와 울부짖는 코러스가 번갈아 교체되면서(후에 코베인은 “난 근본적인 팝송을 쓰려 했다. 기본적으로 픽시스를 베끼려고 노력했다”고 밝혔다고 한다) 죽여주는 리프로 시작하는 곡이며, ‘Come As You Are’는 또 하나의 걸작이다. 코베인의 가사는 까다롭고 모순적이고 어지럽다. ‘Territorial Pissings’는 소란스럽게 허둥지둥하며 휘몰아치는 데이브 그롤의 파워하우스 드럼으로 사람들의 마음을 마구 어지럽힌다. 하지만 이 앨범은 보다 조용한 앨범들에게도 위협을 가하고 있다. ‘Polly’는 애잔한 어쿠스틱 기타로 구성한 유괴된 소녀의 이야기이며, 스산한 첼로를 도입한 ‘Something In The Way’는 커트가 보냈던 힘 들었던 휴지기를 떠올리게 한다.\n\n이 앨범에 딱 맞는 흥미롭고도 불온한 앨범 커버는 인류의 물질만능주의를 비꼬고 있다. 그 주인공은 생후 5개월 된 스펜서 엘든이다. 낚싯바늘과 지폐는 나중에 추가됐다.\n\n너바나의 세계적인 베스트셀러 「Nevermind」는 빌보드 핫 200에서 마이클 잭슨의 「Dangerous」를 때려 눕혔다. 후에 커트는 이 앨범의 매끄러운 사운드에 불만을 품었고, 밴드는 후속 앨범 「In Utero」에서는 조화로움을 깨뜨리는 방향으로 나갔다. 하지만 「Nevermind」의 영향력, 그리고 교묘한 작곡은 그 세대의 뮤지션들에게 많은 영감을 불러일으켰다.\n\n[네이버 지식백과] Nevermind (죽기 전에 꼭 들어야 할 앨범 1001, 2006. 8. 21., 로버트 다이머리)\n\n", 
                    country: "USA", 
                    album_no: 1, 
                    releaseYear: 1991
                },
                {
                    genre: "락", 
                    image: "https://image.aladin.co.kr/product/3947/79/cover500/3581142228_1.jpg", 
                    media: "https://www.youtube.com/embed/eKPlo2D1Q5E", 
                    style: "브릿 팝, 모던 락", 
                    title: "Definitely Maybe", 
                    artist: "Oasis", 
                    content: "1994년 영국의 음악 지형이 얼마나 황량했는지 되돌아보자. 브릿팝은 아직 완전히 성숙하지 못했으며 그런지는 커트 코베인과 함께 죽어버렸다. 그러한 영국 음악씬에 불을 붙이고 이를 재정의한 것은 평범한 노동자계급인 이 다섯 청년이었다.\n\n오아시 스에겐 유년기가 없었다. 맨체스터 거리에서 등장한 이들은 출발부터 성숙한 모습을 지니고 있었다. 「Definitely Maybe」는 그들의 앨범에서 가장 신선하고 영민하고 선동적인 앨범으로, 앨범 커버가 조지 베스트부터 버트 바카락, 그리고 적포도주병(사 실은 블랙커런트 주스지만)까지 그들의 성향을 여실히 보여준다. 풋볼, 음악, 음주. 그들은 그야말로 대중의 밴드였다.\n\n사람들도 그들을 사랑했다. 비틀즈의 곡을 개작하는 데 있어 어떤 주저함도 보이지 않은 그들은 ‘Rock ‘N’ Roll Star’에서 탁 월한 쾌락주의 성가를 들려주고 있으며 활기차고 명랑한 ‘Cigaretts And Alcohol’에서는 티 렉스의 ‘Get It On’을 참고해 또 다른 주제를 보여준다. 또한 뻔뻔하게 뉴 시커스를 도용했지만 ‘Shakermaker’는 명랑하기 그지없다. 한편 ‘Live Forever ’는 밴드의 메인 작곡가 노엘 갤러거의 펜 끝에서 흘러나온 가장 클래시컬한 사운드를 담고 있다. 오아시스의 멤버 다섯 모두가 90년대 로큰롤 정신을 체득하고 있어서 앨범은 오늘날 들어도 무척 만족스럽다. 앨범 끝 곡인 단출한 어쿠스틱 넘버(이른바 감상용 음악은 “엿같다”고 단호히 심판하고 있는)조차 이후로는 볼 수 없던 신랄함을 지니고 있다.\n\n말하자면 오아시스는 음악계에서 셔먼 장군의 탱크 같은 존재였다. 믿을만하고, 종종 파괴적이고, 또한 결코 시비걸고 싶지 않은 그런 팀인 것이다.\n\n[네이버 지식백과] Definitely Maybe (죽기 전에 꼭 들어야 할 앨범 1001, 2006. 8. 21., 로버트 다이머리)\n\n",
                    country: "UK", 
                    album_no: 2, 
                    releaseYear: 1994
                },
                {
                    genre: "락", 
                    image: "https://image.bugsm.co.kr/album/images/500/5522/552236.jpg", 
                    media: "https://www.youtube.com/embed/60CRF5yIvso", 
                    style: "펑크 (Punk)", 
                    title: "American Idiot", 
                    artist: "Green Day", 
                    content: "그린 데이가 21 세기에 하드록 히트작을 만들 것이라 생각한 사람은 거의 없었다. 바로 전 앨범 「Shenanigans」은 미국에서도 ‘고작’ 50만 장 팔렸을 뿐이었고, 싱어이자 기타리스트 빌리 조 암스트롱의 성숙한 작곡능력은 충실한 몇몇 팬만 알고 있었다. 대중은 1994 년 초 히트작 「Dookie」의 여운에 취해 있을 뿐이었다.\n\n암스트롱과 드러머 트레 쿨, 그리고 베이시스트 마이크 던트는 더 심각한 후속작 「Cigarettes And Valentines」를 그냥 행방불명된 테이프일 뿐이라고 치부하고 모든 것을 다시 시작했다(실제야 어떻든, 그 앨범의 프로듀서 롭 카발로는 그저 평범한 노래들이었다고 했다는 소리도 들렸다). 불굴의 노력은 대서양을 가로질러 1위를 하고 수백만 장을 판매한 앨범 「American Idiot」로 보상받았다.\n\n비록 후의 「Quadrophenia」에 빚진 작품이라  해도, 눈살을 찌푸리던 팬들이 반가워한 것은 「American Idiot」가 일관된 주제를 갖고 있었다는 점이다. 「Quadrophenia」가 종교적인 군더더기를 드러낸 지점을 「American Idiot」은 멋진 멜로디로 넘어섰다. 어떤 앨범이든 단 1초도 버릴 게 없는 두 곡의 9분짜리 서사시를 담고 있다고 말하기는 힘들다. 쿨의 무덤덤한 ‘Rock And Roll Girlfriend’ 파트의 가사에서조차 니체를 찾고 있는 ‘Homecoming’은 그들이 「Cigarettes And Valentines」를 재작업해 얻은 수확이다.\n\n‘American Idiot’, ‘Holiday’, ‘Boulevard Of Broken Dreams’, ‘Wake Me Up When September Ends’, 그리고 ‘Jesus Of Suburbia’가 히트곡이었지만, 모든 곡에서 강력한 훅과 활기찬 코러스가 돋보였다. 이 앨범은 매시업(딘 그레이가 재미있게 뒤섞어놓은 ‘American Edit’을 인터넷에서 찾아보라) 속에서도 음악적 감수성이 손상되지 않은 채 살아남았다. 커버에 굳이 수류탄을 그려 넣을 필요는 없었다. 이 앨범의 음악은 반드시 폭발하는 수류탄이나 마찬가지였으니까.\n\n[네이버 지식백과] American Idiot (죽기 전에 꼭 들어야 할 앨범 1001, 2006. 8. 21., 로버트 다이머리)\n\n", 
                    country: "USA", 
                    album_no: 3, 
                    releaseYear: 2004
                },
                {
                    genre: "락", 
                    image: "https://image.bugsm.co.kr/album/images/1000/1142/114200.jpg", 
                    media: "https://www.youtube.com/embed/5BIElTtN6Fs", 
                    style: "펑크 (Punk), 고스 락, 포스트 펑크", 
                    title: "Unknown Pleasures", 
                    artist: "Joy Division", 
                    content: "지역 텔레비전의 명사 토니 윌슨은 주목을 받은 1978년작 「Factory Sample EP」의 후속작에 제작비를 지원했다. 조이 디비전은 메이저 레이블에서 보낸 러브콜을 모두 마다하고, 소규모 인디 레이블인 팩토리에서 밴드의 기념비적 데뷔앨범을 발표하기로 결정했다.\n\n스톡포트의 스트로베리 스튜디오에서 음향에 사로잡힌 하넷의 지휘로 단 일주일 만에 완성한 앨범은, (버나드 섬너로 알려진) 버나드 디큰의 메탈 기타와 피터 훅이 연주한 독특한 베이스 멜로디, 그리고 어쿠스틱과 일렉트 로닉 드럼이 혁신적으로 결합한 작품이었다. 여기에 스티븐 모리스의 드럼 연주와 선구적인 디지털 이펙트와 약한 비명 소리, 유리 파열음이 무기력한 분위기를 만들어냈다.\n\n작사가 이언 커티스는 자신의 간질병 경험을 변종적인 디스코 ‘She’s Lost Control’에 기록했고, ‘Shadowplay’는 1970년대 후반 맨체스터의 도회적 부패와 편집증적인 이미지를 마술처럼 보여준다. 엷은 음악과 차가운 바리톤은 완벽하게 결합했다. 특히 웅장한 죽음의 송가 ‘New Dawn Fades’와 기억에서 지워지지 않는 ‘I Remember Nothing’에서 이 두 가지의 조화는 완벽했다. 에너지 넘치는 ‘Interzone’과 ‘Disorder’는 극단적인 라이브로 유명한 밴드다운 음악이다.\n\n포스트 펑크 시대의 산만한 디자인 경향과 달리 기본 바탕색에 성운에서 방사되는 라디오 주파수만 그려놓은 이 커버는, 그 안에 담긴 음악처럼 기존의 틀을 깨는 작품이었고, 미니멀 디자인의 혁명을 가져오는 결과를 낳았다.\n\n「Unknown Pleasures」는 상업적, 비평적으로 큰 성공을 거두었다(한 평론가가 앨범을 두고 “자살을 생각하는 사람들이 가 장 먼저 들어야 할 앨범”이라고 비꼬긴 했다). 25년이 지난 지금도 「Unknown Pleasures」는 들을 때마다 심취하게 만드는 앨범이다.\n\n[네이버 지식백과] Unknown Pleasures (죽기 전에 꼭 들어야 할 앨범 1001, 2006. 8. 21., 로버트 다이머리)\n\n", 
                    country: "UK", 
                    album_no: 4, 
                    releaseYear: 1979
                },
                {
                    genre: "락", 
                    image: "https://image.bugsm.co.kr/album/images/1000/202/20299.jpg", 
                    media: "https://www.youtube.com/embed/LBt60dfwEBY", 
                    style: "브릿 팝", 
                    title: "OK Computer", 
                    artist: "Radiohead", 
                    content: "스미스와 퀸 사운드의 무분별한 합성. 다행히 라디오헤드가 영향받은 기이함은 그들의 재능과 잘 어울렸고, 세 번째 앨범은 전작 「The Bends」보다 더 큰 도약을 이루었다.\n\n초기 히트곡 ‘Creep’으로 부풀려진 명성도 리더 톰 요크를 도취시키지는 못했다. 앨범에서 가장 긍 정적인 ‘Airbag’은 “사고를 피한 직후 느끼는 깊은 안도감”에 대한 곡이다. 다른 곳에서 그는 대부분 분노를 터뜨리고 있는데, ‘Electioneering’은 “비즈니스와 거짓말”에 대해, ‘Let Down’은 “덫에 걸린 상황”을, ‘Climbing Up The Walls’ 는 “벽장 속 괴물”을 다룬다. 가장 생생한 곡 ‘Paranoid Android’의 헷갈리는 제목은 『은하수를 여행하는 히치하이커를 위한 안내서』에서 따온 것이다. 상류층의 코카인 중독증에서 영감을 얻은 가사는 등골이 오싹할 정도로 극도의 혼돈상태를 환기시킨다.\n\n이런 공포스러운 가사는 음악적인 아름다움으로 완화된다. ‘Subterranean Homesick Alien’의 감각적인 몽롱함, 영롱한 글로켄슈필이 주도하는 ‘No Surprises’, 마치 제인 세이모어의 무도회장에서 녹음한 것처럼 사랑스러운 ‘Let Down’, 반면에 ‘Lucky’와 ‘The Tourist’는 유쾌한 핑크 플로이드 같다.\n\n놀라운 소리의 향연은 그 뿐이 아니다. DJ 셰도우 같은 드럼 루프를 담은 ‘Airbag’, 비틀즈의 ‘Happiness Is A Warm Gun’ 같은 서사시 ‘Paranoid Android’, 스티븐 호킹 박사의 목소리를 듣는 듯한 ‘Fitter Happier’(사실은 톰 요크가 애플 컴퓨터로 프로그래밍한 소리)는 또 어떤가.\n\n혼란스럽고 모호한 앨범 커버로 마무리한 「OK Computer」는 미국차트까지 점령했지만, 밴드는 이런 결과가 과장된 것이라고 보았다. 그러나 이 작품은 1997년에 그랬던 것처럼 여전히 야심적이며 황홀하게 들린다.\n\n[네이버 지식백과] OK Computer (죽기 전에 꼭 들어야 할 앨범 1001, 2006. 8. 21., 로버트 다이머리)", 
                    country: "UK", 
                    album_no: 5,
                    releaseYear: 1997
                }
            ],
        }
    },
    computed: {
        randomAlbums () {
            return this.albums[Math.floor(Math.random() * this.albums.length)]
        },
    }
}
</script>

<style scoped>

.네모박스 {
  background: #e0c1d4a4;
}

.테이블 {
  padding:1px 100px 200px 100px;
}
</style>