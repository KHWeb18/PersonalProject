<template>
    <button @click="addCounter">{{ counter }}</button>
</template>

<script>

export default {
   name: 'global-component',
   props: ['initialTest'], //사용하는 이유는 컴포넌트간의 데이터 전달
   // 템플릿의 경우엔 컴포넌트를 배치했을때 자동으로 생성되는 HTML 태그를 의미한다.
   template: '<button @click="addCounter">{{ counter }}</button>',
   data() {
       return {
           counter: this.initialTest
       }
   },
   methods: {
       addCounter () {
           this.counter += 1
       }
   }
}
</script>
