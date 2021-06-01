#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>

void bubbleSort(int p[], int len)
{
	int i, j;//i´ú±íÌËÊý
	int temp = 0;
	int count = 1;
	for (i = 0;i < len - 1;i++)
	{  
		if (count != 0)
		{
			count = 0;
		}
		else
		{
			break;
		}
		               //5-1-i 
		for (j = 0;j < len - 1 - i;j++)
		{
			if (p[j] > p[j + 1])
			{
				temp = p[j];
				p[j] = p[ j + 1 ];
				p[j + 1 ] = temp;
				count++;
			}
		}
		
	}
}
