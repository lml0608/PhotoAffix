package com.example.photoaffix.ui;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.afollestad.dragselectrecyclerview.DragSelectRecyclerView;
import com.example.photoaffix.R;
import com.example.photoaffix.adapters.PhotoGridAdapter;
import com.example.photoaffix.data.Photo;
import com.example.photoaffix.views.ColorCircleView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_RC = 69;
    private static final int BROWSE_RC = 21;

    @BindView(R.id.list)
    private DragSelectRecyclerView list;

    @BindView(R.id.toolbar)
    private Toolbar toolbar;

    @BindView(R.id.affixButton)
    private Button affixButton;

    @BindView(R.id.expandButton)
    private Button expandButton;

    @BindView(R.id.empty)
    private TextView empty;

    @BindView(R.id.stackHorizonllySwitch)
    private CheckBox stackHorizonllySwitch;

    @BindView(R.id.bgFillColorCircle)
    private ColorCircleView bgFillColorCircle;

    @BindView(R.id.bgFillColorLabel)
    private TextView bgFillColorLabel;

    @BindView(R.id.removeBgButton)
    private Button removeBgButton;

    @BindView(R.id.imagePaddingLabel)
    private TextView imagePaddingLabel;

    @BindView(R.id.scalePrioritySwitch)
    private CheckBox scalePrioritySwitch;

    @BindView(R.id.scalePriorityLabel)
    private TextView scalePriorityLabel;

    @BindView(R.id.settingsFrame)
    ViewGroup settingsFrame;


    private PhotoGridAdapter adapter;

    private Photo[] selectedPhotos;

    private int traverseIndex;

    private boolean autoSelectFirst;

    private int originalSettingsFrameHeight = -1;
    private ValueAnimator settingsFrameAnimator;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        unbinder = ButterKnife.bind(this);

        list.setLayoutManager(new GridLayoutManager(this, getResources().getInteger(R.integer.grid_width)));

        adapter = new PhotoGridAdapter(this);
        list.setAdapter(adapter);
        list.setItemAnimator(new DefaultItemAnimator());






    }
}