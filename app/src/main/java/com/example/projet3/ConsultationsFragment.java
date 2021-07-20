package com.example.projet3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConsultationsFragment} factory method to
 * create an instance of this fragment.
 */
public class ConsultationsFragment extends Fragment {
    private ListView listConsultations;
    private String consultations, details;
    private String [] tabConsultations, tabDetails;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_consultations, container, false);
        listConsultations = view.findViewById(R.id.listConsultations);
        tabConsultations = getResources().getStringArray(R.array.tab_consultation);
        tabDetails = getResources().getStringArray(R.array.tab_details);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, tabConsultations);
        listConsultations.setAdapter(adapter); // Charge les donnees sur la liste
        listConsultations.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                consultations = tabConsultations[position];
                details = tabDetails[position];
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setTitle(consultations);
                dialog.setMessage(details);
                dialog.setNegativeButton(getString(R.string.back), null);
                dialog.setPositiveButton(getString(R.string.finish), null);
//                dialog.setPositiveButton(getString(R.string.see_patient), new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        getFragmentManager()
//                                .beginTransaction()
//                                .replace(R.id.nav_host_fragment_content_home,new DetailsPatientFragment())
//                                .addToBackStack(null)
//                                .commit();
//                    }
//                });
                dialog.show();
            }
        });
        return view;
    }
}