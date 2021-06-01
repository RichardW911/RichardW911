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
	//整体逆置
	reverseStr(str,len);
	//局部逆置，按照单词进行局部逆置
	char* cur;
	char* start;
	int count = 0;//记录单词长度
	cur = str;
	while (*cur != '\0')
	{
		//查找单词的边界
		start = cur;
		while (*cur != ' ' && *cur != '\0')
		{
			cur++;
			count++;
		}
		//当前单词的区间：[start,start+count]
		//逆转单词
		reverseStr(start,count);
		count = 0;//逆转后 销毁单词长度
		//查找下一个单词区间
		//跳过空格
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