package com.example.testfragment;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.support.v4.app.FragmentActivity;
public class MainActivity extends FragmentActivity implements HeadLines.OnHeadlinesSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container) != null) {


            if (savedInstanceState != null)
                return;
            Log.d("My app", "This is portrait");
            HeadLines frag1 = new HeadLines();

            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, frag1).commit();
        }
    }

    public void onArticleSelected (int pos) {
        ArticlesView articlesView = (ArticlesView) getSupportFragmentManager().findFragmentById(R.id.articles_fragment);

        if (articlesView != null)
            articlesView.updateArticleView(pos);
        else {
            ArticlesView newArticle = new ArticlesView();
            Bundle args = new Bundle ();
            args.putInt(ArticlesView.ARG_POSITION, pos);
            newArticle.setArguments(args);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.fragment_container, newArticle);
            transaction.addToBackStack(null);

            transaction.commit();
        }
    }

    /*@Override
    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount() != 0 && findViewById(R.id.fragment_container) != null) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }*/
}
