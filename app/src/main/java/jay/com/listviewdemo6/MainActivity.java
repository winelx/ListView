package jay.com.listviewdemo6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int TYPE_BOOK = 0;
    private static final int TYPE_APP = 1;
    private ListView list_content;
    private ArrayList<Object> mData = null;
    private MutiLayoutAdapter myAdapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //数据准备：
        mData = new ArrayList<Object>();
        mData.add(new banner("谷歌"));
        mData.add(new Book("《第一行代码》", "郭霖"));
        mData.add(new App(R.mipmap.iv_icon_baidu, "百度"));
        mData.add(new App(R.mipmap.iv_icon_baidu, "百度"));
        mData.add(new banner("谷歌"));
        mData.add(new Book("《第一行代码》", "郭霖"));
        mData.add(new App(R.mipmap.iv_icon_baidu, "百度"));
        mData.add(new Book("《第一行代码》", "郭霖"));
        mData.add(new banner("谷歌"));
        list_content = (ListView) findViewById(R.id.list_content);
        myAdapter = new MutiLayoutAdapter(MainActivity.this, mData);
        list_content.setAdapter(myAdapter);
    }
}
