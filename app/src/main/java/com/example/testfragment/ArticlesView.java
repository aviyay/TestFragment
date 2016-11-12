package com.example.testfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ArticlesView extends Fragment {
    final static String ARG_POSITION = "position";
    int mCurrentPosition = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (savedInstanceState != null)
            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_articles_view, container, false);
    }

    @Override
    public void onStart () {
        super.onStart();

        Bundle args = getArguments();

        if (args != null)
            updateArticleView(args.getInt(ARG_POSITION));
        else if (mCurrentPosition != -1)
            updateArticleView (mCurrentPosition);
    }

    public void updateArticleView (int pos) {
        TextView article = (TextView) getActivity().findViewById(R.id.article);

        if (article != null) {
            article.setText(Ipsum.Articles[pos]);
            mCurrentPosition = pos;
        }
    }
}
