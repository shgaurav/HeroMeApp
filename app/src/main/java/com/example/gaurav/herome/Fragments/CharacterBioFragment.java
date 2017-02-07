package com.example.gaurav.herome.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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
        startOver.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity)getActivity();
                mainActivity.loadMainScreen();
            }

        });

        MainActivity mainActivity = (MainActivity) getActivity();
        if(mainActivity.POWERTYPE == 1)
        {
            secondaryPower.setText("Turtle Power");
        }
        else if(mainActivity.POWERTYPE == 2)
        {
            secondaryPower.setText("Lightning");
        }
        else if(mainActivity.POWERTYPE == 3)
        {
            secondaryPower.setText("Flight");
        }
        else if(mainActivity.POWERTYPE == 4)
        {
            secondaryPower.setText("Web Slinging");
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
