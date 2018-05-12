/*
*  定义包的种类
*/
package qq.common;

public interface MessageType {

    String message_login_succeed = "1";  //表明成功登陆
    String message_login_failed = "2";  //表明登陆失败
    String message_common_mes = "3";   //普通消息包
    String message_get_onlineFriends = "4";   //请求在线好友列表
    String message_ret_onlineFriends = "5";  //返回在线好友列表
    String message_off_line = "6";  //表明用户下线
    String message_ret_off_line = "7";  //返回下线用户列表
    String message_to_all = "8";    //管理员群发的消息
    String message_group_chat = "9";    //群聊消息
}
