package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtility {

	public static String getTimeStamp() {
		
		Date dt= new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_YYYY_HH_mm_ss");
		String str = sdf.format(dt);
		return str;
	}
}
