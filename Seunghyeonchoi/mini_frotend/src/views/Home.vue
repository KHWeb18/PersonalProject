<template>
    <div class="home">
        <v-spacer style="background-color: black;height: 90px;"></v-spacer>
        <div id="header">
            <br>
            <br>
            <router-link :to="{ name: 'Home' }"
                    class="nav-link"
                    active-class="active">
                Home
            </router-link>  
            <router-link :to="{ name: 'NoticeBoardListPage' }"
                    class="nav-link"
                    active-class="active">
                NoticeBoard
            </router-link>
            <router-link :to="{ name: 'VuetifyAllOneTestPage' }"
                    class="nav-link"
                    active-class="active">
                Vuetify 활용
            </router-link>
            <router-link :to="{ name: 'MainPage' }"
                    class="nav-link"
                    active-class="active">
                MainPage
            </router-link>
            <router-link :to="{ name: 'MemberJoinColumn' }"
                    class="nav-link"
                    active-class="active">
                MemberJoinColumn
            </router-link>
            <router-link :to="{ name: 'FoodRegisterPage' }"
                    class="nav-link"
                    active-class="active">
                FoodRegisterPage
            </router-link>
            <router-link :to="{ name: 'FoodListPage' }"
                    class="nav-link"
                    active-class="active">
                FoodListPage
            </router-link>
            <router-link :to="{ name: 'TestPage' }"
                    class="nav-link"
                    active-class="active">
                TestPage
            </router-link>
            
            
        </div>
    </div>
</template>

<script>
export default {
    name: 'Home'
}

</script>