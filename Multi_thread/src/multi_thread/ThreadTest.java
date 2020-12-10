package multi_thread;
import java.util.Scanner;
//1到1000000000中含target的数的总和327813115672186884
//无线程 23s
//10线程 18s
//100线程 14s
//1000线程 12s
public class ThreadTest 
{
	public static void main(String[] args) 
	{
		//处理1到1000000000之间含target的数的和
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入target");
		int temp=scanner.nextInt();
		scanner.close();
		Hello t[]=new Hello[1000];//创建1000个线程
		String target=""+temp;//将输入的要查找的数字转换成字符，用于Hello对象初始化
		for(int i=0;i<t.length;i++)
		{
			t[i]=new Hello(1000000*i,1000000*i+999999,target,i);
			t[i].start();
			
		}
		long total=0;
		for(;;)
		{
			if(t[0].isFinished(t)==true)//查看是否全部线程已结束
			{
				for(int i=0;i<t.length;i++)//全部线程结束后，统计各个线程里的sum值
				{
					total+=t[i].getSum();
				}
				System.out.println(total);
				break;//统计结束，跳出循环
			}
		}
	}
}
