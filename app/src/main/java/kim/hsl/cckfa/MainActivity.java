package kim.hsl.cckfa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 点击触发关键帧动画
     * @param view
     */
    public void onClick(View view){
        //1 . 获取 约束布局 组件 ( 设置 关键帧动画的 开始帧 )
        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);

        //2 . 创建 约束集 对象
        ConstraintSet constraintSet = new ConstraintSet();

        //3 . 从 约束布局 中加载约束集
        constraintSet.load(this, R.layout.activity_main2);

        //4 . 设置 关键帧动画
        TransitionManager.beginDelayedTransition(constraintLayout);

        //5 . 在 约束布局 中 , 应用约束集属性 ( 设置 关键帧动画的 结束帧 )
        constraintSet.applyTo(constraintLayout);
    }
}
