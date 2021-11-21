package bootcamp.utils;

import org.openqa.selenium.By;

import java.util.Set;

public class Helper {
    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String firstTab = Driver.get().getWindowHandle();

    public static void switchLastTab() {
        String originTab = Driver.get().getWindowHandle();
        Set<String> allTabs = Driver.get().getWindowHandles();

        for(String tab : allTabs){
            if(!originTab.equals(tab))
                Driver.get().switchTo().window(tab);
        }
    }
    public static void switchFirstTab() {
        Driver.get().switchTo().window(firstTab);
    }
}
