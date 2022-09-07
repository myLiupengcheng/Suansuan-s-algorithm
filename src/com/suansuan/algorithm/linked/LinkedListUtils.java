package com.suansuan.algorithm.linked;

import com.suansuan.algorithm.linked.bean.SingleLinkedNode;

/**
 * 算法数组必备工具 - 链表的对数器
 * 数据常用工具类型，算法必备。包含生成随机单链表，双链表，以及判断当前的单双链表是否是有序的。
 * 
 * @since 2022-09-07
 * @author suansuanliu
 *
 */
public class LinkedListUtils {
	
	/**
	 * 主函数入口
	 * 
	 * @param args 启动该程序所传递过来的参数，可以是控制台输入。
	 */
	public static void main(String[] args) {
		SingleLinkedNode<Integer> HEAD = createDisorderSingleLinkedList(10,10);
		System.out.println("======");
		println(HEAD);
	}
	
	/**
	 * 生成一个无序的单链表，链表内部填充的是 Integer 类型的数字。
	 * 
	 * @param maxValue 单个 Integer 类型的数字的最大值。
	 * @param maxLength 整个链表的最大长度（由于长度随机，所以该链表的长度绝对不会超过这个数值）。
	 * @return 一个无序的单链表，链表内部填充的是 Integer 类型的数字。一个无序的单链表，链表内部填充的是 Integer 类型的数字。
	 */
	public static SingleLinkedNode<Integer> createDisorderSingleLinkedList(int maxValue, int maxLength) {
		int length = (int) (Math.random() * maxLength);
		System.out.println("length = " + length);
		SingleLinkedNode<Integer> header = new SingleLinkedNode<Integer>(null);
		SingleLinkedNode<Integer> preNode = header;
		for (int i = 0; i < length; i++) {
			int result01 = (int) (Math.random() * maxValue);
			SingleLinkedNode<Integer> currentNode = new SingleLinkedNode<Integer>(result01);
			System.out.println("i = " + i + ", result = " + result01);
			preNode.setNext(currentNode);
			preNode = currentNode;
		}
		return header;
	}

	/**
	 * 打印 T 类型的数组值。具体打印格式如下所示： [ x, x, x, x, x ]
	 * @param <T>
	 * 
	 * @param array
	 */
	public static <T> void println(SingleLinkedNode<T> header) {
		// 边界条件判断
		if (header == null) {
			System.out.println("null");
			return;
		}
		
		if (header.next() == null) {
			System.out.println("[ ]");
			return;
		}
		
		System.out.print("[");
		while (header.next() != null) {
			if (header.value() == null) {
				System.out.print("header");
			} else {
				System.out.print(" -> " + header.value());
			}
			header = header.next();
		}
		System.out.print(" -> " + header.value());
		System.out.println("]");
	}

}
