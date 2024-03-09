<template>
    <div>
        <h1>影片名：{{title}}</h1>
        <span>评分：{{ rating }}</span>
        <a @click="fun" class="fa fa-star-o fa-1.9x"></a>
    </div>
</template>
<script>

import axios from 'axios'

export default {
    name: 'Movie',
    props: ['title', 'rating'],
    data: function() {
        return {
            
        }
    },
    methods: {
        fun() {
            debugger
            alert("收藏成功")
        }
    }
}
</script>