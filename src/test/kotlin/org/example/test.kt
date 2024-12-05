package org.example

import org.jetbrains.kotlinx.lincheck.annotations.Operation
import org.jetbrains.kotlinx.lincheck.check
import org.jetbrains.kotlinx.lincheck.strategy.managed.modelchecking.ModelCheckingOptions
import org.jetbrains.kotlinx.lincheck.annotations.*
import org.jetbrains.kotlinx.lincheck.strategy.stress.StressOptions
import org.junit.jupiter.api.Test
import java.util.*

class TreiberStackSequentialTest {
    private val stack = TreiberStack<Int>()

    @Operation
    fun add(x: Int) {
        stack.add(x)
    }

    @Operation
    fun remove(): Int? {
        return stack.remove()
    }

    @Test
    fun test() {
        StressOptions()
            .threads(1)
            .check(TreiberStackSequentialTest::class)
    }
}

class TreiberStackTest2 {
    private val stack = TreiberStack<Int>()

    @Operation
    fun add(x: Int) {
        stack.add(x)
    }

    @Operation
    fun remove(): Int? {
        return stack.remove()
    }

    @Test
    fun test() {
        StressOptions()
            .threads(2)
            .check(TreiberStackTest2::class)
    }
}

class TreiberStackTest3 {
    private val stack = TreiberStack<Int>()

    @Operation
    fun add(x: Int) {
        stack.add(x)
    }

    @Operation
    fun remove(): Int? {
        return stack.remove()
    }


    @Test
    fun test() {
        ModelCheckingOptions()
            .check(TreiberStackTest3::class)
    }
}

class TreiberStackTest4 {
    private val stack = TreiberStack<Int>()

    @Operation
    fun add(x: Int) {
        stack.add(x)
    }

    @Operation
    fun remove(): Int? {
        return stack.remove()
    }


    @Test
    fun test() {
        ModelCheckingOptions()
            .checkObstructionFreedom()
            .check(TreiberStackTest4::class)
    }
}

class TreiberStackTest5 {
    private val stack = TreiberStack<Int>()

    @Operation
    fun add(x: Int) {
        stack.add(x)
    }

    @Operation
    fun remove(): Int? {
        return stack.remove()
    }

    @Test
    fun test() {
        StressOptions()
            .threads(4)
            .iterations(20)
            .invocationsPerIteration(1000)
            .check(TreiberStackTest5::class)
    }
}

class TreiberStackTest6 {
    private val stack = TreiberStack<Int>()

    @Operation
    fun add(x: Int) {
        stack.add(x)
    }

    @Operation
    fun remove(): Int? {
        return stack.remove()
    }

    @Test
    fun test() {
        ModelCheckingOptions()
            .checkObstructionFreedom()
            .check(TreiberStackTest6::class)
    }
}