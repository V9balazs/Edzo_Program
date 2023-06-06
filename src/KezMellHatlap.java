import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class KezMellHatlap extends JFrame implements ActionListener{

	JPanel panel = new JPanel();
	JButton vissza = new JButton("Vissza");
	JButton kovi = new JButton("Következő");
	JButton set = new JButton("Új set kezdése");
	JLabel felirat = new JLabel();
	JLabel kep;
	ImageIcon icon;
	JProgressBar progress = new JProgressBar();
	JFrame frame;
	int barvalue = 12;
	int kovdb = 1;
	
	Timer timer;
	int second, minute;
	String ddSecond, ddMinute;
	DecimalFormat dFormat = new DecimalFormat("00");
	JLabel countdown = new JLabel();
	
	KezMellHatlap(JFrame eredetiframe){
		frame = eredetiframe;
		
		panel.setSize(500, 600);
		panel.setLayout(null);
		panel.setBackground(new Color(211, 211, 211));
		
		visszagomb();
		kovigomb();
		edzes0();
		progressbar();
		
		panel.add(progress);
		panel.add(kovi);
		panel.add(vissza);
		frame.add(panel);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == vissza)
		{
			frame.remove(panel);
			frame.repaint();
			Valasztolap valasztopanel = new Valasztolap(frame);
		}
		
		if(e.getSource() == set) {
			frame.remove(panel);
			frame.repaint();
			KezMellHatlap kezmellhat = new KezMellHatlap(frame);
		}
		
		if(e.getSource() == kovi)
		{
			if(kovdb%2 == 0) {
				switch(kovdb){
				case 2:
					panel.remove(countdown);
					panel.repaint();
					edzes1();
					kovdb++;
					barvalue += 13;
					progress.setValue(barvalue);
					timer.stop();
					break;
				case 4:
					panel.remove(countdown);
					panel.repaint();
					edzes2();
					kovdb++;
					barvalue += 12;
					progress.setValue(barvalue);
					timer.stop();
					break;
				case 6:
					panel.remove(countdown);
					panel.repaint();
					edzes3();
					kovdb++;
					barvalue += 13;
					progress.setValue(barvalue);
					timer.stop();
					break;
				case 8:
					panel.remove(countdown);
					panel.repaint();
					edzes4();
					kovdb++;
					barvalue += 12;
					progress.setValue(barvalue);
					timer.stop();
					break;
				case 10:
					panel.remove(countdown);
					panel.repaint();
					edzes5();
					kovdb++;
					barvalue += 13;
					progress.setValue(barvalue);
					timer.stop();
					break;
				case 12:
					panel.remove(countdown);
					panel.repaint();
					edzes6();
					kovdb++;
					barvalue += 12;
					progress.setValue(barvalue);
					timer.stop();
					break;
				case 14:
					panel.remove(countdown);
					panel.remove(kovi);
					panel.repaint();
					edzes7();
					kovdb++;
					barvalue += 13;
					progress.setValue(barvalue);
					nextset();
					timer.stop();
					
					break;
				default:
					break;
				}
			}
			else {
				panel.remove(felirat);
				panel.remove(kep);
				panel.repaint();
				countdown.setText("01:00");
				second = 0;
				minute = 1;
				pihi();
				timer.start();
				kovdb++;
			}
		}
	}
	
	public void visszagomb(){
		vissza.setBounds(10, 10, 100, 30);
		vissza.setFocusable(false);
		vissza.addActionListener(this);
		vissza.setForeground(new Color(211, 211, 211));
		vissza.setBackground(new Color(61, 61, 61));
		vissza.setFont(new Font("Comic Sans", Font.BOLD, 20));
	}
	
	public void kovigomb(){
		kovi.setBounds(323, 520, 150, 30);
		kovi.setFocusable(false);
		kovi.addActionListener(this);
		kovi.setForeground(new Color(211, 211, 211));
		kovi.setBackground(new Color(61, 61, 61));
		kovi.setFont(new Font("Comic Sans", Font.BOLD, 20));
	}
	
	public void nextset(){
		set.setBounds(282, 520, 190, 30);
		set.setFocusable(false);
		set.addActionListener(this);
		set.setForeground(new Color(211, 211, 211));
		set.setBackground(new Color(61, 61, 61));
		set.setFont(new Font("Comic Sans", Font.BOLD, 20));

		panel.add(set);
	}
	
	public void progressbar(){
		progress.setValue(barvalue);
		progress.setBounds(10, 480, 463, 30);
		progress.setStringPainted(true);
		progress.setForeground(new Color(63, 181, 0));
	}
	
	public void pihi(){
		countdown.setFont(new Font("Comic Sans", Font.BOLD, 35));
		countdown.setBounds(200, 200, 150, 50);
		panel.add(countdown);
		
		timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				second--;
				ddSecond = dFormat.format(second);
				ddMinute = dFormat.format(minute);
				countdown.setText(ddMinute + ":" + ddSecond);
			
				if(second == -1){
					second = 59;
					minute--;
					ddSecond = dFormat.format(second);
					ddMinute = dFormat.format(minute);
					countdown.setText(ddMinute + ":" + ddSecond);
				}
				if(minute == 0 && second == 0){
					timer.stop();
				}
			}
		});
	}
	
	public void edzes0(){
		felirat.setText("Push up:   12");
		felirat.setFont(new Font("Comic Sans", Font.BOLD, 20));
		felirat.setBounds(175, 70, 200, 30);
		
		icon = new ImageIcon(getClass().getResource("Images/Standard_push_up.png"));
		kep = new JLabel(icon);
		kep.setBounds(100, 130, 300, 350);
		
		panel.add(kep);
		panel.add(felirat);
	}
	
	public void edzes1(){
		felirat.setText("Diamond push up:   12");
		felirat.setFont(new Font("Comic Sans", Font.BOLD, 20));
		felirat.setBounds(130, 70, 250, 30);
		
		icon = new ImageIcon(getClass().getResource("Images/Diamond_push_up.png"));
		kep = new JLabel(icon);
		kep.setBounds(100, 130, 300, 350);
		
		panel.add(kep);
		panel.add(felirat);
	}
	
	public void edzes2(){
		felirat.setText("Incline push up:   12");
		felirat.setFont(new Font("Comic Sans", Font.BOLD, 20));
		felirat.setBounds(140, 70, 250, 30);
		
		icon = new ImageIcon(getClass().getResource("Images/Incline_push_up.png"));
		kep = new JLabel(icon);
		kep.setBounds(100, 130, 300, 350);
		
		panel.add(kep);
		panel.add(felirat);
	}
	
	public void edzes3(){
		felirat.setText("Decline push up:   12");
		felirat.setFont(new Font("Comic Sans", Font.BOLD, 20));
		felirat.setBounds(135, 70, 250, 30);
		
		icon = new ImageIcon(getClass().getResource("Images/Decline_push_up.png"));
		kep = new JLabel(icon);
		kep.setBounds(100, 130, 300, 350);
		
		panel.add(kep);
		panel.add(felirat);
	}
	
	public void edzes4(){
		felirat.setText("Bench dips:   12");
		felirat.setFont(new Font("Comic Sans", Font.BOLD, 20));
		felirat.setBounds(160, 70, 250, 30);
		
		icon = new ImageIcon(getClass().getResource("Images/Bench_dips.png"));
		kep = new JLabel(icon);
		kep.setBounds(100, 130, 300, 350);
		
		panel.add(kep);
		panel.add(felirat);
	}
	
	public void edzes5(){
		felirat.setText("Dumbbell curls:   12");
		felirat.setFont(new Font("Comic Sans", Font.BOLD, 20));
		felirat.setBounds(145, 70, 250, 30);
		
		icon = new ImageIcon(getClass().getResource("Images/Dumbbell_curls.png"));
		kep = new JLabel(icon);
		kep.setBounds(100, 130, 300, 350);
		
		panel.add(kep);
		panel.add(felirat);
	}
	
	public void edzes6(){
		felirat.setText("Dumbbell wrist curls:   12");
		felirat.setFont(new Font("Comic Sans", Font.BOLD, 20));
		felirat.setBounds(120, 70, 250, 30);
		
		icon = new ImageIcon(getClass().getResource("Images/Dumbbell_wrist_curls.png"));
		kep = new JLabel(icon);
		kep.setBounds(100, 130, 300, 350);
		
		panel.add(kep);
		panel.add(felirat);
	}
	
	public void edzes7(){
		felirat.setText("Dumbbell reverse wrist curls:   12");
		felirat.setFont(new Font("Comic Sans", Font.BOLD, 20));
		felirat.setBounds(90, 70, 350, 30);
		
		icon = new ImageIcon(getClass().getResource("Images/Dumbbell_reverse_wrist_curls.png"));
		kep = new JLabel(icon);
		kep.setBounds(100, 130, 300, 350);
		
		panel.add(kep);
		panel.add(felirat);
	}
}
