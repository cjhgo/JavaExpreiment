package nine;  
import java.awt.*;  
    import java.io.*;  
    import javax.swing.JOptionPane;  
    
    public class Test_Notepad extends javax.swing.JFrame {  
      
        /** Creates new form Test_Notepad */  
        public Test_Notepad(String name) {  
            super(name);  
            initComponents();  
            setLocation(450, 200);  
        }  
      
       
        private void initComponents() {  
      
            jScrollPane1 = new javax.swing.JScrollPane();  
            jTextArea1 = new javax.swing.JTextArea();  
            jMenuBar1 = new javax.swing.JMenuBar();  
            jMenu1 = new javax.swing.JMenu();  
            jMenuItem1 = new javax.swing.JMenuItem();  
            jMenuItem2 = new javax.swing.JMenuItem();  
            jMenuItem3 = new javax.swing.JMenuItem();  
            jMenuItem4 = new javax.swing.JMenuItem();  
            jSeparator1 = new javax.swing.JSeparator();  
            jSeparator2 = new javax.swing.JSeparator();  
            jMenuItem6 = new javax.swing.JMenuItem();  
            jMenu2 = new javax.swing.JMenu();  
            jMenuItem7 = new javax.swing.JMenuItem();  
            jMenuItem8 = new javax.swing.JMenuItem();  
            jMenuItem9 = new javax.swing.JMenuItem();  
            jMenuItem10 = new javax.swing.JMenuItem();  
            jMenuItem11 = new javax.swing.JMenuItem();  
      
            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);  
      
            jTextArea1.setColumns(20);  
            jTextArea1.setRows(5);  
            jScrollPane1.setViewportView(jTextArea1);  
      
            jMenu1.setText("\u6587\u4ef6");  
            jMenu1.setMinimumSize(new java.awt.Dimension(35, 19));  
      
            jMenuItem1.setText("\u65b0\u5efa");  
            jMenuItem1.addActionListener(new java.awt.event.ActionListener() {  
                public void actionPerformed(java.awt.event.ActionEvent evt) {  
                    jMenuItem1ActionPerformed(evt);  
                }  
            });  
            jMenu1.add(jMenuItem1);  
      
            jMenuItem2.setText("\u6253\u5f00");  
            jMenuItem2.addActionListener(new java.awt.event.ActionListener() {  
                public void actionPerformed(java.awt.event.ActionEvent evt) {  
                    jMenuItem2ActionPerformed(evt);  
                }  
            });  
            jMenu1.add(jMenuItem2);  
      
            jMenuItem3.setText("\u4fdd\u5b58");  
            jMenuItem3.addActionListener(new java.awt.event.ActionListener() {  
                public void actionPerformed(java.awt.event.ActionEvent evt) {  
                    jMenuItem3ActionPerformed(evt);  
                }  
            });  
            jMenu1.add(jMenuItem3);  
      
            jMenuItem4.setText("\u53e6\u5b58\u4e3a");  
            jMenuItem4.addActionListener(new java.awt.event.ActionListener() {  
                public void actionPerformed(java.awt.event.ActionEvent evt) {  
                    jMenuItem4ActionPerformed(evt);  
                }  
            });  
            jMenu1.add(jMenuItem4);  
            jMenu1.add(jSeparator1);  
            jMenu1.add(jSeparator2);  
      
            jMenuItem6.setText("\u9000\u51fa");  
            jMenuItem6.addActionListener(new java.awt.event.ActionListener() {  
                public void actionPerformed(java.awt.event.ActionEvent evt) {  
                    jMenuItem6ActionPerformed(evt);  
                }  
            });  
            jMenu1.add(jMenuItem6);  
      
            jMenuBar1.add(jMenu1);  
      
            jMenu2.setText("\u7f16\u8f91");  
      
            jMenuItem7.setText("\u64a4\u9500");  
            jMenu2.add(jMenuItem7);  
      
            jMenuItem8.setText("\u526a\u5207");  
            jMenu2.add(jMenuItem8);  
      
            jMenuItem9.setText("\u590d\u5236");  
            jMenu2.add(jMenuItem9);  
      
            jMenuItem10.setText("\u7c98\u8d34");  
            jMenu2.add(jMenuItem10);  
      
            jMenuItem11.setText("\u5220\u9664");  
            jMenu2.add(jMenuItem11);  
      
            jMenuBar1.add(jMenu2);  
      
            setJMenuBar(jMenuBar1);  
      
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(  
                    getContentPane());  
            getContentPane().setLayout(layout);  
            layout.setHorizontalGroup(layout.createParallelGroup(  
                    javax.swing.GroupLayout.Alignment.LEADING).addComponent(  
                    jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400,  
                    Short.MAX_VALUE));  
            layout.setVerticalGroup(layout.createParallelGroup(  
                    javax.swing.GroupLayout.Alignment.LEADING).addComponent(  
                    jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 279,  
                    Short.MAX_VALUE));  
      
            pack();  
        }// </editor-fold>  
        //GEN-END:initComponents  
      
        private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {  
            // TODO add your handling code here:  
            jTextArea1.setText(null);  
        }  
      
        private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {  
            // TODO add your handling code here:  
                FileDialog fd = new FileDialog(this, "����Ϊ", FileDialog.SAVE);  
                fd.setVisible(true);  
                String string1 = jTextArea1.getText();  
                String stringfile = fd.getDirectory()+fd.getFile();  
                BufferedWriter bWriter = null;  
                try {  
                    bWriter = new BufferedWriter(new FileWriter(stringfile));  
                    bWriter.write(string1);   
                    bWriter.close();   
                } catch (Exception e) {  
                    // TODO Auto-generated catch block  
                    System.out.println("����ʧ��");  
                }   
        }  
      
        private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {  
            // TODO add your handling code here:  
            String FileName = JOptionPane.showInputDialog("�����뱣����ļ�����");  
            String string1 = jTextArea1.getText();  
            if (FileName != null) {  
                BufferedWriter bWriter = null;  
                try {  
                    bWriter = new BufferedWriter(new FileWriter(new File(FileName)));  
                    bWriter.write(string1);  
                    bWriter.close();  
                } catch (Exception e) {  
                    System.out.println("����ʧ��");  
                }  
            }  
        }  
      
        private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {  
            // TODO add your handling code here:  
            int result = JOptionPane.showConfirmDialog(null, "�˳�ǰ�Ƿ񱣴棿");  
            if (result == JOptionPane.YES_OPTION) {  
                String FileName = JOptionPane.showInputDialog("�����뱣����ļ�����");  
                String string1 = jTextArea1.getText();  
                if (FileName != null) {  
                    BufferedWriter bWriter = null;  
                    try {  
                        bWriter = new BufferedWriter(new FileWriter(new File(  
                                FileName)));  
                        bWriter.write(string1);  
                        bWriter.close();  
                    } catch (Exception e) {  
                        System.out.println("����ʧ��");  
                    }  
                }  
                System.exit(0);  
            } else if (result == JOptionPane.NO_OPTION) {  
                System.exit(0);  
            }  
        }  
      
        private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {  
            // TODO add your handling code here:  
            FileDialog fd = new FileDialog(this, "��", FileDialog.LOAD);  
            fd.setVisible(true);  
            String strFile = fd.getDirectory() + fd.getFile();  
            if (strFile != null) {  
                try {  
                    FileInputStream fis = new FileInputStream(strFile);  
                    byte[] buf = new byte[10 * 1024];  
                    int len = fis.read(buf);  
                    jTextArea1.append(new String(buf, 0, len));  
                    fis.close();  
                } catch (Exception e) {  
                    System.out.println("��ʧ��");  
                }  
            }  
        }  
      
        public void SaveNotepad() {  
            String FileName = JOptionPane.showInputDialog("�����뱣����ļ�����");  
            String string1 = jTextArea1.getText();  
            if (FileName != null) {  
                BufferedWriter bWriter = null;  
                try {  
                    bWriter = new BufferedWriter(new FileWriter(new File(FileName)));  
                    bWriter.write(string1);  
                    bWriter.close();  
                    //              Thread.sleep(1000);  
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
      
        /** 
         * @param args the command line arguments 
         */  
        public static void main(String args[]) {  
            java.awt.EventQueue.invokeLater(new Runnable() {  
                public void run() {  
                    Test_Notepad notepad = new Test_Notepad("��Jue�ļ��±�");  
                    notepad.setVisible(true);  
                }  
            });  
        }  
      
        //GEN-BEGIN:variables  
        // Variables declaration - do not modify  
        private javax.swing.JMenu jMenu1;  
        private javax.swing.JMenu jMenu2;  
        private javax.swing.JMenuBar jMenuBar1;  
        private javax.swing.JMenuItem jMenuItem1;  
        private javax.swing.JMenuItem jMenuItem10;  
        private javax.swing.JMenuItem jMenuItem11;  
        private javax.swing.JMenuItem jMenuItem2;  
        private javax.swing.JMenuItem jMenuItem3;  
        private javax.swing.JMenuItem jMenuItem4;  
        private javax.swing.JMenuItem jMenuItem6;  
        private javax.swing.JMenuItem jMenuItem7;  
        private javax.swing.JMenuItem jMenuItem8;  
        private javax.swing.JMenuItem jMenuItem9;  
        private javax.swing.JScrollPane jScrollPane1;  
        private javax.swing.JSeparator jSeparator1;  
        private javax.swing.JSeparator jSeparator2;  
        private javax.swing.JTextArea jTextArea1;  
        // End of variables declaration//GEN-END:variables  
      
    }  