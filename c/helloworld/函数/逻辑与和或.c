#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
 /*&& (并且) 逻辑与 
   表达式1 && 表达式2
   短路与：只要有1个表达式为假，整个表达式为假
   只要表达式1为假，就不会执行表达式2。！！！
 */
void test1()
{


	int a = 1;
	int b = 0;
	int c = 2;
	if (a++ && b++ && c++)            /*a=1，则表达式1为真，执行a++语句，执行后，a的值
									  为2，然后判断b，b=0，表达式2为假，则不去判断表达式3，
									  执行b++语句，然后执行else语句。
							          */
	{
		printf("case1:%d%d%d\n",a,b,c);
	}
	else
	{
		printf("case2: %d %d %d\n",a,b,c);//a=2 b=1 c=2
	}

	/*|| (或) 逻辑或
   表达式1 || 表达式2

   短路或：只要有1个表达式为真，整个表达式为真
   只要表达式1为真，就不会执行表达式2。！！！
 */

	
	if (a++ || b++ || c++)            /*a=1，则表达式1为真，执行a++语句，执行后，a的值
									  为2，然后直接执行打印语句。
									  */
	{
		printf("case1: %d %d %d\n", a, b, c);//2 0 2
	}
	else
	{
		printf("case2: %d %d %d\n", a, b, c);
	}



	

}

