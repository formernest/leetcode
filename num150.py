class Solution:
    def evalRPN(self, tokens):
        stack = []
        op = ["+", "-", "*", "/"]
        for token in tokens:
            if token not in op:
                stack.append(token)
            else:
                num1 = int(stack.pop())
                num2 = int(stack.pop())
                if token == "+":
                    result = num1 + num2
                elif token == "-":
                    result = num2 - num1
                elif token == "*":
                    result = num1 * num2
                elif token == "/":
                    result = int(num2 / num1)
                stack.append(result)
        return int(stack.pop())


if __name__ == "__main__":
    token = ["10", "6","9","3","+","-11","*","/","*","17","+","5","+"]
    s = Solution()
    print(s.evalRPN(token))