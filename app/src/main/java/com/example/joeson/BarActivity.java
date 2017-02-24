package com.example.joeson;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.example.joesn.myapplication.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;

/**
 * Created by joesn on 2017/1/19.
 */
@EActivity(R.layout.xiaojiu)
public class BarActivity extends Activity {
    @ViewById(R.id.tabHost)
    MaterialTabHost tabHost;
    @ViewById(R.id.pager)
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @AfterViews
    public void setTabHost(){

        for(int i=0;i<3;i++)
        {
            tabHost.addTab(tabHost.newTab().setText("需求").setTabListener(new myMaterialTabListener()));
        }
    }



    class myMaterialTabListener implements MaterialTabListener{
        @Override
        public void onTabSelected(MaterialTab tab) {

        }

        @Override
        public void onTabReselected(MaterialTab tab) {

        }

        @Override
        public void onTabUnselected(MaterialTab tab) {

        }
    }
}
