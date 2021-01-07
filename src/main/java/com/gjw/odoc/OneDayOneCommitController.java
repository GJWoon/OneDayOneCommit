package com.gjw.odoc;


import javax.servlet.http.HttpServletRequest;


import java.util.Collections;
import java.util.List;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OneDayOneCommitController {

	@RequestMapping(value="aa.do") 
public ModelAndView pageGo(ModelAndView mv) {
		
		mv.setViewName("OneDayOneCommitPage");
		return mv;
	}
	
	
	public ChromeDriver driver =null;
	@RequestMapping(value="OneDayOneCommit.do")
	  public  ModelAndView runSelenium(ModelAndView mv,HttpServletRequest request){
	        System.setProperty("webdriver.chrome.driver","C:/chromedriver.exe");
	        ChromeOptions options = new ChromeOptions();
	        //options.addArguments("--headless");                 // Browser를 띄우지 않음
	        options.addArguments("--start-maximized");          // 최대크기로
	        options.addArguments("--headless");                 // Browser를 띄우지 않음
	        options.addArguments("--disable-gpu");              // GPU를 사용하지 않음, Linux에서 headless를 사용하는 경우 필요함.
	        options.addArguments("--no-sandbox");              // Sandbox 프로세스를 사용하지 않음, Linux에서 headless를 사용하는 경우 필요함.
	        List<WebElement>list =null;
	        driver = new ChromeDriver(options);
	        String dlist[] = new String[7];
	        String clist[] =new String[7];
	        try {
	            WebDriverWait wait = new WebDriverWait(driver,10);
	 	       //data =data1;
	 	        	// 4. 웹페이지 요청
	            String url = request.getParameter("url");
	 	        driver.get("https://github.com/"+url);
	 	        //WebElement data = driver.findElement(By.className("day")).getText();
	 	      list =driver.findElements(By.className("day"));
	 	      System.out.println(driver.getPageSource());

	 	      System.out.println(list.size());
	 	      Collections.reverse(list);
	 	 	for(int i=0; i<7; i++) {
	 	 		String ii=list.get(i).getAttribute("data-date");
	 	 		dlist[i] = ii;
	 	 		System.out.println(ii);
	 	 		String iii =list.get(i).getAttribute("data-count");
	 	 		clist[i] = iii;
	 	 		System.out.println(iii);
	 	 	}
	 	 		        } catch (Exception e ) {
	            System.out.println("목록을 찾을 수 없습니다.");
	            e.printStackTrace();
	        } finally {            
	            // 9. HTML 저장.
	        	System.out.println("sad");
	        }
	       mv.addObject("countlist",clist);
	       mv.addObject("datelist",dlist);
	        mv.setViewName("aaaa");
	        driver.close();
	      driver.quit();
	        return mv;
	      //datelist.add(String.valueOf(list.get(i).getAttribute("data-date")));
 	    	//countlist.add(String.valueOf(list.get(i).getAttribute("data-count")));
	    }

}
