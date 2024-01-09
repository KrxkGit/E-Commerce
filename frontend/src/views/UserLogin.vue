<template>
<!--  <Demo/>-->
  <MyLayout page_title="用户登录" user_type="用户" @getInfo="userLogin"/>
</template>

<script>
import MyLayout from '../components/MyLayout.vue'

export default {
  name: 'UserLogin',
  components: {
    MyLayout,
  },
  data() {
    return {
      info: {},
    }
  },
  methods: {
    userLogin(info) {
      const username = info.id
      const password = info.pwd
      this.$http.get('/user', {
        params: {
          id: username,
          password
        }
      }).then((res) => {
        if (res.data === '登录成功') {
          this.info = info // 保存账号密码
          // 保存账号密码为全局状态
          this.$store.state.user_id = username
          this.$store.state.user_pwd = password
          // 跳转路由
          this.$router.push('/UserManager')
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
