package jay.com.listviewdemo6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;

import jay.com.listviewdemo6.Bean.App;
import jay.com.listviewdemo6.Bean.Book;
import jay.com.listviewdemo6.Bean.ListB;
import jay.com.listviewdemo6.holder.ViewHolder1;
import jay.com.listviewdemo6.holder.ViewHolder2;
import jay.com.listviewdemo6.holder.ViewHolder3;

/**
 * Created by Jay on 2015/9/23 0023.
 */
public class MutiLayoutAdapter extends BaseAdapter {

    //定义两个类别标志
    private static final int TYPE_BOOK = 0;
    private static final int TYPE_APP = 1;
    private static final int TYPE_BANNER = 2;
    private Context mContext;
    private ArrayList<Object> mData = null;


    public MutiLayoutAdapter(Context mContext, ArrayList<Object> mData) {
        this.mContext = mContext;
        this.mData = mData;

    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //多布局的核心，通过这个判断类别
    @Override
    public int getItemViewType(int position) {
        if (mData.get(position) instanceof App) {
            return TYPE_APP;
        } else if (mData.get(position) instanceof Book) {
            return TYPE_BOOK;
        } else if (mData.get(position) instanceof ListB) {
            return TYPE_BANNER;
        } else {
            return super.getItemViewType(position);
        }
    }

    //类别数目
    @Override
    public int getViewTypeCount() {
        return 3;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        ViewHolder1 holder1 = null;
        ViewHolder2 holder2 = null;
        ViewHolder3 holder3 = null;

        if (convertView == null) {
            switch (type) {
                case TYPE_APP:
                    holder1 = new ViewHolder1();
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.item_one, parent, false);
                    holder1.img_icon = (ImageView) convertView.findViewById(R.id.img_icon);
                    holder1.txt_aname = (TextView) convertView.findViewById(R.id.txt_aname);
                    convertView.setTag(R.id.Tag_APP, holder1);
                    break;
                case TYPE_BOOK:
                    holder2 = new ViewHolder2();
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.item_two, parent, false);
                    holder2.txt_bname = (TextView) convertView.findViewById(R.id.txt_bname);
                    holder2.txt_bauthor = (TextView) convertView.findViewById(R.id.txt_bauthor);
                    convertView.setTag(R.id.Tag_Book, holder2);
                    break;
                case TYPE_BANNER:
                    holder3 = new ViewHolder3();
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.item_three, parent, false);
                    holder3.mBanner = (FlyBanner) convertView.findViewById(R.id.banner_1);
                    convertView.setTag(R.id.Tag_Banner, holder3);
                    break;
            }
        } else {
            switch (type) {
                case TYPE_APP:
                    holder1 = (ViewHolder1) convertView.getTag(R.id.Tag_APP);
                    break;
                case TYPE_BOOK:
                    holder2 = (ViewHolder2) convertView.getTag(R.id.Tag_Book);
                    break;
                case TYPE_BANNER:
                    holder3 = (ViewHolder3) convertView.getTag(R.id.Tag_Banner);
            }
        }

        Object obj = mData.get(position);
        //设置下控件的值
        switch (type) {
            case TYPE_APP:
                App app = (App) obj;
                if (app != null) {
                    holder1.img_icon.setImageResource(app.getaIcon());
                    holder1.txt_aname.setText(app.getaName());
                }
                break;
            case TYPE_BOOK:
                Book book = (Book) obj;
                if (book != null) {
                    holder2.txt_bname.setText(book.getbName());
                    holder2.txt_bauthor.setText(book.getbAuthor());
                }
                break;
            case TYPE_BANNER:
                ListB mbanner = (ListB) obj;
                if (mbanner != null) {
                    holder3.mBanner.setImagesUrl(mbanner.getListB());
                    holder3.mBanner.setOnItemClickListener(new FlyBanner.OnItemClickListener() {
                        @Override
                        public void onItemClick(int position) {
                          int  positions=position+1;
                            Toast.makeText(mContext, "点击了第" + positions+ "张图片", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                break;
        }
        return convertView;
    }

}
