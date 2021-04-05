
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saidu
 */

public class menu extends javax.swing.JFrame {
public String ssvalue="";
public Double finalcostnow;
public int nooftables=0;
public int stime=0;
public String sss="";
public String pubu="";
public String aprom="";
    /**
     * Creates new form menu
     * 
     * 
     */
void checkifuse()
{
    
     JList mList = new JList();
    mList.setModel(new DefaultListModel());

   
    DefaultListModel model = (DefaultListModel)l0.getModel();
    int sel=l0.getSelectedIndex();
    model.removeAllElements();
   
          try
        {
            Class.forName("java.sql.DriverManager");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/cafe","root","ggwp");
            Statement stmt=conn.createStatement();
           
               for(int j=1;j<=nooftables;j++)
               {
                 
                   String qry2="Select * from table"+j;
                    ResultSet rs2=stmt.executeQuery(qry2);
                    boolean val=rs2.next();
                    if(val==false)
                    {
                        ssvalue="Table"+j;
                    }
                    else
                    {
                        ssvalue="Table"+j+" (using)";
                    }
                   
                   
                   
                   model.addElement(ssvalue);
               
                

                

            }
             l0.setSelectedIndex(sel);
           
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this,ex.getMessage());
        }
         
    
}
   void edukku()
   {
        JList mList = new JList();
    mList.setModel(new DefaultListModel());

    /*---- do whatever you want---- */
 long t;
t=System.currentTimeMillis();
 SimpleDateFormat sf4=new SimpleDateFormat("ss");
  
String d=sf4.format((t));

int a1=Integer.parseInt(d);
stime=a1;
    //Retain it wherever you want with
    DefaultListModel model = (DefaultListModel)l1.getModel();
         int county=0;
         String nameu;
           try
        {

            Class.forName("java.sql.DriverManager");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/cafe","root","ggwp");
            Statement stmt=conn.createStatement();
            String qry="Select * from items";
            ResultSet rs=stmt.executeQuery(qry);
            while(rs.next())
            {
                nameu=rs.getString("prodname");
               

               // model.add(county,obj);
                model.addElement(nameu);
                
                county++;

            }

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this,ex.getMessage());
        }  
   }
    public menu() {
        initComponents();
         Dimension sz=Toolkit.getDefaultToolkit().getScreenSize();
        setSize(sz.width,sz.height);
        String ff="qq"+1;
        linfo.setVisible(false); 
         edukku();
              try
        {
String nameu1="";
            Class.forName("java.sql.DriverManager");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/cafe","root","ggwp");
            Statement stmt=conn.createStatement();
            String qry="Select * from companyname";
            ResultSet rs=stmt.executeQuery(qry);
            while(rs.next())
            {
               nameu1=rs.getString("name");
               
            }
            aprom=nameu1;
           ltitle.setText(nameu1+"");
//           jbilltitle.setText("<html>-------------------------------------------------------------------------------------------------"+
  //                 "<br> "+nameu1+"<br> "+
    //             "------------------------------------------------------------------------------------------------- <br>");

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this,ex.getMessage());
        }
        //to shabil.. from here
        
         JComboBox mCombo = new JComboBox();
    mCombo.setModel(new DefaultComboBoxModel());

  
    DefaultComboBoxModel model2 = (DefaultComboBoxModel)cb1.getModel();
    try
        {
            Class.forName("java.sql.DriverManager");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/cafe","root","ggwp");
            Statement stmt=conn.createStatement();
            String qry="Select * from login where desig='waiter'";
            ResultSet rs=stmt.executeQuery(qry);
            while(rs.next())
            {
                
                String name=rs.getString("name");
                
                model2.addElement(name);
                

            }

        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this,ex.getMessage());
        }   
