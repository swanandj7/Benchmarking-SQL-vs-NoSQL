import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
import java.io.*;
import java.util.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Insertion.java
 *
 * Created on Nov 19, 2014, 10:12:31 AM
 */

/**
 *
 * @author Admin
 */
public class Insertion extends javax.swing.JFrame {

    /** Creates new form Insertion */
    public Insertion() {
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

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Bulk insert");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Time taken");

        jTextField1.setEditable(false);

        jButton2.setText("Bulk insert (Mongo)");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(165, 165, 165))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(78, 78, 78)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(92, 92, 92))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        BufferedReader br=null;
        try
        {
             br=new BufferedReader(new FileReader("C:\\xampp\\mysql\\data\\mydb\\join1.txt"));
             if(br==null)
             {
                System.out.println("File note found");
             }
             else
             {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Connection formed successfully");
                String myUrl = "jdbc:mysql://localhost/mydb";
                String pwd="arijit";
                Connection con=DriverManager.getConnection(myUrl,"root",pwd);
                int count=0;
                long total_time=0;
                while((count++)<100)
                {
                    String[] results = br.readLine().split( ",\\s*" );
                    String insertQuery="INSERT INTO insert_tab values(?,?,?)";
                    PreparedStatement ps = null;
                    ps=con.prepareStatement(insertQuery);
                    ps.setString(1,results[0]);
                    ps.setString(2,results[1]);
                    ps.setString(3,results[2]);
                    long timeBefore=System.nanoTime();
                    ps.execute();
                    long timeAfter=System.nanoTime()-timeBefore;
                    total_time+=timeAfter;
                }
                jTextField1.setText(""+total_time);
             }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    MongoClient mongo=null;
    DBCursor cursor=null;
    DBCollection coll=null;
    DB db=null;
    BufferedReader br=null;
    try {
          mongo = new MongoClient("localhost", 27017);
          br=new BufferedReader(new FileReader("C:\\xampp\\mysql\\data\\mydb\\join1.txt"));
          if(br==null)
             {
                System.out.println("File note found");
             }
    } catch(Exception ex)
        {
         ex.printStackTrace();
        }
    db=mongo.getDB("mydb");
    coll=db.getCollection("insert_tab");
    if(coll==null || db==null || mongo==null)
    {
        JOptionPane.showMessageDialog(null, "collection not found");
        return;
    }
    try{
                int count=0;
                long total_time=0;
                while((count++)<100)
                {
                    String[] results = br.readLine().split( ",\\s*" );
                    
                    BasicDBObject query=new BasicDBObject();
                    query.put("field1",results[0]);
                    query.put("field2",results[1]);
                    query.put("field3",results[2]);
                    long timeBefore=System.nanoTime();
                    coll.insert(query);
                    long timeAfter=System.nanoTime()-timeBefore;
                    total_time+=timeAfter;
                }
                jTextField1.setText(""+total_time);
   // TODO add your handling code here:
    }
    catch(Exception e)
    {
        System.out.println(e.toString());
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Insertion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}
