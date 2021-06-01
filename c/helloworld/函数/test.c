#define _CRT_SECURE_NO_WARNINGS 1
#include"game.h"
#include<assert.h>
#define N 10


//void reverseStr(char* start, int len);
//void reverse(char* str);

char* rot(char* p,int len)
{
	assert(p!=NULL);
	char* start = p;
	char temp = *p;
	for (int i = 0;i < len-1 ;i++)
	{
		p[i] = p[i + 1];
	}
	*(p + len - 1) = temp;
	return start;
}

char* rotate(char* p,int len,int k)
{
	assert(p != NULL);
	if (len <= 1)
	{
		return p;
	}
	char* start = p;
	while (k > 0)
	{
		rot(p, len);
		k--;
	}
	return p;
}

int Is_rotate(char* ch1, char* ch2)
{
	int len1 = strlen(ch1);
	int len2 = strlen(ch2);
	int k = 0;
	if (len1 == len2)
	{
		while (k <= len1)
		{
			rotate(ch1,len1,k);
			if (strcmp(ch1,ch2)==0)
			{
				return 1;
			}
			else
			{
				k++;
			}
		}
		return 0;
	}
	else
	{
		return 0;
	}
	return 1;
}


int main()
{
	int temp = 0;
	////存放各位立方之和
	int sum = 0;
	int a = 0;
	int i;
	//for (int i = 100; i < 1000; i++) {
	//	temp = i;
	//	while (temp > 0) {
	//		a = temp % 10;
	//		sum += a * a * a;
	//		temp /= 10;
	//	}
	//	if (sum == i) {
	//		printf("%d",i);
	//	}
	//}
	i = 153;
	temp = i;
	while (temp > 0) {
		a = temp % 10;
		sum += a * a * a;
		temp /= 10;
	}
	if (sum == i) {
		printf("%d", i);
	}
	return 0;


}

/*
  static：
  1.修饰变量
    修饰局部变量
	修饰全局变量
  2.修饰函数
*/

int texx()
{
	/*普通局部变量：
     生命周期：进入函数创建 函数结束销毁
     作用域：函数体内
										 
     静态局部变量：
	 生命周期：进入函数创建，程序结束后才消失
     作用域：函数体内

	 普通全局变量：
	 生命周期：程序开始执行到结束
	 作用域：整个工程

	 静态局部变量：
	 生命周期：程序开始执行到结束
	 作用域：当前.c文件当中去使用

										 */
	static int i = 0;
	i++;
	printf("%d\n",i);
	return 0;

}

//typedef int LOW;
//相当于给int起了个别名 LOW
//extern int func();


void swop(int* a, int* b)
{
	*a = *a ^ *b;
	*b = *a ^ *b;
	*a = *a ^ *b;

}

//int test(int a)
//{
//	int count = 0;
//	int i = 32;
//	while (i)
//	{
//		if ((a & 1) == 1)
//		{
//			count++;
//			a = a >> 1;
//		}
//		a = a >> 1;
//		i--;
//	}
//	return count;
//}

int count(int a,int b)
{
	int count = 0;
	int num;
	num = a ^ b;
	while (num)
	{
		count++;
		num = num & (num-1);
	}
	return count;
}


