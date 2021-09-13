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
        long counter = 0L;
        while (!gevonden) {
            counter++;
            driver.get("https://www.ticketswap.com/event/born-bad-evening-vox-low-le-villejuif-underground-bryans-magic-tears/regular-tickets/32ae0587-064a-4cb2-b600-1f2a562f10bc/1695046");
            var myLinks = driver.findElements(By.xpath("/html/body/div[1]/div[3]/div[3]/ul/li[1]/a"));
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
