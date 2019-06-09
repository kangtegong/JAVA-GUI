import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NumberGame extends JFrame {

	private JButton restart, end;
	private JTextField text;
	private JLabel cur;
	private int number;
	
	public NumberGame(){
		
		// 1~100 랜덤 숫자 생성
		double randomValue = Math.random();
		number = (int)(randomValue*100)+1;
		
		// 사이즈 조정
		setSize(300, 150);
		setTitle("숫자게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel buttonpanel = new JPanel();
		JPanel inputpanel = new JPanel();
		JPanel resultpanel = new JPanel();
		
		setLayout(new BorderLayout());
		
		// 숫자 입력 부분 :  input panel
		inputpanel.add(new JLabel("숫자를 추측하세요 : "));
		
		// 버튼 액션 이벤트 처리
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
							cur.setText("너무 낮습니다!");
							cur.setBackground(Color.red);  

						}
						else if(value > number)
						{
							cur.setText("너무 높습니다!");
							cur.setBackground(Color.red);  

						}
						else if(value == number)	
						{
							cur.setText("정답입니다!");
							cur.setBackground(Color.white);  

						}
						
					}

					catch(NumberFormatException err)// 		
					{
						cur.setText("잘못된 입력입니다!");
						cur.setBackground(Color.yellow);  

					}
				}				
				}    
		    
		});

	
		inputpanel.add(text);
		add(inputpanel, BorderLayout.NORTH);
		
		// 결과 창 띄워주는 부분 : result panel
		cur = new JLabel();
		
		cur.setOpaque(true);		// 이걸 설정해줘야 배경색 변경 가능
		cur.setText("숫자를 입력하세요");
		cur.setBackground(Color.white);
		
		resultpanel.add(cur);
		add(resultpanel, BorderLayout.CENTER);
	
		// 버튼 부분 : button panel

		// 종료버튼은 그냥 무명클래스로 작성
		restart = new JButton("새 게임");
		JButton end = new JButton("종료");
		
		end.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		System.exit(0);
		}
		});
		
		// 재시작
		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// 1~100 랜덤 숫자 생성
				double randomValue = Math.random();
				number = (int)(randomValue*100)+1;

				cur.setOpaque(true);		
				cur.setText("숫자를 입력하세요");
				// cur.setText("생성 수 : "+number); // 디버깅용
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
