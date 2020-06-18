<template>
  <div class="insert_div">
    <h3>맛집 등록</h3>
    <form method="post">
      <div class="insert_main_div">
        <div class="insert_select_div">
          <select class="insert_food_menu" v-model="foodType">
            <option value="" selected disabled hidden>음식 카테고리 선택</option>
            <option value="한식">한식</option>
            <option value="중식">중식</option>
            <option value="일식">일식</option>
            <option value="분식">분식</option>
          </select>
        </div>
        <div class="insert_input_div">
          가게명<br>
          <input type="text" v-model="name"><br>
        </div>
        <div class="insert_input_div">
          번호<br>
          <input type="text" v-model="tel"><br>
        </div>
        <div class="insert_input_div">
          주소<br>
          <input type="text" v-model="address"><br>
        </div>
        <div class="insert_input_div">
          영업시간<br>
          <input type="time" v-model="open_time"> ~
          <input type="time" v-model="end_time"><br>
        </div>
        <div class="insert_input_div">
          대표음식<br>
          <input type="text" v-model="pname"><br>
        </div>
        <div class="insert_input_div">
          가격<br>
          <input type="text" v-model="cost"><br>
        </div>
        <div class="insert_input_div">
          가게 사진<br>
          <input type="file" v-on:change="img"/>
          <div v-if="preview"><img v-bind:src="preview"></div>
        </div>
      </div>
    </form>
    <div class=insert_btn>
      <button class="insert_page_btn">완료</button>
    </div>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        foodType: '',
        name: '',
        tel: '',
        address: '',
        open_time: '',
        end_time: '',
        pname: '',
        cost: '',
        preview: ''
      }
    },
    methods: {
      img(event) {
        var file = event.target.files[0];
        if (file && file.type.match('/^image\/(png|jpeg)')) {
          this.preview = window.URL.createObjectURL(file);
          console.log("Hi,methods");
        }
      }
    }
  }
</script>
