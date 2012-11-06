package external;

public interface IPersistenceMgr {
	
	boolean saveDeviceState(DeviceState ds);
	DeviceState loadDeviceState(IDevice d);
	void saveAppState(Object application);

}
