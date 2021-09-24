package com.max.def.tutorials;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.ToxicBakery.viewpager.transforms.ABaseTransformer;
import com.ToxicBakery.viewpager.transforms.AccordionTransformer;
import com.ToxicBakery.viewpager.transforms.BackgroundToForegroundTransformer;
import com.ToxicBakery.viewpager.transforms.CubeInTransformer;
import com.ToxicBakery.viewpager.transforms.CubeOutTransformer;
import com.ToxicBakery.viewpager.transforms.DefaultTransformer;
import com.ToxicBakery.viewpager.transforms.DepthPageTransformer;
import com.ToxicBakery.viewpager.transforms.FlipHorizontalTransformer;
import com.ToxicBakery.viewpager.transforms.FlipVerticalTransformer;
import com.ToxicBakery.viewpager.transforms.ForegroundToBackgroundTransformer;
import com.ToxicBakery.viewpager.transforms.RotateDownTransformer;
import com.ToxicBakery.viewpager.transforms.RotateUpTransformer;
import com.ToxicBakery.viewpager.transforms.ScaleInOutTransformer;
import com.ToxicBakery.viewpager.transforms.StackTransformer;
import com.ToxicBakery.viewpager.transforms.TabletTransformer;
import com.ToxicBakery.viewpager.transforms.ZoomInTransformer;
import com.ToxicBakery.viewpager.transforms.ZoomOutSlideTransformer;

import github.chenupt.springindicator.SpringIndicator;


public class MainActivity extends AppCompatActivity
{
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SpringIndicator tabLayout = findViewById(R.id.tab_layout);

        viewPager = findViewById(R.id.view_pager);

        viewPager.setAdapter(new TabAdapter(getSupportFragmentManager()));

        tabLayout.setViewPager(viewPager);

        refreshViewPager();
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        refreshViewPager();
    }

    private void refreshViewPager()
    {
        String transformer = PagerSettingsActivity.getTransformer(this);

        switch (transformer)
        {
            case "DefaultTransformer":
                viewPager.setPageTransformer(true,new DefaultTransformer());
                break;
            case "AccordionTransformer":
                viewPager.setPageTransformer(true,new AccordionTransformer());
                break;
            case "BackgroundToForegroundTransformer":
                viewPager.setPageTransformer(true,new BackgroundToForegroundTransformer());
                break;
            case "CubeInTransformer":
                viewPager.setPageTransformer(true,new CubeInTransformer());
                break;
            case "CubeOutTransformer":
                viewPager.setPageTransformer(true,new CubeOutTransformer());
                break;
            case "DepthPageTransformer":
                viewPager.setPageTransformer(true,new DepthPageTransformer());
                break;
            case "DrawerTransformer":
                viewPager.setPageTransformer(true, new ABaseTransformer()
                {
                    @Override
                    protected void onTransform(View page, float position)
                    {
                        if (position <= 0)
                        {
                            page.setTranslationX(0);
                        }
                        else if (position <= 1)
                        {
                            page.setTranslationX(-page.getWidth() / 2 * position);
                        }
                    }
                });
                break;
            case "FlipHorizontalTransformer":
                viewPager.setPageTransformer(true,new FlipHorizontalTransformer());
                break;
            case "FlipVerticalTransformer":
                viewPager.setPageTransformer(true,new FlipVerticalTransformer());
                break;
            case "ForegroundToBackgroundTransformer":
                viewPager.setPageTransformer(true,new ForegroundToBackgroundTransformer());
                break;
            case "RotateDownTransformer":
                viewPager.setPageTransformer(true,new RotateDownTransformer());
                break;
            case "RotateUpTransformer":
                viewPager.setPageTransformer(true,new RotateUpTransformer());
                break;
            case "ScaleInOutTransformer":
                viewPager.setPageTransformer(true,new ScaleInOutTransformer());
                break;
            case "StackTransformer":
                viewPager.setPageTransformer(true,new StackTransformer());
                break;
            case "TabletTransformer":
                viewPager.setPageTransformer(true,new TabletTransformer());
                break;
            case "ZoomInTransformer":
                viewPager.setPageTransformer(true,new ZoomInTransformer());
                break;
            case "ZoomOutSlideTransformer":
                viewPager.setPageTransformer(true,new ZoomOutSlideTransformer());
                break;
            case "ZoomOutTransformer":
                viewPager.setPageTransformer(true, new ABaseTransformer()
                {
                    @Override
                    protected void onTransform(View page, float position)
                    {
                        final float scale = 1f + Math.abs(position);

                        page.setScaleX(scale);
                        page.setScaleY(scale);

                        page.setPivotX(page.getWidth() * .5f);
                        page.setPivotY(page.getHeight() * .5f);

                        page.setAlpha(position < -1f || position > 1f ? 0f : 1f - (scale - 1f));

                        if (position == -1)
                        {
                            page.setTranslationX(page.getWidth() * -1);
                        }

                    }
                });
                break;
            default:
                viewPager.setPageTransformer(true,new DefaultTransformer());
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.settings,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.settings)
        {
            startActivity(new Intent(this,PagerSettingsActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
























