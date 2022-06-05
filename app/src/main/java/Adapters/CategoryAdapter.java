package Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farming.CategoryOverview;
import com.example.farming.CategoryOverview;
import com.example.farming.ProductDetailsActivity;
import com.example.farming.Product_by_category;
import com.example.farming.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.viewHolder>{

    private List<CategoryOverview> dataList;
    private Context context;

    public CategoryAdapter(Context context, List<CategoryOverview> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        TextView category_name;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            category_name = itemView.findViewById(R.id.category_name);

        }
    }


    @NonNull
    @Override
    public CategoryAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.sample_category_list, parent,false);
        return new CategoryAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.viewHolder holder, int position) {
        holder.category_name.setText(dataList.get(position).getName());
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, Product_by_category.class);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
