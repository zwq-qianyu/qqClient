package qq.client.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class qqFriendsList extends JFrame implements ActionListener,MouseListener {
    //处理第一张卡片
    JPanel jphy1,jphy2,jphy3;
    JButton jphy_jb1,jphy_jb2,jphy_jb3;
    JScrollPane jsp1;

    //处理第二张卡片（陌生人）
    JPanel jpmsr1,jpmsr2,jpmsr3;
    JButton jpmsr_jb1,jpmsr_jb2,jpmsr_jb3;
    JScrollPane jsp2;

    //处理第三张卡片（陌生人）
    JPanel jphmd1,jphmd2,jphmd3;
    JButton jphmd_jb1,jphmd_jb2,jphmd_jb3;
    JScrollPane jsp3;

    //对整个JFrame进行卡片布局
    CardLayout cl;
    public qqFriendsList(){
        //处理第一张卡片（好友列表）
        jphy_jb1 = new JButton("我的好友");
        jphy_jb2 = new JButton("陌生人");
        jphy_jb2.addActionListener(this);  //监听
        jphy_jb3 = new JButton("黑名单");
        jphy_jb3.addActionListener(this);
        jphy1 = new JPanel(new BorderLayout());

        //假设有50个好友
        jphy2 = new JPanel((new GridLayout(50,1,4,4)));
        //给jphy2初始化50个好友
        JLabel []jlbs1 = new JLabel[50];
        for(int i = 0;i < jlbs1.length;i++){
            jlbs1[i] = new JLabel(i+1+"",new ImageIcon("image/mine.jpg"),JLabel.LEFT);
            jlbs1[i].addMouseListener(this);
            jphy2.add(jlbs1[i]);
        }

        jphy3 = new JPanel(new GridLayout(2,1));
        //把两个按钮加到jphy3中
        jphy3.add(jphy_jb2);
        jphy3.add(jphy_jb3);

        jsp1 = new JScrollPane(jphy2);

        //将所有组件加到最大的jphy1中去（对jph1初始化）
        jphy1.add(jphy_jb1,"North");
        jphy1.add(jsp1,"Center");
        jphy1.add(jphy3,"South");


        /* 处理第二张卡片（陌生人）*/
        jpmsr_jb1 = new JButton("我的好友");
        jpmsr_jb1.addActionListener(this);
        jpmsr_jb2 = new JButton("陌生人");
        jpmsr_jb3 = new JButton("黑名单");
        jpmsr_jb3.addActionListener(this);
        jpmsr1 = new JPanel(new BorderLayout());

        //假设有20个陌生人
        jpmsr2 = new JPanel((new GridLayout(20,1,4,4)));
        //给jpmsr2初始化20个陌生人
        JLabel []jlbs2 = new JLabel[20];
        for(int i = 0;i < jlbs2.length;i++){
            jlbs2[i] = new JLabel(i+1+"",new ImageIcon("image/mine.jpg"),JLabel.LEFT);
            jlbs2[i].addMouseListener(this);
            jpmsr2.add(jlbs2[i]);
        }

        jpmsr3 = new JPanel(new GridLayout(2,1));
        //把两个按钮加到jpmsr3中
        jpmsr3.add(jpmsr_jb1);
        jpmsr3.add(jpmsr_jb2);

        jsp2 = new JScrollPane(jpmsr2);

        //将所有组件加到最大的jpmsr1中去（对jpmsr1初始化）
        jpmsr1.add(jpmsr3,"North");
        jpmsr1.add(jsp2,"Center");
        jpmsr1.add(jpmsr_jb3,"South");


        /* 处理第三张卡片（黑名单）*/
        jphmd_jb1 = new JButton("我的好友");
        jphmd_jb1.addActionListener(this);
        jphmd_jb2 = new JButton("陌生人");
        jphmd_jb2.addActionListener(this);
        jphmd_jb3 = new JButton("黑名单");
        jphmd1 = new JPanel(new BorderLayout());

        //假设有5个黑名单人员
        jphmd2 = new JPanel((new GridLayout(10,1,4,4)));
        //给jphmd2初始化5个黑名单人员
        JLabel []jlbs3 = new JLabel[5];
        for(int i = 0;i < jlbs3.length;i++){
            jlbs3[i] = new JLabel(i+1+"",new ImageIcon("image/mine.jpg"),JLabel.LEFT);
            jlbs3[i].addMouseListener(this);
            jphmd2.add(jlbs3[i]);
        }

        jphmd3 = new JPanel(new GridLayout(3,1));
        //把两个按钮加到jphmd3中
        jphmd3.add(jphmd_jb1);
        jphmd3.add(jphmd_jb2);
        jphmd3.add(jphmd_jb3);


        jsp3 = new JScrollPane(jphmd2);

        //将所有组件加到最大的jpmsr1中去（对jpmsr1初始化）
        jphmd1.add(jphmd3,"North");
        jphmd1.add(jsp3,"Center");



        //添加到JFrame上
        cl = new CardLayout();
        this.setLayout(cl);
        this.add(jphy1,"1");
        this.add(jpmsr1,"2");
        this.add(jphmd1,"3");

        this.setVisible(true);
        this.setSize(200,400);
        this.setTitle("在线");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==jphy_jb2||e.getSource()==jphmd_jb2){
            cl.show(this.getContentPane(),"2");
        }
        else if(e.getSource()==jpmsr_jb1||e.getSource()==jphmd_jb1){
            cl.show(this.getContentPane(),"1");
        }
        else if(e.getSource()==jphy_jb3||e.getSource()==jpmsr_jb3){
            cl.show(this.getContentPane(),"3");
        }
    }

    public void mouseClicked(MouseEvent e){
        //相应用户双击事件，并得到好友的名字
        if(e.getClickCount()==2){
            //获取好友的姓名
            String friendName = ((JLabel)e.getSource()).getText();
            //System.out.println("你将和" + friendName + "聊天！");
            new qqChat(friendName);
        }
    }
    public void mouseEntered(MouseEvent e){
        JLabel jl = (JLabel)e.getSource();
        jl.setForeground(Color.red);
    }
    public void mouseExited(MouseEvent e){
        JLabel jl = (JLabel)e.getSource();
        jl.setForeground(Color.black);
    }
    public void mousePressed(MouseEvent e){

    }
    public void mouseReleased(MouseEvent e){

    }

    public static void main(String args[]){
        qqFriendsList qqfl = new qqFriendsList();
    }
}
