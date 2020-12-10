package restaurant;

public class OverdraftBalanceException extends RuntimeException {

	private static final long serialVersionUID = 1L;//Ϊ����������ӵ�
public OverdraftBalanceException() {
	super();
}

public OverdraftBalanceException(String message, Throwable cause, boolean enableSuppression,
		boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
}

public OverdraftBalanceException(String message, Throwable cause) {
	super(message, cause);
}

public OverdraftBalanceException(String message) {
	super(message);
}

public OverdraftBalanceException(Throwable cause) {
	super(cause);
}
}
