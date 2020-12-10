package multi_thread;
public class Hello extends Thread
{
	long left;
	long right;
	static long sum[] =new long[1000];
	String target;
	int count;
//target���ַ���������contain����
	public Hello(long left, long right, String target, int count)
	{
		this.left = left;
		this.right = right;
		this.target = target;
		this.count = count;
	}
	
	public long getSum() 
	{
		return sum[count];
	}
	public void run()
	{

		for (long i = left; i <= right; i++) 
		{
			if (("" + i).contains(target))
			{
				sum[count] += i;
			}
		}

	}
	public boolean isFinished(Hello []t) 
	{//�ж��Ƿ�ȫ���̶߳�����
		boolean flag = true;
		for (int i=0;i<t.length;i++) 
		{
			if (t[i].isAlive())
			{
				flag = false;
			}
		}
		return flag;
	}
}
