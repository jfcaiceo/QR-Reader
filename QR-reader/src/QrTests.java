import static org.junit.Assert.*;

import java.io.File;

import junit.framework.Assert;

import org.junit.Test;


public class QrTests {

	@Test
	public void testURIType() {
		String[] obj = new String[1];
		File relative = new File("CodigosQR/Wikipedia.png");
		obj[0] = relative.getAbsolutePath();
		
		Resource qr = new QRReader();
		QRObserver observer = new QRObserver();
		qr.setObserver(observer);
		qr.reciveAction(obj, 0);
		QRCode code = (QRCode)observer.getQRCode();
		
		assertEquals("URI", code.getType());
	}
	
	

}
