
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class Chemin extends JFrame {
	JFrame carrfour=new JFrame();
	private JButton voitureA1= new JButton();
	private JButton voitureA2= new JButton();
	private JButton voitureB1= new JButton();
	private JButton voitureB2= new JButton();
	private  JButton feu_A1= new JButton();
	private  JButton feu_A2= new JButton();
	private JButton feu_B1= new JButton();
	private JButton feu_B2= new JButton();
	public Chemin() {
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    BufferedImage img = ImageIO.read(new File("C:\\Users\\pedro\\Desktop\\S3\\workspa\\Carrfour\\images\\chemin.png"));
                    carrfour.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                    
                    carrfour.setContentPane(new JLabel(new ImageIcon(img)));
                    carrfour.pack();
                    carrfour.setLocationRelativeTo(null);
                    carrfour.setVisible(true);
                    carrfour.setSize(800, 650);
                    carrfour.setTitle("Carrfour");
                    carrfour.setResizable(true);
                    carrfour.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    BufferedImage red_car = ImageIO.read(new File("C:\\Users\\pedro\\Desktop\\S3\\workspa\\Carrfour\\images\\red.png"));
                    BufferedImage pink_car = ImageIO.read(new File("C:\\Users\\pedro\\Desktop\\S3\\workspa\\Carrfour\\images\\pink.png"));
                    BufferedImage green_car = ImageIO.read(new File("C:\\Users\\pedro\\Desktop\\S3\\workspa\\Carrfour\\images\\green.png"));
                    BufferedImage turqoise_car = ImageIO.read(new File("C:\\Users\\pedro\\Desktop\\S3\\workspa\\Carrfour\\images\\turqoise.png"));
                    BufferedImage but = ImageIO.read(new File("C:\\Users\\pedro\\Desktop\\S5\\button.png"));
                    feu_A1.setIcon(new ImageIcon(but));
                    feu_A2.setIcon(new ImageIcon(but));
                    feu_B1.setIcon(new ImageIcon(but));
                    feu_B2.setIcon(new ImageIcon(but));
                    feu_A1.setBounds(200, 439, 40, 40);
              
                    feu_B1.setBounds(200, 142, 40, 40);
                    feu_A2.setBounds(553, 142, 40, 40);
                    feu_B2.setBounds(554, 439, 40, 40);
                    feu_A2.setBorder(new LineBorder(Color.BLACK));
                    feu_B2.setBorder(new LineBorder(Color.BLACK));
                    feu_B1.setBorder(new LineBorder(Color.BLACK));
                    feu_A1.setBorder(new LineBorder(Color.BLACK));
                    feu_A1.setBackground(Color.GREEN);
                    feu_A2.setBackground(Color.GREEN);
                    feu_B1.setBackground(Color.RED);
                    feu_B2.setBackground(Color.RED);
                    voitureA1.setBorder(new LineBorder(Color.WHITE));
                    voitureA2.setBorder(new LineBorder(Color.WHITE));
                    voitureB1.setBorder(new LineBorder(Color.WHITE));
                    voitureB2.setBorder(new LineBorder(Color.WHITE));
                    voitureA1.setIcon(new ImageIcon(red_car));
                    voitureA2.setIcon(new ImageIcon(turqoise_car));
                    voitureB1.setIcon(new ImageIcon(pink_car));
                    voitureB2.setIcon(new ImageIcon(green_car));
                    voitureA1.setBounds(-58, 358, 60, 28);
                    voitureA2.setBounds(785, 240, 60, 28);
                    voitureB1.setBounds(322, -50, 28, 60);
                    voitureB2.setBounds(455, 610, 28, 60);
            		carrfour.setResizable(false);
            		carrfour.add(feu_A1);
            		carrfour.add(feu_B1);
            		carrfour.add(feu_A2);
            		carrfour.add(feu_B2);
            		//jTextAgent.setPreferredSize(new Dimension (70, 50));
            		carrfour.add(voitureA1);
            		carrfour.add(voitureB1);
            		carrfour.add(voitureB2);
            		carrfour.add(voitureA2);
            		carrfour.setVisible(true);
                } catch (IOException exp) {
                    exp.printStackTrace();
                }
            }
        });
	}
	//la premiere voiture A1
	public void move_carA1(){
		this.voitureA1.setLocation(this.voitureA1.getX()+7, this.voitureA1.getY());
		if(this.voitureA1.getX() >= 800){
			this.voitureA1.setLocation(-58,358);
		}
	}
