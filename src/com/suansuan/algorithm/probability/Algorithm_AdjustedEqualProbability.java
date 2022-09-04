package com.suansuan.algorithm.probability;

/**
 * <p>调整概率，题目如下所示：假设存在一个库函数，可以固定概率获取 0 和 1 。</br>
 * 注意：获取到 0 和 1 的概率不是相等的，现在需要设计一个函数，可以将获取 1 和 0 的概率获取均等的。</br>
 * 
 * 思路分析:
 * <li>假设库函数获取 0 的概率为 P 那么获取到 1 的概率就是 （ 1 - P ）。</li>
 * <li>连续调用两次库的函数，获取到的结果以及所需要的概率如下所示：</li> </p>

 * 
 * <table border="1">
 * 	<tr>
 * 		<th>第一次</th>
 * 		<th>第二次</th>
 * 		<th>概率</th>
 * 	</tr>
 * 	<tr>
 * 		<td>0</td>
 * 		<td>0</td>
 * 		<td>P^2</td>
 * 	</tr>
 * 	<tr>
 * 		<td>1</td>
 * 		<td>1</td>
 * 		<td>(1-P)^2</td>
 * 	</tr>
 * 	<tr>
 * 		<td>0</td>
 * 		<td>1</td>
 * 		<td> P * (1 - P)</td>
 * 	</tr>
 * 	<tr>
 * 		<td>1</td>
 * 		<td>0</td>
 * 		<td> P * (1 - P)</td>
 * 	</tr>
 * </table>
 * 
 * 通过上述表格可以看出，当两次获取的值不相等的时候，得到的概率是相等的，通过该方式则可以让两次概率相等
 * 
 * @since 2022-09-02
 * @author pengchengliu
 *
 */
public class Algorithm_AdjustedEqualProbability {
	
	/**
	 * 主函数入口
	 * 
	 * @param args 启动该程序所传递过来的参数，可以是控制台输入。
	 */
	public static void main(String[] args) {
		// 首先验证原始函数是否和题目所说一致。
		testrandom1And0NotEqual();
		
		// 可以看出库里面的函数获取到的 0 和 1 的概率不是相等的，并且概率是一定的。
		System.out.println("=========================");
		
		// 通过如下方法函数进行改造后的测试。
		testrandom1And0Equal();
	}

	/**
	 * 验证原始函数每一个数字出现的次数，通过观看每个数字出现的大体次数
	 * 可以得到相关的每个数字的大体概率。
	 */
	private static void testrandom1And0NotEqual() {
		int testCount = 10000000;
		int[] valueCount = new int[2];
		for (int i = 0; i < testCount; i++) {
			int randomResult = random1And0NotEqual();
			valueCount[randomResult]++;
		}
		for (int i = 0; i < valueCount.length; i++) {
			System.out.println("数字 " + i + "一共出现了 " + valueCount[i] + " 次");
		}
	}
	
	/**
	 * 验证原始函数每一个数字出现的次数，通过观看每个数字出现的大体次数
	 * 可以得到相关的每个数字的大体概率。
	 */
	private static void testrandom1And0Equal() {
		int testCount = 10000000;
		int[] valueCount = new int[2];
		for (int i = 0; i < testCount; i++) {
			int randomResult = random1And0Equal();
			valueCount[randomResult]++;
		}
		for (int i = 0; i < valueCount.length; i++) {
			System.out.println("数字 " + i + "一共出现了 " + valueCount[i] + " 次");
		}
	}
	
	private static int random1And0Equal() {
		int result01;
		int result02;
		do {
			result01 = random1And0NotEqual();
			result02 = random1And0NotEqual();
		} while (result01 == result02);
		return result01;
	}
	
	/**
	 * 库里面的函数，无法进行修改，只能对其进行改造(只能被调用)。
	 *
	 * @return 返回 0 1 之间的随机，且每个数字获取的概率都不是一致的。
	 */
	private static int random1And0NotEqual() {
		return ((int) (Math.random() * 10)) > 8 ? 1 : 0;
	}
}
