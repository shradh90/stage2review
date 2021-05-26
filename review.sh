
#! /bin/bash
arr=(2 3 4 5 6)
echo "given array is"
echo ${arr[*]}
len=${#arr[@]}
echo "length of a array is $len"	
for((i=0;i<$len;i++))
	do
	  multiplication=$(( $len * ${arr[$i]} ))
	  new+=($multiplication)
        done
echo "multiplication of length and array is stored in another array"
echo ${new[@]}
