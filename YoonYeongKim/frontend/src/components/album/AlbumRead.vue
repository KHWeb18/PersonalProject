<template>
    <div>
        <h3>앨범 읽기</h3>
        <table>
            <tr>
                <td>번호</td>
                <td><input type="text" :value="album.albumNo" readonly></td>
            </tr>
            <tr>
                <td>등록일자</td>
                <td><input type="text" :value="album.regDate" readonly></td>
            </tr>
            <tr>
                <td>타이틀</td>
                <td><input type="text" :value="album.title" readonly></td>
            </tr>
            <tr>
                <td>아티스트</td>
                <td><input type="text" :value="album.artist" readonly></td>
            </tr>
            <tr>
                <td>발매연도</td>
                <td><input type="number" :value="album.releaseYear" readonly></td>
            </tr>
            <tr>
                <td>장르</td>
                <td><input type="text" :value="album.genre" readonly></td>
            </tr>
            <tr>
                <td>스타일</td>
                <td><input type="text" :value="album.style" readonly></td>
            </tr>
            <tr>
                <td>국가</td>
                <td><input type="text" :value="album.country" readonly></td>
            </tr>
            <tr>
                <td>설명</td>
                <td><textarea cols="50" rows="15" :value="album.content" readonly></textarea></td>
            </tr>
            <tr>
                <td>이미지주소</td>
                <td><textarea cols="20" rows="15" :value="album.image" readonly></textarea></td>
            </tr>
            <tr>
                <td>미디어주소</td>
                <td><textarea cols="20" rows="15" :value="album.media" readonly></textarea></td>
            </tr>
        </table>
    </div>
</template>

<script>

export default {
    name: 'AlbumRead',
    props: {
        album: {
            type: Object,
            required: true
        }
    }    
}

</script>