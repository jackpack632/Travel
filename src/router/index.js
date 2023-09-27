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
        component: () => import('@/views/ComplaintSystem/SubmittingAndResponding.vue')
      },{
        path: '2',
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
          component: () => import('@/views/EmergencyInfo/EmergencyInformationPublish.vue')
        },{
          path: '2',
          component: () => import('@/views/EmergencyInfo/EmergencyInformationApproval.vue')
        },{
          path: '3',
          component: () => import('@/views/EmergencyInfo/EmergencyInformationEdit.vue')
        },{
          path: '4',
          component: () => import('@/views/EmergencyInfo/Delete.vue')
        },{
          path: '5',
          component: () => import('@/views/EmergencyInfo/EmergencySearch.vue')
        }
        ]
      },
      {
        path: '/HotelSystem',
        name: 'HotelSystem',
        component: () => import('@/views/StarHotelSystem/Index.vue'),
        children: [{
          path: '',
          component: () => import('@/views/StarHotelSystem/HotelSearch.vue')
        },{
          path: '2',
          component: () => import('@/views/StarHotelSystem/RoomInformation.vue')
        },{
          path: '3',
          component: () => import('@/views/StarHotelSystem/HotelMarketing.vue')
        }
        ]
      },
      {
        path: '/NonStarHotelSystem',
        name: 'NonStarHotelSystem',
        component: () => import('@/views/NonStarHotelSystem/Index.vue'),
        children: [{
          path: '',
          component: () => import('@/views/NonStarHotelSystem/NonStarHotelQuery.vue')
        },{
          path: '2',
          component: () => import('@/views/NonStarHotelSystem/RoomInfoEntry.vue')
        },{
            path: '3',
            component: () => import('@/views/NonStarHotelSystem/HotelMarketingEntry.vue')
        }
        ]
      },
      {
        path: '/ScenicSystem',
        name: 'ScenicSystem',
        component: () => import('@/views/ScenicSystem/Index.vue'),
        children: [{
          path: '',
          component: () => import('@/views/ScenicSystem/TouristAttractionQuery.vue')
        },{
          path: '2',
          component: () => import('@/views/ScenicSystem/TouristRouteQuery.vue')
        }
        ]
      },
      {
        path: '/DiningEntertainmentSystem',
        name: 'DiningEntertainmentSystem',
        component: () => import('@/views/DiningEntertainmentSystem/Index.vue'),
        children: [{
          path: '',
          component: () => import('@/views/DiningEntertainmentSystem/DiningEntertainmentQuery.vue')
          },{
          path: '2',
           component: () => import('@/views/DiningEntertainmentSystem/EntertainmentGroupQuery.vue')
          }
          ]
      },
      {
        path: '/WeatherRoadSystem',
        name: 'WeatherRoadSystem',
        component: () => import('@/views/WeatherRoadSystem/Index.vue'),
        children: [{
                  path: '',
                  component: () => import('@/views/WeatherRoadSystem/WeatherQuery.vue')
                },{
                  path: '2',
                  component: () => import('@/views/WeatherRoadSystem/RoadQuery.vue')
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
