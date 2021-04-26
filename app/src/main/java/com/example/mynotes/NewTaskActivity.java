package com.example.mynotes;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Экран редактирования задачи.
 */
public class NewTaskActivity extends AppCompatActivity {
  Task task;
  EditText title;
  EditText text;
  EditText dateComplete;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_new_task);
    task = (Task) getIntent().getSerializableExtra("TASK");
    if (task == null) {
      task = new Task();
    } else {
      title = findViewById(R.id.title);
      text = findViewById(R.id.text);
      dateComplete = findViewById(R.id.dateComplete);
      title.setText(task.getTitle());
      text.setText(task.getText());
    }
    Spinner spinner = findViewById(R.id.spinner);
    ArrayList<String> arr = new ArrayList<>();
    for (ListTask listT : MainActivity.listTasks) {
      arr.add(listT.title);
    }
    ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
            R.layout.support_simple_spinner_dropdown_item, arr);
    spinner.setAdapter(adapter);
  }

  public void save(View view) {

  }

  Calendar dateAndTime = Calendar.getInstance();

  private void setInitialDateTime() {
    TextView currentDateTime = (TextView) findViewById(R.id.textView2);
    currentDateTime.setText(DateUtils.formatDateTime(this,
            dateAndTime.getTimeInMillis(),
            DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR
                    | DateUtils.FORMAT_SHOW_TIME));
  }

  /**
   * Диалог выбора даты.
   * @param view view.
   */
  public void showDialogDate(View view) {
    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
      public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        dateAndTime.set(Calendar.YEAR, year);
        dateAndTime.set(Calendar.MONTH, monthOfYear);
        dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        setInitialDateTime();
      }
    };
    new DatePickerDialog(this, d,
            dateAndTime.get(Calendar.YEAR),
            dateAndTime.get(Calendar.MONTH),
            dateAndTime.get(Calendar.DAY_OF_MONTH))
            .show();
  }
}