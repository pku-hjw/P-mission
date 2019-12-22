// pages/user/setting/setting.js
Page({
  data: {
  
  },
  onLoad: function (options) {

  },
  aboutAPP: function(e) {
    wx.navigateTo({
      url: 'about',
    })
  },
  editAddress: function(e) {
    wx.navigateTo({
      url: 'addressedit',
    })
  }
})