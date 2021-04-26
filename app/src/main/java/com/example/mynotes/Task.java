package com.example.mynotes;

import java.util.ArrayList;
import java.util.Date;

/**
 * Задача.
 */
public class Task {
  String title;
  String text;
  Date dateComplete;
  Date dateRemind;
  Date dateCreate;
  boolean isComplete = false;
  String image;
  ArrayList<String> steps;

  public String getTitle() {
    return title;
  }

  public String getText() {
    return text;
  }

  public Date getDateComplete() {
    return dateComplete;
  }

  public Date getDateRemind() {
    return dateRemind;
  }

  public Date getDateCreate() {
    return dateCreate;
  }

  public ArrayList<String> getSteps() {
    return steps;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setText(String text) {
    this.text = text;
  }

}
