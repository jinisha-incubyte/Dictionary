package com.dictionary;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

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
    Dictionary word = new Dictionary();
    word.setWord(anyString());

    dictionaryController.save(word);

    verify(dictionaryService).save(word);
  }

}
