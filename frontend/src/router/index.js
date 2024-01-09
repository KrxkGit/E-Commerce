import { createRouter, createWebHistory } from 'vue-router'
import Home from '@/views/Home.vue'
import UserLogin from '../views/UserLogin.vue'
import SellerLogin from '../views/SellerLogin.vue'
import SellerRegister from '../views/SellerRegister.vue'
import UserRegister from '../views/UserRegister.vue'
import UserCart from '../views/userCart.vue'
import UserPurchaseRecord from '../views/userPurchaseRecord.vue'
import ShopInventory from '../views/shopInventory.vue'
import ShopSoldStatus from '../views/shopSoldStatus.vue'
import ShopViewStatus from '../views/shopViewStatus.vue'
import UserManager from '../views/UserManager.vue'
import ShopManager from '../views/ShopManager.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/UserLogin',
    name: 'user_login',
    component: UserLogin
  },
  {
    path: '/SellerLogin',
    name: 'seller_login',
    component: SellerLogin
  },
  {
    path: '/SellerRegister',
    name: 'seller_register',
    component: SellerRegister
  },
  {
    path: '/UserRegister',
    name: 'user_register',
    component: UserRegister
  },
  {
    path: '/UserCart',
    name: 'user_cart',
    component: UserCart
  },
  {
    path: '/UserPurchaseRecord',
    name: 'user_purchase_record',
    component: UserPurchaseRecord
  },
  {
    path: '/ShopInventory',
    name: 'shop_inventory',
    component: ShopInventory
  },
  {
    path: '/ShopSoldStatus',
    name: 'shop_sold_status',
    component: ShopSoldStatus
  },
  {
    path: '/ShopViewStatus',
    name: 'shop_view_status',
    component: ShopViewStatus
  },
  {
    path: '/ShopManager',
    name: 'shop_manager',
    component: ShopManager
  },
  {
    path: '/UserManager',
    name: 'user_manager',
    component: UserManager
  }
]

const router = createRouter({
  routes,
  history: createWebHistory(),
  scrollBehavior() {
    return { top: 0 }
  }
})

export default router
