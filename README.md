# prescreen_tasks_for_d-

> [!NOTE]
> 90 minutes were given for both tasks and explanations.
> The first task was mostly finished in 40 minutes with a sliding window algorithm, and I carelessly spent 20 more minutes trying to pack it fully into the stream API.
> The second task was so great that I just refused to brute force and fill it with an array, and in the 30 minutes that were left, I could not properly do the linear approach or iterational.
>
> This repo is solely my redemption on this great challenge.

> [!WARNING]
> I will not disclose the task in order not to be searchable and not to spoil the fun for future applicants.

## (Task 1) The two lists problem.

The strategy pattern here is used to handle different scenarios for the K number. 
I do not recall if K elements should be subsequent or any, so implemented both.
- `TwoListsWindow` is the strategy where the K number should be subsequent and is implemented using a sliding window approach.
- `TwoListsAny` is the strategy where the K numbers can be any and is implemented by brute-forcing via sorting.

 The overall approach is:
 1. Get the difference between the two lists.
      This will remove the need to compare the values from the list1 and list2.
      The difference will be the same for the same indexes. There is no need to traverse the lists synchronously.
 2. Get the indexes of the K biggest differences.
      Each implementation of the TwoListsAbstractSolution will have its own way of getting the indexes.
 4. Compose the final result by adding the values from the list1 or list2, depending on the index.
 
 The overall complexity is O(n), where n is the size of the biggest list. Constants are not taken into account.
 
 It was a really good task. I enjoyed it.

## (Task 2) The threads distribution problem
 This linear aproach works in the following way:
 
 1. Filter the edge cases where coreCount is 0, threadCount is less than 2, or efCorePos is out of bounds.
 
 2. Calculate the maximum initial border value,
    the absolute distance from the efCorePos to the border
    and the initial ladder sum.
    
    It is called ladder because what it basicly does is calculate what range can be entered into the array
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
 
 3. If the calculated maxInitialBorderVal is greater than the threadCount, it means we are in a situation like
    ```
    [0, 0, 0, 1, 2] or [0, 1, 2, 1, 0] or [0, 1, 1, 1, 0]
    ```
    The reversed range sum formula is user to calculate the new value sum = n*(start+end)/2
 
 4. By subtracting the initial ladder threads count from the threadCount, we get values to be distributed
    The fill is essentially the number of times the range can be added to the array, substituting the iterational approach.
    
    In a case 5, 20, 5 -> the ladder sum is 10, the fill is (20 - 10) / 5(coreCount) = 2
    ```
    [0, 1, 2, 3, 4] - ladder
    [1, 2, 3, 4, 5] - ladder + fill
    [2, 3, 4, 5, 6] - ladder + 2*fill
    ```
 
    But we do not perform this operation on the whole array
    but just adding fill to the previously calculated value
 
 This approach is O(1) and is the best solution for this problem i can think of this night.
 
 Overall, it was a great task. Thank you for the challenge.

 > [!IMPORTANT]
 > Please pay attention to the fact that the code is covered with tests, including some edge cases, but probably not all of them.
 > If you will run the code, start by executing the tests.