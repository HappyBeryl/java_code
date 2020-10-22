 16:49:48


//头文件的包含和家定义
#include <ioCC2530.h>

#defineuint unsigned int
#define uchar unsigned char
#define LED2 P1_0
#derine LED3 P1_1
#define S1 P1_2
#defineS3 P1_3

void InitialLed (void); //化初始化灯函数声明
void InitialKey(void);  //初始化按键函数声明

void Delay(uint n)
{
	uint i,j;
	for(i=0;i<n;i++)
	for(j=0;j<110: j++) ;
}
void InitialLed (void)
{
	P1SEL &= 0x03;
	P1DIR |= 0x03; //将P10、P11定义为输出
	LED2=1:
	LED3=1;
}

void InitialKey(void)
{
	EA=1;//开全局中断
	IEN2=0x10; //P1中断使能
	PIIEN =0x0c; //开引脚中断
	PICTL=0x02; //开端口中断
}

//中断处理函数

#pragma vector =P1INT VECTOR 
interrupt void P1_ ISR(void)
{
    uint i
	if(P1IFG==0x04) //判断按键S1是否按下
	{
 		for(i=0;i<20;i++)//LED2闪烁10次
		{
			LED2= !LED2;
			Delay(1000);
		}
	if(P1IFG=0x08)//判断按键S2是否按下
	{
		for(i=0; i<20;i++)//LED3闪烁10次\
		{
			LED3=!LED3;
			Delay(1000) ;
		}
	}
	P1IFG=0;
	P1IF=0;//清中断标志
	LED2=1;
	LED3=1;
//主函数
void main(void)
{
	InitialLed();
	InitialKey();
	while(1) 
	{
		PCON|=0x01;
		SLEEPCMD|=0x03;
	}
}