//till here
    
  try
        {
            Class.forName("java.sql.DriverManager");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/cafe","root","ggwp");
            Statement stmt=conn.createStatement();
             for(int i=1;i<=30;i++)
             {
                  String qry="Delete from table"+i;
            stmt.executeUpdate(qry);
             }
           
           
        
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this,ex.getMessage());
            
        }
            
    
         l1.setFocusable(false);
         b1.setEnabled(false);
         b2.setEnabled(false);
         l1.setEnabled(false);
         
         
         JList mList = new JList();
    mList.setModel(new DefaultListModel());

   
    DefaultListModel model = (DefaultListModel)l0.getModel();
    
   
          try
        {
            Class.forName("java.sql.DriverManager");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/cafe","root","ggwp");
            Statement stmt=conn.createStatement();
            String qry="Select * from details";
            ResultSet rs=stmt.executeQuery(qry);
            while(rs.next())
            {
                String  count=rs.getString("tablecount");
               int dd=Integer.parseInt(count.toString());
               nooftables=dd;
               for(int j=1;j<=nooftables;j++)
               {
                   ssvalue="Table"+j;
                   model.addElement(ssvalue);
               }
                

                

            }
             l0.setSelectedIndex(0);
           
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this,ex.getMessage());
        }
         jLabel5.setIcon(new javax.swing.ImageIcon("C:\\bg.jpg"));
           try {

			
			FileInputStream fin = new FileInputStream("C:\\background.txt");
                        BufferedReader br=new BufferedReader(new InputStreamReader(fin));
String s1=br.readLine();
			

jLabel5.setIcon(new javax.swing.ImageIcon(s1)); 

		} catch (IOException e) {
			
		} 
   
         
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        linfo = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        t1 = new javax.swing.JTable();
        ll1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        b2 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        l0 = new javax.swing.JList<>();
        jLabel17 = new javax.swing.JLabel();
        b1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        l1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jprint = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        cb1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        ltitle = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        pl2 = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane6.setViewportView(jTextArea2);

        jButton2.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        linfo.setBackground(new java.awt.Color(255, 255, 255));
        linfo.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        linfo.setOpaque(true);
        getContentPane().add(linfo);
        linfo.setBounds(760, 700, 550, 20);

        jButton3.setText("<-- LogOut");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(20, 650, 110, 40);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 204, 0));
        jLabel1.setText("SELECTED ITEM");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(680, 120, 220, 50);

        t1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "item name", "number ", "cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(t1);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(600, 180, 300, 470);

        ll1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        ll1.setOpaque(true);
        getContentPane().add(ll1);
        ll1.setBounds(510, 380, 90, 20);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 204, 0));
        jLabel15.setText("ITEM NAME");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(520, 340, 130, 50);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 204, 0));
        jLabel2.setText("COUNT");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(530, 400, 60, 20);

        tf1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        tf1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf1KeyReleased(evt);
            }
        });
        getContentPane().add(tf1);
        tf1.setBounds(510, 420, 90, 20);

        b2.setText("Generate ");
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });
        b2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                b2KeyReleased(evt);
            }
        });
        getContentPane().add(b2);
        b2.setBounds(900, 370, 100, 40);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 204, 0));
        jLabel16.setText("CHOOSE TABLE");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(50, 120, 150, 50);

        l0.setModel(new DefaultListModel());
        l0.setSelectionBackground(new java.awt.Color(255, 51, 51));
        l0.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                l0KeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(l0);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 176, 220, 470);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 204, 0));
        jLabel17.setText("CHOOSE ITEM");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(320, 120, 130, 50);

        b1.setText("add ");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        b1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                b1KeyReleased(evt);
            }
        });
        getContentPane().add(b1);
        b1.setBounds(520, 460, 70, 40);

        l1.setModel(new DefaultListModel());
        l1.setSelectionBackground(new java.awt.Color(255, 51, 51));
        l1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l1MouseClicked(evt);
            }
        });
        l1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                l1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(l1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(270, 180, 240, 470);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 5)); // NOI18N
        jButton1.setText("->");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(230, 420, 40, 30);

        jButton4.setText("<-- Remove Row");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(760, 660, 140, 30);

        jprint.setText("Print and Add");
        jprint.setEnabled(false);
        jprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jprintActionPerformed(evt);
            }
        });
        jprint.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jprintKeyReleased(evt);
            }
        });
        getContentPane().add(jprint);
        jprint.setBounds(1110, 670, 140, 30);

        jButton6.setText("DeleteAll");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(630, 660, 120, 30);

        cb1.setModel(new DefaultComboBoxModel());
        getContentPane().add(cb1);
        cb1.setBounds(900, 420, 100, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 204, 0));
        jLabel3.setText("BILL");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(1150, 120, 90, 40);

        ltitle.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        ltitle.setForeground(new java.awt.Color(204, 0, 0));
        getContentPane().add(ltitle);
        ltitle.setBounds(490, 30, 420, 70);

        jButton7.setText("info");
        jButton7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton7MouseMoved(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(1310, 720, 80, 40);

        jScrollPane4.setViewportView(pl2);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(1010, 180, 380, 480);

        jLabel5.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bg8.jpg"))); // NOI18N
        jLabel5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel5MouseMoved(evt);
            }
        });
        getContentPane().add(jLabel5);
        jLabel5.setBounds(-10, 0, 1400, 760);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        login ll=new login();
        ll.setVisible(true);
        setVisible(false);

       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed

        
        
        
        int count=Integer.parseInt(tf1.getText());

        String selected = l1.getSelectedValue();
        DefaultTableModel tm=(DefaultTableModel)t1.getModel();
        
