import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.util.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
//import javafx.*;

class DoubleBuffer extends Frame 
 { 
   int gap=31;
   int mx, my; 
   boolean flicker=true;
   Image buffer = null;
   int w=400, h=400;
   Graphics screengc = null;
   public DoubleBuffer() 
    { 
     addMouseMotionListener(new MouseMotionAdapter() 
      {
       public void mouseDragged (MouseEvent me) 
        {
          mx = me.getX(); 
          my = me.getY();
          flicker=false;
          repaint();
        }
      public void mouseMoved (MouseEvent me) 
       { 
         mx = me.getX();
         my = me.getY(); 
         flicker=true;
         repaint ();
       }
     });
    addWindowListener(new WindowAdapter() 
     {
      public void windowclosing (WindowEvent we) 
       { 
        System.exit(0);
       }
     });
    }
  public void paint (Graphics g1) 
   {
    Graphics screengc = null;
    if (!flicker) 
     {
       Graphics g;
       g=buffer.getGraphics ();
     }
    g1.setColor (Color.blue); 
    g1.fillRect (0, 0, w, h);
    g1.setColor (Color.red);
    for (int i=0; i<w; i+=gap) 
     g1.drawLine(i, 0, w-i, h);
    for (int i=0; i<h; i+=gap)
     g1.drawLine(0, 1, w, h-i);
    g1.setColor (Color.black); 
   // g1.setColor (Color.yellow);
   // g1.fillOval (mx - gap, my - gap,gap*2+1, gap*2+1);
    if (!flicker) 
     {
      screengc.drawImage (buffer, 0, 0, null);
     }
   }

  public void update (Graphics g1) 
   {
    paint (g1);
   }
 }

class Menu extends JPanel implements ActionListener
 {
   JFrame f=new JFrame("Menu");
  /* JLabel l1=new JLabel("Customer Registeration"); 
   JLabel l2=new JLabel("Flight Updation");
   JLabel l3=new JLabel("Exit"); */
   private JRadioButton r1; 
   private JRadioButton r2; 
   private JRadioButton r3;
/*   JLabel l4=new JLabel("Mobile Number");
   JLabel l5=new JLabel("Permanent Address");
   JLabel l6=new JLabel("Destination Place");
   JLabel l7=new JLabel("Available Flights");
   JLabel l8=new JLabel("Select Flight");
   JTextField t2=new JTextField(); 
   JTextField t3=new JTextField();
   JTextField t4=new JTextField();
   JTextField t5=new JTextField();
   JTextField t6=new JTextField();
   JTextField t1=new JTextField();
   JButton b1=new JButton("Enter");  */
   Menu()
    {
      setBounds(0,0,640,480);
      r1 = new JRadioButton("Customer Registeration"); 
      r2 = new JRadioButton("Flight Updation"); 
      r3 = new JRadioButton("Exit");
      ButtonGroup gp = new ButtonGroup();
      gp.add(r1); 
      gp.add(r2); 
      gp.add(r3); 
      r1.addActionListener(this); 
      r2.addActionListener(this); 
      r3.addActionListener(this);
      f.setLayout(null); 
      f.setVisible(true); 
      f.setSize(1920,1080);
     }
   public void actionPerformed(ActionEvent e) 
    {
     if(r1.isSelected() == true) 
      {
        f.setVisible(false);
        new Customer();
      }
     else if(r2.isSelected() == true) 
      {
        f.setVisible(false);
        //new Flight();
      }
     else if(r3.isSelected() == true) 
      {
        System.exit(0);
      } 
    }
 }
 
class Login extends javax.swing.JFrame implements ActionListener 
 {
  Image img;
  JFrame f=new JFrame("Login");
  JLabel l1=new JLabel("Username"); 
  JLabel l2=new JLabel("Password");
  JTextField t1=new JTextField(); 
  JTextField t2=new JTextField();
  JTextField t3=new JTextField();
  JButton b1=new JButton("Sign in"); 
  //setBackground("Airline.jpg");
  Login()
   {
    try{
    Image img = ImageIO.read(new File("Airline.jpg"));}
    catch(Exception e1)
     {
     }
    l1.setBounds(850,200,100,40); 
    l2.setBounds(850,260,100,40);
    t1.setBounds(950,200,200,40); 
    t2.setBounds(950,260,200,40);
    b1.setBounds(1000,310,100,30);
    f.add(l1); 
    f.add(l2);  
    f.add(t1); 
    f.add(t2); 
    f.add(b1);
    b1.addActionListener(this);
    f.setLayout(null); 
    f.setVisible(true); 
    f.setSize(1920,1080);
   }
  
  /*    addWindowListener(new WindowAdapter()
     {
       public void windowClosing(WindowEvent we)
        {
          System.exit(0);
        }
     });*/ 
   
  public void paint(Graphics g) {
    super.paint(g); 
    g.drawImage(img, 0, 0, null);
   } 
     
  public void actionPerformed(ActionEvent e)
   {
     String s1=t1.getText(); 
     String s2=t2.getText();
     if(e.getSource()==b1) 
      { 
        if(s1.equals("admin"))
         {
           if(s2.equals("admin"))
            {
              f.setVisible(false);
             // new Menu();
             new Customer();
            }
           else
            {
              t3.setBounds(520,260,130,20);
              f.add(t3);
              t3.setText("Wrong Password");
            }
         }
        else
         {
              t3.setBounds(520,160,130,20);
              f.add(t3);
              t3.setText("Wrong Username");
            }
      }
   }
 }
 
