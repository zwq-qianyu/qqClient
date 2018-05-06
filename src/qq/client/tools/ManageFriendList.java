/*
管理好友、黑名单、特别关心。。。界面类
 */

package qq.client.tools;

import java.util.HashMap;
import qq.client.view.*;

public class ManageFriendList {
    private static HashMap hm = new HashMap<String, qqFriendsList>();

    //将创建好的qqFriendsList放到hm中
    public static void addqqFriendsList(String qqid, qqFriendsList qfl){
        hm.put(qqid,qfl);
    }

    //通过qqid取得该好友列表界面
    public static qqFriendsList getqqFriendsList(String qqid){
        return (qqFriendsList)hm.get(qqid);
    }
}
