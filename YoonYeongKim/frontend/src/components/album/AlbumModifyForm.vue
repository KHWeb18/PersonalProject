<template>
    <div>
        <h3>앨범 도감 변경폼</h3>
        <form @submit.prevent="onSubmit">
            <table>
                <tr>
                    <td>앨범번호</td>
                    <td><input type="text" :value="album.albumNo" disabled></td>
                </tr>
                <tr>
                    <td>등록일자</td>
                    <td><input type="text" :value="album.regDate" disabled></td>
                </tr>
                <tr>
                    <td>타이틀</td>
                    <td><input type="text" v-model="title"></td>
                </tr>
                <tr>
                    <td>아티스트</td>
                    <td><input type="text" v-model="artist"></td>
                </tr>
                <tr>
                    <td>발매연도</td>
                    <td><input type="number" v-model="releaseYear"></td>
                </tr>
                <tr>
                    <td>장르</td>
                    <td><input type="text" v-model="genre"></td>
                </tr>
                <tr>
                    <td>스타일</td>
                    <td><input type="text" v-model="style"></td>
                </tr>
                <tr>
                    <td>국가</td>
                    <td><input type="text" v-model="country"></td>
                </tr>
                <tr>
                    <td>설명</td>
                    <td><textarea cols="20" rows="15" v-model="content"></textarea></td>
                </tr>
                <tr>
                    <td>이미지주소</td>
                    <td><textarea cols="20" rows="15" v-model="image"></textarea></td>
                </tr>
                <tr>
                    <td>미디어주소</td>
                    <td><textarea cols="20" rows="15" v-model="media"></textarea></td>
                </tr>
            </table>

            <div>
                <button type="submit">수정 완료</button>
                <router-link :to="{ name: 'AlbumReadPage', params: { albumNo: album.albumNo.toString() } }">
                    취소
                </router-link>
            </div>
        </form>
    </div>
</template>

<script>

export default {
    name: 'AlbumModifyForm',
    props: {
        album: {
            type: Object,
            required: true
        }
    },
    data () {
        return {
            title: '',
            artist: '',
            releaseYear: 0,
            genre: '',
            style: '',
            country: '',
            content: '',
            image: '',
            media: ''
        }
    },
    methods: {
        onSubmit () {
            const { title, artist, releaseYear, genre, style, country, content, image, media } = this
            this.$emit('submit', { title, artist, releaseYear, genre, style, country, content, image, media })
        }
    },
    created () {
        this.title = this.album.title
        this.artist = this.album.artist
        this.releaseYear = this.album.releaseYear
        this.genre = this.album.genre
        this.style = this.album.style
        this.country = this.album.country
        this.content = this.album.content
        this.image = this.album.image
        this.media = this.album.media
    }
}

</script> 