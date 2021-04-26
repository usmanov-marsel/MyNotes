package com.example.mynotes;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

/**
 * Диалог для создания названия нового списка задач.
 */
public class TitleListDialogFragment extends DialogFragment {
  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    LayoutInflater li = requireActivity().getLayoutInflater();
    View dialogView = li.inflate(R.layout.dialog, null);
    final EditText input = (EditText) dialogView.findViewById(R.id.editNewList);
    builder.setView(dialogView)
            .setCancelable(false)
            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                ListTask listT = new ListTask();
                listT.title = input.getText().toString();
                MainActivity.listTasks.add(listT);
                if (input.getText().toString().equals("")) {
                  Log.d("Dialog", "Empty!");
                } else {
                  Log.d("Dialog", "Not Empty!");
                }
              }
            })
            .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
              }
            });
    return builder.create();
  }
}
