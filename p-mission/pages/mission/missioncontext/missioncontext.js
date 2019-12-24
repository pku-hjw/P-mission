// pages/social/topic/topic.js
var api = require('../../../config/api.js')
Page({

  /**
   * 页面的初始数据
   */
  data: {
    missionid: null,
    commentdata: [],
    userComment: null,

    mission: {
      talkId: 1,
      title: null,
      publisher: null,
      discribe: null,
      lookCount: null,
      commentCount: null,
    },
    // missionname:'今天是个好日子',
    imageList: [
      {
        src: "http://nanxuan.qiniuts.com/UI-design-1.jpeg"
      },
      {
        src: "http://nanxuan.qiniuts.com/UI-design-1.jpeg"
      }
    ],
  },
  test: function () {
    // console.log(this.data.missionid)
    // console.log(this.data.title)
    // console.log(this.data.mission)
    // console.log(this.data.mission.missionname)
    // console.log(this.data.commentdata)
    console.log(this.data.userComment)
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    that.setData({
      missionid: options.missionid
    })
    console.log(this.data.missionid)
    wx.request({
      url: api.GetMission,
      method: 'post',
      data: {
        missionid: this.data.missionid
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      success: function (res) {
        console.log(res.data)
        var missionname = res.data.missionname;
        that.setData({
          mission_title: res.data.missionname,
          mission_publisher: res.data.publisher,
          mission_discribe: res.data.discrible,
          mission_lookCount: res.data.lookcount,
          mission_commentCount: res.data.commentcount
        })
        that.setData({
          mission: res.data
        })

      }


    })
    console.log(this.data.missionid)
    wx.request({
      url: api.CommentGet,
      method: 'post',
      data: {
        missionid: this.data.missionid
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      success: function (res) {
        var _commentdata = new Array()
        var _data = res.data
        for (var i = 0; i < _data.length; i++) {
          _commentdata.push({
            commentid: _data[i].commentid,
            comment_content: _data[i].content,
            comment_missionid: _data[i].missionid,
            comment_userid: _data[i].userid,
            comment_date: _data[i].date
          })
          // console.log(JSON.stringify(res));
        }
        that.setData({
          commentdata: _commentdata
        })
        console.log(_commentdata)

      }


    })
  },
  submit: function (e) {
    var _that = this;
    var app = getApp();
    console.log(_that.data.discribe)
    console.log(_that.data.title)
    wx.request({
      url: api.CommentPost,
      method: 'POST',
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      data: {
        'userid': app.globalData.userInfo.userId,
        'content': _that.data.userComment,
        'missionid': _that.data.missionid,
      },
      success: function (res) {
        //console.log(JSON.parse(res))
        wx.showToast({
          title: '发布成功',
          icon: 'success',
          duration: 10000
        })
      }
    })
  },
  bindblur(e) {
    this.setData({
      userComment: e.detail.value
    })
    console.log(e)
  },


  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})
