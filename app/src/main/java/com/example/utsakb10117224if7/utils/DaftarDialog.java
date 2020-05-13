package com.example.utsakb10117224if7.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.utsakb10117224if7.R;
import com.example.utsakb10117224if7.model.db.DbOpenHelper;
import com.example.utsakb10117224if7.ui.daftar.DaftarFragment;

public class DaftarDialog extends AppCompatDialogFragment {
//    Tanggal Pengerjaan : 11 Mei 2020
//    Nim : 10117224
//    Nama : Ahmad Faritz Ied putra
//    Kelas : IF - 7


    private EditText val_nim, val_nama, val_kelas, val_email, val_telp, val_sosmed;
    DbOpenHelper myDb;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.CustomAlertDialogRounded);

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View root = inflater.inflate(R.layout.dialog_add_layout, null);

        val_nim    = root.findViewById(R.id.edit_text_nim);
        val_nama   = root.findViewById(R.id.edit_text_nama);
        val_kelas  = root.findViewById(R.id.edit_text_kelas);
        val_telp   = root.findViewById(R.id.edit_text_telp);
        val_email  = root.findViewById(R.id.edit_text_email);
        val_sosmed = root.findViewById(R.id.edit_text_sosmed);
        myDb = new DbOpenHelper(getActivity());

        builder.setView(root)
                .setTitle("Tambah Daftar Teman")
                .setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getDialog().dismiss();
                    }
                })
                .setPositiveButton("Tambah", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(getActivity(), val_nim.getText(), Toast.LENGTH_LONG).show();
                        String nim    = val_nim.getText().toString();
                        String nama   = val_nama.getText().toString();
                        String kelas  = val_kelas.getText().toString();
                        String telp   = val_telp.getText().toString();
                        String email  = val_email.getText().toString();
                        String sosmed = val_sosmed.getText().toString();
                        Boolean tambah= false;

                        if(!nim.isEmpty()){
                            tambah = myDb.insertData(nim, nama, kelas, telp, email, sosmed);
                        }

                        if(tambah){
                            Toast.makeText(getActivity(), "Berhasil Menambahkan", Toast.LENGTH_LONG).show();
                            FragmentTransaction f = getFragmentManager().beginTransaction();
                            f.replace(R.id.layout_frame, new DaftarFragment());
                            f.commit();
                        }else{
                            Toast.makeText(getActivity(), "Gagal Menambahkan", Toast.LENGTH_LONG).show();
                        }

                    }
                });
        return builder.create();
    }

}