String s=ll1.getText();
int ssvalue22 = l0.getSelectedIndex();
          ssvalue22=ssvalue22+1;
         String ssvalue2="table"+ssvalue22;
int gautham=0;
String priceu2;
int priceu;
int price=0;
int countz=count,pricez=price;
 
try
{
 int hj=tm.getRowCount();
 for(int j=0;j<=hj;j++)
 {   
     Object obj1=tm.getValueAt(j,0);
     String pak=obj1.toString();
     pak=pak.trim();
     s=s.trim();
     
    
     if(pak.equals(s))
     {
         Object objj=tm.getValueAt(j,1);
     
     int q=Integer.parseInt(objj.toString());
        
         
         count=count+q;
         gautham=1;
         tm.removeRow(j);
        
     }
     
     
   
 }
}
catch(Exception ex)
{
  //  JOptionPane.showMessageDialog(this,ex.getMessage());
}

try
        {

            Class.forName("java.sql.DriverManager");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/cafe","root","ggwp");
            Statement stmt=conn.createStatement();
            String qry="Select * from items where prodname='"+s+"'";
            ResultSet rs=stmt.executeQuery(qry);
            while(rs.next())
            {
                priceu2=rs.getString("price");
                priceu=Integer.parseInt(priceu2);
                 price=priceu*count;
        Object obj[]={s,count,price};
        tm.addRow(obj);
                
            }
            int ccc=tm.getRowCount();
        if(ccc>0)
        {
            b2.setEnabled(true);
        }
        }
 catch(Exception ex)
 {
     
 }
 
 tf1.setText("");
 
 if(gautham==0)
 {
   try
{
    int g3;
    String g1,g2;

              try
        {
            Class.forName("java.sql.DriverManager");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/cafe","root","ggwp");
            Statement stmt=conn.createStatement();
             
            String qry="insert into "+ssvalue2+" values('"+s+"',"+count+","+price+")";
            stmt.executeUpdate(qry);
           
        
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this,ex.getMessage());
            
        }
               
      
      
}
catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this,"enter valid values");
        }        
 }
 else if(gautham==1)
 {
     try
{
    int g3;
    String g1,g2;

              try
        {
            Class.forName("java.sql.DriverManager");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/cafe","root","ggwp");
            Statement stmt=conn.createStatement();
             
            String qry="update "+ssvalue2+" set number="+count+" where itemname='"+s+"'";
            stmt.executeUpdate(qry);
            
            
           
            
            
           
        
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this,ex.getMessage());
            
        }
               
      
      
}
catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this,"enter valid values");
        }
 }
 checkifuse();
        // TODO add your handling code here:
    }//GEN-LAST:event_b1ActionPerformed

    private void l1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l1MouseClicked
        String selected = l1.getSelectedValue();
        if(selected==null)
        {
            
        }
        else
        {
              ll1.setText(selected+" ");
        }
      

        // TODO add your handling code here:
    }//GEN-LAST:event_l1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
