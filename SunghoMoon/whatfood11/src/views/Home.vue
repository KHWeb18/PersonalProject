<template>
    <div class="home">
    <div id="header">

    <nav v-bind:class="active" v-on:click.prevent>    
    <router-link :to="{ name: 'VuetifyMemberRegisterPage' }"  class="nav-link" active-class="active">
    회원가입
    </router-link>
    <router-link :to="{ name: 'VuetifyMemberLoginPage' }"  class="nav-link"  active-class="active">
    로그인
    </router-link>   
    <router-link :to="{ name: 'BoardListPage' }" class="nav-link" active-class="active">
    자유게시판
    </router-link>
    <router-link :to="{ name: 'CalendarTestPage' }" class="nav-link" active-class="active">
    이달의 할인 메뉴
    </router-link> 
    <router-link :to="{ name: 'ImageGalleryTestPage' }" class="nav-link" active-class="active">
    후기 사진
    </router-link>    
    </nav>
    </div>
    </div>
            
    </template>

<script>
export default {
    name: 'Home'
}
</script>

<style>
 *{
  margin:0;
  padding:0;
}

body{
  font:15px/1.3 'Open Sans', sans-serif;
  color: #5e5b64;
  text-align:center;
}

a, a:visited {
  outline:none;
  color:#ff1744;
}

a:hover{
  text-decoration:none;
}

section, footer, header, aside, nav{
  display: block;
}

/*-------------------------
  The menu
--------------------------*/

nav{
  display:inline-block;
  margin:60px auto 45px;
  background-color:#ff1744;
  box-shadow:0 1px 1px #ccc;
  border-radius:2px;
}

nav a{
  display:inline-block;
  padding: 18px 30px;
  color:#fff !important;
  font-weight:bold;
  font-size:16px;
  text-decoration:none !important;
  line-height:1;
  text-transform: uppercase;
  background-color:transparent;

  -webkit-transition:background-color 0.25s;
  -moz-transition:background-color 0.25s;
  transition:background-color 0.25s;
}

nav a:first-child{
  border-radius:2px 0 0 2px;
}

nav a:last-child{
  border-radius:0 2px 2px 0;
}

nav.home .home,
nav.projects .projects,
nav.services .services,
nav.contact .contact{
  background-color:#e35885;
}

p{
  font-size:22px;
  font-weight:bold;
  color:#7d9098;
}

p b{
  color:#ffffff;
  display:inline-block;
  padding:5px 10px;
  background-color:#c4d7e0;
  border-radius:2px;
  text-transform:uppercase;
  font-size:18px;
}
.resource {
  margin: 20px 0;
}
</style>

