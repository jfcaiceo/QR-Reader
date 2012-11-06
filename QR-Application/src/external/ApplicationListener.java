package external;

import java.util.ArrayList;
import java.util.HashMap;

public class ApplicationListener {
	
	IApplication app;
	
		
	// otorgar un recurso a alg�n dipositivo
	public boolean handleResourceRequest(IDevice sender , String resourceType){
		ArrayList<IResource> resources = app.getResources();
		HashMap<IDevice,ArrayList<IResource>> assignedDevices = app.getAssignedDevices();
		
		for(IResource r : resources){
			if(r.getType().equals(resourceType) && app.getResourceMgr().isAvailable(r)){
				
				if(!assignedDevices.containsKey(sender)){
					ArrayList<IResource> a = new ArrayList<IResource>();
					a.add(r);
					assignedDevices.put(sender, a);					
				}
				else{
					assignedDevices.get(sender).add(r);
				}							
				
				return true;
			}
		}
		return false;
	}


}
