package qq.client.back;

import qq.common.*;
public class ClientUser {
    public boolean checkUser(User u){
        return new ClientToServer().sendLoginInfoToServer(u);
    }
}
