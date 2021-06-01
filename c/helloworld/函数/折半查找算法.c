#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<string.h>
//int main()
//{
//	int arr[] = {1,2,3,4,5,6,7,8,9,10};
//	int left = 0;                                    
//	//int right = sizeof(arr) / sizeof(arr[0]) - 1;  //sizeof（arr）/size(arr[0])
//	                                               //求出的数组长度包含\0！
//	int right = strlen(arr);
//	int key = 7;
//	int mid = 0;
//	while (left <= right)
//	{
//		mid = (left + right) / 2;
//		if (arr[mid] > key)
//		{
//			right = mid - 1;
//		}
//		else if (arr[mid] < key)
//		{
//			left = mid + 1;
//		}
//		else
//		{
//			break;
//		}
//	}
//	if (left <= right)
//	{
//		printf("找到了，下标是%d\n",mid);
//	}
//	else
//	{
//		printf("找不到\n");
//	}
//	return 0;
//}

int Bin_Search(int arr[], int left, int right, int key)
{
	int mid = 0;
	while (left <= right)
	{
		mid = (left + right) >> 1;
		if (arr[mid] > key)
		{
			right = mid - 1;
		}
		else if (arr[mid] < key)
		{
			left = mid + 1;
		}
		else
		{
			return mid;//找到了
		}
		return -1;//找不到
	}
	return -1;//未找到
}