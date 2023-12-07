/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.sourcecode.main;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.plaf.ProgressBarUI;



/**
 *
 * @author ashish
 */




public final class ReadQR extends javax.swing.JFrame implements Runnable , ThreadFactory{
    
     public static void main(String args[]) {
                  


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ReadQR().setVisible(true);
        });
        
        
//        progressbarrr();
//        progressbarrr2();
//        progressbarrr3();
//        progressbarrr4();
//        progressbarrr5();
//        progressbarrr6();
        
        
       
        
        
    
        
    }
    //p = panel ;
    //wc = webcam ;
    ///ex = executor
    private WebcamPanel p = null;
    private Webcam wc = null;
    private final Executor ex =  Executors.newSingleThreadExecutor(this);
    

    /**
     * Creates new form ReadQR
     */
    public ReadQR() {
        initComponents();
        initWebcam();
        Connect();
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void Connect(){ 
        
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/productdetails","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadQR.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReadQR.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        resultfield = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 430, 290));

        resultfield.setBackground(new java.awt.Color(204, 255, 255));
        resultfield.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        resultfield.setForeground(new java.awt.Color(51, 0, 0));
        resultfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        resultfield.setText("result");
        resultfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultfieldActionPerformed(evt);
            }
        });
        resultfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                resultfieldKeyPressed(evt);
            }
        });
        jPanel1.add(resultfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 530, 70));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/sourcecode/main/BG.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void resultfieldActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        
        
        
    }                                           

    private void resultfieldKeyPressed(java.awt.event.KeyEvent evt) {                                       
        // TODO add your handling code here:
        
        String Barcode = resultfield.getText();
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            try {
               
                java.util.Date date = new java.util.Date();
                java.sql.Date sqldate = new java.sql.Date(date.getTime());
                java.sql.Timestamp sqltime = new java.sql.Timestamp(date.getTime());
                
                pst = (PreparedStatement) con.prepareStatement("SELECT * FROM product WHERE barcodenumber =?");
                pst.setString(1, Barcode);
                rs = (ResultSet) pst.executeQuery();
                
                if(rs.next() == false){
                    pst = (PreparedStatement) con.prepareStatement("INSERT INTO entry (barcodenumber , Date , Time )VALUES(?,?,?)");
                    pst.setString(1, Barcode);
                    pst.setDate(2, sqldate);
                    pst.setTimestamp(3, sqltime);
                    
                    int q = pst.executeUpdate();
                    
                    if(q==1){
                         JOptionPane.showMessageDialog(this , " PRODUCT REGISTERED SUCCESSFULLY " );
                         resultfield.setText("");
                         resultfield.requestFocus();
                         
                    }else{
                        JOptionPane.showMessageDialog(this , "ERROR IN PRODUCT REGISTRATION " );
                    
                    }
                }else{
                    JOptionPane.showMessageDialog(this , "NOT IN DATABASE  " );
                
                }
            } catch (SQLException ex) {
                Logger.getLogger(ReadQR.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        }
        
        
    }                                      

  
   

    
    
    private void initWebcam(){
        Dimension size = WebcamResolution.QVGA.getSize();
        wc = Webcam.getWebcams().get(0);
        wc.setCustomViewSizes(size);
        
        p = new WebcamPanel(wc);
        p.setPreferredSize(size);
       
        jPanel2.add(p , new org.netbeans.lib.awtextra.AbsoluteConstraints(0,0,430 ,290));
        ex.execute(this);
        
    }
    
    
    @Override
    
    
    public void run(){
        
        do{
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(ReadQR.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Result result = null;
            BufferedImage image = null;
            
            if(wc.isOpen()){
                if((image = wc.getImage()) == null){
                    continue;
                }
            }
            
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            
            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException ex) {
                Logger.getLogger(ReadQR.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(result != null){
                resultfield.setText(result.getText());
                
            }
            
            
        }while(true);
    }
    
    @Override
    public Thread newThread(Runnable r){
        Thread t  = new Thread( r , "IS EQUAL ");
        t.setDaemon(true);
        return t;
    }
    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField resultfield;
    // End of variables declaration                   
}
