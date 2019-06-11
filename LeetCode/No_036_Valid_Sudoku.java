package LeetCode;

import java.util.HashMap;

/**
 * 暴力解法，分别对行、列、斜三个方向进行验证，使用HashMap记录各个数字出现的次数
 */
public class No_036_Valid_Sudoku {
	public boolean isValidSudoku(char[][] board) {
		HashMap<Character,Boolean> map = new HashMap<>();
		for (int i=0;i<9;i++){
			map.clear();
			for (int j=0;j<9;j++){
				if (board[i][j]!='.'){
					if (map.get(board[i][j])!=null){
						return false;
					}else {
						map.put(board[i][j],true);
					}
				}
			}
		}
		for (int i=0;i<9;i++){
			map.clear();
			for (int j=0;j<9;j++){
				if (board[j][i]!='.'){
					if (map.get(board[j][i])!=null){
						return false;
					}else {
						map.put(board[j][i],true);
					}
				}
			}
		}
		for (int i=0;i<9;i+=3){
			for (int j=0;j<9;j+=3){
				map.clear();
				for (int k=i;k<i+3;k++){
					for (int l=j;l<j+3;l++){
						if (board[k][l]!='.'){
							if (map.get(board[k][l])!=null){
								return false;
							}else {
								map.put(board[k][l],true);
							}
						}
					}
				}
			}
		}
		return true;
	}
}
