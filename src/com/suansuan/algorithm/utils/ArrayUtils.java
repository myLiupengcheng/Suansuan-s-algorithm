package com.suansuan.algorithm.utils;

/**
 * 算法数组必备工具-对数器
 * 数据常用工具类型，算法必备。包含生成随机数组，以及判断当前的数组是否是有序的。
 * 
 * @since 2020-08-31
 * @author suansuanliu
 *
 */
public class ArrayUtils {

	/**
	 * 被测试数据
	 */
	public static final int[] ARRAY = { 8, 3, 5, 7, 3, 1, 3, 5, 10, 32, 44, 14, 15, 63, 12, 5, 6, 2, -1, -49, 0, 12 };

	/**
	 * 打印 int 类型的数组值。具体打印格式如下所示： [ x, x, x, x, x ]
	 * 
	 * @param array
	 */
	public static void printlnArray(int[] array) {
		// 边界条件判断
		if (array == null || array.length <= 0) {
			return;
		}
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			String arrayString = i == array.length - 1 ? array[i] + "" : array[i] + ", ";
			System.out.print(arrayString);
		}
		System.out.println("]");
	}

	/**
	 * 数组交换所使用的方法，给定两个位置，将两个位置里面的值进行交换
	 * 
	 * @param array 所需要交换的数组对象
	 * @param a     所需要交换数组的下标位置
	 * @param b     所需要交换数组的下标位置
	 */
	public static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
