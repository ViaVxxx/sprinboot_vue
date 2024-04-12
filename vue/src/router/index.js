import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Info from '../views/Info.vue'
import Course from '../views/Course.vue'
import User from '../views/AdminView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/Info',
      name: 'info',
      component: Info
    },
    {
      path: '/Course',
      name: 'course',
      component: Course
    },
    {
      path: '/Users',
      name: 'users',
      component: User
    },
    /*未知页面导航到404*/
    {
      path: '/:pathMatch(.*)*',
      name: 'not-found',
      component: () => import('../views/NotFound.vue')
    }



  ]
})

export default router
