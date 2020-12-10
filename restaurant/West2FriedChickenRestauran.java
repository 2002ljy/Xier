package restaurant;
import java.util.LinkedList;
import java.util.Iterator;
import java.time.LocalDate;
public class West2FriedChickenRestauran implements FriedChickenRestaurant{
public float accountBalance;//�˻����
//��������洢ơ�ƣ���֭���ײ��б���Ϊ���ۡ���������ʹ����ɾ����������Ч�ʸ��ߣ�
//���������б�ÿ���ӻ�ɾ��Ԫ�ض�Ҫ��������ȫ��Ԫ�ؽ����ƶ���Ч�ʵ�
public LinkedList<Beer> beer= new LinkedList<Beer>();//ơ���б�
public LinkedList<Juice> juice= new LinkedList<Juice>();//��֭�б�
public static LinkedList<SetMeal> meal = new LinkedList<SetMeal>();//�ײ��б�
public West2FriedChickenRestauran(float accountBalance) {
	super();
	this.accountBalance = accountBalance;
	//�ײ������۸�ը�������������ͣ�ơ�ƶ���
	meal.add(new SetMeal("�ײ�1", 33.0, "ըȫ��", new Juice("��֭", 5, LocalDate.parse("2020-12-06"))));
	meal.add(new SetMeal("�ײ�2", 18.0, "ը�뼦", new Juice("��֭", 5, LocalDate.parse("2020-12-06"))));
	meal.add(new SetMeal("�ײ�3", 31.0, "ըȫ��", new Beer("ơ��", 5, LocalDate.parse("2020-12-06"),(float) 3)));
	meal.add(new SetMeal("�ײ�4", 16.0, "ը�뼦", new Beer("ơ��", 5, LocalDate.parse("2020-12-06"),(float) 3)));
	meal.add(new SetMeal("�ײ�5", 50.0, "��ֻȫ��", new Juice("��֭", 5, LocalDate.parse("2020-12-06"))));
}
boolean flag_beer=false;//�ж��Ƿ���ơ��
boolean flag_juice=false;//�ж��Ƿ��й�֭
private void use(Beer b) {
	Iterator<Beer> i = beer.iterator();
	for(;i.hasNext();)//�Ƴ���������
	{
		if(i.next().isOverdue())
			i.remove();
	}
	//�鿴�Ƴ��������Ϻ��Ƿ������Ͽ�����
	if(beer.isEmpty())//�����Ͽ��ۣ��׳��쳣
		throw new IngredientSortOutException("ơ�������������ײ��޷����ۣ���ǰ�˻���"+accountBalance);
	if(!beer.isEmpty())
	{
		beer.removeFirst();//���ۺ�����б���ɾ��
		flag_beer=true;
	}
	
}

private void use(Juice j) {
	Iterator<Juice> i=juice.iterator();
	for(;i.hasNext();)//�Ƴ���������
	{
		if(i.next().isOverdue())
			i.remove();
	}
	//�鿴�Ƴ��������Ϻ��Ƿ������Ͽ�����
	if(juice.isEmpty())//�����Ͽ��ۣ��׳��쳣
		throw new IngredientSortOutException("��֭�����������ײ��޷����ۣ���ǰ�˻���"+accountBalance);
	if(!juice.isEmpty())
	{
		juice.removeFirst();//���ۺ�����б���ɾ��
		flag_juice=true;
	}
	
}
public void sell(SetMeal taocan) throws IngredientSortOutException {
	try {
	if((taocan.getDrinkType() instanceof Beer)&&!beer.isEmpty()) {
		
		Beer b=beer.getFirst();
			use(b);//�Ƴ��������ϼ���������
		if(flag_beer)//�����������ơ���ײ�
		{
			String mealOut = taocan.getMealName();
			switch (mealOut) {
			//���ײ�3��4�в���ơ�ƣ���ֻ��3��4�ײ�
			case "�ײ�3":
				accountBalance +=  31.0;//׬Ǯ����
				if (beer.isEmpty()) {//use���ѽ��ɹ����۵������Ƴ��б��ˣ���Ϊ��ʱ��Ϊ���һ���ײ�
					System.out.println("���ѳɹ�����������ײ�Ϊ");
					System.out.println(	taocan.toString());
					throw new IngredientSortOutException("�ײ�3���۳ɹ���Ŀǰ�ײ�3�����ꡣ");
				} else {
					System.out.println("���ѳɹ�����������ײ�Ϊ");
					System.out.println(	taocan.toString());
				}
				break;
			case "�ײ�4":
				accountBalance+= 16.0;
				if (beer.isEmpty()) {//use���ѽ��ɹ����۵������Ƴ��б��ˣ���Ϊ��ʱ��Ϊ���һ���ײ�
					System.out.println("���ѳɹ�����������ײ�Ϊ");
					System.out.println(	taocan.toString());
					throw new IngredientSortOutException("�ײ�4���۳ɹ���Ŀǰ�ײ�4�����ꡣ");
				} else {
					System.out.println("���ѳɹ�����������ײ�Ϊ");
					System.out.println(	taocan.toString());
				}
				break;
		}
		
	}
}
	else if((taocan.getDrinkType() instanceof Juice)&&!juice.isEmpty()){
		Juice j=juice.getFirst();
		use(j);//�Ƴ��������ϼ���������
		if(flag_juice)//����������۹�֭�ײ�
		{
			String mealOut = taocan.getMealName();
			//���ײ�1��2��5�в���ơ�ƣ���ֻ��1��2��5�ײ�
			switch (mealOut) {
			case "�ײ�1":
				accountBalance +=33.0;
				if (juice.isEmpty()) {//use���ѽ��ɹ����۵������Ƴ��б��ˣ���Ϊ��ʱ��Ϊ���һ���ײ�
					System.out.println("���ѳɹ�����������ײ�Ϊ");
					System.out.println(	taocan.toString());
					throw new IngredientSortOutException("�ײ�1���۳ɹ���Ŀǰ�ײ�1�����ꡣ");
				} else {
					System.out.println("���ѳɹ�����������ײ�Ϊ");
					System.out.println(	taocan.toString());
				}
				break;
			case "�ײ�2":
				accountBalance += 18.0;
				if (juice.isEmpty()) {//use���ѽ��ɹ����۵������Ƴ��б��ˣ���Ϊ��ʱ��Ϊ���һ���ײ�
					System.out.println("���ѳɹ�����������ײ�Ϊ");
					System.out.println(	taocan.toString());
					throw new IngredientSortOutException("�ײ�2���۳ɹ���Ŀǰ�ײ�2������");
				} else {
					System.out.println("���ѳɹ�����������ײ�Ϊ");
					System.out.println(	taocan.toString());
				}
				break;
			case "�ײ�5":
				accountBalance +=  50.0;
				if (juice.isEmpty()) {//use���ѽ��ɹ����۵������Ƴ��б��ˣ���Ϊ��ʱ��Ϊ���һ���ײ�
					System.out.println("���ѳɹ�����������ײ�Ϊ");
					System.out.println(	taocan.toString());
					throw new IngredientSortOutException("�ײ�5���۳ɹ���Ŀǰ�ײ�5������");
				} else {
					System.out.println("���ѳɹ�����������ײ�Ϊ");
					System.out.println(	taocan.toString());
				}
				break;
			}
	}
	}
}catch(Exception e) {
		throw new IngredientSortOutException("����"+taocan.getDrinkType().getName()+"���㣬"+taocan.getMealName()+"����������ǰ�˻���"+accountBalance);
	}
}
public void purchase(Drinks drinkType, int count, int price) throws OverdraftBalanceException {//�������ͣ�������������Ʒ����
	int total=count*price;//��������ܼ�
	if (drinkType instanceof Beer) {//����ơ��
		if (total > accountBalance) {//�����˻����׳��쳣
			throw new OverdraftBalanceException("����ʧ�ܣ��˻����㣬������ơ�ƻ���Ҫ" + (total - accountBalance) + "Ԫ");
		} else {
			for (int i = 0; i < count; i++) {
				Beer b=new Beer("ơ��", 5,drinkType.getProductionDate(), (float) 5.0);
				beer.add(b);//�����б�
			}
			accountBalance -= total;//�˻�����Ǯ
			System.out.println("�ɹ�����" + count + "ƿơ��"+"���ķ�"+total+"Ԫ����ǰ�˻���"+accountBalance);
		}
	} else {//������֭
		if (total > accountBalance) {//�����˻����׳��쳣
			throw new OverdraftBalanceException("����ʧ�ܣ��˻����㣬��������֭����Ҫ" + (total - accountBalance) + "Ԫ");
		} else {
			for (int i = 0; i < count; i++) {
				Juice j=new Juice(drinkType.getName(),drinkType.getCost(),drinkType.getProductionDate());
				juice.add(j);//�����б�
			}
			accountBalance -= total;//�˻�����Ǯ
			System.out.println("�ɹ�����" + count + "ƿ��֭"+"���ķ�"+total+"Ԫ����ǰ�˻���"+accountBalance);
		}
	}
}

}
