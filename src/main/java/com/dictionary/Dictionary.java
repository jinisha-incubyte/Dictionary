package com.dictionary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Dictionary {

  @Id
  @GeneratedValue
  private Long id;
  private String word;

  public void setWord(String word) {
    this.word = word;
  }

  public String getWord() {
    return word;
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
