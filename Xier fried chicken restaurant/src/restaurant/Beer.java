package restaurant;

import java.time.LocalDate;

public class Beer extends Drinks{
protected float alcoholDegree;//�ƾ�����
public Beer(String name, double cost, LocalDate productionDate, float alcoholDegree) {
	super(name, cost, productionDate, 30);//�����ʼ����������Ϊ30��
	this.alcoholDegree=alcoholDegree;
}
public float getAlcoholDegree() {
	return alcoholDegree;
}
public void setAlcoholDegree(float alcoholDegree) {
	this.alcoholDegree = alcoholDegree;
}

}
