// goLogin() {
//   wx.navigateTo({
//     url: "/pages/auth/login/login"
//   });
// },
// hasLogin: false,

const qiniuUploader = require("../../utils/qiniuUploader");
var util = require('../../utils/util.js');
var api = require('../../config/api.js');
var user = require('../../utils/user.js');

// const qiniuUploader = require("../../utils/qiniuUploader");
//index.js

// 初始化七牛相关参数
function initQiniu() {
  var app = getApp()
  var options = {
    region: 'ECN', // 华北区
    uptokenURL: app.globalData.domain.dev + '/goods/image/uptoken',
    // uptoken: 'qVwP0HV-VC7jGGmREBUZwgKrdJNs9ib5_rA-6OSs:nEn4E36d7z8dmk9qjpdNyoIk5qg=:eyJzY29wZSI6ImF5eS1maWxlIiwiZGVhZGxpbmUiOjE1MTQwMjUyMzl9',
    domain: app.globalData.domain.qiniuImg,
    shouldUseQiniuFileName: false
  };
  qiniuUploader.init(options);
}

//获取应用实例
var app = getApp()
Page({
  data: {
    /* 0 表示商品 1 表示任务*/
    hasLogin: false,
    switchstatus: 0,
    imageList: [],
    categories: ["衣服", "鞋子", "书本", "电器", "其他"],
    mission_categories: ["着急要", "慢慢收"],
    cIndex: 0,
    mission_index: 0,
    donationList: ["否", "是"],
    dIndex: 0,
    location: '',
    title: '',
    discribe: '',
    mission_price: '',
    price: {
      now: "",
      old: "",
      freight: ""
    },
    tagStr: '',
    sort_button_back_color: ["", ""],
    pages: [],
    addType: 1,
    hasMore: true,
  },

  //事件处理函数
  onLoad: function () {
    console.log('onLoad')
    var that = this;

    //定位
    that.getCityNameOFLocation()
  },
  goLogin() {
  wx.navigateTo({
    url: "/pages/auth/login/login"
  });
},
hasLogin: false,
  didPressChooesImage: function () {
    var _this = this;
    didPressChooesImage(_this, function (result) {
      _this.data.imageList.push(result.imageURL);
      _this.setData({
        imageList: _this.data.imageList
      });
    }, function (error) {
    });
  },
  bindTitleInputChange: function (e) {
    this.setData({
      'title': e.detail.value
    })
  },
  bindDiscribeInputChange: function (e) {
    this.setData({
      'discribe': e.detail.value
    })
  },
  bindPriceInputChange: function (e) {
    this.setData({
      'mission_price': e.detail.value
    })
  },
  clickEditPrice: function (e) {
    var _that = this;
    wx.navigateTo({
      url: 'edit-price/edit-price?' + 'now=' + _that.data.price.now + '&old=' + _that.data.price.old + '&freight=' + _that.data.price.freight,
    })
  },
  clickEditTag: function (e) {
    var _that = this;
    wx.navigateTo({
      url: 'edittag/edittag?tagStr=' + _that.data.tagStr,
    })
  },
  bindCategoryChange: function (e) {
    this.setData({
      cIndex: e.detail.value
    })
  },
  bindPickerChange: function (e) {
    this.setData({
      dIndex: e.detail.value
    })
  },
  /**
   * 测试函数
   */
  test: function () {
    wx.navigateTo({
      url: '../add/addmission/addmission'
    })
    console.log("test")
  },
  /*两个发布函数*/
  publish_mission: function () {
    this.setData({
      sort_button_back_color: ["#C0C4CC", "#fff"],
      switchstatus: 0
    }),
      console.log("publishmission"),
      wx.navigateTo({
        url: '../index/index',
        success: function (res) {
          console.log("success")
        },
        fail: function (res) { },
        complete: function (res) { },
      })
  },
  publish_goods: function () {
    this.setData({
      switchstatus: 1,
      sort_button_back_color: ["#fff", "#C0C4CC"],
      text_msg: "publishgoods"
    })
    console.log("publishgoods")
  },
  publishGoods: function (e) {
    var _that = this;
    var app = getApp();
    console.log(_that.data.discribe)
    console.log(_that.data.title)
    wx.request({
      url: 'http://localhost:8080/goods/addgood',

      method: 'POST',
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      data: {
        'publisher_id': app.globalData.userInfo.userId,
        'publisher': app.globalData.userInfo.nickname,
        'title': _that.data.title,
        'desc': _that.data.discribe,
        'price': _that.data.price.now,
        'old_price': _that.data.price.old,
        'cover': _that.data.imageList,
        'address': _that.data.location,
        'tags': _that.data.tagStr,
        'is_donation': _that.data.dIndex
      },
      success: function (res) {
        //console.log(JSON.parse(res))
        wx.showToast({
          title: '发布成功',
          icon: 'success',
          duration: 10000
        })
        wx.reLaunch({
          url: '/pages/index/index',
        })
      }
    })
  },
  publishMission: function (e) {
    var _that = this;
    var app = getApp();
    console.log(_that.data.discribe)
    console.log(_that.data.title)
    wx.request({
      url: 'http://localhost:8080/mission/addmissison',
      method: 'POST',
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      data: {
        'publisherid': app.globalData.userInfo.userId,
        'publisher': app.globalData.userInfo.nickname,
        'missionname': _that.data.title,
        'discribe': _that.data.discribe,
        'price': _that.data.mission_price,
        'old_price': _that.data.price.old,
        'freight': _that.data.price.freight,
        'image_list': _that.data.imageList,
        'publisher_location': _that.data.location,
        'missionclass': _that.data.cIndex,
        'is_donation': _that.data.dIndex
      },
      success: function (res) {
        //console.log(JSON.parse(res))
        wx.showToast({
          title: '发布成功',
          icon: 'success',
          duration: 10000
        })
        wx.reLaunch({
          url: '/pages/index/index',
        })
      }
    })
  },
  getCityNameOFLocation: function () {
    var that = this;
    wx.getLocation({
      type: 'wgs84', // 默认为 wgs84 返回 gps 坐标，gcj02 返回可用于 wx.openLocation 的坐标
      success: function (res) {
        console.log("定位成功");
        var locationString = res.latitude + "," + res.longitude;
        console.log(locationString);
        wx.request({
          url: 'https://apis.map.qq.com/ws/geocoder/v1/?l&get_poi=1',
          data: {
            "key": "24FBZ-2V4KW-LLPRZ-OXSWW-MVVIS-RHBLL",
            "location": locationString
          },
          method: 'GET',
          // header: {}, 
          success: function (res) {
            // success

            var app = getApp();
            app.globalData.userInfo.province = res.data.result.address_component.province;
            app.globalData.userInfo.city = res.data.result.address_component.city;
            app.globalData.userInfo.district = res.data.result.address_component.district;

            that.setData({
              location: formatLocationDesc()
            })
          },
          fail: function () {
            // fail
            console.log("请求失败");
          },
          complete: function () {
            // complete
            console.log("请求完成");
          }
        })
      },
      fail: function () {
        // fail
        console.log("定位失败");
      },
      complete: function () {
        // complete
        console.log("定位完成");
      }
    })
  }
});

function formatLocationDesc() {
  var app = getApp();
  if (app.globalData.userInfo.province == app.globalData.userInfo.city) {
    var province = app.globalData.userInfo.city;
    var city = app.globalData.userInfo.district;
  } else {
    var province = app.globalData.userInfo.province;
    var city = app.globalData.userInfo.city;
  }
  var location = province.substring(0, province.length - 1) + " " + city.substring(0, city.length - 1);
  return location;
}

function didPressChooesImage(that, resolve, reject) {
  initQiniu();
  // 微信 API 选文件
  wx.chooseImage({
    count: 1,
    success: function (res) {
      var filePath = res.tempFilePaths[0];
      // 交给七牛上传
      qiniuUploader.upload(filePath, (res) => {
        resolve(res);
      }, (error) => {
        reject(error);
        // console.error('error: ' + JSON.stringify(error));
      }
      );
    }
  })
}
