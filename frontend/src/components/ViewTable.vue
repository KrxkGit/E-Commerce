<template>
  <Table stripe :columns="columns" :data="data"></Table>
</template>
<script>
export default {
  name: 'ViewTable',
  data() {
    return {
      columns: [
        // {
        //   title: '商家号',
        //   key: 'shop_id',
        //   width: 100,
        //   align: 'center'
        // },
        {
          title: '用户号',
          key: 'user_id',
          width: 100,
          align: 'center'
        },
        {
          title: '商品号',
          key: 'goods_id',
          width: 100,
          align: 'center'
        },
        {
          title: '浏览时间',
          key: 'view_time',
          width: 300,
          align: 'center'
        },
      ],
    }
  },
  props: {
    data: [],
  }
}
</script>
