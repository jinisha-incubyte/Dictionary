package com.dictionary;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;

@Controller("/dictionary")
public class DictionaryController {

  private final DictionaryService dictionaryService;

  public DictionaryController(DictionaryService dictionaryService) {
    this.dictionaryService = dictionaryService;
  }

  @Post
  public Dictionary save(@Body Dictionary word) {
    return dictionaryService.save(word);
  }

  @Get
  public Iterable<Dictionary> getAllWords() {
    return dictionaryService.getAllWords();
  }

  @Delete
  //Return value is must for controller
  public Dictionary deleteWord(@Body Dictionary word) {
    dictionaryService.deleteWord(word);
    return word;
  }

  @Put("/{updatedWord}")
  public Dictionary updateWord(@Body Dictionary actualWord, String updatedWord) {
    dictionaryService.updateWord(actualWord, updatedWord);
    Dictionary dictionary = new Dictionary();
    dictionary.setWord(updatedWord);
    return dictionary;
  }
}
