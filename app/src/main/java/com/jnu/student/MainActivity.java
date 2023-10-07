package com.jnu.student;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView recycler_View_books;
    private MyAdapter bookAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("MainActivity","enter OnCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView_hello_world);       //通过id找到view中的TextView并获得对应的对象
        textView.setText(getResources().getString(R.string.hello_world));  //设置TextView控件的文字内容
        textView.setTextColor(Color.RED);                                   //设置TextView控件的文字颜色
        textView.setTextSize(25);                                           //设置TextView控件的文字大小

        Button button0 = findViewById(R.id.button_click);
        button0.setOnClickListener(viewClicked -> {
            Button click = (Button)viewClicked;
            click.setText(R.string.clicked);
        });

        Button button1 = findViewById(R.id.button_one);
        button1.setOnClickListener(this);

        Button button2 = findViewById(R.id.button_two);

        Button button3 = findViewById(R.id.button_three);
        button3.setOnClickListener(viewClicked -> {
            Button button = (Button)viewClicked;
            button.setText(R.string.click_msg_three);
            button.setTextSize(13);
        });

        recycler_View_books = findViewById(R.id.book_view);
        recycler_View_books.setLayoutManager(new LinearLayoutManager(this));
        List<BookItem> booklist = new ArrayList<>();
        for(int i=0;i<10;i++) {
            booklist.add(new BookItem("软件项目管理", "30", R.drawable.book_2));
            booklist.add(new BookItem("创新工程实践", "25", R.drawable.book_3));
            booklist.add(new BookItem("信息安全基础", "35", R.drawable.book_1));
        }
        bookAdapter = new MyAdapter(booklist);
        recycler_View_books.setAdapter(bookAdapter);

    }

    public void onClick(View view){
        Button v = (Button)view;
        v.setText(R.string.click_msg_one);
    }

    public void MyXMLClick(View view){
        Button v = (Button)view;
        v.setText(R.string.click_msg_two);
    }
}
