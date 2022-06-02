package com.dictionary;

import jakarta.inject.Singleton;
import java.util.List;

@Singleton
public class DictionaryService {

  private final DictionaryRepository dictionaryRepository;

  public DictionaryService(DictionaryRepository dictionaryRepository) {
    this.dictionaryRepository = dictionaryRepository;
  }

  public Words save(Words word) {
    return dictionaryRepository.save(word);
  }

  public List<Words> getAllWords() {
    return dictionaryRepository.findAll();
  }

  public void deleteWord(String word) {
    Words wordTobeDeleted=new Words();
    wordTobeDeleted.setWord(word);
      dictionaryRepository.delete(wordTobeDeleted);
  }

  public void updateWord(String actualWord, String updatedWord) {
      dictionaryRepository.updateWord(actualWord,updatedWord);
  }
}
