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
 * Use the {@link CerdoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CerdoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerProductos;
    ArrayList<ProductoVo> listaProductos;

    public CerdoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CerdoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CerdoFragment newInstance(String param1, String param2) {
        CerdoFragment fragment = new CerdoFragment();
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
        View vistaC=inflater.inflate(R.layout.fragment_cerdo, container, false);

        listaProductos=new ArrayList<>();
        recyclerProductos = vistaC.findViewById(R.id.recyclerId);
        recyclerProductos.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarLista();

        ProductosAdapter adapter=new ProductosAdapter(listaProductos);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //se propone la vista a la cual va dirigida el rpoducto
            }
        });

        recyclerProductos.setAdapter(adapter);

        return vistaC;
    }

    private void llenarLista() {
        listaProductos.add(new ProductoVo("Hamburguesa","Pan artesanal con semillas de ajonjoli y la arne de la mas alta calidad","S/ 11.00",R.drawable.hamburguesa));
        listaProductos.add(new ProductoVo("Taco de Carne","Tortilla de arina con pedasos de carne y los ingredientes mas puros y frescos","S/ 12.50",R.drawable.taco_carne));
        listaProductos.add(new ProductoVo("Lomo de Carne","Carne de calidad y papas fritas con una porcion de ensalada y con las mejores especias","S/ 15.30",R.drawable.lomo_carne));
        listaProductos.add(new ProductoVo("Sandwich Americano","Sandwich muy bien proporcionado con la cantidad exacta y un gran sabor","S/ 9.00",R.drawable.sandwich_americano));
        listaProductos.add(new ProductoVo("Nuggets","Los Nuggets vienen con una capa crujiente que te encantara, con una porsion de salsa espeial","S/ 11.30",R.drawable.nuggets));
    }
}
