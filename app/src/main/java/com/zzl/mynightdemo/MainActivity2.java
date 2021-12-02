package com.zzl.mynightdemo;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    private String content1 = "时间，忘却不了美好的回忆；岁月，冲淡不了友情的芬芳；距离，阻断不了心灵的感应；忙碌，断绝不了彼此的情谊。朋友，惟愿你时时开怀，幸福快乐每一天！";
    private String content2 = "清晨的霞光无比灿烂，扫除你一切的忧烦，清晨的露珠无比晶莹，装点你美丽的心情;清晨的鲜花无比美丽，代表我祝福的心意：祝早安带笑意，心情乐无比!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle bundle = new Bundle();
        HashMap<String, Object> map = new HashMap<>();
        ArrayList<String> list1 = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list1.add(content1 + " 00000000" + i);
        }
        ArrayList<String> list2 = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list2.add(content2 + " 111111111" + i);
        }
        map.put("GoodMorning", list1);
        map.put("GoodAfternoon", list2);
        JSONObject jsonObject = new JSONObject(map);
        String s="";
        try {
             s = new String(jsonObject.toString().getBytes("UTF-8"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        printLongString(s);
    }

    private static final String TAG = "MainActivity2";
    private void printLongString(String content) {
        if (content.length() > 3000) {
            int count = 0;
            if (content.length() % 3000 == 0) {
                count = content.length() / 3000;
            } else {
                count = content.length() / 3000 + 1;
            }
            for (int i = 0; i < count; i++) {
                if ((1+i)*3000>content.length()){
                    Log.d(TAG, "printLongString "+content.substring(i));
                }else {
                    Log.d(TAG, "printLongString "+content.substring(i,(1+i)*3000));
                }

            }
        }
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        int width = getWindow().getDecorView().getWidth();
        int height = getWindow().getDecorView().getHeight();
        Log.d(TAG, "onAttachedToWindow  widt="+width+" ,height="+height);
    }

}