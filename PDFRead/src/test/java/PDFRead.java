import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PDFRead {

	@Test
	
	public void readPDFTest() throws IOException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://support.smartbear.com/support/media/pdf/6_Tips_for_Automated_Test.pdf");
		
		String currentUrl =driver.getCurrentUrl();
		System.out.println(currentUrl);
		
		URL url = new URL("http://support.smartbear.com/support/media/pdf/6_Tips_for_Automated_Test.pdf");
		//URL url = new URL("file:///C:/Users/pc/Downloads/CONTENTS%20(1).pdf");
		
		InputStream is = url.openStream();
		
		BufferedInputStream fileParse = new BufferedInputStream(is);
	
		PDDocument document = null;
	
		document = PDDocument.load(fileParse);
		String pdfContent =	new PDFTextStripper().getText(document);
		System.out.println(pdfContent);
	
		Assert.assertTrue(pdfContent.contains("Automated testing will shorten your"));
		Assert.assertTrue(pdfContent.contains("development cycles, avoid cumbersome"));
		Assert.assertTrue(pdfContent.contains("repetitive tasks and help improve software"));

	
	
	}
	
	
	
}
