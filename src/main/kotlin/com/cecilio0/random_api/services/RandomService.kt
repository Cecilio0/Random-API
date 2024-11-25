package com.cecilio0.random_api.services

import com.cecilio0.random_api.utils.factorial
import org.springframework.stereotype.Service
import java.math.BigInteger
import kotlin.random.Random

@Service
class RandomService {

    fun getRandomNumber(rangeStart: Int, rangeEnd: Int): Int {
        if(rangeStart >= rangeEnd)
            throw IllegalArgumentException("Range start must be strictly lower than range end")

        return Random.nextInt(from = rangeStart, until = rangeEnd)
    }

    fun getRandomPermutation(size: Int): List<Int> {
        if (size < 1)
            throw IllegalArgumentException("A permutation must have at least size 1")

        val permutation: MutableList<Int> = mutableListOf()

        permutation.add(Random.nextInt(size))
        while (permutation.size < size) {
            var number: Int = Random.nextInt(size)
            while (permutation.contains(number)) {
                number = Random.nextInt(size)
            }
            permutation.add(number)
        }

        return permutation
    }

    fun getNRandomPermutations(n: Int, size: Int): List<List<Int>> {

        if (factorial(size) < BigInteger.valueOf(n.toLong()))
            throw IllegalArgumentException("There are not $n permutations for size $size")

        val permutations: MutableList<List<Int>> = mutableListOf()

        permutations.add(getRandomPermutation(size))

        var i = 1
        while (i < n) {
            var tempPermutation: List<Int> = getRandomPermutation(size)
            while (tempPermutation in permutations) {
                tempPermutation = getRandomPermutation(size)
            }
            permutations.add(tempPermutation)
            i++
        }

        return permutations
    }
}