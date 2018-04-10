package qq.common;

public class Message implements java.io.Serializable {  //将对象序列化，以实现对象在网络上或文件中传输(java的反射机制)
    private String mesType;

    public String getMesType() {
        return mesType;
    }

    public void setMesType(String mesType) {
        this.mesType = mesType;
    }
}
