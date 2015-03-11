package know.io;

import know.IO;
import java.io.File;
import know.Virtual;

public enum Bat implements Virtual {

    FITNESSE(new IO("C:/selenium/golden/target/bin", "fitnesse", "bat", "@echo off\nif exist C:\\bin\\fitnesse\\FitNesseRoot rmdir /s /q C:\\bin\\fitnesse\\FitNesseRoot\nstart java -jar C:\\bin\\fitnesse\\fitnesse-standalone.jar -p 121 -d C:\\bin\\fitnesse\nexit")), DB_LOGIN(new IO("C:/selenium/golden/target/bin", "dblogin", "bat", "@ECHO OFF\nstart C:\\bin\\mysql\\bin\\mysql.exe -u root")),
    DB_ADMIN(new IO("C:/selenium/golden/target/bin", "dbadmin", "bat", "@ECHO OFF\nC:\\bin\\mysql\\bin\\mysql.exe -u root --execute=%1% | echo %%i% > C:\\selenium\\golden\\target\\log\\allDatabases.log\nexit")),
    DB_CREATE(new IO("C:/selenium/golden/target/bin", "create", "bat", "@ECHO OFF\nC:\\bin\\mysql\\bin\\mysql.exe -u root --execute=\"create database %1%\"\nexit")),
    DB_SAVE(new IO("C:/selenium/golden/target/bin", "dbsave", "bat", "@ECHO OFF\nC:\\bin\\mysql\\bin\\mysqldump.exe --databases selenium -u root > C:\\selenium\\golden\\target\\log\\selenium.sql\nexit")),
    DB_LOG(new IO("C:/selenium/golden/target/bin", "log", "bat", "@ECHO OFF\nif exist C:\\selenium\\golden\\target\\log\\desc rmdir /s /q C:\\selenium\\golden\\target\\log\\desc\nif exist C:\\selenium\\golden\\target\\log\\select rmdir /s /q C:\\selenium\\golden\\target\\log\\select\nmkdir C:\\selenium\\golden\\target\\log\\desc\nmkdir C:\\selenium\\golden\\target\\log\\select\nstart C:\\selenium\\golden\\target\\bin\\dbcommand.bat \"desc node\" \"desc\\node.log\"\nstart C:\\selenium\\golden\\target\\bin\\dbcommand.bat \"select * from node\" \"select\\node.log\"\nstart C:\\selenium\\golden\\target\\bin\\dbcommand.bat \"desc edge\" \"desc\\edge.log\"\nstart C:\\selenium\\golden\\target\\bin\\dbcommand.bat \"select * from edge\" \"select\\edge.log\"\n\nstart C:\\selenium\\golden\\target\\bin\\dbcommand.bat \"desc api\" \"desc\\api.log\"\nstart C:\\selenium\\golden\\target\\bin\\dbcommand.bat \"select * from api\" \"select\\api.log\"\nstart C:\\selenium\\golden\\target\\bin\\dbsave.bat")),
    DB_COMMAND(new IO("C:/selenium/golden/target/bin", "dbcommand", "bat", "@ECHO OFF\nC:\\bin\\mysql\\bin\\mysql.exe selenium -u root --execute=%1% | echo %%i% > C:\\selenium\\golden\\target\\log\\%2%\nexit")),
    DB_GOLDEN(new IO("C:/selenium/golden/target/bin", "dbgolden", "bat", "@ECHO OFF\nstart dbadmin.bat \"show databases\"")),
    DB_CLEAN(new IO("C:/selenium/golden/target/bin", "dbclean", "bat", "@ECHO OFF\nC:\\bin\\mysql\\bin\\mysql.exe -u root --execute=\"drop database selenium\"\nC:\\bin\\mysql\\bin\\mysql.exe -u root --execute=\"create database selenium\"")),
    DB_DROP(new IO("C:/selenium/golden/target/bin", "drop", "bat", "@ECHO OFF\nC:\\bin\\mysql\\bin\\mysql.exe -u root --execute=\"drop database %1%\"\nexit")),
    GIT_PULL(new IO("C:/selenium/golden/target/bin", "pull", "bat", "@echo off\ncd ..\\..\\\ngit pull\ncd golden\\target")),
    GIT_PUSH(new IO("C:/selenium/golden/target/bin", "push", "bat", "@echo off\ncall C:\\selenium\\golden\\target\\bin\\dbclean.bat\ncall C:\\selenium\\golden\\target\\bin\\stop.bat\ncall C:\\selenium\\golden\\target\\bin\\commit.bat \"An Automated Commit Message\"\nstart C:\\selenium\\golden\\target\\bin\\services.bat\nstart C:\\selenium\\golden\\target\\bin\\hub.bat\nstart C:\\selenium\\golden\\target\\bin\\selenium.bat")),
    GIT_SPUSH(new IO("C:/selenium/golden/target/bin", ".spush", "bat", "@echo off\ngit push -u origin master\nexit")),
    GIT_COMMIT(new IO("C:/selenium/golden/target/bin", "commit", "bat", "@echo off\ncd ..\\..\\..\\\ncall git status\ncall git add -A\ncall git commit -m %1%\ncd C:\\selenium\\golden\\target\\bin\nstart .spush.bat")),
    GIT_ROLLBACK(new IO("C:/selenium/golden/target/bin", "rollback", "bat", "@ECHO OFF\ngit checkout -f")),
    MVN_BUILD(new IO("C:/selenium/golden/target/bin", "build", "bat", "@echo off\n"
            + "cd C:\\selenium\\mvc\n"
            + "call mvn clean install\n"
            + "cd C:\\selenium\\gold\n"
            + "call mvn clean install\n"
            + "cd C:\\selenium\\user\n"
            + "call mvn clean install\n"
            + "cd C:\\selenium\\www\n"
            + "call mvn clean install\n"
            + "cd C:\\selenium\\golden\\target\\bin")),
    SELENIUM_ALL(new IO("C:/selenium/golden/target/bin", "selenium", "bat", "@echo off\nstart C:\\selenium\\golden\\target\\bin\\chromeA.bat\nstart C:\\selenium\\golden\\target\\bin\\chromeB.bat\nstart C:\\selenium\\golden\\target\\bin\\fitnesse.bat\nexit")),
    SELENIUM_HUB(new IO("C:/selenium/golden/target/bin", "hub", "bat", "@echo off\nstart java -jar C:\\bin\\selenium\\lib\\selenium.jar -role hub\nexit")),
    SELENIUM_CHROME_A(new IO("C:/selenium/golden/target/bin", "chromeA", "bat", "@echo off\nstart java -jar C:\\bin\\selenium\\lib\\selenium.jar -role node -port 5559 -hub http://localhost:4444/grid/register-browser -browser \"browserName=chrome,chrome_binary=C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe ,maxInstances=5, platform=WINDOWS\"\nexit")),
    SELENIUM_CHROME_B(new IO("C:/selenium/golden/target/bin", "chromeB", "bat", "@echo off\nstart java -jar C:\\bin\\selenium\\lib\\selenium.jar -role node -port 5560 -hub http://localhost:4444/grid/register-browser -browser \"browserName=chrome,chrome_binary=C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe ,maxInstances=5, platform=WINDOWS\"\nexit")),
    KILL_PROCESS(new IO("C:/selenium/golden/target/bin", "kill", "bat", "@echo off\ntaskkill /f /im %1%\nexit")),
    SERVICES_STOP(new IO("C:/selenium/golden/target/bin", "stop", "bat", "@echo off\nstart C:\\selenium\\golden\\target\\bin\\kill.bat \"Apache.exe\" && start C:\\selenium\\golden\\target\\bin\\kill.bat \"mysqld.exe\" && start C:\\selenium\\golden\\target\\bin\\kill.bat \"chromedriver.exe\"")),
    SERVICES_START(new IO("C:/selenium/golden/target/bin", "services", "bat", "@echo off\nstart C:\\bin\\apache\\bin\\Apache.exe && start C:\\bin\\mysql\\bin\\mysqld.exe\nexit"));

    private final Virtual virtual;

    Bat(Virtual start) {
        virtual = start;
    }

    @Override
    public String toString() {
        return virtual.toString();
    }

    @Override
    public String getType() {
        return virtual.getType();
    }

    @Override
    public void setType(String type) {
        virtual.setType(type);
    }

    @Override
    public String getName() {
        return virtual.getName();
    }

    @Override
    public void setName(String name) {
        virtual.setName(name);
    }

    @Override
    public String getFolder() {
        return virtual.getFolder();
    }

    @Override
    public void setFolder(String folder) {
        virtual.setFolder(folder);
    }

    @Override
    public String getContent() {
        return virtual.getContent();
    }

    @Override
    public void setContent(String content) {
        virtual.setContent(content);
    }

    @Override
    public File call() throws Exception {
        return virtual.call();
    }

}
