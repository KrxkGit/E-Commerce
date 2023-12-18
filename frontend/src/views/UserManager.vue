<script>
import InventoryTable from '../components/InventoryTable.vue'

export default {
  name: 'UserManager',
  components: { InventoryTable },
  data() {
    return {
      inventory: [],
      show_browse: false, // 模拟浏览
      show_addCart: false, // 加入购物车
      cartFormItem: {
        goods_id: '',
        goods_num: ''
      },
      viewFormItem: {
        shop_id: '',
        goods_id: '',
      }
    }
  },
  created() { // 用于首次加载
    this.GetInventory()
  },
  methods: {
    GetInventory() {
      this.$http.get('/all_inventory', {
        params: {
          start: 0, pages: 1
        }
      }).then((response) => {
        // alert(JSON.stringify(response.data))
        this.inventory = response.data.records
        const c = 20
        const l = this.inventory.length - c - 1
        const start = Math.round(Math.random() * l)
        this.inventory = this.inventory.slice(start, start + c) // 显示 20 条
      })
    },
    AddBrowse() {
      const time_now = new Date()
      const time_now_format = `${time_now.getFullYear()}/${time_now.getMonth() + 1}/${time_now.getDate()} ${time_now.getHours()}:${time_now.getMinutes()}:${time_now.getSeconds()}`
      const params = new FormData()
      params.append('shop_id', this.viewFormItem.shop_id)
      params.append('goods_id', this.viewFormItem.goods_id)
      params.append('user_id', this.$store.state.user_id)
      params.append('view_time', time_now_format)
      this.$http.post('/view_status', params).then((response) => {
        alert(response.data)
      })
    },
    AddCart() {
      const params = new FormData()
      params.append('id', this.$store.state.user_id)
      params.append('password', this.$store.state.user_pwd)
      params.append('goods_id', this.cartFormItem.goods_id)
      params.append('num', this.cartFormItem.goods_num)
      this.$http.post('/cart', params).then((response) => {
        alert(response.data)
      })
    }
  }
}
</script>

<template>
<!--  展示 shop_inventory-->
  <div class="header">
    <h1>用户管理界面</h1>
    <br/>
    <h2>库存</h2>
    <br/>
    <Space wrap>
      <Button type="primary" @click="this.$router.push('/')">返回主页</Button>
      <Button type="primary" @click="GetInventory">刷新</Button>
      <Button type="primary" @click="show_browse = true">模拟浏览</Button>
    </Space>
    <br/><br/>
    <Space wrap>
      <Button type="primary" @click="show_addCart = true">加入购物车</Button>
      <Button type="primary" @click="this.$router.push('/UserCart')">查看购物车</Button>
    </Space>
    <br/><br/>
    <Modal
        v-model="show_browse"
        title="模拟浏览"
        @on-ok="AddBrowse">
      <Form :model="viewFormItem" :label-width="80">
        <FormItem label="商家号">
          <Input v-model="viewFormItem.shop_id" placeholder="输入商家号"></Input>
        </FormItem>
        <FormItem label="商品号">
          <Input v-model="viewFormItem.goods_id" placeholder="输入商品号"></Input>
        </FormItem>
      </Form>
    </Modal>

    <Modal
        v-model="show_addCart"
        title="加入购物车"
        @on-ok="AddCart">
        <Form :model="cartFormItem" :label-width="80">
          <FormItem label="商品号">
            <Input v-model="cartFormItem.goods_id" placeholder="输入商品号"></Input>
          </FormItem>
          <FormItem label="数量">
            <Input v-model="cartFormItem.goods_num" placeholder="输入数量"></Input>
          </FormItem>
        </Form>
    </Modal>
  </div>
  <div class="content">
    <InventoryTable :data=inventory />
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
