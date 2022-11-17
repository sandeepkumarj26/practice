package genaricUtility;

import java.util.Set;

public class webDriverUtility extends BaseClass{
	public static void switchingWindow(Set<String>allid) {
		for(String id:allid) {
			driver.switchTo().window(id);
		}
	}
	public static void switchingToBackWindow(String id) {
		driver.switchTo().window(id);
	}
	public static void switchingToFrame(String FrameRef) {
		try {
		driver.switchTo().frame(FrameRef);	
		}catch(Exception demo) {
			int index = Integer.parseInt(FrameRef);
			driver.switchTo().frame(index);
		}
	}

}
