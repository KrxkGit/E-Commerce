<template>
  <Table stripe :columns="columns" :data="data"></Table>
</template>
<script>
export default {
  name: 'CartTable',
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
          title: '数量',
          key: 'num',
          width: 100,
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
