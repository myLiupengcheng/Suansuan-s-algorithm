package com.suansuan.algorithm.sort;

import com.suansuan.algorithm.utils.ArrayUtils;

/**
 * 插入排序相关算法，其主要实现原理如下所示：
 * 假设存在4个无序数字组成的数组，分别[3,2,7,1] 
 * 
 * 第一轮：确认0～0位置上面是有序的
 * 
 * 第二轮：确认0～1位置上面是有序的
 * 1、1位置和0位置进行比较，如果1位置小于0位置，此时数组为：[2,3,7,1] 此时0～1位置上面是有序的
 * 
 * 第二轮：确认0～2位置上面是有序的
 * 1、2位置和1位置进行比较，如果2位置小于1位置，此时数组为：[2,3,7,1] 此时0～1位置上面是有序的
 * 
 * 第三轮：确认0～3位置上面是有序的
 * 1、3位置和2位置进行比较，如果3位置小于2位置，此时数组为：[2,3,1,7]
 * 2、2位置和1位置进行比较，如果2位置小于1位置，此时数组为：[2,1,3,7]
 * 3、1位置和0位置进行比较，如果1位置小于0位置，此时数组为：[1,2,3,7] 此时0～1位置上面是有序的
 * 
 * 通过大的循环来控制整体的循环进行
 * 内侧循环来控制后位置新来的数字，应该在什么位置，这里注意两个终止条件
 * 1、当新来的数字处于0位置时停止
 * 2、当新来的数字大于前面一个位置的时停止。
 * 
 * 我们可以理解外循环给右走，内循环每次左走。
 * 
 * @since 2022-08-31
 * @author pengchengliu
 *
 */
public class Algorithm_InsertSort {

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
		insertSortWithFor(array);
		System.out.print("排序数组：");
		ArrayUtils.printlnArray(array);
		System.out.println("排序后数组是否有序：" + ArrayUtils.isOrderArray(array));
		
		array = ArrayUtils.createDisorderArray(20, 100);
		System.out.print("原始数组：");
		ArrayUtils.printlnArray(array);
		System.out.println("原始数组是否有序：" + ArrayUtils.isOrderArray(array));
		insertSortWithWhile(array);
		System.out.print("排序数组：");
		ArrayUtils.printlnArray(array);
		System.out.println("排序后数组是否有序：" + ArrayUtils.isOrderArray(array));
	}
	
	/**
	 * 插入排序核心算法 - 使用 while 循环实现。
	 * 
	 * @param array 需要排序的数组
	 */
	public static void insertSortWithWhile(int[] array) {
		// 边界条件判断，如果满足，则没有排序的必要
		if (array == null || array.length <= 1) {
			return;
		}
		
		// 由于0～0位置已经是有序的了所以开始 我们从第一个上面开始。
		for (int end = 1; end < array.length; end++) {
			int newEndValueIndex = end;
			while (newEndValueIndex - 1 >= 0 && array[newEndValueIndex - 1] > array[newEndValueIndex]) {
				ArrayUtils.swap(array, newEndValueIndex, newEndValueIndex - 1);
				newEndValueIndex--;
			}
		}
	}
	
	/**
	 * 插入排序核心算法 - 使用 while 循环实现。
	 * 
	 * @param array 需要排序的数组
	 */
	public static void insertSortWithFor(int[] array) {
		// 边界条件判断，如果满足，则没有排序的必要
		if (array == null || array.length <= 1) {
			return;
		}
		
		// 由于 0～0 位置已经是有序的了所以开始 我们从第一个上面开始。
		for (int end = 1; end < array.length; end++) {
			for (int pre = end - 1; pre >= 0 && array[pre] > array[pre + 1]; pre--) {
				ArrayUtils.swap(array, pre, pre + 1);
			}
		}
	}
}
