import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your user name:");
        String userName = scanner.nextLine();
        System.out.println("Enter your user password:");
        String password = scanner.nextLine();

        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\97252\\Desktop\\driver\\chromedriver.exe"
        );
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.aac.ac.il/");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement menu = driver.findElement(By.id("menu-%d7%9b%d7%9c%d7%9c%d7%99"));
        if (menu != null) {
            List<WebElement> menuItems = driver.findElements(By.tagName("li"));
            WebElement personalInfo = menuItems.get(30);
            personalInfo.click();
        }
        WebElement userNameInput = driver.findElement(By.id("Ecom_User_ID"));
        if (userNameInput != null) {
            userNameInput.sendKeys(userName);
        }
        WebElement passwordInput = driver.findElement(By.id("Ecom_Password"));
        if (passwordInput != null) {
            passwordInput.sendKeys(password);
        }
        driver.findElement(By.id("wp-submit")).click();
        driver.get("https://moodle.aac.ac.il/login/index.php");

        WebElement courses = driver.findElement(By.id("nav-drawer"));
        if (courses != null) {
            List<WebElement> coursesName = courses.findElements(By.tagName("li"));
            for (int i = 0; i < coursesName.size(); i++) {
                WebElement courseName = coursesName.get(i);
                System.out.println(i + ":" + courseName.getText());

            }
            System.out.println("Choose a course number:");
            String courseNumber = scanner.nextLine();
            WebElement courseInfo = coursesName.get(Integer.parseInt(courseNumber));
            courseInfo.click();
        }
        driver.get("https://portal.aac.ac.il/");
        WebElement exit = driver.findElement(By.id("menu-top-header"));
        if (exit != null) {
            List<WebElement> exitWebsite = exit.findElements(By.tagName("li"));
            WebElement website = exitWebsite.get(1);
            website.click();

        }

    }
}