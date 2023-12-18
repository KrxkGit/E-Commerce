<script>
import InventoryTable from '../components/InventoryTable.vue'

export default {
  name: 'ShopManager',
  components: { InventoryTable },
  created() {
    this.GetShopInventory()
  },
  methods: {
    GetShopInventory() {
      this.$http.get('/inventory', {
        params: {
          shop_id: this.$store.state.shop_id,
          password: this.$store.state.shop_pwd,
        }
      }).then((response) => {
        // alert(JSON.stringify(response.data))
        this.inventory = response.data
        // const c = 20
        // const l = this.inventory.length - c - 1
        // const start = Math.round(Math.random() * l)
        // this.inventory = this.inventory.slice(start, start + c) // 显示 20 条
      })
    },
    AddInventory() {
      const formData = new FormData()
      formData.append('shop_id', this.$store.state.shop_id)
      formData.append('password', this.$store.state.shop_pwd)
      formData.append('goods_id', this.addInventoryFormItem.goods_id)
      formData.append('goods_name', this.addInventoryFormItem.goods_name)
      formData.append('goods_num', this.addInventoryFormItem.goods_num)
      this.$http.post('/inventory', formData).then((res) => {
        alert(res.data)
        this.GetShopInventory() // 刷新
      })
    },
    DelInventory() {
      this.$http.delete('/inventory', {
        params: {
          shop_id: this.$store.state.shop_id,
          password: this.$store.state.shop_pwd,
          goods_id: this.delInventoryFormItem.goods_id,
        }
      }).then((res) => {
        alert(res.data)
        this.GetShopInventory()
      })
    },
  },
  data() {
    return {
      inventory: [],
      show_AddInventory: false,
      show_DelInventory: false,
      addInventoryFormItem: {
        goods_id: '',
        goods_name: '',
        goods_num: '',
      },
      delInventoryFormItem: {
        goods_id: '',
      }
    }
  },
}
</script>

<template>
  <div class="header">
    <h1>商户管理页面</h1>
    <br/>
    <h2>商家库存</h2>
    <br/>
    <Space wrap>
      <Button type="primary" @click="this.$router.push('/')">返回主页</Button>
      <Button type="primary" @click="GetShopInventory">刷新</Button>
    </Space>
    <br/><br/>
    <Space wrap>
      <Button type="primary" @click="this.show_AddInventory=true">添加库存</Button>
      <Button type="primary" @click="this.show_DelInventory=true">删除库存</Button>
    </Space>
    <br/><br/>
    <Space wrap>
      <Button type="primary" @click="this.$router.push('/ShopViewStatus')">用户来访</Button>
      <Button type="primary" @click="this.$router.push('/ShopSoldStatus')">成交记录</Button>
    </Space>
    <br/><br/>
    <Modal
        v-model="show_AddInventory"
        title="添加库存"
        @on-ok="AddInventory">
      <Form :model="addInventoryFormItem" :label-width="80">
        <FormItem label="商品号">
          <Input v-model="addInventoryFormItem.goods_id" placeholder="输入商品号"></Input>
        </FormItem>
        <FormItem label="商品名">
          <Input v-model="addInventoryFormItem.goods_name" placeholder="输入商品名"></Input>
        </FormItem>
        <FormItem label="数量">
          <Input v-model="addInventoryFormItem.goods_num" placeholder="输入商品数量"></Input>
        </FormItem>
      </Form>
    </Modal>
    <Modal
        v-model="show_DelInventory"
        title="删除库存"
        @on-ok="DelInventory">
      <Form :model="delInventoryFormItem" :label-width="80">
        <FormItem label="商品号">
          <Input v-model="delInventoryFormItem.goods_id" placeholder="输入商品号"></Input>
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
