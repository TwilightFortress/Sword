package others;
public class 棋盘 {
	public static  char[][] replace(char[][] chars) {
		int r=chars.length;
		int c = chars[0].length;
		//用来记录数组中哪些字符修改过，若改过，记录为true，否则为false。
		boolean[][] b=new boolean[r][c];

		//正向遍历in[1][1]到in[r-2][c-2]之间的字符
		for (int i = 1; i < r-1; i++) {
			for (int j = 1; j < c-1; j++) {
				//如果当前位置为O，并且左边、上边为X，此位置变为X，且b[i][j]=true,表示修改过值
				if (chars[i][j]=='O'&&chars[i-1][j]=='X'&&chars[i][j-1]=='X') {
					chars[i][j]='X';
					b[i][j]=true;
				}
			}
		}
		//反向遍历从in[r-2][c-2]到in[1][1]之间的字符
		for (int i = r-2; i >0; i--) {
			for (int j = c-2; j>0; j--) {
				//如果当前位置的值改过，且右边、下边任一位置的值为'O'，则此位置设为'O'
				if ((chars[i+1][j]=='O'||chars[i][j+1]=='O')&&b[i][j]==true) {
					chars[i][j]='O';
				}
			}
		}

		return chars;
	}
}
