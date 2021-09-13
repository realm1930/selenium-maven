import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Arne Van Eycken
 * @version 1.0
 */

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", "D:\\Ruby30-x64\\bin\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();
        driver.get("https://browser.ticketswap.com/magic-link/69a1f8c6abd992c852d91188a0b2650c6006db81?locale=en&platform=web&flow=authentication");

        boolean gevonden = false;
        long counter = 0L;
        while (!gevonden) {
            counter++;
            System.out.print("Refresh nummer: "+counter);
            driver.get("https://www.ticketswap.com/event/boom-festival-2022/regular/35812929-0839-4edf-803c-a69261e939b4/1463104");
            //driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
            List<WebElement> myLinks = driver.findElements(By.xpath("//ul[@data-testid='available-tickets-list']/li[1]/a"));
            System.out.println(myLinks);
            if (myLinks.size() > 0){
                driver.get(myLinks.get(0).getAttribute("href"));
                driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[1]/div/div/form/div[3]/button")).click();
                gevonden = true;
                System.out.println("Ticket gevonden na "+counter+" keer refreshen.");
            }
        }
    }
}
