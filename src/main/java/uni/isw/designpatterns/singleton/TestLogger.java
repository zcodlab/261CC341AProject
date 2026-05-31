package uni.isw.designpatterns.singleton;

public class TestLogger {
    public static void main(String[] args){
        Logger logger1 =Logger.getInstance();
        Logger logger2 =Logger.getInstance();
        logger1.setValue("Test");
        System.out.println(logger2.getValue());
    }
}
