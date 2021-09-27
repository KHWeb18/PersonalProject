<template>
  <div>
    <contact-list-index app />
  </div>
</template>

<script>

export default {
  components: {
    ContactListIndex: () => import('../components/contact/Index.vue')
  }

}
</script>

<style>

</style>
