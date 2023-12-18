<script>
import CartTable from '../components/CartTable.vue'

export default {
  name: 'userCart',
  components: { CartTable },
  data() {
    return {
      cartList: [],
      showDelForm: false,
      delFormItem: {
        goods_id: '',
      }
    }
  },
  created() {
    this.GetCartList()
  },
  methods: {
    GetCartList() {
      this.$http.get('/cart', {
        params: {
          id: this.$store.state.user_id,
          password: this.$store.state.user_pwd
        }
      }).then((res) => {
        this.cartList = res.data
      })
    },
    DelCartItem() {
      this.$http.delete('/cart', {
        params: {
          id: this.$store.state.user_id,
          password: this.$store.state.user_pwd,
          goods_id: this.delFormItem.goods_id,
        }
      }).then((res) => {
        alert(res.data)
        this.GetCartList() // 刷新
      })
    },
    OnekeyOrdering() {
      const time_now = new Date()
      const time_now_format = `${time_now.getFullYear()}/${time_now.getMonth() + 1}/${time_now.getDate()} ${time_now.getHours()}:${time_now.getMinutes()}:${time_now.getSeconds()}`
      // alert(time_now_format)
      this.cartList.forEach((item) => {
        const formdata = new FormData()
        formdata.append('id', this.$store.state.user_id)
        formdata.append('password', this.$store.state.user_pwd)
        formdata.append('goods_id', (item).goods_id)
        formdata.append('num', (item).num)
        formdata.append('transaction_time', time_now_format)
        this.$http.post('/purchase_record', formdata).then((res) => {
          const buyStatus = res.data
          alert(buyStatus)
          if (buyStatus === '购买成功') {
            this.$http.delete('/cart', {
              params: {
                id: this.$store.state.user_id,
                password: this.$store.state.user_pwd,
                goods_id: (item).goods_id
              }
            }).then(() => {
              this.GetCartList() // 刷新
            })
          }
        })
      })
    }
  }
}
</script>

<template>
  <div class="header">
    <h1>购物车</h1>
    <br/>
    <Space wrap>
      <Button type="primary" @click="this.$router.push('/UserManager')">返回</Button>
      <Button type="primary" @click="this.GetCartList">刷新</Button>
    </Space>
    <br/><br/>
    <Space wrap>
      <Button type="primary" @click="this.showDelForm=true">暂时不想要</Button>
    </Space>
    <br/><br/>
    <Space wrap>
      <Button type="primary" @click="OnekeyOrdering">一键下单</Button>
      <Button type="primary" @click="this.$router.push('/UserPurchaseRecord')">购物记录</Button>
    </Space>
    <Modal
        v-model="showDelForm"
        title="暂时不想要"
        @on-ok="DelCartItem">
      <Form :model="delFormItem" :label-width="80">
        <FormItem label="商品号">
          <Input v-model="delFormItem.goods_id" placeholder="输入商品号"></Input>
        </FormItem>
      </Form>
    </Modal>
  </div>
  <br/><br/>
  <div class="content">
    <CartTable :data="cartList"/>
  </div>
</template>

<style scoped lang="less">
.header {
  text-align: center;
}
.content {
  margin: 0 auto;
  width: 210px;
}
</style>
