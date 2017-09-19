package jay.com.listviewdemo6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import jay.com.listviewdemo6.Bean.App;
import jay.com.listviewdemo6.Bean.Book;
import jay.com.listviewdemo6.Bean.ListB;

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
        ArrayList<String> banners = new ArrayList<>();
        banners.add("http://scimg.jb51.net/allimg/130104/2-130104091152C2.jpg");
        banners.add("http://www.51pptmoban.com/d/file/2012/03/07/2d12ae13e98b96ca0ddcf684f1dc14aa.jpg");
        banners.add("http://scimg.jb51.net/allimg/131021/2-131021011631Z8.jpg");
        banners.add("http://scimg.jb51.net/allimg/121209/2-1212091UH0339.jpg");
        //数据准备：
        mData = new ArrayList<Object>();
        mData.add(new ListB(banners));
        mData.add(new Book("《第一行代码》", "郭霖"));
        mData.add(new App(R.mipmap.iv_icon_baidu, "百度"));
        mData.add(new App(R.mipmap.iv_icon_baidu, "百度"));

        mData.add(new Book("《第一行代码》", "郭霖"));
        mData.add(new App(R.mipmap.iv_icon_baidu, "百度"));
        mData.add(new Book("《第一行代码》", "郭霖"));

        list_content = (ListView) findViewById(R.id.list_content);
        myAdapter = new MutiLayoutAdapter(MainActivity.this, mData);
        list_content.setAdapter(myAdapter);
    }
}
