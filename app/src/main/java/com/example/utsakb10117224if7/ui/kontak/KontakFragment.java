package com.example.utsakb10117224if7.ui.kontak;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.utsakb10117224if7.R;

public class KontakFragment extends Fragment {
//    Tanggal Pengerjaan : 10 Mei 2020
//    Nim : 10117224
//    Nama : Ahmad Faritz Ied putra
//    Kelas : IF - 7

    TextView textVNama,textVphoto,textVFollow,textVFollowing, textVFollowNum,textVFollowingNum, textVTelp, textVEmail, textVIg;
    Typeface rLight;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_kontak, container, false);

        textVNama = root.findViewById(R.id.tv_kontak_nama);
        textVphoto = root.findViewById(R.id.tv_kontak_nama);
        textVFollow = root.findViewById(R.id.tv_kontak_nama);
        textVFollowing = root.findViewById(R.id.tv_kontak_nama);
        textVFollowNum = root.findViewById(R.id.tv_kontak_nama);
        textVFollowingNum = root.findViewById(R.id.tv_kontak_nama);
        textVTelp = root.findViewById(R.id.tv_kontak_nama);
        textVEmail = root.findViewById(R.id.tv_kontak_nama);
        textVIg = root.findViewById(R.id.tv_kontak_nama);
        rLight  = Typeface.createFromAsset(getActivity().getAssets(),  "fonts/Raleway-Light.ttf");
        textVNama.setTypeface(rLight);
        textVphoto.setTypeface(rLight);
        textVFollow.setTypeface(rLight);
        textVFollowing.setTypeface(rLight);
        textVFollowNum.setTypeface(rLight);
        textVFollowingNum.setTypeface(rLight);
        textVTelp.setTypeface(rLight);
        textVEmail.setTypeface(rLight);
        textVIg.setTypeface(rLight);


        return root;
    }
}
