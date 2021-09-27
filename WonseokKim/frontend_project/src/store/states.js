export default {
    // 회원가입
    emailRules: [
        v => !!v|| '이메일을 작성해주세요.',
    ],
    passwordRules: [
        v => !!v || '비밀번호를 작성해주세요',
    ],
    // 공지사항 게시판
    notices: [],
    notice: null,
    //크롤링
    lists: [],
    // 질문 게시판
    questions: [],
    question: null,
    // 세션
    session: []
}
