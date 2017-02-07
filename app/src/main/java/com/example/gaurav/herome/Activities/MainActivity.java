package com.example.gaurav.herome.Activities;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.gaurav.herome.Fragments.CharacterBioFragment;
import com.example.gaurav.herome.Fragments.MainFragment;
import com.example.gaurav.herome.Fragments.PickPowerFragment;
import com.example.gaurav.herome.R;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentInteractionListener, PickPowerFragment.PickPowerInteractionListener, CharacterBioFragment.CharacterBioInteractionListener {

   public int POWERTYPE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragment_container);

        if (fragment == null)
        {
            fragment = new MainFragment();
            manager.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }

    public void loadPickPowerScreen(){

        PickPowerFragment pickPowerFragment = new PickPowerFragment();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, pickPowerFragment).addToBackStack(null).commit();
        //this.getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, pickPowerFragment).addToBackStack(null).commit();
    }

    public void loadCharacterBioScreen(){

        CharacterBioFragment CharacterBioFragment = new CharacterBioFragment();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, CharacterBioFragment).addToBackStack(null).commit();
        //this.getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, pickPowerFragment).addToBackStack(null).commit();
    }

     public void loadMainScreen(){

        MainFragment MainFragment = new MainFragment();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, MainFragment).addToBackStack(null).commit();
        //this.getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, pickPowerFragment).addToBackStack(null).commit();
    }
    @Override
    public void onMainFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPickPowerInteraction(Uri uri) {

    }

    @Override
    public void onCharacterBioInteraction(Uri uri) {

    }
}
