<template>
  <div id="app" class="flex flex-1">
    <MainPage />
  </div>
</template>

<script>
import MainPage from "./components/MainPage.vue";

export default {
  name: "app",
  components: {
    MainPage
  }
};
</script>

<style lang='less'>
@import "./assets/css/common.css";

html,
body {
  height: 100%;
}
#app {
  font-family: "Regular";
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  background-color: #f1f4fb;
  height: 100%;
  overflow:hidden;
}
</style>
