/*
用户信息类
 */
package qq.common;

public class User implements java.io.Serializable {   //将对象序列化，以实现对象在网络上或文件中传输(java的反射机制)
    private String userId;
    private String passwd;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}