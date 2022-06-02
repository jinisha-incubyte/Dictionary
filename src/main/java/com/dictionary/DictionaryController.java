package com.dictionary;

import io.micronaut.http.HttpResponse;
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
  public HttpResponse<Dictionary> save(@Body Dictionary word) {
    dictionaryService.save(word);
    return HttpResponse.created(word);
  }

  @Get
  public Iterable<Dictionary> getAllWords() {
    return dictionaryService.getAllWords();
  }

  @Delete("/{word}")
  public HttpResponse<Void> deleteWord(String word) {
    dictionaryService.deleteWord(word);
    return HttpResponse.noContent();
  }

  @Put("/{actualWord}")
  public HttpResponse<Dictionary> updateWord(@Body Dictionary updatedWord, String actualWord) {
    dictionaryService.updateWord(updatedWord, actualWord);
    return HttpResponse.created(updatedWord);
  }
}
