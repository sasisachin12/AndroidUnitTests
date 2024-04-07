package aaa.android.androidunittests.utils

import org.junit.Assert.*

import org.junit.Test


class UtilsTest {

    @Test
    fun addTheValues() {
        val result = Utils.addTheValues("10", "30")
        assertEquals(40.0f, result.toFloat())
    }

    @Test
    fun minusTheValues() {
        val result = Utils.minusTheValues("45", "25")
        assertEquals(20.0f, result.toFloat())
    }

    @Test
    fun multiplyTheValues() {
        val result = Utils.multiplyTheValues("5", "25")
        assertEquals(125.0f, result.toFloat())
    }

    @Test
    fun divideTheValues() {
        val result = Utils.divideTheValues("25", "5")
        assertEquals(5.0f, result.toFloat())
    }
}