package com.dictionary;

import jakarta.inject.Singleton;

@Singleton
public class DictionaryService {

  private final DictionaryRepository dictionaryRepository;

  public DictionaryService(DictionaryRepository dictionaryRepository) {
    this.dictionaryRepository = dictionaryRepository;
  }

  public Dictionary save(Dictionary word) {
    return dictionaryRepository.save(word);
  }
}
