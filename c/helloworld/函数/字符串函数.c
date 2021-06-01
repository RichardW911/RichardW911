#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<assert.h>

int Mystrlen(const char* pstr)
{
	assert(pstr!=NULL);
	char* pc = pstr;
	while (*pc!='\0')
	{
		pc++;
	}
	return pc - pstr;
}



char* Mystrcpy(char* dest, const char* src)
{
	assert(dest!=NULL && src!=NULL);
	char* start = dest;
	while (*src != '\0')
	{
		*dest = *src;
		dest++;
		src++;
	}
	*dest = '\0';
	return start;
}

char* Mystrcat(char* dest, const char* src)
{
	assert(dest!=NULL);
	if (src == NULL)
	{
		return dest;
	}
	char* start = dest;
	while (*dest != '\0')
	{
		dest++;
	}
	while (*src != '\0')
	{
		*dest = *src;
		dest++;
		src++;
	}
	*dest = '\0';
	return start;
}


int Mystrcmp(char* str1, char* str2)
{
	assert(str1 && str2);
	if (str1 == NULL)
	{
		return -1;
	}
	if (str2 == NULL)
	{
		return 1;
	}
	while (*str1 == *str2)
	{
		if (*str1 == '\0')
		{
			return 0;
		}
		str1++;
		str2++;
	}
	if (*str1 > * str2)
	{
		return 1;
	}
	else
	{
		return -1;
	}
}



char* Mystrstr(char* str1, char* str2)
{
	char* start = str1;
	while (*start != '\0')
	{
		char* s1 = start;
		char* s2 = str2;
		while (*s1 && *s2 && *s1 == *s2)
		{
			s1++;
			s2++;
		}
		if (*s2 == '\0')
		{
			return start;
		}
		start++;
	}
	return NULL;
}


void* memcpy(void* dst, const void* src, size_t count)
{
	void* ret = dst;
	assert(dst);
	assert(src);
	while (count--)
	{
		*(char*)dst = *(char*)src;
		dst = (char*)dst + 1;
		src = (char*)src + 1;
	}
	return(ret);
}

void* memmove(void* dst, const void* src, size_t count)
{
	void* ret = dst;
	if (dst <= src || (char*)dst >= ((char*)src + count))
	{
		while (count--)
		{
			*(char*)dst = *(char*)src;
			dst = (char*)dst + 1;
			src = (char*)src + 1;
		}
	}
	else
	{
		dst = (char*)dst + count - 1;
		src = (char*)src + count - 1;
		while (count--)
		{
			*(char*)dst = *(char*)src;
			dst = (char*)dst - 1;
			src = (char*)src - 1;
		}
	}
	return(ret);
}