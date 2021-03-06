package com.example.hkings.todorecetas;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link recetas.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link recetas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class recetas extends Fragment implements View.OnClickListener {


    Button buttondesayuno,buttonnalmuerzo,buttoncenas,buttonpostres;





    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public recetas() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment recetas.
     */
    // TODO: Rename and change types and number of parameters
    public static recetas newInstance(String param1, String param2) {
        recetas fragment = new recetas();
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
        // Inflate the layout for this fragment
      //  return inflater.inflate(R.layout.fragment_recetas, container, false);


        View v = inflater.inflate(R.layout.fragment_recetas, container, false);

        ImageButton b = (ImageButton) v.findViewById(R.id.btndesayuno);
        b.setOnClickListener(this);

        ImageButton c = (ImageButton) v.findViewById(R.id.btnalmuerzo);
        c.setOnClickListener(this);

        ImageButton d = (ImageButton) v.findViewById(R.id.btncenas);
        d.setOnClickListener(this);

        ImageButton e = (ImageButton) v.findViewById(R.id.btnpostres);
        e.setOnClickListener(this);
        return v;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btndesayuno:
                Intent i = new Intent(getActivity(), desayunos.class);
                startActivity(i);
                break;

            case R.id.btnalmuerzo:
                Intent e = new Intent(getActivity(), desayunos.class);
                startActivity(e);
                break;

            case R.id.btncenas:
                Intent f = new Intent(getActivity(), desayunos.class);
                startActivity(f);
                break;

            case R.id.btnpostres:
                Intent g = new Intent(getActivity(), desayunos.class);
                startActivity(g);
                break;
        }
    }










    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
