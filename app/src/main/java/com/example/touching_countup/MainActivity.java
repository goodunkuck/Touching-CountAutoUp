package com.example.touching_countup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textview;

    //핸들러를 만들어준다.
    Handler PHandler = new Handler(){
        public void handleMessage(Message msg){
            String result = textview.getText().toString();
            if(result == null || result.equals("")) result = "0";
            result = String.valueOf(Integer.parseInt(result) + 1);
            textview.setText(result);
            //값이 증가할때마다의 딜레이 (0, 값(높을 수록 딜레이가 느려진다.))
            PHandler.sendEmptyMessageDelayed(0, 10);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = findViewById(R.id.textView);
        Button Up = findViewById(R.id.UpButton);

        Up.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == 0){
                    //버튼 터치하고 값이 오르기 시작할때까지의 딜레이 (0, 값(높을 수록 딜레이가 느려진다.))
                    PHandler.sendEmptyMessageDelayed(0, 500);
                }
                if(motionEvent.getAction() == 1){
                    PHandler.removeMessages(0);
                }
                return false;
            }
        });
    }
}