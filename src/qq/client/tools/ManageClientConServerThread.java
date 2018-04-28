/*
* 管理客户端和服务器端保持通讯的线程类
*/
package qq.client.tools;

import java.util.HashMap;

public class ManageClientConServerThread {
    private static HashMap hm = new HashMap<String, ClientConServerThread>();

    //将创建好的ClientConServerThread放到hm中
    public static void addClientConServerThread(String qqid, ClientConServerThread ccst){
        hm.put(qqid,ccst);
    }

    //通过qqid取得该线程
    public static ClientConServerThread getClientConServerThread(String qqid){
        return (ClientConServerThread)hm.get(qqid);
    }

}
