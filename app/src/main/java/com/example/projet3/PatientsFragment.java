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
 * Use the {@link PatientsFragment} factory method to
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

        View view = inflater.inflate(R.layout.fragment_patients, container, false);
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
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setTitle(patients);
                dialog.setMessage(details);
                dialog.setNegativeButton(getString(R.string.back), null);
                dialog.setPositiveButton(getString(R.string.see_patient), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getFragmentManager()
                                .beginTransaction()
                                .replace(R.id.nav_host_fragment_content_home,new DetailsPatientFragment())
                                .addToBackStack(null)
                                .commit();
                    }
                });
                dialog.show();
            }
        });
        return view;
    }
}