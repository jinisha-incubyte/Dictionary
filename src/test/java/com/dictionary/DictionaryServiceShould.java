package com.dictionary;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
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
  void invoke_DictionaryRepository_deleteWord_and_return_true_for_existing_word() {
    List<Words> words = new ArrayList<>();
    words.add(word);
    when(dictionaryService.getAllWords()).thenReturn(words);
    Boolean isDeletedExistingWord = dictionaryService.deleteWord("word1");
    assertTrue(isDeletedExistingWord);
    verify(dictionaryRepository).delete(word);
  }

  @Test
  void return_false_for_non_existing_word_while_calling_delete() {
    List<Words> words = new ArrayList<>();
    words.add(word);
    when(dictionaryService.getAllWords()).thenReturn(words);
    Boolean isDeletedExistingWord = dictionaryService.deleteWord("word10");
    assertFalse(isDeletedExistingWord);
  }

  @Test
  void invoke_DictionaryRepository_to_update_an_existing_word_and_return_true_for_not_already_existing_word() {
    List<Words> words = new ArrayList<>();
    words.add(word);
    when(dictionaryService.getAllWords()).thenReturn(words);
    Boolean result = dictionaryService.updateWord("word1", "word8");
    assertTrue(result);
    verify(dictionaryRepository).updateWord("word1", "word8");
  }

  @Test
  void return_false_for_already_existing_word_while_calling_update() {
    List<Words> words = new ArrayList<>();
    words.add(word);
    Words word2 = new Words();
    word2.setWord("word2");
    words.add(word2);
    when(dictionaryService.getAllWords()).thenReturn(words);
    Boolean result = dictionaryService.updateWord("word1", "word2");
    assertFalse(result);
  }
}
