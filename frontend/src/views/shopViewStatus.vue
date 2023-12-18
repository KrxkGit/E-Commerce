<script>
import ViewTable from '../components/ViewTable.vue'

export default {
  name: 'ShopViewStatus',
  components: { ViewTable },
  created() {
    this.GetViewStatus()
  },
  methods: {
    GetViewStatus() {
      this.$http.get('/view_status', {
        params: {
          shop_id: this.$store.state.shop_id,
          password: this.$store.state.shop_pwd
        }
      }).then((res) => {
        this.viewList = res.data
      })
    }
  },
  data() {
    return {
      viewList: [],
    }
  },
}
</script>

<template>
  <div class="header">
    <h1>用户来访</h1>
    <br/>
    <Space wrap>
      <Button type="primary" @click="this.$router.push('/ShopManager')">返回</Button>
      <Button type="primary" @click="this.GetViewStatus">刷新</Button>
    </Space>
  </div>
  <br/><br/>
  <div class="content">
    <ViewTable :data="viewList"/>
  </div>
</template>

<style scoped lang="less">
.header {
  text-align: center;
}
.content {
  margin: 0 auto;
  width: 510px;
}
</style>
