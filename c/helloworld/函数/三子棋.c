#define _CRT_SECURE_NO_WARNINGS 1
#include"game.h"


void menu()
{
	printf("****************************\n");
	printf("***********0.exit***********\n");
	printf("***********1.play***********\n");
	printf("****************************\n");
}

void IntBoard(char board[][COL], int row, int col)
{
	for (int i = 0;i < row;i++)
	{
		for (int j = 0;j < col; j++)
		{
			board[i][j] = ' ';
		}
	}
}
void ShowBoard(char board[][COL], int row, int col)
{
	printf("****************************\n");
	for (int i = 0;i < row;i++)
	{
		for (int j = 0;j < col; j++)
		{
			printf("%c", board[i][j]);
			if (j < col - 1)
			{
				printf("|");
			}
		}
		printf("\n");
		//---��������
		if (i < row - 1)
		{
			//ѭ������---������
			for (int j = 0;j < col; j++)
			{
				printf("-");
				if (j < col - 1)
				{
					printf("|");
				}
			}
			printf("\n");
		}

	}
	printf("****************************\n");

}


void game()
{
	char board[ROW][COL] = { 0 };
	IntBoard(board, ROW, COL);
	ShowBoard(board, ROW, COL);
	int ret = 0;
	while (1)
	{
		PlayerMove(board, ROW, COL);
		ComputerMove(board, ROW, COL);
		ShowBoard(board, ROW, COL);
		ret = IsWin(board, ROW, COL);
		if (ret != ' ')
		{
			break;//�϶�����Ӯ��
		}
		ret = IsWin(board, ROW, COL);
		if (ret != ' ')
		{
			break;//�϶�����Ӯ��
		}
	}
	if (ret == 'Q')
	{
		printf("ƽ��\n");
		return;
	}
	if (ret == 'X')
	{
		printf("���Ӯ\n");
		return;
	}
	if (ret == 'Y')
	{
		printf("����Ӯ\n");
		return;
	}
}

void PlayerMove(char board[][COL], int row, int col)
{
	int x = 0;
	int y = 0;
	while (1)
	{
		printf("���������1-3�����꣺\n");
		scanf("%d%d", &x, &y);
		if (x >= 1 && x <= 3 && y >= 1 && y <= 3)
		{
			if (board[x - 1][y - 1] == ' ')
			{
				board[x - 1][y - 1] = 'X';
				break;
			}
			else
			{
				printf("���겻�Ϸ������������룺\n");
			}
		}
	}
}

void ComputerMove(char board[][COL], int row, int col)
{
	while (1)
	{
		int x = rand() % ROW;//row==3 --->0,1,2
		int y = rand() % COL;
		if (board[x][y] == ' ')
		{
			board[x][y] = 'O';
			break;
		}
	}

}


char IsWin(char board[][COL], int row, int col)
{
	for (int i = 0;i < row;i++)
	{
		//��
		if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ')
		{
			return board[i][0];
		}
		//��
		if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ')
		{
			return board[0][i];
		}
		//�Խ���
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][i] != ' ')
		{
			return board[0][0];
		}
		if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][i] != ' ')
		{
			return board[0][2];
		}
		//�Ƿ���ƽ��--->���������Ѿ�������
		if (IsFull(board, row, col) == 1)
		{
			return 'Q';//֤����ƽ��
		}
	}
	return ' ';//����û��Ӯ
}
static int IsFull(char board[][COL], int row, int col)
{
	for (int i = 0;i < row;i++)
	{
		for (int j = 0;j < col;j++)
		{
			if (board[i][j] == ' ')
			{
				return 0;//û����
			}
		}
	}
	return 1;
}



//int main()
//{
//	srand((unsigned)time(NULL));
//	int input = 0;
//	printf("��������Ĳ�����\n");
//	do
//	{
//		menu();
//		scanf("%d",&input);
//		switch (input)
//		{
//		case 1:
//			game();
//			break;
//		case 0:
//			printf("�˳���Ϸ\n");
//			break;
//		default:
//			break;
//		}
//	} while (input);
//	system("pause");
//	return 0;
//}