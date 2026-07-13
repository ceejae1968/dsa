//At each step with l, mid, r:
//
//If nums[l] <= nums[mid] → left half is sorted
//If target is in [nums[l], nums[mid]) → move r = mid - 1
//else → move l = mid + 1
//Else → right half is sorted
//If target is in (nums[mid], nums[r]] → move l = mid + 1
//else → move r = mid - 1