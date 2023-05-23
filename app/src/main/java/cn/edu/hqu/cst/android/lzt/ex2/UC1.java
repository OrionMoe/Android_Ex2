package cn.edu.hqu.cst.android.lzt.ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;

import cn.edu.hqu.cst.android.lzt.ex2.R;

public class UC1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uc1_linearlayout);

        LinearLayout linearLayout = findViewById(R.id.LinearLayout1);
        Button ButtonH = findViewById(R.id.ButtonH);
        Button ButtonV = findViewById(R.id.ButtonV);
        Button ButtonAL = findViewById(R.id.ButtonAL);

        Button homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ButtonH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setGravity(Gravity.CENTER);
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            }
        });

        ButtonV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setGravity(Gravity.CENTER);
                linearLayout.setOrientation(LinearLayout.VERTICAL);
            }
        });

        ButtonAL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setGravity(Gravity.START);
            }
        });
    }

}