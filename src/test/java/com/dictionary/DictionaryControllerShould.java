package com.dictionary;

import io.micronaut.http.HttpResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DictionaryControllerShould {

  @Mock DictionaryService dictionaryService;
  private DictionaryController dictionaryController;

  @BeforeEach
  void setUp() {
    dictionaryController = new DictionaryController(dictionaryService);
  }

  @Test
  void invoke_dictionaryService_save() {
    Dictionary word = new Dictionary();
    word.setWord(anyString());
    HttpResponse<Dictionary> dictionary = dictionaryController.save(word);
    verify(dictionaryService).save(word);
  }

  @Test
  void invoke_dictionaryService_toGetAllWords() {
    Iterable<Dictionary> words = dictionaryController.getAllWords();
    verify(dictionaryService).getAllWords();
  }

  @Test
  void invoke_dictionaryService_to_delete_a_word() {
    HttpResponse<Void> deletedWord = dictionaryController.deleteWord("word1");
    verify(dictionaryService).deleteWord("word1");
  }

  @Test
  void invoke_dictionaryService_to_update_a_word() {
    Dictionary actualWord = new Dictionary();
    actualWord.setWord("word1");
    dictionaryController.updateWord(actualWord, "word8");
    verify(dictionaryService).updateWord(actualWord, "word8");
  }
}