DefaultTableModel tm=(DefaultTableModel)t1.getModel();
tm.setRowCount(0);
l1.setFocusable(true);
         b1.setEnabled(true);
         l1.setEnabled(true);
         String gh1,h2,h3;
         int gh2,gh3;
         int ssvalue22 = l0.getSelectedIndex();
          ssvalue22=ssvalue22+1;
         String ssvalue2="table"+ssvalue22;
         
        int ccc=tm.getRowCount();
        if(ccc>0)
        {
            b2.setEnabled(true);
        }
         
         
try
        {

            Class.forName("java.sql.DriverManager");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/cafe","root","ggwp");
            Statement stmt=conn.createStatement();
            String qry="Select * from "+ssvalue2+"";
            ResultSet rs=stmt.executeQuery(qry);
            while(rs.next())
            {
                gh1=rs.getString("itemname");
                h2=rs.getString("number");
                h3=rs.getString("cost");
                gh2=Integer.parseInt(h2);
                gh3=Integer.parseInt(h3);
                
        Object obj[]={gh1,h2,h3};
        tm.addRow(obj);
                
            }
        }
 catch(Exception ex)
 {
     
 }         
         
       checkifuse();  
         
         // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        try
{
        DefaultTableModel tm=(DefaultTableModel)t1.getModel();
        
      
int a=t1.getSelectedRow();
String ss=tm.getValueAt(a,0).toString();

     
     //int s1=Integer.parseInt(obj2.toString());
tm.removeRow(a);
int b=tm.getRowCount();
if(b==0)
{
    b2.setEnabled(false);
}


    
    

int ssvalue22 = l0.getSelectedIndex();
          ssvalue22=ssvalue22+1;
         String ssvalue2="table"+ssvalue22;
            Class.forName("java.sql.DriverManager");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/cafe","root","ggwp");
            Statement stmt=conn.createStatement();
             
             String qry="Delete from "+ssvalue2+" where itemname='"+ss+"'";
            stmt.executeUpdate(qry);
           
        
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this,ex.getMessage());
            
        }
