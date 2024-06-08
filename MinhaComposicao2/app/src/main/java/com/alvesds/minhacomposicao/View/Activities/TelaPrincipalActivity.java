package com.alvesds.minhacomposicao.View.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.alvesds.minhacomposicao.R;
import com.alvesds.minhacomposicao.View.Fragments.AntropometriaFragment;
import com.alvesds.minhacomposicao.View.Fragments.HistoricoFragment;
import com.alvesds.minhacomposicao.View.Fragments.OutrasMedidasFragment;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class TelaPrincipalActivity extends AppCompatActivity {

    ChipNavigationBar bottomnav;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_praticante);

        bottomnav = findViewById(R.id.botton_nav);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HistoricoFragment()).commit();
        MudarTela();
    }

    public void MudarTela() {
        bottomnav.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int id) {
                Fragment fragment = null;
                switch (id) {
                    case R.id.nav_historico:
                        fragment = new HistoricoFragment();
                        break;
                    case R.id.nav_antropo:
                        fragment = new AntropometriaFragment();
                        break;
                    case R.id.nav_outras_medidas:
                        fragment = new OutrasMedidasFragment();
                        break;
                }

                if (fragment != null) {
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.frame_layout, fragment)
                            .commit();
                }
            }
        });
    }

}