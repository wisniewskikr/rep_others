COPY OF ARRAY

Project shows how to create copy of array.


1. ArrayCopy 
It creates copy of array but not copy of instaces. It means that if you remove some element from
source then element in copy will still exists;

System.arraycopy(source, 0, result, 0, source.length); 


2. Deep copy
It means how to create copy of array and objects in this array. To do it you have to use serialization