checkifuse();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed

        int bbb=JOptionPane.showOptionDialog(null,"Are You Sure You want to generate the bill?","Message",JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null,null,null);
                  if(bbb==JOptionPane.YES_OPTION)
                  {
                      jprint.setEnabled(true);
        int ggwp=pl2.getText().length();
        pl2.setContentType("text/html");
        StringBuffer sb=new StringBuffer();
        
        sb.append("<html><center><b><font size='15' face='Bookman Old Style'>"+aprom+"</font></b></center><br>"
                + "<body>- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -"
                + "<br> "
                + " <center>"
                + "<b><font size='10'>BILL</font></b></center><br>"
                + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - <br>"
                
                + "<table>"
                + "<tr>"
                
                 + "<th>Item &nbsp&nbsp &nbsp &nbsp &nbsp &nbsp&nbsp &nbsp &nbsp &nbsp &nbsp&nbsp &nbsp &nbsp &nbsp &nbsp&nbsp &nbsp &nbsp &nbsp &nbsp&nbsp &nbsp &nbsp &nbsp</th>"
                 + "<th>Quantity &nbsp&nbsp &nbsp &nbsp &nbsp &nbsp&nbsp &nbsp &nbsp &nbsp &nbsp&nbsp &nbsp &nbsp &nbsp</th>"
                 + "<th>Cost &nbsp&nbsp &nbsp &nbsp &nbsp &nbsp&nbsp &nbsp &nbsp &nbsp &nbsp&nbsp &nbsp &nbsp &nbsp</th>"
                + "</tr>");
       
        int sum=0;
         DefaultTableModel tm=(DefaultTableModel)t1.getModel();
 try
 {
        
 
 int a=tm.getRowCount();
 
 for(int j=0;j<a;j++)
 {
     Object obj1=tm.getValueAt(j,0);
     String s=obj1.toString();
     Object obj2=tm.getValueAt(j,1);
     Object obj3=tm.getValueAt(j,2);
     int s1=Integer.parseInt(obj2.toString());
     int s2=Integer.parseInt(obj3.toString());
     sb.append("<tr>"
              + "<td> "+s+"</td>"
             + "<td> "+s1+"</td>"
                     + "<td> "+s2+"</td>"
                             + "</tr>  ");
     sum+=s2;
     
 }
 }
 catch(Exception e)
 {
     
 }
 //llll       
        
       ////llll 
        try
        {
            int ssvalue22 = l0.getSelectedIndex();
          ssvalue22=ssvalue22+1;
         String ssvalue2="table"+ssvalue22;
            Class.forName("java.sql.DriverManager");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/cafe","root","ggwp");
            Statement stmt=conn.createStatement();
             
             String qry="Delete from "+ssvalue2;
            stmt.executeUpdate(qry);
           
        
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this,ex.getMessage());
            
        }
 
      
 
 
 String h1,h2,h3;
 int k1=0,k2=0,k3=0;
 Double m1=0.0,m2=0.0,i1=0.0,i2=0.0;
 try
        {

            Class.forName("java.sql.DriverManager");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/cafe","root","ggwp");
            Statement stmt=conn.createStatement();
            String qry="Select * from details";
            ResultSet rs=stmt.executeQuery(qry);
            while(rs.next())
            {
                h1=rs.getString("tax");
                h2=rs.getString("service");
                m1=Double.parseDouble(h1);
                m2=Double.parseDouble(h2);
              
              
               m1=m1/100;
               m2=m2/100;
k1=Integer.parseInt(h1);
k2=Integer.parseInt(h2);    




                
         
                
            }
        }
 catch(Exception ex)
 {
     
 }  
 
 Double j1=(sum*m1*100);
 long jl1=Math.round(j1);
 String pp1=jl1+"";
 j1=Double.parseDouble(pp1)/100;
 
 Double j2=(sum*m2*100);
 long jl2=Math.round(j2);
 String pp2=jl2+"";
 j2=Double.parseDouble(pp2)/100;
 
 Double jj=(j1+j2+sum)*100;
 long jl3=Math.round(jj);
 String pp3=jl3+"";
 jj=Double.parseDouble(pp3)/100;
 m1=m1*100;
 m2=m2*100;

sb.append("</table><br><br>&nbsp &nbsp &nbsp &nbsp &nbsp  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp"
        + "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"
        + "   Tax("+m1+"%)="+j1+"<br> "
                + "&nbsp &nbsp &nbsp &nbsp &nbsp  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp"
        + "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&n"
                + "bsp&nbsp&nbsp&nbsp&nbsp service Tax("+m2+"%)="+j2+" <br><br><br><br> "
        + "<center><b><font size='6'><p style='border:3px;border-style:solid;'>Total Cost= "+jj+" egp</p></font></b></center>");
 tm.setRowCount(0);
  
            long t;
t=System.currentTimeMillis();
        SimpleDateFormat sf=new SimpleDateFormat("dd");
        SimpleDateFormat sf2=new SimpleDateFormat("MM");
        SimpleDateFormat sf3=new SimpleDateFormat("yyyy");
        SimpleDateFormat sf4=new SimpleDateFormat("hh:mm:ss a ");
        SimpleDateFormat sf5=new SimpleDateFormat("EEE");
        

