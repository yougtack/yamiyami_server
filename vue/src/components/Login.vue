<template>
  <div class="login_div">
    <form method="POST">
      <div>
        <h3 style="text-align: center;">로그인</h3>
        <div class="login_id">
          <input type="text" placeholder="아이디"/>
        </div>
        <div class="login_pw">
          <input type="password" placeholder="비밀번호"/>
        </div>
        <div class="login_btn">
          <button type="button">로그인</button>
          <router-link to="/member/signUp" tag="button">회원가입</router-link>
        </div>
      </div>
      <!-- <div v-if="">
      test="${!empty member.userId}"
        <h3 style="text-align: center;">회원정보</h3>
        <button type="button" id="check_logout" style="text-align: center;">로그아웃</button>
      </div>
      -->
    </form>
  </div>
</template>
<script>
  export default {}
</script>
