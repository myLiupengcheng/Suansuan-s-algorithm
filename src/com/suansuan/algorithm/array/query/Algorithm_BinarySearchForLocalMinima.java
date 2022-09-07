package com.suansuan.algorithm.array.query;

import com.suansuan.algorithm.array.ArrayUtils;

/**
 * 二分查找 局部最小数相关算法，题目如下所示：
 * 存在一个无序数组且任意两个相邻的的数字是不相等的，
 * 
 * 如果满足 
 * 1、(0 < N < array.length) N-1位置上的数 > N位置上的数 且 N+1位置上的数 > N位置上的数
 * 2、(N = 0) N+1位置上的数 > N位置上的数
 * 3、(N = array.length) N-1位置上的数 > N位置上的数
 * 
 * 我们就称为 N 上的数为该无序数组且任意两个相邻的的数字是不相等的数组中的最小局部数
 * 
 * 思路分析：
 * 1、边界条件为2、3两个点
 * 2、中间的数字通过使用二分法进行比较 最终找到这个数组的局部最小值
 * 
 * @since 2022-09-05
 * @author pengchengliu
 *
 */
public class Algorithm_BinarySearchForLocalMinima {
	/**
	 * 主函数入口。
	 * 
	 * @param args 启动该程序所传递过来的参数，可以是控制台输入。
	 */
	public static void main(String[] args) {
		int maxLength = 100;
		int maxValue = 200;
		int testTime = 1000000;
		System.out.println("测试开始");
		for (int i = 0; i < testTime; i++) {
			int[] array = ArrayUtils.createDisorderAndNotEqualArray(maxLength, maxValue);
			int localMinimaIndex = searchLocalMinimaForArray(array);
			System.out.println("==========");
			ArrayUtils.printlnArray(array);
			System.out.print("局部最小值为：" + localMinimaIndex + ", ");
			if (ArrayUtils.isLocalMinimaForArrayIndex(array, localMinimaIndex)) {
				System.out.println("测试成功");
			} else {
				System.out.println("测试失败");
				break;
			}
		}
		System.out.println("测试结束");
	}
	
	/**
	 * 寻找数组中的最小局部数的下标。
	 * 
	 * @param array 无序数组且任意两个相邻的的数字是不相等的数组。
	 * @return 返回数组中的最小局部数的下标。-1 表示没有找到
	 */
	private static int searchLocalMinimaForArray(int[] array) {
		// 边界条件
		if (array == null || array.length == 0) {
			return -1;
		}
		if (array.length == 1) {
			return 0;
		}
		if (array[0] < array[1]) {
			return 0;
		}
		if (array[array.length - 1] < array[array.length - 2]) {
			return array.length - 1;
		}
		int L = 0;
		int R = array.length - 1;
		while (L < R - 1) {
			int M = (L + R) / 2;
			if (array[M] < array[M - 1] && array[M] < array[M + 1]) {
				return M;
			} else {
				if (array[M] > array[M - 1]) {
					R = M - 1;
				} else {
					L = M + 1;
				}
			}
		}
		return array[L] < array[R] ? L : R;
	}
	
}
