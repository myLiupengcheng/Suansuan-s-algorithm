package com.suansuan.algorithm.array;

/**
 * 算法数组必备工具-对数器
 * 数据常用工具类型，算法必备。包含生成随机数组，以及判断当前的数组是否是有序的。
 * 
 * @since 2022-08-31
 * @author suansuanliu
 *
 */
public class ArrayUtils {
	
	/**
	 * 主函数入口
	 * 
	 * @param args 启动该程序所传递过来的参数，可以是控制台输入。
	 */
	public static void main(String[] args) {
		System.out.println("测试无序数组：");
		testCretaeDisorderArray();
		System.out.println("测试有序数组：");
		testCretaeOrderArray();
	}
	
	/**
	 * 判断当前的数组是否有序的。
	 * 
	 * @param array 需要判断的数组
	 * @return true：代表当前数组是有序的，false：代表当前数组是无序的。
	 */
	public static boolean isOrderArray(int[] array) {
		// 当前参数合法性检查
		if (array == null) {
			return false;
		}
		
		// 边界条件
		if (array.length < 2) {
			return true;
		}
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i+1]) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 判断当前数组的下标位置是否是该数组的局部最小值。
	 *
	 * @param array 需要判断的数组。
	 * @param localMinimaIndex 需要判断数组当中的局部最小值的下标位置。
	 * @return true 表示当前下标位置确实是该数组的局部最小值的位置。
	 */
	public static boolean isLocalMinimaForArrayIndex(int [] array, int localMinimaIndex) {
		// 验证参数合法性		
		if (array == null || array.length == 0) {
			return localMinimaIndex == -1;
		}
		
		if (array.length == 1) {
			return localMinimaIndex == 0;
		}
		
		int leftIndex = localMinimaIndex - 1;
		int rightIndex = localMinimaIndex + 1;
		
		if (leftIndex < 0) {
			return array[localMinimaIndex] < array[rightIndex];
		} else if (rightIndex > array.length - 1) {
			return array[localMinimaIndex] < array[leftIndex];
		} else {
			return array[localMinimaIndex] < array[rightIndex] && array[localMinimaIndex] < array[leftIndex];
		}
	}
	
	/**
	 * 创建一个无序的随机数组，用来测试数组的局部最小值，所以生成的数组必须是无序且相邻两个数字之间不相等
	 *
	 * @param maxLength 无序随机数组最大的长度。
	 * @param maxValue 无序随机数组中单个数值的最大值。
	 * @return 返回无序且相邻两个数字之间不相等的数组。
	 */
	public static int[] createDisorderAndNotEqualArray(int maxLength, int maxValue) {
		int arrayLength = (int) (Math.random() * maxLength);
		int[] array = new int[arrayLength];
		if (arrayLength <= 0) {
			return array;
		}
		array[0] = (int) (Math.random() * maxValue);
		for (int i = 1; i < arrayLength; i++) {
			do {
				array[i] = (int) (Math.random() * maxValue);
			} while (array[i - 1] == array[i]);
		}
		return array;
	}
	
	/**
	 * 生成一个有序的数组，因为要生成有序的数组，所以关于数组的最大值就不会再做任何限制。
	 * 
	 * @param maxLength 无序随机数组最大的长度。
	 * @return 返回一个有序的随机数组。
	 */
	public static int[] cretaeOrderArray(int maxLength) {
		int arrayLength = (int) (Math.random() * maxLength) + 1;
		int[] array = new int[arrayLength];
		int preVaule = 0;
		for (int i = 0; i < arrayLength; i++) {
			preVaule = (int) (Math.random() * 10) + preVaule;
			array[i] = preVaule;
		}
		return array;
	}
	
	/**
	 * 创建一个无序的随机数组，用来测试排序，或者其他算法是否正常。
	 * 
	 * @param maxLength 无序随机数组最大的长度。
	 * @param maxValue 无序随机数组中单个数值的最大值。
	 * @return 返回一个无序的随机数组。
	 */
	public static int[] createDisorderArray(int maxLength, int maxValue) {
		int arrayLength = (int) (Math.random() * maxLength) + 1;
		int[] array = new int[arrayLength];
		for (int i = 0; i < arrayLength; i++) {
			array[i] = (int) (Math.random() * maxValue) + 1;
		}
		return array;
	}

	/**
	 * 打印 int 类型的数组值。具体打印格式如下所示： [ x, x, x, x, x ]
	 * 
	 * @param array
	 */
	public static void printlnArray(int[] array) {
		// 边界条件判断
		if (array == null) {
			System.out.println("null");
			return;
		}
		
		if (array.length <= 0) {
			System.out.println("[ ]");
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
	
	/**
	 * 测试创建的数组是否为有序数组。
	 */
	private static void testCretaeOrderArray() {
		for(int i = 0; i < 10; i++) {
			int[] disorderArray = cretaeOrderArray(15);
			printlnArray(disorderArray);
		}
	}
	
	/**
	 * 测试创建的数组是否为无序数组。
	 */
	private static void testCretaeDisorderArray() {
		for(int i = 0; i < 10; i++) {
			int[] disorderArray = createDisorderArray(10, 10);
			printlnArray(disorderArray);
		}
	}
}
