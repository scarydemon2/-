import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MapElement
{
	private int row;
	private int column;
	
	public int living = 0;
	public JButton button = null;

	public MapElement(int _row, int _column)
	{
		row = _row;
		column = _column;
		if (row >= 5 && row < 25 && column >= 5 && column < 25)
			ValidateButton();
	}

	private void ValidateButton()
	{
		button = new JButton(Pref.IconWhiteCell);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if (living == 1)
				{
					living--;
					button.setIcon(Pref.IconWhiteCell);
				}
				else
				{
					living++;
					button.setIcon(Pref.IconBlackCell);
				}
			}
		});
	}

	public void reset()
	{
		living = 0;
		if (button != null)
			button.setIcon(Pref.IconWhiteCell);
	}
	
	public void changeState(int state)
	{
		living = state;
		if(button == null)
			return;
		if (state == 1)
			button.setIcon(Pref.IconBlackCell);
		else
			button.setIcon(Pref.IconWhiteCell);
	}
}
