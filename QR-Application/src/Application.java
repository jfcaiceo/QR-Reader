
import java.util.ArrayList;
import java.util.HashMap;

import external.*;

public abstract class Application{

	String appID;
	String version;
	IDevice currentDevice;
	ApplicationListener listener;
	DeviceState state;
	
	ICommunicationMgr communicationMgr;	
	IPersistenceMgr persistenceMgr;
	IResourceMgr resourceMgr;

	//ApplicationDaemon deamon;
	
	HashMap<Integer, DeviceState> connectedDevices = new HashMap<Integer, DeviceState>();
	ArrayList<IResource> resources = new ArrayList<IResource>();

	
	
	// Lista con dispositivos, recursos solicitados y recursos asignados
	HashMap<DeviceState,ArrayList<IResource>> assignedDevices = new HashMap<DeviceState, ArrayList<IResource>>();
	
	public void run(){
		
	}
	
	public HashMap<DeviceState, ArrayList<IResource>> getAssignedDevices() {
		return assignedDevices;
	}


	// Agregar-remover dispositivos al entorno de la aplicacion
	public void addDevice(DeviceState device){
		this.connectedDevices.put(new Integer(device.getId()) , device);
	}

	public boolean removeDevice(DeviceState device){

		for( Integer i : connectedDevices.keySet() ){
			if(i.intValue() == device.getId()){
				connectedDevices.remove(i);
				return true;
			}			
		}
		return false;
	}



	
	//Guardar estado de la aplicaci�n
	public void saveAppState(){
		persistenceMgr.saveAppState(this);
	}

	public ArrayList<IResource> getResources() {
		// TODO Auto-generated method stub
		return resources;
	}


	public IResourceMgr getResourceMgr() {
		// TODO Auto-generated method stub
		return resourceMgr;
	}
	





}
