<template>
    <v-footer padless color="grey lighten-5" style="overflow: hidden;">
        <v-col class="footer_txt text-center" cols="12">
           {{ new Date().getFullYear() }} — <span>Copyright © CATMORE All rights reserved</span>
        </v-col>
    </v-footer>
</template>

<style scoped>
.footer_txt {
  color: #424242;
  font-size: 13px;
  border-top: 1px solid #BDBDBD;
}
</style>