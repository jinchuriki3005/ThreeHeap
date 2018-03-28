Max Tran, CSE 373, HW#2

1)
I would first make a threeHeap object. Then insert some values into it and print out the string representation 
of the priority queue from the toString() method to make sure that it satisfies the heap property. 
I then test out to make sure the size() and isEmpty() works. Then I findMin and deleteMin and print out 
the string representation of the heap again to make sure it still behaves like I expect it to. 
I then make a new List object and add some values into it and run the buildQueue() method and test it with the 
toString() again to make sure it works. Overall, it works just fine!

2)
My isEmpty(), size(), findMin() methods are both O(1). size() returns a field, IsEmpty() evaluates a boolean 
statement relating to the size field and findMin() return the first value in the priority Queue without changing
the queue. Insert() and deleteMin() are O(log N) because percolateUp and percolateDown are both O(log3 N) but 
they are both within O(logN)

3)
a) O(NLogN), the outer for loop runs N times, and the inner for loop iterates by 2, thus it's always a half, so it's
logN, thus the overall asymptotic runtime is O(NLogN)

b) O(N^3), the outer for loop runs N times and the inner for loop run n*(n+1)/3 times, thus the overall runtime is 
O(N^3/3 + N^2/3) or O(N^3) if we ignore the constants and coefficients.

c) O(N^2), the outer for loop run the method printCats() N times and the printCats() has a for loop that runs N times
Thus overall the runtime is N^2 so the asymptotic runtime is O(N^2)

4)
a) Yes
for O(N^2), the pseudo code is
int dif = 0;
for(int i = 0; i < size-1;i++){
   for(int j=0;j<size-1;j++){
	if(difference in list[i] and list[j] > dif){
	     dif = that difference;
	}
   }
}
return dif;

b) Yes
for O(N);
the pseudo code is 
int max = list[0];
int min = list[0];
for(int i = 0;i<size-1;i++){
   if(list[i]>max){
	max = list[i];
   }
   if(list[i] < min){
	min = list[i];
   }
}
return max-min;

c) No, because you need to run a for loop over the array to search for the min and max value. The only way for this
to work is if the array is empty or has 1 element so then the difference is 0;

5)
a) because the array grows with a constant amount, operations are not amortized O(1). After O(M) operations,
you may have done O(M^2) copies
b) We can see that when making an array that is 1.5 times larger and copy over your element. The runtime would be 
less than when you make an array that is 2 times larger and copy over your element. Thus, it would be less than
amortized O(1) which is O(1) itself.
c) This is amortized O(1) because we have enough cheap operations to build up "credit" that can be used to "pay
for" later "expensive" operations. We also know that insert() will take O(N) for N operation when N reach the size
of the array because it will have to run a for loop to copy over the element from the old array to bigger array.
This will take O(N) and since there are N operations, the amortized runtime is O(1);

6) Yes I implement the Floyd's method into the buildQueue() along with a toString() to model the threeHeap