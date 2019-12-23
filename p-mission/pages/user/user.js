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
    phone: "请留下您的联系方式",
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
      this.getPhone()
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

  jumpToMycollection: function(e) {
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
  },

  editPhone: function (e) {
    if (app.globalData.hasLogin) {
      wx.navigateTo({
        url: "/pages/user/setting/phoneedit"
      });
    }
    else {
      wx.navigateTo({
        url: "/pages/auth/login/login"
      });
    }
  },

  getPhone: function (e) {
    var that = this;
    util.request(api.AuthGetPhone).then(function (res) {
      console.log(res);
      if (res.errno != 0) {
        return;
      }
      that.setData({
        phone: res.data.phone
      });
    }
    )
  }

})