package com.jnu.student;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        TextView buttonFirst = findViewById(R.id.button);
//        buttonFirst.setText(R.string.hello_world);
//        setContentView(R.layout.activity_main);

        RelativeLayout relativeLayout = new RelativeLayout(this);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        //addRule参数对应RelativeLayout的XML布局属性
        params.addRule(RelativeLayout.CENTER_IN_PARENT);                    //设置居中显示

        TextView textView = findViewById(R.id.textView33);       //通过id找到view中的TextView并获得对应的对象
        textView.setText(getResources().getString(R.string.hello_world));  //设置TextView控件的文字内容
        textView.setTextColor(Color.RED);                                   //设置TextView控件的文字颜色
        textView.setTextSize(25);                                           //设置TextView控件的文字大小
        Button button_one = findViewById(R.id.button_click_one);
        button_one.setOnClickListener(new View.OnClickListener(){
            public void onClick(View viewClicked){
                Button click = (Button)viewClicked;
                click.setText("Clicked!");
            }
        });
        Button button_two = findViewById(R.id.button_click_two);
        button_two.setOnClickListener(this);
    }
    public void onClick(View view){
        Button v = (Button)view;
        v.setText("已点击");
    }

    public void MyXMLClick(View view){
        Button v = (Button)view;
        v.setText("Set in XML");
    }
}