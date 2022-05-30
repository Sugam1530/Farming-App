package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farming.SingleProductOverview;
import com.example.farming.R;

import java.util.List;

public class ProductDetailsAdapter extends RecyclerView.Adapter<ProductDetailsAdapter.viewHolder> {

    private List<SingleProductOverview> dataList;
    private Context context;

    public ProductDetailsAdapter(Context context, List<SingleProductOverview> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        TextView product_name,product_details;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            product_name = itemView.findViewById(R.id.product_name);
            product_details = itemView.findViewById(R.id.product_details);

        }
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.sample_product_list, parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.product_name.setText(dataList.get(position).getSingleProductDetails_name());
        holder.product_details.setText(dataList.get(position).getSingleProduct_details());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
