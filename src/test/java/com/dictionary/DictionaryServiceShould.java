package com.dictionary;

import static org.mockito.ArgumentMatchers.anyString;
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

  @BeforeEach
  void setUp() {
    dictionaryService = new DictionaryService(dictionaryRepository);

  }

  @Test
  void invoke_DictionaryRepository_save() {
    Dictionary word = new Dictionary();

    Dictionary dictionary = dictionaryService.save(word);

    verify(dictionaryRepository).save(word);
  }

}
