/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJFrame.java
 *
 * Created on Jan 28, 2015, 6:21:01 PM
 */

/**
 *
 * @author Admin
 */

import com.mongodb.BasicDBObject;
import com.mongodb.BulkWriteOperation;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import java.sql.*;

public class NewJFrame extends javax.swing.JFrame {

    /** Creates new form NewJFrame */
    public NewJFrame() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Index field Execution time measurement");

        jLabel2.setText("Mongodb execution time");

        jLabel1.setText("Mysql Execution time");

        jLabel5.setText("Search key(q)");

        jTextField2.setEditable(false);

        jTextField1.setEditable(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton5.setText("Mysql");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Mongo");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jRadioButton3.setText("1000000 records");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("10000 records");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton1.setText("100 records");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(jLabel3)
                .addContainerGap(108, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField4)
                    .addComponent(jTextField2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                .addContainerGap(76, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addGap(42, 42, 42))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(185, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jRadioButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(162, 162, 162))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton3)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
    
    // TODO add your handling code here:
}//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    try
    {
     Class.forName("com.mysql.jdbc.Driver");
    System.out.println("Connection formed successfully");
    String myUrl = "jdbc:mysql://localhost/mydb";
    String pwd="arijit";

    
    Connection con=DriverManager.getConnection(myUrl,"root",pwd);
    Statement st=con.createStatement();
    String query="";
    if(jRadioButton1.isSelected()==true)
    {
        query="select * from test_tab1 where q="+"'"+jTextField4.getText()+"'"; //make this query parameterized later
    }
    if(jRadioButton2.isSelected()==true)
    {
        query="select * from test_tab2 where q="+"'"+jTextField4.getText()+"'"; //make this query parameterized later
    }
    if(jRadioButton3.isSelected()==true)
    {
        query="select * from test_tab3 where q="+"'"+jTextField4.getText()+"'"; //make this query parameterized later
    }
    long timeNow = System.nanoTime();

    ResultSet rs=st.executeQuery(query);
    long timeAfter = System.nanoTime()-timeNow;
    System.out.println(query);
    while(rs.next())
    {

System.out.print(rs.getString("a"));
System.out.print(rs.getString("b"));
System.out.print(rs.getString("c"));
System.out.print(rs.getString("d"));
System.out.print(rs.getString("e"));
System.out.print(rs.getString("f"));
System.out.print(rs.getString("g"));
System.out.print(rs.getString("h"));
System.out.print(rs.getString("i"));
System.out.print(rs.getString("j"));
System.out.print(rs.getString("k"));
System.out.print(rs.getString("l"));
System.out.print(rs.getString("n"));
System.out.print(rs.getString("naics"));
System.out.print(rs.getString("o"));
System.out.print(rs.getString("p"));
System.out.print(rs.getString("q"));
System.out.print(rs.getString("r"));
System.out.print(rs.getString("s"));
System.out.print(rs.getString("t"));
System.out.print(rs.getString("u"));
System.out.print(rs.getString("v"));
System.out.print(rs.getString("w"));
System.out.print(rs.getString("x"));
System.out.print(rs.getString("y"));
System.out.print(rs.getString("z"));

    }
    jTextField1.setText(""+timeAfter);

    st.close();
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
DBCursor cursor=null;
       MongoClient mongoClient=null;

       try{
        mongoClient= new MongoClient("localhost",27017); //initialize connection
        DB db = mongoClient.getDB("mydb"); //connect to database, if no authentication then this will work
        DBCollection coll=null;
        if(jRadioButton1.isSelected()==true)
        {
            coll = db.getCollection("test_tab1");//from database object, get collection with date
        }
        if(jRadioButton2.isSelected()==true)
        {
            coll = db.getCollection("test_tab2");//from database object, get collection with date
        }
        if(jRadioButton3.isSelected()==true)
        {
            coll = db.getCollection("test_tab3");//from database object, get collection with date
        }
        BasicDBObject query=new BasicDBObject();
       query.put("q",jTextField4.getText() );
       long timeNow = System.nanoTime();
       cursor=coll.find(query);
        long timeAfter = System.nanoTime()-timeNow;

       jTextField2.setText(""+timeAfter);
       /*if(cursor.count()>0)
        {
            DBObject currentRecord=cursor.next();
            System.out.println("Records fetched");
        }
        else
        {
           // JOptionPane.showMessageDialog(null,"Record not found");
           System.out.println("Record not found!");
        }*/
      // long actual = timeAfter-timeNow;
        while(cursor.hasNext())
        {
            DBObject o=cursor.next();
            System.out.println(o);
        }
       }
       catch(Exception ex)
       {
        JOptionPane.showMessageDialog(null,ex);
       }
       finally
       {
        cursor.close();//cleanup
        mongoClient.close();
       }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed

        jRadioButton1.setSelected(false);
jRadioButton2.setSelected(false);
        // TODO add your handling code here:
}//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        jRadioButton1.setSelected(false);
jRadioButton3.setSelected(false);
}//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
jRadioButton2.setSelected(false);
jRadioButton3.setSelected(false);// TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

}