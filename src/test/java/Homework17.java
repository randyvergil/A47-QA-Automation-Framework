import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{

    @Test

    public void addSongToPlaylist() throws InterruptedException {

    String newSongAddedNotificationText = "Added one song int";

    navigateToPage();
    provideEmail("randy.davila@testpro.io");
    providePassword("te$t$tudent");
    clickSubmit();
    searchSong("Lament");
    clickViewAllBtn();
    selectFirstSongResult();
    clickAddBtn();
    choosePlaylist();
        Assert.assertTrue(getNotificationText().contains(newSongAddedNotificationText));






















    }
}
