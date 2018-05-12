/*
管理用户聊天界面的类
 */
package qq.client.tools;

import java.util.*;
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

    /*
    //全部取出，收群发消息时需要使用
    public static qqChat[] getAllQqChats(){
        Set keys = hm.keySet();
        Object[] allQqChats = keys.toArray();
        qqChat allQqChatsAttay[] = null;
        allQqChatsAttay = new qqChat[100];
        for(int i =0; i<allQqChats.length;i++){
            allQqChatsAttay[i] = (qqChat)allQqChats[i];
        }
        return allQqChatsAttay;
    }*/
}
