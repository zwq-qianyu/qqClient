package qq.common;

public class Message implements java.io.Serializable {     //将对象序列化，以实现对象在网络上或文件中传输(java的反射机制)
    private static final long serialVersionUID = 1234567890L;   //自定义serialVersionUID，防止版本问题而无法进行消息传递

    private String mesType;

    private String sender;
    private String getter;
    private String con;
    private String sendTime;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getMesType() {
        return mesType;
    }

    public void setMesType(String mesType) {
        this.mesType = mesType;
    }
}