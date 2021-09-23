<template>
	<v-app>
		<v-main style="width: 100%">
			<Navigation/>
			<router-view class="page"/>
			<Footer/>
		</v-main>
	</v-app>
</template>

<script>
  // import HelloWorld from './components/HelloWorld';
  import Navigation from './components/Navigation.vue';
  import Footer from './components/Footer.vue';

  export default {
    name: 'App',

    components: {
      Navigation,
      Footer,
      // HelloWorld,
    },

    data: () => ({
      //
    }),
  };
</script>
