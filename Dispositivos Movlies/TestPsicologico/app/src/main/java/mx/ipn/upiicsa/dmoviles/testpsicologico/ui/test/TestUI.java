package mx.ipn.upiicsa.dmoviles.testpsicologico.ui.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import mx.ipn.upiicsa.dmoviles.testpsicologico.FactorsActivity;
import mx.ipn.upiicsa.dmoviles.testpsicologico.R;
import mx.ipn.upiicsa.dmoviles.testpsicologico.RorschachActivity;

public class TestUI extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_test, container, false);

        return root;

    }


}
