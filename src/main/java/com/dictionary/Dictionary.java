package com.dictionary;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Dictionary {

  @Id private String word;

  public void setWord(String word) {
    this.word = word;
  }

  public String getWord() {
    return word;
  }
}
