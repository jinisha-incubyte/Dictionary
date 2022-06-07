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

  public Boolean deleteWord(String word) {
    Words wordTobeDeleted = new Words();
    wordTobeDeleted.setWord(word);
    List<Words> words = getAllWords();
    if (words.contains(wordTobeDeleted)) {
      dictionaryRepository.delete(wordTobeDeleted);
      return true;
    }
    return false;
  }

  public Boolean updateWord(String actualWord, String updatedWord) {
    List<Words> words = getAllWords();
    Words newWord = new Words();
    newWord.setWord(updatedWord);
    if (words.contains(newWord)) {
      return false;
    }
    dictionaryRepository.updateWord(actualWord, updatedWord);
    return true;
  }
}