import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Puzzle extends JFrame implements ActionListener {

	JButton[][] buttons = new JButton[3][3];
	JButton zero = new JButton();
	JButton reset = new JButton();
	private String str;
	private JPanel panel;
	
	public Puzzle() {
		setTitle("puzzle");
		setSize(400,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		
		Font f = new Font("Times New Roman", Font.PLAIN, 50);
		
		buttons[0][0] = new JButton("1");
		buttons[0][1] = new JButton("2");
		buttons[0][2] = new JButton("3");

		buttons[1][0] = new JButton("4");
		buttons[1][1] = new JButton("5");
		buttons[1][2] = new JButton("6");

		buttons[2][0] = new JButton("7");
		buttons[2][1] = new JButton("8");
		buttons[2][2] = new JButton(" ");
		
		zero = buttons[2][2];
		reset = new JButton("reset");
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				buttons[i][j].setFont(f);					
				buttons[i][j].addActionListener(this);
				panel.add(buttons[i][j]);
			}
		}
		panel.add(zero);
		
		panel.setLayout(new GridLayout(0,3));
		
		add(panel, BorderLayout.CENTER);
		reset.setFont(f);
		reset.addActionListener(this); //이걸 자꾸 까먹는다
		add(reset, BorderLayout.SOUTH);
		
		setVisible(true);		
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
	
	// if 행+열의 합의 차가 1보다 작으면 (상하좌우로만 움직여야 하므로)
	JButton pressed = (JButton)e.getSource();
		
	// 리셋버튼
	if(pressed == reset)
	{
		buttons[0][0].setText("1");		
		buttons[0][1].setText("2");		
		buttons[0][2].setText("3");		

		buttons[1][0].setText("4");		
		buttons[1][1].setText("5");		
		buttons[1][2].setText("6");		

		buttons[2][0].setText("7");		
		buttons[2][1].setText("8");		
		buttons[2][2].setText(" ");		
		zero = buttons[2][2];
	
	}
	
	// Case #1
	if(pressed == buttons[0][0] && (zero == buttons[0][1] || zero == buttons[1][0])) // pressed가 zero의 상하좌우에 있고 zero가 reset이 아닐 경우
	{
	str = pressed.getText();
	
		if(str=="reset") return;

		else 
		{
			pressed.setText(" ");			
			zero.setText(str);
			zero = pressed;
		}
	}		

	// Case #2
	else if(pressed == buttons[0][1] && (zero == buttons[0][0] || zero == buttons[0][2] || zero == buttons[1][1])) // pressed가 zero의 상하좌우에 있고 zero가 reset이 아닐 경우
	{
	str = pressed.getText();
	
		if(str=="reset") return;

		else 
		{
			pressed.setText(" ");			
			zero.setText(str);
			zero = pressed;
		}
	}		
	
	// Case #3
	else if(pressed == buttons[0][2] && (zero == buttons[0][1] || zero == buttons[1][2])) // pressed가 zero의 상하좌우에 있고 zero가 reset이 아닐 경우
	{
	str = pressed.getText();
	
		if(str=="reset") return;

		else 
		{
			pressed.setText(" ");			
			zero.setText(str);
			zero = pressed;
		}
	}
	
	// Case #4
	else if(pressed == buttons[1][0] && (zero == buttons[0][0] || zero == buttons[2][0] || zero == buttons[1][1])) // pressed가 zero의 상하좌우에 있고 zero가 reset이 아닐 경우
	{
	str = pressed.getText();
	
		if(str=="reset") return;

		else 
		{
			pressed.setText(" ");			
			zero.setText(str);
			zero = pressed;
		}
	}
	
	// Case #5
	else if(pressed == buttons[1][1] && (zero == buttons[0][1] || zero == buttons[1][0] || zero == buttons[1][2] || zero == buttons[2][1])) // pressed가 zero의 상하좌우에 있고 zero가 reset이 아닐 경우
	{
	str = pressed.getText();
	
		if(str=="reset") return;

		else 
		{
			pressed.setText(" ");			
			zero.setText(str);
			zero = pressed;
		}
	}
	
	// Case #6
	else if(pressed == buttons[1][2] && (zero == buttons[0][2] || zero == buttons[1][1] || zero == buttons[2][2])) // pressed가 zero의 상하좌우에 있고 zero가 reset이 아닐 경우
	{
	str = pressed.getText();
	
		if(str=="reset") return;

		else 
		{
			pressed.setText(" ");			
			zero.setText(str);
			zero = pressed;
		}
	}
	
	// Case #7
	else if(pressed == buttons[2][0] && (zero == buttons[1][0] || zero == buttons[2][1])) // pressed가 zero의 상하좌우에 있고 zero가 reset이 아닐 경우
	{
	str = pressed.getText();
	
		if(str=="reset") return;

		else 
		{
			pressed.setText(" ");			
			zero.setText(str);
			zero = pressed;
		}
	}
		
	// Case #8
	else if(pressed == buttons[2][1] && (zero == buttons[2][0] || zero == buttons[1][1]|| zero == buttons[2][2])) // pressed가 zero의 상하좌우에 있고 zero가 reset이 아닐 경우
	{
	str = pressed.getText();
	
		if(str=="reset") return;

		else 
		{
			pressed.setText(" ");			
			zero.setText(str);
			zero = pressed;
		}
	}

	// Case #8
	else if(pressed == buttons[2][2] && (zero == buttons[2][1] || zero == buttons[1][2])) // pressed가 zero의 상하좌우에 있고 zero가 reset이 아닐 경우
	{
	str = pressed.getText();
	
		if(str=="reset") return;

		else 
		{
			pressed.setText(" ");			
			zero.setText(str);
			zero = pressed;
		}
	}

	
	}

	public static void main(String[] args) {

		Puzzle gui = new Puzzle();
	}

	
}

