package restaurant;
import java.time.LocalDate;
import java.util.Scanner;
public class Test {
	public static void main(String[] args) throws OverdraftBalanceException, IngredientSortOutException {
		System.out.println("����������˻����:");
		Scanner scanner =new Scanner(System.in);
		float n=scanner.nextInt();
		scanner.close();
		West2FriedChickenRestauran w = new West2FriedChickenRestauran(n);
		System.out.println("���Խ���");
		System.out.println();
		//�����ܼ���150Ԫ������������
		//���֣��ɱ����������ڣ��ƾ�����������ƿ������Ʒ����
		w.purchase(new Beer("ơ��", 5, LocalDate.now(), (float) 5.0), 5, 5);//����5ƿ�ɳ���ơ��
		w.purchase(new Beer("ơ��", 5, LocalDate.parse("2019-12-02"), (float) 5.0), 10,5);//����10ƿ���ڲ��ɳ���ơ��
		//���֣��ɱ����������ڣ�����ƿ������Ʒ����
		w.purchase(new Juice("��֭", 5, LocalDate.now()), 5, 5);//����5ƿ�ɳ��۹�֭ 
		w.purchase(new Juice("��֭", 5, LocalDate.parse("2019-12-08")), 10, 5);//����10ƿ���ڲ��ɳ���ơ�� 
		System.out.println("�������");
		System.out.println();
		System.out.println();
		System.out.println("���Գ����ײ�");
		System.out.println();
		System.out.println();
		//�����о�������Ϊ��Щ�ײ�û���������ۣ�û���õ�
		SetMeal meal1=new SetMeal("�ײ�1", 33.0, "ըȫ��", new Juice("��֭", 5, LocalDate.parse("2020-12-06")));
		SetMeal meal2=new SetMeal("�ײ�2", 18.0, "ը�뼦", new Juice("��֭", 5, LocalDate.parse("2020-12-06")));
		SetMeal meal3=new SetMeal("�ײ�3", 31.0, "ըȫ��", new Beer("ơ��", 5, LocalDate.parse("2020-12-06"),(float) 5));
		SetMeal meal4=new SetMeal("�ײ�4", 16.0, "ը�뼦", new Beer("ơ��", 5, LocalDate.parse("2020-12-06"),(float) 5));
		SetMeal meal5=new SetMeal("�ײ�5", 50.0, "��ֻȫ��", new Juice("��֭", 5, LocalDate.parse("2020-12-06")));
		int i;
		System.out.println("����ơ�Ʋ���");
		for(i=0;i<20;i++)//������10ƿ����ơ�ƺ�5ƿδ����ơ�ƣ�ֻ�ܳ���5�ݾ��׳��쳣
		w.sell(meal4);
//		System.out.println("���۹�֭����");
//		for(i=0;i<20;i++)//������5ƿ���ڹ�֭��10ƿδ���ڹ�֭��ֻ�ܳ���5��
//		w.sell(meal1);
		
	}
	}
