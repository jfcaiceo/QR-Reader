package external;

import java.util.ArrayList;

public interface ICommunicationMgr{
	
	ArrayList<Object> requestDevicesOnline();
	boolean isDeviceOnline(int id);

}
