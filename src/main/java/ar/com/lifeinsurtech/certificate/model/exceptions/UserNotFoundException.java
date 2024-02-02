package ar.com.lifeinsurtech.certificate.model.exceptions;

public class UserNotFoundException  extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(){
        super("There is not a registered user with that ID");
        this.setStackTrace(new StackTraceElement[0]);
    }
}