public int location_voitureA1(){
		return this.voitureA1.getX();
	}
public void stop_carA1(){
		this.voitureA1.setLocation(200, 358);
	}
public void light_feuA1_green() throws IOException{
		
		this.feu_A1.setBackground(Color.GREEN);
		
		}
public void light_feuA1_red() throws IOException{
		
		this.feu_A1.setBackground(Color.RED);
		}
public void light_feuA1_black() throws IOException{
		
		this.feu_A1.setBackground(Color.BLACK);
		}
public void light_feuA1_orange() throws IOException{
	
	feu_A1.setBackground(Color.ORANGE);
	}	
    
    //la deuxiem voiture A2
    public void move_carA2(){
		this.voitureA2.setLocation(this.voitureA2.getX()-8, this.voitureA2.getY());
		if(this.voitureA2.getX() <=-10){
			this.voitureA2.setLocation(785,240);
		}
	}
 public void stop_carA2(){
		this.voitureA2.setLocation(553, 240);
	}   
    
public int location_voitureA2(){
		return this.voitureA2.getX();
	}
public void light_feuA2_green() throws IOException{
		
		this.feu_A2.setBackground(Color.GREEN);
		}
public void light_feuA2_red() throws IOException{
		
		this.feu_A2.setBackground(Color.RED);
		}
public void light_feuA2_black() throws IOException{
		
		this.feu_A2.setBackground(Color.BLACK);
		}
public void light_feuA2_orange() throws IOException{
	
	this.feu_A2.setBackground(Color.ORANGE);
	}	
    
    //la troisiem voiture B1
 public void move_carB1(){
		this.voitureB1.setLocation(this.voitureB1.getX(), this.voitureB1.getY()+7);
		if(this.voitureB1.getY() >=650){
			this.voitureB1.setLocation(322,-50);
		}
	}
public void stop_carB1(){
		this.voitureB1.setLocation(322, 142);
	}
    
public int location_voitureB1(){
		return this.voitureB1.getY();
	}
public void light_feuB1_green() throws IOException{
		
		this.feu_B1.setBackground(Color.GREEN);
		}
public void light_feuB1_red() throws IOException{
		
		this.feu_B1.setBackground(Color.RED);
		}
public void light_feuB1_black() throws IOException{
		
		this.feu_B1.setBackground(Color.BLACK);
		}
public void light_feuB1_orange() throws IOException{
	
	this.feu_B1.setBackground(Color.ORANGE);
	}	
    //la quatriem voiture B2
public void move_carB2(){
		this.voitureB2.setLocation(this.voitureB2.getX(), this.voitureB2.getY()-7);
		if(this.voitureB2.getY() <=0){
			this.voitureB2.setLocation(455,610);
		}
	}
public void stop_carB2(){
		this.voitureB2.setLocation(455, 440);
	}
public int location_voitureB2(){
		return this.voitureB2.getY();
	}
public void light_feuB2_green() throws IOException{
		
		this.feu_B2.setBackground(Color.GREEN);
		}
public void light_feuB2_red() throws IOException{
		
		this.feu_B2.setBackground(Color.RED);
		}
public void light_feuB2_black() throws IOException{
		
		this.feu_B2.setBackground(Color.BLACK);
		}
public  void light_feuB2_orange() throws IOException{
	
	this.feu_B2.setBackground(Color.ORANGE);
	}	
	public static void main(String[] args) {
		new Chemin();
	}
}