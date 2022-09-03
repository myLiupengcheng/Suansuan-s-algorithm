package com.suansuan.algorithm.query;

import com.suansuan.algorithm.utils.ArrayUtils;

/**
 * 二分查找相关算法，二分查找相关算法主要涉及两个常用算法，具体题目如下所示：</br>
 * <li>1、给定一个有序的数组array，在该数组当中找到相应的数值value的小标，-1代表没有找到。
 * <li>2、给定一个有序的数组array，在该数组当中找到 >= vale 最左边的数的下标，-1代码没有找到。
 * 
 * 思路分析
 * 上述题目当中 1 是典型的数组当中找给定数值，这里的解法主要有两种
 *  1、直接简单全部遍历一次即可，暴力遍历一次，用一个变量记录要找的值，每次和新来的值做对比即可获取下标位置。
 *  2、这里的数组是有序的，可以利用这个条件，先从中间，然后比大小 再然后看是属于上半区还是下半区，以此类推。
 * 
 * @since 2020-09-03
 * @author pengchengliu
 *
 */
public class Algorithm_BinarySearch {
	
	private static final int[] ARRAY = {
			1, 11, 18, 23, 39, 39, 39, 39, 39, 100, 129, 183, 230, 430
	};

	/**
	 * 主函数入口
	 * 
	 * @param args 启动该程序所传递过来的参数，可以是控制台输入。
	 */
	public static void main(String[] args) {
		System.out.println("标准二分法查找");
		ArrayUtils.printlnArray(ARRAY);
		System.out.println("要找到的数字是 " + 39 + " 找到的位置是 " + binarySearch(ARRAY, 39));
		
		System.out.println("最左二分法查找");
		ArrayUtils.printlnArray(ARRAY);
		System.out.println("要找到的数字是 " + 39 + " 找到的位置是 " + binarySearchLeftValue(ARRAY, 39));
	}
	
	/**
	 * 通过二分法查找固定的数字在数组中的最左端的位置。
	 *
	 * @param array 备查找的数组。
	 * @param value 要查找的数字。
	 * @return 被查找的数字的下标的值。-1 代表没有被找到
	 */
	public static int binarySearchLeftValue(int[] array, int value) {
		int L = 0;
		int R = array.length;
		int leftValue = -1;
		while (L <= R) {
			int M = (L + R) / 2;
			if (array[M] >= value) {
				leftValue = M;
				R = M - 1;
			} else {
				L = M + 1;
			}
		}
		return leftValue;
	}
	
	/**
	 * 通过二分法查找固定的数字在数组中的位置。
	 * 
	 * @param array 备查找的数组。
	 * @param value 要查找的数字。
	 * @return 被查找的数字的下标的值。-1 代表没有被找到
	 */
	public static int binarySearch(int[] array, int value) {
		int L = 0;
		int R = array.length;
		while (L < R) {
			int M = (L + R) / 2;
			if (array[M] == value) {
				return M;
			}

			if (array[M] < value) {
				L = M + 1;
			}

			if (array[M] > value) {
				R = M - 1;
			}
		}
		return -1;
	}
}
