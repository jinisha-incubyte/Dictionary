package com.dictionary;

public class DictionaryController {

  private final DictionaryService dictionaryService;

  public DictionaryController(DictionaryService dictionaryService) {
    this.dictionaryService=dictionaryService;
  }

  public void save(Dictionary word) {
    throw new UnsupportedOperationException();
  }
}
