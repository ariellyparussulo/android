package com.example.arielly_pc.herome.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.arielly_pc.herome.R;
import com.example.arielly_pc.herome.activities.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragmentInterface} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment implements View.OnClickListener{
	private Button btnAccident;
	private Button btnGenetic;
	private Button btnBorn;
	private Button btnChoose;

	private MainFragmentInterface mListener;

	public MainFragment() {
		// Required empty public constructor
	}

	/**
	 * Use this factory method to create a new instance of
	 * this fragment using the provided parameters.
	 *
	 * @return A new instance of fragment MainFragment.
	 */
	public static MainFragment newInstance() {
		MainFragment fragment = new MainFragment();
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
		View view = inflater.inflate(R.layout.fragment_main, container, false);

		btnAccident = (Button) view.findViewById(R.id.btn_accident);
		btnGenetic = (Button) view.findViewById(R.id.btn_genetic);
		btnBorn = (Button) view.findViewById(R.id.btn_born);
		btnChoose = (Button) view.findViewById(R.id.btn_choose);

		btnAccident.setOnClickListener(this);
		btnBorn.setOnClickListener(this);
		btnGenetic.setOnClickListener(this);

		btnChoose.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				MainActivity mainActivity = (MainActivity) getActivity();
				mainActivity.setChosenPower();
				mainActivity.loadPickAPowerScreen();
			}
		});

		btnChoose.setEnabled(false);
		btnChoose.getBackground().setAlpha(128);

		return view;
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		if (context instanceof MainFragmentInterface) {
			mListener = (MainFragmentInterface) context;
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
		int leftDrawable;

		Button btn = (Button) v;

		btnBorn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.rocket, 0, 0, 0);
		btnAccident.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lightning, 0, 0, 0);
		btnGenetic.setCompoundDrawablesWithIntrinsicBounds(R.drawable.atomic, 0, 0, 0);

		if (btn == btnBorn) {
			leftDrawable = R.drawable.rocket;
		} else if (btn == btnAccident) {
		 	leftDrawable = R.drawable.lightning;
		} else {
			leftDrawable = R.drawable.atomic;
		}

		btn.setCompoundDrawablesWithIntrinsicBounds(leftDrawable, 0, R.drawable.item_selected, 0);

		btnChoose.setEnabled(true);
		btnChoose.getBackground().setAlpha(255);
	}

	/**
	 * This interface must be implemented by activities that contain this
	 * fragment to allow an interaction in this fragment to be communicated
	 * to the activity and potentially other fragments contained in that
	 * activity.
	 * <p>
	 * See the Android Training lesson <a href=
	 * "http://developer.android.com/training/basics/fragments/communicating.html"
	 * >Communicating with Other Fragments</a> for more information.
	 */
	public interface MainFragmentInterface {
	}
}
