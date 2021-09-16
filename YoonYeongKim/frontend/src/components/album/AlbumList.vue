<template>
    <div>
        <h3>게시물 목록</h3>
        <table border="1">
            <tr>
                <th align="center" width="50">번호</th>
                <th align="center" width="250">타이틀</th>
                <th align="center" width="150">아티스트</th>
                <th align="center" width="200">발매연도</th>
                <th align="center" width="150">장르</th>
                <th align="center" width="150">스타일</th>
                <th align="center" width="200">국가</th>
                <th align="center" width="200">내용</th>
                <th align="center" width="200">이미지주소</th>
                <th align="center" width="200">미디어주소</th>
            </tr>
            <tr v-if="!albums || (Array.isArray(albums) && albums.length === 0)">
                <td colspan="4">
                    현재 등록된 게시물이 없습니다.
                </td>
            </tr>
            <tr v-else v-for="album in albums" :key="album.albumNo">
                <td align="center">{{ album.albumNo }}</td>
                <td align="left">
                    <router-link :to="{ name: 'AlbumReadPage',
                                    params: { albumNo: album.albumNo.toString() } }">
                        {{ album.title }}
                    </router-link>
                </td>
                <td align="center">{{ album.title }}</td>
                <td align="center">{{ album.artist }}</td>
                <td align="center">{{ album.releaseYear }}</td>
                <td align="center">{{ album.genre }}</td>
                <td align="center">{{ album.style }}</td>
                <td align="center">{{ album.country }}</td>
                <td align="center">{{ album.content }}</td>
                <td align="center">{{ album.image }}</td>
                <td align="center">{{ album.media }}</td>
            </tr>
        </table>
    </div>
</template>

<script>

export default {
    name: 'AlbumList',
    props: {
        albums: {
            type: Array
        }
    }
}

</script>