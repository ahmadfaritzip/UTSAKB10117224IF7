package com.example.utsakb10117224if7.ui.profil;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import com.example.utsakb10117224if7.R;

public class ProfilFragment extends Fragment {
//    Tanggal Pengerjaan : 10 Mei 2020
//    Nim : 10117224
//    Nama : Ahmad Faritz Ied putra
//    Kelas : IF - 7
    TextView textVNama,textVNim,textVKelas,textVDeskripsi, textVNim2;
    Typeface rLight,rSemibold;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profil, container, false);

        textVNama = root.findViewById(R.id.text_view_nama);
        textVNim = root.findViewById(R.id.text_view_nama);
        textVNim2 = root.findViewById(R.id.text_view_nama);
        textVKelas= root.findViewById(R.id.text_view_nama);
        textVDeskripsi = root.findViewById(R.id.text_view_nama);
        textVNama = root.findViewById(R.id.text_view_nama);
        rLight  = Typeface.createFromAsset(getActivity().getAssets(),  "fonts/Raleway-Light.ttf");
        rSemibold  = Typeface.createFromAsset(getActivity().getAssets(),  "fonts/Raleway-SemiBold.ttf");
        textVNama.setTypeface(rSemibold);
        textVNim.setTypeface(rLight);
        textVNim2.setTypeface(rLight);
        textVKelas.setTypeface(rLight);
        textVDeskripsi.setTypeface(rLight);

        return root;
    }
}
