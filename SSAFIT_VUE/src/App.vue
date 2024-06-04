<template>
  <div>
    <TheHeader />
    <main>
      <RouterView />
    </main>
  </div>
</template>

<script setup>
import TheHeader from '@/components/common/TheHeader.vue'
</script>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  list-style: none;
}

a {
  text-decoration: none;
  color: #787878;
}

main {
  padding-bottom: 50px;
}
</style>
