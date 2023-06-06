import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Valasztolap extends JFrame implements ActionListener{

	JPanel valaszto = new JPanel();
	JButton KezMellHat = new JButton("Felső test edzés");
	JButton LabAbs = new JButton("Alsó test edzés");
	JLabel szoveg = new JLabel();
	JFrame frame;
	
	Valasztolap(JFrame eredeitframe){
		frame = eredeitframe;
		
		valaszto.setSize(500, 600);
		valaszto.setLayout(null);
		valaszto.setBackground(new Color(211, 211, 211));
		
		szoveg.setText("Válaszd ki a kívánt edzés tervet");
		szoveg.setFont(new Font("Comic Sans", Font.BOLD, 20));
		szoveg.setBounds(100, 60, 300, 30);
		
		KezMellHat.setBounds(100, 150, 300, 150);
		KezMellHat.setFocusable(false);
		KezMellHat.addActionListener(this);
		KezMellHat.setForeground(new Color(211, 211, 211));
		KezMellHat.setBackground(new Color(61, 61, 61));
		KezMellHat.setFont(new Font("Comic Sans", Font.BOLD, 25));		
		
		LabAbs.setBounds(100, 350, 300, 150);
		LabAbs.setFocusable(false);
		LabAbs.addActionListener(this);
		LabAbs.setForeground(new Color(211, 211, 211));
		LabAbs.setBackground(new Color(61, 61, 61));
		LabAbs.setFont(new Font("Comic Sans", Font.BOLD, 25));
		
		valaszto.add(szoveg);
		valaszto.add(KezMellHat);
		valaszto.add(LabAbs);
		frame.add(valaszto);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == KezMellHat)
		{
			frame.remove(valaszto);
			frame.repaint();
			KezMellHatlap kezmellhatlap = new KezMellHatlap(frame);
		}
		if(e.getSource() == LabAbs)
		{
			frame.remove(valaszto);
			frame.repaint();
			LabAbslap kezmellhatlap = new LabAbslap(frame);	
		}
	}	
}
