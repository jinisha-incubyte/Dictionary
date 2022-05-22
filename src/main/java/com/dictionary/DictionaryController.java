package com.dictionary;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

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
}
