import javax.swing.JPanel;

import sun.misc.PerformanceLogger;

public class CellMap
{
	static public MapElement[][] mapElements = new MapElement[Pref.MapSize][Pref.MapSize];

	static public void initMap()
	{
		for (int i = 0; i < Pref.MapSize; i++)
			for (int j = 0; j < Pref.MapSize; j++)
			{
				mapElements[i][j] = new MapElement(i, j);
			}
	}

	static public void initPanel(JPanel panelMap)
	{
		for (int i = 0; i < Pref.GridSize; i++)
			for (int j = 0; j < Pref.GridSize; j++)
			{
				panelMap.add(mapElements[j + 5][i + 5].button);
			}
	}

	static public void resetMap()
	{
		for (int i = 0; i < Pref.MapSize; i++)
			for (int j = 0; j < Pref.MapSize; j++)
			{
				mapElements[i][j].reset();
			}
	}

	static public void nextFrame()
	{
		int[][] mapNext = new int[Pref.MapSize][Pref.MapSize];
		int i, j;
		int cells;

		for (i = 1; i < Pref.MapSize - 1; i++)
			for (j = 1; j < Pref.MapSize - 1; j++)
			{
				cells = 0;
				cells += mapElements[i - 1][j - 1].living;
				cells += mapElements[i - 1][j].living;
				cells += mapElements[i - 1][j + 1].living;
				cells += mapElements[i][j - 1].living;
				cells += mapElements[i][j + 1].living;
				cells += mapElements[i + 1][j - 1].living;
				cells += mapElements[i + 1][j].living;
				cells += mapElements[i + 1][j + 1].living;
				if (cells == 2)
					mapNext[i][j] = mapElements[i][j].living;
				else if (cells == 3)
					mapNext[i][j] = 1;
				else
					mapNext[i][j] = 0;
			}

		for (i = 1; i < Pref.MapSize - 1; i++)
			for (j = 1; j < Pref.MapSize - 1; j++)
			{
				mapElements[i][j].changeState(mapNext[i][j]);
			}
	}
}