String a=sf.format((t));
String b=sf2.format((t));
String c=sf3.format((t));
String d=sf4.format((t));
String e=sf5.format((t));

 String selected2=cb1.getSelectedItem().toString();
 String hjk=d+" "+a+"/"+b+"/"+c+"  "+e;
 sb.append("<br><br>&nbsp&nbsp&nbsp&nbsp Served by: "+selected2+"<br>&nbsp&nbsp&nbsp &nbsp "+hjk+""
         + "<br><br><br><center><b>Thank You, Visit Again </b></center></body>  </html>");
        
        
        pl2.setText(sb.toString());
        pubu=sb.toString();
       
 finalcostnow=jj;
 


                      
                      
                  }
                  else
                  {
                      
                  }
                  
    checkifuse();    // TODO add your handling code here:
    }//GEN-LAST:event_b2ActionPerformed

    private void jprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jprintActionPerformed

        
        jprint.setEnabled(false);
        
try
{
    try
{
    
   // boolean pd=jt1.print();
   Toolkit tkp=pl2.getToolkit();
   PrintJob pjp=tkp.getPrintJob(this,null,null);
   Graphics g=pjp.getGraphics();
   pl2.print(g);
   g.dispose();
   pjp.end();
   
}
catch(Exception ex)
{
    
}       
    
                  try
        {
            Class.forName("java.sql.DriverManager");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/cafe","root","ggwp");
            Statement stmt=conn.createStatement();
 
            
            //idhu time and dateku
            
            long t;
t=System.currentTimeMillis();
        SimpleDateFormat sf=new SimpleDateFormat("dd");
        SimpleDateFormat sf2=new SimpleDateFormat("MM");
        SimpleDateFormat sf3=new SimpleDateFormat("yyyy");
        SimpleDateFormat sf4=new SimpleDateFormat("hh:mm:ss a ");
        SimpleDateFormat sf5=new SimpleDateFormat("EEE");
        

String a=sf.format((t));
String b=sf2.format((t));
String c=sf3.format((t));
String d=sf4.format((t));
String e=sf5.format((t));

int a1=Integer.parseInt(a);
int b1=Integer.parseInt(b);
int c1=Integer.parseInt(c);
String c7="database"+c1;
 int ssvalue22 = l0.getSelectedIndex();
          ssvalue22=ssvalue22+1;
         String selected="table"+ssvalue22;
 String selected2=cb1.getSelectedItem().toString();

          
            String qry="insert into "+c7+" values("+a1+","+b1+","+c1+",'"+e+"','"+d+"',"+finalcostnow+",'"+selected+"','"+selected2+"')";
            stmt.executeUpdate(qry);
           
        
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this,ex.getMessage());
            
        }
               

    
    
}
catch(Exception ex)
{
    
}


        // TO;DO add your handling code here:
    }//GEN-LAST:event_jprintActionPerformed

    private void l0KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_l0KeyReleased
 if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
      jButton1.doClick();
      l1.requestFocus();
  l1.setSelectedIndex(0);
   }
  
 if(evt.getKeyCode() == KeyEvent.VK_1) {
     l0.setSelectedIndex(0);
     sss=sss+1;
      
   }
 if(evt.getKeyCode() == KeyEvent.VK_2) {
     l0.setSelectedIndex(1);
      sss=sss+2;
   }
 if(evt.getKeyCode() == KeyEvent.VK_3) {
     l0.setSelectedIndex(2);
      sss=sss+3;
   }
 if(evt.getKeyCode() == KeyEvent.VK_4) {
     l0.setSelectedIndex(3);
      sss=sss+4;
   }
 if(evt.getKeyCode() == KeyEvent.VK_5) {
     l0.setSelectedIndex(4);
     sss=sss+5;
   }
 if(evt.getKeyCode() == KeyEvent.VK_6) {
     l0.setSelectedIndex(5);
      sss=sss+6;
   }
 if(evt.getKeyCode() == KeyEvent.VK_7) {
     l0.setSelectedIndex(6);
      sss=sss+7;
   }
 if(evt.getKeyCode() == KeyEvent.VK_8) {
     l0.setSelectedIndex(7);
      sss=sss+8;
   }
 if(evt.getKeyCode() == KeyEvent.VK_9) {
     l0.setSelectedIndex(9);
      sss=sss+9;
   }
 if(evt.getKeyCode() == KeyEvent.VK_0) {
     l0.setSelectedIndex(9);
      sss=sss+0;
   }
 if(sss.length()==1||sss.length()==2)
 {
     int a=Integer.parseInt(sss);
     l0.setSelectedIndex(a-1);
     if(sss.length()==2)
     {
         sss="";
     }
      
     
 }
 

      
 
 
        // TODO add your handling code here:
    }//GEN-LAST:event_l0KeyReleased

    private void l1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_l1KeyReleased
