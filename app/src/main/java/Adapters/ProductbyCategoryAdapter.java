package Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.farming.ProductDetailsActivity;
import com.example.farming.ProductOverview;
import com.example.farming.ProductbyCategoryOverview;
import com.example.farming.R;

import java.util.List;

public class ProductbyCategoryAdapter extends RecyclerView.Adapter<ProductbyCategoryAdapter.viewHolder> {

    private List<ProductbyCategoryOverview> datalist;
    private Context context;

    public ProductbyCategoryAdapter(Context context, List<ProductbyCategoryOverview> dataList){
        this.context = context;
        this.datalist = dataList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.sample_productbycat, parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.product_name.setText(datalist.get(position).getProduct_name());
        holder.product_details.setText(datalist.get(position).getProduct_details());
        holder.mrpPrice.setText(datalist.get(position).getMrp());
        holder.spPrice.setText(datalist.get(position).getSp());
        Glide.with(context).load(datalist.get(position).getImage()).override(100,100).into(holder.productImage);

        holder.itemView.setOnClickListener(view -> {
            Intent productDetailsIntent = new Intent(context, ProductDetailsActivity.class) ;
            productDetailsIntent.putExtra(context.getString(R.string.productId), datalist.get(position).getId());
            context.startActivity(productDetailsIntent);
        });

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        TextView product_name,product_details,mrpPrice,spPrice;
        ImageView productImage;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            product_name = itemView.findViewById(R.id.product_name);
            product_details = itemView.findViewById(R.id.product_details);
            mrpPrice = itemView.findViewById(R.id.mrpPrice);
            spPrice = itemView.findViewById(R.id.spPrice);
            productImage = itemView.findViewById(R.id.productImage);

        }
    }


}

