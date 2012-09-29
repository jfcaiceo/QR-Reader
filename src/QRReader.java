import java.io.FileInputStream;
import java.util.Enumeration;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.result.ResultParser;
import com.google.zxing.common.HybridBinarizer;

public class QRReader implements Resource{

	// Create the listener list
    protected javax.swing.event.EventListenerList listenerList =
        new javax.swing.event.EventListenerList();
	
	public void consume(Object data) {
		read(data);
	}
	
	private void read(Object obj){

		Result result = null;
		BinaryBitmap binaryBitmap;

		try{
			FileInputStream file = (FileInputStream) obj;
			binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(file))));

			result = new MultiFormatReader().decode(binaryBitmap);
			
			ResultParser.parseResult(result).getType().toString();
			
			QRCode code = new QRCode(result.getText(), ResultParser.parseResult(result).getType().toString());

			//Fire the event with the QRCode
			fireFinishedEvent(new ResourceEvent(this, code));

		}catch(Exception ex){

			fireFinishedEvent(new ResourceEvent(this, null));
		}

	}

    // This methods allows classes to register for MyEvents
    public void addListener(ResourceEventListener listener) {
        listenerList.add(ResourceEventListener.class, listener);
    }

    // This methods allows classes to unregister for MyEvents
    public void removeListener(ResourceEventListener listener) {
        listenerList.remove(ResourceEventListener.class, listener);
    }

    // This private class is used to fire MyEvents
    void fireFinishedEvent(ResourceEvent evt) {
        Object[] listeners = listenerList.getListenerList();
        // Each listener occupies two elements - the first is the listener class
        // and the second is the listener instance
        for (int i=0; i<listeners.length; i+=2) {
            if (listeners[i]==ResourceEventListener.class) {
                ((ResourceEventListener)listeners[i+1]).resourceEventFinished(evt);
            }
        }
    }
}
