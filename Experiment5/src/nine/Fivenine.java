package nine;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.Transferable;

import javax.swing.*;

public class Fivenine extends JFrame implements ActionListener{

	private JTextArea jta; 
	private JScrollPane jp;
	private JMenuBar jmb;
	private JMenu filem;
	private JMenu editm;
	private JMenuItem newfile = new JMenuItem();
	private JMenuItem open = new JMenuItem();
	private JMenuItem save = new JMenuItem();
	private JMenuItem save_as = new JMenuItem();
	private JMenuItem exit = new JMenuItem();
	private JMenuItem copy = new JMenuItem();
	private JMenuItem paste = new JMenuItem();
	private JMenuItem cut = new JMenuItem();
	private JMenuItem find = new JMenuItem(); 

	Fivenine(String name)
	{
		this.setTitle(name);
		initCompoents();
	}
	private void initCompoents()
	{
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		jmb = new JMenuBar();
		
		
        filem = new JMenu();
        filem.setText("File");
        jmb.add(filem);

        editm = new JMenu();
        editm.setText("Edit");
        jmb.add(editm);
        
        newfile.setText("new");
		newfile.addActionListener(this);
		filem.add(newfile);
		filem.addSeparator();
		
        open.setText("open");
		open.addActionListener(this);
		filem.add(open);
		filem.addSeparator();
		
		save.setText("save");
		save.addActionListener(this);
		filem.add(save);
		filem.addSeparator();
		
		save_as.setText("save_as");
		save_as.addActionListener(this);
		filem.add(save_as);
		filem.addSeparator();


		exit.setText("exit");
		exit.addActionListener(this);
		filem.add(exit);
		filem.addSeparator();
		
		copy.setText("copy");
		copy.addActionListener(this);
		editm.add(copy);
		editm.addSeparator();

		paste.setText("paste");
		paste.addActionListener(this);
		editm.add(paste);
		editm.addSeparator();

		cut.setText("cut");
		cut.addActionListener(this);
		editm.add(cut);
		editm.addSeparator();

		find.setText("find");
		find.addActionListener(this);
		editm.add(find);
		editm.addSeparator();
		
        this.setJMenuBar(jmb);

        
		jta = new JTextArea();
		jp = new JScrollPane();  
        jta.setColumns(40);
        jta.setRows(60);
        jta.setLineWrap(true);
        jp.setViewportView(jta);
        this.add(jp);
        
        
        this.setSize(600, 500);
        this.setLocation(300, 100);
        this.setVisible(true);
        //pack();

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Fivenine("cjh-notepad");
	}
	
	private void handle_new(ActionEvent e)
	{
		jta.setText(null);
	}
	private void handle_open(ActionEvent e)
	{
		FileDialog fd = new FileDialog(this, "打开", FileDialog.LOAD);  
        fd.setVisible(true);  
        String strFile = fd.getDirectory() + fd.getFile();  
        if (strFile != null) {  
            try {  
                FileInputStream fis = new FileInputStream(strFile);  
                byte[] buf = new byte[10 * 1024];  
                int len = fis.read(buf);  
                jta.append(new String(buf, 0, len));  
                fis.close();  
            } catch (Exception ex) {  
                System.out.println("打开失败");  
            }  
        }  
	}
	private void handle_save(ActionEvent e)
	{
		String FileName = JOptionPane.showInputDialog("请输入保存的文件名：");  
        String string1 = jta.getText();  
        if (FileName != null) {  
            BufferedWriter bWriter = null;  
            try {  
                bWriter = new BufferedWriter(new FileWriter(new File(FileName)));  
                bWriter.write(string1);  
                bWriter.close();  
            } catch (Exception ex) {  
                System.out.println("保存失败");  
            }  
        }  
	}
	private void handle_save_as(ActionEvent e)
	{
		FileDialog fd = new FileDialog(this, "另存为", FileDialog.SAVE);  
        fd.setVisible(true);  
        String string1 = jta.getText();  
        String stringfile = fd.getDirectory()+fd.getFile();  
        BufferedWriter bWriter = null;  
        try {  
            bWriter = new BufferedWriter(new FileWriter(stringfile));  
            bWriter.write(string1);   
            bWriter.close();   
        } catch (Exception ex) {  
            // TODO Auto-generated catch block  
            System.out.println("保存失败");  
        }   
	}
	private void handle_exit(ActionEvent e)
	{
		System.exit(0);
	}
	private void handle_copy(ActionEvent e)
	{
		jta.copy();

	}
	private void handle_paste(ActionEvent e)
	{
		jta.paste();
	}
	private void handle_cut(ActionEvent e)
	{
		jta.cut();
	}
	private void handle_find(ActionEvent e)
	{
		//
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource().equals(newfile))
		{
			handle_new(e);
		}
		else if(e.getSource().equals(open))
		{
			handle_open(e);
		}
		else if(e.getSource().equals(save))
		{
			handle_save(e);
		}
		else if(e.getSource().equals(save_as))
		{
			handle_save_as(e);
		}
		else if(e.getSource().equals(exit))
		{
			handle_exit(e);
		}
		else if(e.getSource().equals(copy))
		{
			handle_copy(e);
		}
		else if(e.getSource().equals(paste))
		{
			handle_paste(e);
		}
		else if(e.getSource().equals(cut))
		{
			handle_cut(e);
		}
		else if(e.getSource().equals(find))
		{
			handle_find(e);
		}

	}


}
