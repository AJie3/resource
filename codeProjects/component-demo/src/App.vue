<template>
  <div id="app">
    <Movie v-for="movie in movies" :key="movie.id" :title="movie.title" :rating="movie.rating"></Movie>
    <hello></hello>
    <user></user>
  </div>
</template>

<script>
import Movie from './components/Movie.vue'
import Hello from './components/Hello.vue'
import User from './components/User.vue'

 
export default {
  name: 'App',
  components: {
    Movie,
    Hello,
    User,
    User
  },
  data: function() {
    return {
      movies: [
        {id: 1, title: '叮当猫', rating: 9.9},
        {id: 2, title: '机器牛', rating: 8.7},
        {id: 3, title: '机器猪', rating: 6.9},
        {id: 4, title: '机器狗', rating: 5.5},
        {id: 5, title: '机器猫', rating: 10}
      ]
    }
  },
  methods: {

  },
  created: function() {
    
  },
  mounted: function() {

  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
