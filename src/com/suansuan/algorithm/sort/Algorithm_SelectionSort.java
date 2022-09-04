package com.suansuan.algorithm.sort;

import com.suansuan.algorithm.utils.ArrayUtils;

/**
 * 选择排序相关算法，主要使用原理如下所示： 
 * 1、假设存在4个无序数字组成的数组，分别[3,2,7,1] 
 * 2、从 0～3 的位置上面找到一个最小的数字，将该数字放置到第 0 位上面,比如找到就是 1，将 1 这个数字放置到 0 的位置上面 
 * 3、从 1～3 的位置上面找到一个最小的数字，将该数字放置到第 1 位上面,比如找到就是 2，将 2 这个数字放置到 1 的位置上面 
 * 4、从 2～3 的位置上面找到一个最小的数字，将该数字放置到第 2 位上面,比如找到就是 3，将 3 这个数字放置到 2 的位置上面 
 * 5、从 3～3 的位置上面找到一个最小的数字，将该数字放置到第 3 位上面,比如找到就是 7，将 7 这个数字放置到 3 的位置上面
 *  . . .
 *  
 * 以此进行类推，假如现在有一个N长度的无序数组使用选择排序，则就是 0～N 找到最小放置在 0 位 
 * 
 * 1～N 找到最小放置在 1 位 
 * 2～N 找到最小放置在 2 位 
 * N～N 找到最小放置在 N 位
 * 
 * 具体实现细节请参照如下 selectionSort 方法的实现即可
 * 
 * 
 * @since 2022-08-31
 * @author pengchengliu
 *
 */
public class Algorithm_SelectionSort {

	/**
	 * 主函数入口
	 * 
	 * @param args 启动该程序所传递过来的参数，可以是控制台输入。
	 */
	public static void main(String[] args) {
		int[] array = ArrayUtils.createDisorderArray(20, 100);
		System.out.print("原始数组：");
		ArrayUtils.printlnArray(array);
		System.out.println("原始数组是否有序：" + ArrayUtils.isOrderArray(array));
		selectionSort(array);
		System.out.print("排序数组：");
		ArrayUtils.printlnArray(array);
		System.out.println("排序后数组是否有序：" + ArrayUtils.isOrderArray(array));
	}

	/**
	 * 选择排序核心算法。
	 * 
	 * @param array 需要排序的数组
	 */
	private static void selectionSort(int[] array) {
		// 边界条件判断
		if (array == null || array.length <= 1) {
			return;
		}

		// 最外侧的循环来控制整体的打大循环
		for (int i = 0; i < array.length; i++) {
			int minValueIndex = i;

			// 内侧循环负责找到最小值的位置，然后拿到最小值的位置和该循环开始前面的一个数进行交换。
			for (int j = i + 1; j < array.length; j++) {
				// 将最小值的位置和新来的数字做比较。如果小了就更新记录的最小值，然后重复上述操作。
				minValueIndex = array[j] < array[minValueIndex] ? j : minValueIndex;
			}
			ArrayUtils.swap(array, i, minValueIndex);
		}
	}
}
