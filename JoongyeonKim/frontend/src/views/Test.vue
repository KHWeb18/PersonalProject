<template>
  <div class="test">
      <div id="header">
          <router-link :to="{ name: 'MemberRegisterPage' }"
                  class="nav-link"
                  active-class="active">
              회원가입 테스트
          </router-link>
          <router-link :to="{ name: 'MemberLoginPage' }"
                  class="nav-link"
                  active-class="active">
              로그인 테스트
          </router-link>
          <router-link :to="{ name: 'FundingRegisterPage' }"
                  class="nav-link"
                  active-class="active">
              펀딩 등록 테스트
          </router-link>
          <router-link :to="{ name: 'MainPage' }"
                  class="nav-link"
                  active-class="active">
              펀딩메인화면 테스트
          </router-link>
          <!--
          <router-link :to="{ name: 'FundingDetail' }"
                  class="nav-link"
                  active-class="active">
              펀딩 자세히보기 테스트
          </router-link>
          <router-link :to="{ name: 'ImageInsert' }"
                  class="nav-link"
                  active-class="active">
              이미지등록 테스트
          </router-link>
          <router-link :to="{ name: 'SalesList' }"
                  class="nav-link"
                  active-class="active">
              내가올린 펀딩 자세히보기  테스트
          </router-link>
          <router-link :to="{ name: 'FundingUpdate' }"
                  class="nav-link"
                  active-class="active">
              ???  테스트
          </router-link>
          -->
          <router-link :to="{ name: 'MainPage' }"
                  class="nav-link"
                  active-class="active">
              메인페이지 확인
          </router-link>
          <router-link :to="{ name: 'BoardRegisterPage' }"
                  class="nav-link"
                  active-class="active">
              게시판 글 생성 확인
          </router-link>
          <router-link :to="{ name: 'BoardListPage' }"
                  class="nav-link"
                  active-class="active">
              게시판리스트 확인
          </router-link>
          <router-link :to="{ name: 'FundingListPage' }"
                  class="nav-link"
                  active-class="active">
              펀딩 프로젝트 리스트 확인
          </router-link>
          <router-link :to="{ name: 'MemberListPage' }"
                  class="nav-link"
                  active-class="active">
              회원 리스트 확인
          </router-link>
      </div>
  </div>
</template>

<script>
  

  export default {
    name: 'Test',
    components: {
    }
  }
</script>
