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
public class PatientsFragment extends Fragment {
    private ListView listPatients;
    private String patients, details;
    private String [] tabPatients, tabDetails;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_consultations, container, false);
        listPatients = view.findViewById(R.id.listPatients);
        tabPatients = getResources().getStringArray(R.array.tab_patient);
        tabDetails = getResources().getStringArray(R.array.tab_details_patient);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, tabPatients);
        listPatients.setAdapter(adapter); // Charge les donnees sur la liste
        listPatients.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                patients = tabPatients[position];
                details = tabDetails[position];
                getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment_container,new DetailsPatientFragment())
                    .addToBackStack(null)
                    .commit();
            }
        });
        return view;
    }
}