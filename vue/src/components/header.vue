<template>
  <div id="main_header">
    <header>
      <div class="main_title">
        <router-link to="/Home"><h3>맛집 연구소</h3></router-link>
      </div>
      <div class="wrap">
        <div class="search">
          <input type="text" class="searchTerm" placeholder="Search">
          <router-link to="/SearchList" tag="button" class="searchButton">
            <img src="../assets/picture/search_icon.png">
          </router-link>
        </div>
      </div>
    </header>
  </div>
</template>
<script>
  export default {}
</script>
