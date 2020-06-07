#include <ioCC2530.h>
#define uint unsigned int
#define uchar unsigned char
#define RLED P1_0
#define YLED P1_1
void Delay(uint):
void Initial(void);
void Delay(uint n)//延时函数
{
   uint tt.jj
   for(tt=0;tt<n;tt++)
    for(jj=O;jj<ll0;jj+);
}
void Initial(void)//初始化
{
   PIDIR |= 0x03: //p1.0,p1.1为输出
   P1IEN |= 0x0C; //开引脚中断
   PICTL |= 0X02; //开端口使能
   IEN2 |= 0X10; //P口使能
   EА=1; //总中断;
}
#pragma vector = P1INT_VECTOR
__interrupt void P1_INTERRUPT(void) { //中断函数
	if (P1IFG == 0x04 )
	{
		RLED = ! RLED;
		Delay(2000);
	}
	if (P1IFG == 0x08) 
	{
		GLED = ! GLED;
		Delay(2000);
	}
	P1IFG = O; //P1引脚中断标志位清0
	P1IF = 0; //P1口中断标志位清零
}
void main(void)
{
	Initial();
	while(1) {
		P1_INTERRUPT();
	}
}