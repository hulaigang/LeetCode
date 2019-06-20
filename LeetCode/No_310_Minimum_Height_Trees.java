package LeetCode;

import java.util.*;

/**
 * 使用剪枝法，首先统计所有结点的度，然后每一轮删除一次叶结点（叶节点就是入度为1的节点）
 * 	然后将与叶节点相连节点的度-1，直到只剩下1或2个节点，这几个节点就是目标的根节点
 */
public class No_310_Minimum_Height_Trees {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		boolean[][] relation = new boolean[n][n];//两点之间是否有关系
		boolean[] isThrow = new boolean[n];//这个点是否被抛弃
		int[] numOfLink = new int[n];//这个点的连接数（1个就是叶子）
		int mark = n;//标记还剩多少个，<2就可以停止了
		for (int i = 0; i < edges.length; i++) {
			int x = edges[i][0];
			int y = edges[i][1];
			relation[x][y] = true;
			relation[y][x] = true;
			numOfLink[x]++;
			numOfLink[y]++;
		}

		while (mark>2){
			//找到叶子
			List<Integer> arr = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				if (!isThrow[i] && numOfLink[i] == 1){
					arr.add(i);
				}
			}
			//删除叶子
			for (int k = 0; k < arr.size(); k++) {
				int i = arr.get(k);
				isThrow[i] = true;
				mark--;
				for (int j = 0; j < n; j++) {
					if (relation[i][j]){
						numOfLink[j]--;
					}
				}
			}
		}
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (!isThrow[i]){
				list.add(i);
			}
		}
		return list;
	}
}
