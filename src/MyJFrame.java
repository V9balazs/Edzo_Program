import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class MyJFrame extends JFrame{

	JFrame frame = new JFrame();
	
	MyJFrame(){
		frame.setTitle("Edzo Program");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(500, 600);
		
		ImageIcon icon = new ImageIcon(this.getClass().getResource("Images/MainIcon.png"));
		frame.setIconImage(icon.getImage());
		frame.getContentPane().setBackground(new Color(211, 211, 211));
		
		frame.setVisible(true);
		
		Valasztolap valastopanel = new Valasztolap(frame);
	}
}
