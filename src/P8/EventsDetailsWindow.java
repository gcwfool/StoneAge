package P8;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;  
 
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;  
  
import java.awt.Color;













import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JPanel;  
import javax.swing.JScrollPane;  
import javax.swing.JTable;  
import javax.swing.JTextField;  
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel; 
import javax.swing.table.AbstractTableModel; 





import javax.swing.table.TableCellRenderer;

import java.util.Date;      

import javax.swing.Timer;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Stack;





class ColorTableCellRenderer extends JLabel implements TableCellRenderer

{

private static final long serialVersionUID = 1L;

//定义构造器

public ColorTableCellRenderer ()

{

//设置标签为不透明状态

this.setOpaque(true);

//设置标签的文本对齐方式为居中

this.setHorizontalAlignment(JLabel.CENTER);

}

//实现获取呈现控件的getTableCellRendererComponent方法

public Component getTableCellRendererComponent(JTable table,Object value,

           boolean isSelected,boolean hasFocus,int row,int column)

{           

//获取要呈现的颜色

Color c=(Color)value;

//根据参数value设置背景色

this.setBackground(c);



return this;   

}

 }   



public class EventsDetailsWindow extends JFrame  
{  
  
   
	private static final long serialVersionUID = 508685938515369544L;
	
	private  Vector<String[]> detailsData = null;
	
	
	
	

    
    
/*    private JLabel labeltime = new JLabel("距封盘:");
    private JTextField textFieldtime = new JTextField(15);  
    
    private AtomicLong remainTime = new AtomicLong(0);*/
    
    
    MyTableModel tableMode = new MyTableModel();
    
    
    

    
    
    
	

	public EventsDetailsWindow()  
    {  
		//setTitle("投注北京赛车详情");  
		
        intiComponent();  
        
    }  
	
	

	
	
	
	public void updateEventsDetails(Vector<String[]> eventDetailsVec){
		
		try{
			detailsData = eventDetailsVec;
			
			tableMode.updateTable();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		

		
	}
	
	public  void addData(Object[] a){
		
/*		try{
			detailsData.push(a);
			
	    	Comparator ct = new CompareStr();
	    	
	    	Collections.sort(detailsData, ct);
			
			tableMode.updateTable();
		}catch(Exception e){
			e.printStackTrace();
		}*/
		

	}
	
	

	
	

	
	
	
  
    /** 
     * 初始化窗体组件 
     */  
    private void intiComponent()  
    {  

		final Container container = getContentPane();
		
		container.setLayout(new BorderLayout());
		
		JPanel panelNorth = new JPanel(new GridLayout(5, 4));

        container.add(panelNorth, BorderLayout.NORTH);  
        
        

        
        
/*        panelNorth.add(labeltime);
        panelNorth.add(textFieldtime);
        textFieldjinrichazhi.setEditable(false);*/


	    
		
	    final JTable table = new JTable(tableMode);

        JScrollPane scroll = new JScrollPane(table);  
        
        
	    table.getColumnModel().getColumn(2).setPreferredWidth(240);
	    
	    table.setRowHeight(30);
	    
	    table.setFont(new java.awt.Font("黑体", Font.PLAIN, 15));
	    
	    //table.setColumnModel(columnModel);
	    
	    //tableMode.

	    
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
        tcr.setHorizontalAlignment(JLabel.CENTER);
       // tcr.setHorizontalAlignment(SwingConstants.CENTER);// 这句和上句作用一样
        table.setDefaultRenderer(Object.class, tcr);
        
        
        
        container.add(scroll, BorderLayout.CENTER);  

        setVisible(false);  
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);  
        
        

        
        setBounds(100, 100, 1600, 800); 

    }  
    
    

    

    
    
    
  
    private class MyTableModel extends AbstractTableModel  
    {  
        /* 
         * 这里和刚才一样，定义列名和每个数据的值 
         */  
        String[] columnNames =  
        { "联赛", "时间", "球队", "全场让球", "全场大小", "上半让球", "上半大小"};  
        

        
        //Object[][] data = new Object[2][5];  
        
        

        
  
        /** 
         * 构造方法，初始化二维数组data对应的数据 
         */  
        public MyTableModel()  
        {  

        }  
  
        // 以下为继承自AbstractTableModle的方法，可以自定义  
        /** 
         * 得到列名 
         */  
        @Override  
        public String getColumnName(int column)  
        {  
            return columnNames[column];  
        }  
          
        /** 
         * 重写方法，得到表格列数 
         */  
        @Override  
        public int getColumnCount()  
        {  
            return columnNames.length;  
        }  
  
        /** 
         * 得到表格行数 
         */  
        @Override  
        public int getRowCount()  
        {  
            return detailsData.size();  
        }  
  
        /** 
         * 得到数据所对应对象 
         */  
        @Override  
        public Object getValueAt(int rowIndex, int columnIndex)  
        {  
            //return data[rowIndex][columnIndex];
        	return detailsData.elementAt(rowIndex)[columnIndex+1];
        }  
  
        /** 
         * 得到指定列的数据类型 
         */  
        @Override  
        public Class<?> getColumnClass(int columnIndex)  
        {  
            return detailsData.elementAt(0)[columnIndex].getClass();
        }  
  
        /** 
         * 指定设置数据单元是否可编辑.这里设置"姓名","学号"不可编辑 
         */  
        @Override  
        public boolean isCellEditable(int rowIndex, int columnIndex)  
        {  
            return false;
        }  
          
        /** 
         * 如果数据单元为可编辑，则将编辑后的值替换原来的值 
         */  
        @Override  
        public void setValueAt(Object aValue, int rowIndex, int columnIndex)  
        {  
            detailsData.elementAt(rowIndex)[columnIndex] = (String)aValue;  
            /*通知监听器数据单元数据已经改变*/  
            fireTableCellUpdated(rowIndex, columnIndex);  
        }  
        
        public void updateTable(){
        	fireTableDataChanged();
        }
        
  
    }  
    
    
}