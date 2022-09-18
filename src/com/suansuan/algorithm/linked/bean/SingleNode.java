package com.suansuan.algorithm.linked.bean;

import com.suansuan.algorithm.linked.bean.base.Node;

/**
 * 单链表的节点，主要包含两部分：
 * 1、所表达的值。
 * 2、指向下一个节点的引用。
 * 
 * @since 2022-09-07
 * @author pengchengliu
 *
 */
public class SingleNode<T> extends Node {
	/**
	 * 当前节点所表达的值类型。
	 */
	public T value;
	
	/**
	 * 当前节点指向下一个节点的引用。如果当前节点为最后一个节点，则该节点为null
	 */
	public SingleNode<T> next;
	
	public SingleNode(T value) {
		this.value = value;
	}
	
	
	public T value() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public SingleNode<T> next() {
		return next;
	}

	public void setNext(SingleNode<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "SingleLinkedNode [mValue=" + value + ", mNext=" + next + "]";
	}
}
