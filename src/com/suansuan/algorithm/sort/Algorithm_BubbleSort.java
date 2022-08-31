package com.suansuan.algorithm.sort;

import com.suansuan.algorithm.utils.ArrayUtils;

/**
 * 冒泡排序相关算法，其主要原理为：
 * 从开始两两比较，然后将比较结果较大的一方向后位置移动，当最大的数移动到最后面的时候，从前面继续开始比较，这不过这次到倒数第二个结束。
 * 假设存在4个无序数字组成的数组，分别 [3,2,7,1] 
 * 
 * 第一轮 在 0～3 位置进行交换
 * 1、将0位置和1位置进行比较，此时的数组位 [2,3,7,1] 
 * 2、将1位置和2位置进行比较，此时的数组位 [2,3,7,1] 
 * 3、将2位置和3位置进行比较，此时的数组位 [2,3,1,7] 
 * 
 * 第二轮 在 0～2 位置进行交换
 * 1、将0位置和1位置进行比较，此时的数组位 [2,3,1,7] 
 * 2、将1位置和2位置进行比较，此时的数组位 [2,1,3,7] 
 * 
 * 第三轮 在 0～1 位置进行交换
 * 1、将0位置和1位置进行比较，此时的数组位 [1,2,3,7] 
 * 
 * 至此交换结束，排序完成
 * 
 * 算法设计，首先将数组长度抽象位 N + 1，那么位置位0～N
 * 其次关注外层控制循环的遍历为 
 * 0 ～ N
 * 0 ～ N - 1
 * 0 ～ N - 2
 * 
 * 内部循环则在外部循环的基础之上循环即可，具体实现细节请参照如下 bubbleSort 方法的实现即可
 * 
 * @since 2020-08-31
 * @author pengchengliu
 *
 */
public class Algorithm_BubbleSort {

	/**
	 * 主函数入口
	 * 
	 * @param args 启动该程序所传递过来的参数，可以是控制台输入。
	 */
	public static void main(String[] args) {
		System.out.print("原始数组：");
		ArrayUtils.printlnArray(ArrayUtils.ARRAY);
		bubbleSort(ArrayUtils.ARRAY);
		System.out.print("排序数组：");
		ArrayUtils.printlnArray(ArrayUtils.ARRAY);
	}
	
	/**
	 * 冒泡排序核心算法。
	 * 
	 * @param array 需要排序的数组。
	 */
	private static void bubbleSort(int[] array) {
		// 边界条件,没有排序的必要性
		if (array == null || array.length <= 1) {
			return;
		}
		
		// 外层循环控制整体的遍历次数，从最后开始，因为最后都是上次比较大的值。
		for (int i = array.length - 1; i > 0; i--) {
			
			// 内层循环控制本次遍历将最大的值移动到最后一位。
			for (int j = 0; j < i; j++) {
				if (array[j] > array[j + 1]) {
					// TODO 感觉交换的频率有点高。
					ArrayUtils.swap(array, j, j + 1);
				}
			}
		}
	}
}




