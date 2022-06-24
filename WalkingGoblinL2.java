import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class WalkingGoblinL2 extends JPanel {
	
	private JLabel lblNewLabel;
	
	private JLabel lblNewLabel_1;
	
	private int x = 0;
	
	private boolean happened = false;
	
	private boolean hasHappened = false;
	
	private int there;
	
	private int there1;
	
	private int current = -1;
	
	private Timer t;
	
	private Timer t1;
	
	private boolean b1;
	
	private ArrayList<JLabel> labels = new ArrayList<>();
	
	private ArrayList<Integer> yvals = new ArrayList<>();
	
	private ArrayList<Integer> xvals = new ArrayList<>();
	
	private int power;
	
	private boolean doEvery = true;
	
	
	public WalkingGoblinL2() {
		
		power = 10;
		
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		setLayout(null);
		setBounds(0, 0, 160, 300);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 93, 160, 16);
		add(lblNewLabel_1);
		Image img2 = new ImageIcon(this.getClass().getResource("platform1_213x16-removebg-preview.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img2));
		
		lblNewLabel = new JLabel("");
		add(lblNewLabel);
		lblNewLabel.setBounds(x, 0, 124, 124);
		lblNewLabel.setVisible(true); 
		Image img1 = new ImageIcon(this.getClass().getResource("temp_2_58x89.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img1));
		
		Image marionervL = new ImageIcon(this.getClass().getResource("tgeniestill1_1_58x89.png")).getImage();
		
		Image yipee1 = new ImageIcon(this.getClass().getResource("tgenierun1_1_58x89.png")).getImage();
		
		Image marionervR = new ImageIcon(this.getClass().getResource("tgeniestill2_58x89.png")).getImage();
		
		Image yipee2 = new ImageIcon(this.getClass().getResource("tgenierun2_58x89.png")).getImage();
		

		t1 = new Timer(20, new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
			 for (int i = 0; i < labels.size(); i ++) {
					labels.get(i).setBounds(xvals.get(i), yvals.get(i) + 2, 60, 60);
			    if (labels.get(i).getY() >= 234) {  
			    	
			    	hasHappened = true;
			    	
					labels.get(i).setEnabled(false);
					labels.get(i).setVisible(false);
					
					labels.remove(i);
					xvals.remove(i);
					yvals.remove(i);
					i--;					
					t1.stop();

					}
			    yvals.set(i, yvals.get(i) + 2);
		         }
				
			}
		});
		
		t = new Timer(100, new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (doEvery) {
				TimerTask task = new TimerTask() {
					public void run() {
						current++;
					}
				};
				
				if (x == (there + 30) || x == (there + 70)) {
					
					if (getDoable()) {
					
					JLabel newLabel = new JLabel();
					newLabel.setBounds(50, 108, 60, 60);
					Image img1 = new ImageIcon(this.getClass().getResource("hello.gif")).getImage();
					newLabel.setIcon(new ImageIcon(img1));
					newLabel.setOpaque(false);
					add(newLabel);
					labels.add(newLabel);
					yvals.add(108);
					xvals.add(x);
					t1.start();
					}
					
				}
				
				if (x == (there + 100)) {
					task.cancel();
					happened = true;
					x -= 2;
					lblNewLabel.setBounds(x, there1, 124, 124);
					
					}
			    if (happened == true) {
						x -= 2;
						lblNewLabel.setBounds(x, there1, 124, 124);
						if (x <= 0) {
							happened = false;
							current = -1;
							task.cancel();
						}
						task.run();
						
						if (current == 1) {
							lblNewLabel.setIcon(new ImageIcon(yipee1));
						}
						else if (current == 3) {
							lblNewLabel.setIcon(new ImageIcon(marionervL));
							current = -1;
						}
					}
				 if (happened == false) {
					x += 2;
					lblNewLabel.setBounds(x, there1, 124, 124);
					
					if (current == 1) {
						lblNewLabel.setIcon(new ImageIcon(yipee2));
					}
					else if (current == 3) {
						lblNewLabel.setIcon(new ImageIcon(marionervR));
						current = -1;
					}
					task.run();
				}
			}
		}
	});
		
		t.start();

	}
	
	public void setInvisible() {
		
		t.stop();
				
		lblNewLabel_1.setVisible(false);
				
	    lblNewLabel.setVisible(false);

		
	}
	public void setDoable(boolean b) {
		b1 = b;
	}
	public boolean getDoable() {
		return b1;
	}
	public void returnEstop() {
		t1.stop();
		t.stop();
		for (int i = 0 ; i < labels.size(); i ++) {
			labels.get(i).setVisible(false);
	}
	}
	public void returnEstart() {
		t1.start();
		t.start();
		for (int i = 0 ; i < labels.size(); i ++) {
			labels.get(i).setVisible(true);
	}
	}
	public void stopE() {
		t.stop();
		t1.stop();
		doEvery = false;
	}
	public boolean getHappened() {
		return hasHappened;
	}
	public void setHappened() {
		hasHappened = false;
	}
	public int getPower() {
		return power;
	}
}