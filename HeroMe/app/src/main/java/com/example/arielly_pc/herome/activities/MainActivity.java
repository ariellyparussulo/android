package com.example.arielly_pc.herome.activities;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.arielly_pc.herome.R;
import com.example.arielly_pc.herome.fragments.MainFragment;
import com.example.arielly_pc.herome.fragments.PickAPowerFragment;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentInterface,
																PickAPowerFragment.OnPickAPowerInteraction {
	private String chosenPower;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		FragmentManager fragmentManager = getSupportFragmentManager();
		Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);

		if (fragment == null){
			fragment = new MainFragment();
			fragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit();
		}
	}

	public void loadPickAPowerScreen () {
		PickAPowerFragment pickAPowerFragment = new PickAPowerFragment();
		getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, pickAPowerFragment).addToBackStack(null).commit();
	}
}
