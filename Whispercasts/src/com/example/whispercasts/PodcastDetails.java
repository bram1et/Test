package com.example.whispercasts;

import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;


public class PodcastDetails extends DialogFragment {

	private String podcastName = "Podcast";

//	private ContactPagerAdapter adapter;

	public static PodcastDetails newInstance() {
		PodcastDetails f = new PodcastDetails();
		return f;
	}
	
	public void setPodcast(String name) {
		podcastName = name;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		if (getDialog() != null) {
			getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		}
		
		View root = inflater.inflate(R.layout.fragment_podcast_details, container, false);
		TextView tv = (TextView)(root.findViewById(R.id.dialogText));
		tv.setText(podcastName);
		
		Button bt = (Button)root.findViewById(R.id.button1);
		bt.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
      	
     	 String number = "202-600-2282";
   		if( podcastName.equals("Best of the Left")) 
   			number = "202-600-2282";
  		else if ( podcastName.equals("Christian Science Georgia")) 
  			number = "678-364-7005";
  		else if ( podcastName.equals("Un Mensaje a la Conciencia")) 
  			number = "949-943-3997";
  		else if ( podcastName.equals("TV Media")) 
  			number = "646-381-2665";
     	 String uri = "tel:" + number.trim() ;
     	 Intent intent = new Intent(Intent.ACTION_CALL);
     	 intent.setData(Uri.parse(uri));
     	 startActivity(intent);
      }
  });
		
		return root;
	}


	@SuppressWarnings("deprecation")
	@Override
	public void onStart() {
		super.onStart();

		// change dialog width
		if (getDialog() != null) {

			int fullWidth = getDialog().getWindow().getAttributes().width;

			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
				Display display = getActivity().getWindowManager().getDefaultDisplay();
				Point size = new Point();
				display.getSize(size);
				fullWidth = size.x;
			} else {
				Display display = getActivity().getWindowManager().getDefaultDisplay();
				fullWidth = display.getWidth();
			}

			final int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
					.getDisplayMetrics());

			int w = fullWidth - padding;
			int h = getDialog().getWindow().getAttributes().height;

			getDialog().getWindow().setLayout(w, h);
		}
	}
	


}
