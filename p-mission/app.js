var util = require('./utils/util.js');
var api = require('./config/api.js');
var user = require('./utils/user.js');

App({
  onShow: function (options) {
    user.checkLogin().then(res => {
      this.globalData.hasLogin = true;
    }).catch(() => {
      this.globalData.hasLogin = false;
    });
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
  }
})