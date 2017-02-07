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
 * {@link PickPowerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PickPowerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PickPowerFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button turtleBtn;
    private Button lightningBtn;
    private Button flightBtn;
    private Button webSlingingBtn;
    private Button laserVision;
    private Button superStrength;
    private Button showBacktoryBtn;


    private PickPowerInteractionListener mListener;

    public PickPowerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PickPowerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PickPowerFragment newInstance(String param1, String param2) {
        PickPowerFragment fragment = new PickPowerFragment();
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

        View view = inflater.inflate(R.layout.fragment_pick_power, container, false);
        turtleBtn = (Button)view.findViewById(R.id.turtleBtn);
        lightningBtn = (Button)view.findViewById(R.id.lightningBtn);
        flightBtn = (Button)view.findViewById(R.id.flightBtn);
        webSlingingBtn = (Button)view.findViewById(R.id.webSlingBtn);
        laserVision = (Button)view.findViewById(R.id.laserVisionBtn);
        superStrength = (Button)view.findViewById(R.id.superStrengthBtn);
        showBacktoryBtn = (Button)view.findViewById(R.id.showBstoryBtn);

        turtleBtn.setOnClickListener(this);
        lightningBtn.setOnClickListener(this);
        flightBtn.setOnClickListener(this);
        webSlingingBtn.setOnClickListener(this);
        laserVision.setOnClickListener(this);
        superStrength.setOnClickListener(this);
        showBacktoryBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity)getActivity();
                mainActivity.loadCharacterBioScreen();
            }
        });

        showBacktoryBtn.setEnabled(false);
        showBacktoryBtn.getBackground().setAlpha(128);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View v) {
        showBacktoryBtn.setEnabled(true);
        showBacktoryBtn.getBackground().setAlpha(255);

        turtleBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.turtlepower_icon,0,0,0);
        lightningBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lightning_icon,0,0,0);
        flightBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.rocket_icon,0,0,0);
        webSlingingBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.spiderweb_icon,0,0,0);
        laserVision.setCompoundDrawablesWithIntrinsicBounds(R.drawable.laservision_icon,0,0,0);
        superStrength.setCompoundDrawablesWithIntrinsicBounds(R.drawable.superstrength_icon,0,0,0);

        Button btn = (Button)v;
        int leftDrawable = 0;

        MainActivity mainActivity = (MainActivity) getActivity();
        if(btn == turtleBtn)
        {
            leftDrawable = R.drawable.turtlepower_icon;
            mainActivity.POWERTYPE = 1;
        }
        else if(btn == lightningBtn)
        {
            leftDrawable = R.drawable.lightning_icon;
            mainActivity.POWERTYPE = 2;
        }
        else if(btn == flightBtn)
        {
            leftDrawable = R.drawable.rocket_icon;
            mainActivity.POWERTYPE = 3;
        }
        else if(btn == webSlingingBtn)
        {
            leftDrawable = R.drawable.spiderweb_icon;
            mainActivity.POWERTYPE = 4;
        }
        else if(btn == laserVision)
        {
            leftDrawable = R.drawable.laservision_icon;
            mainActivity.POWERTYPE = 5;
        }
        else if(btn == superStrength)
        {
            leftDrawable = R.drawable.superstrength_icon;
            mainActivity.POWERTYPE = 6;
        }

        btn.setCompoundDrawablesWithIntrinsicBounds(leftDrawable,0,R.drawable.item_selected_btn,0);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onPickPowerInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PickPowerInteractionListener) {
            mListener = (PickPowerInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement onPickPowerInteractionListener");
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
    public interface PickPowerInteractionListener {
        // TODO: Update argument type and name
        void onPickPowerInteraction(Uri uri);
    }
}
