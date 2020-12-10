package restaurant;

import java.time.LocalDate;

public class Juice extends Drinks{

	public Juice(String name, double cost, LocalDate productionDate) {
		super(name, cost, productionDate, 2);//父类初始化，保质期两天
		
	}
}
