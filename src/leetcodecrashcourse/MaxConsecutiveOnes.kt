package leetcodecrashcourse


/**
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you
 * can flip at most k 0's.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 * Example 2:
 *
 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 * Output: 10
 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 * 0 <= k <= nums.length
 */
fun longestOnes(nums: IntArray, k: Int): Int {
    //The problem is similar with finding the max number of contiguous 0's
    var max = 0
    var left = 0
    var currentNoOfZeros = 0

    for(right in 0 until nums.size){
        if(nums[right] == 0){
            currentNoOfZeros++
        }

        if(currentNoOfZeros > k){
            while(nums[left] == 1){
                left++
            }

            currentNoOfZeros--
            left++
        }

        max = maxOf(max, right - left + 1)
    }

    return max
}


//fun longestOnes(nums: IntArray, k: Int): Int {
//    var left = 0
//    var right = 0
//    var max = 0
//    var flipsLeft = k
//
//    while(left <= right && right < nums.size){
//        if(nums[right] == 1){
//            right++
//        }else {
//            //we have flips left => we advance
//            if(flipsLeft > 0){
//                flipsLeft--
//                right++
//            }else{
//                //we search for first 0 from the left in order to free up "flips"
//                while(nums[left] == 1 && left < right){
//                    left++
//                }
//
//                //if we found a slot where we used our flip, we reuse it on current ("right") element
//                if(nums[left] == 0 && left < right){
//                    left++
//                    right++
//                } else { //else we reset our left and right to current element
//                    right++
//                    left = right
//                }
//            }
//        }
//
//        max = maxOf(max, right - left)
//    }
//
//    return max
//}