package com.cecilio0.random_api.controllers

import com.cecilio0.random_api.services.RandomService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/random")
class RandomController(private val randomService: RandomService) {

    @GetMapping("/range")
    fun getRandomNumber(@RequestParam(name = "rangeStart") rangeStart: Int, @RequestParam(name = "rangeEnd") rangeEnd: Int): ResponseEntity<Int> {
        return ResponseEntity.ok(randomService.getRandomNumber(rangeStart, rangeEnd))
    }

    @GetMapping("/permutation")
    fun getRandomPermutation(@RequestParam(name = "size") size: Int): ResponseEntity<List<Int>> {
        return ResponseEntity.ok(randomService.getRandomPermutation(size))
    }

    @GetMapping("/permutations")
    fun getNRandomPermutations(@RequestParam(name = "n") n: Int, @RequestParam(name = "size") size: Int): ResponseEntity<List<List<Int>>> {
        return ResponseEntity.ok(randomService.getNRandomPermutations(n, size))
    }

}