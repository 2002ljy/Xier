package restaurant;
public interface FriedChickenRestaurant {
void sell(SetMeal taocan) throws IngredientSortOutException;//�����ײ�
void purchase(Drinks drinkType,int count,int price)throws OverdraftBalanceException;//��������
}
