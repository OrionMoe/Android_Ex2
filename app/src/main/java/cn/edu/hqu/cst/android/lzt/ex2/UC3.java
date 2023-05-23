package cn.edu.hqu.cst.android.lzt.ex2;

import android.widget.Button;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import cn.edu.hqu.cst.android.lzt.ex2.R;

import java.util.Timer;
import java.util.TimerTask;

public class UC3 extends AppCompatActivity {

    // 定義 ImageViewSlideshow 為 ImageView
    // private ImageView ImageViewSlideshow;
    // private int[] imageIds = {      // 定義 imageIds, 並把圖片放裏面
    //         R.drawable.rice_bread,  // 把你的圖片放在 res/drawable 裏面
    //         R.drawable.dark_pepe,        // R.drawable.圖片檔案名
    //         R.drawable.slow_sign,
    //         R.drawable.pbnj,
    //         R.drawable.angry_pepe
    // };
    // 像之前C++一樣, 做一個計數器之前要先把
    // private int currentIndex = 0;

    private ImageView[] imageViews;
    private int currentIndex = 0;
    private Timer timer;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uc3_timedimg);

        // ImageViewSlideshow = findViewById(R.id.ImageViewSlideshow);

        // Timer timer = new Timer();
        // timer.scheduleAtFixedRate(new TimerTask() {
        //     @Override
        //     public void run() {
        //         // Update the UI on the main thread
        //         runOnUiThread(new Runnable() {
        //             @Override
        //             public void run() {
        //                 // Display the next image in the array
        //                 ImageViewSlideshow.setImageResource(imageIds[currentIndex]);

        //                 // Increment the index or reset to 0 if it reaches the end
        //                 currentIndex = (currentIndex + 1) % imageIds.length;
        //             }
        //         });
        //     }
        // }, 0, 2000);

        Button homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        imageViews = new ImageView[]{
                findViewById(R.id.imageView1),
                findViewById(R.id.imageView2),
                findViewById(R.id.imageView3),
                findViewById(R.id.imageView4),
                findViewById(R.id.imageView5)
        };

        handler = new Handler(Looper.getMainLooper());

        startImageRotation();

    }
    private void startImageRotation() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        int nextIndex = (currentIndex + 1) % imageViews.length;

                        imageViews[currentIndex].setVisibility(View.INVISIBLE);
                        imageViews[nextIndex].setVisibility(View.VISIBLE);

                        currentIndex = nextIndex;
                    }
                });
            }
        }, 0, 3000); // 以毫秒為單位，每隔几秒钟切换一次图片。
    }

    @Override
    protected void onDestroy() {    // 可選，主要是爲了防止退出頁面後Timer仍然在運行的問題
        super.onDestroy();          // 避免内存泄漏或其他潜在的问题，导致不必要的资源消耗或可能引发异常。
        if (timer != null) {
            timer.cancel();
        }
    }
}
