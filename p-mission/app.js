var util = require('./utils/util.js');
var api = require('./config/api.js');
var user = require('./utils/user.js');

App({
  onLaunch: function () {
    this.getUserInfo()
    console.log(this.globalData.hasLogin)
    console.log(this.globalData.userInfo.userId)
  },

  onShow: function (options) {
    user.checkLogin().then(res => {
      this.globalData.hasLogin = true;
    }).catch(() => {
      this.globalData.hasLogin = false;
    });
  },
  test:function(){
    console.log(this.globalData.userInfo.userId)
    console.log(this.globalData.hasLogin)
  },

  globalData: {
    hasLogin: false,
    userInfo: {
      userId: 0,
      nickname: "",
      avatar: "",
      gender: "",
      province: "",
      city: "",
      district: "",
      location: "",
      telephone: "",
      email: "",
      shipAddress: "",
    },
    domain: {
      // dev: "http://localhost:8081/",
      dev: "https://ganzhiqiang.wang/ares/",
      qiniuImg: "http://ayy.ganzhiqiang.wang",
      tencentMap: "",
      imageUpload: "",
    }
  },

  getUserInfo: function (e) {
    var that = this;
    util.request(api.AuthGetUserInfo).then(function (res) {
      console.log(res);
      if (res.errno != 0) {
        return;
      }
      that.globalData.userInfo.userId=res.data.id
      that.globalData.hasLogin=true
    }
    )
  }
})