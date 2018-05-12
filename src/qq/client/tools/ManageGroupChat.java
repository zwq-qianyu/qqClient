package qq.client.tools;

import qq.client.view.qqChat;

import java.util.HashMap;
import qq.client.view.groupChat;

public class ManageGroupChat {
    private static HashMap hm = new HashMap<String, groupChat>();

    //加入
    public static void addGroupChat(String loginid, groupChat gc){
        hm.put(loginid, gc);
    }

    //取出
    public static groupChat getGroupChat(String loginid){
        return (groupChat)hm.get(loginid);
    }
}
