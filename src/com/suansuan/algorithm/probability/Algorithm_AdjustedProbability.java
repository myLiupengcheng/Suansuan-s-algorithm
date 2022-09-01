package com.suansuan.algorithm.probability;

/**
 * 调整概率相关的算法实践，题目如下所示：
 * 假设存在一个库函数 random1To5，可以获取1~5之间的随机数，且1到5之间数字获取的概率是一样的。
 * 现在要求对库函数进行改造 (无法对库函数里面的逻辑进行修改)，改造成为可以获取到11~18随机数，且每个数字出现的概率是一样的函数 random11To18。
 * 
 * 思路解析：
 * 1、将原来的函数 random1To5，能否进行分解，分解成为获取 0，1均等概率的，随机因子发生器。
 * 2、如何通过随机因子发生器来表示 0~8上面的均等概率
 * 3、如何将0~8上面的均等概率表示成为1~8上面的均等概率呢。
 * 4、如何将1~8上面的均等概率表示成为11~18上面的均等概率呢。
 * 
 * 具体的实现思路如下所示：
 * 
 * @since 2020-09-01
 * @author pengchengliu
 *
 */
public class Algorithm_AdjustedProbability {
	/**
	 * 主函数入口
	 * 
	 * @param args 启动该程序所传递过来的参数，可以是控制台输入。
	 */
	public static void main(String[] args) {
		// 首先验证原始函数是否和题目所说一致。
		testRandom1To5(10);
		System.out.println("=========================");
		// 通过如下方法函数进行改造后的测试。
		testRandom11To18(20);
	}
	
	/**
	 * 验证原始函数每一个数字出现的次数，通过观看每个数字出现的大体次数
	 * 可以得到相关的每个数字的大体概率。
	 * 
	 * @param number 生成随机数的个数，因为要通过数组进行打印。
	 */
	private static void testRandom1To5(int number) {
		int testCount = 1000000;
		int[] valueCount = new int[number + 1];
		for (int i = 0; i < testCount; i++) {
			int randomResult = random1To5();
			valueCount[randomResult]++;
		}
		for (int i = 0; i < valueCount.length; i++) {
			System.out.println("数字 " + i + "一共出现了 " + valueCount[i] + " 次");
		}
	}
	
	/**
	 * 验证原始函数每一个数字出现的次数，通过观看每个数字出现的大体次数
	 * 可以得到相关的每个数字的大体概率。
	 * 
	 * @param number 生成随机数的个数，因为要通过数组进行打印。
	 */
	private static void testRandom11To18(int number) {
		int testCount = 1000000;
		int[] valueCount = new int[number + 1];
		for (int i = 0; i < testCount; i++) {
			int randomResult = random11To18();
			valueCount[randomResult]++;
		}
		for (int i = 0; i < valueCount.length; i++) {
			System.out.println("数字 " + i + "一共出现了 " + valueCount[i] + " 次");
		}
	}
	
	/**
	 * 获取10~18上面的随机，且每个数字的概率都是均等的。
	 * 
	 * @return 获取10~18上面的随机，且每个数字的概率都是均等的。
	 */
	private static int random11To18() {
		return random1To8() + 10;
	}
	
	/**
	 * 将只能返回0 和 1 的随机因子方法，通过二进制的形式进行编排。
	 * 获取0~8的数字为，4个二进制位，所以获取四次，然后其余不满足的情况重新获取。
	 * 
	 * @return 获取相关0~8上面的随机数。
	 */
	private static int random1To8() {
		int result;
		do {
			result = (random0To1() << 3) + (random0To1() << 2) + (random0To1() << 1) + (random0To1() << 0);
		} while (result > 8 || result == 0);
		return result;
	}
	
	/**
	 * 将库函数 random1To5 进行改造，改造成为只能均等返回 0 和 1 的随机因子方法。
	 * 具体思路如下所示：
	 * 通过 random1To5 函数获取随机数字。
	 * 如果获取到 1，2 该方法就返回 0
	 * 如果获取到 4，5 该方法就返回 1
	 * 如果获取到 3，则就重来，直到随机出上述的情况，
	 * 这样一来相当于获取3的概率均等的分到了上述两种情况当中。
	 * 
	 * @return 只能均等返回 0 和 1 的随机因子。
	 */
	private static int random0To1() {
		int result;
		do {
			result = random1To5();
		} while (result == 3);
		return result > 3 ? 1 : 0;
	}
	
	/**
	 * 库里面的函数，无法进行修改，只能对其进行改造(只能被调用)。
	 *
	 * @return 返回 1~5 之间的随机，且每个数字获取的概率都是一致的。
	 */
	private static int random1To5() {
		return (int) (Math.random() * 5) + 1;
	}
}
