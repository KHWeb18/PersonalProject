<template>
    <form @submit.prevent="onSubmit">
        <h3>앨범 등록</h3>
        <table border=1>
            <tr>
                <td>타이틀</td>
                <td><input type="text" v-model="title" placeholder="여기에 입력"></td>
            </tr>
            <br>
            <tr>
                <td>아티스트</td>
                <td><input type="text" v-model="artist" placeholder="여기에 입력"></td>
            </tr>
            <br>
            <tr>
                <td>발매연도</td>
                <td><input type="number" v-model="releaseYear" placeholder="여기에 입력"></td>
            </tr>
            <br>
            <tr>
                <td>장르</td>
                <td><input type="text" v-model="genre" placeholder="여기에 입력"></td>
            </tr>
            <br>
            <tr>
                <td>스타일</td>
                <td><input type="text" v-model="style" placeholder="여기에 입력"></td>
            </tr>
            <br>
            <tr>
                <td>국가</td>
                <td><input type="text" v-model="country" placeholder="여기에 입력"></td>
            </tr>
            <br>
            <tr>
                <td>설명</td>
                <td><textarea cols="100" rows="15" v-model="content"></textarea></td>
            </tr>
            <br>
            <tr>
                <td>이미지주소</td>
                <td><textarea cols="100" rows="5" v-model="image"></textarea></td>
            </tr>
            <br>
            <tr>
                <td>미디어주소</td>
                <td><textarea cols="100" rows="5" v-model="media"></textarea></td>
            </tr>
        </table>

        <div>
            <button type="submit">등록</button>
            <router-link :to="{ name: 'AlbumListPage' }">
                취소
            </router-link>
        </div>
    </form>
</template>

<script>
export default {
    name: 'AlbumRegisterForm',
    data () {
        return {
            title: '',
            artist: '',
            releaseYear: '',
            genre: '',
            style: '',
            country: '',
            content: '',
            image: '',
            media: '',
        }
    },
    methods: {
        onSubmit () {
            const { title, artist, releaseYear, genre, style, country, content, image, media } = this
            this.$emit('submit', { title, artist, releaseYear, genre, style, country, content, image, media })
        }
    }
}
</script> 