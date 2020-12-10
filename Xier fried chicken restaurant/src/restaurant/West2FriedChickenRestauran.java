package restaurant;
import java.util.LinkedList;
import java.util.Iterator;
import java.time.LocalDate;
public class West2FriedChickenRestauran implements FriedChickenRestaurant{
public float accountBalance;//账户余额
//采用链表存储啤酒，果汁，套餐列表，因为出售、进货经常使用增删操作，链表效率更高；
//若用数组列表，每增加或删除元素都要对其后面的全部元素进行移动，效率低
public LinkedList<Beer> beer= new LinkedList<Beer>();//啤酒列表
public LinkedList<Juice> juice= new LinkedList<Juice>();//果汁列表
public static LinkedList<SetMeal> meal = new LinkedList<SetMeal>();//套餐列表
public West2FriedChickenRestauran(float accountBalance) {
	super();
	this.accountBalance = accountBalance;
	//套餐名，价格，炸鸡名，饮料类型，啤酒度数
	meal.add(new SetMeal("套餐1", 33.0, "炸全鸡", new Juice("果汁", 5, LocalDate.parse("2020-12-06"))));
	meal.add(new SetMeal("套餐2", 18.0, "炸半鸡", new Juice("果汁", 5, LocalDate.parse("2020-12-06"))));
	meal.add(new SetMeal("套餐3", 31.0, "炸全鸡", new Beer("啤酒", 5, LocalDate.parse("2020-12-06"),(float) 3)));
	meal.add(new SetMeal("套餐4", 16.0, "炸半鸡", new Beer("啤酒", 5, LocalDate.parse("2020-12-06"),(float) 3)));
	meal.add(new SetMeal("套餐5", 50.0, "两只全鸡", new Juice("果汁", 5, LocalDate.parse("2020-12-06"))));
}
boolean flag_beer=false;//判断是否还有啤酒
boolean flag_juice=false;//判断是否还有果汁
private void use(Beer b) {
	Iterator<Beer> i = beer.iterator();
	for(;i.hasNext();)//移除过期饮料
	{
		if(i.next().isOverdue())
			i.remove();
	}
	//查看移除过期饮料后是否还有饮料可销售
	if(beer.isEmpty())//无饮料可售，抛出异常
		throw new IngredientSortOutException("啤酒已售罄，该套餐无法出售，当前账户余额："+accountBalance);
	if(!beer.isEmpty())
	{
		beer.removeFirst();//销售后将其从列表中删除
		flag_beer=true;
	}
	
}

private void use(Juice j) {
	Iterator<Juice> i=juice.iterator();
	for(;i.hasNext();)//移除过期饮料
	{
		if(i.next().isOverdue())
			i.remove();
	}
	//查看移除过期饮料后是否还有饮料可销售
	if(juice.isEmpty())//无饮料可售，抛出异常
		throw new IngredientSortOutException("果汁已售罄，该套餐无法出售，当前账户余额："+accountBalance);
	if(!juice.isEmpty())
	{
		juice.removeFirst();//销售后将其从列表中删除
		flag_juice=true;
	}
	
}
public void sell(SetMeal taocan) throws IngredientSortOutException {
	try {
	if((taocan.getDrinkType() instanceof Beer)&&!beer.isEmpty()) {
		
		Beer b=beer.getFirst();
			use(b);//移除过期饮料及销售饮料
		if(flag_beer)//如果可以销售啤酒套餐
		{
			String mealOut = taocan.getMealName();
			switch (mealOut) {
			//在套餐3、4中才有啤酒，故只用3、4套餐
			case "套餐3":
				accountBalance +=  31.0;//赚钱入账
				if (beer.isEmpty()) {//use中已将成功出售的饮料移出列表了，故为空时即为最后一份套餐
					System.out.println("消费成功，您购买的套餐为");
					System.out.println(	taocan.toString());
					throw new IngredientSortOutException("套餐3出售成功，目前套餐3已售完。");
				} else {
					System.out.println("消费成功，您购买的套餐为");
					System.out.println(	taocan.toString());
				}
				break;
			case "套餐4":
				accountBalance+= 16.0;
				if (beer.isEmpty()) {//use中已将成功出售的饮料移出列表了，故为空时即为最后一份套餐
					System.out.println("消费成功，您购买的套餐为");
					System.out.println(	taocan.toString());
					throw new IngredientSortOutException("套餐4出售成功，目前套餐4已售完。");
				} else {
					System.out.println("消费成功，您购买的套餐为");
					System.out.println(	taocan.toString());
				}
				break;
		}
		
	}
}
	else if((taocan.getDrinkType() instanceof Juice)&&!juice.isEmpty()){
		Juice j=juice.getFirst();
		use(j);//移除过期饮料及销售饮料
		if(flag_juice)//如果可以销售果汁套餐
		{
			String mealOut = taocan.getMealName();
			//在套餐1、2、5中才有啤酒，故只用1、2、5套餐
			switch (mealOut) {
			case "套餐1":
				accountBalance +=33.0;
				if (juice.isEmpty()) {//use中已将成功出售的饮料移出列表了，故为空时即为最后一份套餐
					System.out.println("消费成功，您购买的套餐为");
					System.out.println(	taocan.toString());
					throw new IngredientSortOutException("套餐1出售成功，目前套餐1已售完。");
				} else {
					System.out.println("消费成功，您购买的套餐为");
					System.out.println(	taocan.toString());
				}
				break;
			case "套餐2":
				accountBalance += 18.0;
				if (juice.isEmpty()) {//use中已将成功出售的饮料移出列表了，故为空时即为最后一份套餐
					System.out.println("消费成功，您购买的套餐为");
					System.out.println(	taocan.toString());
					throw new IngredientSortOutException("套餐2出售成功，目前套餐2已售完");
				} else {
					System.out.println("消费成功，您购买的套餐为");
					System.out.println(	taocan.toString());
				}
				break;
			case "套餐5":
				accountBalance +=  50.0;
				if (juice.isEmpty()) {//use中已将成功出售的饮料移出列表了，故为空时即为最后一份套餐
					System.out.println("消费成功，您购买的套餐为");
					System.out.println(	taocan.toString());
					throw new IngredientSortOutException("套餐5出售成功，目前套餐5已售完");
				} else {
					System.out.println("消费成功，您购买的套餐为");
					System.out.println(	taocan.toString());
				}
				break;
			}
	}
	}
}catch(Exception e) {
		throw new IngredientSortOutException("由于"+taocan.getDrinkType().getName()+"不足，"+taocan.getMealName()+"已售罄，当前账户余额："+accountBalance);
	}
}
public void purchase(Drinks drinkType, int count, int price) throws OverdraftBalanceException {//饮料类型，进货数量，商品单价
	int total=count*price;//计算进货总价
	if (drinkType instanceof Beer) {//进货啤酒
		if (total > accountBalance) {//超过账户余额，抛出异常
			throw new OverdraftBalanceException("进货失败，账户余额不足，进此批啤酒还需要" + (total - accountBalance) + "元");
		} else {
			for (int i = 0; i < count; i++) {
				Beer b=new Beer("啤酒", 5,drinkType.getProductionDate(), (float) 5.0);
				beer.add(b);//加入列表
			}
			accountBalance -= total;//账户减少钱
			System.out.println("成功进货" + count + "瓶啤酒"+"，耗费"+total+"元，当前账户余额："+accountBalance);
		}
	} else {//进货果汁
		if (total > accountBalance) {//超过账户余额，抛出异常
			throw new OverdraftBalanceException("进货失败，账户余额不足，进此批果汁还需要" + (total - accountBalance) + "元");
		} else {
			for (int i = 0; i < count; i++) {
				Juice j=new Juice(drinkType.getName(),drinkType.getCost(),drinkType.getProductionDate());
				juice.add(j);//加入列表
			}
			accountBalance -= total;//账户减少钱
			System.out.println("成功进货" + count + "瓶果汁"+"，耗费"+total+"元，当前账户余额："+accountBalance);
		}
	}
}

}
