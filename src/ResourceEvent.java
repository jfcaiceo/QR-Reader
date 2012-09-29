import java.util.EventObject;


public class ResourceEvent extends EventObject{
	private Object data;
	
	public ResourceEvent(Object source, Object data) {
		super(source);
		this.data = data;
	}
	
	public Object getData() {
		return data;
	}

}
