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
 * Use the {@link VegetalesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VegetalesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerProductos;
    ArrayList<ProductoVo> listaProductos;

    public VegetalesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VegetalesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VegetalesFragment newInstance(String param1, String param2) {
        VegetalesFragment fragment = new VegetalesFragment();
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
        View vistaV=inflater.inflate(R.layout.fragment_vegetales, container, false);

        listaProductos=new ArrayList<>();
        recyclerProductos = vistaV.findViewById(R.id.recyclerId);
        recyclerProductos.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarLista();

        ProductosAdapter adapter = new ProductosAdapter(listaProductos);

        //el metodo setOnClickListener se tiene que colocar en los Fragments.java

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /////// aqui se propone la viste a la cual va dirigida
            }
        });

        recyclerProductos.setAdapter(adapter);

        return vistaV;
    }

    private void llenarLista() {
        listaProductos.add(new ProductoVo("Ensalada Americana","Ensalada hecho on las mejores verduras y con piña","S/ 7.00",R.drawable.ensalada_americana));
        listaProductos.add(new ProductoVo("Ensalada C.Americana","Ensalada Comercial pequeña con piña y algunos pedasos de pollo","S/ 6.30",R.drawable.ensalada_comercial_americana));
        listaProductos.add(new ProductoVo("Ensalada Mixta","Hecho con las verduras mas frescas con pollo, piña y papas y una salsa especial","S/ 7.30",R.drawable.ensalada_mix));
        listaProductos.add(new ProductoVo("Ensalada de Pollo","Ensalada con piesas de pollo y una salsa agridulce especial","S/ 10.00",R.drawable.ensalada_pollo));
        listaProductos.add(new ProductoVo("Ensalada Tradicional","Ensalada con tomate, pepino, lechuga y zanahoria para acompañar cualquier plato","S/ 6.50",R.drawable.ensalada_tradicional));
    }
}