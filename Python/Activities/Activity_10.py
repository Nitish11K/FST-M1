lst = []
 
# number of elements as input
n = int(input("Enter number of elements : "))
 
# iterating till the range
for i in range(0, n):
    ele = int(input())
    # adding the element
    lst.append(ele)  
 
print(lst)

print("Elements that are divisible by 5:")
for num in lst:
    if (num % 5 == 0):
        print(num)