import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.awt.FlowLayout;

public class MyFrame extends JFrame implements ActionListener{

	JFrame frame = new JFrame();
	
	DecimalFormat df = new DecimalFormat("0.000");

	JButton buttonf;
	JTextField textField;
	JTextField textField12;
	JTextField textField2;
	JTextField textField3;
	BigDecimal masscon = new BigDecimal("1000");
	BigDecimal radcon = new BigDecimal("1");
	BigDecimal gravcon = new BigDecimal("0.00000000006673889");
	MathContext mc = new MathContext(20);

	
	
	
	
	MyFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		Font font = new Font("Consolas", Font.PLAIN, 40);
		Color color = new Color(0x00FF00);
		
		buttonf = new JButton("Calculate Force");
		buttonf.addActionListener(this);
		buttonf.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		textField = new JTextField("Radius (meters)");
		textField.setColumns(20);
		textField.setFont(font);
		textField.setCaretColor(color);
		textField.setForeground(color);
		textField.setBackground(Color.BLACK);
		textField.addActionListener(this);
		
		textField12 = new JTextField("Mass 1 (tons)");
		textField12.setColumns(20);
		textField12.setFont(font);
		textField12.setCaretColor(color);
		textField12.setForeground(color);
		textField12.setBackground(Color.BLACK);
		textField12.addActionListener(this);

		textField2 = new JTextField("Mass 2 (tons)");
		textField2.setColumns(20);
		textField2.setFont(font);
		textField2.setCaretColor(color);
		textField2.setForeground(color);
		textField2.setBackground(Color.BLACK);
		textField2.addActionListener(this);
		
		textField3 = new JTextField("Force (N)");
		textField3.setColumns(20);
		textField3.setFont(font);
		textField3.setCaretColor(color);
		textField3.setForeground(color);
		textField3.setBackground(Color.BLACK);
		textField3.setEditable(true);
		
		

		//allows for only the input of numbers
		textField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent evt) {
				if(!Character.isDigit(evt.getKeyChar())) {
					evt.consume();
				}
			}
		});
		textField12.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent evt) {
				if(!Character.isDigit(evt.getKeyChar())) {
					evt.consume();
				}
			}
		});
		textField2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent evt) {
				if(!Character.isDigit(evt.getKeyChar())) {
					evt.consume();
				}
			}
		});
		textField3.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent evt) {
				if(!Character.isDigit(evt.getKeyChar())) {
					evt.consume();
				}
			}
		});
		
		
		this.pack();
		this.add(textField);
		this.add(textField12);
		this.add(textField2);
		this.add(textField3);
		this.add(buttonf);
		this.setSize(750,350);
		this.setVisible(true);
						
	}
	
	public void actionPerformed(ActionEvent e) {
		
	
		String strtextFieldm1 = textField12.getText();
		String strtextFieldm2 = textField2.getText();
		String strtextFieldr = textField.getText();
		
		BigDecimal mass1 = new BigDecimal(strtextFieldm1);
		BigDecimal mass2 = new BigDecimal(strtextFieldm2);
		BigDecimal Radi = new BigDecimal(strtextFieldr);


		BigDecimal radius = Radi.multiply(radcon).multiply(Radi.multiply(radcon));
		BigDecimal Masses = (mass1.multiply(masscon).multiply(mass2.multiply(masscon)));
		BigDecimal Force = (((gravcon.multiply(Masses))).divide(radius, 20, RoundingMode.CEILING));
		BigDecimal Radius = (((gravcon.multiply(Masses)).divide(Force, 20, RoundingMode.CEILING)).sqrt(mc));
		
		if(e.getSource() == buttonf ) {

			textField3.setText(df.format(Force) + " N");
		}	

}
}