package com.suansuan.algorithm.sum;

import com.suansuan.algorithm.utils.ArrayUtils;

/**
 * 数组求和类问题拓展，题目如下所示：
 * 存在一个数组Array，给出两个下标值，求出两个下标之间的总和。
 * 例如存在数组[1,3,5,7,9,2,4,6,8],求3到7之间的总和。
 * 
 * 思路分析，3到7位的数字为： 7，9，2，4，6，所以答案为：7 + 9 + 2 + 4 + 6 = 28.
 * 
 * 这里提供三种解法，在不同的约束条件下，以下三种方式都有自己的特点。
 * 1、arrayIndexSummation01 暴力遍历，下标满足条件的数字相加，空间复杂度最小，但是时间复杂度最大。 
 * 2、arrayIndexSummation02 使用二位数组保存相加的值，不利于生成，适合快速查找访问。空间复杂度最大，但是时间复杂度最小。
 * 3、arrayIndexSummation03 使用数组保存相加的值，空间复杂度介于上述两种方式之间，但是时间复杂度介于上述两种方式之间。
 * 
 * 
 * @since 2022-09-03
 * @author pengchengliu
 *
 */
public class Algorithm_ArrayIndexSummation {
	
	/**
	 * 表结构的临时存储变量
	 */
	private static int[][] SUMMATION_TEMP_TABLE = null;
	
	/**
	 * 数组结构的临时存储变量
	 */
	private static int[] SUMMATION_TEMP_ARRAY = null;
	
	/**
	 * 主函数入口
	 * 
	 * @param args 启动该程序所传递过来的参数，可以是控制台输入。
	 */
	public static void main(String[] args) {
		int[] array = ArrayUtils.createDisorderArray(20, 10);
		
//		调试数据
//		int[] array = {2, 6, 10, 5, 9, 3, 1};
		
		System.out.println("原始数组为：");
		ArrayUtils.printlnArray(array);
		
		int left = (int) (Math.random() * array.length);
		int right = (int) (Math.random() * array.length);
		int summation01 = arrayIndexSummation01(array, left, right);
		System.out.println("arrayIndexSummation01 求下标：(" + left + "," + right + ") 的总和为：" + summation01);
	
		int summation02 = arrayIndexSummation02(array, left, right);
		System.out.println("arrayIndexSummation02 求下标：(" + left + "," + right + ") 的总和为：" + summation02);
		
		int summation03 = arrayIndexSummation03(array, left, right);
		System.out.println("arrayIndexSummation03 求下标：(" + left + "," + right + ") 的总和为：" + summation03);
	}
	
	/**
	 * 使用数组保存相加的值，空间复杂度介于上述两种方式之间，但是时间复杂度介于上述两种方式之间。
	 *
	 * @param array 需要遍历的整个数组
	 * @param left 数组当中左边的下标值
	 * @param right 数组当中右边的下标值
	 * @return 两个下标之间的总和
	 */
	public static int arrayIndexSummation03(int[] array, int left, int right) {
		// 数组的边界条件
		if (array == null || left > array.length - 1 || right < 0 || left > right) {
			System.out.println("参数不合法");
			return -1;
		}
		// 右边界条件
		if (left < 0) {
			left = 0;
		}

		// 左边界条件
		if (right > array.length - 1) {
			right = array.length - 1;
		}
		
		//TODO 下面的函数，只在第一次启动调用。
		if (SUMMATION_TEMP_ARRAY == null) {
			SUMMATION_TEMP_ARRAY = generateSummationTempArray(array, left, right);
		}
		
		return left == 0 ? SUMMATION_TEMP_ARRAY[right] : SUMMATION_TEMP_ARRAY[right] - SUMMATION_TEMP_ARRAY[left - 1]; 
	}
	
	/**
	 * 生成以一张专门用于查找的数据总和的数组，只在第一次进行生成，后续不再需要，只要查询直接取表里面的值即可。
	 * 
	 * @param array 需要遍历的整个数组
	 * @param left 数组当中左边的下标值
	 * @param right 数组当中右边的下标值
	 * @return 生成以一张专门用于查找的数据总和的数组
	 */
	private static int[] generateSummationTempArray(int[] array, int left, int right) {
		int length = array.length;
		int[] summationTempArray = new int[length];
		for (int i = 0; i < length; i++) {
			int sum = 0;
			for(int j = 0; j <= i ; j ++) {
				sum+=array[j];
			}
			summationTempArray[i] = sum;
		}
		return summationTempArray;
	}
	
	/**
	 * 使用二位数组保存相加的值，不利于生成，适合快速查找访问。空间复杂度最大，但是时间复杂度最小。
	 * 
	 * @param array 需要遍历的整个数组
	 * @param left 数组当中左边的下标值
	 * @param right 数组当中右边的下标值
	 * @return 两个下标之间的总和
	 */
	public static int arrayIndexSummation02(int[] array, int left, int right) {
		// 数组的边界条件
		if (array == null || left > array.length - 1 || right < 0 || left > right) {
			System.out.println("参数不合法");
			return -1;
		}
		// 右边界条件
		if (left < 0) {
			left = 0;
		}

		// 左边界条件
		if (right > array.length - 1) {
			right = array.length - 1;
		}
		
		//TODO 下面的函数，只在第一次启动调用。
		if (SUMMATION_TEMP_TABLE == null) {
			SUMMATION_TEMP_TABLE = generateSummationTempTable(array, left, right);
		}
		return SUMMATION_TEMP_TABLE[left][right];
	}
	
	/**
	 * 生成以一张专门用于查找的数据表结构，只在第一次进行生成，后续不再需要，只要查询直接取表里面的值即可。
	 * 
	 * @param array 需要遍历的整个数组
	 * @param left 数组当中左边的下标值
	 * @param right 数组当中右边的下标值
	 * @return 生成以一张专门用于查找的数据表结构
	 */
	private static int[][] generateSummationTempTable(int[] array, int left, int right) {
		int length = array.length;
		int[][] summationTempTable = new int[length][length];
		for (int i = 0; i < length; i++) {
			for (int j = i; j < length; j++) {
				summationTempTable[i][j] = arrayIndexSummation01(array, i, j);
			}
		}
		return summationTempTable;
	}
	
	/**
	 * 暴力遍历，下标满足条件的数字相加，空间复杂度最小，但是时间复杂度最大。
	 *
	 * @param array 需要遍历的整个数组
	 * @param left 数组当中左边的下标值
	 * @param right 数组当中右边的下标值
	 * @return 两个下标之间的总和
	 */
	public static int arrayIndexSummation01(int[] array, int left, int right) {
		// 数组的边界条件
		if (array == null || left > array.length - 1 || right < 0 || left > right) {
			System.out.println("参数不合法");
			return -1;
		}

		// 右边界条件
		if (left < 0) {
			left = 0;
		}

		// 左边界条件
		if (right > array.length - 1) {
			right = array.length - 1;
		}

		int summation = 0;
		for (int i = 0; i < array.length; i++) {
			if (i >= left && i <= right) {
				summation += array[i];
			}
		}
		return summation;
	}
}
