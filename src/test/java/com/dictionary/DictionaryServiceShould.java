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
  Dictionary word;

  @BeforeEach
  void setUp() {
    word = new Dictionary();
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

}
