
# Average Function Testing

This project implements and tests an `average` function in Java. The function calculates the arithmetic mean of the first `k` elements of an array. If `k` exceeds the array length, it computes the average of the entire array. If the array is empty or `k` is 0, it returns 0. The project includes functional tests, partition tests, boundary value tests, and measures code coverage using JUnit and EclEmma.

## Table of Contents
1. [Functional Description](#functional-description)
2. [Test Cases](#test-cases)
    - [Functional Test Cases](#functional-test-cases)
    - [Partition Test Cases](#partition-test-cases)
    - [Boundary Value Test Cases](#boundary-value-test-cases)
3. [Injected Fault and Fix](#injected-fault-and-fix)
4. [Code Coverage](#code-coverage)
5. [Setup and Run Instructions](#setup-and-run-instructions)
6. [Contributing](#contributing)

---

## Functional Description

The `average` function calculates the average of the first `k` elements in an array:
- If `k > array.length`, the average of the entire array is returned.
- If `k = 0` or the array is empty, it returns `0`.

## Test Cases

### Functional Test Cases
| Test Case ID | Input                            | Expected Output | Description                              |
|--------------|----------------------------------|-----------------|------------------------------------------|
| TC1          | `k = 3, list = {1, 2, 3, 4, 5}` | `2`             | Average of the first 3 elements.         |
| TC2          | `k = 10, list = {1, 2, 3, 4, 5}`| `3`             | Average of the entire array.             |
| TC3          | `k = 0, list = {1, 2, 3}`       | `0`             | No elements to average.                  |
| TC4          | `k = 5, list = {}`              | `0`             | Empty array.                             |
| TC5          | `k = 2, list = {-3, 3, 6}`      | `0`             | Average of `{-3, 3}`.                    |

### Partition Test Cases
| Partition                          | Input                            | Expected Output | Description                              |
|------------------------------------|----------------------------------|-----------------|------------------------------------------|
| No elements to average             | `k = 0, list = {1, 2, 3}`       | `0`             | `k = 0` results in no averaging.         |
| Average of `k` elements (`k < n`)  | `k = 2, list = {4, 5, 6}`        | `4`             | Average of the first 2 elements.         |
| Average of the entire array (`k >= n`) | `k = 5, list = {2, 2}`        | `2`             | Covers case where `k` exceeds array size.|
| Empty array                        | `k = 3, list = {}`              | `0`             | Empty list results in 0.                 |
| Mixed positive and negative values | `k = 3, list = {-3, 3, 9}`      | `3`             | Average of mixed values.                 |

### Boundary Value Test Cases
| Test Case ID | Input                            | Expected Output | Description                              |
|--------------|----------------------------------|-----------------|------------------------------------------|
| BV1          | `k = 0, list = {}`              | `0`             | No elements in the array or to process.  |
| BV2          | `k = 1, list = {10}`            | `10`            | Single element in the array.             |
| BV3          | `k = 3, list = {1, 2, 3}`       | `2`             | Average of exactly `k` elements.         |
| BV4          | `k = 3, list = {-5, -5, -5}`    | `-5`            | Negative values only.                    |
| BV5          | `k = 3, list = {10, 20, 30}`    | `20`            | Boundary case for average of 3 values.   |
