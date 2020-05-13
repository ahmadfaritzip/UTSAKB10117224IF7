package com.example.utsakb10117224if7.ui.daftar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.utsakb10117224if7.R;
import com.example.utsakb10117224if7.model.DaftarModel;
import com.example.utsakb10117224if7.model.db.DbOpenHelper;
import com.example.utsakb10117224if7.utils.DaftarAdapter;
import com.example.utsakb10117224if7.utils.DaftarDialog;

import java.util.ArrayList;

public class DaftarFragment extends Fragment {
//    Tanggal Pengerjaan : 12 Mei 2020
//    Nim : 10117224
//    Nama : Ahmad Faritz Ied putra
//    Kelas : IF - 7


    Button btn_tambah;
    DbOpenHelper myDb;

    ListView mListView;
    DaftarAdapter daftarAdapter = null;
    ArrayList<DaftarModel> mList;

    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_daftar, container, false);

        mListView = root.findViewById(R.id.listView);
        mList = new ArrayList<>();
        daftarAdapter = new DaftarAdapter(getActivity(), R.layout.card_item_daftar, mList);
        mListView.setAdapter(daftarAdapter);

        myDb = new DbOpenHelper(getActivity());

        updateRecordList();

        if(mList.size() == 0){
            Toast.makeText(getActivity(), "Daftar Teman Kosong ...", Toast.LENGTH_SHORT).show();
        }

        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                //Tampil tombol ubah dan hapus
                final CharSequence[] items = {"Ubah", "Hapus"};

                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity(), R.style.CustomAlertDialogRounded);
                dialog.setTitle("Silahkan Pilih");
                dialog.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(i == 0){
                            //Tombol Ubah
                            Cursor cursor = myDb.getAllData();
                            ArrayList<Integer> arrNim = new ArrayList<Integer>();
                            while (cursor.moveToNext()){
                                arrNim.add(cursor.getInt(0));
                            }
                            Log.d("====>", "onClick: "+position);
                            showDialogUpdate(getActivity(), arrNim.get(position).toString());
                        }
                        if(i == 1){
                            //Tombol Hapus
                            Cursor cursor = myDb.getAllData();
                            ArrayList<Integer> arrNim = new ArrayList<Integer>();
                            while (cursor.moveToNext()){ arrNim.add(cursor.getInt(0)); }
                            showDialogDelete(arrNim.get(position).toString());
//                            Toast.makeText(getActivity(), arrNim.get(position).toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dialog.show();
                return true;
            }
        });

        btn_tambah = root.findViewById(R.id.btn_tambah);
        btn_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DaftarDialog daftarDialog = new DaftarDialog();
                daftarDialog.show(getFragmentManager(), "");
            }
        });
        return root;
    }

    private void showDialogDelete(final String nim) {
        final AlertDialog.Builder dialogDelete = new AlertDialog.Builder(getActivity(), R.style.CustomAlertDialogRounded);
        dialogDelete.setTitle("Warning!!");
        dialogDelete.setMessage("Apakah anda yakin mengapus data ini ?");
        dialogDelete.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    myDb.deleteData(nim);
                    Toast.makeText(getActivity(), "Berhasil Menghapus", Toast.LENGTH_SHORT).show();
                    updateRecordList();
                }catch (Exception e){
                    Toast.makeText(getActivity(), "Tidak Berhasil Menghapus", Toast.LENGTH_SHORT).show();
                    Log.e("Error", e.getMessage() );
                }
            }
        });
        dialogDelete.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialogDelete.show();
    }

    private void showDialogUpdate(Activity activity, final String val_nim){
        final Dialog dialog = new Dialog(activity);
        dialog.setContentView(R.layout.dialog_update_daftar);
        dialog.setTitle("Ubah Biodata Teman");
        String valNim = "";
        String valNama = "";
        String valKelas = "";
        String valTelp = "";
        String valEmail = "";
        String valSosmed = "";

        Cursor data      = myDb.getData(val_nim);
        while (data.moveToNext()) {
            valNim = data.getString(0);
            valNama = data.getString(1);
            valKelas = data.getString(2);
            valTelp = data.getString(3);
            valEmail = data.getString(4);
            valSosmed = data.getString(5);
        }

        final TextView nim    = dialog.findViewById(R.id.edit_text_nim_ubah);
        final EditText nama   = dialog.findViewById(R.id.edit_text_nama_ubah);
        final EditText kelas  = dialog.findViewById(R.id.edit_text_kelas_ubah);
        final EditText telp   = dialog.findViewById(R.id.edit_text_telp_ubah);
        final EditText email  = dialog.findViewById(R.id.edit_text_email_ubah);
        final EditText sosmed = dialog.findViewById(R.id.edit_text_sosmed_ubah);
        Button btnUbah = dialog.findViewById(R.id.btn_form_ubah);

        nim.setText(valNim);
        nama.setText(valNama);
        kelas.setText(valKelas);
        telp.setText(valTelp);
        email.setText(valEmail);
        sosmed.setText(valSosmed);

        int width = (int)(activity.getResources().getDisplayMetrics().widthPixels*0.95);
        int height = (int)(activity.getResources().getDisplayMetrics().heightPixels*0.95);
        dialog.getWindow().setLayout(width, height);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        btnUbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    myDb.updateData(nim.getText().toString(),
                            nama.getText().toString(),
                            kelas.getText().toString(),
                            telp.getText().toString(),
                            email.getText().toString(),
                            sosmed.getText().toString());
                    Toast.makeText(getActivity(), "Berhasil di Ubah", Toast.LENGTH_SHORT).show();
                    updateRecordList();
                }catch (Exception e){
                    Toast.makeText(getActivity(), "Gagal di Ubah", Toast.LENGTH_SHORT).show();
                    Log.e("Update Error ", e.getMessage() );
                }
                dialog.dismiss();
            }
        });
    }

    public void updateRecordList(){
        Cursor data = myDb.getAllData();
        mList.clear();
        while (data.moveToNext()){
            String nim = data.getString(0);
            String nama = data.getString(1);
            String kelas = data.getString(2);
            String telp = data.getString(3);
            String email = data.getString(4);
            String sosmed = data.getString(5);
            mList.add(new DaftarModel(nim, nama, kelas, telp, email, sosmed));
        }
        daftarAdapter.notifyDataSetChanged();
    }

}
