package com.example.projet3;

import android.app.AlertDialog;
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
 * Use the {@link HelpFragment} factory method to
 * create an instance of this fragment.
 */
public class HelpFragment extends Fragment {
    private ListView askList;
    private String asks, details;
    private String [] tabAsks, tabDetails;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_help, container, false);
        askList = view.findViewById(R.id.listAsk);
        tabAsks = getResources().getStringArray(R.array.tab_help);
        tabDetails = getResources().getStringArray(R.array.tab_details_help);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, tabAsks);
        askList.setAdapter(adapter); // Charge les donnees sur la liste
        askList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                asks = tabAsks[position];
                details = tabDetails[position];
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setTitle(asks);
                dialog.setMessage(details);
                dialog.setNegativeButton(getString(R.string.back), null);
                dialog.setPositiveButton(getString(R.string.finish), null);
                dialog.show();
            }
        });
        return view;
    }
}