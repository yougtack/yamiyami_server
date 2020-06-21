<template>
  <div>
    <h3 style="text-align:center">회원가입</h3>
    <div class="signup_div">
      아이디<br>
      <input type="text" v-model="userId"><br><br>
      비밀번호<br>
      <input type="password" v-model="userPw"><br><br>
      비밀번호 확인<br>
      <input @keyup.enter="SignUp" type="password" v-model="userPwTest"><br><br>
    </div>
    <div class="signup_btn_div">
      <input @click="SignUp" type="button" value="완료">
    </div>
  </div>
</template>
<script>
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
      SignUp: function () {
        let student = {
          userId: this.userId,
          userPw: this.userPw
        };
        let json = JSON.stringify(student);

        this.$http.post('/api/member/signUp', {
          json
        }).then(res => {
          console.log(res.data);
        }).catch(res => {
          console.warn(json);
          console.warn(res);
        });

      }
    }
  }
  /*
  if (!this.userId || !this.userPw || !this.userPwTest) {
          alert("빈 칸에 값을 넣어주세요.");
        } else if (this.userPw !== this.userPwTest) {
          alert("비밀번호가 일치하지않습니다.");
        } else {
        }
   */
</script>
