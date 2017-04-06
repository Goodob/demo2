package com.app.demo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.app.demo2.home_child.newest;

/***
 * 首页
 */
public class fra_home extends Fragment {

	private View view;

	@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState) {
		 view = inflater.inflate(R.layout.fra_home, container, false);
		return view;
	}
	
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		Button bt = (Button) view.findViewById(R.id.tz);
		bt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(),new newest().getClass());
				getActivity().startActivity(intent);
			}
		});
	}
	
	
	
}
