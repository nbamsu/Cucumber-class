package API.utils;


import Utils.Driver;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class CMDUtil {
    @Test
    public void executeCMD() throws IOException, InterruptedException {
        String[] commands = {"/bin/sh", "-c", "cd C:\\Users\\Nurkulov\\Atlassian\\JIRA\\bin;start-jira.bat /fg"};
        // Process process = Runtime.getRuntime().exec(commands);
        List<String> cmdList = new ArrayList<String>();//"C:\\Users\\Nurkulov\\Atlassian\\JIRA\\bin"
        cmdList.add("cmd");
        cmdList.add("/c");
        cmdList.add("cd C:\\Users\\Nurkulov\\Atlassian\\JIRA\\bin;start-jira.bat /fg");

        Process process=Runtime.getRuntime().exec("cmd /c start-jira.bat", null,
                new File("C:\\Users\\Nurkulov\\Atlassian\\JIRA\\bin"));
        InputStream inputStream = process.getInputStream();
        List<String> output = IOUtils.readLines(inputStream,Charset.defaultCharset());
        System.out.println(output);
        Thread.sleep(15000);
        WebDriver driver = Driver.getDriver();
        driver.get("http://localhost:8080");

//        String[] commands = {"/bin/sh", "-c", "cd C:\\Users\\dddef\\Atlassian\\JIRA\\bin;start-jira.bat /fg"};
//        // Process process = Runtime.getRuntime().exec(commands);
//        List<String> cmdList = new ArrayList<String>();
//        cmdList.add("cmd");
//        cmdList.add("/c");
//        cmdList.add("cd C:\\Users\\dddef\\Atlassian\\JIRA\\bin");
//        cmdList.add("start-jira.bat /fg");
//        ProcessBuilder builder = new ProcessBuilder();
//        builder.command(cmdList);
//        Process process = builder.start();





    }
}
