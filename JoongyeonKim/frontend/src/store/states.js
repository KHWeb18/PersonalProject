export default {
    // ========= Rules =============== //
    emailRules: [
        v => !!v || '이메일을 작성해주세요.',
        v => /.+@.+\..+/.test(v) || '이메일 형식으로 작성해주세요.',
    ],
    nameRules: [
        v => !!v || '이름을 작성해주세요.',
        v => !/[~!@#$%^&*()_+|<>?:{}]/.test(v) || '이름에는 특수문자를 사용할 수 없습니다'
    ],
    passwordRules: [
        v => !!v || '비밀번호를 작성해주세요.'
    ],
    // ============ user ============== //
    // 회원
    members: [],
    member: null,
    // 세션
    session: [],
    //크롤링
    lists: [],
    // 게시판
    boards: [],
    board: null,
    // 펀딩 프로젝트
    fundings: [],
    funding: null,
}