package com.dictionary;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DictionaryServiceShould {

  private DictionaryService dictionaryService;
  @Mock
  DictionaryRepository dictionaryRepository;
  Words word;

  @BeforeEach
  void setUp() {
    word = new Words();
    word.setWord("word1");
    dictionaryService = new DictionaryService(dictionaryRepository);

  }

  @Test
  void invoke_DictionaryRepository_save() {

    dictionaryService.save(word);

    verify(dictionaryRepository).save(word);
  }

  @Test
  void invoke_DictionaryRepository_getAllWords() {

   dictionaryService.getAllWords();

    verify(dictionaryRepository).findAll();
  }

  @Test
  void invoke_DictionaryRepository_deleteWord() {

    dictionaryService.deleteWord("word1");

    verify(dictionaryRepository).delete(word);
  }

  @Test
  void invoke_DictionaryRepository_toupdate_an_existing_word() {
    dictionaryService.updateWord("word1", "word8");
    verify(dictionaryRepository).updateWord("word1", "word8");
  }

}
