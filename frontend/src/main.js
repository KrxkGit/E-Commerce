import { createApp } from 'vue'
import ViewUIPlus from 'view-ui-plus'
import App from './App.vue'
import router from './router'
import store from './store'
import './styles/index.less'
// import './mock'
import axios from './axios/index'

const app = createApp(App)

app.config.globalProperties.$http = axios
app.use(router)
  .use(store)
  .use(ViewUIPlus)
  .mount('#app')
