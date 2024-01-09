<template>
<!--  <Demo/>-->
  <MyLayout page_title="商家登录" user_type="商家" @getInfo="shopLogin"/>
</template>

<script>
import MyLayout from '../components/MyLayout.vue'

export default {
  name: 'SellerLogin',
  components: {
    MyLayout,
  },
  data() {
    return {
      info: {},
    }
  },
  methods: {
    shopLogin(info) {
      const username = info.id
      const password = info.pwd
      this.$http.get('shop', {
        params: {
          shop_id: username,
          password
        }
      }).then((res) => {
        if (res.data === '登录成功') {
          this.info = info
          this.$store.state.shop_id = username
          this.$store.state.shop_pwd = password
          this.$router.push('/ShopManager')
        } else {
          alert('登录信息错误')
        }
      })
    }
  }
}
</script>

<style lang="less" scoped>
</style>
