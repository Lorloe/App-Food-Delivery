package com.eddie.appbanhang.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eddie.appbanhang.R;
import com.eddie.appbanhang.model.Sanpham;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class TieudungBaseAdapter extends BaseAdapter{
    Context context ;
    ArrayList <Sanpham> listSanPham;

    public TieudungBaseAdapter(Context context, ArrayList<Sanpham> listSanPham) {
        this.context = context;
        this.listSanPham = listSanPham;
    }

    @Override
    public int getCount() {
        return listSanPham.size();
    }

    @Override
    public Object getItem(int i) {
        return listSanPham.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    class ViewHolder{
        ImageView ingTieuDung;
        TextView tvTenTD,tvGiaTD,tvMoTaTD;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view==null){
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=layoutInflater.inflate(R.layout.tieudung_item,null);
            viewHolder.ingTieuDung = view.findViewById(R.id.img_tieudung);
            viewHolder.tvTenTD = view.findViewById(R.id.tv_tensptieudung);
            viewHolder.tvGiaTD = view.findViewById(R.id.tv_giasptieudung);
            viewHolder.tvMoTaTD = view.findViewById(R.id.tv_motasptieudung);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Sanpham sanpham = (Sanpham) getItem(i);
        viewHolder.tvTenTD.setText(sanpham.getTensp());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.tvGiaTD.setText("Giá: "+decimalFormat.format(sanpham.getGiasp())+" vnđ");
        Glide.with(context).load(sanpham.getHinhanhsp()).placeholder(R.drawable.ic_launcher_background).into(viewHolder.ingTieuDung);
        viewHolder.tvMoTaTD.setMaxLines(3);
        viewHolder.tvMoTaTD.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.tvMoTaTD.setText(sanpham.getMotasp());
        return view;
    }
}
