package com.example.gaurav.herome.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.gaurav.herome.Activities.MainActivity;
import com.example.gaurav.herome.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CharacterBioFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CharacterBioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CharacterBioFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button startOver;
    private Button primaryPower;
    private Button secondaryPower;
    private TextView name;
    private TextView desc;


    private CharacterBioInteractionListener mListener;

    public CharacterBioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CharacterBioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CharacterBioFragment newInstance(String param1, String param2) {
        CharacterBioFragment fragment = new CharacterBioFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_character_bio, container, false);
        startOver = (Button)view.findViewById(R.id.startOverBtn);
        primaryPower = (Button)view.findViewById(R.id.primaryPowerBtn);
        secondaryPower = (Button)view.findViewById(R.id.secondaryPowerBtn);
        name = (TextView) view.findViewById(R.id.superHeroNameTV);
        desc = (TextView) view.findViewById(R.id.descTV);
        startOver.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity)getActivity();
                mainActivity.loadMainScreen();
            }

        });

        MainActivity mainActivity = (MainActivity) getActivity();
        if(mainActivity.POWERCHOSEN == 1 && mainActivity.HowPowerGot == 2)
        {
            name.setText("Ninja Turtles - TMNT");
            desc.setText("The Teenage Mutant Ninja Turtles (often shortened to TMNT or Ninja Turtles) are four fictional teenaged anthropomorphic turtles named after Renaissance Italian artists. They were trained by their anthropomorphic rat sensei in the art of ninjutsu.");
            primaryPower.setText("Turtle Power");
            secondaryPower.setText("Karate Chopping");

        }
        else if(mainActivity.POWERCHOSEN == 2 && mainActivity.HowPowerGot == 1)
        {
            name.setText("The Flash");
            desc.setText("The first was Jay Garrick, from the Golden Age - later belonging to Earth-Two. He inhaled the vapours of hard water (later, heavy water) to gain his superspeed. The second was Barry Allen, a Silver Age forensic scientist who gained his powers when lightning struck at his lab and doused him with chemicals.");
            primaryPower.setText("Lightning");
            secondaryPower.setText("Time Travel");
        }
        else if(mainActivity.POWERCHOSEN == 3 && mainActivity.HowPowerGot == 3)
        {
            name.setText("Superman");
            desc.setText("Superman, a Kryptonian, flies toward the Earth's yellow sun to recharge his powers. The Photonucleic Effect is the effect by which Kryptonians and creatures from the planet Krypton and, presumably, Daxam as well, are given incredible superpowers by exposure to Earth's Yellow sun.");
            primaryPower.setText("Flight");
            secondaryPower.setText("Super Strength");
        }
        else if(mainActivity.POWERCHOSEN == 4 && mainActivity.HowPowerGot == 1)
        {
            name.setText("Spiderman");
            desc.setText("Spider-Man (Peter Parker) Small hairs on his hands and feet that allow him to adhere to walls and most surfaces. When high school bookworm Peter Parker was bitten by a Radioactive Spider during a science experiment, he soon found out that he had gained the proportionate powers of an arachnid.");
            primaryPower.setText("Web Slinging");
            secondaryPower.setText("Super Strength");
        }
        else if(mainActivity.POWERCHOSEN == 5 && mainActivity.HowPowerGot == 2)
        {
            name.setText("Cyclops - XMEN");
            desc.setText("The first X-Man, Scott Summers possesses the mutant ability to draw ambient energy from another dimension through his eyes which are actually portals to the dimension, he usually channels this energy into concussive force blasts. He is visually distinctive for the ruby quartz visor he wears to control his devastating power. A born leader, Cyclops succeeded his mentor Professor X to command the X-Men.");
            primaryPower.setText("Laser Vision");
            secondaryPower.setText("Strategist");

        }
        else if(mainActivity.POWERCHOSEN == 6 && mainActivity.HowPowerGot == 1)
        {
            name.setText("Incredible Hulk");
            desc.setText("The Incredible Hulk is a embodiment of Super Strength, Unstoppable Rage. Emotionally-repressed scientific genius Dr. Bruce Banner, while employed as a weapons designer for the US Army, is exposed to a massive dose of gamma radiation in the process of saving teenager Rick Jones from a bomb test, and as a result now changes into a gigantic green musclebound.");
            primaryPower.setText("Super Strength");
            secondaryPower.setText(" Unstoppable Rage");
        }
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View v) {

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onCharacterBioInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof CharacterBioInteractionListener) {
            mListener = (CharacterBioInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
    public interface CharacterBioInteractionListener {
        // TODO: Update argument type and name
        void onCharacterBioInteraction(Uri uri);
    }
}