class Customer implements ActionListener
 {
  JFrame f=new JFrame("Customer Details");
  JLabel l1=new JLabel("Enter the Customer Details"); 
  JLabel l2=new JLabel("Customer ID");
  JLabel l3=new JLabel("Customer Name");
  JLabel l4=new JLabel("Mobile Number");
  JLabel l5=new JLabel("Permanent Address");
  JLabel l6=new JLabel("Destination Place");
  JLabel l7=new JLabel("Available Flights");
  JLabel l8=new JLabel("Select Flight");
  JTextField t2=new JTextField(); 
  JTextField t3=new JTextField();
  JTextField t4=new JTextField();
  JTextField t5=new JTextField();
  JTextField t6=new JTextField();
  JTextField t1=new JTextField(); 
  JButton b1=new JButton("Enter");  
  Customer()
   {
    l1.setBounds(870,100,300,60); 
    l2.setBounds(800,240,200,40);
    l3.setBounds(800,300,200,40);
    l4.setBounds(800,360,200,40);
    l5.setBounds(800,420,200,40);
    l6.setBounds(800,480,200,40);
    t2.setBounds(1050,240,200,40);
    t3.setBounds(1050,300,200,40);
    t4.setBounds(1050,360,200,40);
    t5.setBounds(1050,420,200,40);
    t6.setBounds(1050,480,200,40);
    b1.setBounds(1100,540,100,30);
    f.add(l1); 
    f.add(l2);
    f.add(l3);
    f.add(l4);
    f.add(l5);
    f.add(l6);
    f.add(t2);
    f.add(t3);
    f.add(t4); 
    f.add(t5); 
    f.add(t6);
    f.add(b1);
    b1.addActionListener(this);
    f.setLayout(null); 
    f.setVisible(true); 
    f.setSize(1920,1080);
   }
  public void actionPerformed(ActionEvent e)
   {
     int j=0;
/*     ArrayList<String> a = new ArrayList<String>()
     a.add("Air Asia");
     a.add("Air India");
     a.add("Spicejet");
     a.add("");
     Iterator itr = a.Iterator(); */
     String s1=t2.getText(); 
     String s2=t3.getText();
     String s3=t4.getText();
     String s4=t5.getText();
     String s5=t6.getText();     
     if(e.getSource()==b1) 
      { 
       // while(itr.hasNext())
        // {
            l7.setBounds(800,600,200,40);
            f.add(l7);
            try
             {
               JLabel l9=new JLabel("Flight Number");
               JLabel l10=new JLabel("Flight Name");
               JLabel l11=new JLabel("Flight Departure Time");
               JLabel l12=new JLabel("Flight Rate");
               l9.setBounds(800,660,200,40);
               l10.setBounds(920,660,200,40);
               l11.setBounds(1040,660,200,40);
               l12.setBounds(1240,660,200,40);
               f.add(l9);
               f.add(l10);
               f.add(l11);
               f.add(l12);
               FileReader f1 = new FileReader("Flights.txt");
               while(f1.read()!=-1)
                {
                  t1.setBounds(800,720+j,100,40);
                  f.add(t1);
                  t1.setText(String.valueOf(f1.read()));
                  j+=60;
                }
               l8.setBounds(1000,600,100,40);
               f.add(l8);
             }
            catch(Exception e1)
             {
               t1.setBounds(800,720,100,40);
               f.add(t1);
               t1.setText("Error Occurred");
             }
         }  
        else
         {
            //  t1.setBounds(520,260,130,20);
         //     f.add(t1);
              //t1.setText("Wrong Password");
          }
     }
 }
 
/*public class Test extends Application 
 {
    @Override
    public void start(Stage primaryStage) 
     {
        StackPane root = new StackPane();
        root.setId("pane");
        Scene scene = new Scene(root, 300, 250);
        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
     }
}*/

class AirlineReservation 
 {
   public static void main(String[] abs) throws IOException
    { 
     /* DoubleBuffer appwin = new DoubleBuffer();
      appwin.setSize(new Dimension (400, 400)); 
      appwin.setTitle("DoubleBuffer");
      appwin.setVisible(true);
      appwin.buffer = appwin.createImage (appwin.w, appwin.h); */
   //   launch(abs);
   //   BackgroundImage myBI= new BackgroundImage(new Image("Airline.jpg",1920,1080,false,true),BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
    //  myContainer.setBackground(new Background(myBI));

      Login L =new Login();
      
    } 
 }
