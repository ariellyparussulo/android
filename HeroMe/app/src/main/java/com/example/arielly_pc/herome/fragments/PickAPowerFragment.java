package com.example.arielly_pc.herome.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.arielly_pc.herome.R;

public class PickAPowerFragment extends Fragment implements  View.OnClickListener{
	private OnPickAPowerInteraction mListener;

	private Button btnTurtle, btnLightning, btnFight, btnWeb, btnLaser, btnSuper, btnBackStory;
	private int numberOfChoices = 0;

	public PickAPowerFragment() {
		// Required empty public constructor
	}

	// TODO: Rename and change types and number of parameters
	public static PickAPowerFragment newInstance(String param1, String param2) {
		PickAPowerFragment fragment = new PickAPowerFragment();
		Bundle args = new Bundle();

		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_pick_apower, container, false);

		btnTurtle.setOnClickListener(this);
		btnLightning.setOnClickListener(this);
		btnFight.setOnClickListener(this);
		btnWeb.setOnClickListener(this);
		btnLaser.setOnClickListener(this);
		btnSuper.setOnClickListener(this);

		return view;
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		if (context instanceof OnPickAPowerInteraction) {
			mListener = (OnPickAPowerInteraction) context;
		} else {
			throw new RuntimeException(context.toString()
					+ " must implement OnPickAPowerInteraction");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mListener = null;
	}

	@Override
	public void onClick(View v) {
		Button button = (Button) v;
	}

	public interface OnPickAPowerInteraction {

	}
}
