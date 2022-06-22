package GPACK;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class StartMenu extends JFrame{
	
	//Menu UI
	private JPanel menuPanel;
	private ImageIcon background;
	private JLabel mImage;
	private JLabel menuL;
	//
	
	//Button Options UI
	private JButton miniGamesB;
	private JButton levelsB;
	private JButton itemShopB;
	//
	
	//Select Game UI
	private boolean MGbuttonVisible;
	private boolean LVLbuttonVisible;
	private Timer MGbuttonTimer;
	private Timer LVLbuttonTimer;
	private JButton back1;
	private JButton back2;
	private JButton MG1;
	private JButton MG2;
	
	private JButton level1;
	private JButton level2;
	private JButton level3;
	
	private ImageIcon black;
	private JLabel blackL;
	//
	
	

	
	
	//Name Game Screen
			//Lists
			private ArrayList<Integer> answered;
			private ArrayList<String> allEyes;
			private ArrayList<String> allHair;
			private ArrayList <String> allNames;
			private ArrayList<String> allHeight;
			private ArrayList<String> allGlasses;
			//
			
			//Bakcground Image
			private ImageIcon background1;
			private JLabel rImage1;
			//
			
			//Timer
			DecimalFormat dFormat = new DecimalFormat("00");
			private Timer timer; 
			private Timer blinkTimer;
			private Timer correctTimer;
			private JLabel timerL; 
			private int second;
			private int secondC;
			private int minute;
			private String ddSecond;
			private String ddMinute;
			private boolean isVisible;
			private JButton timerBack;
			//
			
			//Quiz Game
			private JPanel nameGameP;
			private JButton startB2;
			private JButton doneB;
			private JButton skipB;
			private JLabel doneL;
			private JTextField answer;
			private JLabel glasses;
			private JLabel hairCol;
			private JLabel eyeCol;
			private JLabel height;
			private JLabel pointCounter;
			private JLabel correctL;
			private JLabel correctLName;
			private int randPerson;
			private int points;
			//
	//		
			
			
			
			//Music and SFX

				//Game Music
				private File file;
				private AudioInputStream audiostream;
				private Clip clip;
				//
				
				//Timer ALarm Music
				private File file1;
				private AudioInputStream audiostream1;
				private Clip clip1;
				//
				
				//WRONG-SOUND SFX
				private File file2;
				private AudioInputStream audiostream2;
				private Clip clip2;
				//
				
				//RIGHT-SOUND SFX
				private File file3;
				private AudioInputStream audiostream3;
				private Clip clip3;
				//
				
				//Menu Music
				private File file4;
				private AudioInputStream audiostream4;
				private Clip clip4;
				//
			
		
	//Genie Catcher Screen
			private JPanel gCatcherP;
			private JLabel genie;
			private JButton beginB;
			private ImageIcon backgroundgC;
			private ImageIcon genieImage;
			private JLabel screenImage;
			private JButton gCDone;
			private JLabel gCInstr;
			
			private Timer gCTimer;
			private Timer imageTimer;
			private Timer gCBlinkTimer;
			private boolean compVisible;
			private JLabel gCTimerLabel;//
			private JButton gCTimerBack;//
			private JLabel gCPointsLabel;
			private int gCPoints;
			private boolean imageVisible;
			
			private int gCsecond;
			private int gCminute;
			
			
			

	
	public StartMenu(int score) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		initialize();
		playMenuMusic();
		
	}
	
	public void initialize() {
		
		
		//FRAME SETUP
		
			//NECESSARY FRAME STUFF
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // || When the red button is clicked, window closes ||
			setLocationRelativeTo(null); // || Sets the window to appear on center of the screen ||
			setLayout(new BorderLayout()); // || Sets Layout to BorderLayout ||
			pack(); // || I don't know what this does ||
			//
			
			//MY FRAME STUFF
			setResizable(true); // || User can't resize the frame ||
			setTitle("Start Menu");  // || Sets the title of FRAME ||
			 setSize(1000, 900); // || Size Preference ||
			//
		
			// menuPanel SETUP
			menuPanel = new JPanel();
			menuPanel.setLayout(null);
			add(menuPanel);
			//
		
		//
		
		//MENU Label
		menuL = new JLabel("G-F MENU");
		menuL.setLayout(null);
		menuL.setBounds(200, 0, 900, 120);
		menuL.setFont(new Font("Serif", Font.BOLD, 120));
		menuL.setForeground(Color.GREEN);
	    menuPanel.add(menuL);
		//
	    
	    
		
	    //Menu Mini Giames Button
	    miniGamesB = new JButton("MINI-GAMES");
		miniGamesB.setForeground(Color.ORANGE);
		miniGamesB.setBackground(Color.RED);
		miniGamesB.setBounds(300, 150, 370, 150);
		miniGamesB.setFont(new Font("Serif", Font.BOLD, 50));
		menuPanel.add(miniGamesB);
		//
		
		
		//MiniGames button is pressed
		miniGamesB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MGbuttonVisible = true;
				blackL.setBounds(300,150,370,370);
				miniGamesB.setVisible(false);
				levelsB.setVisible(false);
				itemShopB.setVisible(false);
				blackL.setVisible(true);
				back1.setVisible(true);
				MG1.setVisible(true);
				MG2.setVisible(true);
				MGbuttonTimer.start();
			}
			
			
			
		});
		//
		
		
		//Menu Levels Button
		levelsB = new JButton("LEVELS");
		levelsB.setForeground(Color.RED);
		levelsB.setBackground(Color.RED);
		levelsB.setBounds(300, 350, 370, 150);
		levelsB.setFont(new Font("Serif", Font.BOLD, 60));
		menuPanel.add(levelsB );
		//
		
		
		//Menu Levels Button is pressed
		levelsB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LVLbuttonVisible = true;
				blackL.setBounds(300,350,370,450);
				miniGamesB.setVisible(false);
				levelsB.setVisible(false);
				itemShopB.setVisible(false);
				blackL.setVisible(true);
				back2.setVisible(true);
				level1.setVisible(true);
				level2.setVisible(true);
				level3.setVisible(true);
				LVLbuttonTimer.start();
			}
			
			
		});
		//
		
		
		//Menu Item Shop Button
		itemShopB = new JButton("ITEM SHOP");
		itemShopB.setForeground(Color.GREEN);
		itemShopB.setBackground(Color.RED);
		itemShopB.setBounds(300, 550, 370, 150);
		itemShopB.setFont(new Font("Serif", Font.BOLD, 60));
		menuPanel.add(itemShopB);
		//
		
		//Back button 1
		back1 = new JButton("BACK");
		back1.setForeground(Color.GREEN);
		back1.setBounds(310, 160, 100, 50);
		back1.setFont(new Font("Serif", Font.BOLD, 20));
		back1.setVisible(false);
		menuPanel.add(back1);
		//
		
		
		//Back button 1 pressed
		back1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MGbuttonVisible = false;
				MGbuttonTimer.stop();
				MG1.setVisible(false);
				MG2.setVisible(false);
				blackL.setVisible(false);
				back1.setVisible(false);
				miniGamesB.setVisible(true);
				levelsB.setVisible(true);
				itemShopB.setVisible(true);
				
				
			}
			
		});
		//
		
		
		//Back button 2 
		back2 = new JButton("BACK");
		back2.setForeground(Color.GREEN);
		back2.setBounds(310, 360, 100, 50);
		back2.setFont(new Font("Serif", Font.BOLD, 20));
		back2.setVisible(false);
		menuPanel.add(back2);
		//
		
		
		//Back button 2 pressed
		back2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LVLbuttonVisible = false;
				LVLbuttonTimer.stop();
				level1.setVisible(false);
				level2.setVisible(false);
				level3.setVisible(false);
				blackL.setVisible(false);
				back2.setVisible(false);
				miniGamesB.setVisible(true);
				levelsB.setVisible(true);
				itemShopB.setVisible(true);
				
				
			}
			
		});
		//
		
		//MiniGmae 1 Button
		MG1 = new JButton("Name - Game");
		MG1.setForeground(Color.RED);
		MG1.setBounds(330, 230, 300, 100);
		MG1.setFont(new Font("Serif", Font.BOLD, 30));
		MG1.setVisible(false);
		menuPanel.add(MG1);
		//
		
		
		//MiniGame 2 Button
		MG2 = new JButton("Genie - Catcher");
		MG2.setForeground(Color.RED);
		MG2.setBounds(330, 380, 300, 100);
		MG2.setFont(new Font("Serif", Font.BOLD, 30));
		MG2.setVisible(false);
		menuPanel.add(MG2);
		//
		
		
		//Level 1 Button
		level1 = new JButton("Level 1 - EASY");
		level1.setForeground(Color.GREEN);
		level1.setBounds(330, 420, 300, 100);
		level1.setFont(new Font("Serif", Font.BOLD, 40));
		level1.setVisible(false);
		menuPanel.add(level1);
		//
		
		
		//Level 2 Button
		level2 = new JButton("Level 1 - Medium");
		level2.setForeground(Color.RED);
		level2.setBounds(330, 530, 300, 100);
		level2.setFont(new Font("Serif", Font.BOLD, 35));
		level2.setVisible(false);
		menuPanel.add(level2);
		//
		
		
		//Level 3 Button
		level3 = new JButton("Bossfight - GOD");
		level3.setForeground(Color.MAGENTA);
		level3.setBounds(330, 640, 300, 100);
		level3.setFont(new Font("Serif", Font.BOLD, 40));
		level3.setVisible(false);
		menuPanel.add(level3);
		//
		
		
		
		//MiniGame BlINK TIMER SET UP
	    MGbuttonTimer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if (MGbuttonVisible) {
					MG1.setVisible(false);
					MG2.setVisible(false);
					MGbuttonVisible = false;
				} else {
					MG1.setVisible(true);
					MG2.setVisible(true);
					MGbuttonVisible = true;
				}
				
			}
	    	
	    	
	    }); 
	    //
	    
	    //Level BlINK TIMER SET UP
	    LVLbuttonTimer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if (LVLbuttonVisible) {
					level1.setVisible(false);
					level2.setVisible(false);
					level3.setVisible(false);
					LVLbuttonVisible = false;
				} else {
					level1.setVisible(true);
					level2.setVisible(true);
					level3.setVisible(true);
					LVLbuttonVisible = true;
				}
				
			}
	    	
	    	
	    }); 
	    //
	    
	    
	    //Black Image Setup
		black = new ImageIcon("black.jpeg");
		Image img2=black.getImage();
		Image temp2=img2.getScaledInstance(370,450,Image.SCALE_SMOOTH);
		black = new ImageIcon(temp2);
		blackL = new JLabel(black);
		blackL.setLayout(null);
		blackL.setVisible(false);
		blackL.setBounds(300,350,370,450);
		menuPanel.add(blackL);
		//
	    
		//Menu Background
	    background=new ImageIcon("SpaceMenu.jpg");
		Image img=background.getImage();
		Image temp=img.getScaledInstance(1000,900,Image.SCALE_SMOOTH);
		background= new ImageIcon(temp);
		mImage = new JLabel(background);
		mImage.setLayout(null);
		mImage.setBounds(0,0,1000,900);
		menuPanel.add(mImage);
		//
		
		
		//Mini Game 1 BUTTON Pressed
		MG1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				clip4.stop();
				
				try {
					playGameMusic();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				MGbuttonVisible = false;
				MGbuttonTimer.stop();
				getContentPane().removeAll(); // || Removes all components ||
				repaint();
				
				//SETS UP TEXT FILES INTO ARRAY LISTS
				setFiles();
				//
				
				
				// PANEL 2 SETUP
				nameGameP = new JPanel();
				nameGameP.setLayout(null);
				nameGameP.setBackground(Color.BLACK);
				add(nameGameP);
				//
				
			    //GAME TIMER Setup
			    timer = new Timer(1000, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						second--;
						
						if (second == -1) {
							
							if (minute == 0) {
								second = 0;
								minute = 0;
								
								ddSecond = dFormat.format(second); 
								ddMinute = dFormat.format(minute);
								
								timerL.setText(ddMinute + ":" + ddSecond);
								
								timer.stop();
								clip.stop();
								timerL.setVisible(false);
								pointCounter.setVisible(false);
								isVisible = false;
								doneScreen();
								blinkTimer.start();
								
								
								

							} else {
								second = 59;
								minute--;
								
								ddSecond = dFormat.format(second); 
								ddMinute = dFormat.format(minute);
								
								timerL.setText(ddMinute + ":" + ddSecond);
							}
							
						} else {
							ddSecond = dFormat.format(second); 
							ddMinute = dFormat.format(minute);
							
							timerL.setText(ddMinute + ":" + ddSecond);
						}
					}
			    	
			    	
			    });
			    //
			    
			    //BlINK TIMER SET UP
			    blinkTimer = new Timer(500, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							loopAlarmMusic();
						} catch (UnsupportedAudioFileException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (LineUnavailableException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						if (isVisible) {
							timerL.setVisible(false);
							pointCounter.setVisible(false);
							doneL.setVisible(false);
							isVisible = false;
						} else {
							timerL.setVisible(true);
							pointCounter.setVisible(true);
							doneL.setVisible(true);
							isVisible = true;
						}
						
					}
			    	
			    	
			    }); 
			    //
			    
			    //Timer Label
			    timerL = new JLabel("00:10");
			    timerL.setLayout(null);
			    timerL.setBounds(775, 15, 500, 60);
			    timerL.setFont(new Font("Arial", Font.BOLD, 60));
			    timerL.setForeground(Color.GREEN);
			    timerL.setVisible(false);
			    nameGameP.add(timerL);
			    //
			    
			    
			    //Timer BackGround
			    timerBack = new JButton();
				timerBack.setBounds(700, 0, 300, 90);
				nameGameP.add(timerBack);
				timerBack.setVisible(false);
				//
			    
			     // ANSWER TEXTFIELD
			    answer = new JTextField();
			    answer.setBounds(450, 390, 400, 90);
			    answer.setFont(new Font("Sabo", Font.BOLD, 40));
			    answer.setForeground(Color.GREEN);
			    answer.setBackground(Color.RED);
			    answer.setVisible(false);
			    answer.setEnabled(false);
			    nameGameP.add(answer);
			    //
			    
			    
			  //Question is answered in ANSWER TEXTFIELD
			    answer.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String userAnswer = answer.getText();
						if (userAnswer.equals(allNames.get(randPerson))) {
							try {
								playRightSFX();
							} catch (UnsupportedAudioFileException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (LineUnavailableException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							points++;
							pointCounter.setText("Points: " + points);
						} else {
							try {
								playWrongSFX();
							} catch (UnsupportedAudioFileException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (LineUnavailableException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							showCorrectAnswer();
							correctTimer.start();
						}
						answer.setText("");
						setQuestion();
						
					}
			    	
			    	
			    });
			    //
			    
			    
			  //SETUP for ALL Hints
			    
			    //Glasses Hint Label
			    glasses = new JLabel("1");
				glasses.setLayout(null);
				glasses.setBounds(10, 160, 400, 400);
				glasses.setFont(new Font("Arial", Font.BOLD, 24));
				glasses.setForeground(Color.GREEN);
				glasses.setVisible(false);
				nameGameP.add(glasses);
				//
				
				
				//Hair Color Hint Label
				hairCol = new JLabel("2");
				hairCol.setLayout(null);
				hairCol.setBounds(180, 160, 400, 400);
				hairCol.setFont(new Font("Arial", Font.BOLD, 24));
				hairCol.setForeground(Color.GREEN);
				hairCol.setVisible(false);
				nameGameP.add(hairCol);
				//
				
				//Eye Color Hint Label
				eyeCol = new JLabel("3");
				eyeCol.setLayout(null);
				eyeCol.setBounds(180, 300, 400, 400);
				eyeCol.setFont(new Font("Arial", Font.BOLD, 24));
				eyeCol.setForeground(Color.GREEN);
				eyeCol.setVisible(false);
				nameGameP.add(eyeCol);
				//
				
				//Height Hint Label
				height = new JLabel("4");
				height.setLayout(null);
				height.setBounds(10, 300, 400, 400);
				height.setFont(new Font("Arial", Font.BOLD, 24));
				height.setForeground(Color.GREEN);
				height.setVisible(false);
				nameGameP.add(height);
				//

			  //
				
				
				//POINT COUNTER SET UP
				pointCounter = new JLabel("Points: ");
				pointCounter.setLayout(null);
				pointCounter.setBounds(550, 300, 400, 400);
				pointCounter.setFont(new Font("Arial", Font.BOLD, 30));
				pointCounter.setForeground(Color.GREEN);
				pointCounter.setVisible(false);
				nameGameP.add(pointCounter);
				//
				
				//SKIP BUTTON SETUP
				skipB = new JButton("SKIP");
				skipB.setForeground(Color.GREEN);
				skipB.setBackground(Color.WHITE);
				skipB.setBounds(520, 550, 300, 90);
				skipB.setFont(new Font("Arial", Font.BOLD, 60));
				skipB.setVisible(false);
			    nameGameP.add(skipB);
				//
			    
			    //Question SKIPPED
			    skipB.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							playWrongSFX();
						} catch (UnsupportedAudioFileException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (LineUnavailableException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						showCorrectAnswer();
						correctTimer.start();
						setQuestion();
						
					}
			    	
			    	
			    });
			    //
			    
			    //CORRECT ANSWER LABEL
			    correctL = new JLabel("Correct Answer WAS: ");
			    correctL.setLayout(null);
			    correctL.setBounds(10, 350, 400, 400);
			    correctL.setFont(new Font("Arial", Font.BOLD, 30));
			    correctL.setForeground(Color.GREEN);
			    correctL.setVisible(false);
				nameGameP.add(correctL);
				//
				
				// Correct Name Label
				correctLName = new JLabel();
				correctLName.setLayout(null);
				correctLName.setBounds(10, 400, 400, 400);
				correctLName.setFont(new Font("Arial", Font.BOLD, 30));
			    correctLName.setForeground(Color.GREEN);
			    correctLName.setVisible(false);
				nameGameP.add(correctLName);
			    
			    // START BUTTON 2 SETUP
			    startB2 = new JButton("BEGIN");
			    startB2.setForeground(Color.GREEN);
			    startB2.setBackground(Color.WHITE);
			    startB2.setBounds(460, 370, 430, 200);
			    startB2.setFont(new Font("Arial", Font.BOLD, 120));
			    nameGameP.add(startB2);
			    //
			    
			    
			    //GAME START
			    startB2.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						points = 0;
						pointCounter.setText("Points: " + points);
						answered = new ArrayList<>();
						skipB.setVisible(true);
						timerL.setVisible(true);
						timerBack.setVisible(true);
						startB2.setVisible(false);
						startB2.setEnabled(false);
						glasses.setVisible(true);
						hairCol.setVisible(true);
						eyeCol.setVisible(true);
						height.setVisible(true);
						answer.setVisible(true);
						answer.setEnabled(true);
						pointCounter.setVisible(true);
						
						
						setQuestion();
						second = 30;
						minute = 0;
						timer.start();
						
						setVisible(true);
						
					}
			    	
			    	
			    });
			    //
			    
			    
			    //DONE LABEL
			    doneL = new JLabel();
			    doneL = new JLabel("DONE");
			    doneL.setLayout(null);
			    doneL.setBounds(95, 680, 300, 90);
			    doneL.setFont(new Font("Arial", Font.BOLD, 60));
			    doneL.setForeground(Color.RED);
			    doneL.setVisible(false);
				nameGameP.add(doneL);
				//
				
				// DONE BUTTON
				doneB = new JButton();
				doneB.setForeground(Color.RED);
				doneB.setBackground(Color.WHITE);
				doneB.setBounds(30, 680, 300, 90);
			    nameGameP.add(doneB);
			    doneB.setVisible(false);
			    doneB.setEnabled(false);
			    //
			    
			    
			    //DONE PRESSED
			    doneB.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						blinkTimer.stop();
						
						clip.stop();
						dispose();
						try {
							StartMenu kop = new StartMenu(0);
						} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
			    	
			    	
			    });
			    //

			    
			  //IMAGE 2 SETUP
				background1=new ImageIcon("MG1.jpg");
				Image img1=background1.getImage();
				Image temp1=img1.getScaledInstance(1000,900,Image.SCALE_SMOOTH);
				background1= new ImageIcon(temp1);
				JLabel rImage1 = new JLabel(background1);
				rImage1.setLayout(null);
				rImage1.setBounds(0,0,1000,900);
				nameGameP.add(rImage1);
				//
				
				
				
			// NECESSARY _ DO NOT REMOVE
				
				 // Sets Frame and all components to be visible
				 setVisible(true);	
				 //
				 
			//
			
	    	
	    	
				
				
			}
			
		});
		
		//Mini Game 2 BUTTON Pressed
		MG2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				clip4.stop(); // stops the Menu Music
				
				// Plays Game Music
				try {
					playGameMusic();
				} catch (UnsupportedAudioFileException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (LineUnavailableException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				//
				
				
				//Frame stuff
				MGbuttonVisible = false;
				MGbuttonTimer.stop();
				getContentPane().removeAll(); // || Removes all components ||
				repaint();
				//
				
				//New Minigame Panel
				gCatcherP = new JPanel();
				gCatcherP.setLayout(null);
				gCatcherP.setBackground(Color.BLACK);
				add(gCatcherP);
				//
				
				
				//Genie Image Setup
				genieImage=new ImageIcon("Genie_80x80.jpg");
				Image img1=genieImage.getImage();
				Image temp1=img1.getScaledInstance(120,120,Image.SCALE_SMOOTH);
				genieImage= new ImageIcon(temp1);
				genie = new JLabel(genieImage);
				genie.setLayout(null);
				genie.setBounds(0,0,120,80);
				genie.setVisible(false);
				gCatcherP.add(genie);
				//
				
				//Genie Image Clicked
				genie.addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							playRightSFX();
						} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						genie.setVisible(false);
						gCPoints++;
						gCPointsLabel.setText("" + gCPoints);
						
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					
				});
				//
				
				
				//Begin Button Setup
				beginB = new JButton("BEGIN");
				beginB.setForeground(Color.GREEN);
				beginB.setBackground(Color.WHITE);
				beginB.setBounds(280, 300, 430, 200);
				beginB.setFont(new Font("SERIF", Font.BOLD, 120));
			    gCatcherP.add(beginB);
			    //
			    
			    
			    //Instruction Label Setup
			    gCInstr = new JLabel("Catch the GENIE with your MOUSE!");
			    gCInstr.setLayout(null);
			    gCInstr.setBounds(150, 230, 800, 60);
			    gCInstr.setFont(new Font("Arial", Font.BOLD, 40));
			    gCInstr.setForeground(Color.RED);
			    gCatcherP.add(gCInstr);
			    //
			    
			    
			    
			    //gCTimer Label
			    gCTimerLabel = new JLabel("01:30");
			    gCTimerLabel.setLayout(null);
			    gCTimerLabel.setBounds(810, 15, 500, 60);
			    gCTimerLabel.setFont(new Font("Arial", Font.BOLD, 60));
			    gCTimerLabel.setForeground(Color.GREEN);
			    gCTimerLabel.setVisible(false);
			    gCatcherP.add(gCTimerLabel);
			    //
			    
			    
			    //Mini Game Points Label Setup
			    gCPointsLabel = new JLabel("0");
				gCPointsLabel.setLayout(null);
				gCPointsLabel.setBounds(720, 15, 500, 60);
				gCPointsLabel.setFont(new Font("Arial", Font.BOLD, 60));
				gCPointsLabel.setForeground(Color.RED);
				gCPointsLabel.setVisible(false);
				gCatcherP.add(gCPointsLabel);
				//
				
				
			    //gCTimer BackGround
			    gCTimerBack = new JButton();
			    gCTimerBack.setBounds(700, 0, 300, 90);
				gCatcherP.add(gCTimerBack);
				gCTimerBack.setVisible(false);
				//
				
				
				
				//Mini Game Done Button Setup
				gCDone = new JButton("DONE");
				gCDone.setForeground(Color.RED);
				gCDone.setBackground(Color.RED);
				gCDone.setBounds(300, 550, 350, 150);
				gCDone.setFont(new Font("Serif", Font.BOLD, 60));
			    gCatcherP.add(gCDone);
			    gCDone.setVisible(false);
			    //
			    
			    //Done Button Pressed
			    gCDone.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						gCBlinkTimer.stop();
						dispose();
						
						try {
							StartMenu kop = new StartMenu(0);
						} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
			    	
			    	
			    });
				//
				
				
				//Mini Game Timer
				gCTimer = new Timer(1000, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						gCsecond--;
						
						if (gCsecond == -1) {
							
							if (gCminute == 0) {
								gCsecond = 0;
								gCminute = 0;
								
								ddSecond = dFormat.format(gCsecond); 
								ddMinute = dFormat.format(gCminute);
								
								gCTimerLabel.setText(ddMinute + ":" + ddSecond);
								
								genie.setVisible(false);
								gCTimer.stop();
								imageTimer.stop();
								clip.stop();
								gCTimerLabel.setVisible(false);
								gCTimerBack.setVisible(false);
								gCTimerLabel.setBounds(670, 90, 500, 60);
								gCTimerLabel.setForeground(Color.RED);
								gCPointsLabel.setVisible(false);
								gCPointsLabel.setText("FINAL SCORE: " + gCPoints);
								gCPointsLabel.setBounds(100, 300, 1000, 200);
								gCPointsLabel.setFont(new Font("Serif", Font.BOLD, 100));
								gCPointsLabel.setForeground(Color.RED);
								compVisible = false;
								gCDone.setVisible(true);
								gCBlinkTimer.start();
								
								
								
								

							} else {
								gCsecond = 59;
								gCminute--;
								
								ddSecond = dFormat.format(gCsecond); 
								ddMinute = dFormat.format(gCminute);
								
								gCTimerLabel.setText(ddMinute + ":" + ddSecond);
							}
							
						} else {
							ddSecond = dFormat.format(gCsecond); 
							ddMinute = dFormat.format(gCminute);
							
							gCTimerLabel.setText(ddMinute + ":" + ddSecond);
						}
					}
			    	
			    	
			    });
				//
				
				//Game Finised Blinker Timer
				gCBlinkTimer = new Timer(500, new ActionListener() {
					

					@Override
					public void actionPerformed(ActionEvent e) {
						
						try {
							loopAlarmMusic();
						} catch (UnsupportedAudioFileException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (LineUnavailableException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						if (compVisible) {
							gCTimerLabel.setVisible(false);
							gCPointsLabel.setVisible(false);
							gCDone.setText("");
							compVisible = false;
						} else {
							gCTimerLabel.setVisible(true);
							gCPointsLabel.setVisible(true);
							gCDone.setText("DONE");
							compVisible = true;
							
						}
						
					}
			    	
			    	
			    }); 
				//
				
				//Genie Image switch Location Timer
				imageTimer = new Timer(1000, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (gCsecond == 15 && gCminute == 1) {
							imageTimer.setDelay(900);
						} else if (gCsecond == 0 && gCminute == 1) {
							imageTimer.setDelay(800);
						} else if (gCsecond == 45 && gCminute == 0) {
							imageTimer.setDelay(700);
						} else if (gCsecond == 30 && gCminute == 0) {
							imageTimer.setDelay(600);
						} else if (gCsecond == 15 && gCminute == 0) {
							imageTimer.setDelay(500);
						}
						
						if (imageVisible) {
							imageVisible = false;
							genie.setVisible(false);
						} else {
							imageVisible = true;
							int x = (int) (Math.random()*720 + 100);
							int y = (int) (Math.random()*620 + 100);
							genie.setBounds(x, y, 120, 120);
							genie.setVisible(true);
						}
						
						
						
						
						
						
					}
			    	
			    	
			    });
			    //
				
			   //Begin Button Pressed - Game STARTED
			   beginB.addActionListener(new ActionListener() {
				  
				@Override
				public void actionPerformed(ActionEvent e) {
					gCInstr.setVisible(false);
					imageVisible = false;
					beginB.setVisible(false);
					gCPointsLabel.setVisible(true);
					gCTimerLabel.setVisible(true);
					gCTimerBack.setVisible(true);
					gCsecond = 30;
					gCminute = 0;
					gCTimer.start();
					imageTimer.start();
					
				}
				   
				   
			   });
			    
			   
			   //Mini Game BackGround Setup
			    backgroundgC=new ImageIcon("gCatcherScreen.jpg");
				Image img2=backgroundgC.getImage();
				Image temp2=img2.getScaledInstance(1000,800,Image.SCALE_SMOOTH);
				backgroundgC= new ImageIcon(temp2);
				screenImage = new JLabel(backgroundgC);
				screenImage.setLayout(null);
				screenImage.setBounds(0,0,1000,800);
				gCatcherP.add(screenImage);
			    //
				
				
				//NECESSARY
			    setVisible(true);
				//
				
				
				
				
				
			}
			
			
		});
		
		
		// NECESSARY
		setVisible(true);
		//
	}
	
	// Play Music Methods - Starts the Music
	
	
			public void playMenuMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
				file4 = new File("awesomeness.wav");
				audiostream4 =  AudioSystem.getAudioInputStream(file4);
				clip4 = AudioSystem.getClip();
				clip4.open(audiostream4);
				
				clip4.loop(Clip.LOOP_CONTINUOUSLY);
			}
			//PLAYS GAME MUSIC
			public void playGameMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
				file = new File("8BIT.wav");
				audiostream =  AudioSystem.getAudioInputStream(file);
				clip = AudioSystem.getClip();
				clip.open(audiostream);
				
				clip.start();
			}
			//
			
			
			
			//PLAYS ALARM MUSIC ONCE TIME IS DONE
			public void loopAlarmMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
				file1 = new File("AlarmSound.wav");
				audiostream1 =  AudioSystem.getAudioInputStream(file1);
				clip1 = AudioSystem.getClip();
				clip1.open(audiostream1);
				
				
				clip1.start();
			}
			//
			
			
			
			//PLAYS WRONG SFX WHEN QUESTION IS ANSWERED WRONG
			public void playWrongSFX() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
				file2 = new File("WRONG.wav");
				audiostream2 =  AudioSystem.getAudioInputStream(file2);
				clip2 = AudioSystem.getClip();
				clip2.open(audiostream2);
				
				
				clip2.start();
			}
			//
			
			
			
			//PLAYS RIGHT SFX WHEN QUESTION IS ANSWERED CORRECTLY
			public void playRightSFX() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
				file3 = new File("RIGHT.wav");
				audiostream3 =  AudioSystem.getAudioInputStream(file3);
				clip3 = AudioSystem.getClip();
				clip3.open(audiostream3);
				
				
				clip3.start();
			}
			//
		
		//
			
		public void showCorrectAnswer() {
			secondC = 0;
			correctLName.setText(allNames.get(randPerson));
			correctTimer = new Timer(1000, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (secondC >= 1) {
						correctTimer.stop();
						secondC = 0;
						correctL.setVisible(false);
						correctLName.setVisible(false);
						
					} else {
						correctL.setVisible(true);
						correctLName.setVisible(true);
						secondC++;
					}
					
				}
		    	
		    	
		    }); 
		    //
		}
		
		//Sets up screen after DONE is pressed
		public void doneScreen() {
			correctL.setText("");
			correctLName.setText("");
			doneB.setVisible(true);
			doneB.setEnabled(true);
			skipB.setVisible(false);
			skipB.setEnabled(false);
			glasses.setVisible(false);
			hairCol.setVisible(false);
			eyeCol.setVisible(false);
			height.setVisible(false);
			answer.setVisible(false);
			answer.setEnabled(false);
			timerL.setForeground(Color.RED);
			pointCounter.setForeground(Color.RED);
			pointCounter.setText("FINAL SCORE:" + points);
			pointCounter.setBounds(90, 360, 1000, 100);
			pointCounter.setFont(new Font("Arial", Font.BOLD, 100));
			
		}
		//
		
		
		
		//Sets up a new Question for the User
		public void setQuestion() {
			randPerson = (int) (Math.random()*31);
			if (neverUsed(randPerson)) {
				glasses.setText("Glasses: " + allGlasses.get(randPerson));
				hairCol.setText("Hair Color: " + allHair.get(randPerson));
				eyeCol.setText("Eye Color: " + allEyes.get(randPerson));
				height.setText("Height: " + allHeight.get(randPerson));
			} else if (answered.size() >= 31){
				doneScreen();
				timerL.setText("00:00");
				timer.stop();
				blinkTimer.start();
			} else {
				setQuestion();
			}
		
		}
		//
		
		
		
		//SETS UP ALL THE TEXT FILES
		public void setFiles () {
		    allEyes = importFile("eye.txt");
		    allGlasses = importFile("glasses.txt");
		    allHair = importFile("hair.txt");
		    allNames = importFile("name.txt");
		    allHeight = importFile("heights.txt");
		}
		//
		
		
		
		// Checks if a person(represented as a number) has already been used
		public boolean neverUsed(int num) {
			for (int i = 0; i < answered.size(); i++) {
				if (answered.get(i) == num) {
					return false;
				}
			}
			answered.add(num);
			return true;
		}
		//
		
		
		
		// Converts STRING Text Files to ArrayLists
		public static ArrayList<String> importFile(String fileName) {
		    ArrayList<String> words = new ArrayList<>();
		    try {
		      File myObj = new File(fileName);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        words.add(data);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }

		    return words;
		  }
		//

	
}
