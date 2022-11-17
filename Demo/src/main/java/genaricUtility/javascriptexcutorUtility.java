package genaricUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class javascriptexcutorUtility extends BaseClass {
public static JavascriptExecutor js=( JavascriptExecutor) driver;
public static void clickingOnElementUsingJavaScript(WebElement Element) {
	js.executeScript("arguments[0].click;", Element);
}
public static void EnteringDataToElementUsingJavaSript(WebElement element,String data) {
	js.executeScript("arguments[0].value='"+data+"';", element);
}
}
