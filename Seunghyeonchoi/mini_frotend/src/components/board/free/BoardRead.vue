<template>
    <div>
        <div class="main_box">
            <!-- 제목 -->
            <div class="title_box">
                <h4 class="page_title">
                    <v-icon>mdi-exclamation-thick</v-icon>
                    <span>자유게시판</span></h4>
            </div>
            <!-- 게시글 리스트 -->
            <div class="post_list">
                <div class="post_card_box">
                    <div class="searching_message_box">
                        <div class="searching_message">
                            <div style="margin-top:20px;"><b>{{board.title}}</b></div>
                            <div><p><b class="post_tag">#사료추천</b> / {{board.nickname}} / {{board.regDate}}</p></div>
                        </div>
                    </div>
                </div>
                <div class="content_img">
                    <img :src="ImgRequest()" class="test">
                </div>
                <div class="post_content">
                    <div style="white-space:pre-line;">{{ board.content }}</div>
                </div>
            </div>
        </div>        
    </div>
</template>

<script>
export default {
    name: 'BoardRead',
    props: {
        board: {
            type: Object,
            required: true
        }
    },
    methods : {
        ImgRequest() {
            try {
                return require(`../../../../../Mini/Images/free/${this.board.writer}_${this.board.boardNo}.gif`
                )
            } catch (e) {
                return require(`@/assets/logo.png`)
            }
        }
    }
}
</script> 

<style scoped>
.post_list {
    width:70vw;
    max-width: 1000px;
}
.main_box {
    color: #424242;
}
.title_box {   
}
.title_box span {
    font-size: 25px;
    font-weight: bold;
}
.page_title {
}
.option_box {
    display: flex;
    justify-content: flex-end;
    width: 70vw;    
    max-width: 1000px;
}
.searching_box {    
    height: 50px;
}
.searching_bar {
    display: flex;
    justify-content: row;
    height: 40px;
    width:70vw;
    max-width: 1000px;
    border: 1px solid #BDBDBD;
}
.searching {
    height: 38px !important; 
    width:60vw !important;
    max-width: 955px;
    border-style: none !important;
}
.searching_message_box {
    width:70vw;
    height: 150px;
    max-width: 1000px;
    display:flex;
    justify-content: center;
}
.searching_message {
    display: flex;
    justify-content: center;
    flex-direction: column;
    width:70vw;
    max-width: 900px;
    border-top: 1px solid #BDBDBD;
    border-bottom: 1px solid #BDBDBD;
    margin-top: 50px;
}
.searching_message div {
    text-align: center;
    font-colr: #333333;
    font-size: 20px;
}
.searching_message b {
    letter-spacing: 2px;
    font-size: 26px;
}
.searching_message p {    
    font-size: 13px;
    color: #757575;

}




.post_align {
    display: flex;
    justify-content: center;
    flex-direction: column;
}
.post_card:hover {
    transform: scale(1.005);
    box-shadow: 10px 17px 40px 0 rgb(0 0 0 / 4%);
    cursor: pointer;
    transition: all 0.1s ease;
}
.post_card {
    display: flex;
    justify-content: row;
    margin: 15px;
    padding: 20 20 5 5;
    height: 150px;
    border-bottom: 1px solid #BDBDBD;
}
.post_card_box {

}
.content_img {
    text-align: center;
    width: 70vw;
    max-width: 1000px;
}
.thumbnail {
    margin-right: 20px;
    height: 140px !important; 
    width: 140px !important; 
}
.thumbnail_img {
    width: 100%;
    height: 100%;
}
.post_box {
    margin: 10px 10px 20px 5px;
    display: flex;
    flex-direction: column;
    height: 100px;
    width: 500px;
}
.post_tag {
    color: #0288D1;
    font-weight: bold;
    font-size: 16px !important;    
    letter-spacing: 0px !important;
}
.post_title {
    margin: 0 0 0 0px;
    font-size: 17px;
    font-weight: bold;
    color: #424242;
}
.post_title:hover {
    color: #29B6F6;
    text-decoration: underline;
}
.post_content {
    font-size: 15px;
    color: #757575;
    padding-bottom: 10px;
}
.post_reg_date {
    font-size: 13px;
    color: #757575;
}
.btn_pagination {
    background-color: transparent;
    box-shadow: none;
}
.button_box {
    margin-top: 10px;
    display: flex;
    justify-content: flex-end;
}
.change-font {
    font: 12pt;
    color: white;
    font-weight: 800;
}
.v-input__slot::before {
  border-style: none !important;
}
::placeholder {
    font-size: 13px;
    letter-spacing: 0;
    color: #757575d0;    
}
.post_image {
    margin: 50px;
    width: 40vw;
}
.test {
    max-width: 50vw;
    max-width: 60vw;
    margin: 80px 0 30px 0;
}
.v-application a {
    color: #757575 !important;
    font-weight: bold;
}
.middle_btn_box {
    margin-top: 10px;
}
.item {
    cursor: pointer;
}
</style>