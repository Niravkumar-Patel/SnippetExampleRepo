package interviewque;

import java.util.ArrayList;
import java.util.List;

public class FindRectangles {

	public static List<Point> findRectangle(int matrix[][]) {
		List<Point> recCordinatesPoints = new ArrayList<Point>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					recCordinatesPoints.addAll(caputreCoordinates(matrix, i, j));
				}
			}
		}
		return recCordinatesPoints;
	}

	public static List<Point> caputreCoordinates(int matrix[][], int i, int j) {

		int colStart = j;
		Point startPoint = new Point(i, j);

		while (j < matrix[0].length && matrix[i][j] == 0) {
			matrix[i][j] = 1;
			j++;
		}

		int colEnd = --j;
		i++;
		j = colStart;
		while (i < matrix.length && matrix[i][j] == 0) {
			while (j <= colEnd) {
				matrix[i][j] = 1;
				j++;
			}
			j = colStart;
			i++;
		}

		Point endPoint = new Point(--i, colEnd);

		List<Point> listPoint = new ArrayList<Point>();
		listPoint.add(startPoint);
		listPoint.add(endPoint);

		return listPoint;
	}
	
	public static void main(String[] args) {
		int matrix[][] = { {0,1,1,1,1,1,1}, 
						   {1,1,1,1,1,1,1},
						   {1,1,1,1,1,1,1},
						   {1,1,1,0,0,1,1},
						   {1,1,1,0,0,1,1},
						   {1,1,1,0,0,1,1},
						   {1,1,1,0,0,1,1},
						   {1,1,1,0,0,1,1},
						   {1,1,1,1,1,1,1},
						   {1,1,1,1,1,1,1}};
		System.out.println(findRectangle(matrix));
	}

}

class Point {
	int x = -1;
	int y = -1;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "[" + x + ", " + y + "]";
	}

}