if(evt.getKeyCode() == KeyEvent.VK_EQUALS) {
    
    b2.doClick();
    jprint.requestFocus();
}
if(evt.getKeyCode() == KeyEvent.VK_PLUS) {
    jprint.requestFocus();
    b2.doClick();
}
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
      
     
  
  String selected = l1.getSelectedValue();
        if(selected==null)
        {
            
        }
        else
        {
              ll1.setText(selected+" ");
        } 
         tf1.requestFocus();
   }
         // TODO add your handling code here:
    }//GEN-LAST:event_l1KeyReleased

    private void tf1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf1KeyReleased
if(evt.getKeyCode() == KeyEvent.VK_EQUALS) {
    jprint.requestFocus();
    b2.doClick();
}
if(evt.getKeyCode() == KeyEvent.VK_PLUS) {
    jprint.requestFocus();
    b2.doClick();
}
if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
      b1.doClick();
      l1.requestFocus();
  l1.setSelectedIndex(0);
   }
  
// TODO add your handling code here:
    }//GEN-LAST:event_tf1KeyReleased

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
DefaultTableModel tm=(DefaultTableModel)t1.getModel();
tm.setRowCount(0);

            
        
  try
        {
            int ssvalue22 = l0.getSelectedIndex();
          ssvalue22=ssvalue22+1;
         String ssvalue2="table"+ssvalue22;
            Class.forName("java.sql.DriverManager");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/cafe","root","ggwp");
            Statement stmt=conn.createStatement();
             
             String qry="Delete from "+ssvalue2;
            stmt.executeUpdate(qry);
           
        
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this,ex.getMessage());
            
        }
        checkifuse();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void b2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_b2KeyReleased

if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
      b2.doClick();
      
  
   }        // TODO add your handling code here:
    }//GEN-LAST:event_b2KeyReleased

    private void b1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_b1KeyReleased
if(evt.getKeyCode() == KeyEvent.VK_EQUALS) {
    
    b2.doClick();
}
if(evt.getKeyCode() == KeyEvent.VK_PLUS) {
    
    b2.doClick();
}
if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
      b1.doClick();
      l1.requestFocus();
  l1.setSelectedIndex(0);
   }        // TODO add your handling code here:
    }//GEN-LAST:event_b1KeyReleased

    private void jprintKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jprintKeyReleased
if(evt.getKeyCode() == KeyEvent.VK_P) {
      jprint.doClick();
      
  
   }          // TODO add your handling code here:
    }//GEN-LAST:event_jprintKeyReleased

    private void jButton7MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseMoved
        linfo.setVisible(true);
        linfo.setText("<html>\n" +
            "<head>\n" +
            "	<title>cafe</title>\n" +
            "</head>\n" +
            "<body><h1>gggggg</h1>\n" +
            "<p1> ggwp </p1>\n" +
            "\n" +
            "\n" +
            "</body>\n" +
            "</html>");
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7MouseMoved

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jLabel5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseMoved
linfo.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseMoved

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JComboBox<String> cb1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JButton jprint;
    private javax.swing.JList<String> l0;
    private javax.swing.JList<String> l1;
    private javax.swing.JLabel linfo;
    private javax.swing.JLabel ll1;
    private javax.swing.JLabel ltitle;
    private javax.swing.JTextPane pl2;
    private javax.swing.JTable t1;
    private javax.swing.JTextField tf1;
    // End of variables declaration//GEN-END:variables
}
