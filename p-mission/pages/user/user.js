var util = require('../../utils/util.js');
var api = require('../../config/api.js');
var user = require('../../utils/user.js');
var app = getApp();

Page({
  data: {
    aboutShow: true,
    userInfo: {
      nickName: '点击登录',
      avatarUrl: 'http://yanxuan.nosdn.127.net/8945ae63d940cc42406c3f67019c5cb6.png'
    },
    index: 0,
    // schools: [],
    favoriteCount: 0,
    integral: 0,
    likeCount: 0,
    lookCount: 0,
    publishCount: 0
  },

  onLoad: function (options) {

  },
  onReady: function () {

  },
  onShow: function () {

    //获取用户的登录信息
    if (app.globalData.hasLogin) {
      let userInfo = wx.getStorageSync('userInfo');
      // this.querySchool()
      this.setData({
        aboutShow: true,
        userInfo: userInfo,
      });
    }

  },
  onHide: function () {
    // 页面隐藏

  },
  onUnload: function () {
    // 页面关闭
  },
  goLogin() {
    if (!app.globalData.hasLogin) {
      wx.navigateTo({
        url: "/pages/auth/login/login"
      });
    }
  },


  jumpToSetting() {
    wx.navigateTo({
      url: 'setting/setting',
    })
  },

  jumpToStar() {
    wx.navigateTo({
      url: 'star/star',
    })
  },

  jumpToRelease(){
    if (app.globalData.hasLogin) {
      wx.navigateTo({
        url: "/pages/user/release/release"
      });
    }
    else {
      wx.navigateTo({
        url: "/pages/auth/login/login"
      });
    }
  },

  jumpToMycollection() {
    if(app.globalData.hasLogin){
      wx.navigateTo({
      url: 'mytrace/mytrace?type=' + e.currentTarget.id,
    });
    }
    else{
      wx.navigateTo({
        url: "/pages/auth/login/login"
      });
    }
  },

  // schoolSelect: function(e) {
  //   this.setData({
  //     index: e.detail.value
  //   });
  //   this.changeSchool()
  // },
  // changeSchool: function(e) {
  //   var _that = this;
  //   var app = getApp();
  //   wx.request({
  //     url: app.globalData.domain.dev + 'people/school/change/',
  //     method: 'GET',
  //     data: {
  //       uid: app.globalData.userInfo.userId,
  //       index: _that.data.index
  //     },
  //     success: function(res) {
  //       if (res.data.status != 1) {
  //         wx.showToast({
  //           title: res.data.message,
  //           icon: 'none',
  //         })
  //         return;
  //       }
  //     }
  //   })
  // },
  // querySchool: function(e) {
  //   var _that = this;
  //   wx.request({
  //     url: app.globalData.domain.dev + 'people/school/query/',
  //     method: 'GET',
  //     data: {},
  //     success: function(res) {
  //       if (res.data.status != 1) {
  //         wx.showToast({
  //           title: res.data.message,
  //           icon: 'none',
  //         })
  //         return;
  //       }
  //       _that.setData({
  //         schools: res.data.data
  //       })
  //     }
  //   })
  // },
  

  exitLogin: function () {
    wx.showModal({
      title: '',
      confirmColor: '#b4282d',
      content: '退出登录？',
      success: function (res) {
        if (res.confirm) {
          wx.removeStorageSync('token');
          wx.removeStorageSync('userInfo');
          wx.switchTab({
            url: '/pages/index/index'
          });
        }
      }
    })
  }

})