package leetcodecrashcourse

/**
 * You are given a 0-indexed array nums of n integers, and an integer k.
 *
 * The k-radius average for a subarray of nums centered at some index i with the radius k is the average of all elements in nums between the indices i - k and i + k (inclusive). If there are less than k elements before or after the index i, then the k-radius average is -1.
 *
 * Build and return an array avgs of length n where avgs[i] is the k-radius average for the subarray centered at index i.
 *
 * The average of x elements is the sum of the x elements divided by x, using integer division. The integer division truncates toward zero, which means losing its fractional part.
 *
 * For example, the average of four elements 2, 3, 1, and 5 is (2 + 3 + 1 + 5) / 4 = 11 / 4 = 2.75, which truncates to 2.
 */


fun getAverages(nums: IntArray, k: Int): IntArray {
    val result = IntArray(nums.size)
    val partialSums = LongArray(nums.size)

    if (nums.isEmpty()) return result

    partialSums[0] = nums[0].toLong()
    for (i in 1 until nums.size) {
        partialSums[i] = partialSums[i - 1] + nums[i]
    }

    var index = 0
    //fill the positions with less than k elements to the left
    while (index < nums.size && index < k) {
        result[index] = -1
        index++
    }

    //fill the positions where we have k-radius

    while (index + k < nums.size) {
        var sumLeft = if (index - k - 1 >= 0) partialSums[index - k - 1] else 0

        result[index] = ((partialSums[index + k] - sumLeft) / (2 * k + 1)).toInt()
        index++
    }

    //fill the positions with less than k elements to the right
    while (index < nums.size) {
        result[index] = -1
        index++
    }

    return result
}