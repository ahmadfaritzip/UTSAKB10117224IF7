package com.example.utsakb10117224if7.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.utsakb10117224if7.R;
import com.example.utsakb10117224if7.model.DaftarModel;

import java.util.ArrayList;

public class DaftarAdapter extends BaseAdapter {
//    Tanggal Pengerjaan : 11 Mei 2020
//    Nim : 10117224
//    Nama : Ahmad Faritz Ied putra
//    Kelas : IF - 7

    private Context context;
    private int layout;
    private ArrayList<DaftarModel> recordList;

    public DaftarAdapter(Context context, int layout, ArrayList<DaftarModel> recordList){
        this.context = context;
        this.layout = layout;
        this.recordList = recordList;
    }

    @Override
    public int getCount() {
        return recordList.size();
    }

    @Override
    public Object getItem(int position) {
        return recordList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        TextView tvNim, tvNama, tvKelas, tvTelp, tvEmail, tvSosmed;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);
            holder.tvNim = row.findViewById(R.id.tv_nim);
            holder.tvNama = row.findViewById(R.id.tv_nama);
            holder.tvKelas = row.findViewById(R.id.tv_kelas);
            holder.tvTelp = row.findViewById(R.id.tv_telp);
            holder.tvEmail = row.findViewById(R.id.tv_email);
            holder.tvSosmed = row.findViewById(R.id.tv_sosmed);
            row.setTag(holder);
        }else{
            holder = (ViewHolder) row.getTag();
        }
        DaftarModel daftarModel = recordList.get(position);

        holder.tvNim.setText(daftarModel.getNim());
        holder.tvNama.setText(daftarModel.getNama());
        holder.tvKelas.setText(daftarModel.getKelas());
        holder.tvTelp.setText(daftarModel.getTelp());
        holder.tvEmail.setText(daftarModel.getEmail());
        holder.tvSosmed.setText(daftarModel.getSosmed());

        return row;
    }
}
