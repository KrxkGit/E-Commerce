<script>
import SoldTable from '../components/SoldTable.vue'

export default {
  name: 'shopSoldStatus',
  components: { SoldTable },
  data() {
    return {
      soldList: [],
    }
  },
  created() {
    this.GetSoldStatus()
  },
  methods: {
    GetSoldStatus() {
      this.$http.get('/sold_status', {
        params: {
          shop_id: this.$store.state.shop_id,
          password: this.$store.state.shop_pwd
        }
      }).then((res) => {
        this.soldList = res.data
      })
    }
  }
}
</script>

<template>
  <div class="header">
    <h1>成交状态</h1>
    <br/>
    <Space wrap>
      <Button type="primary" @click="this.$router.push('/ShopManager')">返回</Button>
      <Button type="primary" @click="this.GetSoldStatus">刷新</Button>
    </Space>
  </div>
  <br/><br/>
  <div class="content">
    <SoldTable :data="soldList"/>
  </div>
</template>

<style scoped lang="less">
.header {
  text-align: center;
}
.content {
  margin: 0 auto;
  width: 610px;
}
</style>
