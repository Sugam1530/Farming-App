package Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farming.FeaturedCategoryOverview;
import com.example.farming.ProductDetailsActivity;
import com.example.farming.Product_by_category;
import com.example.farming.R;

import java.util.List;

public class FeaturedCategoryAdapter extends RecyclerView.Adapter<FeaturedCategoryAdapter.viewHolder> {

    private List<FeaturedCategoryOverview> dataList;
    private Context context;

    public  FeaturedCategoryAdapter(Context context, List<FeaturedCategoryOverview> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView categoryName;

        public viewHolder(@NonNull View itemview){
            super(itemview);

            categoryName = itemview.findViewById(R.id.categoryName);
//            image = itemview.findViewById(R.id.productImage);
        }
    }




    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.sample_featured_category, parent,false);
        return new FeaturedCategoryAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.categoryName.setText(dataList.get(position).getName());
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, Product_by_category.class);
            intent.putExtra(context.getString(R.string.cat_id), dataList.get(position).getId());
            context.startActivity(intent);

        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
