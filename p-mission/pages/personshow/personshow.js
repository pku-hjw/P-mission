Page({
  data: {
    userinfo: {
      avatar: "https://www.woyaogexing.com/touxiang/nan/2019/901513.html",
      username: "南轩",
      desc: "这个人很懒，什么也没留下"
    },
    pages: [
      {
        goods_id: 1,
        is_donation: 0,
        cover: "https://www.woyaogexing.com/touxiang/nan/2019/901513.html",
        title:"卫龙 八成新"
      }
    ],
    data: [
      {
        talkId: 1,
        lookCount: 4343,
        commentCount: 555
      },
      {
        talkId: 2,
        lookCount: 54,
        commentCount: 6
      }
    ],
    selected1: true,
    selected2: false,
    selected3: false
  },
  selected1: function (e) {
    this.setData({
      selected1: true,
      selected2: false,
      selected3: false
    })
  },
  selected2: function (e) {
    this.setData({
      selected2: true,
      selected1: false,
      selected3: false
    })
  },
  selected3: function (e) {
    this.setData({
      selected3: true,
      selected1: false,
      selected2: false
    })
  }
})