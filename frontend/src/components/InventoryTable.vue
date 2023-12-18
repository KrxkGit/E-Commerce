<template>
  <Table stripe :columns="columns" :data="data"></Table>
</template>
<script>
export default {
  name: 'InventoryTable',
  data() {
    return {
      columns: [
        {
          title: '商品号',
          key: 'goods_id',
          width: 100,
          align: 'center'
        },
        {
          title: '商品名',
          key: 'goods_name',
          width: 300,
          align: 'center'
        },
        {
          title: '商品数量',
          key: 'goods_num',
          width: 100,
          align: 'center'
        },
        {
          title: '商家号',
          key: 'shop_id',
          width: 100,
          align: 'center'
        }
      ],
    }
  },
  props: {
    data: [],
  }
}
</script>
