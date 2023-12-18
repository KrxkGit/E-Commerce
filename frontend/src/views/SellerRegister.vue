<template>
<!--  <Demo/>-->
  <MyLayout page_title="商家注册" user_type="商家" @RegisterInfo="shopLogin"/>
</template>

<script>
import MyLayout from '../components/MyLayout.vue'

export default {
  name: 'SellerRegister',
  components: {
    MyLayout,
  },
  setup() {
  },
  methods: {
    shopLogin(info) {
      const username = info.id
      const password = info.pwd
      const mail = info.email
      const params = new FormData()
      params.append('shop_id', username)
      params.append('password', password)
      params.append('email', mail)

      this.$http.post('/shop', params).then((response) => {
        alert(response.data)
      }).catch((err) => {
        alert(err)
      })
      // console.log('用户名： ', username)
      // console.log('密码： ', password)
      // console.log('邮箱： ', mail)
    }
  }
}
</script>

<style lang="less" scoped>
</style>
