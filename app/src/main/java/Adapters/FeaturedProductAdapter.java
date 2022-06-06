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
import com.example.farming.FeaturedProductOverview;
import com.example.farming.ProductDetailsActivity;
import com.example.farming.R;

import java.util.List;

public class FeaturedProductAdapter extends RecyclerView.Adapter<FeaturedProductAdapter.viewHolder> {

    private List<FeaturedProductOverview> dataList;
    private Context context;

    public FeaturedProductAdapter(Context context, List<FeaturedProductOverview> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView productName;
        ImageView image;

        public viewHolder(@NonNull View itemview){
            super(itemview);

            productName = itemview.findViewById(R.id.productName);
            image = itemview.findViewById(R.id.productImage);
        }
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.sample_featured_product, parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        holder.productName.setText(dataList.get(position).getProduct_name());
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ProductDetailsActivity.class);
            intent.putExtra(context.getString(R.string.productId), dataList.get(position).getId());
            context.startActivity(intent);

        });
//        Glide.with(context).load(dataList.get(position).getImage()).override(100,100).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
