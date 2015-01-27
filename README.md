# simpleInterpreter
A very simple interpreter.

Reads the following commands:
INT X (add X to a stack)
ADD (adds the two last numbers in the stack together)
PRINT (prints last number in the stack)
JGE X (jumps to the X instruction)
SUB (substracts the last number in the stack from the one after it)
SWAP (swaps the last two numbers in the stack)
CALL (goes to the X instruction but saves the next step)
RET (jumps to the last number in the stack)
EXIT (exits the program)
DUP (duplicates the last number in the stack)
JEQ X (if the last number of the stack is not 0 it jumps to X)
POP (removes the last number in the stack)
