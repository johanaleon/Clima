package site.clima;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by lleon on 4/27/16.
 */
public class DetailFragment extends Fragment {

    public DetailFragment(){}

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        Intent intent = getActivity().getIntent();
        if(intent != null && intent.hasExtra(Intent.EXTRA_TEXT)){
            String forecastStr = intent.getStringExtra(Intent.EXTRA_TEXT);
            ((TextView) rootView.findViewById(R.id.detail_text)).setText(forecastStr);
        }
        return  rootView;
    }
}
