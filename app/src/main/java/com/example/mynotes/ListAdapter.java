package com.example.mynotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/**
 * Адаптер для RecyclerView.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

  private final LayoutInflater inflater;
  private final List<ListTask> listTasks;

  ListAdapter(Context context, List<ListTask> listTasks) {
    this.listTasks = listTasks;
    this.inflater = LayoutInflater.from(context);
  }

  @NonNull
  @Override
  public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = inflater.inflate(R.layout.list_item, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(ListAdapter.ViewHolder holder, int position) {
    ListTask listT = listTasks.get(position);
    String text = ++position + ". " + listT.getTitle();
    holder.titleView.setText(text);
  }

  @Override
  public int getItemCount() {
    return listTasks.size();
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {
    final TextView titleView;

    ViewHolder(View view) {
      super(view);
      titleView = (TextView) view.findViewById(R.id.titleListT);
    }
  }
}
