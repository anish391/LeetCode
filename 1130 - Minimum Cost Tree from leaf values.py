class Solution:
    def mctFromLeafValues(self, arr: List[int]) -> int:
        result = 0
        while(len(arr)>1):
            minimumLeafIndex = arr.index(min(arr))
            if 0 < minimumLeafIndex < len(arr)-1:
                result += min(arr[minimumLeafIndex-1], arr[minimumLeafIndex+1]) * arr[minimumLeafIndex]
            elif minimumLeafIndex == 0:
                result += arr[minimumLeafIndex] * arr[minimumLeafIndex+1]
            elif minimumLeafIndex == len(arr)-1:
                result += arr[minimumLeafIndex-1] * arr[minimumLeafIndex]
            arr.pop(minimumLeafIndex)
        return result