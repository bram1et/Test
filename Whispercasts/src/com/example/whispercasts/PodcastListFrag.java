package com.example.whispercasts;

import com.example.whispercasts.ImageAdapter;
import com.example.whispercasts.R;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout.LayoutParams;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass. Activities that
 * contain this fragment must implement the
 * {@link PodcastListFrag.OnFragmentInteractionListener} interface to handle
 * interaction events. Use the {@link PodcastListFrag#newInstance} factory
 * method to create an instance of this fragment.
 * 
 */
public class PodcastListFrag extends Fragment {


	private static final String ARG_POSITION = "position";

	private int position;

	public static PodcastListFrag newInstance(int position) {
		PodcastListFrag frag = new PodcastListFrag();
		Bundle b = new Bundle();
		b.putInt(ARG_POSITION, position);
		frag.setArguments(b);
		return frag;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		position = getArguments().getInt(ARG_POSITION);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

		FrameLayout fl = new FrameLayout(getActivity());
		fl.setLayoutParams(params);

		final int margin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources()
				.getDisplayMetrics());

	//	TextView v = new TextView(getActivity());
		if ( this.position == 1 ) {
    GridView v = new GridView(getActivity());
    v.setAdapter(new ImageAdapter(getActivity()));
    
		params.setMargins(margin, margin, margin, margin);
		v.setLayoutParams(params);
		v.setLayoutParams(params);
		v.setGravity(Gravity.CENTER);
		v.setNumColumns(3);
		//v.setBackgroundResource(R.drawable.background_card);

		
		
    v.setOnItemClickListener(new OnItemClickListener() {
      public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
      	
  			PodcastDetails dialog = new PodcastDetails();
  			
      	switch(position) {
      	case ( 0 ): {
    			dialog.setPodcast("Best of the Left");
    			dialog.show(getFragmentManager(), "podcast");
    			break;
      	}
      	
      	case ( 1 ): {
    			dialog.setPodcast("Christian Science Georgia");
    			dialog.show(getFragmentManager(), "podcast");
    			break;
      	}
      	
      	case ( 2 ): {
    			dialog.setPodcast("TV Media");
    			dialog.show(getFragmentManager(), "podcast");
    			break;
      	}
      	
      	case ( 3 ): {
    			dialog.setPodcast("Un Mensaje a la Conciencia");
    			dialog.show(getFragmentManager(), "podcast");
    			break;
      	}
      	
        }
      }
    });

		fl.addView(v);
		}
		
		if ( this.position == 2 ) {
			
		}
		return fl;
	}
	
}