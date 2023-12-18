<template>
  <div class="demo-login">
    <Login @on-submit="handleSubmit">
      <UserName name="username" />
      <Password name="password" />
      <div class="demo-auto-login">
        <Checkbox v-model="autoLogin" size="large">自动登录</Checkbox>
        <a @click="handleRegister">注册新账号</a>
      </div>
      <Submit>{{ login_type }}</Submit>
    </Login>
  </div>
</template>
<script>

export default {
  name: 'MyLogin',
  data() {
    return {
      autoLogin: true,
      info: {}, // 账号信息
    }
  },
  props: {
    login_type: String,
    user_type: String, // 用户 or 商家
  },
  methods: {
    handleSubmit(valid, { username, password }) {
      if (valid) {
        this.info = {
          id: username,
          pwd: password
        }
        this.$emit('getInfo', this.info) // 传递回父组件
      }
    },
    handleRegister() {
      if (this.user_type === '用户') {
        this.$router.push('/UserRegister')
      } else {
        this.$router.push('/SellerRegister')
      }
    }
  }
}
</script>
<style>
.demo-login{
  width: 400px;
  margin: 0 auto !important;
}
.demo-auto-login{
  margin-bottom: 24px;
  text-align: left;
}
.demo-auto-login a{
  float: right;
}
</style>
