package com.dictionary;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Words {

  @Id
  private String word;

  public void setWord(String word) {
    this.word = word;
  }

  public String getWord() {
    return word;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Words words = (Words) o;
    return Objects.equals(word, words.word);
  }

  @Override
  public int hashCode() {
    return Objects.hash(word);
  }
}
