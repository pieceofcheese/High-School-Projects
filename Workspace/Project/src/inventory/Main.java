 package inventory;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.table.*;

public class Main {

    private static JFrame frame;
    private static JTable table = null;
    private static	DefaultTableModel model = null;
    private static JButton addButton = null;
    private static JButton save = null;
    private static JButton sortM = null;
    private static JButton sortL = null;
    private static JButton sortW = null;
    private static JButton sortT = null;
    private static JButton sortA = null;
    private static JScrollPane pane = null;
    private static JPanel menu = null;
    static String loc = "H:\\ComSci\\text\\test.txt";

    public static void main(String args[]) {
     
    	//intialize frame
    	frame = new JFrame();
    	
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setPreferredSize(new Dimension(800, 400));
    	
    	//initialize tableModel
    	String[] columnNames = {"Material", "Length", "Width", "Thickness", "Amount"};
    	
    	try {
			model = new DefaultTableModel(fileIn(loc), columnNames);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//make table
    	table = new JTable(model);
    	
    	//intialize scroll pane
    	pane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    	
    	addButton = new JButton("Add");
    	addButton.addActionListener(new ActionListener() {
    		
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Object source = e.getSource();
				
				if(source == addButton) {
					
					Object[] temp = {"material", new Float(0), new Float(0), new Float(0), new Integer(0)};
					
					model.addRow(temp);
					
				}
				
			}
    		
    	});
    	
    	save = new JButton("Save");
    	save.addActionListener(new ActionListener() {
    		
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Object source = e.getSource();
				
				if(source == save) {
					
					try {
						save();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
			}
    		
    	});
    	
    	sortM = new JButton("Sort by\nmaterials");
    	sortM.addActionListener(new ActionListener() {
    		
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Object source = e.getSource();
				
				if(source == sortM) {
					
					String[] strings = new String[model.getRowCount()];
					
					for(int x = 0; x<model.getRowCount(); x++) {
						try{
						strings[x] = (String) model.getValueAt(x, 0);
						}
						
						catch(RuntimeException e1) {
							
							System.out.println("not strings being sorted");
							
						}
					}
					
					String[] compare = null;
					try {
						compare = sortString(strings, 0, strings.length);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					for(int x = 0;  x<compare.length; x++) {
						
						String anchor = compare[x];
						
						for(int y = 0; y<model.getRowCount(); y++) {
							
							if(((String) model.getValueAt(y, 0)).equalsIgnoreCase(compare[x])) {
								
								model.moveRow(y, y, x);
								
							}
							
						}
						
						
					}
					
				}
				
			}
    		
    	});
    	
    	sortL = new JButton("Sort by\nlength");
    	sortL.addActionListener(new ActionListener() {
    		
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Object source = e.getSource();
				
				if(source == sortM) {
					
					String[] strings = new String[model.getRowCount()];
					
					for(int x = 0; x<model.getRowCount(); x++) {
						try{
						strings[x] = (String) model.getValueAt(x, 0);
						}
						
						catch(RuntimeException e1) {
							
							System.out.println("not strings being sorted");
							
						}
					}
					
					String[] compare=null;
					try {
						compare = sortString(strings, 0, strings.length);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					for(int x = 0;  x<compare.length; x++) {
						
						String anchor = compare[x];
						
						for(int y = 0; y<model.getRowCount(); y++) {
							
							if(((String) model.getValueAt(y, 0)).equalsIgnoreCase(compare[x])) {
								
								model.moveRow(y, y, x);
								
							}
							
						}
						
						
					}
					
				}
				
			}
    		
    	});
    	
    	sortW = new JButton("Sort by\nwidth");
    	sortW.addActionListener(new ActionListener() {
    		
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Object source = e.getSource();
				
				if(source == sortM) {
					
					String[] strings = new String[model.getRowCount()];
					
					for(int x = 0; x<model.getRowCount(); x++) {
						try{
						strings[x] = (String) model.getValueAt(x, 0);
						}
						
						catch(RuntimeException e1) {
							
							System.out.println("not strings being sorted");
							
						}
					}
					
					String[] compare=null;
					try {
						compare = sortString(strings, 0, strings.length);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					for(int x = 0;  x<compare.length; x++) {
						
						String anchor = compare[x];
						
						for(int y = 0; y<model.getRowCount(); y++) {
							
							if(((String) model.getValueAt(y, 0)).equalsIgnoreCase(compare[x])) {
								
								model.moveRow(y, y, x);
								
							}
							
						}
						
						
					}
					
				}
				
			}
    		
    	});
    	
    	sortT = new JButton("Sort by\nthickness");
    	sortT.addActionListener(new ActionListener() {
    		
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Object source = e.getSource();
				
				if(source == sortM) {
					
					String[] strings = new String[model.getRowCount()];
					
					for(int x = 0; x<model.getRowCount(); x++) {
						try{
						strings[x] = (String) model.getValueAt(x, 0);
						}
						
						catch(RuntimeException e1) {
							
							System.out.println("not strings being sorted");
							
						}
					}
					
					String[] compare=null;
					try {
						compare = sortString(strings, 0, strings.length);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					for(int x = 0;  x<compare.length; x++) {
						
						String anchor = compare[x];
						
						for(int y = 0; y<model.getRowCount(); y++) {
							
							if(((String) model.getValueAt(y, 0)).equalsIgnoreCase(compare[x])) {
								
								model.moveRow(y, y, x);
								
							}
							
						}
						
						
					}
					
				}
				
			}
    		
    	});
    	
    	sortA = new JButton("Sort by\namount");
    	sortA.addActionListener(new ActionListener() {
    		
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Object source = e.getSource();
				
				if(source == sortM) {
					
					String[] strings = new String[model.getRowCount()];
					
					for(int x = 0; x<model.getRowCount(); x++) {
						try{
						strings[x] = (String) model.getValueAt(x, 0);
						}
						
						catch(RuntimeException e1) {
							
							System.out.println("not strings being sorted");
							
						}
					}
					
					String[] compare=null;
					try {
						compare = sortString(strings, 0, strings.length);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					for(int x = 0;  x<compare.length; x++) {
						
						String anchor = compare[x];
						
						for(int y = 0; y<model.getRowCount(); y++) {
							
							if(((String) model.getValueAt(y, 0)).equalsIgnoreCase(anchor)) {
								
								model.moveRow(y, y, x);
								
							}
							
						}
						
						
					}
					
				}
				
			}
    		
    	});
    	
    	menu = new JPanel();
    	
    	menu.add(addButton);
    	menu.add(save);
    	menu.add(sortM);
    	menu.add(sortL);
    	menu.add(sortW);
    	menu.add(sortT);
    	menu.add(sortA);
    	menu.add(pane);
    	frame.add(menu);
    	
    	
    	
    	frame.setVisible(true);
    	
    }
    
    public static String[] sortString(String a[], int left, int right) throws IOException{
		
		//if one value
		if(!(right==left)) {
			
			//choose middle
			int middle = (left + right)/2;
			
			//split more
			stringMergeSort(a, left, middle);
			stringMergeSort(a, middle+1, right);
			
			//sort
			merge(a, left, middle, right);
			
		}
		
		return a;
		
	}
    
public static void stringMergeSort(String a[], int left, int right) throws IOException{
		
		//if there is one value
		if(right==left) return;
		
		//choose middle
		int middle = (left + right)/2;
		
		//split more
		stringMergeSort(a, left, middle);
		stringMergeSort(a, middle+1, right);
		
		//sort
		merge(a, left, middle, right);
		
	}
	
	private static void merge(String[] a, int left, int middle, int right) {
		
		//make values
		String tmpArray[] = new String[right-left+1];
		
		int index1 = left;
		int index2 = middle + 1;
		int indx = 0;
		
		//sort based on indexes
		while(index1 <= middle&&index2<=right) {
			
			//for left side
			if(a[index1].compareTo(a[index2])<0) {
				
				tmpArray[indx] = a[index1];
				index1++;
			
			//for right side
			} else {
				
				tmpArray[indx] = a[index2];
				index2++;
				
			}
			
			indx++;
			
		}
		
		//fill rest of it
		while(index1<=middle) {
			
			tmpArray[indx] = a[index1];
			index1++;
			indx++;
		}
		
		while(index2<=right){
			
			tmpArray[indx] = a[index2];
			index2++;
			indx++;
			
		}
		
		//fill array with sorted variables
		for(indx = 0; indx<tmpArray.length; indx++) {
			
			a[left+indx] = tmpArray[indx];
			
		}
		
	}

	private static Object[][] fileIn(String loc) throws IOException {
		
		Scanner scan = new Scanner(new File(loc));
		
		Object[][] data;
		ArrayList<Pipe> temp = new ArrayList<Pipe>();
		
		while(scan.hasNext()) {
			
			Pipe temps = new Pipe(scan.next(),scan.nextFloat(),scan.nextFloat(),scan.nextFloat(),scan.nextInt());
			temp.add(temps);
			
		}
		
		data = new Object[temp.size()][5];
		
		for(int x = 0; x<temp.size(); x++) {
			
			data[x][0] = temp.get(x).material;
			data[x][1] = temp.get(x).length;
			data[x][2] = temp.get(x).width;
			data[x][3] = temp.get(x).thickness;
			data[x][4] = temp.get(x).amount;
			
		}
		
		return data;
	}
	
	
	

	public static void save() throws IOException {
		
		FileWriter fw = new FileWriter(loc);
		PrintWriter print = new PrintWriter(fw);
		
		for(int x = 0; x<model.getRowCount(); x++) {
			
			print.print(model.getValueAt(x, 0)+ " ");
			print.print(model.getValueAt(x, 1)+ " ");
			print.print(model.getValueAt(x, 2)+ " ");
			print.print(model.getValueAt(x, 3)+ " ");
			print.print(model.getValueAt(x, 4)+ " ");
			print.println();
			
		}
		
		print.close();
		fw.close();
		
	}
	
	
}



class Pipe {
	
	public Pipe(String s, float l, float w, float t, int a) {
	
		material = s;
		length = l;
		width = w;
		thickness = t;
		amount = a;
		
	}
	
	String material;
	float length;
	float width;
	float thickness;
	int amount;
	
}