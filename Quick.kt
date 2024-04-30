fun main() {
    val sortedArray = sortArray(intArrayOf(5, 2, 3, 1))
    println(sortedArray.contentToString())
}

    fun sortArray(nums:IntArray):IntArray{
        return (divide(nums,0,nums.size-1))
    }

    fun divide(nums: IntArray,Si:Int,Ei:Int):IntArray {
        if (Si<Ei){
            val mid:Int=Si+(Ei-Si)/2
            divide(nums,Si,mid)
            divide(nums,mid+1,Ei)
            conquer(nums,Si,mid,Ei)
        }
        return nums
    }

    fun conquer(arr: IntArray, si: Int, mid: Int, ei: Int) {
    val merger = IntArray(ei - si + 1)
    var idx1 = si
    var idx2 = mid + 1
    var x = 0
    while (idx1 <= mid && idx2 <= ei) {
        if (arr[idx1] <= arr[idx2]) {
            merger[x++] = arr[idx1++]
        } else {
            merger[x++] = arr[idx2++]
        }
    }
    while (idx1 <= mid) {
        merger[x++] = arr[idx1++]
    }
    while (idx2 <= ei) {
        merger[x++] = arr[idx2++]
    }

    var i = 0
    var j = si
    while (i < merger.size) {
        arr[j] = merger[i]
        i++
        j++
    }
}
