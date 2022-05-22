package com.dictionary;

import jakarta.inject.Singleton;

@Singleton
public class DictionaryService {

  private final DictionaryRepository dictionaryRepository;

  public DictionaryService(DictionaryRepository dictionaryRepository) {
    this.dictionaryRepository=dictionaryRepository;
  }

  public void save(Dictionary word) {
    throw new UnsupportedOperationException();
  }
}
