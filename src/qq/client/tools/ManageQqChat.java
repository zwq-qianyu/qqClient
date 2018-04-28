/*
管理用户聊天界面的类
 */
package qq.client.tools;

import java.util.HashMap;
import qq.client.view.*;

public class ManageQqChat {
    private static HashMap hm = new HashMap<String, qqChat>();

    //加入
    public static void addQqChat(String loginidAndFriendid, qqChat qqchat){
        hm.put(loginidAndFriendid, qqchat);
    }

    //取出
    public static qqChat getQqChat(String loginidAndFriendid){
        return (qqChat)hm.get(loginidAndFriendid);
    }
}
