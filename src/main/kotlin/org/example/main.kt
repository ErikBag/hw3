package org.example

import java.util.concurrent.atomic.AtomicReference



class TreiberStack <T> {
    private val headRef = AtomicReference<StackNode<T>?>(null)

    private class StackNode<T>(val item: T, var nextNode: StackNode<T>? = null)

    fun add(item: T) {
        val newNode = StackNode(item)
        while (true) {
            val currentHead = headRef.get()
            newNode.nextNode = currentHead
            if (headRef.compareAndSet(currentHead, newNode)) {
                return
            }
        }
    }

    fun remove(): T? {
        while (true) {
            val currentHead = headRef.get() ?: return null
            val nextHead = currentHead.nextNode
            if (headRef.compareAndSet(currentHead, nextHead)) {
                return currentHead.item
            }
        }
    }
}
