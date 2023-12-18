<script>
import PurchaseTable from '../components/PurchaseTable.vue'
import CartTable from '../components/CartTable.vue'
export default {
  name: 'userPurchaseRecord',
  components: { PurchaseTable, CartTable },
  data() {
    return {
      PurchaseList: [],
    }
  },
  created() {
    this.GetPurchaseRecord()
  },
  methods: {
    GetPurchaseRecord() {
      this.$http.get('/purchase_record', {
        params: {
          id: this.$store.state.user_id,
          password: this.$store.state.user_pwd
        }
      }).then((res) => {
        this.PurchaseList = res.data
      })
    }
  }
}
</script>

<template>
  <div class="header">
    <h1>购物记录</h1>
    <br/>
    <Space wrap>
      <Button type="primary" @click="this.$router.push('/UserCart')">返回</Button>
      <Button type="primary" @click="this.GetPurchaseRecord">刷新</Button>
    </Space>
  </div>
  <br/><br/>
  <div class="content">
    <PurchaseTable :data="PurchaseList"/>
  </div>
</template>

<style scoped lang="less">
.header {
  text-align: center;
}
.content {
  margin: 0 auto;
  width: 530px;
}
</style>
