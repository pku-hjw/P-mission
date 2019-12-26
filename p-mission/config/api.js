// 以下是业务服务器API地址
// 本机开发时使用
//var WxApiRoot = 'http://localhost:8081/wx/';
// 局域网测试使用
var WxApiRoot = 'http://182.254.200.15:8081/wx/';
var WxApiGoods = 'http://182.254.200.15:8080/user/';

// 云平台上线时使用
//var WxApiRoot = 'http://cp.ahalk.cn:8081/wx/';
//var WxApiGoods = 'http://cp.ahalk.cn:8080/user/';

module.exports = {
  AuthLoginByWeixin: WxApiRoot + 'auth/login_by_weixin', //微信登录
  AuthBindPhone: WxApiRoot + 'auth/phone/update', //绑定微信手机号
  AuthGetPhone:WxApiRoot + 'auth/phone', //得到用户号码
  AuthGetUserInfo:WxApiRoot + 'auth/info', //得到用户信息

  GoodsPost: WxApiRoot +'goods/addgood',//发布商品
  GoodsQuery: WxApiGoods+'goods',//查询商品列表
  GoodsDetail:WxApiGoods+'goods/details/',//对应商品详细信息

  CommentPost: WxApiRoot + 'comment/addComment', //发表评论
  CommentGet: WxApiRoot +'comment/getcomment', //获取评论

  GetAllMission: WxApiRoot +'mission/getAllMission',//获取全部任务
  GetMission: WxApiRoot +'mission/getMission',//获取单个任务
  MissionPost: WxApiRoot + 'mission/addmissison',//发布任务
};