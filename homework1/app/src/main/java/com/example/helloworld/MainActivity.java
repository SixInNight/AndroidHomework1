package com.example.helloworld;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        SeekBar sb1 = findViewById(R.id.sb1);
        final ImageView iv1 = findViewById(R.id.iv1);
        final EditText et1 = findViewById(R.id.et1);
        final TextView tv1 = findViewById(R.id.tv1);
        final TextView tv3 = findViewById(R.id.tv3);
        final TextView tv4 = findViewById(R.id.tv4);

        sb1.setMax(255);
        sb1.setProgress(5);

        sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv4.setText("图片虚化程度：" + progress);
                iv1.setImageAlpha(progress);
                System.out.println("tv4 and iv1 changed.");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText("Wow, what a handsome boy!");
                System.out.println("tv1 changed.");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mile = Integer.parseInt(et1.getText().toString());
                double km = 1.61*(double)mile;
                tv3.setText(km + "公里");
                System.out.println("et1 and tv3 changed.");
            }
        });
    }
}
