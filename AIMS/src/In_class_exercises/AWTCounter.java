package In_class_exercises;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AWTCounter extends Frame implements ActionListener { 
	private Label lblCount;
	private TextField tfCount; 
	private Button btnCount; 
	private int count = 0; // Counter's value 
// Setup GUI components and event handling 
	public AWTCounter () {
		setLayout(new FlowLayout());
		lblCount = new Label("Counter");
		add(lblCount);
		tfCount = new TextField("0", 10);
		tfCount.setEditable(false); // set to read-only
		add(tfCount);
		btnCount = new Button("Count");
		add(btnCount); 
		//Clicking Button source fires ActionEvent
		//btnCount registers this instance as ActionEvent listener
		btnCount.addActionListener(this);
		setTitle("AWT Counter"); 
		setSize(250, 100);
		setVisible(true);
	}
	public static void main(String[] args){
		AWTCounter app = new AWTCounter();
	}
/** ActionEvent handler - Called back upon 
button-click. */
	public void actionPerformed(ActionEvent e){
		++count;
// Display the counter value on the TextField
		tfCount.setText(count + "");
	}
}