package restaurant;

public class SetMeal {
protected String mealName;//�ײ���
protected double mealPrice;//�ײͼ۸�
protected String chickenName;//ը����
protected Drinks drinkType;//��������
public SetMeal(String mealName, double mealPrice, String chickenName, Drinks drinkType) {
	this.mealName = mealName;
	this.mealPrice = mealPrice;
	this.chickenName = chickenName;
	this.drinkType = drinkType;
}
public String toString() {
	return "SetMeal [mealName=" + mealName + ", mealPrice=" + mealPrice + ", chickenName=" + chickenName
			+ ", drinkType=" + drinkType + "]";
}
public String getMealName() {
	return mealName;
}
public void setMealName(String mealName) {
	this.mealName = mealName;
}
public double getMealPrice() {
	return mealPrice;
}
public void setMealPrice(double mealPrice) {
	this.mealPrice = mealPrice;
}
public String getChickenName() {
	return chickenName;
}
public void setChickenName(String chickenName) {
	this.chickenName = chickenName;
}
public Drinks getDrinkType() {
	return drinkType;
}
public void setDrinkType(Drinks drinkType) {
	this.drinkType = drinkType;
}

}
