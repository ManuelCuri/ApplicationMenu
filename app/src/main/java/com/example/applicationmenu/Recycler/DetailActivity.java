package com.example.applicationmenu.Recycler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.applicationmenu.R;

public class DetailActivity extends AppCompatActivity {
    private ImageView imgItemDetail;
    private TextView TituloDetail;
    private TextView DescriptionDetail;
    private TextView PrecioDetail;
    private ProductoVo itemDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setTitle(getClass().getSimpleName());

        initViews();
        initValues();
    }


    private void initViews(){
        imgItemDetail = findViewById(R.id.imgItemDetail);
        TituloDetail = findViewById(R.id.TituloDetail);
        DescriptionDetail = findViewById(R.id.DescripcionDetail);
        PrecioDetail = findViewById(R.id.PrecioDetail);
    }

    private void initValues(){
        itemDetail = (ProductoVo) getIntent().getExtras().getSerializable("itemDetail");

        imgItemDetail.setImageResource(itemDetail.getFoto());
        TituloDetail.setText(itemDetail.getNombre());
        DescriptionDetail.setText(itemDetail.getInfo());
        PrecioDetail.setText(itemDetail.getPrecio());
    }
}