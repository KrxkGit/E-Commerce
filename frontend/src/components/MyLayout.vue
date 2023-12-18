<style scoped>
.background {
  background-image: url("/Background.jpg");
  background-size: cover;
  //position: absolute;
}

#title {
  background-size: cover;
  color: palegreen;
  background: url("/BackgroundTitle.jpg");
  boxShadow: '0 2px 3px 0px rgba(0,0,0,.1)';
}

.menu-item span{
  display: inline-block;
  overflow: hidden;
  width: 69px;
  text-overflow: ellipsis;
  white-space: nowrap;
  vertical-align: bottom;
  transition: width .2s ease .2s;
}
.menu-item i{
  transform: translateX(0px);
  transition: font-size .2s ease, transform .2s ease;
  vertical-align: middle;
  font-size: 16px;
}
.collapsed-menu span{
  width: 0px;
  transition: width .2s ease;
}
.collapsed-menu i{
  transform: translateX(5px);
  transition: font-size .2s ease .2s, transform .2s ease .2s;
  vertical-align: middle;
  font-size: 22px;
}
.dev-run-preview .dev-run-preview-edit{ display: none }
#title {
  text-align: center;
}
</style>

<template>
  <div class="layout">
    <Layout :style="{minHeight: '100vh'}">
      <Sider v-model="isCollapsed" :collapsed-width="78" collapsible
             style="background-color: transparent">
        <Menu active-name="1-2" theme="light" width="auto" :class="menuitemClasses">
          <MenuItem name="1-1" @click="$router.push('/')">
            <Icon type="md-bulb" />
            <span>欢迎主页</span>
          </MenuItem>
          <MenuItem name="1-2" @click="$router.push('/UserLogin')">
            <Icon type="md-person" />
            <span>用户登录</span>
          </MenuItem>
          <MenuItem name="1-3" @click="$router.push('/SellerLogin')">
            <Icon type="logo-android" />
            <span>商家登录</span>
          </MenuItem>
        </Menu>
      </Sider>
      <Layout class="background">
        <Header id="title">
          <h1>{{ page_title }}</h1>
        </Header>
        <Content :style="{padding: '0 16px 16px'}">
          <Breadcrumb :style="{margin: '16px 0'}" style="color: palegreen">
            <BreadcrumbItem>主页</BreadcrumbItem>
            <BreadcrumbItem>{{ page_title }}</BreadcrumbItem>
          </Breadcrumb>
          <div style="display: flex; align-items: center; justify-content: center">
            <Card v-if="page_title=='星空集市'"
                  style="width: fit-content; background-color: transparent">
              <img src="/shop_car.png" width="630"/>
            </Card>
            <Card v-else style="width: fit-content;">
                <MyLogin v-if="page_title.indexOf('注册') == -1" :login_type=page_title
                         :user_type=user_type @getInfo="handleInfo"/>
                <MyRegister v-else @PostRegister="handleRegister"/>
            </Card>
          </div>
        </Content>
      </Layout>
    </Layout>
  </div>
</template>

<script>
import MyLogin from './Login.vue'
import MyRegister from './Register.vue'

export default {
  components: { MyRegister, MyLogin },
  computed: {
    menuitemClasses() {
      return [
        'menu-item',
        this.isCollapsed ? 'collapsed-menu' : ''
      ]
    }
  },
  data() {
    return {
      isCollapsed: false,
      info: {},
    }
  },
  props: {
    page_title: String, // 定义为字符串类型
    user_type: String,
  },
  name: 'MyLayout',
  methods: {
    handleInfo(info) {
      // console.log(info)
      this.info = info
      this.$emit('getInfo', this.info)
    },
    handleRegister(info) {
      this.info = info
      this.$emit('RegisterInfo', this.info)
    }
  }
}
</script>
