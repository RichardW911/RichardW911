#define _CRT_SECURE_NO_WARNINGS 1
#define N 2
#include<stdio.h>
int Speed_Up(int x)
{
	x = x << N;//"<<"按位左移 快速放大2的N次方  
	return x;
}

int Speed_Down(int y)
{
	y = y >> N;//">>"按位右移 快速缩小2的N次方
	return y;
}


