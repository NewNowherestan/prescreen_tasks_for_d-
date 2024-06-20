# prescreen_tasks_for_d-

> [WARNING]
> I will not disclose the task in order not to be searchabe and not to spoil fun for future applicants.

 This linear aproach works in the following way:
 
 1. Filter egde cases where coreCount is 0, threadCount is less than 2 or efCorePos is out of bounds.
 
 2. Calculate the maximum initial border value,
 the absolute distance from the efCorePos to the border
 and the initial ladder sum.
 
 It called ladder because what it basicly does is calculates what range can be inserter into the array
 and the sum of this range in a manner 
 ```
 [0, 1, 2, 3, 4] for 5 x>9 5 case 
 or [0, 1, 2, 3] for the 3 x>5 3
 ```
 The absBorderDist is adjusting the ladder like
```
 [0, 1, 2, 3, 0] for 5 x>5 4 case
 or [0, 1, 2, 0] for the 4 x>3 2 case
```
 
 3. If the calculated maxInitialBorderVal is greater than the threadCount it means we are in the situation like
```
 [0, 0, 0, 1, 2] or [0, 1, 2, 1, 0] or [0, 1, 1, 1, 0]
```
 reversed range sum formula is user to calculate the new value sum = n*(start+end)/2
 
 4. By substtracting the initial ladder threads count from the threadCount we get falues to be distributed
 The fill is basicly how much times the range can be added to the array and substitutes the iterational approach.
 
 in a case 5, 20, 5 -> the ladder sum is 10, the fill is (20 - 10) / 5(corecount) = 2
```
 [0, 1, 2, 3, 4] - ladder
 [1, 2, 3, 4, 5] - ladder + fill
 [2, 3, 4, 5, 6] - ladder + 2*fill
```
 
 But we do not perform this operation on the whole array
 but just adding fill to the previouslly calculated value
 
 done.
 This approach is O(1) and is the best solution for this problem i can think of this night.
 
 Overall great task, thank you for the challalenge.

## The two lists problem.

The strategy pattern here is used to handle different scenarios for the K number. 

- `TwoListsWindow` is the strategy where the K number should be subsequent and is implemented using a sliding window approach.
- `TwoListsAny` is the strategy where the K numbers can be any and is implemented by brute-forcing via sorting.
