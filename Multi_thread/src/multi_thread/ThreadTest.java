package multi_thread;
import java.util.Scanner;
//1��1000000000�к�target�������ܺ�327813115672186884
//���߳� 23s
//10�߳� 18s
//100�߳� 14s
//1000�߳� 12s
public class ThreadTest 
{
	public static void main(String[] args) 
	{
		//����1��1000000000֮�京target�����ĺ�
		Scanner scanner=new Scanner(System.in);
		System.out.println("������target");
		int temp=scanner.nextInt();
		scanner.close();
		Hello t[]=new Hello[1000];//����1000���߳�
		String target=""+temp;//�������Ҫ���ҵ�����ת�����ַ�������Hello�����ʼ��
		for(int i=0;i<t.length;i++)
		{
			t[i]=new Hello(1000000*i,1000000*i+999999,target,i);
			t[i].start();
			
		}
		long total=0;
		for(;;)
		{
			if(t[0].isFinished(t)==true)//�鿴�Ƿ�ȫ���߳��ѽ���
			{
				for(int i=0;i<t.length;i++)//ȫ���߳̽�����ͳ�Ƹ����߳����sumֵ
				{
					total+=t[i].getSum();
				}
				System.out.println(total);
				break;//ͳ�ƽ���������ѭ��
			}
		}
	}
}
