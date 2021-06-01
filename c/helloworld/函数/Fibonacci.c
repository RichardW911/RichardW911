#include <stdio.h>
int Fib(int n)
{
	if (n <= 0)
	{
		return -1;
	}
	int f1 = 1;
	int f2 = 1;
	int f3 = 1;
	for (int i = 3;i <= n;i++)
	{
		f3 = f1 + f2;
		f1 = f2;
		f2 = f3;
	}
	return f3;
}