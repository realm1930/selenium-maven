import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * @author Arne Van Eycken
 * @version 1.0
 */

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", "D:\\Ruby30-x64\\bin\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();
        driver.get("https://www.ticketswap.com");

        boolean gevonden = false;
        while (!gevonden) {
            driver.get("https://www.ticketswap.com/event/boom-festival-2022/regular/35812929-0839-4edf-803c-a69261e939b4/1463104");
            var myLinks = driver.findElements(By.xpath("/html/body/div[1]/div[3]/div[3]/ul/li[1]/a"));
            System.out.println(myLinks);
            if (myLinks.size() > 0){
                driver.get(myLinks.get(0).getAttribute("href"));
                driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[1]/div/div/form/div[3]/button")).click();
                gevonden = true;
            }
        }
    }
}
