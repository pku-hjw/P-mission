//pages / social / social.js
var util = require('../../utils/util.js');
var api = require('../../config/api.js');
var user = require('../../utils/user.js');
var app = getApp();
Page({
  onLoad: function () {
    // 定位
    // location.getCityNameOFLocation()
    this.queryMission();
  },
  data: {
    sort_button_back_color: ["", "", ""],
    missiondata: [],
    // queryType: 1,
    hasMore: true,
    start: 0,
    limit: 24,
  },

  onPullDownRefresh: function () {
    wx.showNavigationBarLoading() //在标题栏中显示加载

    setTimeout(function () {
      // complete
      wx.hideNavigationBarLoading() //完成停止加载
      wx.stopPullDownRefresh() //停止下拉刷新
    }, 600);
  },

  queryMission: function () {
    var app = getApp();
    var _that = this
    wx.request({
      url: api.GetAllMission,
      method: 'GET',
      // data: {
      //   'start': _that.data.start,
      //   'limit': _that.data.limit,
      //   'uid': app.globalData.userInfo.userId
      // },
      success: function (res) {
        /* res */
        console.log(JSON.stringify(res.data));
        var _missiondata;
        _missiondata = new Array()

        /*取出数据*/
        var _data = res.data
        console.log(_data)
        for (var i = 0; i < _data.length; i++) {
          _missiondata.push({
            missionid: _data[i].missionid,
            missionname: _data[i].missionname,
            publisher: _data[i].publisher,
            publisherid: _data[i].publisherid,
            discribe: _data[i].discrible,
            lookCount: _data[i].lookCount,
            commentCount: _data[i].commentcount
          })
          // console.log(JSON.stringify(res));
        }
        _that.setData({
          missiondata: _missiondata
        })
        console.log("读取成功")
        // console.log(this._missiondata)
      }
    })
  },
  test: function () {
    console.log(this.data)
  },
  publishTopic: function (e) {
    wx.navigateTo({
      url: 'release/release',
    })
  }
})