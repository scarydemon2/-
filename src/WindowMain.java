
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.javafx.collections.MappingChange.Map;

import javafx.scene.control.Cell;
import java.awt.Font;

public class WindowMain extends JFrame
{
	private JPanel contentPane;

	public static void main(String[] args)
	{
		WindowMain frame = new WindowMain();
		frame.setVisible(true);
	}

	public WindowMain()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelMap = new JPanel();
		panelMap.setBounds(0, 0, 553, 553);
		contentPane.add(panelMap);
		panelMap.setLayout(new GridLayout(20, 20, 0, 0));
		CellMap.initMap();
		CellMap.initPanel(panelMap);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Source Code Pro Black", Font.PLAIN, 16));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CellMap.resetMap();
			}
		});
		btnReset.setBounds(600, 50, 120, 30);
		contentPane.add(btnReset);
		
		JButton btnNextFrame = new JButton("Next Frame");
		btnNextFrame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CellMap.nextFrame();
			}
		});
		btnNextFrame.setFont(new Font("Source Code Pro Black", Font.PLAIN, 16));
		btnNextFrame.setBounds(585, 150, 150, 30);
		contentPane.add(btnNextFrame);
	}
}
