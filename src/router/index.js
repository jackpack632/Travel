import Vue from 'vue'
import VueRouter from 'vue-router'
import test from "@/views/test.vue";
import HeadTitle from "@/views/HeadTitle.vue";

Vue.use(VueRouter)

const routes = [
  {
    path: '/test',
    name: 'test',
    component: test
  },
  {
    path: '/',
    name: 'home',
    component: HeadTitle,
    children: [{
      path: '/ComplaintSystem',
      name: 'ComplaintSystem',
      component: () => import('@/views/ComplaintSystem/Index.vue'),
      children: [{
        path: '',
        component: () => import('@/views/ComplaintSystem/ViewingComplaints.vue')
      },
      ]
    },
      {
        path: '/EmergencyInfo',
        name: 'EmergencyInfo',
        component: () => import('@/views/EmergencyInfo/Index.vue'),
        children: [{
          path: '',
          component: () => import('@/views/EmergencyInfo/EmergencyList.vue')
        },{
            path: '2',
            component: () => import('@/views/EmergencyInfo/EmergencyInfo.vue')
        }
        ]
      },
      {
        path: '/HotelSystem',
        name: 'HotelSystem',
        component: () => import('@/views/HotelSystem/Index.vue'),
        children: [{
          path: '',
          component: () => import('@/views/HotelSystem/HotelSearch.vue')
        },{
          path: '2',
          component: () => import('@/views/HotelSystem/RoomInformation.vue')
        }
        ]
      }, {
        path: '/Spot',
        name: 'Spot',
        component: () => import('@/views/Spot/Index.vue'),
        children: [{
                  path: '',
                  component: () => import('@/views/Spot/SpotInfo.vue')
                }
              ]
      },{
        path: '/Home',
        name: 'Home',
        component: () => import('@/views/Home.vue')
      }
    ]
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
