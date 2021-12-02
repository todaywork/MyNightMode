package com.zzl.mynightdemo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private String content1="时间，忘却不了美好的回忆；岁月，冲淡不了友情的芬芳；距离，阻断不了心灵的感应；忙碌，断绝不了彼此的情谊。朋友，惟愿你时时开怀，幸福快乐每一天！";
    private String content2="清晨的霞光无比灿烂，扫除你一切的忧烦，清晨的露珠无比晶莹，装点你美丽的心情;清晨的鲜花无比美丽，代表我祝福的心意：祝早安带笑意，心情乐无比!";
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
        HashMap<String, Object> map = new HashMap<>();
        ArrayList<String> list1=new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            list1.add(content1+" 00000000"+i);
//        }
//        ArrayList<String> list2=new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            list2.add(content2+" 111111111"+i);
//        }
//        map.put("GoodMorning",list1);
//        map.put("GoodAfternoon",list2);
//        JSONObject jsonObject = new JSONObject(map);
//        System.out.println(jsonObject.toString());
        boolean s= true;
        s=s|false;
        System.out.println("b="+(s));
    }
}
