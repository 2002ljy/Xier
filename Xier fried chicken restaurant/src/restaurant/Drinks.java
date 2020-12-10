package restaurant;
import java.time.LocalDate;
public abstract class Drinks {
protected String name;//名字
protected double cost;//成本
protected LocalDate productionDate;//生产日期
protected int expirationDate;//保质期
//名字，成本，生产日期，保质期
public Drinks(String name, double cost, LocalDate productionDate, int expirationDate) {//全参构造函数
	super();
	this.name = name;
	this.cost = cost;
	this.productionDate = productionDate;
	this.expirationDate = expirationDate;
}
public boolean isOverdue() {//判断当前是否过期的方法
	LocalDate a=LocalDate.now();
	int dates;
	dates=Math.abs((int)(a.toEpochDay()-this.productionDate.toEpochDay()));//利用LocalDate自带的方法计算是否过期
	if(dates>expirationDate)
		return true;
	else
		return false;
}
public String toString() {
	return "Drinks [name=" + name + ", cost=" + cost + ", productionDate=" + productionDate + ", expirationDate="
			+ expirationDate + "]";
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getCost() {
	return cost;
}
public void setCost(double cost) {
	this.cost = cost;
}
public LocalDate getProductionDate() {
	return productionDate;
}
public void setProductionDate(LocalDate productionDate) {
	this.productionDate = productionDate;
}
public int getExpirationDate() {
	return expirationDate;
}
public void setExpirationDate(int expirationDate) {
	this.expirationDate = expirationDate;
}

}

