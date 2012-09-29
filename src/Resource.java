
public interface Resource {
	public void consume(Object data);
	public void addListener(ResourceEventListener listener);
	public void removeListener(ResourceEventListener listener);

}
