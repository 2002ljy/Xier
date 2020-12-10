package restaurant;
import java.time.LocalDate;
import java.util.Scanner;
public class Test {
	public static void main(String[] args) throws OverdraftBalanceException, IngredientSortOutException {
		System.out.println("请输入店主账户余额:");
		Scanner scanner =new Scanner(System.in);
		float n=scanner.nextInt();
		scanner.close();
		West2FriedChickenRestauran w = new West2FriedChickenRestauran(n);
		System.out.println("测试进货");
		System.out.println();
		//进货总价需150元，共进四批货
		//名字，成本，生产日期，酒精度数，进货瓶数，商品单价
		w.purchase(new Beer("啤酒", 5, LocalDate.now(), (float) 5.0), 5, 5);//进货5瓶可出售啤酒
		w.purchase(new Beer("啤酒", 5, LocalDate.parse("2019-12-02"), (float) 5.0), 10,5);//进货10瓶过期不可出售啤酒
		//名字，成本，生产日期，进货瓶数，商品单价
		w.purchase(new Juice("果汁", 5, LocalDate.now()), 5, 5);//进货5瓶可出售果汁 
		w.purchase(new Juice("果汁", 5, LocalDate.parse("2019-12-08")), 10, 5);//出售10瓶过期不可出售啤酒 
		System.out.println("测试完毕");
		System.out.println();
		System.out.println();
		System.out.println("测试出售套餐");
		System.out.println();
		System.out.println();
		//这里有警告是因为这些套餐没有用来出售，没有用到
		SetMeal meal1=new SetMeal("套餐1", 33.0, "炸全鸡", new Juice("果汁", 5, LocalDate.parse("2020-12-06")));
		SetMeal meal2=new SetMeal("套餐2", 18.0, "炸半鸡", new Juice("果汁", 5, LocalDate.parse("2020-12-06")));
		SetMeal meal3=new SetMeal("套餐3", 31.0, "炸全鸡", new Beer("啤酒", 5, LocalDate.parse("2020-12-06"),(float) 5));
		SetMeal meal4=new SetMeal("套餐4", 16.0, "炸半鸡", new Beer("啤酒", 5, LocalDate.parse("2020-12-06"),(float) 5));
		SetMeal meal5=new SetMeal("套餐5", 50.0, "两只全鸡", new Juice("果汁", 5, LocalDate.parse("2020-12-06")));
		int i;
		System.out.println("出售啤酒测试");
		for(i=0;i<20;i++)//进货了10瓶过期啤酒和5瓶未过期啤酒，只能出售5份就抛出异常
		w.sell(meal4);
//		System.out.println("出售果汁测试");
//		for(i=0;i<20;i++)//进货了5瓶过期果汁和10瓶未过期果汁，只能出售5份
//		w.sell(meal1);
		
	}
	}
