Compiler Project Part 3
================

## Prerequisites
- JDK
- JFlex
- CUP 

## Build and Run

#### Build the Project
```shell
make run
```

#### Test Cases in Part 3

Testcase inputs and results are in ./TestCases

To Run All Test Cases:

```shell
make part3
```

To run individual test cases, use the following format:
    ```
    make <Test_Case_Name>
    ```

- For badDec.as:
    ```shell
    make badDec
    ```

- For badInc.as:
    ```shell
    make badInc
    ```

- For badNegation.as:
    ```shell
    make badNegation
    ```

- For badString.as:
    ```shell
    make badString
    ```

- For badTernaryCond.as:
    ```shell
    make badTernaryCond
    ```

- For badTernaryTypes.as:
    ```shell
    make badTernaryTypes
    ```

- For boolToFloat.as:
    ```shell
    make boolToFloat
    ```

- For boolToInt.as:
    ```shell
    make boolToInt
    ```

- For callNonExistFunc.as:
    ```shell
    make callNonExistFunc
    ```

- For charToFloat.as:
    ```shell
    make charToFloat
    ```

- For charToInt.as:
    ```shell
    make charToInt
    ```

- For floatToInt.as:
    ```shell
    make floatToInt
    ```

- For fullValidProgram.as:
    ```shell
    make fullValidProgram
    ```

- For incompatBinary.as:
    ```shell
    make incompatBinary
    ```

- For intArrayToBoolArray.as:
    ```shell
    make intArrayToBoolArray
    ```

- For noReturn.as:
    ```shell
    make noReturn
    ```

- For reassignFinal.as:
    ```shell
    make reassignFinal
    ```

- For redefMethod.as:
    ```shell
    make redefMethod
    ```

- For redefVar.as:
    ```shell
    make redefVar
    ```

- For redefVarAsMethod.as:
    ```shell
    make redefVarAsMethod
    ```

- For returnTypeBad.as:
    ```shell
    make returnTypeBad
    ```

#### Clean the Project

```shell
make clean
```
