#define _CRT_SECURE_NO_WARNINGS 1
#define N 2
#include<stdio.h>
int Speed_Up(int x)
{
	x = x << N;//"<<"��λ���� ���ٷŴ�2��N�η�  
	return x;
}

int Speed_Down(int y)
{
	y = y >> N;//">>"��λ���� ������С2��N�η�
	return y;
}


