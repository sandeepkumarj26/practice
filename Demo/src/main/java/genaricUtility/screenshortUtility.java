package genaricUtility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class screenshortUtility extends BaseClass implements IAutoConstants {
	public static String tackingScreenshort(String screenshortName) throws IOException {
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File photo = screenshot.getScreenshotAs(OutputType.FILE);
		
		String ldt = LocalDateTime.now().toString().replace(':' , '-');
		//File storage=new File(ERRORSHORTS+screenshortName+" "+ldt+".png");
		String destination = System.getProperty("user.dir")+ERRORSHORTS+screenshortName+" "+ldt+".png";
		File dest=new File(destination);
		FileUtils.copyFile(photo,dest);
		return destination;
	}

	
		
	}


