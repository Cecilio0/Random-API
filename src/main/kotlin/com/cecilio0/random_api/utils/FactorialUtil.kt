package com.cecilio0.random_api.utils

import java.math.BigInteger

class FactorialUtil {
    fun factorial (n: Int): Long {
        if (n < 0)
            throw IllegalArgumentException("Can not get factorial of negative number")

        if (n == 0)
            return 0


        var fact: Long = 1
        for (i in 2..n)
            fact *= i

        return fact
    }
}

fun factorial (n: Int): BigInteger {
    if (n < 0)
        throw IllegalArgumentException("Can not get factorial of negative number")

    if (n == 0)
        return BigInteger.ZERO


    var fact: BigInteger = BigInteger.ONE
    for (i in 2..n){
        fact = fact.multiply(BigInteger.valueOf(i.toLong()))
    }

    return fact
}