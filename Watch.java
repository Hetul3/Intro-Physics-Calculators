import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Watch implements ActionListener{

	
	private static final DecimalFormat df = new DecimalFormat("0.00");
	JFrame frame = new JFrame();
	JButton startButton = new JButton("Start");
	JButton resetButton = new JButton("Reset");
	JButton calcButton = new JButton("Free Fall");
	JButton addButton = new JButton("+10");
	JButton JupiterButton = new JButton("Jupiter");
	JButton MarsButton = new JButton("Mars");
	JButton MoonButton = new JButton("Moon");
	JLabel timeLabel = new JLabel();
	int elapsedTime = 0;
	int milliseconds = 0;
	int seconds = 0;
	int minutes = 0;
	int HEIGHT = 400;
	int WIDTH = 700;
	boolean started = false;
	String milliseconds_string = String.format("%03d", milliseconds);
	String seconds_string = String.format("%02d", seconds);
	String minutes_string = String.format("%02d", minutes);
	Timer timer = new Timer(1, new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			elapsedTime = elapsedTime+1;
			minutes = (elapsedTime/60000) % 100;
			seconds = (elapsedTime/1000) % 60;
			milliseconds = (elapsedTime) % 1000;
			milliseconds_string = String.format("%03d", milliseconds);
			seconds_string = String.format("%02d", seconds);
			minutes_string = String.format("%02d", minutes);
			timeLabel.setText(minutes_string + ":" + seconds_string + ":"
					+ milliseconds_string);
			
		}
			
	});
	
	
	
	Watch() {
		
		timeLabel.setText(minutes_string + ":" + seconds_string + ":" 
		+ milliseconds_string);
		
		timeLabel.setBounds(WIDTH/2 - 130, HEIGHT/2 - 150, 250, 100);
		timeLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		
		startButton.setBounds(5, HEIGHT/2 - 30,WIDTH/2 - 10,75);
		startButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
		startButton.setFocusable(false);
		startButton.addActionListener(this);
		
		resetButton.setBounds(WIDTH/2 + 5,HEIGHT/2 - 30,WIDTH/2 - 10,75);
		resetButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		calcButton.setBounds(5, HEIGHT/2 + 50,WIDTH/2 - 10,75);
		calcButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
		calcButton.setFocusable(false);
		calcButton.addActionListener(this);
		
		JupiterButton.setBounds(WIDTH/2 + 5,HEIGHT/2 + 50,WIDTH/2 - 10,75);
		JupiterButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
		JupiterButton.setFocusable(false);
		JupiterButton.addActionListener(this);
		
		MarsButton.setBounds(5, HEIGHT/2 + 130,WIDTH/2 - 10,75);
		MarsButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
		MarsButton.setFocusable(false);
		MarsButton.addActionListener(this);
		
		MoonButton.setBounds(WIDTH/2 + 5,HEIGHT/2 + 130,WIDTH/2 - 10,75);
		MoonButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
		MoonButton.setFocusable(false);
		MoonButton.addActionListener(this);
		
		addButton.setBounds(WIDTH/4, HEIGHT/2 + 210, WIDTH/2 - 10, 75);
		addButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
		addButton.setFocusable(false);
		addButton.addActionListener(this);
		
		
		frame.add(startButton);
		frame.add(resetButton);
		frame.add(calcButton);
		frame.add(timeLabel);
		frame.add(addButton);
		frame.add(JupiterButton);
		frame.add(MarsButton);
		frame.add(MoonButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 550);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		double elap = Math.round(elapsedTime*100)/100;
		if(e.getSource() == startButton) {
	
			if (started == false) {
				started=true;
				startButton.setText("Stop");
				start();
			}
			else {
				started=false;
				startButton.setText("Start");
				stop();
			}
		}
		if(e.getSource() == resetButton) {
			started = false;
			startButton.setText("Start");
			calcButton.setText("Free Fall");
			JupiterButton.setText("Jupiter");
			MarsButton.setText("Mars");
			reset();
		}
		
		if(e.getSource() == calcButton) {
			calcButton.setText(
					df.format(0.5 * 9.80665 * (elap/1000) * (elap/1000)) +
					"m");
			stop();
			started = false;
			startButton.setText("Start");
			
		}
		
		if(e.getSource() == addButton) {
			elapsedTime += 10000;
		}
	
		if(e.getSource() == JupiterButton) {
			JupiterButton.setText(
					df.format(0.5 * 24.79 * (elap/1000)*(elap/1000)) + "m"
					);
			stop();
			started = false;
			startButton.setText("Start");
		}
		if(e.getSource() == MarsButton) {
			MarsButton.setText(
					df.format(0.5 * 3.721 * (elap/1000)*(elap/1000)) + "m"
					);
			stop();
			started = false;
			startButton.setText("Start");
		}
		if(e.getSource() == MoonButton) {
			MoonButton.setText(
					df.format(0.5 * 1.625 * (elap/1000) * (elap/1000)) + "m"
					);
			stop();
			started = false;
			startButton.setText("Start");
		}
		
	}
	void start() {
		timer.start();
		
	}
	void stop() {
		timer.stop();
	}
	void reset() {
		timer.stop();
		elapsedTime = 0;
		seconds = 0;
		milliseconds = 0;
		minutes = 0;
		
		milliseconds_string = String.format("%03d", milliseconds);
		seconds_string = String.format("%02d", seconds);
		minutes_string = String.format("%02d", minutes);
		timeLabel.setText(minutes_string + ":" + seconds_string + ":"
		+ milliseconds_string);	
	}	
}
