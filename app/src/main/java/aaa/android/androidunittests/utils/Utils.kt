package aaa.android.androidunittests.utils

object Utils {

    fun addTheValues(inputOne: String, inputTwo: String): String {
        return (inputOne.toFloat() + inputTwo.toFloat()).toString()
    }

    fun minusTheValues(inputOne: String, inputTwo: String): String {
        return (inputOne.toFloat() - inputTwo.toFloat()).toString()
    }

    fun multiplyTheValues(inputOne: String, inputTwo: String): String {
        return (inputOne.toFloat() * inputTwo.toFloat()).toString()
    }

    fun divideTheValues(inputOne: String, inputTwo: String): String {
        return (inputOne.toFloat() / inputTwo.toFloat()).toString()
    }


}