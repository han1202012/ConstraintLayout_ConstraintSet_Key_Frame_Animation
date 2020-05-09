
[【约束布局】ConstraintSet 约束集 ( 简介 | 约束属性集合 | 约束集初始化 | 约束集应用到布局中 | 关键帧动画 | TransitionManager 使用 )](https://hanshuliang.blog.csdn.net/article/details/105995175)


<br>
<br>


#### I . ConstraintSet 约束集 简介

---

<br>


**ConstraintSet 约束集 简介 :** 

<br>

**① ConstraintSet 约束集 概念 :** ConstraintSet 约束集 顾名思义 , 就是 **约束属性的集合** , 其表示 约束布局 ( ConstraintLayout  ) 中 **所有的组件** 的 约束条件 , 尺寸 , 边距 , 等 **约束属性** ; 

**② 约束集 ConstraintSet 封装内容 :** 约束集中封装了 每个组件 的所有 约束布局 属性 ; 

**③ 约束集应用效果 :** **约束布局 ( ConstraintLayout )**  应用 **约束集 ( ConstraintSet ) 时** , 约束布局中的所有组件都会按照约束集中的约束属性进行重新布局绘制 ; 




<br>
<br>


#### II . ConstraintSet 约束集中封装的约束属性及操作 示例 

---

<br>

**1 . 获取约束集 :** 从 约束布局 ( ConstraintLayout ) 中 , 可以获取 约束集 ( ConstraintSet ) , 约束集可以从当前现有组件中获取 , 也可以从布局文件中获取 , 下面代码是从布局文件中获取的 ; 

<br>

```java
//1 . 创建 约束集 对象
ConstraintSet mConstraintSet = new ConstraintSet();

//2 . 从布局文件中获取 约束集 对象
mConstraintSet.clone(context, R.layout.constraintlayout);
```

<br>

**2 . 约束集中的约束属性 :** R.layout.constraintlayout 布局就是如下代码 , 从下面的布局中获取 约束集 ConstraintSet , 该约束集中封装了 button1 , button2 这 $2$ 个组件的 所有约束属性 , 如 android:layout_width , android:layout_height , 可以直接获取 , app:layout_constraintBottom_toBottomOf 等约束属性需要从 ConstraintLayout.LayoutParams 中获取 ; 

<br>

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <!-- 按钮组件 1 -->
    <Button
        android:id="@+id/button1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <!-- 按钮组件 2 -->
    <Button
        android:id="@+id/button2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World! Hello World!"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toBottomOf="@id/button1"
        app:layout_constraintVertical_bias="0.2" />
        
</androidx.constraintlayout.widget.ConstraintLayout>
```

<br>

**3 . 获取某组件的约束属性 :** 约束集 ( ConstraintSet ) 目前只提供了设置某组件的 约束属性 , 无法获取组件的 约束属性 ;  


<br>

**4 . 设置某组件的约束属性 :** 调用 setXxx(int viewId, 属性值类型 属性值) , 或 constrainXxx(int viewId, 属性值类型 属性值) , 等类型的方法 , 一般是第一个参数传入要修改的属性 ID , 第二个参数传入要修改的约束属性值 , 即可修改指定组件的指定约束属性 ; 


<br>
<br>


#### III . ConstraintSet 约束集 初始化方法

---

<br>


**1 . 从布局中拷贝 ConstraintSet 约束集 数据 :** 

<br>

**① 从 约束布局文件 中拷贝约束集 :** void clone(Context context, int constraintLayoutId) ; 

**② 从 约束布局 组件中拷贝约束集 :** void clone(ConstraintLayout constraintLayout) ; 

**③ 从 约束集 中拷贝约束集 :** void clone(Constraints constraints) ; 

**④ 从 约束 中拷贝约束集 :** void clone(ConstraintSet set) ; 


<br>

**2 . 从 XML 资源文件中加载 约束集 ConstraintSet 数据 :** 从 ConstraintLayout 布局文件 类型的 XML 资源中加载约束集数据 ; 

<br>

**① 从资源中加载 :** void load(Context context, int resourceId) ; 

**② 从 Xml 解析器中加载 :** void load(Context context, XmlPullParser parser) ; 



<br>
<br>


#### IV . ConstraintSet 约束集 应用到 约束布局 ConstraintLayout 中 

---

<br>

**ConstraintSet 约束集 应用到 约束布局 ConstraintLayout 中 :** 

<br>

**① 传统属性 与 约束属性 :** 这里将属性分为 传统属性 ( Custom Attributes ) , 约束属性 , 约束属性是只有在 约束布局中使用的属性 , 其它的非约束属性就是传统属性 , 如 宽高 , 边距 , 位置 , 旋转 , 缩放 , 等所有布局类型通用的这些属性 ; 

**② 应用 约束集所有属性 :** **void applyTo(ConstraintLayout constraintLayout) ;** 将所有的属性 , 传统属性 , 约束属性 , 都应用到约束布局中 ; 

**③ 应用 传统属性 :** **void applyCustomAttributes(ConstraintLayout constraintLayout) ;** 只将传统属性应用到约束布局中 ; 

**④ 应用 约束布局属性 :** **void applyToLayoutParams(int id, ConstraintLayout.LayoutParams layoutParams) ;** 为某个组件应用 **约束布局属性** ; 

**⑤ 应用 约束属性 :** **void applyToWithoutCustom(ConstraintLayout constraintLayout) ;** 将约束属性 ( 非传统属性 ) 应用到约束布局中 ; 


<br>
<br>


#### V . ConstraintSet 关键帧动画

---

<br>

**关键帧动画 :** 

<br>

① 核心方法 : 使用 **TransitionManager.beginDelayedTransition ( final ViewGroup sceneRoot )** 方法生成并执行动画 ; 

② 初始帧 与 目的帧 : 该方法 使用 默认的转换方式 , 创建一个动画 , 动画是基于一个场景 ViewGroup 进行生成的 , 初始场景是 初始帧 , 转换后的新场景是 目的帧 ; 

③ 过渡帧 : TransitionManager 会自动生成中间的多个过渡帧 , 其中的 初始帧 和 目的帧 是关键帧 , 过渡帧 是根据两个关键帧之间的改变自动生成的 , 

④ 方法原型 : 

```java
/**
 * Convenience method to animate, using the default transition,
 * to a new scene defined by all changes within the given scene root between
 * calling this method and the next rendering frame.
 * Equivalent to calling {@link #beginDelayedTransition(ViewGroup, Transition)}
 * with a value of <code>null</code> for the <code>transition</code> parameter.
 *
 * @param sceneRoot The root of the View hierarchy to run the transition on.
 */
public static void beginDelayedTransition(final ViewGroup sceneRoot) {
    beginDelayedTransition(sceneRoot, null);
```

<br>
<br>


#### VI . ConstraintSet 关键帧动画 代码流程

---

<br>

**关键帧动画流程 :** 

<br>

**① 设置起始帧 :** 准备 ViewGroup 组件 $A$ , 作为关键帧动画的起始帧 , 只要获取到该组件即可 ; 

**② 设置关键帧动画 :** 调用 TransitionManager.beginDelayedTransition ( ) 方法 , 生成过渡帧 , 执行时会自动进行关键帧动画执行 ; 

**③ 设置目的帧 :** 设置 ViewGroup 组件 $A$ 的变化结果 , 任何组件的 **尺寸 位置 的 变化** , 都会以动画形式过渡转换过去 ; 


<br>
<br>


#### VII . ConstraintSet 关键帧动画 支持的属性

---

<br>

**关键帧动画支持的属性 :** 

<br>

**① 不适配所有属性 :** 不是所有的属性都适用于关键帧动画 ; 

**② 适配属性 :** 组件的 尺寸 , 位置 , 旋转 , 缩放 , 等属性 , 可以使用关键帧动画生成过渡帧 ; 

**③ 不适配属性 :** 组件的 颜色 , 透明度 , 等属性 , 无法使用关键帧动画生成过渡帧 ; 



<br>
<br>


#### VIII . ConstraintSet 关键帧动画 示例代码 

---

<br>

**1 . 开始帧 布局文件 :** 

<br>

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:id="@+id/constraintLayout"
    android:onClick="onClick">

    <Button
        android:id="@+id/button"
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:text="Hello World!"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintHorizontal_bias="0"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0"/>

</androidx.constraintlayout.widget.ConstraintLayout>
```


<br>

**2 . 目的帧 布局文件 :** 两帧的区别是 按钮的 位置 , 大小 , 角度 发生了改变 ; 

<br>

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:id="@+id/constraintLayout">

    <Button
        android:id="@+id/button"
        android:layout_width="200dp"
        android:layout_height="200dp"
        android:text="Hello World!"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintHorizontal_bias="1"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="1"
        android:rotation="210"/>

</androidx.constraintlayout.widget.ConstraintLayout>
```

<br>

**3 . Activity 代码 :** 

<br>

```java
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
     * 点击触发 关键帧动画
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
```


<br>

**4 . 关键帧动画效果 :** 

<br>

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200509201429921.gif)

<br>


**示例代码地址 :** [GitHub - ConstraintLayout_ConstraintSet_Key_Frame_Animation](https://github.com/han1202012/ConstraintLayout_ConstraintSet_Key_Frame_Animation) ; 
