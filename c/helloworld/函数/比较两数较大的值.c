#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
int compare1(int x, int y)
{
	if (x > y)
	{
		return x;
	}
	else
	{
		return y;
	}
}


int compare2(int x, int y)
{
	return x > y ? x : y;
}







