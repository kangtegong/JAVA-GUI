import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NumberGame extends JFrame {

	private JButton restart, end;
	private JTextField text;
	private JLabel cur;
	private int number;
	
	public NumberGame(){
		
		// 1~100 ���� ���� ����
		double randomValue = Math.random();
		number = (int)(randomValue*100)+1;
		
		// ������ ����
		setSize(300, 150);
		setTitle("���ڰ���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel buttonpanel = new JPanel();
		JPanel inputpanel = new JPanel();
		JPanel resultpanel = new JPanel();
		
		setLayout(new BorderLayout());
		
		// ���� �Է� �κ� :  input panel
		inputpanel.add(new JLabel("���ڸ� �����ϼ��� : "));
		
		// ��ư �׼� �̺�Ʈ ó��
		text = new JTextField(15);
		text.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
				if(e.getSource()==text)
				{
					try
					{

						String str = text.getText();
						int value = Integer.parseInt(str);
						
						if(value < number)
						{
							cur.setText("�ʹ� �����ϴ�!");
							cur.setBackground(Color.red);  

						}
						else if(value > number)
						{
							cur.setText("�ʹ� �����ϴ�!");
							cur.setBackground(Color.red);  

						}
						else if(value == number)	
						{
							cur.setText("�����Դϴ�!");
							cur.setBackground(Color.white);  

						}
						
					}

					catch(NumberFormatException err)// 		
					{
						cur.setText("�߸��� �Է��Դϴ�!");
						cur.setBackground(Color.yellow);  

					}
				}				
				}    
		    
		});

	
		inputpanel.add(text);
		add(inputpanel, BorderLayout.NORTH);
		
		// ��� â ����ִ� �κ� : result panel
		cur = new JLabel();
		
		cur.setOpaque(true);		// �̰� ��������� ���� ���� ����
		cur.setText("���ڸ� �Է��ϼ���");
		cur.setBackground(Color.white);
		
		resultpanel.add(cur);
		add(resultpanel, BorderLayout.CENTER);
	
		// ��ư �κ� : button panel

		// �����ư�� �׳� ����Ŭ������ �ۼ�
		restart = new JButton("�� ����");
		JButton end = new JButton("����");
		
		end.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		System.exit(0);
		}
		});
		
		// �����
		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// 1~100 ���� ���� ����
				double randomValue = Math.random();
				number = (int)(randomValue*100)+1;

				cur.setOpaque(true);		
				cur.setText("���ڸ� �Է��ϼ���");
				// cur.setText("���� �� : "+number); // ������
				cur.setBackground(Color.white);
								
			}
		});


		
		buttonpanel.add(restart);
		buttonpanel.add(end);
		add(buttonpanel, BorderLayout.SOUTH);
		
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		NumberGame game = new NumberGame();

	}

}
