import java.text.DecimalFormat;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;

public class Range_Calc {
	DecimalFormat df = new DecimalFormat("0.00");
	
	JFrame frame = new JFrame();
	JLabel label = new JLabel();
	int fontsize = 45;
	Graphics graphics;
	
	Range_Calc(double speed, double angleInDegrees) {
		double g, angleInRads, range;
		
		g = 9.8;
		angleInRads = angleInDegrees * Math.PI / 180;
		range = 2 * speed * speed * 
		Math.sin(angleInRads) * Math.cos(angleInRads) / g;
			System.out.println("Speed = " + speed + "m/s");
			System.out.println("Angle = " + angleInDegrees + " degrees");
			System.out.println("Range = " + df.format(range) + " Meters");
		
		//If you want a window with the range
		label.setText("Range = " + df.format(range) + " Meters");
		label.setBounds(0, 0 - fontsize, 700, 500);
		label.setFont(new Font("Verdana", Font.PLAIN, fontsize));
		label.setOpaque(true);
		label.setHorizontalAlignment(JTextField.CENTER);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(label);
		frame.setSize(700, 500);
		frame.setLayout(null);
		frame.setVisible(true);
	
	}
	
	
	public static void main(String[] args) {
	//input specifications inside the method	
		new Range_Calc(1000, 45);		

		//or input specifications in the terminal
		Scanner input = new Scanner(System.in);
		int speed = input.nextInt();
		int angleInDegrees = input.nextInt();
		
		double g = 9.8;
		double angleInRads = angleInDegrees * Math.PI / 180;
		double range = 2 * speed * speed * Math.sin(angleInRads) * Math.cos(angleInRads) / g;
		
		System.out.println("Speed: " + speed + "m/s");
		System.out.println("Angle: " + angleInDegrees + " Degrees");
		System.out.println("Range: " + range + " Meters");
	}

}

