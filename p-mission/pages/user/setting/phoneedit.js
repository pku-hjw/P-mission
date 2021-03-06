var util = require('../../../utils/util.js');
var api = require('../../../config/api.js');

var app = getApp();

var interval = null //倒计时函数
Page({

  /**
   * 页面的初始数据
   */
  data: {
    telephone:'',
    captcha:'',
    date: '请选择日期',
    fun_id: 2,
    time: '获取验证码', //倒计时 
    currentTime: 60
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var app = getApp();    
    this.setData({
      telephone: app.globalData.userInfo.telephone
    })
  },
  bindPhoneInputChange: function(e) {
    this.setData({
      telephone: e.detail.value
    })
  },
  getCode: function (options) {
    var that = this;
    var currentTime = that.data.currentTime
    interval = setInterval(function () {
      currentTime--;
      that.setData({
        time: currentTime + '秒'
      })
      if (currentTime <= 0) {
        clearInterval(interval)
        that.setData({
          time: '重新发送',
          currentTime: 60,
          disabled: false
        })
      }
    }, 1000)
  },
  getVerificationCode() {
    this.getCode();
    var that = this
    var app = getApp();
    that.setData({
      disabled: true
    })
    wx.request({
      url: app.globalData.domain.dev + '/people/msg/send/',
      method: 'GET',
      data: {
        uid: app.globalData.userInfo.userId,
        telephone: that.data.telephone
      },
      success: function(res) {
        console.log(res.data)
        if (res.data.status != 1) {
          wx.showToast({
            title: res.data.message,
          })
          return;
        }
      }
    })
  },


  editPhone: function (e) {
    var that = this;
    util.request(api.AuthBindPhone, {
        phone: that.data.telephone
      },'GET').then(function(res) {
        console.log(res);
        if (res.errno != 0) {
          return;
        }
        app.globalData.userInfo.telephone = that.data.telephone
        wx.showToast({
          title: '修改成功',
          icon: 'success',
        })
      }
    )
  }

})