package restaurant;

import java.time.LocalDate;

public class Beer extends Drinks{
protected float alcoholDegree;//酒精度数
public Beer(String name, double cost, LocalDate productionDate, float alcoholDegree) {
	super(name, cost, productionDate, 30);//父类初始化，保质期为30天
	this.alcoholDegree=alcoholDegree;
}
public float getAlcoholDegree() {
	return alcoholDegree;
}
public void setAlcoholDegree(float alcoholDegree) {
	this.alcoholDegree = alcoholDegree;
}

}
