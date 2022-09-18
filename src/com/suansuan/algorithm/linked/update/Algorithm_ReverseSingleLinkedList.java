package com.suansuan.algorithm.linked.update;

import com.suansuan.algorithm.linked.LinkedListUtils;
import com.suansuan.algorithm.linked.bean.SingleNode;

/**
 * 单链表的反转算法，具体题目如下所示：
 * 存在一个单链表，将链表内容全部进行反转，例如存在如下单链表
 * 
 * 1、输入 [1 -> 2 -> 3 -> 6 -> 7 -> 4 -> 8]
 * 2、输出 [8 -> 4 -> 7 -> 6 -> 3 -> 2 -> 1]
 * 
 * 具体思路：
 * 
 * 1、使用两个指针（引用）来记录前一个值或者后一个值
 * 2、注意一下Java当中的引用传递的特效即可。具体实现请参照 reverseSingleLinkedList函数的实现。
 * 
 * 打印结果为：
 * 
 * 原输入单链表如下所示：
 * [header -> 7 -> 5 -> 7 -> 9 -> 2 -> 0]
 * 反转后的单链表如下所示：
 * [header -> 0 -> 2 -> 9 -> 7 -> 5 -> 7]
 * 
 * 原输入单链表如下所示：
 * [header -> 1 -> 3 -> 4 -> 3 -> 7 -> 2 -> 1 -> 4 -> 9]
 * 反转后的单链表如下所示：
 * [header -> 9 -> 4 -> 1 -> 2 -> 7 -> 3 -> 4 -> 3 -> 1]
 * 
 * 
 * @since 2022-09-10
 * @author pengchengliu
 *
 */
public class Algorithm_ReverseSingleLinkedList {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SingleNode<Integer> HEAD = LinkedListUtils.createDisorderSingleLinkedList(10,10);
		System.out.println("原输入单链表如下所示：");
		LinkedListUtils.println(HEAD);
		System.out.println("反转后的单链表如下所示：");
		HEAD.next = reverseSingleLinkedList(HEAD);
		LinkedListUtils.println(HEAD);
	}
	
	/**
	 * 存在一个单链表，将链表内容全部进行反转
	 * 
	 * @return 将链表内容全部进行反转以后的第一个Node进行返回。
	 */
	public static SingleNode<Integer> reverseSingleLinkedList(SingleNode<Integer> header) {
		// 边界条件的判断
		if (header == null || header.next == null) {
			return header;
		}

		SingleNode<Integer> preNode = null;
		SingleNode<Integer> nextNode = null;
		header = header.next;
		do {
			nextNode = header.next;
			header.next = preNode;
			preNode = header;
			header = nextNode;
		} while (header != null);
		return preNode;
	}
}
