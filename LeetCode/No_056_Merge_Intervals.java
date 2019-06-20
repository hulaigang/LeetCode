package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 首先，利用比较器，将所有区间按照区间左元素的大小从小到大排序，然后对排序的数组，相邻的两个区间[a1,b1],[a2,b2]，有a1<b1，按照以下规则合并两区间：
 * 	①若a2>b1,合并为[a1,b2];
 * 	②若a2<b1且b1<b2,合并为[a1,b2]
 * 	③若a2<b1且b2<b1,合并为[a1,b1]
 */
public class No_056_Merge_Intervals {
	public int[][] merge(int[][] intervals) {
		List<int[]> list = new ArrayList<>();
		MyComportor comportor = new MyComportor();
		Arrays.sort(intervals,comportor);
		int i = 0;
		a1:while (i<intervals.length){
			if (i==intervals.length-1){
				int[] a = new int[]{intervals[i][0],intervals[i][1]};
				list.add(a);
				break a1;
			}
			int start = i;
			while (i<intervals.length-1 && intervals[start][1] >= intervals[i+1][0]){
				intervals[start][1] = Math.max(intervals[i+1][1],intervals[start][1]);
				i++;
				if (i==intervals.length-1){
					int[] a = new int[]{intervals[start][0],intervals[start][1]};
					list.add(a);
					break a1;
				}
			}
			int[] a = new int[]{intervals[start][0],intervals[start][1]};
			list.add(a);
			i++;
		}
		int[][] a = new int[list.size()][2];
		for (int j=0;j<a.length;j++){
			a[j][0] = list.get(j)[0];
			a[j][1] = list.get(j)[1];
		}
		return a;
	}

	class MyComportor implements Comparator<int[]> {
		@Override
		public int compare(int[] o1, int[] o2) {
			if (o1[0]>o2[0]){
				return 1;
			}else if (o1[0]==o2[0]){
				return 0;
			}else {
				return -1;
			}
		}
	}
}
