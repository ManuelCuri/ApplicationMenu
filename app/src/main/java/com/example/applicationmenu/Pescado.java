package com.example.applicationmenu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.applicationmenu.Recycler.ProductoVo;
import com.example.applicationmenu.Recycler.ProductosAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Pescado#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Pescado extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerProductos;
    ArrayList<ProductoVo> listaProductos;

    public Pescado() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Pescado.
     */
    // TODO: Rename and change types and number of parameters
    public static Pescado newInstance(String param1, String param2) {
        Pescado fragment = new Pescado();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vistaP=inflater.inflate(R.layout.fragment_pescado, container, false);

        listaProductos=new ArrayList<>();
        recyclerProductos = vistaP.findViewById(R.id.recyclerId);
        recyclerProductos.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarLista();

        ProductosAdapter adapter = new ProductosAdapter(listaProductos);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //vista propuesta AQUI
            }
        });

        recyclerProductos.setAdapter(adapter);

        return vistaP;
    }

    private void llenarLista() {
        listaProductos.add(new ProductoVo("Ceviche","Plato bandera tradicional del Peru y con variedades de mariscos","S/ 18.00",R.drawable.ceviche));
        listaProductos.add(new ProductoVo("Escabeche","Pescado al Vapor con una salsa exquisita y aceite para obtener un sabor excepcional","S/ 21.00",R.drawable.escabeche));
        listaProductos.add(new ProductoVo("Nuggets de Pescado","Nuggets Fritas con doble capa de cobertura y con una salsa espeial","S/ 9.00",R.drawable.nuggets_pescado));
        listaProductos.add(new ProductoVo("Pescado a la Plancha","pescado a la plancha con las mejores espeicias y un aroma perfecto","S/ 17.50",R.drawable.pescado_plancha));
        listaProductos.add(new ProductoVo("Pescado Frito","Fritura crocante con aceite y las mejores especias con una porcion de papas y ensalada","S/ 18.00",R.drawable.pescado_frito));
    }
}












