
# Average Function Testing

This project implements and tests an `average` function in Java. The function calculates the arithmetic mean of the first `k` elements of an array. If `k` exceeds the array length, it computes the average of the entire array. If the array is empty or `k` is 0, it returns 0. The project includes functional tests, partition tests, boundary value tests, and measures code coverage using JUnit and VSCode.
---

## a. Functional Description

The `average` function calculates the average of the first `k` elements in an array:
- If `k > array.length`, the average of the entire array is returned.
- If `k = 0` or the array is empty, it returns `0`.

### b. Functional Test Cases
| Test Case ID | Input                            | Expected Output | Description                              |
|--------------|----------------------------------|-----------------|------------------------------------------|
| TC1          | `k = 3, list = {1, 2, 3, 4, 5}` | `2`             | Average of the first 3 elements.         |
| TC2          | `k = 10, list = {1, 2, 3, 4, 5}`| `3`             | Average of the entire array.             |
| TC3          | `k = 0, list = {1, 2, 3}`       | `0`             | No elements to average.                  |
| TC4          | `k = 5, list = {}`              | `0`             | Empty array.                             |
| TC5          | `k = 2, list = {-3, 3, 6}`      | `0`             | Average of `{-3, 3}`.                    |

### c. Partition Test Cases
| Partition                          | Input                            | Expected Output | Description                              |
|------------------------------------|----------------------------------|-----------------|------------------------------------------|
| No elements to average             | `k = 0, list = {1, 2, 3}`       | `0`             | `k = 0` results in no averaging.         |
| Average of `k` elements (`k < n`)  | `k = 2, list = {4, 5, 6}`        | `4`             | Average of the first 2 elements.         |
| Average of the entire array (`k >= n`) | `k = 5, list = {2, 2}`        | `2`             | Covers case where `k` exceeds array size.|
| Empty array                        | `k = 3, list = {}`              | `0`             | Empty list results in 0.                 |
| Mixed positive and negative values | `k = 3, list = {-3, 3, 9}`      | `3`             | Average of mixed values.                 |

### d. Boundary Value Test Cases
| Test Case ID | Input                            | Expected Output | Description                              |
|--------------|----------------------------------|-----------------|------------------------------------------|
| BV1          | `k = 0, list = {}`              | `0`             | No elements in the array or to process.  |
| BV2          | `k = 1, list = {10}`            | `10`            | Single element in the array.             |
| BV3          | `k = 3, list = {1, 2, 3}`       | `2`             | Average of exactly `k` elements.         |
| BV4          | `k = 3, list = {-5, -5, -5}`    | `-5`            | Negative values only.                    |
| BV5          | `k = 3, list = {10, 20, 30}`    | `20`            | Boundary case for average of 3 values.   |


###  e. Implement the average function in a class Average and generate test cases using Junit
[Link to code](https://github.com/UTDClassroomOrg/HW3-testing-axr210162-cs3354.008)


### f. Compile and Run the Test Cases

#### **Initial Results**
The `average` function was compiled and tested using the provided test cases. No failures or errors were reported.

**Original Function:**
```java
public int average(int k, int[] list) {
    int average = 0;
    int n = Math.min(k, list.length);
    if (n > 0) {
        for (int i = 0; i < n; i++) {
            average += list[i];
        }
        average = average / n;
    }
    return average;
}
```
| Test Case ID | Status  |
|--------------|---------|
| testAverageWithFirstKElements               | `Passed`|
| testAverageWhenKExceedsArrayLength          | `Passed`|
| testAverageWhenKIsZero                      | `Passed`|
| testAverageWithEmptyArray                   | `Passed`|
| testAverageWithNegativeAndPositiveValues	  | `Passed`|

#### **Fault Injection**
To verify the robustness of the test cases, a fault was injected into the average function by modifying the initialization of the loop variable from int i = 0 to int i = 1.

```java
public int average(int k, int[] list) {
    int average = 0;
    int n = Math.min(k, list.length);
    if (n > 0) {
        for (int i = 1; i < n; i++) { // Fault injected: i = 1
            average += list[i];
        }
        average = average / n;
    }
    return average;
}
```
| Test Case ID | Status  |
|--------------|---------|
| testAverageWithFirstKElements               | `Fail`|
| testAverageWhenKExceedsArrayLength          | `Fail`|
| testAverageWhenKIsZero                      | `Passed`|
| testAverageWithEmptyArray                   | `Passed`|
| testAverageWithNegativeAndPositiveValues	  | `Fail`|

#### **Analysis of Failures**
The fault caused the loop to skip the first element of the array, leading to incorrect averages in all scenarios where at least one element should be included. Specifically:

The loop started at the second element (i = 1) instead of the first (i = 0).
Test cases requiring the inclusion of the first element (testAverageWithFirstKElements, testAverageWhenKExceedsArrayLength, and testAverageWithNegativeAndPositiveValues) failed.

### **Fix**
The issue was resolved by reverting the loop initialization to int i = 0.

```java
public int average(int k, int[] list) {
    int average = 0;
    int n = Math.min(k, list.length);
    if (n > 0) {
        for (int i = 0; i < n; i++) { // Fixed: i = 0
            average += list[i];
        }
        average = average / n;
    }
    return average;
}
```
### **Test Results after Fix**
| Test Case ID | Status  |
|--------------|---------|
| testAverageWithFirstKElements               | `Passed`|
| testAverageWhenKExceedsArrayLength          | `Passed`|
| testAverageWhenKIsZero                      | `Passed`|
| testAverageWithEmptyArray                   | `Passed`|
| testAverageWithNegativeAndPositiveValues	  | `Passed`|

### g. **Code Coverage**
![100% Coverage](https://github.com/user-attachments/assets/71322a5d-0c25-4720-a6d6-242d3e27704e)

