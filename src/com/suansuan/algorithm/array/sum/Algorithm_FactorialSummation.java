package com.suansuan.algorithm.array.sum;

/**
 * 题目：给定一个数，求该数之前所有相邻的数阶乘总和。
 * 例如，给定数字5，则为 1！+ 2！+ 3！+ 4！+ 5！
 * 例如，给定数字N，则为 1！+ 2！+ 3！+ 4！+ 5！+ ... + (N - 1)! + N!
 * 
 * @since 2022-09-01
 * @author pengchengliu
 *
 */
public class Algorithm_FactorialSummation {
	
	private static final int VALUE = 10;
	
	/**
	 * 主函数入口
	 * 
	 * @param args 启动该程序所传递过来的参数，可以是控制台输入。
	 */
	public static void main(String[] args) {
		System.out.println("给定数字为：" + VALUE);
		int result01 = factorialSum01(VALUE);
		System.out.println("该数字之前的阶乘结果为：" + result01);
		
		System.out.println("给定数字为：" + VALUE);
		int result02 = factorialSum02(VALUE);
		System.out.println("该数字之前的阶乘结果为：" + result02);
	}
	
	/**
	 * 通过两个循环进行控制并且计算，
	 * 外部的循环主要做相加的操作，
	 * 内部的循环主要做相乘的操作。
	 * 
	 * @param value 给定的数值，用来计算相关的阶乘
	 * @return 计算完成后的结果
	 */
	private static int factorialSum02(int valueSize) {
		// 边界条件判断
		if (valueSize < 1) {
			return -1;
		}
		int summation = 0;
		int currentFactorial = 1;
		for(int i = 1; i <= valueSize; i++) {
			currentFactorial = currentFactorial * i;
			// 将所有的阶乘进行相加
			summation+=currentFactorial;
		}
		return summation;
	}
	
	/**
	 * 通过两个循环进行控制并且计算，
	 * 外部的循环主要做相加的操作，
	 * 内部的循环主要做相乘的操作。
	 * 
	 * @param value 给定的数值，用来计算相关的阶乘
	 * @return 计算完成后的结果
	 */
	private static int factorialSum01(int valueSize) {
		// 边界条件判断
		if (valueSize < 1) {
			return -1;
		}
		int summation = 0;
		for(int i = 1; i <= valueSize; i++) {
			int factorial = 1;
			
			// 求单个数字的阶乘
			for(int j = 1; j <= i; j++) {
				factorial *= j;
			}
			
			// 将所有的阶乘进行相加
			summation+=factorial;
		}
		return summation;
	}

}
