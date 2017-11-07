package test;
//import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.*;
import sound.Sound;

import java.util.Map;
import java.util.HashMap;
public class SoundTest extends  Assert{
    private  final Map<String, Boolean> soundResultData = new HashMap<String, Boolean>();

    @Before
    public  void setUpSoundResultData() {
        soundResultData.put("D:\\", false);
        soundResultData.put("D:\\RPServer\\Sounds", false);
        soundResultData.put("D:\\RPServer\\Sounds\\1.wav", true);
        soundResultData.put("D:\\RPServer\\Sounds\\35.wav", false);

    }
    @After
    public  void tearDownSoundResultData(){
        soundResultData.clear();
    }
    @Test
    public void testSoundResultData() {
        for (Map.Entry<String, Boolean> entry : soundResultData.entrySet()) {
            final boolean testData = entry.getValue();
            final String expected = entry.getKey();
            final boolean actual = Sound.playSound(expected);
            assertEquals(testData, actual);
        }
    }

}
