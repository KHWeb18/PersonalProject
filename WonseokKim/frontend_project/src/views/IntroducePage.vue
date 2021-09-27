<template>
    <div>
        <v-spacer></v-spacer>
        <div align="center">
            <p>_________</p>
            <h1>LoM 개요</h1>
            <p>_________</p>
        </div>
        <introduce-page-form/>
    </div>
</template>

<script>

import IntroducePageForm from '@/components/introduce/IntroducePageForm.vue'

export default {
    name: 'IntroducePage',
    components: {
        IntroducePageForm
    }
}
</script>