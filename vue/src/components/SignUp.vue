<template>
  <div>
    <h3 style="text-align:center">회원가입</h3>
    <div class="signup_div">
      아이디<br>
      <input type="text" v-model="userId"><br><br>
      비밀번호<br>
      <input type="password" v-model="userPw"><br><br>
      비밀번호 확인<br>
      <input @keyup.enter="SignUp_Check" type="password" v-model="userPwTest"><br><br>
      <div v-if="NullOk">빈 칸에 값을 넣어주세요.</div>
      <div v-if="CheckOk">비밀번호가 불일치합니다.</div>
    </div>
    <div class="signup_btn_div">
      <input @click="SignUp_Check" type="button" value="완료">
    </div>
  </div>
</template>
<script>
  import axios from 'axios';

  export default {
    data() {
      return {
        userId: ''.trim(),
        userPw: ''.trim(),
        userPwTest: ''.trim(),
        NullOk: false,
        CheckOk: false
      }
    },
    methods: {
      /**
       * @return {boolean}
       */
      SignUp_Check: function () {
        const params = new URLSearchParams();
        if (!this.userId || !this.userPw || !this.userPwTest) {
          this.NullOk = !this.NullOk;
        } else if (this.userPw !== this.userPwTest) {
          this.CheckOk = !this.CheckOk;
        } else {
          params.append('userId', this.userId);
          params.append('userPw', this.userPw);
          axios.post('/member/signUp', {params}
          ).then((ex => {
            alert("들어갔음", ex);
          })).catch((ex => {
            if (ex.response) {
              console.log("response Error", ex);
            } else if (ex.request) {
              console.log("request Error", ex);
            } else {
              console.log("Error", ex);
            }
          }))
        }
      }
    }
  }
</script>
