package restaurant;

public class IngredientSortOutException extends RuntimeException {
	private static final long serialVersionUID = 1L;//Ϊ����������ӵ�
	public IngredientSortOutException() {
		super();
	}
	public IngredientSortOutException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public IngredientSortOutException(String message, Throwable cause) {
		super(message, cause);
	}
	public IngredientSortOutException(String message) {
		super(message);
	}
	public IngredientSortOutException(Throwable cause) {
		super(cause);
	}
}
