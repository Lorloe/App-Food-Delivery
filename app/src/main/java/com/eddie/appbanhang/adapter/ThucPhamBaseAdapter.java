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

public class ThucPhamBaseAdapter extends BaseAdapter {
    Context context ;
    ArrayList<Sanpham> listSanPham;

    public ThucPhamBaseAdapter(Context context, ArrayList<Sanpham> listSanPham) {
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
        ImageView ingThucPham;
        TextView tvTenTP,tvGiaTP,tvMoTaTP;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ThucPhamBaseAdapter.ViewHolder viewHolder = null;
        if (view==null){
            viewHolder = new ThucPhamBaseAdapter.ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=layoutInflater.inflate(R.layout.thucpham_item,null);
            viewHolder.ingThucPham = view.findViewById(R.id.img_thucpham);
            viewHolder.tvTenTP = view.findViewById(R.id.tv_tensptp);
            viewHolder.tvGiaTP = view.findViewById(R.id.tv_giasptp);
            viewHolder.tvMoTaTP = view.findViewById(R.id.tv_motasptp);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ThucPhamBaseAdapter.ViewHolder) view.getTag();
        }
        Sanpham sanpham = (Sanpham) getItem(i);
        viewHolder.tvTenTP.setText(sanpham.getTensp());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.tvGiaTP.setText("Giá: "+decimalFormat.format(sanpham.getGiasp())+" vnđ");
        Glide.with(context).load(sanpham.getHinhanhsp()).placeholder(R.drawable.ic_launcher_background).into(viewHolder.ingThucPham);
        viewHolder.tvMoTaTP.setMaxLines(3);
        viewHolder.tvMoTaTP.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.tvMoTaTP.setText(sanpham.getMotasp());
        return view;
    }
}
