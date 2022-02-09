package com.iot.panel.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.iot.panel.R;
import com.iot.panel.db.DaoSession;
import com.iot.panel.db.FormOne;
import com.iot.panel.db.FormOneDao;
import com.iot.panel.ui.activity.MainActivity;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeFragment extends BaseFragment {

    @BindView(R.id.source_spinner)
    Spinner sourceSpinner;

    @BindView(R.id.mode_de_pose_spinner)
    Spinner modeDePoseSpinner;

    @BindView(R.id.etat_spinner)
    Spinner etatSpinner;

    @BindView(R.id.type_spinner)
    Spinner typeSpinner;

    @BindView(R.id.ip_spinner)
    Spinner ipSpinner;

    @BindView(R.id.protection_spinner)
    Spinner protectionSpinner;

    @BindView(R.id.etat_protection_spinner)
    Spinner etatProtectionSpinner;

    @BindView(R.id.contacteur_spinner)
    Spinner contacteurSpinner;

    @BindView(R.id.etat_de_concat_spinner)
    Spinner etatDeConcatSpinner;

    @BindView(R.id.type_de_commande_spinner)
    Spinner typeDeCommandeSpinner;

    @BindView(R.id.nombre_de_depart_spinner)
    Spinner nombreDeDepartSpinner;

    @BindView(R.id.protection_de_depart_spinner)
    Spinner protectionDeDepartSpinner;

    @BindView(R.id.txt_numero_de)
    TextView txtNumeroDe;

    @BindView(R.id.txt_calibre)
    TextView txtCalibre;

    @BindView(R.id.txt_dimension)
    TextView txtDimension;

    @BindView(R.id.txt_tension)
    TextView txtTension;

    ArrayAdapter<String> adapter;

    DaoSession daoSession;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(HomeFragment.this, rootView);
        return rootView;
    }

    @Override
    protected void setUpUI() {
        if (mainActivity != null && isAdded()) {
            daoSession = ((MainActivity) getContext()).getDaoSession();
            adapter = new ArrayAdapter<>(mainActivity,
                    R.layout.layout_spinner, R.id.text_view,
                    getResources().getStringArray(R.array.sources_array));
            sourceSpinner.setAdapter(adapter);

            adapter = new ArrayAdapter<>(mainActivity,
                    R.layout.layout_spinner, R.id.text_view,
                    getResources().getStringArray(R.array.mode_de_pose_array));
            modeDePoseSpinner.setAdapter(adapter);

            adapter = new ArrayAdapter<>(mainActivity,
                    R.layout.layout_spinner, R.id.text_view,
                    getResources().getStringArray(R.array.etat_array));
            etatSpinner.setAdapter(adapter);

            adapter = new ArrayAdapter<>(mainActivity,
                    R.layout.layout_spinner, R.id.text_view,
                    getResources().getStringArray(R.array.type_array));
            typeSpinner.setAdapter(adapter);

            adapter = new ArrayAdapter<>(mainActivity,
                    R.layout.layout_spinner, R.id.text_view,
                    getResources().getStringArray(R.array.type_array));
            ipSpinner.setAdapter(adapter);

            adapter = new ArrayAdapter<>(mainActivity,
                    R.layout.layout_spinner, R.id.text_view,
                    getResources().getStringArray(R.array.type_array));
            protectionSpinner.setAdapter(adapter);

            adapter = new ArrayAdapter<>(mainActivity,
                    R.layout.layout_spinner, R.id.text_view,
                    getResources().getStringArray(R.array.etat_protection_array));
            etatProtectionSpinner.setAdapter(adapter);

            adapter = new ArrayAdapter<>(mainActivity,
                    R.layout.layout_spinner, R.id.text_view,
                    getResources().getStringArray(R.array.contacteur_array));
            contacteurSpinner.setAdapter(adapter);

            adapter = new ArrayAdapter<>(mainActivity,
                    R.layout.layout_spinner, R.id.text_view,
                    getResources().getStringArray(R.array.etat_de_contacteur_array));
            etatDeConcatSpinner.setAdapter(adapter);

            adapter = new ArrayAdapter<>(mainActivity,
                    R.layout.layout_spinner, R.id.text_view,
                    getResources().getStringArray(R.array.type_de_commande_array));
            typeDeCommandeSpinner.setAdapter(adapter);


            adapter = new ArrayAdapter<>(mainActivity,
                    R.layout.layout_spinner, R.id.text_view,
                    getResources().getStringArray(R.array.nombre_de_depart_array));
            nombreDeDepartSpinner.setAdapter(adapter);

            adapter = new ArrayAdapter<>(mainActivity,
                    R.layout.layout_spinner, R.id.text_view,
                    getResources().getStringArray(R.array.nombre_de_depart_array));
            protectionDeDepartSpinner.setAdapter(adapter);


        }
    }

    @OnClick(R.id.btn_submit)
    void submitData(){
        if(mainActivity != null && isAdded()){
            FormOneDao formOneDao = daoSession.getFormOneDao();
            FormOne formOne = new FormOne();
            formOne.setSource(sourceSpinner.getSelectedItem().toString());
            formOne.setNumero_de_compteur(txtNumeroDe.getText().toString().trim());
            formOne.setCalibre(txtCalibre.getText().toString().trim());
            formOne.setMode_de_pose(modeDePoseSpinner.getSelectedItem().toString());
            formOne.setDimension(txtDimension.getText().toString().trim());
            formOne.setEtat_de_lenvelope(etatSpinner.getSelectedItem().toString());
            formOne.setType_d_envelope(typeSpinner.getSelectedItem().toString());
            formOne.setIp(ipSpinner.getSelectedItem().toString());
            formOne.setType_de_protection_generale(protectionDeDepartSpinner.getSelectedItem().toString());
            formOne.setEtat_de_protection(etatProtectionSpinner.getSelectedItem().toString());
            formOne.setNombre_de_contacteur(nombreDeDepartSpinner.getSelectedItem().toString());
            formOne.setProtection_de_depart(protectionDeDepartSpinner.getSelectedItem().toString());
            formOne.setTension(txtTension.getText().toString().trim());
            formOneDao.insert(formOne);
        }

    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void updateUI() {
        if (mainActivity != null && isAdded()) {
        }
    }

    @Override
    protected void setUpToolBar() {

    }

    @Override
    public void enableView() {

    }

    @Override
    public void disableView() {

    }
}
