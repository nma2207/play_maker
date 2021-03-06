package test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.Assert;
import sound.Sound;
public class TestMain {
    public static void main(String [] args) throws Exception{
        JUnitCore runner = new JUnitCore();
        Result result = runner.run(SoundTest.class);
        System.out.println("Sound player test: ");
        System.out.println("\trun tests: " + result.getRunCount());
        System.out.println("\tfailed tests: " + result.getFailureCount());
        System.out.println("\tignored tests: " + result.getIgnoreCount());
        System.out.println("\tsuccess: " + result.wasSuccessful());


        Result result1 = runner.run(CommandConvertTest.class);
        System.out.println("Command convert test");
        System.out.println("\trun tests: " + result1.getRunCount());
        System.out.println("\tfailed tests: " + result1.getFailureCount());
        System.out.println("\tignored tests: " + result1.getIgnoreCount());
        System.out.println("\tsuccess: " + result1.wasSuccessful());
    }
}
