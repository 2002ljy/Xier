package restaurant;
import java.time.LocalDate;
public abstract class Drinks {
protected String name;//����
protected double cost;//�ɱ�
protected LocalDate productionDate;//��������
protected int expirationDate;//������
//���֣��ɱ����������ڣ�������
public Drinks(String name, double cost, LocalDate productionDate, int expirationDate) {//ȫ�ι��캯��
	super();
	this.name = name;
	this.cost = cost;
	this.productionDate = productionDate;
	this.expirationDate = expirationDate;
}
public boolean isOverdue() {//�жϵ�ǰ�Ƿ���ڵķ���
	LocalDate a=LocalDate.now();
	int dates;
	dates=Math.abs((int)(a.toEpochDay()-this.productionDate.toEpochDay()));//����LocalDate�Դ��ķ��������Ƿ����
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

