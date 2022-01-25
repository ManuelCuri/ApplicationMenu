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
 * Use the {@link postresFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class postresFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerProductos;
    ArrayList<ProductoVo> listaProductos;

    public postresFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment postresFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static postresFragment newInstance(String param1, String param2) {
        postresFragment fragment = new postresFragment();
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
        View vista = inflater.inflate(R.layout.fragment_postres, container, false);

        listaProductos=new ArrayList<>();
        recyclerProductos = vista.findViewById(R.id.recyclerId);
        recyclerProductos.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarLista();

        ProductosAdapter adapter=new ProductosAdapter(listaProductos);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // la accion de la vista
            }
        });

        recyclerProductos.setAdapter(adapter);

        return vista;
    }

    private void llenarLista() {
        listaProductos.add(new ProductoVo("Alfajores","Suaves y ricas con manjar blanco y azucar impalpable, perfeto para acompañamiento","S/ 3.80",R.drawable.alfajores));
        listaProductos.add(new ProductoVo("arroz con leche","postre tradicional con leche y arroz con canela y clavo de olor","S/ 3.20",R.drawable.arroz_leche));
        listaProductos.add(new ProductoVo("Mil Hojas","fritura hecha a vace de arina y aceite espolvoreada con azucar impalpable","S/ 2.80",R.drawable.milhojas));
        listaProductos.add(new ProductoVo("Mazamorra Morada","postre Peruano con historia del pais y con un sabor excelente","S/ 3.80",R.drawable.morada));
        listaProductos.add(new ProductoVo("Suspiro Limeño","Un postre peruano con una historia muy bonita y un sabor increible","S/ 5.30",R.drawable.suspiro));
    }
}