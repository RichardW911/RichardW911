#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>

void reverseStr(char* start,int len)
{
	char temp;
	char* end;
	end = start + len - 1;
	while (start < end)
	{
		temp = *start;
		*start = *end;
		*end = temp;
		start++;
		end--;
	}

}

void reverse(char* str)
{
	int len;
	len = strlen(str);
	if (len <= 1)
	{
		return;
	}
	//��������
	reverseStr(str,len);
	//�ֲ����ã����յ��ʽ��оֲ�����
	char* cur;
	char* start;
	int count = 0;//��¼���ʳ���
	cur = str;
	while (*cur != '\0')
	{
		//���ҵ��ʵı߽�
		start = cur;
		while (*cur != ' ' && *cur != '\0')
		{
			cur++;
			count++;
		}
		//��ǰ���ʵ����䣺[start,start+count]
		//��ת����
		reverseStr(start,count);
		count = 0;//��ת�� ���ٵ��ʳ���
		//������һ����������
		//�����ո�
		while (*cur == ' ')
		{
			cur++;
		}
	}
}

void test()
{
	char str[101];
	gets(str);
	reverse(str);
	printf("%s", str);
}