package com.dictionary;

import jakarta.inject.Singleton;
import java.util.Optional;

@Singleton
public class DictionaryService {

  private final DictionaryRepository dictionaryRepository;

  public DictionaryService(DictionaryRepository dictionaryRepository) {
    this.dictionaryRepository = dictionaryRepository;
  }

  public Dictionary save(Dictionary word) {
    return dictionaryRepository.save(word);
  }

  public Iterable<Dictionary> getAllWords() {
    return dictionaryRepository.findAll();
  }

  public void deleteWord(Dictionary word) {
      dictionaryRepository.delete(word);
  }
}
