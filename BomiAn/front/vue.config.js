const target = 'http://127.0.0.1:3000'

module.exports = {
  transpileDependencies: [
    'vuetify'
  ],
  devServer: {
    proxy: {
      '/api': {
        target: 'http://localhost:3000',
        changeOrigin: true,
        pathRewirte: {
          '^/api': ''
        }
      }
    }
  },
}
