package com.example.applicationmenu.Recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applicationmenu.R;

import java.util.ArrayList;

public class ProductosAdapter extends RecyclerView.Adapter<ProductosAdapter.ViewHolderProductos>
                implements View.OnClickListener{

    ArrayList<ProductoVo> listaProductos;
    private View.OnClickListener listener;

    public ProductosAdapter(ArrayList<ProductoVo> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @NonNull
    @Override
    public ViewHolderProductos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);

        //metodo Listener
        view.setOnClickListener(this);

        return new ViewHolderProductos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProductos holder, int position) {
        holder.etiNombre.setText(listaProductos.get(position).getNombre());
        holder.etiInformacion.setText(listaProductos.get(position).getInfo());
        holder.etiPrecio.setText(listaProductos.get(position).getPrecio());
        holder.foto.setImageResource(listaProductos.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    //Metodo OnClick Para la Navegacion De Fragments basico
    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolderProductos extends RecyclerView.ViewHolder {

        TextView etiNombre,etiInformacion,etiPrecio;
        ImageView foto;

        public ViewHolderProductos(@NonNull View itemView) {
            super(itemView);
            etiNombre=itemView.findViewById(R.id.idNombre);
            etiInformacion=itemView.findViewById(R.id.idInfo);
            etiPrecio=itemView.findViewById(R.id.idPrecio);
            foto=itemView.findViewById(R.id.idImagen);
        }
    }
}
