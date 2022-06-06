package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farming.R;
import com.example.farming.TransactionHistoryOverview;

import java.util.List;

public class TransactionHistoryAdapter extends RecyclerView.Adapter<TransactionHistoryAdapter.viewHolder> {

    private List<TransactionHistoryOverview> dataList;
    private Context context;

    public TransactionHistoryAdapter(Context context, List<TransactionHistoryOverview> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView tvAmount;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            tvAmount = itemView.findViewById(R.id.tvamount);

        }
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.sample_transaction_history, parent,false);
        return new TransactionHistoryAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.tvAmount.setText(dataList.get(position).getAmount());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
