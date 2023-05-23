package cn.edu.hqu.cst.android.lzt.ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import cn.edu.hqu.cst.android.lzt.ex2.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button UC1_button = findViewById(R.id.UC1_button);
        Button UC2_button = findViewById(R.id.UC2_button);
        Button UC3_button = findViewById(R.id.UC3_button);
        Button UC4_button = findViewById(R.id.UC4_button);
        Button UC5_button = findViewById(R.id.UC5_button);

        UC1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUC1();
            }
        });

        UC2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUC2();
            }
        });

        UC3_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUC3();
            }
        });

        UC4_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUC4();
            }
        });

        UC5_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUC5();
            }
        });

    }

    public void openUC1() {
        Intent intent = new Intent(this, UC1.class);
        startActivity(intent);
    }
    public void openUC2() {
        Intent intent = new Intent(this, UC2.class);
        startActivity(intent);
    }
    public void openUC3() {
        Intent intent = new Intent(this, UC3.class);
        startActivity(intent);
    }
    public void openUC4() {
        Intent intent = new Intent(this, UC4.class);
        startActivity(intent);
    }
    public void openUC5() {
        Intent intent = new Intent(this, UC5.class);
        startActivity(intent);
    }
}