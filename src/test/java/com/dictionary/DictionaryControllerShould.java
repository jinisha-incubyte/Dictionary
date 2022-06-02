package com.dictionary;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;


import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DictionaryControllerShould {

  @Mock
  DictionaryService dictionaryService;
  private DictionaryController dictionaryController;

  @BeforeEach
  void setUp() {
    dictionaryController = new DictionaryController(dictionaryService);
  }

  @Test
  void invoke_dictionaryService_save() {
    Words word = new Words();
    word.setWord(anyString());
    dictionaryController.save(word);
    verify(dictionaryService).save(word);
  }


  @Test
  void invoke_dictionaryService_toGetAllWords() {
    Response<List<Words>> words = dictionaryController.getAllWords();

    verify(dictionaryService).getAllWords();
  }

  @Test
  void invoke_dictionaryService_to_delete_a_word() {

    Response<Boolean> deletedWord = dictionaryController.deleteWord("word1");

    verify(dictionaryService).deleteWord("word1");
  }

  @Test
  void invoke_dictionaryService_to_update_a_word() {


    dictionaryController.updateWord("word1", "word8");

    verify(dictionaryService).updateWord("word1", "word8");
  }

}
