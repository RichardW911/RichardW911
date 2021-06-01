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
	////��Ÿ�λ����֮��
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
  static��
  1.���α���
    ���ξֲ�����
	����ȫ�ֱ���
  2.���κ���
*/

int texx()
{
	/*��ͨ�ֲ�������
     �������ڣ����뺯������ ������������
     �����򣺺�������
										 
     ��̬�ֲ�������
	 �������ڣ����뺯��������������������ʧ
     �����򣺺�������

	 ��ͨȫ�ֱ�����
	 �������ڣ�����ʼִ�е�����
	 ��������������

	 ��̬�ֲ�������
	 �������ڣ�����ʼִ�е�����
	 �����򣺵�ǰ.c�ļ�����ȥʹ��

										 */
	static int i = 0;
	i++;
	printf("%d\n",i);
	return 0;

}

//typedef int LOW;
//�൱�ڸ�int���˸����� LOW
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


