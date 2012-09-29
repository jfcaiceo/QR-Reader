import java.util.EventListener;


public interface ResourceEventListener extends EventListener {
	public void resourceEventFinished(ResourceEvent evt);
}
