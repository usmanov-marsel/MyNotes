package com.example.mynotes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/**
 * Главный экран.
 */
public class MainActivity extends AppCompatActivity {

  TitleListDialogFragment myDialogFragment;
  FragmentManager manager;
  static ArrayList<ListTask> listTasks = new ArrayList<>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    RecyclerView recyclerView = findViewById(R.id.recyclerView);
    ListTask listT = new ListTask();
    listT.setTitle("Учеба");
    listTasks.add(listT);
    ListAdapter adapter = new ListAdapter(this, listTasks);
    recyclerView.setAdapter(adapter);
    recyclerView.invalidate();
  }

  public void newTask(View view) {
    Intent intent = new Intent(this, NewTaskActivity.class);
    startActivity(intent);
  }

  public void newList(View view) {
    Log.d("Main", "click NewList");
    FragmentManager manager = getSupportFragmentManager();
    TitleListDialogFragment myDialogFragment = new TitleListDialogFragment();
    Log.d("Main", "create Fragment");
    myDialogFragment.show(manager, "DialogTitleList");
    Log.d("Main", "show Fragment");
  }
}