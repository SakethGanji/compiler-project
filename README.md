Compiler Project Part 2
================
## Overview

The primary objective of Part 2 in our compiler project is to validate the parsing 
mechanism of our custom programming language and to ensure proper state transitions 
within the parsing process. This is achieved by generating a formatted output derived 
from the abstract syntax tree we construct.

## Prerequisites
- JDK
- JFlex
- CUP 

## Build and Run

#### Build the Project
```
make all
```

#### Test Cases in Part 2 Phase 2

To Run All Test Cases:

```
make run
```

To Run Individual Test Cases:

- For Phase2_empty.txt:
    ```
    make run_Phase2_empty
    ```

- For Phase2_fields.txt:
    ```
    make run_Phase2_fields
    ```

- For Phase2_full.txt:
    ```
    make run_Phase2_full
    ```

- For Phase2_methods.txt:
    ```
    make run_Phase2_methods
    ```

- For Phase2_myt1.txt (my own testcase):
    ```
    make run_Phase2_myt1
    ```

#### Clean the Project
```
make clean
```
