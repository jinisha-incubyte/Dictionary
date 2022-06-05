package com.dictionary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DictionaryServiceShould {

  private DictionaryService dictionaryService;
  @Mock DictionaryRepository dictionaryRepository;
  Dictionary word;

  @BeforeEach
  void setUp() {
    word = new Dictionary();
    word.setWord("word1");
    dictionaryService = new DictionaryService(dictionaryRepository);
  }

  @Test
  void invoke_DictionaryRepository_save() {
    Dictionary dictionary = dictionaryService.save(word);
    verify(dictionaryRepository).save(word);
  }

  @Test
  void invoke_DictionaryRepository_getAllWords() {
    Iterable<Dictionary> words = dictionaryService.getAllWords();
    verify(dictionaryRepository).findAll();
  }

  @Test
  void invoke_DictionaryRepository_deleteWord() {
    dictionaryService.deleteWord("word1");
    verify(dictionaryRepository).deleteById("word1");
  }

  @Test
  void invoke_DictionaryRepository_to_update_an_existing_word() {
    Dictionary actualWord = new Dictionary();
    actualWord.setWord("word1");
    dictionaryService.updateWord(actualWord, "word8");
    verify(dictionaryRepository).updateWord(actualWord.getWord(), "word8");
  }
}
