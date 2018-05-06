/*
*  定义包的种类
*/
package qq.common;

public interface MessageType {

    String message_login_succeed = "1";  //表明成功登陆
    String message_login_failed = "2";  //表明登陆失败
    String message_common_mes = "3";   //普通消息包
    String message_get_onlineFriends = "4";   //请求在线好友列表
    String messag_ret_onlineFriends = "5";  //返回在线好友列表
}
