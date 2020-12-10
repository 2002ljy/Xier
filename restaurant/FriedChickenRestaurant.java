package restaurant;
public interface FriedChickenRestaurant {
void sell(SetMeal taocan) throws IngredientSortOutException;//出售套餐
void purchase(Drinks drinkType,int count,int price)throws OverdraftBalanceException;//批量进货
}
