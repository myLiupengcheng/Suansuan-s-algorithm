package com.suansuan.algorithm.linked.bean;

import com.suansuan.algorithm.linked.bean.base.Node;

/**
 * 双向链表的节点，主要包含两部分：
 * 1、所表达的值。
 * 2、指向下一个节点的引用。
 * 3、指向上一个节点的引用。
 * 
 * @since 2022-09-07
 * @author pengchengliu
 * @param <T> 当前所表达值的内容。
 *
 */
public class DoubleLinkedNode<T> extends Node {
	/**
	 * 当前节点所表达的值类型。
	 */
	private T mValue;
	
	/**
	 * 当前节点指向下一个节点的引用。如果当前节点为最后一个节点，则该节点为null
	 */
	private DoubleLinkedNode<T> mNext;
	
	/**
	 * 当前节点指向上一个节点的引用。如果当前节点为第一个节点，则该节点为null
	 */
	private DoubleLinkedNode<T> mPrevious;

	public T getValue() {
		return mValue;
	}

	public void setValue(T value) {
		this.mValue = value;
	}

	public DoubleLinkedNode<T> getNext() {
		return mNext;
	}

	public void setNext(DoubleLinkedNode<T> next) {
		this.mNext = next;
	}

	public DoubleLinkedNode<T> getPrevious() {
		return mPrevious;
	}

	public void setPrevious(DoubleLinkedNode<T> previous) {
		this.mPrevious = previous;
	}

	@Override
	public String toString() {
		return "DoubleLinkedNode [mValue=" + mValue + ", mNext=" + mNext + ", mPrevious=" + mPrevious + "]";
	}
	
}
