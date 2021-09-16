// .eslintrc.js
module.exports = {
  // 비동기처리 문법오류 방지
  parserOptions : {
    parser: 'babel-eslint',
  },
  extends: [
    'plugin:vue/recommended',
  ],
  plugins: [
    'vuetify'
  ],
  rules: {
    'vuetify/no-deprecated-classes': 'error',
    'vuetify/no-legacy-grid': 'error',
    //No 레거시
    'indent': ["error", 2]
    //두칸 뛰어쓰기
  },
 
}

