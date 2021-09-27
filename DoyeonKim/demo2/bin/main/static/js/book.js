//일종의 생성자 역할을 해줄 수 있는 함수
function Book (title, author, volume, price, url) {
    this.title = title;
    this.author = author;
    this.volume = volume;
    this.price = price;
    this.url = url;
}
//작성한 함수를 사용해서 html, youtube, python 객체를 만든다.
var html = new Book ('웹 마스터','ko', '608');
var youtube = new Book ('하루만에 만드는 유튜브', 'kim', '1069', '40000');
var python = new Book ('일주일만에 파이썬', 'park', '352', '18000');
//객체를 열어보면 json에 저장
//html, youtube python 객체를 배열에 저장
var bookList = [html, youtube, python];

document.write("<h1>책 제목으로 살펴보기</h1>");

for (var i = 0; i < bookList.length; i++){
    document.write("<p><a href='#'" + bookList[i].title + ", 가격: " +
     bookList[i].price + ",쪽수: " +bookList[i].volume + "</p>")
}