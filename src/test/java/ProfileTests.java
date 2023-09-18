import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileTests extends BaseTest{

    @Test

    public void changeProfileName() throws InterruptedException {

        navigateToPage();

        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();

        Thread.sleep(2000);
        clickAvatarIcon();

        String randomName = generateRandomName();

        provideCurrentPassword("te$t$tudent");
        provideProfileName(randomName);
        clickSaveButton();

        Thread.sleep(2000);
        WebElement actualProfileName = driver.findElement(By.cssSelector("a.view-profile>span"));
        Assert.assertEquals(actualProfileName.getText(), randomName);
    }

    public void clickAvatarIcon(){
       WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
       avatarIcon.click();
    }

    public void provideCurrentPassword(String password){
        WebElement currentPassword = driver.findElement(By.cssSelector("[name='current_password']"));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }

    public void clickSaveButton(){
        WebElement saveButton = driver.findElement(By.cssSelector("button.btn-submit"));
        saveButton.click();
    }

    public void provideProfileName(String randomName){
        WebElement profileName = driver.findElement(By.cssSelector("[name='name']"));
        profileName.clear();
        profileName.sendKeys(randomName);
    }

    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
