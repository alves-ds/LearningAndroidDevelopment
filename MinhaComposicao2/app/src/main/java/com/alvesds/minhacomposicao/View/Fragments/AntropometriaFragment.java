package com.alvesds.minhacomposicao.View.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.alvesds.minhacomposicao.R;
import com.alvesds.minhacomposicao.View.Activities.CalculoImcActivity;
import com.alvesds.minhacomposicao.View.Activities.CalculoRcqActivity;
import com.alvesds.minhacomposicao.View.Activities.PerimetriaActivity;
import com.alvesds.minhacomposicao.View.Activities.ProtocolosDobrasActivity;

public class AntropometriaFragment extends Fragment {

    ImageButton dobras, imc, perimetria, rcq;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_antropometria, container, false);

    }

    @Override
    public void onResume() {
        super.onResume();
        Instancias();
        SelecaoAnalise();
    }

    private void Instancias(){
        dobras = getView().findViewById(R.id.botao_dobras);
        imc = getView().findViewById(R.id.botao_imc);
        perimetria = getView().findViewById(R.id.botao_perimetria);
        rcq = getView().findViewById(R.id.botao_rcq);
    }

    private void SelecaoAnalise(){
        imc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent imc = new Intent(getActivity(), CalculoImcActivity.class);
                startActivity(imc);
            }
        });

        dobras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dobras = new Intent(getActivity(), ProtocolosDobrasActivity.class);
                startActivity(dobras);
            }
        });

        rcq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rcq = new Intent(getActivity(), CalculoRcqActivity.class);
                startActivity(rcq);
            }
        });

        perimetria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent perimetria = new Intent(getActivity(), PerimetriaActivity.class);
                startActivity(perimetria);
            }
        });
    }
}