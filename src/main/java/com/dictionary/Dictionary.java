package com.dictionary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Dictionary {

  @Id
  private String word;

  public void setWord(String word) {
    this.word = word;
  }

  public String getWord() {
    return word;
  }


}
