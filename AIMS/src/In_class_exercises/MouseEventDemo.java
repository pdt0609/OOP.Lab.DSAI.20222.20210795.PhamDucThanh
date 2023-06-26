package In_class_exercises;

import java.awt.*;
import java.awt.event.*;

public class MouseEventDemo extends Frame {
	private TextField tfMouseX; // to display mouse-click-x
	private TextField tfMouseY; // to display mouse-click-y
	private TextField tfMousePX; // to display mouse-position-x
	private TextField tfMousePY; // to display mouse-position-y
	//setup the UI components and event handlers
	public MouseEventDemo() {
		setLayout(new FlowLayout());
		
		add(new Label("X-Click: "));
		tfMouseX = new TextField(5); 
		tfMouseX.setEditable(false); 
		add(tfMouseX);
		
		add(new Label("Y-Click: ")); 
		tfMouseY = new TextField(5);
		tfMouseY.setEditable(false); 
		add(tfMouseY);
		
		add(new Label("X-Position: "));
		tfMousePX = new TextField(5); 
		tfMousePX.setEditable(false); 
		add(tfMousePX);
		
		add(new Label("Y-Position: ")); 
		tfMousePY = new TextField(5);
		tfMousePY.setEditable(false); 
		add(tfMousePY);
		
		addMouseListener(new MyMouseListener());
		addMouseMotionListener(new MyMouseMotionListener());
		setTitle("MouseEvent Demo"); setSize(350, 100); setVisible(true);
	}
	public static void main(String[] args) {
		new MouseEventDemo(); // Let the constructor do the job
	}
	class MyMouseListener implements MouseListener {
		@Override
		public void mousePressed(MouseEvent e) {
			System.out.println("Mouse-button pressed!");
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			System.out.println("Mouse-button released!");
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			tfMouseX.setText(e.getX() + "");
			tfMouseY.setText(e.getY() + "");
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			System.out.println("Mouse-pointer entered the source component!");
		}
		@Override
		public void mouseExited(MouseEvent e) {
			System.out.println("Mouse exited-pointer the source component!");
		}	
	}
	
	class MyMouseMotionListener implements MouseMotionListener {
		@Override
		public void mouseDragged(MouseEvent e) {
			System.out.println("Mouse is dragged!");
		}
		@Override
		public void mouseMoved(MouseEvent e) {
		    tfMousePX.setText(e.getX() + "");
		    tfMousePY.setText(e.getY() + "");
		}
	}
}