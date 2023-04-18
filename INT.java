import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class INT extends JFrame implements ActionListener
 {
     JLabel label1, label2;
     JTextField t1;
     JButton b1, b2, b3;
    
    INT()
 {
        setTitle("Sorting Algorithms");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLayout(null);
        label1 = new JLabel("Enter integers separated by commas:");
        
        

        label1.setBounds(50,20,350,25);
      
      
        t1= new JTextField(50);
        t1.setBounds(50,50,420,40);
        
        label2 = new JLabel();
        label2.setBounds(50,90,500,100);
        
     
     
       
       
        b1 = new JButton("Bubble Sort");
        b2 = new JButton("Insertion Sort");
        b3 = new JButton("Selection Sort");
        
        b1.setBounds(20,200,150,40);
        b2.setBounds(200,200,150,40);
        b3.setBounds(380,200,150,40);
        add(label1);
        add(t1);
        add(label2);
        add(b1);
        add(b2);
        add(b3);
        
       
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
 {
        String input = t1.getText();
        String[] inputs = input.split(",");
        int[] array = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) 
{
            array[i] = Integer.parseInt(inputs[i].trim());
        }
        
        if (e.getSource() == b1)
 {
            bubbleSort(array);
        } else if (e.getSource() == b2) 
{
            insertionSort(array);
        } else if (e.getSource() == b3) 
{
            selectionSort(array);
        }
        
        label2.setText("Sorted array: " + arrayToString(array));
    }
    
    public void bubbleSort(int[] array)
 {
        int n = array.length;
        for (int i = 0; i < n-1; i++)
 {
            for (int j = 0; j < n-i-1; j++) 
{
                if (array[j] > array[j+1])
 {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    
    public void insertionSort(int[] array)
 {
        int n = array.length;
        for (int i = 1; i < n; i++) 
{
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key)
 {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
    }
    
    public void selectionSort(int[] array)
 {
        int n = array.length;
        for (int i = 0; i < n-1; i++) 
{
            int minIndex = i;
            for (int j = i+1; j < n; j++) 
{
                if (array[j] < array[minIndex])
 {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
    
    public String arrayToString(int[] array) 
{
        String result = "";
        for (int i = 0; i < array.length; i++)
 {
            result += array[i] + " ";
        }
        return result;
    }
    
    public static void main(String[] args)
 {
        INT a = new INT();
        a.setBounds(400,200,600,400);
        a.setVisible(true);
    }
}