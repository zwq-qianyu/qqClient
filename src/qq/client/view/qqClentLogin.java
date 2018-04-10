package qq.client.view;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import qq.client.back.*;
import qq.common.*;

public class qqClentLogin extends JFrame implements ActionListener {
    //定义北部需要的组件
    JLabel jlb1;

    //定义中部需要的组件
    JPanel jp2;
    JLabel jp2_jlb1,jp2_jlb2;
    JTextField jp2_jtf;
    JPasswordField jp2_jpf;
    JButton jp2_jb1;

    //定义南部的组件
    JPanel jp1;
    JCheckBox jp1_jcb1,jp1_jcb2;
    JLabel jp1_jlb1,jp1_jlb2;

    //构造函数
    public qqClentLogin(){
        //处理北部
        jlb1 = new JLabel(new ImageIcon("image/beibu.png"));

        //处理中部
        jp2 = new JPanel(new GridLayout(3,2,5,5));
        jp2_jtf = new JTextField();
        jp2_jpf = new JPasswordField();
        jp2_jlb1 = new JLabel("账号",JLabel.CENTER);
        jp2_jlb2 = new JLabel("密码",JLabel.CENTER);
        jp2_jb1 = new JButton("登录");
        //相应用户点击登录
        jp2_jb1.addActionListener(this);

        //放到jp2
        jp2.add(jp2_jlb1);
        jp2.add(jp2_jtf);
        jp2.add(jp2_jlb2);
        jp2.add(jp2_jpf);
        jp2.add(jp2_jb1);

        //处理南部
        jp1 = new JPanel(new GridLayout(2,2));
        jp1_jcb1 = new JCheckBox("记住密码");
        jp1_jcb2 = new JCheckBox("隐身登录");
        jp1_jlb1 = new JLabel("忘记密码");
        jp1_jlb2 = new JLabel("注册账号");

        //放到jp1
        jp1.add(jp1_jcb1);
        jp1.add(jp1_jlb1);
        jp1.add(jp1_jcb2);
        jp1.add(jp1_jlb2);

        this.add(jlb1,"North");
        this.add(jp2,"Center");
        this.add(jp1,"South");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(240,320);
        this.setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent e){
        //如果用户点击登录
        if(e.getSource()==jp2_jb1){
            ClientUser cu = new ClientUser();
            User u = new User();
            u.setUserId(jp2_jtf.getText().trim());  //去除前后的空格等
            u.setPasswd(new String(jp2_jpf.getPassword()));

            if(cu.checkUser(u)){
                new qqFriendsList();
                //关闭登录界面
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this,"用户名密码错误");
            }
        }
    }

    //主函数
    public static void main(String args[]){
        qqClentLogin qqlogin = new qqClentLogin();
    }
}
